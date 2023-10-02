import java.util.Scanner;
import java.io.File;
import java.util.Date;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Principal {
    public static boolean isFim(String str){
        return str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M' && str.length() == 3;
    }

    // Cria o arquivo matrícula_sequencial.txt
    public static void log(String matricula, long tempo, int cmp){
        try{
            FileWriter log = new FileWriter("matrícula_sequencial.txt");
            PrintWriter gravarLog = new PrintWriter(log);

            gravarLog.printf("%s\t%d\t%d%n", matricula, tempo, cmp);
            log.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }   

    public static void main(String[] args){
        File arquivo_csv = new File("/tmp/players.csv");
        Scanner sc;
        Fila jogadores = new Fila(5000); // cria uma fila com no máximo 5000 jogadores
        Fila novosJogadores = new Fila(50);

        // Carrega os objetos do arquivo /tmp/players.csv
        try{
            sc = new Scanner(arquivo_csv);
            sc.nextLine(); // remove a primeira linha do arquivo csv
            String linha = sc.nextLine();
            int i = 0;

            while(sc.hasNext()){
                jogadores.add(Jogador.parse(linha));
                linha = sc.nextLine();
                i++;
            }
            sc.close();
        }
        catch(Exception e ){

        }
        // Fila carregada


        // Faz certas inserções na Fila
        try{
            sc = new Scanner(System.in);
            String linha = sc.nextLine();
            int i = 0;

            while(!isFim(linha)){
                int id = Integer.parseInt(linha);
                novosJogadores.add(jogadores.getJogador(id));
                //novosJogadores.printJogador(i);
                linha = sc.nextLine();
                i++;
            }
            
            
            // Verifica se aquele jogador está inserido na fila
            linha = sc.nextLine();
            i = 0;
            int cmp = 0;
            long tempoInicial = System.currentTimeMillis();

            while(!isFim(linha)){
                cmp += novosJogadores.pesquisaSequencial(linha);
                linha = sc.nextLine();
                i++;
            }
            
            long tempoFinal = System.currentTimeMillis();
            long diferencaTempo = tempoFinal - tempoInicial;

            log("xxxxxx", diferencaTempo, cmp);
            
            
        }
        catch(Exception e){

        } 
    }
}
