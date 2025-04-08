class Arvore {
    No raiz;

    public Arvore() {
        this.raiz = null;
    }

    public boolean pesquisar(int x, No no) {
        boolean resp;
        if(no == null) {
            resp = false;
        } else if (x == no.elemento) {
            resp = true;
        } else if (x < no.elemento) {
            resp = pesquisar(x, no.esq);
        } else {
            resp = pesquisar(x, no.dir);
        }
        return resp;
    }

    public void caminharCentral(No no) {
        if(no != null) {
            caminharCentral(no.esq);
            System.out.print(no.elemento + " ");
            caminharCentral(no.dir);    
        }
    }

    public void caminharOrdem(No no) {
        if(no != null) {
            caminharOrdem(no.esq);
            System.out.print(no.elemento + " ");
            caminharOrdem(no.dir);
        }
    }

    public void caminharPre(No no) {
        if(no != null) {
            System.out.print(no.elemento + "(fator " + (no.getAltura(no.dir) - no.getAltura(no.esq)) + ") ");
            caminharPre(no.esq);
            caminharPre(no.dir);
        }
    }

    public void caminharPos(No no) {
        if(no != null) {
            caminharPos(no.esq);
            caminharPos(no.dir);
            System.out.print(no.elemento + " ");
        }
    }

    public void inserir(int elemento) {
        this.raiz = inserirRecursivo(this.raiz, elemento);
    }

    public No inserirRecursivo(No atual, int elemento) {
        if(atual == null) {
            atual = new No(elemento);
        } else if (atual.elemento > elemento) {
            atual.esq = inserirRecursivo(atual.esq, elemento);
        } else if (atual.elemento < elemento) {
            atual.dir = inserirRecursivo(atual.dir, elemento);
        } else {
            System.out.print("Erro");
        }
        return balancear(atual);
    }

    public No balancear(No atual) {
        if(atual != null) {
            int fator = atual.getAltura(atual.dir) - atual.getAltura(atual.esq);
            if(Math.abs(fator) <= 1) {
                atual.setAltura();
            } else if(fator == 2) {
                int fatorFilhoDir = atual.getAltura(atual.dir.dir) - atual.getAltura(atual.dir.esq);
                if(fatorFilhoDir == -1) {
                    atual.dir = rotacionarDir(atual.dir);  
                }
                atual = rotacionarEsq(atual);
            } else if(fator == -2) {
                int fatorFilhoEsq = atual.getAltura(atual.dir);
                if(fatorFilhoEsq == 1) {
                    atual.esq = rotacionarEsq(atual.esq);
                }
                atual = rotacionarDir(atual);
            } else {
                System.out.println("Erro!");
            }
        }
        return atual;
    }

    public No rotacionarEsq(No atual) {
        No noDir = atual.dir;
        No noDirEsq = noDir.esq;

        noDir.esq = atual;
        atual.dir = noDirEsq;
        
        atual.setAltura();
        noDir.setAltura();

        return noDir;
    }

    public No rotacionarDir(No atual) {
        No noEsq = atual.esq;
        No noEsqDir = noEsq.dir;

        noEsq.dir = atual;
        atual.esq = noEsqDir;

        atual.setAltura();
        noEsq.setAltura();

        return noEsq;
    }
}

class No {
    No dir;
    No esq;
    int elemento;
    int altura;

    public No(int elemento) {
        this.dir = null;
        this.esq = null;
        this.elemento = elemento;
        this.altura = 1;
    }

    public int getAltura(No no) {
        return (no == null) ? 0 : no.altura;
    }

    public No(int elemento, No esq, No dir, int altura) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
        this.altura = altura;
    }

    public void setAltura() {
        this.altura = 1 + Math.max(getAltura(esq), getAltura(dir));
    }
}

public class arvoreBalanceada { 
    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        int[] vet = {4,35,10,13,3,30,15,12,7,40,20};

        for(int elemento : vet) {
            arvore.inserir(elemento);
        }

        arvore.caminharPre(arvore.raiz);
    }
}
