#include <stdio.h>
#include <stdbool.h>
#include <string.h>

bool palindromo(char frase[100], int tam, int i, bool resp) {
    if(i >= tam) {
        return resp;
    } else {
        if(frase[i] == frase[tam]) {
            return palindromo(frase, tam - 1, i + 1, resp);
        } else {
            resp = false;
            return resp;
        }
    }
}

int main() {
    while(1) {
        char frase[100];
        fgets(frase,100,stdin);
        frase[strcspn(frase,"\n")] = '\0';
        bool resp = true;
        if(strcmp(frase, "FIM") == 0) {
            break;
        } else {
            resp = palindromo(frase, strlen(frase) - 1, 0, resp);
            if(resp == true) {
                printf("SIM\n");
            } else {
                printf("NAO\n");
            }
        }
    }
}
