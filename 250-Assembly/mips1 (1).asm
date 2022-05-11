# C code:
#
# int arr[5];
#
# void ini_array(int arr_name[], int arr_size, int ini_value)
# {
#	int i;					# int i = 0;
#	for (i = 0; i < arr_size; arr++)	# begin:
#	{					# if (i < arr_size)
#		arr_name[i] = ini_value;	# {
#	}					#    	arr_name[i] = ini_value;
# }						# 	i = i + 1;
#						#	goto begin;
#						# }	
# int main()
# {
#	ini_array(arr, 5, 50);
#	return 0;
# }



.data
	# Since we have a global array, it needs to be declared in this section, and since 
	# we don't know the values of the elements in our array, we need to use the 
	# directive .space and provide the number of bytes to be allocated
	#
	arr: .space 20	# 20 = 5 * 4 bytes

.text
	main:
		# The first step is to place the arguments in $a0, $a1, and $a2
		#
		# Since the array is declared globally, the name of the array 'arr' will
		# contain the address of the first byte in the array
		#
		# To copy the address to the register 'a0', we use the command 'la' (load address)
		#
		# The command below will copy the address of the array to $a0
		#
		la $a0, arr
		
		# Now, we place the 2nd argument in $a1 (size of array)
		#
		addi $a1, $zero, 5
		
		# Finally, we place the 3rd argument in $a2 (50 is the value we want to initialize
		# our array to)
		#
		addi $a2, $zero, 50
		
		# We call the array. jal (Jump and Link) will place the address of the line 
		# after (addi $v0, $zero, 10) in $ra and transfer control to 'ini_array'
		#
		jal ini_array
		
		# This is how we exit our program properly.
		#
		addi $v0, $zero, 10
		
		# This will transfer the control back to the Operating System; when the value 
		# of $v0 is 10, it means that the program ended 'successfully' - return 0 in C;
		#
		syscall
	
	ini_array:
		add $t0, $zero, $zero		# int i = 0
		begin:				# begin:
		slt $t1, $t0, $a1		# if i < size, t1 will be 1, otherwise t1 will be 0
		beq $t1, $zero, after_loop	# if t1 = 0, which means if i is not < size, exit the loop
		
		addi $t3, $zero, 4		# temp = 4
		mul $t2, $t0, $t3		# t2 = i * 4 (to calculate the correct offset in bytes)
		
		add $t4, $a0, $t2		# We add the offset (in bytes) to the address of the array
		
		sw $a2, 0($t4)			# Here, we're changing the element at index i to the value 50
		
		addi $t0, $t0, 1		# i = i + 1
		j begin				# goto begin
		
		after_loop:
		jr $ra				# Return to main()
	