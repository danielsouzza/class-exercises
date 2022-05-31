#include <stdio.h>
#include <stdlib.h>

typedef struct
{
    int dado;
    struct No * prox;
}No;

typedef struct
{
    No * start;
    No * end;
    int size;
}List;

List list; 

void insertStart(int dado)
{
    No *ptr = (No*) malloc(sizeof(No));
    if(ptr != NULL)
    {
        ptr->dado = dado;
        ptr->prox = NULL;
    }
    if(list.start == NULL)
    {
        list.end = ptr;
    }else{
        ptr->prox = list.start;
    }
    list.start = ptr;
    list.size++; 

}

void insertEnd(int dado)
{
    No * ptr = (No*) malloc(sizeof(No));
    if(ptr != NULL)
    {
        ptr->dado = dado;
        ptr->prox = NULL;
    }
    if(list.start == NULL)
    {
        list.end = ptr;
    }else{
        list.end->prox = ptr;
    }
    list.end = ptr;
    list.size++;
}

void print(){
    No *ptr = list.start;
    printf("Start -> ");
    while (ptr != NULL)
    {
        printf("%d ", ptr->dado);
        ptr = ptr->prox;
    }
    printf("<- End\n");
}

void menu()
{
    printf("[1] - Insert at the start\n");
    printf("[2] - Insert at the end\n");
    printf("[3] - Show all data\n");
    printf("[0] - Exit\n");
}


int main()
{
    int choce, dado;
    list.start = NULL;
    list.end = NULL;
    
    do
    {
        system("clear");
        menu();
        scanf("%d", &choce);
        fflush(stdin);
        system("clear");
        switch (choce)
        {
        case 0:
            break;
        case 1:
            printf("Insira o dado desejado para o início: ");
            scanf("%d", &dado);
            insertStart(dado);
            getchar();

            break;
        case 2:
            printf("Insira o dado desejado para o final: ");
            scanf("%d", &dado);
            insertEnd(dado);
            getchar();

            break;
        case 3:
            print();
            getchar();getchar();
            
            break;
        default:
            printf("Opção inválida !!\n");
            break;
        }

    } while (choce != 0);
    return 0;
}