#int var_s0;
addi $s0, $zero, 100

#int var_s1 = 50
addi $s1, $zero, 50

#add immediate
#zero is always value zero
#this would be like in c int x = 100
#addi target, source, immediate
##addi $s0, $zero, 100

#adds s0 and s1 and stores result in t0
#these two instructions are the same
#add destination, source, target
#int result_t0 = var_s0 + var_s1;
add $t0, $s0, $s1
##add $8, $16, $17

#t0 = s0 - s1
sub $t0, $s0, $s1

#int result_t1 = 40 - 12;

addi $t2, $zero, 40
addi $t3, $zero, -12
add $t1, $t2, $t3
#could also have done:


#int reult_t5 = result_t1;
#(these are the same)
addi $t5, $t1, 0
add $t5, $t1, $zero #this is nicer!

