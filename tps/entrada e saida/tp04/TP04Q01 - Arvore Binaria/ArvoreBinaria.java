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


    public ArvoreBinaria(){
        this.raiz = null;
    }

    public void inserir(Jogador jogador){
        raiz = inserir(jogador, raiz);    
    }

    public No inserir(Jogador jogador, No i) {
        if (i == null) {
            i = new No(jogador);
        } else if (jogador.getNome().compareTo(i.jogador.getNome()) > 0) {
            i.dir = inserir(jogador, i.dir);
        } else if (jogador.getNome().compareTo(i.jogador.getNome()) < 0) {
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
            System.out.print("NAO");
            return;
        }

        if(i.jogador.getNome().compareTo(nome) == 0){
            System.out.print("SIM");
            return;
        }

        else if(i.jogador.getNome().compareTo(nome) < 0){
                System.out.print("dir ");
                pesquisar(nome, i.dir);
        }

        else if(i.jogador.getNome().compareTo(nome) > 0){
                System.out.print("esq ");
                pesquisar(nome, i.esq);
        }
    }
}   