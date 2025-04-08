import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class tp3q01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String input_string;
        int input_int = 0;

        // Ler o CSV, e passar tudo para uma List
        List<Pokemon> pokemons = ReadCsv.readAllFile("/tmp/pokemon.csv");

        // List que iremos adicionar apenas os selecionados da entrada, para trabalhar só com eles
        Lista lista = new Lista();

        // Ler até FIM e procurar por ID, e adicionar na List
        while (!(input_string = sc.nextLine()).equals("FIM")) {
            input_int = Integer.parseInt(input_string);
            Pokemon found = PokemonSearch.searchPokemonId(pokemons, input_int);
            if (found != null) {
                lista.InserirFim(found);
            }
        }

        int qnt = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < qnt; i++) {
            String comando = sc.nextLine();
            Scanner lineScanner = new Scanner(comando);
            String prefixo = lineScanner.next();
            int num = -1;
            if(lineScanner.hasNextInt()) {
                num = lineScanner.nextInt();
            }
            int num2 = -1;
            if(lineScanner.hasNextInt()) {
                num2 = lineScanner.nextInt();    
            }
            if(prefixo.equals("II")){
                Pokemon found = PokemonSearch.searchPokemonId(pokemons, num);
                lista.InserirInicio(found);
            } else if(prefixo.equals("IF")) {
                Pokemon found = PokemonSearch.searchPokemonId(pokemons, num);
                lista.InserirFim(found);
            } else if(prefixo.equals("I*")) {
                Pokemon found = PokemonSearch.searchPokemonId(pokemons, num2);
                lista.Inserir(found, num);
            } else if(prefixo.equals("RI")){
                Pokemon found = lista.RemoverInicio();
                System.out.println("(R) " + found.getName());
            } else if(prefixo.equals("RF")) {
                Pokemon found = lista.RemoverFim();
                System.out.println("(R) " + found.getName());
            } else if(prefixo.equals("R*")) {
                Pokemon found = lista.Remover(num);
                System.out.println("(R) " + found.getName());
            }
        }

        sc.close();
        lista.Mostrar();
    }
}

class Pokemon {
    // Atributos privados
    private int id;
    private int generation;
    private String name;
    private String description;
    private ArrayList<String> types;
    private ArrayList<String> abilities;
    private double weight;
    private double height;
    private int captureRate;
    private boolean isLegendary;
    private Date captureDate;

    // Construtores
    public Pokemon() {
        this.id = 0;
        this.generation = 0;
        this.name = "";
        this.description = "";
        this.types = new ArrayList<>();
        this.abilities = new ArrayList<>();
        this.weight = 0.0;
        this.height = 0.0;
        this.captureRate = 0;
        this.isLegendary = false;
        this.captureDate = new Date();
    }

    public Pokemon(String[] aux) throws Exception {
        for (int i = 0; i < aux.length; i++) if (aux[i].isEmpty()) aux[i] = "0";
        this.id = Integer.parseInt(aux[0]);
        this.generation = Integer.parseInt(aux[1]);
        this.name = aux[2];
        this.description = aux[3];

        this.types = new ArrayList<>();
        aux[4] = "'" + aux[4] + "'";
        this.types.add(aux[4]);
        if (!aux[5].equals("0")) {
            aux[5] = "'" + aux[5].trim() + "'";
            this.types.add(aux[5]);
        }

        aux[6] = aux[6].replace("\"", "").replace("[", "").replace("]", "");
        String[] tmp = aux[6].split(",");
        this.abilities = new ArrayList<>();
        for (String s : tmp) abilities.add(s.trim());

        this.weight = Double.parseDouble(aux[7]);
        this.height = Double.parseDouble(aux[8]);
        this.captureRate = Integer.parseInt(aux[9]);
        this.isLegendary = aux[10].equals("1");

        if (aux[11].isEmpty()) {
            this.captureDate = null;
        } else {
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            this.captureDate = inputDateFormat.parse(aux[11]);
        }
    }

