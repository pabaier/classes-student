import zipfile
import os
import os.path
import shutil
import subprocess
from pathlib import Path


def compile(file_path, java_path = "\"C:\\Program Files\\Java\\jdk1.8.0_131\\bin\\"):
    cmd = java_path + "javac.exe\" " + file_path
    print("\tcompiling...")
    proc = subprocess.Popen(cmd, shell=True, stdout=subprocess.PIPE, stderr=subprocess.PIPE)
    out, err = proc.communicate()
    proc.wait()
    if len(err) > 0:
        print("\t" + str(err)[0:100])
    else:
        print("\tDone!")

def main():
    pass
if __name__ == "__main__":
    main()