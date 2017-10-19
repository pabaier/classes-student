# runs test cases through solutions

import subprocess
import os
from pathlib import Path

# get test cases
with open("testcases.txt") as tc:
	test_input = tc.read().splitlines();
	
# open or create file for output:
try:
	file = open("solutionOutput.txt", 'w')
except IOError:
	file = open("solutionOutput.txt", 'w')
	
# class_path = "-cp " + submissions_folder + "\\" + student + "\\"

file_name = "SyllableCounterSolution"

java_path = "\"C:\\Program Files\\Java\\jdk1.8.0_131\\bin\\"
cmd = java_path + "java.exe\" " + file_name

for i in range(0, len(test_input)):
	proc = subprocess.Popen(cmd, shell=True, stdin=subprocess.PIPE, stdout=subprocess.PIPE, universal_newlines=True)
	output = proc.communicate(input=test_input[i])[0]
	proc.wait()
	file.write(output)