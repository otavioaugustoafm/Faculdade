//A saída está errada, não consegui fazer printar na ordem que queria

#include <stdio.h>
#include <stdlib.h>

typedef struct Celula {
    int elemento;
    struct Celula* prox;
} Celula;

typedef struct {
    Celula* topo;
} Pilha;

void pilhaConstrutor(Pilha* pilha) {
    pilha->topo = NULL;
}

Celula* celulaConstrutor(int elemento) {
    Celula* celula = (Celula*)malloc(sizeof(Celula));
    if (celula != NULL) {
        celula->elemento = elemento;
        celula->prox = NULL;
    }
    return celula;
}

void push(Pilha* pilha, int elemento) {
    Celula* celula = celulaConstrutor(elemento);
    celula->prox = pilha->topo;
    pilha->topo = celula;
}

void inserirBase(Pilha* pilha, int elemento) {
    if (pilha->topo == NULL) {
        push(pilha, elemento);
    } else {
        Celula* tmp = pilha->topo;
        while (tmp->prox != NULL) {
            tmp = tmp->prox;
        }
        Celula* celula = celulaConstrutor(elemento);
        tmp->prox = celula;
    }
}

int pop(Pilha* pilha) {
    if (pilha->topo == NULL) return -1;
    int elemento = pilha->topo->elemento;
    Celula* tmp = pilha->topo;
    pilha->topo = pilha->topo->prox;
    free(tmp);
    return elemento;
}

void liberarPilha(Pilha* pilha) {
    while (pilha->topo != NULL) {
        pop(pilha);
    }
}

void mostrar(Pilha* pilha) {
    Celula* tmp = pilha->topo;
    int first = 1;
    while (tmp != NULL) {
        if (!first) {
            printf(", ");
        }
        printf("%d", tmp->elemento);
        first = 0;
        tmp = tmp->prox;
    }
    printf("\n");
}

Pilha descarte(Pilha* pilha) {
    Pilha pilha_descarte;
    pilhaConstrutor(&pilha_descarte);
    while (pilha->topo != NULL && pilha->topo->prox != NULL) {
        int cartaDescarte = pop(pilha);
        push(&pilha_descarte, cartaDescarte);
        int cartaMover = pop(pilha);
        inserirBase(pilha, cartaMover);
    }
    return pilha_descarte;
}

int main() {
    Pilha pilha;
    pilhaConstrutor(&pilha);

    int n;
    while (1) {
        scanf("%d", &n);
        if (n == 0) break;

        // Preencher a pilha com cartas em ordem decrescente
        for (int i = n; i >= 1; i--) {
            push(&pilha, i);
        }

        Pilha pilha_descarte = descarte(&pilha);

        printf("Discarded cards: ");
        mostrar(&pilha_descarte);

        printf("Remaining card: ");
        mostrar(&pilha);

        liberarPilha(&pilha_descarte);
        liberarPilha(&pilha);
    }

    return 0;
}
