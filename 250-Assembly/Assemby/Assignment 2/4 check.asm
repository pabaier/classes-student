#int counter = 0;
#
#void change_global(int value)
#{
#	counter = counter + value;
#} 
#
#void main()
#{
#	change_global(5);
#	change_global(10);
#}

.data
	counter: .word 0
	
.text
	main:
		addi $a0, $zero, 5
		jal change_global
		
		addi $a0, $zero, 10
		jal change_global
		
		addi $v0, $zero, 10
		syscall
	
	change_global:
		lw $t0, counter($zero)
		add $t0, $t0, $a0
		sw $t0, counter($zero)
		jr $ra