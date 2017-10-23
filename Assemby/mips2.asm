# int s0 = 10
# int s1 = 20
#
# if (s0 < s1)
#    s0 = 100
# else
#    s1 = 100

slt $t0, $s0, $s1
beq $t0, $zero, ELSE
addi $s0, $zero, 100
j EXIT
ELSE:
addi $s1, $zero, 100
EXIT:

#This code just "returns" (exits program)
addi $v0, $zero, 10
syscall

# int s0 = 10
# int s1 = 20
#
# if (s0 == s1)
#    s0 = 100
# else
#    s1 = 100

addi $s0, $zero, 10
addi $s1, $zero, 20
bne $s0, $s1, ELSE
addi $s0, $zero, 100
j EXIT
#ELSE:
addi $s1, $zero, 100
#EXIT: