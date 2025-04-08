import java.util.*;

public class lab06 {
    public static void main(String[] args) {
        int[] tamanho = {100,1000,10000};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual opção de ordenação deseja utilizar?\n1 - QuickSort por meio do pivô no primeiro elemento\n2 - QuickSort por meio do pivô no último elemento\n3 - QuickSort por meio do pivô em uma posição aleatória\n4 - QuickSort por meio do pivô na mediana dos três elementos (início, meio, fim)\n5 - Sair");
        int op = scanner.nextInt();
        long startTime, endTime, duration;
        while(op != 5) {
        switch (op) {
            case 1: {
                int[] array1 = arrayOrdenado(tamanho[0]); 
                int[] array2 = arrayOrdenado(tamanho[1]); 
                int[] array3 = arrayOrdenado(tamanho[2]); 
                System.out.println("Ordenando pelo pivo no primeiro elemento e tendo o array já ordenado\n");
                System.out.println("100 elementos\n");
                startTime = System.nanoTime();
                quicksortPrimeiro(array1, 0, array1.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");
                System.out.println("1000 elementos\n");
                startTime = System.nanoTime();
                quicksortPrimeiro(array2, 0, array2.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");
                System.out.println("10000 elementos\n");
                startTime = System.nanoTime();
                quicksortPrimeiro(array3, 0, array3.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");

                array1 = arrayQuaseOrdenado(tamanho[0]); 
                array2 = arrayQuaseOrdenado(tamanho[1]); 
                array3 = arrayQuaseOrdenado(tamanho[2]); 
                System.out.println("Ordenando pelo pivo no primeiro elemento e tendo o array quase ordenado\n");
                System.out.println("100 elementos\n");
                startTime = System.nanoTime();
                quicksortPrimeiro(array1, 0, array1.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");
                System.out.println("1000 elementos\n");
                startTime = System.nanoTime();
                quicksortPrimeiro(array2, 0, array2.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");
                System.out.println("10000 elementos\n");
                startTime = System.nanoTime();
                quicksortPrimeiro(array3, 0, array3.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");

                array1 = arrayAleatorio(tamanho[0]); 
                array2 = arrayAleatorio(tamanho[1]); 
                array3 = arrayAleatorio(tamanho[2]); 
                System.out.println("Ordenando pelo pivo no primeiro elemento e tendo o array quase ordenado\n");
                System.out.println("100 elementos\n");
                startTime = System.nanoTime();
                quicksortPrimeiro(array1, 0, array1.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");
                System.out.println("1000 elementos\n");
                startTime = System.nanoTime();
                quicksortPrimeiro(array2, 0, array2.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");
                System.out.println("10000 elementos\n");
                startTime = System.nanoTime();
                quicksortPrimeiro(array3, 0, array3.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");
                break;
            }
            case 2: {
                int[] array1 = arrayOrdenado(tamanho[0]); 
                int[] array2 = arrayOrdenado(tamanho[1]); 
                int[] array3 = arrayOrdenado(tamanho[2]); 
                System.out.println("Ordenando pelo pivo no último elemento e tendo o array já ordenado\n");
                System.out.println("100 elementos\n");
                startTime = System.nanoTime();
                quicksortUltimo(array1, 0, array1.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");
                System.out.println("1000 elementos\n");
                startTime = System.nanoTime();
                quicksortUltimo(array2, 0, array2.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");
                System.out.println("10000 elementos\n");
                startTime = System.nanoTime();
                quicksortUltimo(array3, 0, array3.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");

                array1 = arrayQuaseOrdenado(tamanho[0]); 
                array2 = arrayQuaseOrdenado(tamanho[1]); 
                array3 = arrayQuaseOrdenado(tamanho[2]); 
                System.out.println("Ordenando pelo pivo no primeiro elemento e tendo o array quase ordenado\n");
                System.out.println("100 elementos\n");
                startTime = System.nanoTime();
                quicksortUltimo(array1, 0, array1.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");
                System.out.println("1000 elementos\n");
                startTime = System.nanoTime();
                quicksortUltimo(array2, 0, array2.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");
                System.out.println("10000 elementos\n");
                startTime = System.nanoTime();
                quicksortUltimo(array3, 0, array3.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");

                array1 = arrayAleatorio(tamanho[0]); 
                array2 = arrayAleatorio(tamanho[1]); 
                array3 = arrayAleatorio(tamanho[2]); 
                System.out.println("Ordenando pelo pivo no primeiro elemento e tendo o array quase ordenado\n");
                System.out.println("100 elementos\n");
                startTime = System.nanoTime();
                quicksortUltimo(array1, 0, array1.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");
                System.out.println("1000 elementos\n");
                startTime = System.nanoTime();
                quicksortUltimo(array2, 0, array2.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");
                System.out.println("10000 elementos\n");
                startTime = System.nanoTime();
                quicksortUltimo(array3, 0, array3.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");
                break;
            }
            case 3: {
                int[] array1 = arrayOrdenado(tamanho[0]); 
                int[] array2 = arrayOrdenado(tamanho[1]); 
                int[] array3 = arrayOrdenado(tamanho[2]); 
                System.out.println("Ordenando pelo pivo em uma posição aleatória e tendo o array já ordenado\n");
                System.out.println("100 elementos\n");
                startTime = System.nanoTime();
                quicksortAleatorio(array1, 0, array1.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");
                System.out.println("1000 elementos\n");
                startTime = System.nanoTime();
                quicksortAleatorio(array2, 0, array2.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");
                System.out.println("10000 elementos\n");
                startTime = System.nanoTime();
                quicksortAleatorio(array3, 0, array3.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");

                array1 = arrayQuaseOrdenado(tamanho[0]); 
                array2 = arrayQuaseOrdenado(tamanho[1]); 
                array3 = arrayQuaseOrdenado(tamanho[2]); 
                System.out.println("Ordenando pelo pivo no primeiro elemento e tendo o array quase ordenado\n");
                System.out.println("100 elementos\n");
                startTime = System.nanoTime();
                quicksortAleatorio(array1, 0, array1.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");
                System.out.println("1000 elementos\n");
                startTime = System.nanoTime();
                quicksortAleatorio(array2, 0, array2.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");
                System.out.println("10000 elementos\n");
                startTime = System.nanoTime();
                quicksortAleatorio(array3, 0, array3.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");

                array1 = arrayAleatorio(tamanho[0]); 
                array2 = arrayAleatorio(tamanho[1]); 
                array3 = arrayAleatorio(tamanho[2]); 
                System.out.println("Ordenando pelo pivo no primeiro elemento e tendo o array quase ordenado\n");
                System.out.println("100 elementos\n");
                startTime = System.nanoTime();
                quicksortAleatorio(array1, 0, array1.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");
                System.out.println("1000 elementos\n");
                startTime = System.nanoTime();
                quicksortAleatorio(array2, 0, array2.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");
                System.out.println("10000 elementos\n");
                startTime = System.nanoTime();
                quicksortAleatorio(array3, 0, array3.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");
                break;
            }
            case 4: {
                int[] array1 = arrayOrdenado(tamanho[0]); 
                int[] array2 = arrayOrdenado(tamanho[1]); 
                int[] array3 = arrayOrdenado(tamanho[2]); 
                System.out.println("Ordenando pelo pivo na mediana e tendo o array já ordenado\n");
                System.out.println("100 elementos\n");
                startTime = System.nanoTime();
                quicksortMediana(array1, 0, array1.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");
                System.out.println("1000 elementos\n");
                startTime = System.nanoTime();
                quicksortMediana(array2, 0, array2.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");
                System.out.println("10000 elementos\n");
                startTime = System.nanoTime();
                quicksortMediana(array3, 0, array3.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");

                array1 = arrayQuaseOrdenado(tamanho[0]); 
                array2 = arrayQuaseOrdenado(tamanho[1]); 
                array3 = arrayQuaseOrdenado(tamanho[2]); 
                System.out.println("Ordenando pelo pivo no primeiro elemento e tendo o array quase ordenado\n");
                System.out.println("100 elementos\n");
                startTime = System.nanoTime();
                quicksortMediana(array1, 0, array1.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");
                System.out.println("1000 elementos\n");
                startTime = System.nanoTime();
                quicksortMediana(array2, 0, array2.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");
                System.out.println("10000 elementos\n");
                startTime = System.nanoTime();
                quicksortMediana(array3, 0, array3.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");

                array1 = arrayAleatorio(tamanho[0]); 
                array2 = arrayAleatorio(tamanho[1]); 
                array3 = arrayAleatorio(tamanho[2]); 
                System.out.println("Ordenando pelo pivo no primeiro elemento e tendo o array quase ordenado\n");
                System.out.println("100 elementos\n");
                startTime = System.nanoTime();
                quicksortMediana(array1, 0, array1.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");
                System.out.println("1000 elementos\n");
                startTime = System.nanoTime();
                quicksortMediana(array2, 0, array2.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");
                System.out.println("10000 elementos\n");
                startTime = System.nanoTime();
                quicksortMediana(array3, 0, array3.length-1);
                endTime = System.nanoTime();
                duration = endTime - startTime;
                System.out.println("Tempo de execução (ns): " + duration + "\n");
                break;
            }
            default: {
                System.out.print("Opção Inválida\n");
            }
        }
        System.out.println("Qual opção de ordenação deseja utilizar?\n1 - QuickSort por meio do pivô no primeiro elemento\n2 - QuickSort por meio do pivô no último elemento\n3 - QuickSort por meio do pivô em uma posição aleatória\n4 - QuickSort por meio do pivô na mediana dos três elementos (início, meio, fim)\n5 - Sair");
        op = scanner.nextInt();
        }
        scanner.close();
    }
    


    // Utilizando o QuickSort com o pivô no primeiro elemento
    public static void quicksortPrimeiro(int[] array, int esq, int dir) {
        if(esq < dir) {
            int indicePivo = particionaPrimeiro(array, esq, dir);
            quicksortPrimeiro(array,esq,indicePivo-1);
            quicksortPrimeiro(array, indicePivo + 1, dir);
        }
    }

    public static int particionaPrimeiro(int[] array, int esq, int dir) {
        int pivo = array[esq];
        int i = esq + 1;
        for(int j = esq + 1; j <= dir; j++) {
            if(array[j] < pivo) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
            }
        }
        int tmp = array[esq];
        array[esq] = array[i-1];
        array[i-1] = tmp;
        return i - 1;
    }

    // Utilizando o QuickSort com o pivô no último elemento
    public static void quicksortUltimo(int[] array, int esq, int dir) {
        if(esq < dir) {
            int indicePivo = particionaUltimo(array, esq, dir);
            quicksortUltimo(array, esq, indicePivo-1);
            quicksortUltimo(array, indicePivo+1, dir);
        }
    }

    public static int particionaUltimo(int[] array, int esq, int dir) {
        int pivo = array[dir];
        int i = esq;
        for(int j = esq; j < dir; j++) {
            if(array[j] <= pivo) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
            }
        }
        int tmp = array[i];
        array[i] = array[dir];
        array[dir] = tmp;
        return i;
    }


    // Utilizando o QuickSort com o pivô no primeiro elemento
    public static void quicksortAleatorio(int[] array, int esq, int dir) {
        if(esq < dir) {
            int indicePivo = particionarAleatorio(array, esq, dir);
            quicksortAleatorio(array, esq, indicePivo-1);
            quicksortAleatorio(array, indicePivo+1, dir);
        }
    }

    public static int particionarAleatorio(int[] array, int esq, int dir) {
        Random gerador = new Random();
        int aleatorio = gerador.nextInt(dir - esq + 1) + esq;
        int tmp = array[dir];
        array[dir] = array[aleatorio];
        array[aleatorio] = tmp;
        int pivo = array[dir];
        int i = esq;
        for(int j = esq; j < dir; j++){
            if(array[j] <= pivo) {
                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
            }
        }
        tmp = array[i];
        array[i] = array[dir];
        array[dir] = tmp;
        return i;
    }

    // Utilizando o QuickSort com o pivô na mediana 
    public static void quicksortMediana(int[] array, int esq, int dir) {
        if (esq < dir) {
            int indicePivo = particionarMediana(array, esq, dir);
            quicksortMediana(array, esq, indicePivo-1);
            quicksortMediana(array, indicePivo+1, dir);
        }
    }

    public static int particionarMediana(int[]array, int esq, int dir) {
        int meio = esq + (dir-esq) / 2;
        int indiceMediana = mediana(array, esq, meio, dir);
        int tmp = array[dir];
        array[dir] = array[indiceMediana];
        array[indiceMediana] = tmp;
        int pivo = array[dir];
        int i = esq;
        for(int j = esq; j < dir; j++) {
            if(array[j] <= pivo) {
                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
            }
        }
        tmp = array[dir];
        array[dir] = array[i];
        array[i] = tmp;
        return i;
    }

    public static int[] arrayAleatorio(int tamanho) {
        Random gerador = new Random();
        int[] array = new int[tamanho];
        for(int i = 0; i < tamanho;i++) {
            array[i] = gerador.nextInt(10000);
        }
        return array;
    }

    public static int[] arrayOrdenado(int tamanho) {
        Random gerador = new Random();
        int[] array = new int[tamanho];
        for(int i = 0; i < tamanho;i++) {
            array[i] = gerador.nextInt(10000);
        }
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public static int[] arrayQuaseOrdenado(int tamanho) {
        Random gerador = new Random();
        int[] array = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = gerador.nextInt(1000);
        }
    
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    
        for (int i = 0; i < n / 10; i++) { 
            int pos1 = gerador.nextInt(n);
            int pos2 = gerador.nextInt(n);
            
            int temp = array[pos1];
            array[pos1] = array[pos2];
            array[pos2] = temp;
        }
        return array;
    }

    public static int mediana(int[] array, int esq, int meio, int dir) {
        int a = array[esq];
        int b = array[meio];
        int c = array[dir];
    
        if ((a > b && a < c) || (a < b && a > c)) {
            return esq; 
        } else if ((b > a && b < c) || (b < a && b > c)) {
            return meio; 
        } else {
            return dir;
        }
    }
}