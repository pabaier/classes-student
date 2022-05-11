#	int s1 = 5;
#	int s2 = 14;
#	int s3 = 19;
#	int s4 = 18;
#	int result = s1 - 15 - s2 - s4 + s3;
addi $s1, $zero, 5
addi $s2, $zero, 14
addi $s3, $zero, 19
addi $s4, $zero, 18

addi $s0, $s1, -15
sub $s0, $s0, $s2
sub $s0, $s0, $s4
add $s0, $s0, $s3


#	int s1 = 11;
#	int s2 = 19;
#	int s3 = 9;
#	int s4 = 12;
#	int result = s4 - s1 + s2 + s4 - 19;

addi $s1, $zero, 11
addi $s2, $zero, 19
addi $s3, $zero, 9
addi $s4, $zero, 12

sub $s0, $s4, $s1
add $s0, $s0, $s2
add $s0, $s0, $s4
addi $s0, $s0, -19
