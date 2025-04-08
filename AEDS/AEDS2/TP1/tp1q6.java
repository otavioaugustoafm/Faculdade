public class tp1q6 {
    public static void main(String[] args) {
        while(true) {
            String frase = MyIO.readLine();
            if(frase.equals("FIM")) {
                return;
            }
            if(vogal(frase) == true) {
                MyIO.print("SIM ");
            } else {
                MyIO.print("NAO ");
            }
            if(consoante(frase) == true) {
                MyIO.print("SIM ");
            } else {
                MyIO.print("NAO ");
            } 
            if(inteiro(frase) == true) {
                MyIO.print("SIM SIM\n");
            } else if(real(frase) == true) {
                MyIO.print("NAO SIM\n");
            } else {
                MyIO.print("NAO NAO\n");
            } 
        }
    }
    public static boolean vogal(String frase) {
        String vogais = "aeiouAEIOU";
        boolean resp = true;
        for(int i = 0; i < frase.length(); i++) {
            for(int j = 0; j < vogais.length(); j++) {
                if(frase.charAt(i) == vogais.charAt(j)) {
                    resp = true;
                    break;
                } else {
                    resp = false;
                }
            }
            if(resp == false) {
                break;
            }
        }
        return resp;
    }
    public static boolean consoante(String frase) {
        String vogais = "aeiouAEIOU";
        boolean resp = true;
        for(int i = 0; i < frase.length(); i++) {
            for(int j = 0; j < vogais.length(); j++) {
                if(Character.isDigit(frase.charAt(i))) {
                    resp = false;
                    break;
                } else {
                    if(frase.charAt(i) != vogais.charAt(j)) {
                        resp = true;
                    } else {
                        resp = false;
                        break;
                    }
                }
            }
            if(resp == false) {
                break;
            }
        }
        return resp;
    }
    public static boolean inteiro(String frase) {
        String caracteres = ".,";
        boolean resp = false;
        for(int i = 0; i < frase.length(); i++) {
            for(int j = 0; j < caracteres.length(); j++) {
                if(Character.isLetter(frase.charAt(i))) {
                    return false;
                } else {
                    if(frase.charAt(i) != caracteres.charAt(j)) {
                        resp = true;
                    } else {
                        resp = false;
                        break;
                    }
                }
            }
            if(resp == false) {
                break;
            }
        }
        return resp;
    }
    public static boolean real(String frase) {
        String caracteres = ".,";
        boolean resp = false;
        for(int i = 0; i < frase.length(); i++) {
            for(int j = 0; j < caracteres.length(); j++) {
                if(Character.isLetter(frase.charAt(i))) {
                    return false;
                } else {
                    if(frase.charAt(i) == caracteres.charAt(j)) {
                        resp = true;
                        break;
                    } else {
                        resp = false;
                    }
                }
            }
            if(resp == true) {
                break;
            }
        }
        return resp;
    }
}
