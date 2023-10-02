
class Fila {
    private Jogador jogadores[]; 
    private int qtdElementosTotal; // armazena a quantidade de elementos que a fila terá
    private int n;

    public Fila(int n){
        jogadores = new Jogador[n]; 
        qtdElementosTotal = n;
        n = 0;
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

} 