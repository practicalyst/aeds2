
class Pilha {
    private int n;
    private int [] array;

    public Pilha(int n){
        array = new int[n + 1];
        this.n = 0;

        System.out.println("Pilha criada com " +  n + " espaços");        
    }

    public Pilha(){
        this(10);
    }
    
    public int pop() throws Exception{

        if(n <= 0){
            throw new Exception("Pilha vazia!");
        }

        return array[n--]; // apagando elemento logicamente
    }

    public void push(int elemento) throws Exception{
        
        if(n >= array.length){
            throw new Exception("Pilha lotada!");
        }

        array[n++] = elemento;
    }

    public void mostrar(){
        System.out.print("[ ");
        for(int i = 0; i < n; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("]");
    }

}