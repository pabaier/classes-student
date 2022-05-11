# C code:
#
# int global_result;
# int sum_array(int arr[], int size)
# {
#	int i = 0;				# i = 0;
#	int sum = 0				# begin:
#	for (; i < size; i++)			# if (i < size) 
#	{					# {			
#		sum = sum + arr[i];		#	sum = sum + arr[i];
#	}					#	i = i + 1;
#	return sum;				#	goto begin;
# }						# }
# void main()
# {
#	int my_array[] = {2, 5, 1, 5};
#	global_result = sum_array(my_array, 4);
# }


.data
	global_result: .space 4		# Here, we allocate 4 bytes for our global int
.text
	main:
		addi $sp, $sp, -16	# The array is declared locally, and hence should live in the stack
		
		addi $t0, $zero, 2	# t0 = 2
		sw $t0, 0($sp)		# my_array[0] = t0
		
		addi $t0, $zero, 5	# t0 = 5
		sw $t0, 4($sp)		# my_array[1] = t0
		sw $t0, 12($sp)		# my_array[3] = t0
		
		addi $t0, $zero, 1	# t0 = 1
		sw $t0, 8($sp)		# my_array[2] = t0
		
		add $a0, $sp, $zero	# a0 = my_array, first argument
		addi $a1, $zero, 4	# a1 = 4, second argument
		
		jal sum_array		# calling the function 'sum_array'
		
		sw $v0, global_result($zero)	# global_result = value returned by 'sum_array'
		
		# This is how we exit our program properly.
		#
		addi $v0, $zero, 10
		
		# This will transfer the control back to the Operating System; when the value 
		# of $v0 is 10, it means that the program ended 'successfully' - return 0 in C;
		#
		syscall
		
	sum_array:
		add $t0, $zero, $zero	# i = 0
		add $v0, $zero, $zero	# sum = 0 
		beg:
		slt $t1, $t0, $a1		# if i < size, t1 will be 1, otherwise t1 will be 0
		beq $t1, $zero, after_loop	# if t1 = 0, which means if i is not < size, exit the loop
		
		sll $t2, $t0, 2		# t2 = i * 4 (to calculate offset in bytes)
		
		add $t3, $t2, $a0	# t3 = t2 + my_array (to calculate absolute address of element)
		
		lw $t4, 0($t3)		# t4 = element located at t3. Or, t4 = my_array[i]
		
		add $v0, $v0, $t4	# sum = sum + t4
		
		addi $t0, $t0, 1	# i = i + 1
		
		j beg			# goto begin
		
		after_loop:
		
		jr $ra			# return to main, sum is in $v0