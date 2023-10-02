import java.io.FileWriter;
import java.io.PrintWriter;

class Fila {
    private Jogador jogadores[]; 
    private int qtdElementosTotal; // armazena a quantidade de elementos que a fila terá
    private int n;

    public Fila(int n){
        jogadores = new Jogador[n]; 
        qtdElementosTotal = n;
        this.n = 0;
    }
    
    public void add(Jogador jogador){
        if(n == qtdElementosTotal){
            System.out.println("Erro! Fila cheia.");
        }
        else{
            jogadores[n] = jogador;
            n++;
        }
    }

    public Jogador getJogador(int i){
        return this.jogadores[i];
    }

    public void printJogador(int i){
        if(i >= n || i < 0){
            System.out.println("Elemento inexistente!");
        }
        else{
            jogadores[i].imprimir();
        }
    }   

    // Cria o arquivo matrícula_sequencial.txt
    public static void log(String nomeArquivo,String matricula, long tempo, int cmp){
        try{
            FileWriter log = new FileWriter(nomeArquivo);
            PrintWriter gravarLog = new PrintWriter(log);

            gravarLog.printf("%s\t%d\t%d%n", matricula, tempo, cmp);
            log.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }   

    public static void log(String nomeArquivo,String matricula, long tempo, int cmp, int mov){
        try{
            FileWriter log = new FileWriter(nomeArquivo);
            PrintWriter gravarLog = new PrintWriter(log);

            gravarLog.printf("%s\t%d\t%d\t%d%n", matricula, cmp, mov, tempo);
            log.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }   


    public int length(){
        return n;
    }

    public int maxFila(){
        return qtdElementosTotal;
    }

    // retorna o número de comparações
    public int pesquisaSequencial(String nome){
        int cmp = 0;
        for(int i = 0; i < n; i++){
            cmp += 1;
            if(jogadores[i].getNome().equals(nome)){
                System.out.println("SIM");
                return cmp;
            }            
        }
        System.out.println("NAO");
        
        return cmp;
    }

    public void sortSelecao(){
        int mov = 0;
        int cmp = 0;

        long tempoInicial = System.currentTimeMillis();

        for(int i = 0; i < (n - 1); i++){
            int menor = i;

            for(int j = (i + 1); j < n; j++){
                // se for menor que zero, significa que jogadores[j] é alfabeticamente menor que jogadores[i]
                if(jogadores[j].getNome().compareTo(jogadores[menor].getNome()) < 0){
                    menor = j;
                }
                cmp += 1;
            }
            
            Jogador temp = jogadores[i];
            jogadores[i] = jogadores[menor];
            jogadores[menor] = temp;
            mov += 3;
        }    

        long tempoFinal = System.currentTimeMillis();
        long tempo = tempoFinal - tempoInicial;

        log("matrícula_selecao.txt","790871", tempo, cmp, mov);
    }

} 