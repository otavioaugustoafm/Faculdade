public class tp1q3 {
    public static void main(String[] args) {
        String frase;
        int tamanho;
        StringBuilder novaFrase;
        while(true){
            frase = MyIO.readLine();
            tamanho = frase.length();
            novaFrase = new StringBuilder();
            if(frase.equals("FIM")) {
                break;
            } 
            for (int i = 0; i < tamanho; i++) {
                int decimal = (int) frase.charAt(i);
                decimal += 3;
                char letra = (char) decimal;
                novaFrase.append(letra);
            }
            MyIO.print(novaFrase.toString() + "\n");
        }
    }
}
