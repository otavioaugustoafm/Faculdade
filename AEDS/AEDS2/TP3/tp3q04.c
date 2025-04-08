#include <ctype.h>
#include <locale.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <math.h>

struct types {
  char *type1;
  char *type2;
  int qtd;
} typedef types;

struct pokemon {
  char *id;
  int generation;
  char *name;
  char *description;
  types types;
  char *abilities;
  double weight;
  double height;
  int captureRate;
  int isLegendary;
  char *captureDate;
} typedef pokemon;

struct Pokedex {
  pokemon *pokemon;
  int tamanho;
  int capacidade;
} typedef Pokedex;

struct PokePilha {
  pokemon *pokemon;
  int tamanho;
  int capacidade;
} typedef PokePilha;


#define TAMANHO_FILA 5

struct PokeFilaCircular {
    pokemon pokemon[TAMANHO_FILA + 1];
    int primeiro;
    int ultimo;
    int tamanho; 
} typedef PokeFilaCircular;




int str_len(const char *_Str) {
  int _Len = -1;
  if (_Str) {
    _Len = 0;
    while (*(_Str + _Len)) {
      _Len = _Len + 1;
    }
  } 
  return (_Len);
} 


char *str_substring(const char *_Str, size_t _Start, size_t _End) {
  char *_Sub = NULL;
  size_t _Len_Str = str_len(_Str);
  if (_Start < _Len_Str && _End < _Len_Str && _Start <= _End) {
    size_t _Len = _End - _Start + 1;
    _Sub = (char *)malloc((_Len + 1) * sizeof(char));
    if (_Sub) {
      size_t j = 0;
      for (size_t i = _Start; i <= _End; i = i + 1, j = j + 1) {
        *(_Sub + j) = *(_Str + i);
      } 
      *(_Sub + j) = '\0';
    } 
  } 
  return (_Sub);
} 


char *str_dup(const char *_Str) {
  char *_Dup = NULL;
  size_t _Var = 0;
  if (_Str) {
    _Dup = (char *)malloc(str_len(_Str) + 1 * sizeof(char));
    if (_Dup) {
      while (*(_Str + _Var)) {
        *(_Dup + _Var) = *(_Str + _Var);
        _Var = _Var + 1;
      }
      *(_Dup + _Var) = '\0';
    } 
  } 
  return (_Dup);
} 


char **str_split(char *_Str, const char _Delimiter) {
  char **_Sequence = NULL;
  size_t _Size = 0;
  if (_Str) {
    size_t _Len_Str = str_len(_Str);

    char *_Temp = _Str;
    while (*_Temp) {
      if (*_Temp == _Delimiter) {
        _Size = _Size + 1;
      } 
      _Temp = _Temp + 1;
    } 
    _Size =
        _Size + 1; 

    _Sequence = (char **)malloc(_Size * sizeof(char *));

    if (_Sequence) {
      size_t _Var = 0;
      size_t _Start = 0;
      size_t _End = 0;
      while (_Var < _Size) {
        while (_End < _Len_Str && *(_Str + _End) != _Delimiter) {
          _End++;
        }

        *(_Sequence + _Var) = str_substring(_Str, _Start, _End - 1);

        if (*(_Sequence + _Var) == NULL) {
          *(_Sequence + _Var) = "";
        } 
        _Start = _End + 1;
        _End = _Start;
        _Var++;
      } 
      *(_Sequence + _Var) = NULL;
    } 
  } 
  return (_Sequence);
} 


char *str_trim(char *str) {
  char *end;


  while (isspace((unsigned char)*str))
    str++;

  if (*str == 0) 
    return str;


  end = str + strlen(str) - 1;
  while (end > str && isspace((unsigned char)*end))
    end--;

  *(end + 1) = '\0';

  return str;
}

char *str_replace_c(const char *_Str, const char _OldChar,
                    const char _NewChar) {
  char *_Dest = NULL;
  if (_Str) {
    _Dest = str_dup(_Str);
    size_t _Var = 0;
    while (*(_Dest + _Var)) {
      if (*(_Dest + _Var) == _OldChar) {
        *(_Dest + _Var) = _NewChar;
      } 
      _Var = _Var + 1;
    } 
  } 
  return (_Dest);
} 




