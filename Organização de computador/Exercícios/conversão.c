#include <stdio.h>
#include <stdlib.h>

int main()
{
    int num = 0;
    int arr[10];
    int i;

    printf("Digite um número para converter para  base 9: ");
    scanf("%d", &num);
    printf("O número %d na base 9 é ", num);

    for (i = 0; num > 0; i++)
    {
        arr[i] = (num % 9);
        num = (num / 9);
    }
    arr[i+1] = (int)num;
    while (i){
       printf("%d", arr[i-1]);
       i--;
    }
    printf("\n");
    return 0;
}