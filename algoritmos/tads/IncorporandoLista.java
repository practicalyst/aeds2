class IncorporandoLista {
    public static void main(String[] args){
        Lista lista = new Lista(10);

        try{
            lista.mostrar();
            // [ ]

            lista.inserirFim(10);
            lista.inserirFim(15);
            lista.inserirFim(20);
            lista.mostrar();
            // [10, 15, 20]

            lista.inserirInicio(1);
            lista.inserirInicio(2);
            lista.inserirInicio(3);
            lista.mostrar();
            // [3, 2, 1, 10, 15, 20]

            lista.inserir(4,4);
            lista.mostrar();
            // [3, 2, 1, 10, 4, 15, 20]

            lista.removeFim();
            lista.removeInicio();
            lista.mostrar();
            // [2, 1, 10, 4, 15]

            lista.remove(2);
            lista.mostrar();
            // [2, 1, 4, 15]

            lista.removeFim();
            lista.removeInicio();
            lista.removeFim();
            lista.removeInicio();
            lista.mostrar();
            // [ ]

        }catch(Exception e){ e.printStackTrace();}
    }   


}