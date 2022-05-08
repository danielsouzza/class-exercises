#include <stdio.h>
#include <unistd.h>

// Daniel Lima de Souza

void main()
{
    int clock = 0, i = 0;
    while (i < 10)
    {
        sleep(1);
        (i % 2 == 0) ? printf("%d\n", clock + 1) : printf("%d\n", clock);
        i++;
    }
}