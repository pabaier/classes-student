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
	MAIN:
	addi $t0, $zero, 20
	addi $sp, $sp, -64
	
	addi $t3, $zero, 50	#t3 is 50
	TOP:
	slti $t1, $t0, 5
	bne $t1, $zero, AFTER
	#LOOP BODY
	addi $t2, $t0, -5	#gets counter -5 in t2
	sll $t2, $t2, 2	#multiply index by 4
	add $t2, $t2, $sp	#gets the memory value of the array indexed
	sw $t3, 0($t2)	#stores 50 into appropriate index
	addi $t0, $t0, -1	#decrement counter
	j TOP		#jump to the top
	###
	AFTER:
	
	addi $v0, $zero, 10
	syscall
	