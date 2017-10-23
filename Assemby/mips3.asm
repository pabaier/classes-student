# int arr[100]
# void ini_array(int name[], int size, int value)
# {
#	for(int i = 0; i < size; i++)
#
#
#

.data
	arr: .space 400
	
.text
	main:
	
		la $a0, arr # load address of array into a0
		addi $a1, $zero, 5 # might see li $a1, 100 (pseudo instruction)
		addi $a2, $zero, 50
	
		jal ini_array
	
	
	addi $v0, $zero, 10
	syscall
	
	ini_array:
		addi $t0, $zero, 0
		BEGIN:
		slt $t1, $t0, $a1
		beq $t1, $zero, AFTER_LOOP
		
		#mult $result, $first, $second
		addi $t3, $zero, 4
		mul $t2, $t0, $t3
		
		add $t4, $a0, $t2 #in order to iterate using sw, need to manually add array address and offset
		
		sw $a2, 0($t4)
		
		addi $t0, $t0, 1
		j BEGIN
		
		AFTER_LOOP:
		jr $ra