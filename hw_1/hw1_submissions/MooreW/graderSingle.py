import subprocess
import os
from pathlib import Path

name = "MooreW"

class_path = "-cp D:\\School\\221\\hw_1\\hw1_submissions\\MooreW\\"
java_path = "\"C:\\Program Files\\Java\\jdk1.8.0_131\\bin\\"
file_name = "HW1Part1"

# get test cases
with open("testcases.txt") as tc:
	test_input = tc.read().splitlines();

# open or create file for output:
try:
	file = open("output.txt", 'a')
except IOError:
	file = open("output.txt", 'a')


file.write("\t" + name + "\n")
print("\t" + name)


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