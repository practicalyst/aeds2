/*  
        Lista Linear

        Pode inserir e remover elementos em qualquer posição
        Ao remover, levar todos os elementos para a 'esquerda'
        Ao inserir, levar todos os elementos para a 'direita'

        Inserir no fim e remover no fim é vantajoso
 */


class Lista {
    private int n; // Representa a quantidade de elementos presente na lista
    private int[] array;

    public Lista(int n){
        this.array = new int[n];
        this.n = 0; 
    }

    public Lista(){
        this(10);
    }
    
    public void inserirInicio(int elemento) throws Exception {
        if(n >= array.length){
            throw new Exception("Erro ao inserir! Lista cheia.");
        }

        // Leva os elementos para a "direita" da lista.
        for(int i = n ; i > 0; i--){
            array[i] = array[i - 1];
        }

        array[0] = elemento;
        n++;
    }

    public void inserirFim(int elemento) throws Exception {
        if(n >= array.length){
            throw new Exception("Erro ao inserir! Lista cheia.");
        }
        
        array[n] = elemento;
        n++;
    }
    
    public void inserir(int elemento, int pos) throws Exception {
        if(n >= array.length){
            throw new Exception("Erro ao inserir! Lista cheia.");
        }
        
        if(pos >= array.length || pos < 0){
            throw new Exception("Posição inexistente!");
        }
        
        // dessa forma para não perder nenhum valor
        for(int i = n; i > pos; i--)
            array[i] = array[i - 1];
        
        array[pos] = elemento;
        n++;
    }


    public int removeFim() throws Exception{
        
        if(n == 0){
            throw new Exception("Erro ao remover! Array vazio!");
        }

        return array[--n]; // Remove lógicamente o elemento, ele está no array fisicamente, mas não existe na variável que enxerga ele.
    }

    public int removeInicio() throws Exception{
        
        if(n == 0){
            throw new Exception("Erro ao remover! Array vazio!");
        }

        int aux = array[0];

        // traz os elementos pra "esquerda" da lista
        for(int i = 0; i < n; i++){
            array[i] = array[i + 1];
        }
        n--;
        return aux;
    }
    
    public int remove(int pos) throws Exception{
        int aux;

        if(pos >= array.length || pos < 0){
            throw new Exception("Posição inexistente! Erro ao remover.");
        }   
    
        aux = array[pos];

        for(int i = pos; i < n - 1; i++){
            array[i] = array[i + 1];
        }

        n--;
        return aux;
    
    }

    public void mostrar(){
        System.out.print("[ ");

        for(int i = 0; i < n; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("]");

    }
}