import java.util.*;

public  class lab2q2 {
    public static void main(String[] args) {
        int x, y;
        Scanner scanner = new Scanner(System.in);
        StringBuilder novapalavra = new StringBuilder();
        StringBuilder palavra = new StringBuilder();
        novapalavra.setLength(palavra.length());
        while(scanner.hasNext()) {
            novapalavra = new StringBuilder();
            palavra = new StringBuilder();
            x = scanner.nextInt();
            y = scanner.nextInt();
        
            for(int i = x; i <= y; i++) {
                palavra.append(i);
            }
            System.out.print(palavra.toString());

            for (int i = palavra.length() -1; i >= 0; i--) {
                System.out.print(palavra.charAt(i));
            }


            System.out.println(novapalavra.toString());
        }
        scanner.close();
    }
}