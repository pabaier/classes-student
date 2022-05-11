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
		add $s2, $zero, $zero	#set counter to 0
		addi $s0, $zero, 0	#set s0 to 0
		
		LOOPONE:		#label first loop
		slti $t0, $s0, 5	#check inequality
		beq $t0, $zero, END	#branch to end if greater than 5
		addi $s1, $zero, 0	#set s1 to 0
		
		LOOPTWO:		#label second loop
		slti $t0, $s1, 4	#check inequality
		beq $t0, $zero, ENDSECOND#
		
		#loop 2 body
		add $t1, $s0, $s1	#sums s0 and s1
		sll $t2, $s2, 2	#multiply counter by 4
		sw $t1, arr($t2)	#set the array value to sum
		addi $s2, $s2, 1	#increment counter
		addi $s1, $s1, 1	#increment s1
		j LOOPTWO		#jump to top of loop two
		###########

		ENDSECOND:
		addi $s0, $s0, 1
		j LOOPONE
		
		
		
		END:
		
		addi $v0, $zero, 10
		syscall
