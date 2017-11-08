import os
from pathlib import Path
import shutil
import Run


# notes:
    # folder with java files needs to be in assignment_directory
    # and called "grader"
    # grader file needs to be "assignment_file_name"_grader.java

#  set all directories
root_directory = "D:\\School\\221\\" # should not change
assignment_directory = root_directory + "lab4\\" # will change
submission_directory = assignment_directory + "individuals\\" # will change
assignment_file_name = "Lab4.java" # will change - this is the file to run
grader_file = assignment_file_name[:-5] + "_grader.java"

working_dir = "D:\\School\\221\\lab4\\individuals\\WashingtonM"
student_name = "WashingtonM"

# create output file (w means write, a means append)
try:
	output_file = open(working_dir + "\\output.txt", 'a')
except IOError:
	output_file = open(working_dir + "\\output.txt", 'w')
output_file.write(working_dir + "\n\n")

print(student_name)
output_file.write("\t" + student_name + "\n")
out = Run.run(working_dir + "\\Lab4_grader.java") # run(full file path, full test input path)
for j in out:
    # print(j + "\n")
    output_file.write(j + "\n")
