import os
from pathlib import Path
import Compile
import Run
import Unzip
import shutil
import os.path
import subprocess
from pathlib import Path

# notes:
    # folder with java files needs to be in assignment_directory
    # and called "grader"
    # grader file needs to be "assignment_file_name"_grader.java


#  set all directories
root_directory = "D:\\School\\221\\" # should not change
assignment_directory = root_directory + "lab4\\" # will change
submission_directory = assignment_directory + "individuals\\" # will change
assignment_file_name = "HW1Part2" # will change - this is the file to run
grader_file = assignment_file_name[:-5] + "_grader.java"
test_file = root_directory + "hw_1\\grading\\HW1Part2_test_file.txt"

java_path = "\"C:\\Program Files\\Java\\jdk1.8.0_131\\bin\\"
class_path = "-cp " + root_directory + "hw_1\\hw1_submissions\\CraggD\\"

output = []


with open(test_file) as tc:
    test_input = tc.readlines()
    # print(test_input)
# '''

cmd = java_path + "java.exe\" " + class_path + " " + assignment_file_name


for i in range(0, len(test_input),2):
    print("\trunning...")
    proc = subprocess.Popen(cmd, shell=True, stdin=subprocess.PIPE, stdout=subprocess.PIPE, stderr=subprocess.PIPE, universal_newlines=True)
    # output.append(proc.communicate(input=test_input[i])[0])
    output.append(proc.communicate(input=test_input[i]+""+test_input[i+1])[0])
    proc.wait()
    err = proc.communicate()[1]
    if len(err) > 0:
        print("\t" + proc.communicate()[1])
    else:
        print("\tSuccess!")
for i in output:
    print(i)
# '''