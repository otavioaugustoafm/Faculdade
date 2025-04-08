#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>
#include <time.h>

#define MAX_STRING_LENGTH 1000
#define MAX_ABILITIES 10
#define MAX_LINE 2000

typedef struct {
    int day;
    int month;
    int year;
} Date;

typedef struct {
    int id;
    int generation;
    char name[MAX_STRING_LENGTH];
    char description[MAX_STRING_LENGTH];
    char type1[MAX_STRING_LENGTH];
    char type2[MAX_STRING_LENGTH];
    char abilities[MAX_ABILITIES][MAX_STRING_LENGTH];
    int abilitiesCount;
    double weight;
    double height;
    int captureRate;
    bool isLegendary;
    Date captureDate;
} Pokemon;

typedef struct Cell {
    Pokemon pokemon;
    struct Cell* next;
} Cell;

typedef struct {
    Cell* head;
    Cell* tail;
} List;


char* parseCsvField(char** cursor);

void initList(List* list) {
    Cell* dummy = (Cell*)malloc(sizeof(Cell));
    dummy->next = NULL;
    list->head = dummy;
    list->tail = dummy;
}

void readPokemon(Pokemon* pokemon, char* id) {
    FILE* file = fopen("/tmp/pokemon.csv", "r");
    if (file == NULL) {
        printf("ERROR: File Not Found.\n");
        return;
    }

    char line[MAX_LINE];
    fgets(line, sizeof(line), file); 

    bool found = false;
    while (fgets(line, sizeof(line), file)) {
        char* cursor = line;
        char* currentId = parseCsvField(&cursor);
        
        if (strcmp(currentId, id) == 0) {
            found = true;
            pokemon->id = atoi(currentId);
            pokemon->generation = atoi(parseCsvField(&cursor));
            
            char* name = parseCsvField(&cursor);
            strcpy(pokemon->name, name);
            
            char* desc = parseCsvField(&cursor);
            strcpy(pokemon->description, desc);
            
            char* type1 = parseCsvField(&cursor);
            strcpy(pokemon->type1, type1);
            
            char* type2 = parseCsvField(&cursor);
            strcpy(pokemon->type2, type2);
            
            char* abilities = parseCsvField(&cursor);
            parseAbilities(abilities, pokemon);
            
            pokemon->weight = atof(parseCsvField(&cursor));
            pokemon->height = atof(parseCsvField(&cursor));
            pokemon->captureRate = atoi(parseCsvField(&cursor));
            pokemon->isLegendary = atoi(parseCsvField(&cursor)) > 0;
            
            char* dateStr = parseCsvField(&cursor);
            if (dateStr[0] != '\0') {
                sscanf(dateStr, "%d/%d/%d", 
                    &pokemon->captureDate.day,
                    &pokemon->captureDate.month,
                    &pokemon->captureDate.year);
            }
            break;
        }
        
        while (*cursor != '\0' && *cursor != '\n') cursor++;
    }

    if (!found) {
        printf("Pokémon não encontrado.\n");
    }

    fclose(file);
}

char* parseCsvField(char** cursor) {
    static char field[MAX_STRING_LENGTH];
    int i = 0;
    bool inQuotes = false;
    
    while (**cursor == ' ' || **cursor == '\t') (*cursor)++;
    
    if (**cursor == '"') {
        inQuotes = true;
        (*cursor)++;
    }
    
    while (**cursor != '\0' && **cursor != '\n' &&
           (inQuotes || **cursor != ',')) {
        if (**cursor == '"' && *(*cursor + 1) == '"') {
            field[i++] = '"';
            (*cursor) += 2;
        } else if (**cursor == '"') {
            inQuotes = !inQuotes;
            (*cursor)++;
        } else {
            field[i++] = **cursor;
            (*cursor)++;
        }
    }
    
    if (**cursor == ',') (*cursor)++;
    
    field[i] = '\0';
    trim(field);
    return field;
}

