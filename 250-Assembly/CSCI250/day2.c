#include <stdio.h>

void printValuesInArray(int arr[], int sizeOfArray){
    //because an array is a pointer, size of returns the size of a pointer
    //you need to pass the size of the array into any functions to have access to it!
    printf("The size of my other array is %lu\n", sizeof(arr));
    return;

    //does not work!
    //int sizeOfMyArray = sizeof(arr)/sizeof(arr[0]);

    int counter;
    for(counter = 0; counter < sizeOfArray; counter++){
        printf("%df\n", arr[counter]);
    }
}

int main(){

    int num = 10;
    int *pointerToNum = &num;

    printf("num is %d\n", num);
    printf("pointer to num is %p\n", pointerToNum);

    //pointer arithmetic
    //when you add to a pointer, you add by the size of the data type the pointer points to!
    printf("pointer to num is %p\n", pointerToNum + 1);

    short myShort = 2;
    short *pointerToShort = &myShort;

    printf("Pointer to short is %p\n", pointerToNum);
    printf("Pointer to short is %p\n", pointerToNum - 2);
    printf("The size of my pointer is %lu\n", sizeof(pointerToNum));

    //2
    short myFirstShort = 20;
    short mySecondShort = 40;
    short *pointerToFirstShort = &myFirstShort;
    short *pointerToSecondShort = &mySecondShort;
    printf("Address of first short is %p\n", &myFirstShort);
    printf("Address of second short is %p\n", &mySecondShort);
    //gives the number of shorts you can fit between these addresses
    printf("The distance between the two shorts is %ld\n",  &myFirstShort - &mySecondShort);

    //3 Pointer to Pointers
    int numb = 100;
    int *pointerToNumb = &numb;
    int **pointerToPointer = &pointerToNumb;

    //4 Arrays
    //2 ways to create
    int myArray[10]; //myArray is a pointer! It points to the first element myArray[0]
    myArray[0] = 50;
    myArray[1] = 200; //this address will be 4 bytes ahead of myArray[0]
    printf("The value of the first element if my array is %d\n", myArray[0]);
    printf("The size of my array is %lu\n", sizeof(myArray));
    printf("The size of first element is %lu\n", sizeof(myArray[1]));
    printf("The size of first element is %lu\n", sizeof(&myArray[1]));
    //length of array
    printf("The length of my array is %lu\n", sizeof(myArray)/sizeof(myArray[0]));

    //other way of creating array
    int myOtherArray[] = {3, 5, 1, 10};
    printf("The size of my array is %lu\n", sizeof(myOtherArray));

    //another way to get the first element
    printf("The first element is %d\n", *myOtherArray);
    printf("The second element is %d\n", *(myOtherArray + 1));

    myOtherArray[1] = 15;
    //or
    *(myOtherArray + 1) = 15;
    printf("The second element is %d\n", *(myOtherArray + 1));

    //passing arrays to functions
    printValuesInArray(myOtherArray, sizeof(myOtherArray)/sizeof(myOtherArray[0]));

    //5 Strings
    char otherName[] = "Ben";
    printf("The size of other name is %lu\n", sizeof(otherName)); //prints 4 because double quotes adds the null character ('\0') to the end
    printf("%s\n", otherName);
    char thirdName[] = {'J', 'o', 'h', 'n'};
    printf("The size of other name is %lu\n", sizeof(thirdName));
    printf("%s\n", thirdName);


    char name[5];
    name[0] = 'A';
    name[1] = 'y';
    name[2] = 'm';




    return 0;


}
