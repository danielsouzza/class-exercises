#include <stdio.h>

void main()
{
    int vetor[8];
    int x,y;
    printf("Enter 8 numbers: ");
    for(int i = 0; i < 8; i++) scanf("%d", &vetor[i]);
    printf("Enter 2 numbers between [0-7]:");
    scanf("%d %d", &x, &y);
    printf("The sum of [%d] e [%d] = [%d]\n",vetor[x], vetor[y], (vetor[x]+vetor[y]));
}