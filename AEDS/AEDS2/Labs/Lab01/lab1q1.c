#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

int main() {
    char frase[100] = "Inicio";
    char fim[] = {"FIM"};
    int cont = 0;
    while(1) {
        fgets(frase, 100, stdin);
        frase[strcspn(frase, "\n")] = '\0';
        if(strcmp(frase, fim) == 0) {
            break;
        } else {
            cont = 0;
            for(int i = 0; i < strlen(frase); i++) {
                if(isupper(frase[i])) {
                    cont++;
                }
            }
            printf("%d\n", cont);
        }

    }
}