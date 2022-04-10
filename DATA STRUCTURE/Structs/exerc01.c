#include <stdio.h>

#define size 20
#define n 2 // change this variable to change the number of people

typedef struct
{
    char name[size];
    int registration;
    float grades[2];
} students;

void printstudents(students student[])
{
    printf("\n<><><><><><>Students<><><><><><>\n");
    for (int i = 0; i < n; i++)
    {
        printf("\nStudent #%d\n", i+1);
        printf("Name........: %s",student[i].name);
        printf("Registration: %d\n", student[i].registration);
        printf("Average.....: %4.2f\n", ((student[i].grades[0]+student[i].grades[1]) / 2));
    }
}

void registestudents(students student[])
{
    for (int i = 0; i < n; i++)
    {
        printf("Typer the name of student [%d] : ", i+1);
        fgets(student[i].name,size, stdin);
        printf("Enter registration: ");
        scanf("%d", &student[i].registration);
        printf("Type two notes: ");
        scanf("%f %f", &student[i].grades[0], &student[i].grades[1]);
        printf("\n");
        setbuf(stdin, 0);
    }
    
}

int main()
{
    students student[n];
    registestudents(student);
    printstudents(student);
}
