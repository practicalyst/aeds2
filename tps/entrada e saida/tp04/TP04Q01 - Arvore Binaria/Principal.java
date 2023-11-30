import java.util.Scanner;
import java.io.File;
import java.util.Date;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.util.Date;
import java.io.FileWriter;
import java.io.PrintWriter;

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
        this.setNome(nome);
        this.altura = altura;
        this.peso = peso;
        this.anoDeNascimento = anoDeNascimento;
        this.universidade = universidade.equals("") ? "nao informado" : universidade;
        this.cidadeNascimento = cidadeNascimento.equals("") ? "nao informado" : cidadeNascimento;
        this.estadoNascimento = estadoNascimento.equals("") ? "nao informado" : estadoNascimento;
    }
    public Jogador(int id, String nome){
        this.id = id;
        this.setNome(nome);

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
        if(nome.charAt(nome.length() - 1) == '*')
            nome = nome.substring(0, nome.length() - 1);
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
        // System.out.print("[");
        //System.out.print(this.id + " ## ");
        System.out.print(this.nome + " ## ");
        System.out.print(this.altura + " ## ");
        System.out.print(this.peso + " ## ");
        System.out.print(this.anoDeNascimento + " ## ");
        System.out.print(this.universidade + " ## ");
        System.out.print(this.cidadeNascimento + " ## ");
        System.out.println(this.estadoNascimento);
        // System.out.println("]");
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

class No {
    public Jogador jogador;
    public No esq; 
    public No dir;

    public No(Jogador jogador){
        this(jogador, null, null);
    }

    public No(Jogador jogador, No esq, No dir){
        this.jogador = jogador;
        this.esq = esq;
        this.dir = dir;
    }
}

class ArvoreBinaria {
    public No raiz;
    public int mov = 0;
    public int cmp = 0;


    public ArvoreBinaria(){
        this.raiz = null;
    }

    public void inserir(Jogador jogador){
        raiz = inserir(jogador, raiz);    
    }

    public No inserir(Jogador jogador, No i) {
        if (i == null) {
            cmp += 1;
            i = new No(jogador);
        } else if (jogador.getNome().compareTo(i.jogador.getNome()) > 0) {
            cmp += 1;
            mov += 1;
            i.dir = inserir(jogador, i.dir);
        } else if (jogador.getNome().compareTo(i.jogador.getNome()) < 0) {
            cmp += 1;
            mov += 1;
            i.esq = inserir(jogador, i.esq);
        } else {
            System.out.println("Erro ao inserir! Jogador com mesmo nome já existe.");
        }

        return i;
    }

    public void caminharPre(){
        caminharPre(raiz);
    }

    public void caminharPre(No i){
        if(i != null){
            cmp += 1;
            System.out.println(i.jogador.getNome());
            caminharPre(i.esq);
            caminharPre(i.dir);
        }
    }
    public void pesquisar(String nome){
        System.out.print("raiz ");
        pesquisar(nome, raiz);
        System.out.println();
    }
    public void pesquisar(String nome, No i){
        if(i == null){
            cmp += 1;
            System.out.print("NAO");
            return;
        }

        if(i.jogador.getNome().compareTo(nome) == 0){
            cmp += 1;
            System.out.print("SIM");
            return;
        }

        else if(i.jogador.getNome().compareTo(nome) < 0){
                cmp += 1;
                System.out.print("dir ");
                pesquisar(nome, i.dir);
        }

        else if(i.jogador.getNome().compareTo(nome) > 0){
                cmp += 1;
                System.out.print("esq ");
                pesquisar(nome, i.esq);
        }
    }


    public void log(String nomeArquivo, String matricula, long tempo){
        try{
            FileWriter log = new FileWriter(nomeArquivo);
            PrintWriter gravarLog = new PrintWriter(log);

            gravarLog.printf("%s\t%d\t%d\t%d%n", matricula, tempo, cmp, mov);
            log.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    } 
}   


class Principal {
    public static boolean isFim(String str){
        return str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M' && str.length() == 3;
    }

    public static void main(String[] args){
        File arquivo_csv = new File("/tmp/players.csv");
        Scanner sc;
        Jogador[] jogadores = new Jogador[5000];
        ArvoreBinaria novosJogadores = new ArvoreBinaria();

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
            String linha = sc.nextLine();
            int i = 0;

            while(!isFim(linha)){
                int id = Integer.parseInt(linha);
                Jogador jogador = jogadores[id].clone();
                novosJogadores.inserir(jogador);
                linha = sc.nextLine();
            }

            linha = sc.nextLine();
            long somaTempo = 0;

            while(!isFim(linha)){
                System.out.print(linha + " ");
                long tempoInicial = System.currentTimeMillis();
                novosJogadores.pesquisar(linha);
                long tempoFinal = System.currentTimeMillis() - tempoInicial;
                somaTempo += tempoFinal;

                linha = sc.nextLine();
            } 

            novosJogadores.log("790871_arvoreBinaria.txt", "790871", somaTempo);
            
            
        }
        catch(Exception e){

        }
    }
}
