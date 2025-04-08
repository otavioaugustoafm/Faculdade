#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct Arvore {
    char especie[31];
    struct Arvore* prox;
    struct Arvore* ant;
} Arvore;

typedef struct Lista {
    struct Arvore* primeiro;
    struct Arvore* ultimo;
    int n_elementos;
} Lista;

void construtorArvore(Arvore* arvore) {
    strcpy(arvore->especie, " ");
    arvore->prox = NULL;
    arvore->ant = NULL;
}

void construtorLista(Lista* lista) {
    lista->primeiro = NULL;
    lista->ultimo = NULL;
    lista->n_elementos = 0;
}

void inserirFim(Lista* lista, char especie[]) {
    Arvore* arvore = (Arvore*)malloc(sizeof(Arvore));
    construtorArvore(arvore);
    strcpy(arvore->especie, especie);
    if(lista->primeiro == NULL) {
        lista->primeiro = arvore;
        lista->ultimo = arvore;
    } else {
        Arvore* tmp = lista->ultimo;
        lista->ultimo = arvore;
        tmp->prox = arvore;
        arvore->ant = tmp; 
    }
    lista->n_elementos++;
}

void inserirInicio(Lista* lista, char especie[]){
    Arvore* arvore = (Arvore*)malloc(sizeof(Arvore));
    construtorArvore(arvore);
    strcpy(arvore->especie, especie);
    if(lista->primeiro == NULL) {
        lista->primeiro = arvore;
        lista->ultimo = arvore; 
    } else {
        Arvore* tmp = lista->primeiro;
        lista->primeiro = arvore;
        arvore->prox = tmp;
        tmp->ant = arvore;   
    }
    lista->n_elementos++;
}

void removerFim(Lista* lista) {
    if (lista->ultimo == NULL) { 
        printf("A lista já está vazia.\n");
        return;
    }
    if(lista->primeiro == lista->ultimo) {
        lista->primeiro = NULL;
        lista->ultimo = NULL;
    } else {
        Arvore* tmp = lista->ultimo;
        lista->ultimo = lista->ultimo->ant;
        lista->ultimo->prox = NULL;
        free(tmp);
    }
    lista->n_elementos--;
}

void removerInicio(Lista* lista) {
    if(lista->primeiro == NULL) {
        printf("Lista vazia\n");
        return;
    }
    if(lista->primeiro == lista->ultimo) {
        lista->ultimo = NULL;
        lista->primeiro = NULL;
    } else {
        Arvore* tmp = lista->primeiro;
        lista->primeiro = lista->primeiro->prox;
        lista->primeiro->ant = NULL;
        free(tmp);
    }
    lista->n_elementos--;
}



void mostrar(Lista* lista) {
    Arvore* ref = lista->primeiro;
    if(lista->primeiro == NULL) {
        printf("Lista vazia\n");
        return;
    }
    printf("A lista esta assim: \n");
    for(int i = 0; i < lista->n_elementos; i++) {
        printf("%s | ", ref->especie);
        if(ref->prox == NULL) {
            break;
        }
        ref = ref->prox;
    }
    printf("\n");
}

void menu() {
    printf("=====Vamos trabalhar com uma Lista Flexivel=====\n1 - Adicionar elemento no fim da lista\n2 - Adicionar elemento no inicio da lista\n3 - Remover elemento no fim da lista\n4 - Remover elemento no inicio da lista\n6 - Mostrar\n0 - Sair\nQual opcao deseja?\n");
}

int main() {
    Lista lista;
    construtorLista(&lista);
    int op = -1;
    while(op != 0) {
        menu();
        scanf("%d", &op);
        getchar();
        switch(op) {
            case 1: {
                char string[31];
                printf("Qual a especie? \n");
                fgets(string, 31, stdin);
                string[strcspn(string, "\n")] = '\0';
                inserirFim(&lista, string);
                break;
            }
            case 2: {
                char string[31];
                printf("Qual a especie? \n");
                fgets(string, 31, stdin);
                string[strcspn(string, "\n")] = '\0';
                inserirInicio(&lista, string);
                break;
            }
            case 3: {
                removerFim(&lista);
                break;
            }
            case 4: {
                removerInicio(&lista);
                break;
            }
            case 6: {
                mostrar(&lista);
                break;
            }
        }
    }
}