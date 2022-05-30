#include <stdio.h>
#include <stdio.h>
#include <time.h> 

int count = 0;

void bubbleSort(int * vetor, int n){
    int k, j, aux;
    int troca=0, varr=0;
    for (k = 1; k < n; k++) {
        varr++;
        for (j = 0; j < n - k; j++) {
            count++;
            if (vetor[j] > vetor[j + 1]) {
                aux = vetor[j];
                vetor[j] = vetor[j + 1];
                vetor[j + 1] = aux;
                troca++;
            }
        }
    }

    printf(" troca = %d\n varredura = %d\ntotal = %d", troca, varr, (troca+varr));
}

void main() {
    // int vetor [] = {12,44, 13, 88, 23, 94, 11, 39, 20, 16, 5, 33, 42};
    int vetor[] = {1, 2, 3, 4, 5, 6};
    int n = (sizeof(vetor)/sizeof(vetor[0])) - 1 ;
    float tempo;
    time_t start, end;
    
    start = time(NULL);
    bubbleSort(vetor, n);
    end = time(NULL);
    tempo = difftime(end,start);
    
    for (int k = 0; k <= n; k++) {
        printf("\n [%d]=%d ", k, vetor[k]);
    }
    
    printf ("\nO tempo de processamento foi %f segundos.\n", tempo);
    printf("%d", count);
    printf("\n");
}
