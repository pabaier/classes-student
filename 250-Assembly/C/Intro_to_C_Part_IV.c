//
/*  main.c
 
 Intro to C Part IV
 
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
    
    // If you try to add a number to address, the result will be: the address + size_of_data_type_address_is_pointing_to * the number
    //
    // For example, if address of 'my_pointer' is 12 (in decimal), then my_pointer + 2 will result in 20 (in decimal)
    //
    printf("The address of my_int_variable plus 2 is %p\n", my_pointer + 2); // Notice that 2 * 4 (8) will be added
    
    // Now let's create a character and print its address
    //
    char my_char = 'A';
    
    printf("Address of my_char is %p\n", &my_char);
    
    // Since the size of any character is 1 byte, if we add 2 to &my_char, then the answer would be only 2 added to the actual address
    //
    printf("Address of my_char after adding 2 is %p\n", &my_char + 2);

    // We are allowed to do the following pointer arithmetic:
    //
    // 1) add an integer (whole number) to an address (shown in examples above)
    // 2) subtract an integer (whole number) from an address (same behaviour)
    // 3) subtract two pointers (result will be a long integer, which will represent the number of variables - of variable type that are being pointed to by both pointers - that fit between the two addresses).
            // for example, if we have a pointer (pointer_1)that points to an int that has address 400
            // and we have another pointer (pointer_2) that points to an int that has address 600
            // if we subtract pointer_1 from pointer_2, we would get 50, which is 50 integers, since 600 - 400 is 200 bytes, and 200/4 is 50
    
    
    
    // The next line declares an array of type int that contains 10 elements. Since each element is an int, and the size of an int (for my compiler) is 4 bytes, then the total size of the array will be 40 bytes.
    //
    // Recall that array elements are stored contiguously in the main memory (or RAM).
    //
    // Also, you need to know that when we declare/define an array, the name of the array will be a pointer that points to the first element of the array
    //
    // The values that are stored in the 10 integers right now are unpredictable, we cannot (and should not) assume anything about these numbers/bits
    //
    int my_array[10];
    
    // We can assign values to array elements using indexing
    //
    my_array[0] = 20;
    my_array[5] = my_array[0] + 80;
    my_array[9] = 200;
    
    // Although 'my_array' is essentially a pointer, if we try to get the size of 'my_array' using the operator 'size_of', C will return the size of the entire array in bytes
    //
    // The output to next line will be 40 (10 elements/ints, each element/int is occupying 4 bytes)
    //
    printf("The size of my array is %lu bytes\n", sizeof(my_array));
    
    // To get the the number of elements in our array, we can divide the size of the entire array by the size of one element (could be any element)
    //
    printf("The number of elements in our array is %lu elements\n", sizeof(my_array)/sizeof(my_array[0]));
    
    // Another way to declare/create an array would be to list its items
    //
    int my_other_array[] = {3, 10, 4, 5};

    // Since an array is essentially a pointer that points to the first element of the array, that means we can dereference the array name and obtain the first value of the array
    //
    printf("The first element in 'my_other_array' is %d\n", *my_other_array); // *my_other_array is equivalent to my_other_array[0]
    
    // We can also do the following:
    //
    printf("The second element in 'my_other_array' is %d\n", *(my_other_array + 1));
    
    // We can also change the value of an element in the array by dereferencing
    //
    *(my_other_array + 2) = 50; // This will change the content of the 3rd element in your array
    
    // Let's print the 3rd element using the normal square bracket method
    //
    printf("The third element in 'my_other_array' is %d\n", my_other_array[2]);

    // In C, a string is essentially an array of characters, here's three ways to declare/create a string.
    //
    // When declaring/defining a string, it's important to reserve the last character to be a null to indicate the end of the string
    //
    // The next line will declare/create a 10-character string
    //
    char my_string_way_1[10];
    
    // The next line will declare/create a 3-character string, where the last character is the null character (remember, the last character needs to always be the null character)
    //
    char my_string_way_2[] = {'a', 'b', '\0'};
    
    // Here's another way to declare/create a string. If we use double quotations then the a null character will automatically be added at the end; therefore, the length of the following string is 6 and not 5
    //
    char my_string_way_3[] = "Hello";
    
    // To print a string (array of characters), we use %s
    //
    printf("The string 'my_other_array' is %s\n", my_string_way_2);
    
    return 0;
    
}
