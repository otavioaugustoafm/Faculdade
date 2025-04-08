
public class tp1q10 {
    public static void main(String[] args) {
        boolean resp = true;
        while(true) {
            String frase = MyIO.readLine();
            int tam = frase.length();
            if(frase.equals("FIM")) {
                break;
            }
            resp = palindromo(frase,0, resp, tam);
            if(resp == true) {
                MyIO.print("SIM");
            } else {
                MyIO.print("NAO");
            }
            MyIO.print("\n");
        }
    }
    public static boolean palindromo(String frase, int i, boolean resp, int tam) {
        if(i == frase.length()){
            return resp;
        } else {
            if (frase.charAt(i) == frase.charAt(tam - 1)) {
                resp = true;
                return palindromo(frase,i + 1, resp, tam - 1);
            } else {
                resp = false;
                return resp;
            }
        }
    }
}
