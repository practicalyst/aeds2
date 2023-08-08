/*
 *
 * 	Repita o exercício acima considerando que os elementos do
 *	array estão ordenados de forma crescente. Uma sugestão
 *	seria começar a pesquisa pelo meio do array
 *
 */

// Implementação do algoritmo de pesquisa binária

class arrayInteirosOrdenados {
	
	public static boolean estaContido(int array[], int x){
		boolean resp = false;

		int inicio = 0;
		int fim = array.length - 1; // menos 1 porque estamos calculando posições do array, contagem começa em 0

		while(inicio <= fim){
			
			int meio = (inicio + fim ) / 2;

			if(array[meio] == x){
				resp = true;
				break;
			}

			// Se esse caso for verdadeiro, significa que x está no subvetor da direita
			if(array[meio] < x){
				inicio = meio + 1; // aqui já podemos pegar o proximo elemento uma vez que a comparaçao de array[meio] == x foi falsa
			}
			
			// Significa que x está no subvetor a esquerda do meio, ou seja, ele é menor que o número na metade do array;
			else {
				fim = meio - 1;
			}
		}


		return resp;
	}
	
	public static void main(String[] args){
		int array[] = {1,22,48,54,58,68,321,546,8879};
		System.out.println("O array contém o elemento 68? : " + estaContido(array, 68));
		System.out.println("O array contém o elemento 128? : " + estaContido(array, 128));

	}

}
