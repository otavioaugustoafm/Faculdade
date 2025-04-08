import java.util.*;

class Matriz {
    CelulaMatriz inicio;
    int linha, coluna;

    Matriz(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    void construirMatriz() {
        this.inicio = new CelulaMatriz();
        CelulaMatriz atual = inicio;
        CelulaMatriz linhaAcima = null;

        for(int i = 1; i < this.coluna; i++) {
            atual.dir = new CelulaMatriz();
            atual.dir.esq = atual;
            atual = atual.dir;
        }

        for(int i = 0; i < this.linha; i++) {
            if(linhaAcima == null) {
                linhaAcima = inicio;
            } else {
                linhaAcima = linhaAcima.inf;
            }
            atual = new CelulaMatriz();
            atual.sup = linhaAcima;
            linhaAcima.inf = atual;

            CelulaMatriz celulaAcima = linhaAcima;
            CelulaMatriz celulaAtual = atual;
            for(int j = 1; j < this.coluna; j++) {
                celulaAtual.dir = new CelulaMatriz();
                celulaAtual.dir.esq = celulaAtual;
                celulaAtual = celulaAtual.dir;
                celulaAcima = celulaAcima.dir;
                celulaAtual.sup = celulaAcima;
                celulaAcima.inf = celulaAtual;
            }
        }
    }

    Lista buscarElemento(int linha, int coluna) {
        CelulaMatriz atual = this.inicio;
        for(int i = 0; i < linha; i++) {
            atual = atual.inf;
        }
        for(int j = 0; j < coluna; j++) {
            atual = atual.dir;
        }
        return atual.lista;
    }
}

class CelulaMatriz {
    Lista lista;
    CelulaMatriz esq, dir, sup, inf;

    CelulaMatriz() {
        this.lista = new Lista();
        this.esq = this.dir = this.sup = this.inf = null;
    }

}

class CelulaLista {
    String elemento;
    CelulaLista ant, prox;

    CelulaLista() {
        this.elemento = " ";
        this.ant = this.prox = null;
    }
}

class Lista {
    CelulaLista primeiro;
    CelulaLista ultimo;

    Lista() {
        this.primeiro = null;
        this.ultimo = null;
    }

    void preencherLista(Lista lista) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite, uma linha por vez, o conteudo dos elementos da lista.\nUse 0 para finalizar.");
        String op = " ";
        int x = 1;
        while(op != "0") {
            System.out.print("Conteudo do " + x + "o elemento da lista: ");
            op = scanner.nextLine();
            if(op.equals("0")){
                break;
            } 
            CelulaLista celula = new CelulaLista();
            if(lista.primeiro == null) {
                lista.primeiro = celula;
                lista.ultimo = celula;
                celula.elemento = op;
            } else {
                CelulaLista tmp = lista.ultimo;
                lista.ultimo = celula;
                celula.ant = tmp;
                tmp.prox = celula;
                celula.elemento = op;
            }
            x++;
        }
    }

    void mostrar(Lista lista) {
        int x = 1;
        CelulaLista tmp = lista.primeiro;
        if(lista.primeiro == null) {  
            System.out.println("Lista Vazia.");
        } else {
            while(true) {
                System.out.print(x + "o elemento: "+ tmp.elemento +" |");
                tmp = tmp.prox;
                x++;
                if(tmp == null) {
                    break;
                }
            }
        }
        System.out.println();
    }
}

public class matrizHibridaLista {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a quantidade de linhas e colunas, respectivamente: ");
        int l = scanner.nextInt(), c = scanner.nextInt();
        Matriz matriz = new Matriz(l,c);
        matriz.construirMatriz();
        System.out.println("Agora vamos escolher um elemento da matriz e preencher a lista que ele aponta.\nDigite a posicao do elemento alvo, primeiro a linha e depois a coluna: ");
        l = scanner.nextInt(); c = scanner.nextInt();
        if(l > matriz.linha || c > matriz.coluna) {
            System.out.println("Posicao invalida");
        } else {
            Lista lista = matriz.buscarElemento(l,c);
            lista.preencherLista(lista);
        }
        System.out.println("Agora, vamos printar a lista de uma posicao.\nDigite a posicao na matriz que esta essa lista, primeiro a linha e depois a coluna: ");
        l = scanner.nextInt(); c = scanner.nextInt();
        if(l > matriz.linha || c > matriz.coluna) {
            System.out.println("Posicao invalida");
        } else {
            Lista lista = matriz.buscarElemento(l,c);
            lista.mostrar(lista);
        }
        scanner.close();
    }
}