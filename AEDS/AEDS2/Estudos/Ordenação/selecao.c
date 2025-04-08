#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>

//Declaracao das estruturas de dados que usaremos para armazenar os alunos

typedef struct {
    int dia;
    int mes;
    int ano;
 } Data;

typedef struct {
    int id;
    Data nasc;
    char nome[100];

} Aluno;

int main() {

    srand(time(NULL)); 

    printf("Aqui vamos ordenar uma colecao de dados de alunos de uma escola. Essa ordenação acontecera da seguinte maneira: \n- Primeiro vamos ordenar pelo ID, que e um numero inteiro.\n- Depois vamos ordenar pelo ano de nascimento\n- Por ultimo vamos ordernar pelo nome do aluno.\n");
        
    int n;
    printf("Quantos alunos voce deseja inserir? ");
    scanf("%d", &n);
    getchar();
    Aluno alunos[n];

    //Preencher os dados dos alunos, sendo o ID e a data de nascimento aleatorios

    for(int i = 0; i < n; i++) {
        printf("Qual o nome do %do aluno?\n", i + 1);
        fgets(alunos[i].nome, 100, stdin);
        alunos[i].nome[strcspn(alunos[i].nome, "\n")] = '\0';
        alunos[i].nasc.dia = (rand() % 30) + 1;
        alunos[i].nasc.mes = (rand() % 11) + 1;
        alunos[i].nasc.ano = (rand() % 21) + 2000;
        alunos[i].id = (rand() % 100000) + 100000;
    }

    //Aqui vamos printar os dados dos alunos inseridos na tela sem estarem ordenados caso
    //o usuario digite "SIM"
    char resp[4];
    printf("Quer ver como ficou o cadastro dos usuarios sem a ordenacao?\nDigite SIM para ver ou NAO para nao ver\n");
    fgets(resp, 4, stdin);
    getchar();
    resp[strcspn(resp, "\n")] = '\0';
    if(strcmp(resp, "SIM") == 0) {
        for(int i = 0; i < n; i++) {
            printf("%do aluno:\n- ID: %d\n- Nome: %s\n- Data de nascimento: %d/%d/%d\n\n", i + 1, alunos[i].id, alunos[i].nome,alunos[i].nasc.dia, alunos[i].nasc.mes, alunos[i].nasc.ano);
        }
    }

    //Aqui e criado um arquivo chamado AlunosSemOrdenacao com as informacoes dos alunos nao ordenadas

    FILE *arquivo = fopen("AlunosSemOrdenacao.txt", "w");
    if(arquivo == NULL) {
        printf("Erro ao abrir o arquivo");
    }

    for(int i = 0; i < n; i++) {
        fprintf(arquivo,"%d\n%s\n%d %d %d\n", alunos[i].id, alunos[i].nome,alunos[i].nasc.dia, alunos[i].nasc.mes, alunos[i].nasc.ano);
    }

    fclose(arquivo);

    //Aqui vamos ordenar por meio do ID de forma crescente e selecao

    for(int i = 0; i < n; i++) {
        int posMenor = i;
        for(int j = i + 1;j < n; j++) {
            if(alunos[posMenor].id > alunos[j].id) {
                posMenor = j;
            }
        }
        if(posMenor != i) {
            Aluno temp = alunos[i];
            alunos[i] = alunos[posMenor];
            alunos[posMenor] = temp;
        }
    }

    //Aqui vamos printar os dados dos alunos inseridos na tela estando ordenados pelo ID caso
    //o usuario digite "SIM"

    printf("Quer ver como ficou o cadastro dos usuarios com a ordenacao pelo ID?\nDigite SIM para ver ou NAO para nao ver\n");
    fgets(resp, 4, stdin);
    getchar();
    resp[strcspn(resp, "\n")] = '\0';
    if(strcmp(resp, "SIM") == 0) {
        for(int i = 0; i < n; i++) {
            printf("%do aluno:\n- ID: %d\n- Nome: %s\n- Data de nascimento: %d/%d/%d\n\n", i + 1, alunos[i].id, alunos[i].nome,alunos[i].nasc.dia, alunos[i].nasc.mes, alunos[i].nasc.ano);
        }
    }

    //Aqui e criado um arquivo chamado AlunosComOrdenacaoID com as informacoes dos alunos nao ordenadas

    FILE *arquivo1 = fopen("AlunosComOrdenacaoID.txt", "w");
    if(arquivo1 == NULL) {
        printf("Erro ao abrir o arquivo");
    }

    for(int i = 0; i < n; i++) {
        fprintf(arquivo1,"%d\n%s\n%d %d %d\n", alunos[i].id, alunos[i].nome,alunos[i].nasc.dia, alunos[i].nasc.mes, alunos[i].nasc.ano);
    }

    fclose(arquivo1);

    //Agora vamos fazer a ordenacao pelo ANO que o aluno nasceu no array ja ordenado pelo ID e, em caso de empate, pelo nome

    for(int i = 0; i < n; i++) {
        int posMenor = i;
        for(int j = i + 1; j < n; j++) {
            // Se o ano de nascimento de alunos[j] for menor, ele deve ser o "menor"
            if (alunos[j].nasc.ano < alunos[posMenor].nasc.ano) {
                posMenor = j;
            }
            // Se os anos forem iguais, desempatar pelo nome
            else if (alunos[j].nasc.ano == alunos[posMenor].nasc.ano) {
                if (strcmp(alunos[j].nome, alunos[posMenor].nome) < 0) {
                    posMenor = j;
                }
            }
        }
        if(posMenor != i) {
            Aluno temp = alunos[i];
            alunos[i] = alunos[posMenor];
            alunos[posMenor] = temp;
        }
    }

    //Aqui vamos printar os dados dos alunos inseridos na tela estando ordenados pelo ano caso
    //o usuario digite "SIM"

    printf("Quer ver como ficou o cadastro dos usuarios com a ordenacao pelo ANO?\nDigite SIM para ver ou NAO para nao ver\n");
    fgets(resp, 4, stdin);
    getchar();
    resp[strcspn(resp, "\n")] = '\0';
    if(strcmp(resp, "SIM") == 0) {
        for(int i = 0; i < n; i++) {
            printf("%do aluno:\n- ID: %d\n- Nome: %s\n- Data de nascimento: %d/%d/%d\n\n", i + 1, alunos[i].id, alunos[i].nome,alunos[i].nasc.dia, alunos[i].nasc.mes, alunos[i].nasc.ano);
        }
    }

    //Aqui e criado um arquivo chamado AlunosComOrdenacaoANO com as informacoes dos alunos ordenadas pelo ano

    FILE *arquivo2 = fopen("AlunosComOrdenacaoANO.txt", "w");
    if(arquivo2 == NULL) {
        printf("Erro ao abrir o arquivo");
    }

    for(int i = 0; i < n; i++) {
        fprintf(arquivo2,"%d\n%s\n%d %d %d\n", alunos[i].id, alunos[i].nome,alunos[i].nasc.dia, alunos[i].nasc.mes, alunos[i].nasc.ano);
    }

    fclose(arquivo2);

    //Agora vamos fazer a ordenacao pelo NOME que o aluno nasceu no array ja ordenado pelo ANO e, em caso de empate, pelo ANO

    for(int i = 0; i < n; i++) {
        int posMenor = i;
        for(int j = i + 1; j < n; j++) {
            if (strcmp(alunos[j].nome, alunos[posMenor].nome) < 0) {
                posMenor = j;
            }
            else if (strcmp(alunos[j].nome, alunos[posMenor].nome) == 0) {
                if (alunos[j].nasc.ano < alunos[posMenor].nasc.ano) {
                    posMenor = j;
                }
            }
        }
        if(posMenor != i) {
            Aluno temp = alunos[i];
            alunos[i] = alunos[posMenor];
            alunos[posMenor] = temp;
        }
    }

    //Aqui vamos printar os dados dos alunos inseridos na tela estando ordenados pelo NOME caso
    //o usuario digite "SIM"

    printf("Quer ver como ficou o cadastro dos usuarios com a ordenacao pelo NOME?\nDigite SIM para ver ou NAO para nao ver\n");
    fgets(resp, 4, stdin);
    getchar();
    resp[strcspn(resp, "\n")] = '\0';
    if(strcmp(resp, "SIM") == 0) {
        for(int i = 0; i < n; i++) {
            printf("%do aluno:\n- ID: %d\n- Nome: %s\n- Data de nascimento: %d/%d/%d\n\n", i + 1, alunos[i].id, alunos[i].nome,alunos[i].nasc.dia, alunos[i].nasc.mes, alunos[i].nasc.ano);
        }
    }

    //Aqui e criado um arquivo chamado AlunosComOrdenacaoANO com as informacoes dos alunos ordenadas pelo ano

    FILE *arquivo3 = fopen("AlunosComOrdenacaoNOME.txt", "w");
    if(arquivo3 == NULL) {
        printf("Erro ao abrir o arquivo");
    }

    for(int i = 0; i < n; i++) {
        fprintf(arquivo3,"%d\n%s\n%d %d %d\n", alunos[i].id, alunos[i].nome,alunos[i].nasc.dia, alunos[i].nasc.mes, alunos[i].nasc.ano);
    }

    fclose(arquivo3);
}