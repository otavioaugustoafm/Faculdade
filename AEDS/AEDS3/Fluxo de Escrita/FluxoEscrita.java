import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.io.DataOutputStream;

public class FluxoEscrita {
    public static void main(String[] args) {
        Livro l1 = new Livro(1, "Eu, Robô","Isaac Asimov", 14.9F);
        Livro l2 = new Livro(2, "Eu Sou A Lenda","Richard Matheson", 21.99F);
        Livro l3 = new Livro(3, "Teste Título", "Teste Autor", 50.9F);

        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);

        FileOutputStream arq;
        DataOutputStream dos;
        
        try {
            arq = new FileOutputStream("dados/livros.db");
            dos = new DataOutputStream(arq);

            dos.writeInt(l1.idLivro);
            dos.writeUTF(l1.titulo);
            dos.writeUTF(l1.autor);
            dos.writeFloat(l1.preco);

            dos.writeInt(l2.idLivro);
            dos.writeUTF(l2.titulo);
            dos.writeUTF(l2.autor);
            dos.writeFloat(l2.preco);

            dos.writeInt(l3.idLivro);
            dos.writeUTF(l3.titulo);
            dos.writeUTF(l3.autor);
            dos.writeFloat(l3.preco);

            dos.close();
            arq.close();
            
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

    public String toString() {
        return "\nID: " + idLivro + " | Título: " + titulo + " | Autor: " + autor + " | Preço: " + df.format(preco);
    }
}