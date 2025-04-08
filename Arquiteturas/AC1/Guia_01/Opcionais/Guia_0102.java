//851568 - Otávio Augusto de Assis Ferreira Monteiro

public class Guia_0102 {
    public static void bin2dec(String binaryString) {
        int decimalNumber = Integer.parseInt(binaryString, 2);
        System.out.println("O número decimal de " + binaryString + " é: " + decimalNumber);
    }
    
    public static void main(String[] args) {
        String a = "10101";  
        String b = "11011"; 
        String c = "10010"; 
        String d = "101011"; 
        String e = "110111"; 
        bin2dec(a);
        bin2dec(b);
        bin2dec(c);
        bin2dec(d);
        bin2dec(e);
    }
}
