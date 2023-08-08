/*
 *
 * 	Faça um método que receba um array de inteiros e mostre na
 *	tela o maior e o menor elementos do array.
 */


class menorMaior {
	public static void minMax(int[] array){
		int menor = array[0];
		int maior = array[0];

		for(int i = 1; i < array.length; i++){
			if(array[i] < menor)
				menor = array[i];
			if(array[i] > maior)
				maior = array[i];
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
