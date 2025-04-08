import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class tp2q01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String entradaStr = "";
        int entradaInt = 0;

        // Ler o CSV e passar tudo para uma Lista
        List<Pokemon> listaPokemons = CsvReader.lerArquivo("/tmp/pokemon.csv");

        // Lista onde adicionaremos apenas os selecionados da entrada
        List<Pokemon> pokemonsUsados = new ArrayList<>();

        // Ler até "FIM", procurar pelo ID e adicionar na lista
        while (!(entradaStr = scanner.nextLine()).equals("FIM")) {
            entradaInt = Integer.parseInt(entradaStr);
            pokemonsUsados.add(BuscaPokemon.buscarPorId(listaPokemons, entradaInt));
        }

        // Imprimir cada instância da lista
        for (Pokemon p : pokemonsUsados) {
            System.out.println(p);
        }

        scanner.close();
    }
}

class Pokemon {
    // Atributos privados
    private int id;
    private int geracao;
    private String nome;
    private String descricao;
    private ArrayList<String> tipos;
    private ArrayList<String> habilidades;
    private double peso;
    private double altura;
    private int taxaCaptura;
    private boolean lendario;
    private Date dataCaptura;

    // Construtores
    public Pokemon() {
        this.id = 0;
        this.geracao = 0;
        this.nome = "";
        this.descricao = "";
        this.tipos = new ArrayList<>();
        this.habilidades = new ArrayList<>();
        this.peso = 0.0;
        this.altura = 0.0;
        this.taxaCaptura = 0;
        this.lendario = false;
        this.dataCaptura = new Date();
    }

    public Pokemon(int id, int geracao, String nome, String descricao, ArrayList<String> tipos,
                   ArrayList<String> habilidades, double peso, double altura, int taxaCaptura,
                   boolean lendario, Date dataCaptura) {
        this.id = id;
        this.geracao = geracao;
        this.nome = nome;
        this.descricao = descricao;
        this.tipos = tipos;
        this.habilidades = habilidades;
        this.peso = peso;
        this.altura = altura;
        this.taxaCaptura = taxaCaptura;
        this.lendario = lendario;
        this.dataCaptura = dataCaptura;
    }

    // Recebe um array com cada coluna e define os valores
    public Pokemon(String[] atributos) throws Exception {
        // Setar todos os atributos vazios como "0" para evitar problemas de parsing
        for (int i = 0; i < atributos.length; i++) {
            if (atributos[i].isEmpty()) {
                atributos[i] = "0";
            }
        }

        // Setar os atributos
        this.id = Integer.parseInt(atributos[0]);
        this.geracao = Integer.parseInt(atributos[1]);
        this.nome = atributos[2];
        this.descricao = atributos[3];

        // Verificar tipos, pois há pokémons com 1 ou 2 tipos
        this.tipos = new ArrayList<>();
        atributos[4] = "'" + atributos[4] + "'";
        this.tipos.add(atributos[4]);
        if (!atributos[5].equals("0")) {
            atributos[5] = "'" + atributos[5].trim() + "'";
            this.tipos.add(atributos[5]);
        }

        // Formatar a string de habilidades
        atributos[6] = atributos[6].replace("\"", "").replace("[", "").replace("]", "");
        String[] habilidadesAux = atributos[6].split(",");
        this.habilidades = new ArrayList<>();
        for (String hab : habilidadesAux) {
            this.habilidades.add(hab.trim());
        }

        this.peso = Double.parseDouble(atributos[7]);
        this.altura = Double.parseDouble(atributos[8]);
        this.taxaCaptura = Integer.parseInt(atributos[9]);
        this.lendario = atributos[10].equals("1");

        if (atributos[11].isEmpty()) {
            this.dataCaptura = null;
        } else {
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            this.dataCaptura = formatoData.parse(atributos[11]);
        }
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getGeracao() { return geracao; }
    public void setGeracao(int geracao) { this.geracao = geracao; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public ArrayList<String> getTipos() { return tipos; }
    public void setTipos(ArrayList<String> tipos) { this.tipos = tipos; }

    public ArrayList<String> getHabilidades() { return habilidades; }
    public void setHabilidades(ArrayList<String> habilidades) { this.habilidades = habilidades; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public double getAltura() { return altura; }
    public void setAltura(double altura) { this.altura = altura; }

    public int getTaxaCaptura() { return taxaCaptura; }
    public void setTaxaCaptura(int taxaCaptura) { this.taxaCaptura = taxaCaptura; }

    public boolean isLendario() { return lendario; }
    public void setLendario(boolean lendario) { this.lendario = lendario; }

    public Date getDataCaptura() { return dataCaptura; }
    public void setDataCaptura(Date dataCaptura) { this.dataCaptura = dataCaptura; }

    // Método clone
    public Pokemon clonar() {
        try {
            return (Pokemon) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Clonagem não suportada.");
            return null;
        }
    }

    // Método para imprimir todos os atributos da instância
    public String toString() {
        SimpleDateFormat formatoSaidaData = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = (dataCaptura != null) ? formatoSaidaData.format(dataCaptura) : "Data não disponível";

        return "[#" + id + " -> " + nome + ": " + descricao +
            " - " + tipos + " - " + habilidades +
            " - " + peso + "kg - " + altura + "m - " +
            taxaCaptura + "% - " + lendario +
            " - " + geracao + " gen] - " + dataFormatada;
    }
}

class BuscaPokemon {
    // Função estática que busca um Pokémon pelo ID
    public static Pokemon buscarPorId(List<Pokemon> lista, int id) {
        for (Pokemon pokemon : lista) {
            if (pokemon.getId() == id) {
                return pokemon;
            }
        }
        return null;
    }
}

class CsvReader {
    public static List<Pokemon> lerArquivo(final String arquivo) {
        List<Pokemon> pokemons = new ArrayList<>();

        try {
            BufferedReader leitor = new BufferedReader(new FileReader(arquivo));

            // Ignorar o cabeçalho
            leitor.readLine();

            // Ler linha por linha
            String linha = "";
            while ((linha = leitor.readLine()) != null) {
                linha = formatarLinha(linha);

                // Criar instância e adicionar à lista
                Pokemon p = new Pokemon(linha.split(";"));
                pokemons.add(p);
            }

            leitor.close();
        } catch (Exception e) {
            e.printStackTrace();
            pokemons = null;
        }

        // Retornar lista com todos os pokémons
        return pokemons;
    }

    // Substituir todas as vírgulas por ponto e vírgula, exceto as dentro de colchetes
    private static String formatarLinha(String linha) {
        char[] arrayAux = linha.toCharArray();
        boolean dentroLista = false;
        for (int i = 0; i < arrayAux.length; i++) {
            if (!dentroLista && arrayAux[i] == ',') {
                arrayAux[i] = ';';
            } else if (arrayAux[i] == '"') {
                dentroLista = !dentroLista;
            }
        }
        return new String(arrayAux);
    }
}
