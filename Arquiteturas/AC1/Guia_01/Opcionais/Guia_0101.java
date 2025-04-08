//851568 - Otávio Augusto de Assis Ferreira Monteiro

public class Guia_0101 {
    public static void dec2bin(int x) {
        String binaryString = Integer.toBinaryString(x);
        System.out.println("O número binário de " + x + " é: " + binaryString);
    }
    public static void main(String[] args) {
        int a = 26;
        int b = 53;
        int c = 713;
        int d = 213;
        int e = 365;
        dec2bin(a);
        dec2bin(b);
        dec2bin(c);
        dec2bin(d);
        dec2bin(e);
    }
}
