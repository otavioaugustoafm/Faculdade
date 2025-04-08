#include <stdio.h>
#include <stdbool.h>
#include <string.h>

int main() {
    char frase [1000];
    while(1) {
        fgets(frase, 1000, stdin);
        frase[strcspn(frase, "\n")] = '\0';
        if (strcmp(frase, "FIM") == 0) {
            break;
        }
        bool resp = true;
        int tamanho = strlen(frase);
        for (int i = 0; i < tamanho / 2; i++ ) {
            if(frase[i] != frase[tamanho - 1 - i]) {
                resp = false;
                break;
            } 
        }
        if(resp == false) {
            printf("NAO\n");
        } else {
            printf("SIM\n");
        }
    }
}
