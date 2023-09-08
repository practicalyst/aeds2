class Fila {
    private int primeiro; // gerencia remoções
    private int ultimo; // gerencia inserções
    private int [] array;


    // cria uma fila com um espaço a mais para economizar um if
    public Fila(int n){
        array = new int[n + 1];
        primeiro = 0; // so pra ficar evidente que os valores iniciais precisam ser iguais
        ultimo = 0;

        System.out.println("Criando uma fila circular com 10 espaços.");
    }

    public Fila(){
        this(10);
    }

    public void inserir(int elemento) throws Exception {
        if((ultimo + 1) % array.length == primeiro){
            throw new Exception("Fila completamente cheia!");
        }

        array[ultimo] = elemento;
        ultimo = (ultimo + 1) % array.length;
    }

    public int remover() throws Exception {
        if(primeiro == ultimo){
            throw new Exception("Fila vazia!");
        }
        int resp = array[primeiro];
        primeiro = (primeiro + 1) % array.length; // apaga o elemento logicamente
        return resp;
    }

    public void mostrar() {
        int i = primeiro;
        
        System.out.print("[ ");
        while(i != ultimo){
            System.out.print(array[i] + " ");
            i = (i + 1) % array.length;
        }
        System.out.println(" ]");
    }



}