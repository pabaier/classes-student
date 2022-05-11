import os
from pathlib import Path
import Compile
import Run
import Unzip

#  set all directories
root_directory = "D:\\School\\221\\" # should not change
assignment_directory = root_directory + "hw_1\\" # will change
submission_directory = assignment_directory + "hw1_submissions\\" # will change
assignment_file_name = "HW1Part2.java" # will change - this is the file to run
# test_file = os.path.abspath("HW1Part2_test_file.txt") # will change

test_file = root_directory + "hw_1\\grading\\HW1Part2_test_file.txt"

#  get all submission folders (absolute paths)
sub_folders_temp = os.listdir(submission_directory)
submission_directory_folders = []

for x in sub_folders_temp:
    if Path(submission_directory + x).is_dir():
        submission_directory_folders += [submission_directory + x + "\\"]

# open or create file for output:
try:
	file = open("output.txt", 'w')
except IOError:
	file = open("output.txt", 'a')

"""
# compile all files in submission folders
# student_folder is absolute path, everything else is relative
for student_folder in submission_directory_folders:
    student_files = os.listdir(student_folder)
    for f in student_files:
        if f.endswith(".java"): # or if f == assignment_file_name:
            Compile.compile(student_folder + f)
"""

#  run all files in submission folders
# student_folder is absolute path, everything else is relative
for student_folder in submission_directory_folders: 
    student_files = os.listdir(student_folder)
    file.write(student_folder + "\n")
    print(str(student_folder))

    for f in student_files:
        if f == assignment_file_name:
            print(student_folder + f)
            out = Run.run(student_folder + f, test_file) # run(full file path, full test input path)
            for j in out:
                file.write(j + "\n")


# for x in submission_directory_folders:
#     print(x)
# print(submission_directory_folders)
# print(len(submission_directory_folders))