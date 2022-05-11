.data
	#gobal variables
	val1: .word 10
	val2: .word 20
	returnValue: .space 4
	
.text
	#main method
	lw $a0, val1($zero)	#argument 1
	lw $a1, val2($zero)	#argument 2
	jal returnMax	#jump and link to returnMax
	sw $v0, returnValue($zero)#store return value in returnValue
	
	addi $v0, $zero, 10
	syscall
	
	#functions
	returnMax:
	slt $t0, $a0, $a1
	bne $t0, $zero, ELSE
	add $v0, $a0, $zero
	jr $ra
	ELSE:
	add $v0, $a1, $zero
	jr $ra