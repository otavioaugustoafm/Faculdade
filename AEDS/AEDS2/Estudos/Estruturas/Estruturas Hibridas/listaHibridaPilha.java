
class Lista {
    Celula primeiro;
    Celula ultimo;

    Lista() {
        this.primeiro = null;
        this.ultimo = null;
    }
}

class Celula {
    Celula ant;
    Celula prox;
    String elemento;

    Celula() {
        this.ant = null;
        this.prox = null;
        this.elemento = " ";
    }
}

class Pilha {
    Celula ultimo;

    Pilha() {
        this.ultimo = null;
    }

    void inserirPilha() {
        Celula celula = new Celula();
        if(this.ultimo == null) {
            this.ultimo = celula;
        } else {
            Celula tmp = this.ultimo;
            this.ultimo = celula;
            celula.ant = tmp;
            tmp.prox = celula;
        }
    }
}

public class listaHibridaPilha {
    public static void main(String args[]) {

    }
}