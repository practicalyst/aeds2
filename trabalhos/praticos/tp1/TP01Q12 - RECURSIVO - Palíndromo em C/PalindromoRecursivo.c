#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool isFim(char palavra[]){
	return palavra[0] == 'F' && palavra[1] == 'I' && palavra[2] == 'M';
}

bool isPalindromo(char str[], int inicio_fim){
    // Caso base: se chegamos ao meio da string, é um palíndromo
    if (inicio_fim <= 0) {
        return true;
    }

    // Verifica se o primeiro e o último caractere são iguais
    if (str[0] != str[inicio_fim]) {
        return false;
    }

    // Chamada recursiva com os caracteres internos da string
    return isPalindromo(str + 1, inicio_fim - 2);
}


int main(){

    char str[10000];
    scanf("%[^\n]", str);
    
    while(true){

        if(isFim(str)){
            break;
        }
        if(isPalindromo(str, strlen(str) - 1)){
            printf("SIM\n");
        }else{
            printf("NAO\n");
        }
        scanf(" %[^\n]", str);
    }
}