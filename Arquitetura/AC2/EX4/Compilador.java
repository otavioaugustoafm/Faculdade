import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Compilador {
    public static void main(String[] args) {
        
        try {
        //Abertura dos arquivos de escrita e leitura
        BufferedReader arq = new BufferedReader(new FileReader("dados/TESTEULA.ULA"));
        FileWriter saida = new FileWriter("dados/TESTEULA.HEX");

        //String linha vai ler o arquivo de entrada linha por linha por meio do burfferedReader
        String linha, W = "", X = "", Y = "";
        int x = 0, y = 0;

        while((linha = arq.readLine()) != null) {
            if(linha.equals("inicio:")) {
                // Pula a primeira linha;
            } else if (linha.charAt(0) == 'A') {
                X = linha.split("=")[1].replace(";","");
            } else if (linha.charAt(0) == 'B') {
                Y = linha.split("=")[1].replace(";","");
            } else if (linha.charAt(0) == 'W') {
                if(X == "" || Y == "") {
                    //Verifica se X e Y tem algum valor prévio ao W
                    System.out.println("Erro, X ou Y não foram definidos antes da primeira operação.");
                } else {
                    W = linha.split("=")[1].replace(";","");
                    try {
                        //Aqui transformamos a string X em inteiro
                        x = Integer.parseInt(X);
                        //Aqui transformamos o valor inteiro em Hexadecimanl e depois em letra maiúscula
                        saida.write(Integer.toHexString(x).toUpperCase());
                        //Aqui transformamos a string Y em inteiro
                        y = Integer.parseInt(Y);
                        //Aqui transformamos o valor inteiro em Hexadecimanl e depois em letra maiúscula
                        saida.write(Integer.toHexString(y).toUpperCase());
                        //Aqui buscamos na função ProcurarMnemonico o valor hexadecimal correspondente
                        saida.write(ProcurarMnemonico(W) + "\n");
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else if (linha.equals("fim.")) {
                break;
            }
        }

        //Fecha os dois arquivos
        arq.close();
        saida.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    //A string de parâmetro é o valor do W que recebemos na entrada. Ele será comparado com o código correspondente em hexadecimal
    public static String ProcurarMnemonico(String string) {
        if(string.equals("zeroL")) {
            return "0";
        } else if (string.equals("umL")) {
            return "1";
        } else if (string.equals("copiaA")) {
            return "2";
        } else if (string.equals("copiaB")) {
            return "3";
        } else if (string.equals("nA")) {
            return "4";
        } else if (string.equals("nB")) {
            return "5";
        } else if (string.equals("AenB")) {
            return "6";
        } else if (string.equals("nAeB")) {
            return "7";
        } else if (string.equals("AxB")) {
            return "8";
        } else if (string.equals("nAxnB")) {
            return "9";
        } else if (string.equals("nAxnBn")) {
            return "A";
        } else if (string.equals("AeB")) {
            return "B";
        } else if (string.equals("AeBn")) {
            return "C";
        } else if (string.equals("AoBn")) {
            return "D";
        } else if (string.equals("AoB")) {
            return "E";
        } else if (string.equals("nAonBn")) {
            return "F";
        } else {
            return "Erro";
        }
    }
}