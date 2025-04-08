import java.util.*;

class Celula {
    String elemento;
    Celula sup;
    Celula esq;
    Celula dir;
    Celula inf;

    Celula() {
        this.elemento = " ";
        this.sup = null;
        this.esq = null;
        this.dir = null;
        this.inf = null;
    }
}

class Matriz {
    Celula inicio;
    int linha, coluna;
    
    Matriz(int linha,int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    void construirMatriz() {
        inicio = new Celula();
        Celula atual = inicio;
        Celula linhaAcima = null;

        for(int i = 0; i < this.coluna; i++) {
            atual.dir = new Celula();
            atual.dir.esq = atual;
            atual = atual.dir;
        }

        for(int i = 1; i < this.linha; i++) {
            if(linhaAcima == null) {
                linhaAcima = inicio;
            }
            else {
                linhaAcima = linhaAcima.inf;
            }
            atual = new Celula();
            linhaAcima.inf = atual;
            atual.sup = linhaAcima;

            Celula celulaAcima = linhaAcima;
            Celula celulaAtual = atual;
            for(int j = 1; j < this.coluna; j++) {
                celulaAtual.dir = new Celula();
                celulaAtual.dir.esq = celulaAtual;
                celulaAtual = celulaAtual.dir;
                celulaAcima = celulaAcima.dir;
                celulaAtual.sup = celulaAcima;
                celulaAcima.inf = celulaAtual;
            }
        }
    }

    void mostrar() {
        Celula atual = inicio;
        for(int i=0; i<this.linha; i++) {
            Celula linhaAtual = atual;
            for(int j=0; j<this.coluna; j++) {
                System.out.print(linhaAtual.elemento + " ");
                linhaAtual = linhaAtual.dir;
            }
            System.out.println();
            atual = atual.inf;
        }
    }

    void matrizElementos () {
        Celula atual = inicio;
        for(int i=0; i<this.linha; i++) {
            Celula linhaAtual = atual;
            for(int j=0;j<this.coluna; j++) {
                linhaAtual.elemento = "[" +i+"|"+j+"]";
                linhaAtual = linhaAtual.dir;
            }
            atual = atual.inf;
        }
    }
}


public class matrizFlexivel {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt(); 
        int c = scanner.nextInt();;

        Matriz matriz = new Matriz(l,c);
        matriz.construirMatriz();
        matriz.matrizElementos();
        matriz.mostrar();
    }
}