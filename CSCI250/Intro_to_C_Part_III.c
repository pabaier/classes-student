//
/*  main.c
 
 Intro to C Part III
 
 Created by Ayman Hajja on 1/19/17.
 Copyright © 2017 college_of_charleston. All rights reserved.
 */

#include <stdio.h>

// This is a function that will accept a value of type 'int' and store it in 'cv_variable'; the function will then change the value of 'cv_variable'; that being said, changing the value of 'cv_variable' will not affect the value of the variable being passed to this function
//
void change_variable(int cv_variable)
{
    cv_variable = cv_variable + 20;
}

void change_variable_pointer(int *address_of_int)
{
    // Recall that when we use '*' before a pointer: '*some_pointer' (thta is not in a declaration line), then we are essentially referring to the variable being pointed to by 'some_pointer', which is 'my_int' in this case (refer to function call below), since we passed the address of 'my_int'
    //
    // That means that the line below can be essentially viewed as: my_int = my_int + 10
    //
    // ...and that's how we are able to change 'my_int' without returning a value
    //
    *address_of_int = *address_of_int + 10;
}

int main()
{
    // The next line will declare a variable of type int and will initialize it to the value 10
    //
    int my_int = 10;
    
    // In C, when we pass a variable to a function, the arguments are passed by 'value', meaning that the variables declared in the function header (parameters) will only have a copy of the *values* being passed
    //
    printf("The value of my_int before calling change_variable is %d\n", my_int);
    change_variable(my_int);
    printf("The value of my_int after calling change_variable is %d\n", my_int);
    
    // We notice here that the value of 'my_int' didn't change, even though we changed the value of the parameter 'cv_variable' (refer to function above). This is because only the value was passed to the parameter, and changing the parameter won't affect the argument since they are two entirely different/independent variables
    
    
    // Important Note: Each variable has a value and each variable has an address in the main memory
    //
    // To get the address of any variable, we use the reference (or address-of: '&') operator
    //
    // '&some_variable' will return the address of 'some_variable'
    //
    // We can also declare a variable of type 'pointer to an int'. A data-type 'pointer to an int' means that the value of that pointer variable will be an address of an int. Another way of looking at it would be that the value of that variable will point to another variable of type int, hence the name 'pointer'
    //
    // Here's how we declare a variable of type 'pointer to an int'
    //
    int *my_int_p;
    
    // Since we declare the variable 'my_int_p' to be a pointer to an int, then we can only assign the variable an address of some integer.
    //
    my_int_p = &my_int;
    
    // Note here that in the line above, we didn't use the asterisk. There is only two places/ways where we would use the asterisk in the context of pointers. The first one is when we declare/define the variable, we use it to indicate to the C compiler that the data-type is a pointer; we'll show and explain the second way/use for an asterisk in few lines...
    //
    
    // To print the address of 'my_int', we can either use 'my_int_p' or use the address-of operator '&'
    //
    printf("(using my_int_p) The address of my_int is %p\n", my_int_p);
    printf("(using &my_int) The address of my_int is %p\n", &my_int);
    
    // Note here that we used the letter 'p', which stands for pointer
    //
    
    // Now let's talk about the second way that we can use an asterisk in the context of pointers.
    //
    // If you precede a 'pointer' variable with an asterisk, then the C compiler will replace both the asterisk and the pointer with the variable that the pointer is pointing to
    //
    // For example: '*my_int_p' will essentially be equivalent to 'my_int', since 'my_int_p' is pointing to 'my_int'
    //
    printf("To obtain the value of my_int using *my_int_p. The value of my_int is %d\n", *my_int_p);
    
    // The function call in the next line will call 'change_variable_pointer' and pass the address of 'my_int' to the function. The function call below will add 10 to 'my_int'. Refer to the function for what and how the function works
    //
    change_variable_pointer(my_int_p);
    
    // The line below is identical to the line above; it will add another 10 to 'my_int
    //
    change_variable_pointer(&my_int);
    
    // Now if we print the value of 'my_int' we will get 30
    //
    printf("The value for my_int after calling change_variable_pointer twice is %d\n", my_int);
    
    return 0;
}
