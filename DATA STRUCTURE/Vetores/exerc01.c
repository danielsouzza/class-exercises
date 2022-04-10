#include <stdio.h>

void main(){
    int vetor[] = {1, 0, 5, -2, -5, 7};
    int soma = 0;
    soma = vetor[0] + vetor[1] + vetor[5];
    printf("A soma dos indices [0], [1] e [5] é = [%d]\n", soma);
    vetor[4] = 100;
    for(int i = 0; i < 6; i ++) printf("vetor[%d] = [%d]\n",i,vetor[i]);
}