#void main()
#{
#	int counter = 20;
#	int loc_arr[16];
#
# 	while(counter >= 5)
# 	{
# 		loc_arr[counter - 5] = 50;
# 		counter = counter - 1;
# 	}
#}

.data

.text
	main:
		addi $s0, $zero, 20 # counter
		addi $sp, $sp, -64 # stack pointer space
		addi $s1, $zero, 50 # constant
		
		LOOP:
			slti $t0, $s0, 5
			bne $t0, $zero, END
		
			addi $t0, $s0, -5 # sub 5
			sll $t0, $t0, 2 # multiply by 4
			add $t0, $t0, $sp
			sw $s1, 0($t0)
		
			addi $s0, $s0, -1
			j LOOP
		END:
		addi $v0, $zero, 10
		syscall