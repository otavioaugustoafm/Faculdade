import java.text.DecimalFormat;
import java.io.IOException;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.RandomAccessFile;

public class AcessoAleatorio {
  public static void main(String[] args) {
    Livro l1 = new Livro(1, "Eu, Robô", "Isaac Asimov", 14.90F);
    Livro l2 = new Livro(2, "Eu Sou a Lenda", "Richard Matheson", 21.99F);

    RandomAccessFile arq;
    byte[] ba;

    try {

      // ESCRITA
      arq = new RandomAccessFile("dados/livros.db", "rw");

      long pos1 = arq.getFilePointer();
      ba = l1.toByteArray();
      arq.writeInt(ba.length);
      arq.write(ba);

      long pos2 = arq.getFilePointer();
      ba = l2.toByteArray();
      arq.writeInt(ba.length);
      arq.write(ba);

      // LEITURA
      Livro l3 = new Livro();
      Livro l4 = new Livro();
      int tam;

      arq.seek(pos2);
      tam = arq.readInt();
      ba = new byte[tam];
      arq.read(ba);
      l3.fromByteArray(ba);

      arq.seek(pos1);
      tam = arq.readInt();
      ba = new byte[tam];
      arq.read(ba);
      l4.fromByteArray(ba);

      System.out.println(l3);
      System.out.println(l4);

      arq.close();

    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}

class Livro {
    protected int idLivro;
    protected String titulo;
    protected String autor;
    protected float preco;
  
    public Livro(int i, String t, String a, float p) {
      this.idLivro = i;
      this.titulo = t;
      this.autor = a;
      this.preco = p;
    }
  
    public Livro() {
      this.idLivro = -1;
      this.titulo = "";
      this.autor = "";
      this.preco = 0F;
    }
  
    public String toString() {
      DecimalFormat df = new DecimalFormat("#,##0.00");
  
      return "\nID....: " + this.idLivro + "\nTítulo: " + this.titulo + "\nAutor.: " + this.autor + "\nPreço.: R$ "
          + df.format(this.preco);
    }
  
    public byte[] toByteArray() throws IOException {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      DataOutputStream dos = new DataOutputStream(baos);
      dos.writeInt(idLivro);
      dos.writeUTF(titulo);
      dos.writeUTF(autor);
      dos.writeFloat(preco);
      return baos.toByteArray();
    }
  
    public void fromByteArray(byte[] ba) throws IOException {
      ByteArrayInputStream bais = new ByteArrayInputStream(ba);
      DataInputStream dis = new DataInputStream(bais);
      idLivro = dis.readInt();
      titulo = dis.readUTF();
      autor = dis.readUTF();
      preco = dis.readFloat();
    }
  
  }