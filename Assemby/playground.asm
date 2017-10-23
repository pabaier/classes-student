
	addi $t2, $zero, 1
	not $t1, $t2 
	
	nor $t3, $t2, $t2
	nor $t4, $t2, $zero
	
	
	#addi $t3, $zero, -1
	#lui $t3, 0xffff
	#ori $t3, $t3, 0xffff
	#xor $t3, $t2, $t3	
	
	#xori $t3, $t2, 0xffffffff
	
	addi $v0, $zero, 10
	syscall

.text
	MAIN:
		addi $a0, $zero, 7
		addi $a1, $zero, 8
		addi $a2, $zero, 9
		addi $a3, $zero, 10
		
		jal LEAF_EXAMPLE
		
		addi $v0, $zero, 10
		syscall
		
	LEAF_EXAMPLE:
		add $v0, $a0, $a1
		sub $v0, $v0, $a2
		sub $v0, $v0, $a3
		jr $ra
