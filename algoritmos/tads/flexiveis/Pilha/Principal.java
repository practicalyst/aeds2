
class Principal {    
    public static void main(String[] args){
        System.out.println("Teste de Pilha!");

        Pilha pilha = new Pilha();

        System.out.println("Inserindo 10");
        pilha.inserir(10);

        System.out.println("Inserindo 12");
        pilha.inserir(12);

        System.out.println("Inserindo 4");
        pilha.inserir(4);

        System.out.println("Inserindo 9231");
        pilha.inserir(9231);

        System.out.println("Mostrando elementos da pilha...");
        pilha.mostrar();

        System.out.println("Inserindo 1");
        pilha.inserir(1);

        System.out.println("Inserindo 2");
        pilha.inserir(2);

        System.out.println("Inserindo 3");
        pilha.inserir(3);

        System.out.println("Inserindo 100");
        pilha.inserir(100);

        System.out.println("Mostrando elementos da pilha...");
        pilha.mostrar();

        System.out.println("Removendo elemento");
        pilha.remover();

        System.out.println("Removendo elemento");
        pilha.remover();

        System.out.println("Removendo elemento");
        pilha.remover();

        System.out.println("Removendo elemento");
        pilha.remover();

        System.out.println("Removendo elemento");
        pilha.remover();

        System.out.println("Mostrando elementos da pilha...");
        pilha.mostrar();
    }

}