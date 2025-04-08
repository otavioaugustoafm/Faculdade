import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class es_lab1q1 {
    public static void main(String[] args) {
        String caminhoArquivo = "txt/lab01.txt";
        int cont = 0;
        try (Scanner scanner = new Scanner(new File(caminhoArquivo))) {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                cont = 0;
                for(char c : linha.toCharArray()) {
                    if(Character.isUpperCase(c)) {
                        cont++;
                    }
                }
                System.out.println(cont);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + caminhoArquivo);
        }
    }
}