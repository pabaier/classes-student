 

.data
	counter: .word 0

.text
	MAIN:
	addi $a0, $zero, 5	#set argument to 5
	jal CHANGE_GLOBAL	#jump and link to function change_global
	
	addi $a0, $zero, 10	#set argument to 10
	jal CHANGE_GLOBAL	#jump and link to function change_global
	
	addi $v0, $zero, 10
	syscall
	
	CHANGE_GLOBAL:
	lw $t0, counter($zero)
	add $t0, $t0, $a0
	sw $t0, counter($zero)
	jr $ra
