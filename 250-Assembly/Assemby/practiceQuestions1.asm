.data
	#global
	globalValue: .word 10

.text
	#main
	
	addi $a0, $zero, 5	#function arguments go in a registers
	jal addToGlobal	#jump and link to the function
	sw $v0, globalValue($zero)
	
	addi $v0, $zero, 10
	syscall
	
	
	#functions
	addToGlobal:
	lw $t0, globalValue($zero)#get the value of globalValue
	bne $a0,$t0, ELSE	#branch if not equal to else
	addi $v0, $a0, 10	#add 10 to the argument
	#j AFTER		#jump to after the else statement
	jr $ra
	ELSE:
	addi $v0, $zero, 0	#set return value to 0
	#AFTER:
	jr $ra		#jump return to return address
	