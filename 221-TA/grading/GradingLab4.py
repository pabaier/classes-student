import os
from pathlib import Path
import Compile
import Run
import Unzip
import shutil


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



"""
# unzipping
# get files in submission folder
unzip_all_files_in_directory = os.listdir(assignment_directory)
for x in unzip_all_files_in_directory:
    if x.endswith(".zip"):
        try:
            Unzip.unzip(assignment_directory + "\\" + x)
        except:
            pass       
"""
###### end unzipping #####

# running

# process: go through submission_directory
#           go into each submission
#           copy file to grader folder
#           run java script 

# create output file (w means write, a means append)
try:
	output_file = open(assignment_directory + "grader\\output.txt", 'a')
except IOError:
	output_file = open(assignment_directory + "grader\\output.txt", 'w')
output_file.write(submission_directory + "\n\n")

# get all submission folders (absolute paths)
student_folders_list_temp = os.listdir(submission_directory)
student_folders_list = []
for x in student_folders_list_temp:
    if Path(submission_directory + x).is_dir():
        student_folders_list += [submission_directory + x + "\\"]
###
# go through each folder, get all the files, go through all of the files,
# copy the assignment file to the grader directory, compile it, and run it
for student in student_folders_list:
    # get files in student's folder
    files = os.listdir(student)
    student_name = student[student.rfind("\\", 0, len(student)-1) + 1:len(student)-1]

    # go through the files
    counter = 0
    for file in files:
        if file == assignment_file_name and not Path(student + file).is_dir():
            x = shutil.copy(student + file, assignment_directory + "grader\\")
            # append name to bottom of file
            of = open(assignment_directory + "grader\\" + file, 'a')
            of.write("//" + student_name[0:-1])
            of.close()
            try:
                os.remove(assignment_directory + "grader\\" + file[:-5] + ".class")
            except:
                pass
            print(student_name)
            output_file.write("\t" + student_name + "\n")
            Compile.compile(assignment_directory + "grader\\" + file)
            out = Run.run(assignment_directory + "grader\\" + grader_file) # run(full file path, full test input path)
            for j in out:
                # print(j + "\n")
                output_file.write(j + "\n")
            counter += 1
    if counter < 1 or counter > 1:
        output_file.write(student_name + " error with file name" + "\n\n")
        # print(student + " error with file name" + "\n")