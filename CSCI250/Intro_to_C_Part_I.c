//
/*  main.c

  Intro to C Part I

  Created by Ayman Hajja on 1/19/17.
  Copyright © 2017 college_of_charleston. All rights reserved.
*/

#include <stdio.h>

int main()
{
    // Next line of code will declare and initialize a variable of type int (integer)
    //
    int myVariable = 10;

    // To print a variable in C, we need to include a format specifier (% followed by a lettter or two)
    //
    // For integers, the format specifier is %d
    //
    printf("The value of my variable is %d, %d\n\n", myVariable, myVariable + 10);

    int mySecondInt = -10;

    // If we use the format specifier %x, the the value will be printed in hexadecimal
    // using two's complement representation
    //
    printf("The value of my second int is: %x\n\n", mySecondInt);

    // Next we declare a float (real number)
    //
    float myFloatVariable = 10.539;

    // The format specifier for floats is %f
    //
    printf("The value of my float %.2f, the value of my int is %d\n\n", myFloatVariable, mySecondInt);

    // Next we declare and initialize an unsigned (int) - for 32-bit integers range is 0 to ~4 * 10^9
    //
    unsigned myUnsigned = 100;

    // The format specifier for an unsigned int is %u
    //
    printf("The value of my unsigned %u\n\n", myUnsigned);

    // Next few lines will print the sizes of few data-types
    // Notice here that we use the format specifier %lu (for unsigned long - return data-type for sizeof)
    //
    printf("The size of an int is: %lu\n", sizeof(int));
    printf("The size of a long is: %lu\n", sizeof(long));
    printf("The size of a short is: %lu\n", sizeof(short));
    printf("The size of a character is: %lu\n", sizeof(char));
    printf("The size of a float is: %lu\n", sizeof(float));
    printf("The size of a double is: %lu\n", sizeof(double));

    // Next we declare and initialize a character (size of character will always be 1 byte)
    //
    char myCharacter = 'a';
    printf("The value of my character is %c\n\n", myCharacter);

    float myOtherVariable;

    // Integer division will always result in an int
    //
    myOtherVariable = 20 / 3;
    printf("The value of my other variable is %f\n\n", myOtherVariable);


    int myControlVarible = 0;

    if (myControlVarible < 10)
    {
        // This block (area surrounded by curly braces) will execute only of condition is true
        //
        printf("I am inside the if statement!\n\n");
    }
    else
    {
        // This block (area surrounded by curly braces) will execute when the condition is false
        //
        printf("I am inside the else section!\n\n");
    }

    // Note here that if the block contains only one line of code, we can omit the curly braces
    //
    // The following code is equivalent to code above
    /*
        if (myControlVarible < 10)
            printf("I am inside the if statement!\n\n");
        else
            printf("I am inside the else section!\n\n");
     */


    // If (0) will evaluate to false; anything other than 0 will evaluate to true
    //
    if (0)
        printf("Will this execute?");


    // Here's how to code a 'for' loop in C.
    // 1) myControlVarible = 0 will execute first, and it will execute only once
    // 2) The boolean expression (myControlVarible < 5) will evaluate, if it evaluates to true, everything in the loop body will execute (everything between the curly braces); and if it evaluates to false, then we will exit the loop
    // 3) After we execute what's in the loop body (given the boolean expression evaluated to true), we execute 'myOtherVariable = myOtherVariable + 1', which will increment the counter by one
    // 4) Now we go back to step 2
    //
    for (myControlVarible = 0; myControlVarible < 5; myControlVarible++)
    {
        // 'break' will quit the loop
        //
        if (myControlVarible == 4)
            break;

        // 'continue' will take us direcly to Step 3 (without reaching the end of the loop body)
        //
        if (myControlVarible == 3)
            continue;

        printf("%d ", myControlVarible);
    }


    // For 'while' loops, the condition is first evaluated, if it evaluates to true, everything in the loop body willl execute, and after we're done executing the loop body, we evaluate the condition again (and repeat)
    //
    // It's imoprtant to note here that for 'while' loops, we need to explicitly update the control variable inside the loop body
    //
    while(myControlVarible < 5)
    {
        printf("%d\n", myControlVarible);
        myControlVarible = myControlVarible + 1;
    }

    // For 'do...while' loops, the first thing C does is executes the loop body (without evaluating any boolean expression), and after executing the loop body once, C will evaluate the condition in the 'while' line; if it evaluates to true, the loop body executes again and the process repeats; as soon as the boolean expression evaluates to false, we quit the loop
    //
    do
    {
        printf("The value of cv is %d\n", myControlVarible);
        myControlVarible = myControlVarible + 1;
    }while(myControlVarible < 5);

    // We can use logical operators such as and (&&) and or (||)
    //
    if (myControlVarible > 10 && myControlVarible < 100)
        printf("\nTrue\n");


    float myFloat = 10.6;
    // Here, by doing (int)myFloat, we are essentially using the integer value of 'myFloat'.
    // Note here that we're not changing the content of 'myFloat', only usint its integer value, which will truncate everything after the decimal point
    //
    printf("The value of my float (as a whole number): %d\n", (int)myFloat);
    printf("The value of my float (as a decimal number): %f\n", myFloat);

    return 0;
}



