import java.util.Scanner;
import java.io.File;

/**
 *
 *      Arquivo que foi enviado no Verde
 *
 **/

class Jogador {
    private int id;
    private int altura;
    private int peso;
    private int anoDeNascimento;
    private String nome;
    private String universidade;
    private String cidadeNascimento;
    private String estadoNascimento;


    public Jogador(int id, String nome, int altura, int peso, int anoDeNascimento, String universidade, String cidadeNascimento, String estadoNascimento){
        this.id = id;
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.anoDeNascimento = anoDeNascimento;
        this.universidade = universidade.equals("") ? "nao informado" : universidade;
        this.cidadeNascimento = cidadeNascimento.equals("") ? "nao informado" : cidadeNascimento;
        this.estadoNascimento = estadoNascimento.equals("") ? "nao informado" : estadoNascimento;
    }
    public Jogador(int id, String nome){
        this.id = id;
        this.nome = nome;

        this.altura = 0;
        this.peso = 0;
        this.anoDeNascimento = 0;
        this.universidade = "nao informado";
        this.cidadeNascimento = "nao informado";
        this.estadoNascimento = "nao informado";
    }
    public void setID(int id){
        this.id = id;
    }
    public void setAltura(int altura){
        this.altura = altura;
    }
    public void setPeso(int peso){
        this.peso = peso;
    }
    public void setAnoDeNascimento(int anoDeNascimento){
        this.anoDeNascimento = anoDeNascimento;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setUniversidade(String universidade){
        if(universidade.equals(""))
            this.universidade = "nao informado";
        else
            this.universidade = universidade;
    }

    public void setCidadeNascimento(String cidadeNascimento){
        if(cidadeNascimento.equals(""))
            this.cidadeNascimento = "nao informado";
        else
            this.cidadeNascimento = cidadeNascimento;
    }
    public void setEstadoNascimento(String estadoNascimento){
        if(estadoNascimento.equals(""))
            this.estadoNascimento = "nao informado";
        else
            this.estadoNascimento = estadoNascimento;    }

    public int getID(){
        return this.id;
    }
    public int getAltura(){
        return this.altura;
    }
    public int getPeso(){
        return this.peso;
    }
    public int getAnoDeNascimento(){
        return this.anoDeNascimento;
    }
    public String getNome(){
        return this.nome;
    }
    public String getUniversidade(){
        return this.universidade;
    }
    public String getCidadeNascimento(){
        return this.cidadeNascimento;
    }
    public String getEstadoNascimento(){
        return this.estadoNascimento;
    }
    public Jogador clone(){
        return new Jogador(this.id, this.nome, this.altura, this.peso, this.anoDeNascimento, this.universidade, this.cidadeNascimento, this.estadoNascimento);
    }

    // modelo: [106 ## Walt Lautenbach ## 188 ## 83 ## 1922 ## University of Wisconsin ## nao informado ## nao informado]
    public void imprimir(){
        System.out.print("[");
        System.out.print(this.id + " ## ");
        System.out.print(this.nome + " ## ");
        System.out.print(this.altura + " ## ");
        System.out.print(this.peso + " ## ");
        System.out.print(this.anoDeNascimento + " ## ");
        System.out.print(this.universidade + " ## ");
        System.out.print(this.cidadeNascimento + " ## ");
        System.out.print(this.estadoNascimento);
        System.out.println("]");
    }

    public void imprimirBonito(){
        System.out.print("ID: " + this.id);
        System.out.print(" Nome: " + this.nome);
        System.out.print(" Altura: " + this.altura);
        System.out.print(" Peso: " + this.peso);
        System.out.print(" Ano de Nascimento: " + this.anoDeNascimento);
        System.out.print(" Universidade: " + this.universidade);
        System.out.print(" Cidade de Nascimento: " + this.cidadeNascimento);
        System.out.print(" Estado de Nascimento: " + this.estadoNascimento);
        System.out.println();
    }

    // método do classe, leitura da entrada padrão feita da seguinte maneira:
    // Jogador teste = Jogador.ler();
    public static Jogador ler(){
        Scanner sc = new Scanner(System.in);
        int n;
        String tmp;

        System.out.print("ID: ");
        n = sc.nextInt();
        System.out.print("Nome: ");
        tmp = sc.next();
        Jogador jogador = new Jogador(n, tmp);

        System.out.print("Altura: ");
        n = sc.nextInt();
        jogador.setAltura(n);

        System.out.print("Peso: ");
        n = sc.nextInt();
        jogador.setPeso(n);

        System.out.print("Ano de Nascimento: ");
        n = sc.nextInt();
        jogador.setAnoDeNascimento(n);

        System.out.print("Universidade: ");
        tmp = sc.next();
        jogador.setUniversidade(tmp);

        System.out.print("Cidade de Nascimento: ");
        tmp = sc.next();
        jogador.setCidadeNascimento(tmp);

        System.out.print("Estado de Nascimento: ");
        tmp = sc.next();
        jogador.setEstadoNascimento(tmp);

        sc.close();
        return jogador;
    }

    // Recebe uma linha de um arquivo .csv e devolve o endereço de memória de um objeto
    public static Jogador parse(String linha){
        String[] tmp = linha.split(",");

        String[] csv = new String[8]; // uma linha completa tem 8 atributos

        // prepara o array para ser "ideal"
        for(int i = 0; i < csv.length; i++){
            if(i > (tmp.length - 1))
                csv[i] = "";
            else
                csv[i] = tmp[i];
        }

        Jogador jogador = new Jogador(Integer.parseInt(csv[0]), csv[1]); // únicos atributos que tenho a certeza que irão existir

        // número ideal de atributos para Jogador
        jogador.setAltura(Integer.parseInt(csv[2]));
        jogador.setPeso(Integer.parseInt(csv[3]));
        jogador.setUniversidade(csv[4]);
        jogador.setAnoDeNascimento(Integer.parseInt(csv[5]));
        jogador.setCidadeNascimento(csv[6]);
        jogador.setEstadoNascimento(csv[7]);

        return jogador;
    }

}

public class Principal {
    public static boolean isFim(String str){
        return str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M' && str.length() == 3;
    }

    public static void main(String[] args){
        File arquivo_csv = new File("/tmp/players.csv");
        Scanner sc;
        Jogador[] jogadores = new Jogador[5000];

        // Carrega os objetos do arquivo /tmp/players.csv
        try{
            sc = new Scanner(arquivo_csv);
            sc.nextLine(); // remove a primeira linha do arquivo csv
            String linha = sc.nextLine();
            int i = 0;

            while(sc.hasNext()){
                jogadores[i] = Jogador.parse(linha);
                linha = sc.nextLine();
                i++;
            }
            sc.close();
        }
        catch(Exception e ){

        }

        try{
            sc = new Scanner(System.in);
            String linha = sc.next();
            int i = 0;

            while(!isFim(linha)){
                int id = Integer.parseInt(linha);
                Jogador jogador = jogadores[id].clone();
                jogador.imprimir();
                linha = sc.next();
            }

        }
        catch(Exception e){

        }
    }
}
