#include <stdio.h>
#include <stdlib.h>

void busca(int vetor[], int size, int * temp)
{
    int count = 0, k = 0;
    for(int i = 0; i < size; i++)
    {
        for(int j = i; j < size; j++)
        {
            if(vetor[i] == vetor[j]) {
                count++;
            }
            if(count == (size/3))
            {
                temp[k++] = vetor[i];
                temp = realloc(temp, (k+1) * sizeof(int));
                count = 0;
            }
        }
        count = 0;
    }
}

void print(int* vetor)
{
    int size = sizeof(vetor) / sizeof(int);
    for(int i = 0; i < size; i++){
        printf("[%d] ", vetor[i]);
    }
    //printf("\n");
}

void main()
{
    int vetor[] = {2, 6, 2, 10, 2, 12, 3, 6, 7, 8, 6};
    int size = sizeof(vetor) / sizeof(int);
    int * temp;
    temp = (int *) malloc(1 * sizeof(int));

    busca(vetor, size, temp);
    print(temp);
    printf(" se repetem %d vezes \n", size/3);
    free(temp);
}