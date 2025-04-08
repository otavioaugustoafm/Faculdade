public class Guia_0303 {

    public static void main(String[] args) {
        System.out.println("10110(2) = " + complementoDoisToBase("10110", 10));
        System.out.println("110011(2) = " + complementoDoisToBase("110011", 10));
        System.out.println("100100(2) = " + complementoDoisToBase("100100", 2));
        System.out.println("1011011(2) = " + complementoDoisToBase("1011011", 2));
        System.out.println("1110011(2) = " + complementoDoisToBase("1110011", 16));
    }

    public static String complementoDoisToBase(String binary, int base) {
        int length = binary.length();
        boolean isNegative = binary.charAt(0) == '1';

        int decimalValue;
        if (!isNegative) {
            decimalValue = Integer.parseInt(binary, 2);
        } else {
            String invertedBinary = invertBits(binary);
            decimalValue = Integer.parseInt(invertedBinary, 2) + 1;
            int maxValue = (1 << length) - 1;
            decimalValue = maxValue - decimalValue + 1;
        }

        return convertToBase(decimalValue, base);
    }

    public static String invertBits(String binary) {
        StringBuilder inverted = new StringBuilder();
        for (char bit : binary.toCharArray()) {
            inverted.append(bit == '0' ? '1' : '0');
        }
        return inverted.toString();
    }

    public static String convertToBase(int decimalValue, int base) {
        switch (base) {
            case 2: // Binary
                return Integer.toBinaryString(decimalValue);
            case 8: // Octal
                return Integer.toOctalString(decimalValue);
            case 16: // Hexadecimal
                return Integer.toHexString(decimalValue).toUpperCase();
            default:
                return Integer.toString(decimalValue); // Decimal
        }
    }
}
