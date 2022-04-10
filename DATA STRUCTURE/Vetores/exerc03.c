#include <stdio.h>

void main()
{
    int vetor0[10];
    int vetor1[10];

    printf("Enter 10 numbers: ");
    for (int i = 0; i < 10; i++) scanf("%d", &vetor0[i]);
    for (int i = 0; i < 10; i++) vetor1[i] = vetor0[i] * vetor0[i];
    printf("Vetor0: ");
    for (int i = 0; i < 10; i++) printf("[%d] ",vetor0[i]);
    printf("\nvetor1: ");
    for (int i = 0; i < 10; i++) printf("[%d] ",vetor1[i]);
    printf("\n");

}