void parseAbilities(char* abilitiesStr, Pokemon* pokemon) {
    removeQuotes(abilitiesStr);
    if (abilitiesStr[0] == '[') abilitiesStr++;
    if (abilitiesStr[strlen(abilitiesStr)-1] == ']') 
        abilitiesStr[strlen(abilitiesStr)-1] = '\0';
    
    pokemon->abilitiesCount = 0;
    char* ability = strtok(abilitiesStr, ",");
    while (ability != NULL && pokemon->abilitiesCount < MAX_ABILITIES) {
        trim(ability);
        strcpy(pokemon->abilities[pokemon->abilitiesCount++], ability);
        ability = strtok(NULL, ",");
    }
}

void insertStart(List* list, Pokemon pokemon) {
    Cell* newCell = (Cell*)malloc(sizeof(Cell));
    newCell->pokemon = pokemon;
    newCell->next = list->head->next;
    list->head->next = newCell;
    if (list->tail == list->head) {
        list->tail = newCell;
    }
}

void insertEnd(List* list, Pokemon pokemon) {
    Cell* newCell = (Cell*)malloc(sizeof(Cell));
    newCell->pokemon = pokemon;
    newCell->next = NULL;
    list->tail->next = newCell;
    list->tail = newCell;
}

void insert(List* list, Pokemon pokemon, int pos) {
    int size = getSize(list);
    if (pos < 0 || pos > size) {
        printf("Erro: Posição inválida\n");
        return;
    }
    
    if (pos == 0) {
        insertStart(list, pokemon);
    } else if (pos == size) {
        insertEnd(list, pokemon);
    } else {
        Cell* current = list->head;
        for (int i = 0; i < pos; i++) {
            current = current->next;
        }
        Cell* newCell = (Cell*)malloc(sizeof(Cell));
        newCell->pokemon = pokemon;
        newCell->next = current->next;
        current->next = newCell;
    }
}

Pokemon removeStart(List* list) {
    Pokemon empty = {0};
    if (list->head->next == NULL) return empty;
    
    Cell* temp = list->head->next;
    Pokemon removed = temp->pokemon;
    list->head->next = temp->next;
    if (list->head->next == NULL) {
        list->tail = list->head;
    }
    free(temp);
    return removed;
}

Pokemon removeEnd(List* list) {
    Pokemon empty = {0};
    if (list->head->next == NULL) return empty;
    
    Cell* current = list->head;
    while (current->next != list->tail) {
        current = current->next;
    }
    
    Pokemon removed = list->tail->pokemon;
    free(list->tail);
    list->tail = current;
    list->tail->next = NULL;
    return removed;
}

Pokemon removePos(List* list, int pos) {
    Pokemon empty = {0};
    int size = getSize(list);
    if (pos < 0 || pos >= size) {
        printf("Erro: Posição inválida\n");
        return empty;
    }
    
    if (pos == 0) return removeStart(list);
    if (pos == size - 1) return removeEnd(list);
    
    Cell* current = list->head;
    for (int i = 0; i < pos; i++) {
        current = current->next;
    }
    
    Cell* temp = current->next;
    Pokemon removed = temp->pokemon;
    current->next = temp->next;
    free(temp);
    return removed;
}

void printPokemon(Pokemon pokemon, int index) {
    printf("[%d] [#%d -> %s: %s - ['%s%s%s'] - [", 
        index, pokemon.id, pokemon.name, pokemon.description,
        pokemon.type1,
        (strlen(pokemon.type2) > 0 ? "', '" : ""),
        (strlen(pokemon.type2) > 0 ? pokemon.type2 : ""));

    for (int i = 0; i < pokemon.abilitiesCount; i++) {
        printf("%s%s", pokemon.abilities[i],
               (i < pokemon.abilitiesCount - 1 ? ", " : ""));
    }

    printf("] - %.1fkg - %.1fm - %d%% - %s - %d gen] - ",
        pokemon.weight, pokemon.height, pokemon.captureRate,
        pokemon.isLegendary ? "true" : "false", pokemon.generation);

    if (pokemon.captureDate.year != 0) {
        printf("%02d/%02d/%04d\n",
            pokemon.captureDate.day,
            pokemon.captureDate.month,
            pokemon.captureDate.year);
    } else {
        printf("N/A\n");
    }
}

