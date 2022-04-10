#include <stdio.h>

void main ()
{
    int vetor[10];
    int maior, menor ;
    
    printf("Enter 10 numbers: ");
    for (int i = 0; i < 10; i++){
        scanf("%d", &vetor[i]);
        if (i == 0) maior = menor = vetor[i];
        else if(vetor[i] > maior) maior = vetor[i];
        else if (vetor[i] < menor) menor = vetor[i];
    }
    printf("Maior = [%d]\n", maior);
    printf("Menor = [%d]\n", menor);

}