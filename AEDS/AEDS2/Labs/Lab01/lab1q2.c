#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

void letrasMaiusculas(char frase[], char fim[], int cont) {
    fgets(frase, 100, stdin);
    frase[strcspn(frase, "\n")] = '\0';
    if(strcmp(frase, fim) == 0) {
        return;
    } else {
        cont = 0;
        for(int i = 0; i < strlen(frase); i++) {
                if(isupper(frase[i])) {
                    cont++;
                }
            }
            printf("%d\n", cont);
        letrasMaiusculas(frase, fim, cont);
    }
}

int main() {
    char frase[100] = "Início";
    char fim[] = "FIM";
    int cont = 0;
    letrasMaiusculas(frase, fim, cont);
}
