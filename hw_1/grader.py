import subprocess
import os
from pathlib import Path

# need to set variables file_name, testcases.txt, output.txt

# Folder Structure needs to be 
# -root (with this file)
# 	-folder with all submissions
# 		-student a
# 			-file.java
# 			-file.class
# 		-student b
# 			-file.java
# 			-file.class
								

root = Path()

root_contents = os.listdir()

# get folder where all submissions are stored
for c in root_contents:
	if os.path.isdir(c):
		submissions_folder = c

# get list of all student folders
student_folders = os.listdir(submissions_folder)

java_path = "\"C:\\Program Files\\Java\\jdk1.8.0_131\\bin\\"
file_name = "HW1Part1"

# get test cases
with open("testcases.txt") as tc:
	test_input = tc.read().splitlines();

# open or create file for output:
try:
	file = open("output.txt", 'w')
except IOError:
	file = open("output.txt", 'w')

	

for student in student_folders:
	
	file.write("\t" + student + "\n")
	print("\t" + student)

	class_path = "-cp " + submissions_folder + "\\" + student + "\\"

	cmd = java_path + "java.exe\" " + class_path + " " + file_name

	for i in range(0, len(test_input)):
		proc = subprocess.Popen(cmd, shell=True, stdin=subprocess.PIPE, stdout=subprocess.PIPE, universal_newlines=True)
		output = proc.communicate(input=test_input[i])[0]
		proc.wait()
		file.write(output)
		# if output.startswith("Error"):# or output.startswith("Traceback"):
			# pass
		# else:	
			# print(output.startswith("Error"))