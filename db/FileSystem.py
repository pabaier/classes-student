from glob import glob
from natsort import natsorted
import json
import os


class FileSystem:
	def __init__(self):
		(self.folder, self.folder_number) = FileSystem.get_most_recent_folder()
		(self.file, self.file_number) = self.get_most_recent_file_in_folder()

	def update_folder(self):
		(self.folder, self.folder_number) = FileSystem.get_most_recent_folder()

	def update_file(self):
		(self.file, self.file_number) = self.get_most_recent_file_in_folder()

	@staticmethod
	def get_most_recent_folder():
		dirs = natsorted(glob("data/*/"),reverse=True)
		return dirs[0], len(dirs)

	def get_most_recent_file_in_folder(self, folder=None):
		if folder is None:
			folder = self.folder
		all_files = glob(folder + '*')
		most_recent_file = max(all_files, key=os.path.getctime)
		return most_recent_file, len(all_files)

	def write(self, data):
		with open(self.file, "r+") as file:
			contents = file.readlines()
			lines = self.get_number_of_lines(contents)
			contents[0] = str(lines+1) + "\n"
			file.seek(0)
			file.truncate()
			file.writelines(contents)
			file.writelines(data + '\n')
			# make new file after 1000th line (write 1000 lines per file)
			if lines+1 >= 1000:
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
		self.folder_number = self.folder_number + 1
		self.folder = 'data/' + str(self.folder_number) + '/'
		self.file_number = 0
		os.makedirs(self.folder)

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
		return int(file[0].rstrip('\r\n'))