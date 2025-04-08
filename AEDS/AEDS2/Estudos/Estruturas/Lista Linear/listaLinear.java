public class listaLinear {
    public static void main(String[] args) {
        System.out.println("============ Lista Linear ============");
        Lista lista = new Lista(6);  
        int x1, x2, x3;             

        //Comandos de inseção para serem executados na lista
        lista.InserirInicio(1);
        lista.Mostrar();
        lista.InserirFim(7);
        lista.Mostrar();
        lista.InserirFim(9);
        lista.Mostrar();
        lista.InserirInicio(3);
        lista.Mostrar();
        lista.Inserir(8,3);
        lista.Mostrar();
        lista.Inserir(4,2);
        lista.Mostrar();

        //Comandos de remoção para serem executados na lista
        x1 = lista.RemoverInicio();
        x2 = lista.RemoverFim();
        x3 = lista.Remover(2);
        System.out.println("Remoção no início: " + x1 + " | Remoção no fim: " + x2 + " | Remoção na posição 2 (após remoção no início e fim): " + x3);

        //Comando para printar o estado atual da lista
        lista.Mostrar();        
    }
}

class Lista { 
    int[] array;
    int n;

    //Construtores 
    Lista() {
        array = new int[6];
        n = 0;
    }

    Lista (int tamanho) {
        array = new int[tamanho];
        n = 0;
    }

    //Metodos 
    void InserirInicio(int x) {
        if(n >= array.length) {
            System.out.println("Erro");
        }

        for(int i = n; i > 0; i--) {
            array[i] = array[i-1];
        }

        array[0] = x;
        n++;
    }

    void InserirFim(int x) {
        if(n >= array.length) {
            System.out.println("Erro");
        }

        array[n] = x;
        n++;
    }

    void Inserir(int x, int pos) {
        if(n >= array.length) {
            System.out.println("Erro");
        }

        for(int i = n; i > pos; i--) {
            array[i] = array[i-1];
        }

        array[pos] = x;
        n++;
    }

    int RemoverInicio() {
        if(n == 0) {
            System.out.println("Erro");
        }

        int resp = array[0];
        n--;

        for(int i = 0; i < n; i++) {
            array[i] = array[i+1];
        }

        return resp;
    }

    int RemoverFim() {
        if(n == 0) {
            System.out.println("Erro");
        }

        return array[--n];
    }

    int Remover(int pos) {
        if(n == 0 || pos < 0 || pos > n) {
            System.out.println("Erro");
        }

        int resp = array[pos];
        n--;

        for(int i = pos; i < n; i++) {
            array[i] = array[i+1];
        }

        return resp;
    }

    void Mostrar() {
        for(int i = 0; i < n; i++) {
            System.out.println(array[i] + "|");
        }
        System.out.println("=======================");
    }
}