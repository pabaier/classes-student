import zipfile
import os
import os.path
import shutil
import subprocess
from pathlib import Path

# This file unzips a file in the current directory, then
# unzips every file within the directory made from unzipping

# Folder Structure needs to be 
# -root (with this file)
# 	-AllSubmissions.zip
# 		

java_path = "\"C:\\Program Files\\Java\\jdk1.8.0_131\\bin\\"

def compile(file_path):
    cmd = java_path + "javac.exe\" " + file_path
    proc = subprocess.Popen(cmd, shell=True)
    print("compiling...")
    proc.wait()
    print("Done!")

def run(file_path, test_input=""):
    cmd = java_path + "java.exe\" " + file_path
    proc = subprocess.Popen(cmd, shell=True, stdin=subprocess.PIPE, stdout=subprocess.PIPE, universal_newlines=True)
    a = proc.communicate(input=test_input)[0]
    proc.wait()
    print(str(a))



def unzip():
    zip_file = input("Enter zip file name: ") + ".zip"
    sub_dir = input("Enter folder to extract to: ")
    temp_dir = sub_dir + "_temp"

    # set current path to root
    root = Path()

    # make a directory to unzip to
    os.mkdir(temp_dir)

    # make a directory to store submissions
    os.mkdir(sub_dir)

    # extract zip files
    print("...unzipping...")
    zipfile.ZipFile(zip_file, "r").extractall(temp_dir)
    print("done!")
        
    # remove index.html
    os.remove(temp_dir + "\index.html")    

    # get list of all files in zip directory
    all_files = os.listdir(temp_dir)
    print("...unzipping all submissions")
    for x in all_files:
        if x.endswith(".zip"):
            print(x)
            zipfile.ZipFile(temp_dir + "\\" + x, "r").extractall(sub_dir)
        else:
            print("ERROR - Could not unzip file : ")
            print("\t" + x)
    print("done!")

    # remove macosx folder
    shutil.rmtree(sub_dir + "\__MACOSX")

    # remove pycache folder
    shutil.rmtree("__pycache__")

    # remove temp unzip folder
    shutil.rmtree(temp_dir)

#

unzip()
# compile("Lab3.java")




# then go into the Submissions directory
# subFolder = root / "Submissions"
# get the zip file name there
# subZipFiles = os.listdir(subFolder)[0]
# extract zip file
# zipfile.ZipFile(p, "w").extractall(p)