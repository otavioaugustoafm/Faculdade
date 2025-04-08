import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class es_lab1q2 {
    public static void main(String[] args) {
        String caminhoArquivo = "txt/lab01.txt";
        try (Scanner scanner = new Scanner(new File(caminhoArquivo))) {
            letrasMaiusculas(scanner);
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + caminhoArquivo);
        }
    }

    public static void letrasMaiusculas(Scanner scanner) {
        if (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            int cont = 0;
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