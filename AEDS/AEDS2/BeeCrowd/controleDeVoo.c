//Ta invertendo alguns avioes na fila de pouso nessa caralha

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Aviao {
    char pos[4];
    struct Aviao* prox;
} Aviao;

typedef struct Fila {   
    Aviao* ultimo;
    Aviao* primeiro;
} Fila;

Aviao* construtorAviao(char posicao[4]) {
    Aviao* aviao = (Aviao*)malloc(sizeof(Aviao));
    aviao->prox = NULL;
    strcpy(aviao->pos, posicao);
    return aviao;
}

void construtorFila(Fila* fila1, Fila* fila2, Fila* fila3, Fila* fila4, Fila* fila5) {
    fila1->primeiro = fila1->ultimo = NULL;
    fila2->primeiro = fila2->ultimo = NULL;
    fila3->primeiro = fila3->ultimo = NULL;
    fila4->primeiro = fila4->ultimo = NULL;
    fila5->primeiro = fila5->ultimo = NULL;
}

void inserir(Fila* lista, Aviao* aviao) {
    if(lista->ultimo == NULL) {
        lista->ultimo = aviao;
        lista->primeiro = aviao;
    } else {
        lista->ultimo->prox = aviao;
        lista->ultimo = aviao;
    }
    aviao->prox = NULL;
}

void imprimirFila(Fila* fila) {
    Aviao* atual = fila->primeiro;
    while (atual != NULL) {
        printf("%s ", atual->pos);
        atual = atual->prox;
    }
    printf("\n");
}

Aviao* removerPrimeiro(Fila* fila) {
    if (fila->primeiro == NULL) return NULL;
    
    Aviao* aviao = fila->primeiro;
    fila->primeiro = aviao->prox;
    
    if (fila->primeiro == NULL) {
        fila->ultimo = NULL;
    }
    
    aviao->prox = NULL;
    return aviao;
}

void juntarFilas(Fila* oeste, Fila* norte, Fila* sul, Fila* leste, Fila* resp) {
    int contador = 0;
    
    while (oeste->primeiro || norte->primeiro || sul->primeiro || leste->primeiro) {
        switch (contador % 4) {
            case 0:
                if (oeste->primeiro) {
                    inserir(resp, removerPrimeiro(oeste));
                }
                break;
            case 1:
                if (norte->primeiro) {
                    inserir(resp, removerPrimeiro(norte));
                }
                break;
            case 2:
                if (sul->primeiro) {
                    inserir(resp, removerPrimeiro(sul));
                }
                break;
            case 3:
                if (leste->primeiro) {
                    inserir(resp, removerPrimeiro(leste));
                }
                break;
        }
        contador++;
    }
}

int main() {
    Fila oeste, norte, sul, leste, resp;
    Fila* filaAtual;
    construtorFila(&oeste,&norte,&sul,&leste,&resp);
    char n[4] = " ";
    while (1) {
        scanf("%s", n);
        if (strcmp(n, "-1") == 0) {
            filaAtual = &oeste;
        } else if (strcmp(n, "-2") == 0) {
            filaAtual = &norte;
        } else if (strcmp(n, "-3") == 0) {
            filaAtual = &sul;
        } else if (strcmp(n, "-4") == 0) {
            filaAtual = &leste;
        } else if (strcmp(n, "0") == 0) {
            break;
        } else if (filaAtual != NULL) {
            Aviao* aviao = construtorAviao(n);
            inserir(filaAtual, aviao);
        } else {
            printf("Direção inválida\n");
        }
    }  
    juntarFilas(&oeste, &norte, &sul, &leste, &resp);
    imprimirFila(&resp);
}