#include <stdio.h>

void addFive(int *n, int v){
    n = n + v;
}

void adder(int *n){
    *n = *n + 2;
}

int main(){

    int numTest = 3;
    int *numPointer = &numTest;
    printf("%p\n", numPointer);
    adder(numPointer);
    printf("%d\n", *numPointer);
    double *t;
    printf("%lu\n", sizeof(t));

    return 0;


   //roudning questions - what if 12.94 and 12.95?
    float f = 12.85;
    float g = 12.94;
    printf("%0.2f\n%0.1f\n", f, g);
    return 0;


    //first question
    int q = 9;
    int *q_p = & q;
    q_p += 1;
    printf("%d", q);
    return 0;

    int a = 5;
    int *k = &a;
    int **m = &k;
    int **j = m;

    printf("%p\n", m);
    printf("%p\n", &k);
    printf("%d\n", **j);

    printf("%d\n", a);
    addFive(k, 3);
    printf("%d\n", a);
    printf("%p\n", &a); //print address of a
    printf("%p\n", k);  //print value of k, which is address of a
    printf("%p\n", &k); //print the address of k
    printf("%p\n", m); //print value of m, which is value of k
    printf("%d\n", **m); //print the value of the address in m which is value of a

    return 0;

    int num = 7;
    int *numP = &num;
    char *s = "Hello, world!";

    printf("A int is %lu bytes\n", sizeof(int));
    printf("A double is %lu bytes\n", sizeof(double));
    printf("A char is %lu bytes\n", sizeof(char));
    printf("A string is %lu bytes\n", sizeof(s));

    printf("The pointer *numP points to the address %p (numP)\n", numP);
    printf("That means num's address is %p (&num)\n", &num);
    printf("The pointer *numP points to the value %d (*numP)\n", *numP);

    printf("The string starts at address %p \n", s);
    printf("The first letter is %c \n", *s);
    printf("The second letter's address is %p \n", s + 1);
    printf("The second letter is %c \n", *(s + 1));





    return 0;
}
