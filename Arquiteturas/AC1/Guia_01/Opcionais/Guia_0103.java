//851568 - Otávio Augusto de Assis Ferreira Monteiro

public class Guia_0103 {
    public static void decToBase(int decimalNumber, int base) {
        String result = Integer.toString(decimalNumber, base);
        System.out.println("O número " + decimalNumber + "(10) em base " + base + " é: " + result);
    }

    public static void main(String[] args) {
        int a = 61;  // Decimal para base 4
        int b = 53;  // Decimal para base 8
        int c = 77;  // Decimal para base 16
        int d = 153; // Decimal para base 16
        int e = 753; // Decimal para base 16

        decToBase(a, 4);
        decToBase(b, 8);
        decToBase(c, 16);
        decToBase(d, 16);
        decToBase(e, 16);
    }
}
