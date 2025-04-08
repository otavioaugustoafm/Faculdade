//851568 - Otávio Augusto de Assis Ferreira Monteiro


public class Guia_0105 {

    public static void main(String[] args) {
        // Exemplos de conversões

        // a.) “PUC-M.G.”
        String strA = "PUC-M.G.";
        System.out.println("a.) 'PUC-M.G.' em hexadecimal:");
        System.out.println(convertASCIItoHex(strA));

        // b.) “2024-02”
        String strB = "2024-02";
        System.out.println("b.) '2024-02' em hexadecimal:");
        System.out.println(convertASCIItoHex(strB));

        // c.) “Belo Horizonte”
        String strC = "Belo Horizonte";
        System.out.println("c.) 'Belo Horizonte' em hexadecimal:");
        System.out.println(convertASCIItoHex(strC));

        // d.) Octal para hexadecimal
        int[] octalNumbers = {0156, 0157, 0151, 0164, 0145}; // Octal
        System.out.println("d.) Octal para hexadecimal:");
        convertOctalToHex(octalNumbers);

        // e.) Hexadecimal para ASCII
        String hexString = "4D 61 6E 68 61";
        System.out.println("e.) Hexadecimal para ASCII:");
        System.out.println(convertHexToASCII(hexString));
    }

    // Função para converter ASCII para hexadecimal
    public static String convertASCIItoHex(String input) {
        StringBuilder hexString = new StringBuilder();
        for (char c : input.toCharArray()) {
            hexString.append(String.format("%02X ", (int) c));
        }
        return hexString.toString().trim();
    }

    // Função para converter valores octais para hexadecimal
    public static void convertOctalToHex(int[] octalNumbers) {
        for (int octal : octalNumbers) {
            System.out.printf("%o (8) = %X (16)%n", octal, octal);
        }
    }

    // Função para converter hexadecimal para ASCII
    public static String convertHexToASCII(String hexString) {
        StringBuilder asciiString = new StringBuilder();
        String[] hexValues = hexString.split(" ");
        for (String hex : hexValues) {
            int decimal = Integer.parseInt(hex, 16);
            asciiString.append((char) decimal);
        }
        return asciiString.toString();
    }
}
