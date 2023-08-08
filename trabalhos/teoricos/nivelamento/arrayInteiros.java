/*
 *
 *	Faça um método que receba um array de inteiros e um
 *	número inteiro x e retorne um valor booleano informando se o
 *	elemento x está contido no array
 *
 */

class arrayInteiros {
	
	public static boolean estaContido(int array[], int x){
		boolean resp = false;

		for(int i = 0; i < array.length; i++){
			if(array[i] == x){
				resp = true;
				break;
			}
		}
		
		return resp;
	}
	
	public static void main(String[] args){
		
		int array[] = {1,58,48,22,54,68,546,321,8879};
		System.out.println("O array contém o elemento 68? : " + estaContido(array, 68));
		System.out.println("O array contém o elemento 128? : " + estaContido(array, 128));

	}

}
