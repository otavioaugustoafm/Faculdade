import java.util.Scanner;

public class tp1q1 {
    public static void main(String[] args) {
        String frase = "Inicio";
        Scanner scanner = new Scanner(System.in);
        int tamanho, index1, index2;
        String fim = "FIM";
        while(true) {
            boolean resp = true;
            frase = scanner.nextLine();
            if(frase.equals(fim)) {
                break;
            } else {
                tamanho = frase.length();
                index1 = 0;
                index2 = tamanho - 1;
                for(int i = 0; i < tamanho / 2; i++) {
                    if(frase.charAt(index1) != frase.charAt(index2)) {
                        resp = false;
                        break;
                    } 
                    index1++;
                    index2--;
                }
                if( resp == true) {
                    System.out.println("SIM");
                } else {
                    System.out.println("NAO");
                }
            }
        }
        scanner.close();
    }
}
