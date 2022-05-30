#include <stdio.h>

void heapSort(int *vetor, int size)
{
    int i, aux;
    for(i = (size-1)/2; i >= 0; i--)
    {
       criaHeap(vetor, i, size-1);
    }
    print(vetor, size);
    for(i = size-1; i >= 1; i--)
    {
        aux = vetor[0];
        vetor[0] = vetor[i];
        vetor[i] = aux;
        criaHeap(vetor, 0, i-1);
        print(vetor, size);
    }

}

void criaHeap(int *vetor, int start, int end)
{
    int father = vetor[start];
    int son = (start * 2 + 1);
    while (son <= end)
    {
        if(son < end && (vetor[son] < vetor[son + 1]))
        {
            son = son + 1;
        }
        if(father < vetor[son])
        {
            vetor[start] = vetor[son];
            start = son;
            son = 2 * start + 1;
        }else{
            son = end + 1; 
        }
    }
    vetor[start] = father;
    
}

void print(int vetor[], int end)
{
    for(int i = 0; i < end; i ++)
    {
        printf("[%d] ", vetor[i]);
    }
    printf("\n");
}

void main()
{
    int vetor[] = {3, 4, 9, 2, 5, 8, 2, 1, 7, 4, 6, 2, 9, 8, 5, 1};
    int end = sizeof(vetor) / sizeof(int);
    print(vetor, end);
    heapSort(vetor, end);
    print(vetor, end);
}