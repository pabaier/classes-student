import os
import os.path
import shutil
import subprocess
from pathlib import Path

# Folder Structure needs to be 
# -root (with this file)
# 	-folder with all submissions
# 		-student a
# 			-file.java
# 			-file.class
# 		-student b
# 			-file.java
# 			-file.class

# set append to 'a' to append the output file, 'w' to write over it

def run(file_path="", test_input_path, output_file_path="output.temp", append='a' java_path = "\"C:\\Program Files\\Java\\jdk1.8.0_131\\bin\\"):
    cmd = java_path + "java.exe\" " + file_path
    proc = subprocess.Popen(cmd, shell=True, stdin=subprocess.PIPE, stdout=subprocess.PIPE, universal_newlines=True)
    a = proc.communicate(input=test_input)[0]
    proc.wait()
    print(str(a))

    root = os.Path()

    root_contents = os.listdir()

    # get test cases
    with open(test_input_path) as tc:
        test_input = tc.read().splitlines();

    # open or create file for output:
    try:
        output_file = open(output_file_path, append)
    except IOError:
        output_file = open(output_file_path, append)

    for student in student_folders:
        
        output_file.write("\t" + student + "\n")
        print("\t" + student)

        class_path = "-cp " + submissions_folder + "\\" + student + "\\"

        cmd = java_path + "java.exe\" " + class_path + " " + file_path

        for i in range(0, len(test_input)):
            proc = subprocess.Popen(cmd, shell=True, stdin=subprocess.PIPE, stdout=subprocess.PIPE, universal_newlines=True)
            output = proc.communicate(input=test_input[i])[0]
            proc.wait()
            output_file.write(output)