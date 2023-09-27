class Pilha {
    private Celula topo;

    public Pilha(){
        topo = null;
    }

    Pilha(int n){
        topo.prox = null;
    }

    public void inserir(int n){
        Celula tmp = new Celula(n); // cria um ponteiro e lhe atribui um endereço de memória
        tmp.prox = topo; 
        topo = tmp;
        tmp = null;
    }

    // lembre-se que na pilha, o último a entrar é o primeiro a sair
    public int remover(){
        int n = 0;
        if(topo == null)
            System.out.println("Erro, pilha vazia!");
        
        else{
            n = topo.elemento;
            Celula tmp = topo;        
            topo = topo.prox;
            tmp.prox = null;
            tmp = null;
        }

        return n;
    }

    public void mostrar(){
        System.out.print("[ ");
        mostrar(topo);
        System.out.println("]");
    }

    public void mostrar(Celula i){
        if(i != null){
            mostrar(i.prox);
            System.out.print(i.elemento + " ");
        }
    }

}
