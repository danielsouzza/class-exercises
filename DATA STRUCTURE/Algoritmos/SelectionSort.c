#include <stdio.h>

/*
    Algoritmo
    Nome: SelectionSort
    Complexidade: O(n²) para todos os casos
    By: Daniel Lima de Souza
    
*/
int comparisons = 0;
int troca = 0;

void selectionSort(int vetor[], int size)
{
    int i, j,menor, aux;
    for(i = 0; i < size; i++)
    {
        menor = i;
        for(j = i + 1; j < size; j++)
        {
            comparisons++;
            if(vetor[j] < vetor[menor])
            {
                menor = j;
            }
        }
        if(i != menor)
        {
            aux = vetor[i];
            vetor[i] = vetor[menor];
            vetor[menor] = aux;
            troca++;
        }
    }
}

void print(int vetor[], int size)
{
    for(int * i = vetor; *(i) != vetor[size]; i++)
    {
        printf(" %d ", *(i));
    }
    printf("\n");
}

void main()
{
    //int vetor[] = {12,44, 13, 88, 23, 94, 11, 39, 20, 16, 5, 33, 42};
    int vetor[] = {12,44, 13, 88, 23, 94};
    int size = (sizeof(vetor) / sizeof(vetor[0]));
    print(vetor, size);
    selectionSort(vetor, size);
    print(vetor, size);
    printf("Comparação = %d\ntrocas = %d \n", comparisons, troca);
    printf("Foram nescessaŕias %d comparações críticas ", (comparisons + troca));
}