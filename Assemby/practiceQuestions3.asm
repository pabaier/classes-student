.data

.text
	main:
	
	
	addi $sp, $sp, -400	#set stack pointer to -400 (allocate 400 bytes)
	add $a0, $sp, $zero	#set argument 0 to array memory address
	addi $a1, $zero, 100 	#set argument 1 to 100
	addi $a2, $zero,5 	#set argument 2 to 5
	jal iniArray	#jump and link to iniArray function (stores mem in $ra)
	
	addi $v0, $zero, 10
	syscall
	
	iniArray:
	add $t0, $zero, $zero	#counter i
	BEFORE:
	slt $t1, $t0, $a1	#is i < array size?
	beq $t1, $zero, AFTER	#if no, branch on equal to end of loop
			#sw $a2, i*4($a0)
	sll $t2, $t0, 2	#shift left logical immediate by 2 (multiply by 4
	add $t2, $t2, $a0	#add shift value to array address
	sw $a2, 0($t2)	#store a2 in array
	addi $t0, $t0, 1	#increment i by 1
	j BEFORE
	AFTER:
	jr $ra