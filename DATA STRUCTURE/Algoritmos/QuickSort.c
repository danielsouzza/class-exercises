#include <stdio.h>

int count = 0;

void quickSort(int * vetor, int start, int end)
{
    int pivot;

    if(start < end)
    {
        pivot = partition(vetor, start, end);
        quickSort(vetor, start, pivot - 1);
        quickSort(vetor, pivot + 1, end);
    }
}

int partition(int * vetor, int start, int end)
{
    int pivot = vetor[start];
    int left = start, rigth = end;

    while(left < rigth)
    {
        while ( vetor[left] <= pivot) left++;
        while(vetor[rigth] > pivot) rigth--;
        if(left < rigth)
        {
            troca(vetor, left, rigth);
        }
        count++;
        //print(vetor)
    }

    troca(vetor, start, rigth);
    print(vetor, end);
    return rigth;
}

void troca(int * vetor, int num1, int num2)
{
    int aux = vetor[num1];
    vetor[num1] = vetor[num2];
    vetor[num2] = aux;
}

void print(int vetor[], int end)
{
    for(int i = 0; i <= end; i ++)
    {
        printf("[%d] ", vetor[i]);
    }
    printf("\n");
}



void main()
{
    int vetor[] = {3, 4, 9, 2, 5, 8, 2, 1, 7, 4, 6, 2, 9, 8, 5, 1};
    int end = sizeof(vetor) / sizeof(int) - 1;
    print(vetor, end);
    quickSort(vetor, 0, end);
    print(vetor, end);
    // printf("%d", count);
}