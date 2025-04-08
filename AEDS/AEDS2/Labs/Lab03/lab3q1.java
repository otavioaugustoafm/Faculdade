public class lab3q1 {
    public static void main(String[] args) {
        while(true) {
            String frase;
            frase = MyIO.readLine();
            int pd = 0, pe = 0;
            boolean resp = true;
            char e = '(', d = ')';
            if(frase.equals("FIM")) {
                break;
            }
            for(int i = 0; i < frase.length(); i++) {
                if(frase.charAt(i) == e) {
                    pe++;
                } else if(frase.charAt(i) == d) {
                    if(pe == 0) {
                        resp = false;
                        break;
                    }
                    pd++;
                }
            }
            if(resp == true && pe == pd) {
                MyIO.print("correto\n");
            } else {
                MyIO.print("incorreto\n");
            }
        }
    }
}
