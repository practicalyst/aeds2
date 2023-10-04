#include <stdio.h>
#include <string.h>
#include <stdlib.h>

//id,Player,height,weight,collage,born,birth_city,birth_state
typedef struct jogador {
    int id, altura, peso, anoNascimento;
    char nome[100];
    char universidade[100];
    char cidadeNascimento[100];
    char estadoNascimento[100];

}jogador;

void imprimir(jogador j){
    printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n", j.id, j.nome, j.altura, j.peso, j.anoNascimento, j.universidade ,j.cidadeNascimento, j.estadoNascimento);
}

void newJogador(jogador * j, int id, char * nome, int altura, int peso, char * universidade, int anoNascimento, char * cidadeNascimento, char * estadoNascimento){    
    j->id = id;
    j->altura = altura;
    j->peso = peso;
    j->anoNascimento = anoNascimento;

    strcpy(j->nome, nome);
    strcpy(j->universidade, universidade);
    strcpy(j->cidadeNascimento,cidadeNascimento);
    strcpy(j->estadoNascimento, estadoNascimento);
}

// devolve um registro do tipo jogador com os atributos do arquivo csv
// id,Player,height,weight,collage,born,birth_city,birth_state
void parseCSV(jogador * j, char * linha){
    
    int id, altura, peso, anoNascimento;
    char nome[100], universidade[100], cidadeNascimento[100], estadoNascimento[100];

    char atributos[8][100];
    char aux[100];

    for (int i = 0; i < 8; i++) {
        strcpy(atributos[i], "");
        if (sscanf(linha, "%[^,\n]", aux) == 0) {
            strcpy(atributos[i], "nao informado");
        } else {
            strcpy(atributos[i], aux);
        }
        // Encontra a posição da primeira vírgula
        char *virgula = strchr(linha, ',');
        if (virgula != NULL) {
            linha = virgula + 1; // Move para o próximo  
        }
        
        //printf("Atributo[%d]: %s \n", i, atributos[i]);
    }
    id = atoi(atributos[0]);
    strcpy(nome, atributos[1]);
    altura = atoi(atributos[2]);
    peso = atoi(atributos[3]);
    strcpy(universidade, atributos[4]);
    anoNascimento = atoi(atributos[5]);
    strcpy(cidadeNascimento, atributos[6]);
    strcpy(estadoNascimento, atributos[7]);
    
    newJogador(j, id, nome, altura, peso, universidade, anoNascimento, cidadeNascimento, estadoNascimento);
    //imprimir(*j);
}

void main(){
    FILE * arq;
    jogador * jogadores[5000];

    if((arq = fopen("/tmp/players.csv", "r")) == NULL){
        printf("Erro ao abrir arquivo!");
        return;
    }

    char linha[1000];
    int i = 0;
    fgets(linha, sizeof(linha), arq); // tira a primeira linha do csv

    // carrega todos os jogadores na memória principal
    while(fgets(linha, sizeof(linha), arq)){
        jogadores[i] = malloc(sizeof(jogador));
        parseCSV(jogadores[i], linha);
        i++;
    }   
    fclose(arq);

    scanf("%s", linha);
    while(strcmp(linha, "FIM") != 0){
        int id;
        sscanf(linha, "%d" ,&id);
        imprimir(*jogadores[id]);
        scanf("%s", linha);
    }

}