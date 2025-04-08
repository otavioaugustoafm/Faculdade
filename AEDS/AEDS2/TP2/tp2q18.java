import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class Pokemon {
    // atributos
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

    // MÉTODOS

    // Construtor

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
        this.isLegendary = true;
        this.captureDate = null;
    }

    public Pokemon(int id, int generation, String name, String description, ArrayList<String> types,
            ArrayList<String> abilities, double weight, double height, int captureRate,
            boolean isLegendary, Date captureDate) {
        this.id = id;
        this.generation = generation;
        this.name = name;
        this.description = description;
        this.types = types;
        this.abilities = abilities;
        this.weight = weight;
        this.height = height;
        this.captureRate = captureRate;
        this.isLegendary = isLegendary;
        this.captureDate = captureDate;
    }

    public Pokemon(String[] infos) throws Exception {
        for (int i = 0; i < infos.length; i++)
            if (infos[i].isEmpty())
                infos[i] = "0";
        this.id = Integer.parseInt(infos[0]);
        this.generation = Integer.parseInt(infos[1]);
        this.name = infos[2];
        this.description = infos[3];
        this.types = new ArrayList<>();
        infos[4] = "'" + infos[4] + "'";
        this.types.add(infos[4]);
        if (!infos[5].equals("0")) {
            infos[5] = "'" + infos[5].trim() + "'";
            this.types.add(infos[5]);
        }
        infos[6] = infos[6].replace("\"", "");
        infos[6] = infos[6].replace("[", "");
        infos[6] = infos[6].replace("]", "");
        String[] tmp = infos[6].split(",");
        this.abilities = new ArrayList<>();
        for (String s : tmp)
            abilities.add(s.trim());
        this.weight = Double.parseDouble(infos[7]);
        this.height = Double.parseDouble(infos[8]);
        this.captureRate = Integer.parseInt(infos[9]);
        this.isLegendary = infos[10].equals("1");
        if (infos[11].isEmpty()) {
            this.captureDate = null;
        } else {
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            this.captureDate = inputDateFormat.parse(infos[11]);
        }
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types != null ? types : new ArrayList<>();
    }

    public ArrayList<String> getAbilities() {
        return abilities;
    }

    public void setAbilities(ArrayList<String> abilities) {
        this.abilities = abilities != null ? abilities : new ArrayList<>();
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getCaptureRate() {
        return captureRate;
    }

    public void setCaptureRate(int captureRate) {
        this.captureRate = captureRate;
    }

    public boolean isLegendary() {
        return isLegendary;
    }

    public void setLegendary(boolean isLegendary) {
        this.isLegendary = isLegendary;
    }

    public Date getCaptureDate() {
        return captureDate;
    }

    // leitura do csv
    public ArrayList<Pokemon> Ler() {
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        String csvFile = "/tmp/pokemon.csv";
        String linha;

        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            br.readLine(); 

            while ((linha = br.readLine()) != null) {
                if (linha.equals("FIM")) {
                    break;
                }

                linha = formatar(linha);

                Pokemon pokemon = new Pokemon(linha.split(";"));
                pokemons.add(pokemon);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pokemons;
    }

    // imprimir
    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = (captureDate != null) ? formatter.format(captureDate) : "Data não disponível";
        return "[#" + id + " -> " + name + ": " + description +
                " - " + types + " - " + abilities +
                " - " + weight + "kg - " + height + "m - " +
                captureRate + "% - " + isLegendary +
                " - " + generation + " gen] - " + formattedDate;
    }

}

public class tp2q18 {
    public static void main(String[] args) {
        Pokemon pokemonManager = new Pokemon();
        
        ArrayList<Pokemon> pokemons = pokemonManager.Ler();
        ArrayList<Pokemon> pokemonsOrdenados = new ArrayList<>();

        if (pokemons.isEmpty()) {
            System.out.println("Nenhum Pokémon encontrado.");
        } else {
            searchPokemonId(pokemons, pokemonsOrdenados);
            
            long startTime = System.nanoTime();
            int[] stats = ordenar(pokemonsOrdenados, 0, pokemonsOrdenados.size()-1);
            long endTime = System.nanoTime();
            
            long executionTime = endTime - startTime;
            logResults("848122", stats[0], stats[1], executionTime);
            
            for(int i = 0; i < 10; i++) {
                System.out.println(pokemonsOrdenados.get(i));
            }
        }
    }

    // ordenar 
    public static int[] ordenar(ArrayList<Pokemon> pokemons, int esq, int dir) {
        int comparacoes = 0; // Contador de comparações
        int movimentacoes = 0; // Contador de movimentações
        if (esq < dir) {
            int i = esq;
            int j = dir;
            Pokemon pivo = pokemons.get((esq + dir) / 2);
    
            while (i <= j) {
                while ((pokemons.get(i).getGeneration() < pivo.getGeneration()) ||
                       (pokemons.get(i).getGeneration() == pivo.getGeneration() && 
                        pokemons.get(i).getName().compareTo(pivo.getName()) < 0)) {
                    i++;
                    comparacoes++; // Incrementa a contagem de comparações
                }
                while ((pokemons.get(j).getGeneration() > pivo.getGeneration()) ||
                       (pokemons.get(j).getGeneration() == pivo.getGeneration() && 
                        pokemons.get(j).getName().compareTo(pivo.getName()) > 0)) {
                    j--;
                    comparacoes++; // Incrementa a contagem de comparações
                }
                if (i <= j) {
                    // Troca
                    Pokemon temp = pokemons.get(i);
                    pokemons.set(i, pokemons.get(j));
                    pokemons.set(j, temp);
                    movimentacoes += 2; // Duas movimentações (um para cada Pokémon)
                    i++;
                    j--;
                }
            }
            // Recursão
            int[] statsLeft = ordenar(pokemons, esq, j);
            int[] statsRight = ordenar(pokemons, i, dir);
            comparacoes += statsLeft[0] + statsRight[0]; // Soma as comparações das chamadas recursivas
            movimentacoes += statsLeft[1] + statsRight[1]; // Soma as movimentações das chamadas recursivas
        }
        return new int[]{comparacoes, movimentacoes};
    }
    
    // aqui está lendo a entrada e achando o pokemon
    public static void searchPokemonId(ArrayList<Pokemon> pokemons, ArrayList<Pokemon> pokemonsOrdenados) {
        Scanner sc = new Scanner(System.in);
        String resp;
        while (!(resp = sc.nextLine()).equals("FIM")) {
            int id = Integer.parseInt(resp);
            for (Pokemon pokemon : pokemons) {
                if (pokemon.getId() == id) {
                    pokemonsOrdenados.add(pokemon);
                }
            }
        }
        sc.close();
    }
    
    // Método para gravar o log
    public static void logResults(String matricula, int comparacoes, int movimentacoes, long executionTime) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("848122_QuickParcial.txt"))) {
            writer.write(matricula + "\t" + comparacoes + "\t" + movimentacoes + "\t" + executionTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}