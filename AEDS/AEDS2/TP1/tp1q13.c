#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void aleatorio(char frase[1000], int tam, int i, char a, char b) {
    if (i >= tam) {
        printf("%s\n", frase);
        return;
    }
    if(frase[i] == a) {
        frase[i] = b;
    } 
    aleatorio(frase,tam,i+1, a, b);
}

int main() {
    char frase[1000];
    srand(4);
    while(1) {
        char a = rand() % 26 + 'a';
        char b = rand() % 26 + 'a';
        fgets(frase, 1000, stdin);
        frase[strcspn(frase, "\n")] = '\0';
        if(strcmp(frase, "FIM") == 0) {
            break;
        } 
        aleatorio(frase, strlen(frase), 0, a, b);
    }
}