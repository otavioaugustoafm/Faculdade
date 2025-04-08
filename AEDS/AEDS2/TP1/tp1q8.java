import java.io.*;
import java.util.Scanner;

public class tp1q8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float num;
        int n;

        n = scanner.nextInt();

        try (PrintWriter arquivo = new PrintWriter(new FileWriter("arquivo.txt"))) {
            for (int i = 0; i < n; i++) {
                num = scanner.nextFloat();
                if (num / 1.0 == (int) (num / 1.0)) {
                    arquivo.printf("%.0f%n", num);
                } else {
                    arquivo.printf("%.3f%n", num);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao abrir o arquivo: " + e.getMessage());
            scanner.close();
            return;
        }

        try (RandomAccessFile arquivo = new RandomAccessFile("arquivo.txt", "r")) {
            long position = arquivo.length();
            int startOfLine = 1;
            char ch;

            while (position > 0) {
                position--;
                arquivo.seek(position);
                ch = (char) arquivo.read();

                if (ch == '\n' || position == 0) {
                    if (startOfLine == 0) {
                        if (position != 0) {
                            arquivo.seek(position + 1);
                        } else {
                            arquivo.seek(0);
                        }

                        String line = arquivo.readLine();
                        System.out.println(line);
                    }
                    startOfLine = 0;
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao abrir o arquivo: " + e.getMessage());
        }
        scanner.close();
    }
}
