#int arr[20];
#void main()
#{
#	int counter = 0;
# 	int s0;
# 	int s1;
# 	for(s0 = 0; s0 < 5; s0++)
# 		for (s1 = 0; s1 < 4; s1++)
# 		{
# 			arr[counter] = s0 + s1;
#			counter = counter + 1;
# 		}
#}

.data
	arr: .space 80
.text
	main:
		addi $s2, $zero, 0	#counter
		addi $s0, $zero, 0	#outer loop
		OUTERLOOP:
			slti $t0, $s0, 5
			beq $t0, $zero, DONE
			addi $s1, $zero, 0
			INNERLOOP:
				slti $t0, $s1, 4
				beq $t0, $zero, NEXT
				
				sll $t1, $s2, 2
				add $t2, $s0, $s1
				sw $t2, arr($t1)
				
				addi $s2, $s2, 1
				addi $s1, $s1, 1
				j INNERLOOP
				
			NEXT:
			addi $s0, $s0, 1
			j OUTERLOOP
	DONE:
	addi $v0, $zero, 10
	syscall