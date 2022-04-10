#include <stdio.h>

#define size 20
#define p 2 // // change this variable to change the number of people

typedef struct
{
    char name[size];
    float height;
    float weight;
    int cpf;
    char sexo[size];
} people;


void registerPerson(people person[])
{
    for(int i = 0; i < p; i++)
    {
        setbuf(stdin, 0);
        printf("\nTyper the name of person [%d] : ", i+1);
        fgets(person[i].name, size, stdin);
        printf("Enter the weigth: ");
        scanf("%f", &person[i].weight);
        printf("Enter the heigth: ");
        scanf("%f", &person[i].height);
        printf("Enter the CPF: ");
        scanf("%d", &person[i].cpf);
        setbuf(stdin, 0);
        printf("Enter the sex: ");
        fgets(person[i].sexo, size, stdin);
    }
}


void SearchForPerson(people person[], int inputcpf)
{
    for (int i = 0; i < p; i++)
    {
        if(inputcpf == person[i].cpf){
            float IMC;
            IMC = person[i].weight / (person[i].height * person[i].height);
            printf("Name: %s", person[i].name);
            printf("IMC.: %4.2f\n", IMC);
            break;
        }
        else if ((i == p-1) && (inputcpf != person[i].cpf)){
            printf("CPF INVALID!!\n");
        }

    }
}


void main()
{
    people person[p];
    int inputcpf;

    registerPerson(person);

    printf("\nCalculate the IMC, enter a CPF: ");
    scanf("%d", &inputcpf);
    SearchForPerson(person, inputcpf);
}