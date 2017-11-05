import zipfile
import os
import os.path
import shutil
import subprocess
from pathlib import Path

zip_file = "D:\\School\\221\\hw_3\\hw3.zip"

separator = zip_file.rfind("\\")
zip_file_directory = zip_file[:separator]

sub_dir = zip_file[:-4]

# make a directory to unzip to
os.mkdir(sub_dir)

# extract zip files
print("...unzipping...")
zipfile.ZipFile(zip_file, "r").extractall(sub_dir)
print("done!")
    
# remove index.html
os.remove(sub_dir + "\index.html")    

# get list of all files in zip directory
student_zip_collection = os.listdir(sub_dir)
print("...unzipping all submissions in " + sub_dir )
for x in student_zip_collection:
    if x.endswith(".zip"):
        print(x)
        zipfile.ZipFile(sub_dir + "\\" + x, "r").extractall(sub_dir)
        os.remove(sub_dir + "\\" + x)
    else:
        print("ERROR - Could not unzip file : ")
        print("\t" + x)
print("done!")
