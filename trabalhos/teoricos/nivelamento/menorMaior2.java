/*
 *
 * 	Repita o exercício acima fazendo menos comparações com
 *	os elementos do array 
 */

class menorMaior2 {
	public static void minMax(int[] array){
		int menor = array[0];
		int maior = array[0];

		for(int i = 1; i < array.length - 1; i++){
			// Vamos diminuir a quantidade de comparações garantindo que um número seja comparado apenas uma vez com os valores atuais de menor e maior
			if(array[i] < menor){
				menor = array[i];
			} else if(array[i] > maior){
				maior = array[i];
			}
		}	
		
		System.out.println("O menor elemento do array: " + menor);
		System.out.println("O maior elemento do array: " + maior);
	}


	public static void main(String[] args){
		int array[] = {12,54,87,5,489,67898,547,521,23,46,11,2};	
	
			
		System.out.print("{ ");
		for(int i : array){
			System.out.printf(" %d ", i);
		}
		System.out.println(" }");
		minMax(array);

	}


}
