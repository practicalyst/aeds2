#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>
#include <math.h>

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

jogador * clone(jogador j){
    jogador * novoJ;
    novoJ = (jogador *) malloc(sizeof(jogador));

    newJogador(novoJ, j.id, j.nome, j.altura, j.peso, j.universidade, j.anoNascimento, j.cidadeNascimento, j.estadoNascimento);
    return novoJ;
}

void swap(jogador * x, jogador * y) {
    jogador aux;
    memcpy(&aux, x, sizeof(jogador));
    memcpy(x, y, sizeof(jogador));
    memcpy(y, &aux, sizeof(jogador));
}

void sortSelecaoRecursiva(jogador * j[], int inicio, int tamanho, int * cmp, int * mov){
    if(inicio < tamanho - 1 ){
        int menorIndice = inicio;
        int i;
        for(i = inicio + 1; i < tamanho; i++){
            // isso significa que o nome com indice i é menor que o em indiceMenor
            if(strcmp(j[i]->nome, j[menorIndice]->nome) < 0){
                menorIndice = i;
            }
            *cmp++;
        }

        *mov = *mov + 3;
        swap(j[inicio], j[menorIndice]);
        

        sortSelecaoRecursiva(j, inicio + 1, tamanho, cmp, mov);

    }
}

// ordena por anoNascimento, com desempate em nome
void sortBolha(jogador * j[], int tamanho, int * cmp, int * mov){

    for(int i = 0; i < (tamanho-1); i++){
        for(int z = i+1; z < tamanho; z++){ 
            *cmp++;
            if(j[i]->anoNascimento > j[z]->anoNascimento || (j[i]->anoNascimento == j[z]->anoNascimento && strcmp(j[i]->nome, j[z]->nome) > 0) ){
                swap(j[i], j[z]);
                *mov = *mov + 3;
            }
        }
    }
}

// Printa SIM caso houver o elemento no array ou NAO se nao houver, chave de pesquisa NOME
void pesquisaBinaria(char * nome, jogador * j[], int tamanho){
    int inicio = 0, fim = tamanho - 1;
    bool resp = false;
    while(inicio <= fim){
        int meio = (inicio + fim) / 2;

        if(strcmp(j[meio]->nome, nome) == 0){
            resp = true;
            break;  
        }

        if(strcmp(j[meio]->nome, nome) < 0){
            inicio = meio + 1;
        }
        else{
            fim = meio - 1;
        }
   
    }   
    resp == true ? printf("SIM\n") : printf("NAO\n");
}   

void registrarLog(char *nomeArquivo, char *matricula, clock_t tempo, int cmp, int mov) {
    FILE *arq;

    if ((arq = fopen(nomeArquivo, "w")) == NULL) {
        printf("Erro ao abrir arquivo!\n");
        return;
    }

    // Use %lf para formatar um valor double
    double tempo_em_milissegundos = (double)tempo * 1000 / CLOCKS_PER_SEC;
    fprintf(arq, "%s\t%.2lf ms\t%d\t%d\n", matricula, tempo_em_milissegundos, cmp, mov);

    fclose(arq);
}

int qtdJogadoresTotal = 0; // n total de elementos carregados na memoria princial
int qtdJogadores = 0; // n total de elementos novos inseridos

void main(){
    FILE * arq;
    jogador * jogadores[5000]; // armazena todos os jogadores
    jogador * novosJogadores[500]; // armazena uma quantidade selecionada de jogadores 

    if((arq = fopen("/tmp/players.csv", "r")) == NULL){
        printf("Erro ao abrir arquivo!");
        return;
    }

    char linha[1000];
    int i = 0;
    fgets(linha, sizeof(linha), arq); // tira a primeira linha do csv

    // carrega todos os jogadores na memória principal
    while(fgets(linha, sizeof(linha), arq)){
        jogadores[i] = (jogador * ) malloc(sizeof(jogador));
        parseCSV(jogadores[i], linha);
        qtdJogadoresTotal++;
        i++;
    }   
    fclose(arq);
    
    // Processa a primeira entrada com os ids
    scanf("%s", linha);
    i = 0;
    while(strcmp(linha, "FIM") != 0){
        int id;
        sscanf(linha, "%d" ,&id);
        
        //novosJogadores[i] = (jogador * ) malloc(sizeof(jogador));
        novosJogadores[i] = clone(*jogadores[id]);
        
        scanf("%s", linha);
        qtdJogadores++;
        i++;
    }

    // Ordena com base no nome
    int cmp = 0;
    int mov = 0;
    clock_t tempoInicial = clock();
    sortBolha(novosJogadores, qtdJogadores, &cmp, &mov);
    clock_t tempoFinal = clock();
    clock_t tempo = tempoFinal - tempoInicial;
    registrarLog("matrícula_bolha.txt", "790871", tempo, cmp, mov);

    for(int k = 0; k < qtdJogadores; k++){
        imprimir(*novosJogadores[k]);
    }


    
}