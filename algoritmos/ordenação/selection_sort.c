#include <stdio.h>

/*
 * 	Complexidade tanto do pior caso, quanto do melhor é O(n²)
 * 	
 * 	Vantagem: rápido para arrays pequenos, fácil de entender.
 *
 *
 *
 */

void selectionSort(int array[], int n){
	
	int menor; // armazena indice do menor elemento do array 
	int aux;
		
	for(int i = 0; i < n - 1; i++){
		menor = i;
		for(int j = i + 1; j < n; j++){
			if(array[j] < array[menor]){
				menor = j;
			}
		}
		// precisa verificar se houve a mudança no indice do menor numero
		if(menor != i){
			aux = array[i];
			array[i] = array[menor];
			array[menor] = aux;
		}
	}	
}
int main(){
	
	int array[] = {147,87,361,23,74,87,21,879,7,15,12,22,1040,78,549};
	int len = sizeof(array) / sizeof(int);
	
		
	printf("{");
	for(int i = 0; i < len; i++){
		printf(" %d ", array[i]);
	}	
	printf("}\n");

	selectionSort(array, len);
	
	printf("{");
	for(int i = 0; i < len; i++){
		printf(" %d ", array[i]);
	}
	printf("}\n");


}
	
