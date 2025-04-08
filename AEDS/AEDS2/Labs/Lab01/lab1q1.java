import java.util.Scanner;

public class lab1q1 {
    public static void main(String[] args) {
        int cont = 0;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
                if (linha.equalsIgnoreCase("FIM")) {
                break;
            }

            cont = 0;
            for (char c : linha.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    cont++;
                }
            }
            System.out.println(cont);
        }
        scanner.close();
    }
}