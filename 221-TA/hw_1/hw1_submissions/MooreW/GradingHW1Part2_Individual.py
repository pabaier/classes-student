import os
from pathlib import Path
import shutil
import os.path
import subprocess
from pathlib import Path

# notes:
    # folder with java files needs to be in assignment_directory
    # and called "grader"
    # grader file needs to be "assignment_file_name"_grader.java


name = "MooreW"

class_path = "-cp D:\\School\\221\\hw_1\\hw1_submissions\\MooreW\\"
java_path = "\"C:\\Program Files\\Java\\jdk1.8.0_131\\bin\\"
file_name = "HW1Part2"

output = []

with open("D:\\School\\221\\hw_1\\hw1_submissions\\MooreW\\HW1Part2_test_file.txt") as tc:
    test_input = tc.readlines()
    # print(test_input)
# '''

cmd = java_path + "java.exe\" " + class_path + " " + file_name


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