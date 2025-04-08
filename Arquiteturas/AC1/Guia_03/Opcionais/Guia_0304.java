public class Guia_0304 {

    public static void main(String[] args) {
        System.out.println("11001(2) - 1101(2) = " + baseEval("11001", "-", "1101", 2));
        System.out.println("1011101(2) - 1001(2) = " + baseEval("1011101", "-", "1001", 2));
        System.out.println("312(4) - 231(4) = " + baseEval("312", "-", "231", 4));
        System.out.println("376(8) - 267(8) = " + baseEval("376", "-", "267", 8));
        System.out.println("7D2(16) - A51(16) = " + baseEval("7D2", "-", "A51", 16));
    }

    public static String baseEval(String x, String op, String y, int base) {
        int maxLength = Math.max(x.length(), y.length());
        x = padLeft(x, maxLength, base);
        y = padLeft(y, maxLength, base);

        String xComp = x;
        String yComp = getTwoComplement(y, base);

        int result = convertToDecimal(xComp, base) + convertToDecimal(yComp, base);

        return convertFromDecimal(result, base, maxLength);
    }

    public static String padLeft(String num, int length, int base) {
        while (num.length() < length) {
            num = "0" + num;
        }
        return num;
    }

    public static String getTwoComplement(String num, int base) {
        int length = num.length();
        String inverted = invertBits(num, base);
        int decimalValue = convertToDecimal(inverted, base) + 1;
        int maxValue = (1 << length) - 1;
        int complementValue = maxValue - decimalValue + 1;
        return convertFromDecimal(complementValue, base, length);
    }

    public static String invertBits(String num, int base) {
        StringBuilder inverted = new StringBuilder();
        for (char c : num.toCharArray()) {
            char newChar;
            if (base == 2) {
                newChar = (c == '0') ? '1' : '0';
            } else {
                newChar = c;
            }
            inverted.append(newChar);
        }
        return inverted.toString();
    }

    public static int convertToDecimal(String num, int base) {
        return Integer.parseInt(num, base);
    }

    public static String convertFromDecimal(int num, int base, int length) {
        String result = Integer.toString(num, base).toUpperCase();
        if (result.length() < length) {
            result = padLeft(result, length, base);
        }
        return result;
    }
}
