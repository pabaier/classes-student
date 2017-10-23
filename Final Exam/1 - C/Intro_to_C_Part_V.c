//
/*  main.c
 
 Intro to C Part V
 
 Created by Ayman Hajja on 1/19/17.
 Copyright © 2017 college_of_charleston. All rights reserved.
 */

#include <stdio.h>

// The function below will print the elements of an array
//
void printValuesInArray(int arr[], int sizeOfArray)
{
    // Notice here that the following line will print the size of a pointer, either 4 or 8, and not the size of the array in bytes
    //
    printf("The size of 'arr' is %lu\n", sizeof(arr));

    // The only way for this function to know the size of the array is for the caller (main) function to send the size as a separate argument
    
    int counter;
    for (counter = 0; counter < sizeOfArray; counter++)
    {
        printf("%d\n", arr[counter]);
    }
}

int main()
{
    // Next, we declarea an array with 5 elements
    //
    int myArray[] = {1, 5, 6, 2, 7};
    
    // To call the function 'printValuesInArray', we need pass the size of the array in addition to the array
    //
    printValuesInArray(myArray, sizeof(myArray)/sizeof(myArray[0]));

    
    // Next, we provide an example of declaring a pointer to a pointer
    //
    int num = 100;
    
    // The following line will declare a pointer which will point to the int 'num'
    //
    // In other words, the value of 'pointerToNum' will be the address of 'num'
    //
    int *pointerToNum = &num;
    
    // The following line will declare a pointer which will point to 'pointerToNum'
    //
    // The value of 'pointerToPointer' will be the address of 'pointerToNum'
    //
    int **pointerToPointer = &pointerToNum;
    
    // Here are few examples of what we can do:
    //
    // To print the value of 'num' using 'num', we simply do the following
    //
    printf("The value of 'num' (using num) is %d\n", num);
    
    // To print the value of 'num' using 'pointerToNum', we dereference 'pointerToNum'
    // Dereferencing means:
    //      'print the thing that I'm pointing to'
    // or
    //      'print the value that lives at the address that I am storing'
    //
    printf("The value of 'num' (using 'pointerToNum') is %d\n", *pointerToNum);
    
    // To print the value of 'num' using 'pointerToPointer', we "double dereference" 'poniterToPointer'
    //
    // *pointerToPointer will give us the value of 'pointerToNum', which is essentially the address of 'num'
    // if we dereference that, we get the value of 'num'
    //
    printf("The value of 'num' (using 'pointerToPointer') is %d\n", **pointerToPointer);
    
    
    // Next, we provide an example of subtracting two addresses/pointers
    //
    
    short myFirstShort = 20;
    short mySecondShort = 40;
    
    // This will print the address of 'myFirstShort'
    //
    printf("Address of 'myFirstShort' is %p\n", &myFirstShort);
    
    // This will print the address of 'mySecondShort'
    //
    printf("Address of 'mySecondShort' is %p\n", &mySecondShort);
    
    // We notice here that the value printed is really the numbers of shorts (2-byte long segments) that fit between the two addresses
    //
    printf("The distance between the two shorts is %ld\n",  &myFirstShort - &mySecondShort);
    
    return 0;
}
