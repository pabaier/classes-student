#include <stdio.h>
#include <stdlib.h>

void printWelcome(){
    printf("Welcome to our program\n*******\n");
}

int addTwoNumbers(int num1, int num2){
    return num1 + num2;
}

void addFive(int *num){
    //This star dereferences num (get me the thing/value/variable that num points to)
    num = num + 5;
}

int main()
{

    int originalValue = 10;
    printf("The original value is %d\n", originalValue);
    //pass address of originalValue
    addFive(&originalValue);

    /*


    //pointer
    int *myPointer;
    int originalValue = 10;
    myPointer = &originalValue;

    //* means pointer
    //these print the same because myPointer's value is the location of original value
    printf("The address of original value is %p\n", &originalValue);
    printf("The address of my pointer is %p\n", myPointer);

    //if you star a pointer, you dereference, getting the value at that memory location
    printf("The value being stored at the location myPointer is pointing to is %d", *myPointer);




    return 0;

    printf("The original value is %d\n", originalValue);
    addFive(originalValue);
    printf("The original value is %d\n", originalValue);
    return 0;

    printWelcome();
    int sum = addTwoNumbers(5,10);
    printf("%d", sum);

    return 0;
    */

    int myVariable;
    myVariable = 10;
    int mySecondVariable = -11;
    printf("The value of my variable is %d", myVariable);

    unsigned int myUnsignedVariable = -11; //unsigned requires positive values - increases range in positive direction

    printf("The length of an integer in bytes is %lu\n\n", sizeof(double)); //lu means "long unsigned" because sizeof function returns unsigned long
    //sizeof function takes data type or variable as parameter

    printf("The value of myVariable is %x\n\n", myVariable);
    printf("The value of mySecondVariable is %x\n\n", mySecondVariable);
    printf("The value of my unsigned variable is %u\n\n", myUnsignedVariable);

    char myCharacter = 'A';
    printf("My character is %c\n\n", myCharacter);

    float result = 10.0/3;
    printf("The result is %f\n\n", result);

    if (myVariable < 20){//boolean expression
            printf("The body of the if statement executed...\n\n");
    }

    int counter;
    for(counter = 0; counter < 10; counter++){
        if(counter == 5)
            continue;
        printf("%d) Hello There...\n", counter + 1);
    }

    int whileCounter = 10; //control variable

    while( whileCounter > 0){
        printf("The value of while counter is %d\n\n", whileCounter);
        whileCounter --;
    }

    do{
        printf("hello\n\n");
    }while(whileCounter > 10);

    if(whileCounter == 0 && counter == 100){
        printf("The End");
    }

    printf("\n");
    return 0;
}
