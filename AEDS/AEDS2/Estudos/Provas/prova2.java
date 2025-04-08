import java.util.*;

class Lista {
    int[] array;
    int n;

    Lista(int tamanho) {
        array = new int[tamanho];
        n = 0;
    }

    void InserirFim(int elemento) {
        if(n >= array.length) {
            System.out.println("Erro");
            return;
        }
        array[n] = elemento;
        n++;
    }

    boolean isSorted() {
        for (int i = 0; i < n - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    String Ordenar() {
        int turn = 0; // 0 for Marcelo, 1 for Carlos
        while (!isSorted()) {
            boolean moved = false;
            for (int i = 0; i < n - 1; i++) {
                if (array[i] > array[i + 1]) {
                    // Inverte os elementos
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    moved = true;
                    break;
                }
            }
            if (!moved) {
                break;
            }
            turn = 1 - turn; // Alterna entre 0 e 1
        }
        return turn == 0 ? "Carlos" : "Marcelo";
    }
}

public class prova2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String entrada = scanner.nextLine();
            if (entrada.equals("0")) {
                break;
            }

            String[] entradaArray = entrada.split(" ");
            int qntElementos = Integer.parseInt(entradaArray[0]);
            Lista lista = new Lista(qntElementos);

            for (int i = 1; i <= qntElementos; i++) {
                lista.InserirFim(Integer.parseInt(entradaArray[i]));
            }

            String vencedor = lista.Ordenar();
            System.out.println(vencedor);
        }

        scanner.close();
    }
}
