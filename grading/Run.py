import os
import os.path
import shutil
import subprocess
from pathlib import Path

def run(full_file_path="", test_input_file="", java_path = "\"C:\\Program Files\\Java\\jdk1.8.0_131\\bin\\"):

    # get input test cases
    if test_input_file != "":
        with open(test_input_file) as tc:
            test_input = tc.readlines()#.splitlines();
    else:
        test_input = [" "]

    output = []

    separator = full_file_path.rfind("\\") + 1
    if separator > 0:
        # get file name
        file_path = "\"" + full_file_path[:separator - 1]
        file_name = full_file_path[separator:full_file_path.rfind(".")]

        # set classpath
        class_path = "-cp " + file_path + "\""

        cmd = java_path + "java.exe\" " + class_path + " " + file_name

    else:
        cmd = java_path + "java.exe\" " + full_file_path[:full_file_path.rfind(".")]

    for i in range(0, len(test_input),2):
        print("\trunning...")
        proc = subprocess.Popen(cmd, shell=True, stdin=subprocess.PIPE, stdout=subprocess.PIPE, stderr=subprocess.PIPE, universal_newlines=True)
        output.append(proc.communicate(input=test_input[i])[0])
        # output.append(proc.communicate(input=test_input[i]+""+test_input[i+1])[0])
        proc.wait()
        err = proc.communicate()[1]
        if len(err) > 0:
            print("\t" + proc.communicate()[1])
        else:
            print("\tSuccess!")

    return output

def main():
    pass
if __name__ == "__main__":
    main()

# run solution and single files
# x = run("D:\\School\\221\\hw_1\\hw1_submissions\\JacksonS\\HW1Part2.java", "D:\\School\\221\grading\\HW1Part2_test_file.txt")
# for a in x:
#     print(a)

# x = run("D:\\School\\221\\hw_1\\hw1_submissions\\PappasS\\HWPart2.java", "D:\\School\\221\grading\\HW1Part2_test_file.txt")
# x = run("\"D:\\School\\221\\grading scripts\\test.java\"", "D:\\School\\221\\grading scripts\\testInput.txt")