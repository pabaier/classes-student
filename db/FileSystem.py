from glob import glob
from natsort import natsorted
import json
import os

class FileSystem:
	def __init__(self):
		(self.folder, self.folderNumber) = self.getMostRecentFolder()
		(self.file, self.fileNumber) = self.getMostRecentFileInFolder(self.folder)

	def getMostRecentFolder(self):
		dirs = natsorted(glob("data/*/"),reverse=True)
		return (dirs[0], len(dirs))

	def getMostRecentFileInFolder(self, folder):
		allFiles = glob(folder + '*')
		mostRecentFile = max(allFiles, key=os.path.getctime)
		return (mostRecentFile, len(allFiles))

	def write(self, data):
		with open(self.file, "r+") as file:
			contents = file.readlines()
			lines = self.getNumberOfLines(contents)
			contents[0] = str(lines+1) + "\n"
			file.seek(0)
			file.truncate()
			file.writelines(contents)
			file.writelines(data + '\n')
			# make new file after 1000th line (write 1000 lines per file)
			if(lines+1 >= 1000):
				self.makeNewFile()

	def makeNewFile(self):
		# make a new folder if the current folder contains 1000 files (each folder contains 1000 files)
		if(self.fileNumber >= 1000):
			self.makeNewFolder()
		self.fileNumber = self.fileNumber + 1
		self.file = self.folder + '' + str(self.fileNumber) + '.pab'
		with open(self.file, "w+") as file:
			file.write('0')

	def makeNewFolder(self):
		self.folderNumber = self.folderNumber + 1
		self.folder = 'data/' + str(self.folderNumber) + '/'
		self.fileNumber = 0
		os.makedirs(self.folder)

	def getline(self, fileName, lineNumber):
		with open(fileName, "r") as file:
			contents = file.readlines()
			totalLines = len(contents)
			if totalLines < lineNumber:
				return 0
			return contents[lineNumber].rstrip('\r\n')

	def getNumberOfLines(self, file):
		return int(file[0].rstrip('\r\n'))