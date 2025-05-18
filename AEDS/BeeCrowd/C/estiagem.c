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
}

int main () {
    Lista lista;
    Cidade cidade;
    construtorLista(&lista);
    int qnt_imoveis = 0;
    while(1) {
        scanf("%d", &qnt_imoveis);
        if(qnt_imoveis == 0) {
            break;
        }
        construtorCidade(&cidade);
        
    }
}