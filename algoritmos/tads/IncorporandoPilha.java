
class IncorporandoPilha {

    public static void main(String[] args){
        
        Pilha pilha = new Pilha();

        try{
            pilha.push(1);
            pilha.push(2);
            pilha.push(3);
            pilha.push(4);
            pilha.push(5);
            pilha.mostrar();

            pilha.push(10);
            pilha.push(11);
            pilha.push(12);
            pilha.push(13);
            pilha.push(14);
            pilha.mostrar();

            pilha.pop();
            pilha.mostrar();

            pilha.pop();
            pilha.mostrar();

            pilha.pop();
            pilha.mostrar();

            pilha.pop();
            pilha.mostrar();
        }catch(Exception e) {e.printStackTrace();}

    }


}