class IncorporandoFila {

    public static void main(String[] args){

        Fila fila = new Fila(6);


        try{
            fila.inserir(1);
            fila.inserir(3);
            fila.inserir(5);
            fila.inserir(7);
            fila.inserir(9);
            fila.remover();
            fila.remover();
            fila.inserir(4);
            fila.inserir(6);
            fila.remover();
            fila.inserir(8);
            fila.mostrar();
        }catch(Exception e) { e.printStackTrace(); }

    }


}