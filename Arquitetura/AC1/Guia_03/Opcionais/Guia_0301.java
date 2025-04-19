public class Guia_0301 {

    public static void main(String[] args) {
        System.out.println("C1,6(1010) = " + C1(6, "1010"));
        System.out.println("C1,8(1101) = " + C1(8, "1101"));
        System.out.println("C2,6(101001) = " + C2(6, "101001"));
        System.out.println("C2,7(101111) = " + C2(7, "101111"));
        System.out.println("C2,8(110100) = " + C2(8, "110100"));
    }

    public static String C1(int nbits, String binary) {
        String paddedBinary = padBinary(binary, nbits);

        StringBuilder result = new StringBuilder();
        for (char bit : paddedBinary.toCharArray()) {
            result.append(bit == '0' ? '1' : '0');
        }
        return result.toString();
    }

    public static String C2(int nbits, String binary) {
        String c1 = C1(nbits, binary);

        return addBinary(c1, "1", nbits);
    }

    public static String addBinary(String a, String b, int nbits) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int maxLength = Math.max(a.length(), b.length());
        for (int i = 0; i < maxLength; i++) {
            int bitA = i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
            int bitB = i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;
            int sum = bitA + bitB + carry;
            result.append(sum % 2);
            carry = sum / 2;
        }
        if (carry > 0) {
            result.append(carry);
        }
        String binaryResult = result.reverse().toString();
        return padBinary(binaryResult, nbits);
    }

    public static String padBinary(String binary, int nbits) {
        int length = binary.length();
        if (length < nbits) {
            StringBuilder padding = new StringBuilder();
            for (int i = 0; i < nbits - length; i++) {
                padding.append('0');
            }
            return padding.append(binary).toString();
        } else {
            return binary;
        }
    }
}
