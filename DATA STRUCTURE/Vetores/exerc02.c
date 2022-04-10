#include <stdio.h>

void main()
{
    int vetor[6];
    printf("Enter 6 numbers: ");
    for(int i = 0; i < 6; i++) scanf("%d", &vetor[i]);
    for(int i = 0; i < 6; i++) printf("vetor[%d] = [%d]\n",i, vetor[i]);
}