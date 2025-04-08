//851568 - Otávio Augusto de Assis Ferreira Monteiro

public class Guia_0104 {
    public static int bin2dec(String binaryString) {
        return Integer.parseInt(binaryString, 2);
    }
    
    public static void decToBase(int decimalNumber, int base) {
        String result = Integer.toString(decimalNumber, base);
        System.out.println("O número em base " + base + " é: " + result);
    }

    public static void main(String[] args) {
        String a = "10100";  // Binário para base 4
        String b = "11010";  // Binário para base 8
        String c = "100111"; // Binário para base 16
        String d = "100101"; // Binário para base 8
        String e = "101101"; // Binário para base 4

        int decimalA = bin2dec(a);
        int decimalB = bin2dec(b);
        int decimalC = bin2dec(c);
        int decimalD = bin2dec(d);
        int decimalE = bin2dec(e);

        System.out.println("Para o binário " + a + "(2):");
        decToBase(decimalA, 4);

        System.out.println("Para o binário " + b + "(2):");
        decToBase(decimalB, 8);

        System.out.println("Para o binário " + c + "(2):");
        decToBase(decimalC, 16);

        System.out.println("Para o binário " + d + "(2):");
        decToBase(decimalD, 8);

        System.out.println("Para o binário " + e + "(2):");
        decToBase(decimalE, 4);
    }
}