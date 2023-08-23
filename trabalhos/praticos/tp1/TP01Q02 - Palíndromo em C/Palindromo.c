#include <stdio.h>
#include <stdbool.h>
#include <string.h>


bool isFim(char palavra[]){
	return palavra[0] == 'F' && palavra[1] == 'I' && palavra[2] == 'M' && strlen(palavra) == 3;
}

bool ehPalindromo(char palavra[]){
	bool resp = true;
	// lembrar que em C, existe o caractere \0 delimitando o final da String mas strlen nos da o tamanho real da string sem se preocupar com ele
	int len = strlen(palavra); 
	int i, k;

	// duas variavies percorrendo o array simultaneamente nas posições inversas equivalentes
	for(i = 0, k = len - 1; i < (len / 2); i++, k--){		

		if(palavra[i] != palavra[k]){
			resp = false;
			break;
		}
	}

	return resp;
}


int main()
{
	char str[1000];
	
	while(true){
		// o espaço em branco serve para pegar qualquer espaço ou tab antes da string e o [^\n] diz para ler até que um \n seja encontrado
		scanf(" %[^\n]", str);
		if(isFim(str))
			break;
		
		printf(ehPalindromo(str) ? "SIM\n" : "NAO\n");
	}
	
    return 0;
} 
