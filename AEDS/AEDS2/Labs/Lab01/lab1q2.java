import java.util.Scanner;

public class lab1q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        letrasMaiusculas(scanner);
        scanner.close();
    }

    public static void letrasMaiusculas(Scanner scanner){
        int cont = 0;
        String linha = scanner.nextLine();
        if(linha.equals("FIM")) {
            return;
        } else {
            for (char c : linha.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    cont++;
                }
            }
            System.out.println(cont);
            letrasMaiusculas(scanner);
        }
    } 
}    


