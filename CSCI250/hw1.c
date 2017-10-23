#include <stdio.h>

void swap(int *p1, int *p2){
    int temp = *p1;
    *p1 = *p2;
    *p2 = temp;
}

//The 'swap' function should swap the values of two integers.

int main()
{
    //Question 1

 	int x = 70;
 	int y = 20;
 	// You must figure out how to call the function correctly (include this in your answer)
 	// Next line should print out x: 20, y: 10
 	//
 	swap(&x, &y);
 	printf("x: %d, y: %d\n", x, y);

 	//Question 2

 	int counter;
 	int fib[20];
 	*fib = 0;
 	*(fib + 1) = 1;
 	for(counter = 2; counter < 20; counter++){
        *(fib + counter) = *(fib + counter - 1) + *(fib + counter - 2);
 	}

 	for(counter = 0; counter < 20; counter++){
        printf("%p, %d\n", fib + counter, *(fib + counter));
 	}

 	return 0;
}
