public class tp1q12 {
    public static void main(String[] args) {
        while(true) {
        String frase = MyIO.readLine();
        if(frase.equals("FIM")) {
            break;
        }
        ciframento(frase, 0);
        MyIO.print("\n");
        }
    }

    public static void ciframento(String frase, int i) {
        if (i == frase.length()) {
            return;
        } else {
            int num = (int) frase.charAt(i);
            num += 3;
            char c = (char) num;
            MyIO.print(c);
            ciframento(frase, i + 1);
        }
    }
}
