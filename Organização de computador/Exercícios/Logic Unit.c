#include <stdio.h>

//Using logical operators to compare two integers 

int main()
{
    int a, b;
    int i = 1;
    scanf("%d %d", &a, &b);

    while (i){
        //if (a == a)
        if (!(a ^ b)){
            printf("%d == %d\n", a, b);
            i = 0;
        // if (a > b)
        }else if (!a){
            if(b) printf("b > a\n");
            break;
        // if (a > b)
        }else if (!b){
            if (a) printf("a > b\n");
            i = 0;
        }
        a--;
        b--;
    }
    return 0;
}