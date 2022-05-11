from glob import glob
from natsort import natsorted
import json
from .Indexer import Indexer
import os
from pathlib import Path


class FileSystem:
    def __init__(self):
        (self.folder, self.folder_number) = FileSystem.get_most_recent_folder()
        # self.file stores an absolute path to the file
        (self.file, self.file_number) = self.get_most_recent_file_in_folder()
        self.dir_path = os.path.dirname(os.path.realpath(__file__))
        self.indexer = Indexer()
        try:
            self.indexer.build_indexer()
        except:
            pass

    def update_folder(self):
        (self.folder, self.folder_number) = FileSystem.get_most_recent_folder()

    def update_file(self):
        (self.file, self.file_number) = self.get_most_recent_file_in_folder()

    @staticmethod
    def get_most_recent_folder():
        dir_path = os.path.dirname(os.path.realpath(__file__))
        dirs = natsorted(glob(f'{dir_path}/data/*/'), reverse=True)
        return dirs[0], len(dirs)

    def get_most_recent_file_in_folder(self, folder=None):
        if folder is None:
            folder = self.folder
        all_files = glob(folder + '*')
        most_recent_file = max(all_files, key=os.path.getctime)
        return most_recent_file, len(all_files)

    def get_last_transaction(self):
        file = self.file
        lines = self.get_number_of_lines(file)
        # if the file is not empty, get the latest line written
        if lines > 0:
            return FileSystem.get_line(file, lines)
        # if the file number is greater than one, use the previous file
        elif self.file_number > 1:
            file_number = self.file_number - 1
            file = f'{self.folder}/{file_number}.pab'
            lines = self.get_number_of_lines(file)
            return FileSystem.get_line(file, lines)
        # go into the previous directory and get the latest file from there
        else:
            folder_number = self.folder_number - 1
            folder = f'{os.path.dirname(os.path.realpath(__file__))}/data/{folder_number}/'
            print(folder)
            (file, _) = self.get_most_recent_file_in_folder(folder)
            print(file)
            lines = self.get_number_of_lines(file)
            return FileSystem.get_line(file, lines)

    # used to write data to the latest file
    def write(self, data):
        with open(self.file, "r+") as file:
            contents = file.readlines()
            lines = int(contents[0].rstrip('\r\n'))
            contents[0] = str(lines + 1) + "\n"
            file.seek(0)
            file.truncate()
            file.writelines(contents)
            file.writelines(data + '\n')
            self.indexer.add(data, self.folder_number, self.file_number, lines + 1)
            # make new file after 1000th line (write 1000 lines per file)
            if lines >= 1000:
                self.make_new_file()

    def make_new_file(self):
        # make a new folder if the current folder contains 1000 files (each folder contains 1000 files)
        if self.file_number >= 1000:
            self.make_new_folder()
        self.file_number = self.file_number + 1
        self.file = self.folder + '' + str(self.file_number) + '.pab'
        with open(self.file, "w+") as file:
            file.write('0')

    def make_new_folder(self):
        dir_path = os.path.dirname(os.path.realpath(__file__))
        self.folder_number = self.folder_number + 1
        self.folder = f'{dir_path}/data/{str(self.folder_number)}/'
        self.file_number = 0
        os.makedirs(self.folder)

    def get_transaction(self, tid):
        tuples = self.indexer.get_transaction(tid)
        if(tuples is None):
            return None
        else:
            (folder_number, file_number, line_number) = self.indexer.get_transaction(tid)
            file = f'{self.dir_path}/data/{folder_number}/{file_number}.pab'
            return FileSystem.get_line(file, line_number)

    def get_transactions(self, user):
        transactions = self.indexer.get_transactions(user)
        transaction_list = []
        for (folder_number, file_number, line_number) in transactions:
            file = f'{self.dir_path}/data/{folder_number}/{file_number}.pab'
            transaction = FileSystem.get_line(file, line_number)
            transaction_list.append(transaction)
        return transaction_list

    @staticmethod
    def get_line(file_name, line_number):
        with open(file_name, "r") as file:
            contents = file.readlines()
            total_lines = len(contents)
            if total_lines < line_number:
                return 0
            return contents[line_number].rstrip('\r\n')

    @staticmethod
    def get_number_of_lines(file):
        with open(file, "r") as file:
            return int(file.readline().rstrip('\r\n'))