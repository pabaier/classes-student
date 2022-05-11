//
/*  main.c
 
 Intro to C Part II
 
 Created by Ayman Hajja on 1/19/17.
 Copyright © 2017 college_of_charleston. All rights reserved.
 */

#include <stdio.h>

int main()
{
    // In the next line, we declare and initialize a variable of type int
    //
    int my_int_variable = 10;
    
    // The next line declares a pointer of type int, and it's initialized to the address of the variable 'my_int_variable'
    //
    int *my_pointer = &my_int_variable;
    
    // Now to print the value of 'my_int_variable', we can either directly print it, or we could dereference 'my_pointer' which would give us the variable that 'my_pointer' is pointing to, which is 'my_int_variable'. (refer to previous lecture)
    //
    // Here's how we directly print the value of 'my_int_variable'
    //
    printf("The value of my_int_variable is %d\n", my_int_variable);
    
    // ...and here's how we print the value of 'my_int_variable' using 'my_pointer'
    //
    printf("The value of my_int_variable is %d\n", *my_pointer);
    
    // To print the address of 'my_int_variable' we either use the & (address-of) operator, or we could use the pointer variable 'my_pointer' (since it points to 'my_int_variable')
    // Recall that to print an address, we need to use %p (pointer)
    //
    // Very important: Each unique address in modern computers point to one particular byte.
    //
    // The address of an int is the address of the first byte of the 4 bytes that an int holds/reserves. (refer to slides)
    //
    // First method to print address
    //
    printf("The address of my_int_variable is %p\n", &my_int_variable);
    
    // Second method to print address
    //
    printf("The address of my_int_variable is %p\n", my_pointer);
    
    // Now let's create a character and print its address
    //
    char my_char = 'A';
    
    printf("Address of my_char is %p\n", &my_char);

    return 0;
}
