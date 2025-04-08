public class tp1q15 {
    public static void main(String[] args) {
        processaEntrada();
    }

    public static void processaEntrada() {
        String frase = MyIO.readLine();
        if (frase.equals("FIM")) {
            return;
        }

        if (vogal(frase, 0)) {
            MyIO.print("SIM ");
        } else {
            MyIO.print("NAO ");
        }

        if (consoante(frase, 0)) {
            MyIO.print("SIM ");
        } else {
            MyIO.print("NAO ");
        }

        if (inteiro(frase, 0, false)) {
            MyIO.print("SIM SIM\n");
        } else if (real(frase, 0, false)) {
            MyIO.print("NAO SIM\n");
        } else {
            MyIO.print("NAO NAO\n");
        }

        processaEntrada();
    }

    public static boolean vogal(String frase, int i) {
        String vogais = "aeiouAEIOU";
        if (i == frase.length()) {
            return true;
        } else if (!vogais.contains(String.valueOf(frase.charAt(i)))) {
            return false;
        } else {
            return vogal(frase, i + 1);
        }
    }

    public static boolean consoante(String frase, int i) {
        String vogais = "aeiouAEIOU";
        if (i == frase.length()) {
            return true;
        } else if (Character.isDigit(frase.charAt(i)) || vogais.contains(String.valueOf(frase.charAt(i)))) {
            return false;
        } else {
            return consoante(frase, i + 1);
        }
    }

    public static boolean inteiro(String frase, int i, boolean foundDecimal) {
        if (i == frase.length()) {
            return !foundDecimal;
        } else if (Character.isLetter(frase.charAt(i))) {
            return false;
        } else if (frase.charAt(i) == '.' || frase.charAt(i) == ',') {
            return inteiro(frase, i + 1, true);
        } else {
            return inteiro(frase, i + 1, foundDecimal);
        }
    }

    public static boolean real(String frase, int i, boolean foundDecimal) {
        if (i == frase.length()) {
            return foundDecimal;
        } else if (Character.isLetter(frase.charAt(i))) {
            return false;
        } else if (frase.charAt(i) == '.' || frase.charAt(i) == ',') {
            return real(frase, i + 1, true);
        } else {
            return real(frase, i + 1, foundDecimal);
        }
    }
}
