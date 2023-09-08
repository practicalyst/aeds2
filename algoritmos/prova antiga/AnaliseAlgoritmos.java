import java.util.Random;

/*

Questão sobre fundamentos de análise de algoritmos.

Prova antiga, a ideia é contar quantas multiplicações estão sendo feitas,
tanto no melhor, quanto no pior caso.

*/

class AnaliseAlgoritmos {
    static int N = 10; // quantidade de vezes que cada for vai rodar
    static int n = 256; // até onde cada for vai rodar

    // Função auxiliar - retorna logaritmo na base 2
    public static double log2(int numero){
        return (Math.log(numero) / Math.log(2));
    }

    public static void main(String[] args){
        System.out.printf("\tN: %d | n: %d\n", N, n);

        //questao1();
        questao2();
        //questao3();
        questao4();
        //questao5();
    }        

    public static void questao1(){
        System.out.printf("Questão 1\n");
        Random gerador = new Random();
        gerador.setSeed(4);

        for(int j = 0; j < N; j++){

            int mult = 0;
            
            for(int i = 4; i < n; i++){
                if(Math.abs(gerador.nextInt()) % 9 < 4){
                    //a *= 2; b *= 3; l *= 2;
                    mult += 3;
                }

                else if(Math.abs(gerador.nextInt()) % 9 == 5) {
                    //a *= 2; l *= 3;
                    mult += 2;
                } else if(Math.abs(gerador.nextInt()) % 9 > 5){
                    // a *= 2;
                    mult += 1;
                }


            }
            System.out.printf("Rodada %2d | Multiplicações: %5d \n", j + 1, mult);
        }
        System.out.printf("Teoria: theta(n-4) Melhor caso: %d \n", n - 4);
        System.out.printf("Teoria: theta(n-4) Caso Médio: %d \n", (((3*(n - 4)) + (n - 4)) / 2)); // na verdade é bem mais complexo que isso, mas vai servir
        System.out.printf("Teoria: theta(n-4) Pior caso: %d \n", 3 * (n - 4));
        System.out.printf("\n");
    }

    public static void questao2() {
        System.out.printf("Questão 2\n");
    
        for(int j = 0; j < N; j++){
            
            int mult = 0;

            for(int i = n; i >= 1; i = i >> 1) /*, a *= 2 */{
                mult += 1;
            }
            System.out.printf("Rodada %2d | Multiplicações: %5d \n", j + 1, mult);
        }
        // no exemplo com n = 1000, lg(1000) vai ser 9 e uns quebrados, afinal lg(1024) é 10 - o piso de lg(1000) será 9 igual ao lg(512)
        System.out.printf("Teoria: theta(lg(n) piso + 1) unico caso: %f \n", Math.floor(log2(n) + 1));
        System.out.printf("\n");
    }

    
    public static void questao3() {
        System.out.printf("Questão 3\n");

        for(int j = 0; j < N; j++){
            
            int mult = 0;

            for(int i = n - 2; i > 5; i-- /*, a *= 2 */) {
                mult += 1;
            }
            System.out.printf("Rodada %2d | Multiplicações: %5d \n", j + 1, mult);
        }
        System.out.printf("Teoria: theta(n - 2 - 5) unico caso: %d \n", n - 2 - 5);
        System.out.printf("\n");
    }

     public static void questao4() {
        System.out.printf("Questão 4\n");
        
        for(int j = 0; j < N; j++){
            
            int mult = 0;

            // somente por ser n-1, não vai ser lg(n) teto + 1 apenas, será função piso porque isso vai rodar uma vez menos
            for(int i = n - 1; i >= 1; i /= 2 /*, a *= 2 */) {
                mult += 1;
            }
            System.out.printf("Rodada %2d | Multiplicações: %5d \n", j + 1, mult);
        }
        System.out.printf("Teoria: theta(lg(n) teto) unico caso: %f \n", Math.ceil(log2(n)));
        System.out.printf("Log2(n) = %f\n", log2(n));
        System.out.printf("\n");
    }

       public static void questao5() {
        System.out.printf("Questão 5\n");
        
        for(int j = 0; j < N; j++){
            
            int mult = 0;

            for(int x = 0; x < n; x++){
                for(int y = 0; y < n - 1; y++){
                    // l = a * 2 + b * 5;
                    mult += 2;
                }
            }

            System.out.printf("Rodada %2d | Multiplicações: %5d \n", j + 1, mult);
        }
        System.out.printf("Teoria: theta(n(n-1)) unico caso: %d \n", 2 * n * (n - 1));
        System.out.printf("\n");
    }


}