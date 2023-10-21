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

// implementação do particionamento de lomuto
int particionamento(jogador * j[], int esquerda, int direita, int * cmp, int * mov){
    jogador * pivot = j[esquerda];
    jogador * aux = NULL;

    int i = esquerda;

    for(int z = esquerda + 1; z <= direita; z++){
        if((strcmp(j[z]->estadoNascimento, pivot->estadoNascimento) < 0) || 
            strcmp(j[z]->estadoNascimento, pivot->estadoNascimento) == 0 && strcmp(j[z]->nome, pivot->nome) < 0){
            i++;
            aux = j[i];
            j[i] = j[z];
            j[z] = aux;

            *(cmp)++;
            *(mov) = *(mov) + 3;    
        }
    }
    aux = j[esquerda];
    j[esquerda] = j[i];
    j[i] = aux;

    *(mov) = *(mov) + 3;   
    
    return i;
}  

// ordena por estadoNascimento
void sortQuicksort(jogador * j[], int esquerda, int direita, int * cmp, int * mov){
    
    if(esquerda < direita){
        int indicePivot = particionamento(j, esquerda, direita, cmp, mov);
        sortQuicksort(j, esquerda, indicePivot - 1, cmp, mov);
        sortQuicksort(j, indicePivot + 1, direita, cmp, mov);
    }
}
// Função para encontrar o maior ID entre os jogadores
int findMaxID(jogador *j[], int n) {
    int max = j[0]->id;
    for (int i = 1; i < n; i++) {
        if (j[i]->id > max) {
            max = j[i]->id;
        }
    }
    return max;
}

// Função para contar a ocorrência de dígitos em uma posição específica
void countSortByID(jogador *j[], int n, int exp) {
    const int k = 10;  // Número de dígitos possíveis (0-9)
    jogador *output[n];
    int *count = (int *)malloc(k * sizeof(int));  // Alocação dinâmica

    for (int i = 0; i < k; i++) {
        count[i] = 0;
    }

    for (int i = 0; i < n; i++) {
        int digit = (j[i]->id / exp) % 10;
        count[digit]++;
    }

    for (int i = 1; i < k; i++) {
        count[i] += count[i - 1];
    }

    for (int i = n - 1; i >= 0; i--) {
        int digit = (j[i]->id / exp) % 10;
        output[count[digit] - 1] = j[i];
        count[digit]--;
    }

    for (int i = 0; i < n; i++) {
        j[i] = output[i];
    }

    free(count);  // Liberar a memória alocada dinamicamente
}

// Função principal do Radix Sort para ordenar pelo ID
void radixSort(jogador *j[], int n) {
    int maxID = findMaxID(j, n);

    for (int exp = 1; maxID / exp > 0; exp *= 10) {
        countSortByID(j, n, exp);
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
    radixSort(novosJogadores, qtdJogadores);
    clock_t tempoFinal = clock();
    clock_t tempo = tempoFinal - tempoInicial;
    registrarLog("matrícula_radixsort.txt", "790871", tempo, cmp, mov);

    for(int z = 0; z < qtdJogadores; z++){
        imprimir(*novosJogadores[z]);
    }


    
}