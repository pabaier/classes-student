import zipfile
import os
import os.path
import shutil
from pathlib import Path

# cutting and making directories
# dir = "directory/"
# contents = os.listdir(dir)
# x = 1
# for name in contents:
#     name = name[:7] + str(x)
#     try:
#         os.mkdir(dir + name)
#     except OSError as e:
#         print(e)
#     x = x + 1

# listing directory
# dir = os.listdir()
# for name in dir:
#     print(name)
# print(dir[2])

# printing directory names
# print (os.listdir())
# print(str(len([name for name in os.listdir('.') if os.path.isfile(name)])))
# print(str(len([name for name in os.listdir('directory/')])))


# create folders
# for i in range(5):
#     try:   
#         os.makedirs(str(i))
#     except OSError as e:
#         print(e)

# working it out HERE
# current = Path()
# running = 1
# select = 0
# while running > 0:
#     digit = True
#     directory = os.listdir(current)
#     print(directory)
#     select = input("Make a selection (-1 or q to exit) ")
#     try:
#         select = int(select)
#     except ValueError:
#         digit = False
    
#     if digit:
#         if select == -1:
#             running = -1
#         elif select < len(directory) and select >= 0:
#             if os.path.isdir(directory[select]):
#                 os.chdir(directory[select])
#             elif directory[select][-4:] == ".zip":
#                 print("It's a zip!")
#                 zipfile.ZipFile("Submissions.zip", "r").extractall()

#         else:
#             print("Invalid Option!\n")
#     else:
#         if select == "..":
#             os.chdir("..")
#         elif select == "q":
#             running = -1
#         elif select == "d":
#             input("Make delete selection")



# # set current path to root
# root = Path()
# # extract zip files
# zipfile.ZipFile("Submissions.zip", "w").extractall()
# # then delete the macosx folder
# shutil.rmtree("__MACOSX")
# # then go into the Submissions directory
# subFolder = root / "Submissions"
# # get the zip file name there
# subZipFiles = os.listdir(subFolder)[0]
# # extract zip file
# zipfile.ZipFile(p, "w").extractall(p)

# #reset test
# input("Hit Enter to Reset")
# shutil.rmtree("Submissions")

# ****COUNT FILES IS DIRECTORY ****
# import os, os.path

# # simple version for working with CWD
# print len([name for name in os.listdir('.') if os.path.isfile(name)])

# # path joining version for other paths
# DIR = '/tmp'
# print len([name for name in os.listdir(DIR) if os.path.isfile(os.path.join(DIR, name))])



# ****EXTRACT ZIPPED FILES ****
# import zipfile
# with zipfile.ZipFile("file.zip","r") as zip_ref:
#     zip_ref.extractall("targetdir")



# ****СREATE FOLDERS ****
# import os

# def my_function():
#     path = input("Enter dir name or full path.")
#     try:   
#         os.makedirs(path)
#     except OSError as e:
#         print(e)


# ************COMPILING JAVA FILES **************
import subprocess
import time

java_path = "\"C:\\Program Files\\Java\\jdk1.8.0_131\\bin\\"

def compile(file_name):
    cmd = java_path + "javac.exe\" " + file_name # + " Lab3.java"
    proc = subprocess.Popen(cmd, shell=True)#, env = {'PATH': r"C:\Program Files\Java\jdk1.8.0_131\bin\javac.exe"})
    print("compiling...")
    proc.wait()
    print("Done!")

def run(file_name, test_input=""):
    cmd = java_path + "java.exe\" " + file_name# + " Lab3.java"
    
    proc = subprocess.Popen(cmd, shell=True, stdin=subprocess.PIPE, stdout=subprocess.PIPE, universal_newlines=True)
    a = proc.communicate(input=test_input)[0]
    proc.wait()
    print(str(a))

    # for x in proc.stdout:
    #     print(x)
    # print(proc.stdout.readline())
    # print(proc.stdout.readline())

compile("Lab3.java")
run("Lab3")