char *getId(pokemon *p) { return p->id; }
int getGeneration(pokemon *p) { return p->generation; }
char *getName(pokemon *p) { return p->name; }
char *getDescription(pokemon *p) { return p->description; }
types getTypes(pokemon *p) { return p->types; }
char *getAbilities(pokemon *p) { return p->abilities; }
double getWeight(pokemon *p) { return p->weight; }
double getHeight(pokemon *p) { return p->height; }
int getCaptureRate(pokemon *p) { return p->captureRate; }
int getIsLegendary(pokemon *p) { return p->isLegendary; }
char *getCaptureDate(pokemon *p) { return p->captureDate; }
// Funcoes set
void setId(pokemon *p, char *id) { strcpy(p->id, id); }
void setGeneration(pokemon *p, int generation) { p->generation = generation; }
void setName(pokemon *p, char *name) { strcpy(p->name, str_trim(name)); }
void setDescription(pokemon *p, char *description) {
  strcpy(p->description, str_trim(description));
}
void setTypes(pokemon *p, types types) { p->types = types; }
void setAbilities(pokemon *p, char *abilities) {
  strcpy(p->abilities, abilities);
}
void setWeight(pokemon *p, double weight) { p->weight = weight; }
void setHeight(pokemon *p, double height) { p->height = height; }
void setCaptureRate(pokemon *p, int captureRate) {
  p->captureRate = captureRate;
}
void setIsLegendary(pokemon *p, int isLegendary) {
  p->isLegendary = isLegendary;
}
void setCaptureDate(pokemon *p, char *captureDate) {
  strcpy(p->captureDate, str_trim(captureDate));
}


bool existePokemon(pokemon *p) {
  bool existe = false;

  if (p->id != NULL && p->name != NULL && p->description != NULL &&
      p->types.type1 != NULL && p->abilities != NULL &&
      p->captureDate != NULL) {
    existe = true;
  }
  return existe;
}


Pokedex *alocatePokedex(void) {
  Pokedex *pokedex = (Pokedex *)malloc(sizeof(Pokedex));
  if (pokedex == NULL) {
    printf("Memory allocation error\n");
    exit(1);
  }
  pokedex->tamanho = 1;
  pokedex->pokemon = (pokemon *)malloc(
      1000 * sizeof(pokemon)); 
  if (pokedex->pokemon == NULL) {
    printf("Memory allocation error\n");
    free(pokedex);
    exit(1);
  }
  return pokedex;
}

void addPokemon(Pokedex *p, pokemon *poke) {
  p->pokemon[p->tamanho] = *poke;
  p->tamanho++;
}

void deletePokemon(pokemon *p) {
  if (existePokemon(p) && p != NULL) {
    free(p->id);
    free(p->name);
    free(p->description);
    free(p->types.type1);
    free(p->types.type2);
    free(p->abilities);
    free(p->captureDate);
    free(p);
  }
}

pokemon *alocatePokemon(void) {
  pokemon *p = (pokemon *)malloc(sizeof(pokemon));
  if (p == NULL) {
    printf("Memory allocation error\n");
    return NULL;
  }
  p->id = (char *)calloc(10, sizeof(char));
  p->name = (char *)calloc(50, sizeof(char));
  p->description = (char *)calloc(100, sizeof(char));
  p->types.type1 = (char *)calloc(50, sizeof(char));
  p->types.type2 = (char *)calloc(50, sizeof(char));
  p->captureDate = (char *)calloc(50, sizeof(char));
  p->abilities = (char *)calloc(100, sizeof(char));

  if (p->id == NULL || p->name == NULL || p->description == NULL ||
      p->types.type1 == NULL || p->abilities == NULL ||
      p->captureDate == NULL) {
    printf("Error to allocate memory for pokemon\n");
    free(p); 
    return NULL;
  }

  return p;
}

pokemon *clonePokemon(pokemon *p) {
  pokemon *clone = alocatePokemon();
  if (existePokemon(p) && existePokemon(clone)) {
    setId(clone, getId(p));
    setGeneration(clone, getGeneration(p));
    setName(clone, getName(p));
    setDescription(clone, getDescription(p));
    setTypes(clone, getTypes(p));
    setAbilities(clone, getAbilities(p));
    setWeight(clone, getWeight(p));
    setHeight(clone, getHeight(p));
    setCaptureRate(clone, getCaptureRate(p));
    setIsLegendary(clone, getIsLegendary(p));
    setCaptureDate(clone, getCaptureDate(p));
  } else {
    printf("Error to clone pokemon\n");
  }
  return clone;
}

