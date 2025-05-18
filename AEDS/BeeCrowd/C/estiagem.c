#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int qnt_pessoas;
    int qnt_consumo;
} Imovel;

typedef struct Cidade{
    int numero;
    struct Cidade* prox;
    Imovel** imovel;
} Cidade;

typedef struct {
    Cidade* primeiro;
    Cidade* ultimo;
} Lista;

void construtorLista(Lista* lista) {
    lista->primeiro = NULL;
    lista->ultimo = NULL;
}

void construtorCidade(Cidade* cidade) {
    cidade->numero = 0;
    cidade->prox = NULL;
    cidade->imovel = NULL;
}

void construtorImovel(Imovel* imovel) {
    imovel->qnt_pessoas = 0;
    imovel->qnt_consumo = 0;
}

void inserirFim(Lista* lista, int qnt_imoveis) {
    Cidade* cidade = (Cidade*) malloc(sizeof(Cidade));
    construtorCidade(cidade);
    if(lista->primeiro == NULL) {
        lista->primeiro = cidade;
        lista->ultimo = cidade;
    } else {
        Cidade* tmp = lista->ultimo;
        tmp->prox = cidade;
        lista->ultimo = cidade;
    }
    cidade->imovel = (Imovel**) malloc (sizeof(Imovel*) * qnt_imoveis);
    for(int i = 0; i < qnt_imoveis; i++) {
        cidade->imovel[i] = (Imovel*) malloc (sizeof(Imovel));
        printf("Qnt_pessoas");
        scanf("%d", &cidade->imovel[i]->qnt_pessoas);
        printf("Qnt_consumo");
        scanf("%d", &cidade->imovel[i]->qnt_consumo);
    }   
}

int main () {
    Lista lista;
    construtorLista(&lista);
    int qnt_imoveis = 0;
    while(1) {
        printf("Qnt_imoveis");
        scanf("%d", &qnt_imoveis);
        getchar();
        if(qnt_imoveis == 0) {
            break;
        }
        inserirFim(&lista, qnt_imoveis);        
    }
}