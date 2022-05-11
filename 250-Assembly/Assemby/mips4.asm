#void main()
#{
#	int s0 = 5;
#	int s1 = 10;
#	firstFun(s0, s1)
#}
#void firstFun(int v1, int v2){
#
#	int s0 = v1 + v2
#	secondFun(s0);
#	secondFun(v1)
#	secondFun(v2)
#}
#int secondFun(int v1){
#
#	return v1 + v1;
#
#
#}

.text
	MAIN:
		addi $s0, $zero, 5
		addi $s1, $zero, 10
	
		add $a0, $s0, $zero
		add $a1, $s1, $zero
	
		jal firstFun
	
		addi $v0, $zero, 10
		syscall
	firstFun:
		addi $sp, $sp, -16 #free space for $ra $s0, $a0, $a1
		sw $s0, 0($sp)
		sw $ra, 4($sp)
		sw $a0, 8($sp)
		sw $a1, 12($sp)
		
		add $s0, $a0, $a1
		add $a0, $s0, $zero
		jal secondFun
		
		lw $a0, 8($sp)
		jal secondFun
		
		lw $a0, 12($sp)
		jal secondFun
		
		lw $s0, 0($sp)
		lw $ra, 4($sp)
		addi $sp, $sp, 16
		jr $ra
	
	secondFun:
		add $v0, $a0, $a0
		jr $ra