void formatAbilities(char *abilities, pokemon *p) {
  abilities = str_replace_c(str_trim(abilities), '\"', ' ');
  abilities = str_replace_c(str_trim(abilities), '[', ' ');
  abilities = str_replace_c(str_trim(abilities), ']', ' ');
  abilities = str_replace_c(str_trim(abilities), '\'', ' ');
  abilities = str_trim(abilities);

  char *token = strtok(abilities, ",");

  char formattedAbilities[1024] = "['";

  while (token != NULL) {
    strcat(formattedAbilities, str_trim(token));
    token = strtok(NULL, ",");
    if (token != NULL) {
      strcat(formattedAbilities, "', '");
    }
  }
  strcat(formattedAbilities, "']");

  setAbilities(p, formattedAbilities);
}

void printPokemon(pokemon *p) {
  printf("[#%s -> %s: %s - ", getId(p), getName(p), getDescription(p));
  if (getTypes(p).qtd == 1) {
    printf("['%s'] - ", getTypes(p).type1);
  } else {
    printf("['%s', '%s'] - ", getTypes(p).type1, getTypes(p).type2);
  }
  char *lendario = getIsLegendary(p) ? "true" : "false";
  printf("%s - %.1lfkg - %.1lfm - %d%% - %s - %d gen] - %s\n", getAbilities(p),
         getWeight(p), getHeight(p), getCaptureRate(p),
         getIsLegendary(p) ? "true" : "false", getGeneration(p),
         getCaptureDate(p));
}

void inicializarPokemon(pokemon *p, char *id, char *generation, char *name,
                        char *description, char *type1, char *type2,
                        char *abilities, char *weight, char *height,
                        char *captureRate, char *isLegendary,
                        char *captureDate) {
  if (existePokemon(p)) {
    setId(p, id);
    int gen = atoi(generation);
    setGeneration(p, gen);

    setName(p, name);
    setDescription(p, description);

    strcpy(p->types.type1, str_trim(type1));
    p->types.qtd = 1;
    if (type2 != NULL && type2[0] != '\0') {
      strcpy(p->types.type2, str_trim(type2));
      p->types.qtd = 2;
    } else {
      p->types.type2[0] = '\0';
    }

    formatAbilities(abilities, p);

    if (weight != NULL && weight[0] != '\0') {
      setWeight(p, atof(weight));
    } else {
      setWeight(p, 0.0);
    }
    if (height != NULL && height[0] != '\0') {

      setHeight(p, atof(height));

    } else {
      setHeight(p, 0.0);
    }

    if (captureRate != NULL && captureRate[0] != '\0') {
      setCaptureRate(p, atoi(captureRate));
    } else {
      setCaptureRate(p, 0);
    }

    if (isLegendary != NULL && isLegendary[0] != '\0') {
      setIsLegendary(p, atoi(isLegendary));
    } else {
      setIsLegendary(p, 0);
    }

    if (captureDate != NULL && captureDate[0] != '\0') {
      setCaptureDate(p, captureDate);
    } else {
      setCaptureDate(p, "0");
    }

  } else {
    printf("Error to inicialize pokemon\n");
  }
}

void lerCSV(Pokedex *pokedex, char *filename, char *id_search) {

  FILE *file = fopen(filename, "r");
  if (file == NULL) {
    printf("Error opening file\n");
    return;
  }

  char linha[500];

  fgets(linha, sizeof(linha), file);

  while (fgets(linha, sizeof(linha), file) != NULL) {
    pokemon *poke = alocatePokemon();

    if (poke == NULL) {
      printf("Error to alocate pokemon\n");
      fclose(file);
      return;
    }

    bool dentroLista = false;
    for (int i = 0; i < strlen(linha); ++i) {

      if (!dentroLista && linha[i] == ',') {
        linha[i] = ';';
      } else if (linha[i] == '"') {
        dentroLista = !dentroLista;
      }
      if (linha[i] == '\n') {
        linha[i] = '\0';
      }
    }

    char **args = str_split(linha, ';');

    char id[4] = "";
    for (int i = 0; i < 3; i++) {
      if (linha[i] == ';') {
        break;
      }
      strncat(id, &linha[i], 1);
    }

    inicializarPokemon(poke, id, args[1], args[2], args[3], args[4], args[5],
                       args[6], args[7], args[8], args[9], args[10], args[11]);

    addPokemon(pokedex, poke);
  }
  fclose(file);
}

