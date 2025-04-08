class Arvore {
    No raiz;

    Arvore() {
        this.raiz = null;
    }

    public void inserir(int elemento) {
        this.raiz = inserirRecursivo(this.raiz, elemento);
    }

    public No inserirRecursivo(No atual, int elemento) {
        if(atual == null) {
            atual = new No(elemento);
        } else if(atual.elemento > elemento) {
            atual.esq = inserirRecursivo(atual.esq, elemento);
        } else if(atual.elemento < elemento) {
            atual.dir = inserirRecursivo(atual.dir, elemento);
        } else if(atual.elemento == elemento) {
            return atual;
        }
        no.altura = 1 + Math.max(altura(atual.esq),altura(atual.dir));
        return atual;
    }

    public void percorrerOrdem() {
        percorrerOrdemRecursivo(this.raiz);
    }

    public void percorrerOrdemRecursivo(No atual){
        if(atual != null) {
            percorrerOrdemRecursivo(atual.esq);
            System.out.print(atual.elemento + " | ");
            percorrerOrdemRecursivo(atual.dir);
        }
    }
}

class No {
    No dir;
    No esq;
    int altura;
    int elemento;

    No(int elemento) {
        this.dir = null;
        this.esq = null;
        this.elemento = elemento;
        this.altura = 1;
    }
}

public class balanceada {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        
    }
}