    // Métodos Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getGeneration() { return generation; }
    public void setGeneration(int generation) { this.generation = generation; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public ArrayList<String> getTypes() { return types; }
    public void setTypes(ArrayList<String> types) { this.types = types; }

    public ArrayList<String> getAbilities() { return abilities; }
    public void setAbilities(ArrayList<String> abilities) { this.abilities = abilities; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public double getHeight() { return height; }
    public void setHeight(double height) { this.height = height; }

    public int getCaptureRate() { return captureRate; }
    public void setCaptureRate(int captureRate) { this.captureRate = captureRate; }

    public boolean getIsLegendary() { return isLegendary; }
    public void setIsLegendary(boolean isLegendary) { this.isLegendary = isLegendary; }

    public Date getCaptureDate() { return captureDate; }
    public void setCaptureDate(Date captureDate) { this.captureDate = captureDate; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pokemon pokemon = (Pokemon) obj;
        return id == pokemon.id && name.equalsIgnoreCase(pokemon.name);
    }

    // Método clone
    public Pokemon clone() {
        try {
            return (Pokemon) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not supported.");
            return null;
        }
    }

    // Método para imprimir todos atributos da instancia apenas chamando ela no SOP
    @Override
    public String toString() {
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = (captureDate != null) ? outputDateFormat.format(captureDate) : "Data não disponível";
        return "[#" + id + " -> " + name + ": " + description +
            " - " + types + " - " + abilities + 
            " - " + weight + "kg - " + height + "m - " +
            captureRate + "% - " + isLegendary + 
            " - " + generation + " gen] - " + formattedDate;
    }
}

class PokemonSearch {
    public static Pokemon searchPokemonId(List<Pokemon> pokemons, int id) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getId() == id) {
                return pokemon;
            }
        }
        return null;
    }

    public static Pokemon searchPokemonName(List<Pokemon> pokemons, String name) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getName().equalsIgnoreCase(name)) {
                return pokemon;
            }
        }
        return null;
    }
}

class ReadCsv {
    public static List<Pokemon> readAllFile(final String fileToRead) {
        List<Pokemon> pokemon = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileToRead));
            br.readLine();
            String linha;
            while ((linha = br.readLine()) != null) {
                linha = lineFormat(linha);
                Pokemon pessoa = new Pokemon(linha.split(";"));
                pokemon.add(pessoa);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            pokemon = null;
        }

        return pokemon;
    }

    private static String lineFormat(String line) {
        char[] array_aux = line.toCharArray();
        boolean in_list = false;
        for (int i = 0; i < array_aux.length; i++) {
            if (!in_list && array_aux[i] == ',') array_aux[i] = ';';
            else if (array_aux[i] == '"') in_list = !in_list;
        }
        return new String(array_aux);
    }
}

class Lista { 
    Pokemon[] array;
    int n;

    //Construtores 
    Lista() {
        array = new Pokemon[802];
        n = 0;
    }

    Lista (int tamanho) {
        array = new Pokemon[tamanho];
        n = 0;
    }

    //Metodos 
    void InserirInicio(Pokemon x) {
        if(n >= array.length) {
            System.out.println("Erro");
        }

        for(int i = n; i > 0; i--) {
            array[i] = array[i-1];
        }

        array[0] = x;
        n++;
    }

    void InserirFim(Pokemon x) {
        if(n >= array.length) {
            System.out.println("Erro");
        }

        array[n] = x;
        n++;
    }

    void Inserir(Pokemon x, int pos) {
        if(n >= array.length) {
            System.out.println("Erro");
        }

        for(int i = n; i > pos; i--) {
            array[i] = array[i-1];
        }

        array[pos] = x;
        n++;
    }

    Pokemon RemoverInicio() {
        if(n == 0) {
            System.out.println("Erro");
        }

        Pokemon resp = array[0];
        n--;

        for(int i = 0; i < n; i++) {
            array[i] = array[i+1];
        }

        return resp;
    }

    Pokemon RemoverFim() {
        if(n == 0) {
            System.out.println("Erro");
        }

        return array[--n];
    }

    Pokemon Remover(int pos) {
        if(n == 0 || pos < 0 || pos > n) {
            System.out.println("Erro");
        }

        Pokemon resp = array[pos];
        n--;

        for(int i = pos; i < n; i++) {
            array[i] = array[i+1];
        }

        return resp;
    }

    void Mostrar() {
        int cont = 0;
        for(int i = 0; i < n; i++) {
            System.out.println("[" + cont +"] " + array[i]);
            cont++;
        }
    }
}