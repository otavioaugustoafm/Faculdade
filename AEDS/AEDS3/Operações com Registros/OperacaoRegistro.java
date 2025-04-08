import java.text.DecimalFormat;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class OperacaoRegistro {
    public static void main(String[] args) {
        Livro l1 = new Livro(1, "Eu, Robô","Isaac Asimov", 14.9F);
        Livro l2 = new Livro(2, "Eu Sou A Lenda","Richard Matheson", 21.99F);
        Livro l3 = new Livro(3, "Teste Título", "Teste Autor", 50.9F);

        FileOutputStream arq;
        DataOutputStream dos;

        System.out.println("Cópia dos livros que foram ESCRITOS no arquivo: ");
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);

        FileInputStream arq2;
        DataInputStream dis;

        byte[] ba;

        try {

            /* Escrita */

            arq = new FileOutputStream("dados/livros.db");
            dos = new DataOutputStream(arq);    

            ba = l1.toByteArray();
            dos.writeInt(ba.length);
            dos.write(ba);

            ba = l2.toByteArray();
            dos.writeInt(ba.length);
            dos.write(ba);

            /* Aqui ele não tem o registro de tamanho */
            arq.write(l3.toByteArray()); 

            dos.close();
            arq.close();

            /* Leitura */

            Livro l4 = new Livro();
            Livro l5 = new Livro();
            int tam;

            arq2 = new FileInputStream("dados/livros.db");
            dis = new DataInputStream(arq2);
            
            tam = dis.readInt();
            ba = new byte[tam];
            dis.read(ba);
            l4.fromByteArray(ba);

            tam = dis.readInt();
            ba = new byte[tam];
            dis.read(ba);
            l5.fromByteArray(ba);

            System.out.println("\nLivros que foram LIDOS do arquivo: ");
            System.out.println(l4);
            System.out.println(l5);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

class Livro {
    protected int idLivro;
    protected String titulo;
    protected String autor;
    protected float preco;

    DecimalFormat df = new DecimalFormat("#,##0.00");

    public Livro(int idLivro, String titulo, String autor, float preco) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
    }

    public Livro() {
        this.idLivro = -1;
        this.titulo = "";
        this.autor = "";
        this.preco = 0F;
    }

    public String toString() {
        return "\nID: " + idLivro + " | Título: " + titulo + " | Autor: " + autor + " | Preço: " + df.format(preco);
    }

    /* Carregar o vetor de Bytes escrevendo */

    public byte[] toByteArray() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeInt(idLivro);
        dos.writeUTF(titulo);
        dos.writeUTF(autor);
        dos.writeFloat(preco);
        return baos.toByteArray();
    }

    /* Carregar o vetor de Bytes lendo de um arquivo */

    public void fromByteArray(byte[] ba) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(ba);
        DataInputStream dis = new DataInputStream(bais);
        idLivro = dis.readInt();
        titulo = dis.readUTF();
        autor = dis.readUTF();
        preco = dis.readFloat();
    }

}