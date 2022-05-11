# int sum_array(int arr[], int size){
#
#	int i = 0;
#	for(;i < size; i++)
#		sum = sum + arr[i];
#	return sum;
#}	
#
# int global_result;
#
# void main(){
#
#	int my_array[] = {2, 5, 1, 5};
#	global_result = sum_array(my_array, 4);
#
#}
.data
	global_result: .space 4

.text
	main:
		#declaire array and store values
		addi $sp, $sp, -16
		addi $t0, $zero, 2
		sw $t0, 0($sp)
		
		addi $t0, $zero, 5
		sw $t0, 4($sp)
		sw $t0, 12($sp)
		
		addi $t0, $zero,1
		sw $t0, 8($sp)

		#set first function argument to array location
		add $a0, $sp, $zero #move $a0, $sp
		addi $a1, $zero, 4
		jal sum_array
		
		#after the function, store the return value in global_result
		sw $v0, global_result($zero)
			
		addi $v0, $zero, 10
		syscall
		
	sum_array:
		addi $t0, $zero, 0
		add $v0, $zero, $zero
		BEG:
		slt $t1, $t0, $a1
		beq $t1, $zero, AFTER_LOOP
		# calculate offset
		sll $t2, $t0, 2 # shift left logical
		# add offset to beginning of array location
		add $t3, $t2, $a0
		# load array value
		lw $t4, 0($t3)
		# add
		add $v0, $v0, $t4
		addi $t0, $t0, 1
		j BEG
		
		AFTER_LOOP:
		jr $ra