void printList(List* list) {
    int index = 0;
    for (Cell* current = list->head->next; current != NULL; current = current->next) {
        printPokemon(current->pokemon, index++);
    }
}

int getSize(List* list) {
    int size = 0;
    for (Cell* current = list->head->next; current != NULL; current = current->next) {
        size++;
    }
    return size;
}

void trim(char* str) {
    char* start = str;
    char* end = str + strlen(str) - 1;
    
    while(isspace((unsigned char)*start)) start++;
    while(end > start && isspace((unsigned char)*end)) end--;
    
    size_t len = (end - start) + 1;
    memmove(str, start, len);
    str[len] = '\0';
}

void removeQuotes(char* str) {
    if (str[0] == '"') {
        memmove(str, str + 1, strlen(str));
    }
    int len = strlen(str);
    if (len > 0 && str[len-1] == '"') {
        str[len-1] = '\0';
    }
}

char* capitalizeFirstLetter(char* str) {
    static char result[MAX_STRING_LENGTH];
    strcpy(result, str);
    if (strlen(result) > 0) {
        result[0] = toupper(result[0]);
    }
    return result;
}

int main() {
    List list;
    initList(&list);
    char input[MAX_STRING_LENGTH];
    
    while (1) {
        fgets(input, sizeof(input), stdin);
        input[strcspn(input, "\n")] = 0;
        
        if (strcmp(input, "FIM") == 0) break;
        
        Pokemon pokemon = {0};
        readPokemon(&pokemon, input);
        insertEnd(&list, pokemon);
    }
    
    fgets(input, sizeof(input), stdin);
    int n = atoi(input);
    
    for (int i = 0; i < n; i++) {
        fgets(input, sizeof(input), stdin);
        input[strcspn(input, "\n")] = 0; 
        
        char command[3];
        strncpy(command, input, 2);
        command[2] = '\0';
        
        if (strcmp(command, "II") == 0) {
            Pokemon pokemon = {0};
            readPokemon(&pokemon, input + 3);
            insertStart(&list, pokemon);
        }
        else if (strcmp(command, "I*") == 0) {
            char* pos = strtok(input + 3, " ");
            char* id = strtok(NULL, " ");
            Pokemon pokemon = {0};
            readPokemon(&pokemon, id);
            insert(&list, pokemon, atoi(pos));
        }
        else if (strcmp(command, "IF") == 0) {
            Pokemon pokemon = {0};
            readPokemon(&pokemon, input + 3);
            insertEnd(&list, pokemon);
        }
        else if (strcmp(command, "RI") == 0) {
            Pokemon removed = removeStart(&list);
            if (removed.id != 0) {
                printf("(R) %s\n", capitalizeFirstLetter(removed.name));
            }
        }
        else if (strcmp(command, "R*") == 0) {
            int pos = atoi(input + 3);
            Pokemon removed = removePos(&list, pos);
            if (removed.id != 0) {
                printf("(R) %s\n", capitalizeFirstLetter(removed.name));
            }
        }
        else if (strcmp(command, "RF") == 0) {
            Pokemon removed = removeEnd(&list);
            if (removed.id != 0) {
                printf("(R) %s\n", capitalizeFirstLetter(removed.name));
            }
        }
    }
    
    printList(&list);
    
    Cell* current = list.head;
    while (current != NULL) {
        Cell* next = current->next;
        free(current);
        current = next;
    }
    
    return 0;
}