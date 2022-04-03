#include <stdio.h>
//DANIEL LIMA DE SOUZA

// Invete o arry
void invertArray(int *vetor){
    int aux;
    int i,j;
    
    for(i=0,j= 9; i < 5 ; i++,j--){
        aux = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = aux;
    }
}

//Soma os elementos de índice par do arry
int sumArry(int *vetor){
    int soma = 0;
    for(int i = 0; i < 10 ;i++, vetor++){
        soma += (i % 2 == 0) ? (*vetor): 0;
    }
    return (soma);
}

//Mostra na tela os elementos no estado atual
void printArry(int *vetor){
    for(int i = 0;i < 10; i++) printf(" %d ", vetor[i]);
}

// Função principal
int main() {
    int arry[]= {1,2,3,4,5,6,7,8,9,10}; 
    invertArray(arry); 
    printArry(arry);
    printf("\n A soma dos elementos de índice par é = %i\n", sumArry(arry));
    return 0;
}