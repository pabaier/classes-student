import zipfile
import os
import os.path
import shutil
import subprocess
from pathlib import Path

def unzip(zip_file, java_path = "\"C:\\Program Files\\Java\\jdk1.8.0_131\\bin\\"):

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

    # remove macosx folder
    shutil.rmtree(sub_dir + "\__MACOSX")

    # remove pycache folder
    # shutil.rmtree("__pycache__")

    # remove temp unzip folder
    # shutil.rmtree(sub_dir)

def main():
    pass
if __name__ == "__main__":
    main()
