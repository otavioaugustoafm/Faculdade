//Não soube enviar na porra do BeeCrowd

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
    FILE *arquivo = fopen("txt/vogaisAlienigenas.txt", "r");
    char vogais[5];
    int cont = 0;

    while(fscanf(arquivo, "%s", vogais) != EOF) {
        cont = 0;
        char frase[200];
        fgetc(arquivo);
        fgets(frase, 200, arquivo);
        frase[strcspn(frase, "\n")] = '\0';
        for(int i = 0; i < strlen(frase); i++) {
            for(int j = 0; j < 5; j++) {
                if(frase[i] == vogais[j]) {
                    cont++;
                }
            }
        }
        printf("%d\n", cont);
    }
    fclose(arquivo);
}