pokemon *procurarPokemon(Pokedex *pokedex, char *id) {
  for (int i = 0; i < pokedex->tamanho; i++) {
    if (getId(&pokedex->pokemon[i]) != NULL &&
        strcmp(getId(&pokedex->pokemon[i]), id) == 0) {
      return &pokedex->pokemon[i];
    }
  }
  return NULL;
}

PokeFilaCircular* criarPokeFilaCircular() {
    PokeFilaCircular *fila = (PokeFilaCircular *)malloc(sizeof(PokeFilaCircular));
    if (!fila) {
        printf("Memory allocation error\n");
        exit(1);
    }
    fila->primeiro = 0;
    fila->ultimo = 0;
    fila->tamanho = 0; 
    return fila;
}

bool filaCheia(PokeFilaCircular *fila) {
    return fila->tamanho == TAMANHO_FILA;
}

bool filaVazia(PokeFilaCircular *fila) {
    return fila->tamanho == 0;
}

pokemon* desenfileirar(PokeFilaCircular *fila) {
    if (filaVazia(fila)) {
        return NULL;
    }
    pokemon *p = &fila->pokemon[fila->primeiro];
    fila->primeiro = (fila->primeiro + 1) % TAMANHO_FILA;
    fila->tamanho--;
    return p;
}

void enfileirar(PokeFilaCircular *fila, pokemon p) {
    if (filaCheia(fila)) {
        pokemon *removido = desenfileirar(fila);
    }
    fila->pokemon[fila->ultimo] = p;
    fila->ultimo = (fila->ultimo + 1) % TAMANHO_FILA;
    fila->tamanho++;
}

int calcularMediaCaptureRate(PokeFilaCircular *fila) {
  if (filaVazia(fila)) return 0; 
  
  double somaCaptureRate = 0.0;
  for (int i = 0, j = fila->primeiro; i < fila->tamanho; i++, j = (j + 1) % TAMANHO_FILA) {
    somaCaptureRate += fila->pokemon[j].captureRate;
  }
  return (int) round((double) somaCaptureRate / (double) fila->tamanho);
}

void printFila(PokeFilaCircular *fila) {
    if (filaVazia(fila)) {
        printf("Fila vazia.\n");
        return;
    }
    for (int i = 0, j = fila->primeiro; i < fila->tamanho; i++, j = (j + 1) % TAMANHO_FILA) {
        printf("[%d] ", i);
        printPokemon(&fila->pokemon[j]);
    }
}



int main(void) {
  setlocale(LC_CTYPE, "UTF-8");

  Pokedex *pokedex = alocatePokedex();

  char *filename = "/tmp/pokemon.csv";
  lerCSV(pokedex, filename, "1");

  PokeFilaCircular *pokeFila = criarPokeFilaCircular();

  char id[4];
  scanf("%s", id);
  while (strcmp(id, "FIM") != 0 && strcmp(id, "0") != 0) {
    enfileirar(pokeFila, *procurarPokemon(pokedex, id));
    int mediaCaptureRate = calcularMediaCaptureRate(pokeFila);
    printf("Média: %d\n", mediaCaptureRate);
    scanf("%s", id);
  }

  int qtd_operacoes = 0;
  scanf("%d", &qtd_operacoes);
  getchar();

  for (int i = 0; i < qtd_operacoes; i++) {
    char operacao[10];
    scanf("%s", operacao);
    if (strcmp(operacao, "I") == 0) {
      char id[4];
      scanf("%s", id);
      enfileirar(pokeFila, *procurarPokemon(pokedex,id));
      int mediaCaptureRate = calcularMediaCaptureRate(pokeFila);
      printf("Média: %d\n", mediaCaptureRate);
    } else if (strcmp(operacao, "R") == 0) {
      int posicao;
      scanf("%d", &posicao);
      pokemon *poke = desenfileirar(pokeFila);
      printf("(R) %s\n", getName(poke));
      
    }
  }
  printf("\n");
  printFila(pokeFila);

  free(pokeFila->pokemon);

  return 0;
}