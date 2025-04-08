import java.util.*;

class Lista {
    Arvore primeiro;
    Arvore ultimo;
    int n_elementos; 

    Lista() {
        this.primeiro = null;
        this.ultimo = null;
        this.n_elementos = 0;
    }

    void inserirFim(String especie) {

    }
}

class Arvore {
    Arvore prox;
    Arvore ant;
    String especie;

    Arvore() {
        this.prox = null;
        this.ant = null;
        this.especie = " ";
    }
}

public class listaFlexivel {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int op = -1;
        Lista lista = new Lista();

        while(op != 0) {
            System.out.println("=====Vamos trabalhar com uma Lista Flexivel=====\n1 - Adicionar arvore no fim da lista\n2 - Remover elemento no fim da lista\n6 - Mostrar\n0 - Sair\nQual opcao deseja?");
            op = scanner.nextInt();
            scanner.nextLine();
            switch(op) {
                case 1: {
                    System.out.print("Qual a especie?\n");
                    String especie = scanner.nextLine();
                    lista.inserirFim(especie);
                    break;
                }
                case 2: {
                    
                    break;
                }
                case 6: {

                    break;
                }
            }
        }

        scanner.close();
    }
}