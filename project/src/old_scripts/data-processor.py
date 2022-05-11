# Average host ping rtt for 1st, 2nd, 3rd and 4th times
import argparse
import os
from os.path import isfile

# Topology	Controller Count	Average RTT	Downed Controllers	Average RTT
def run():
	f = open("data/results.csv", "w")
	allFiles = os.listdir('data')
	for file in allFiles:
		if file[0] == '.' or not isfile('data/' + file):
			allFiles.remove(file)
	for filename in allFiles:
		row = filename.split('-')
		if len(row) == 4:
			row[2] = row[2] + "-" + row.pop(3)

		with open("data/" + filename) as file:
			title = file.readline().strip()
			subtitle = file.readline().strip()
			run1 = file.readline().strip()
			errors1 = file.readline().strip()
			run2 = file.readline().strip()
			errors2 = file.readline().strip()
			row.insert(2, run2)
			run3 = file.readline().strip()
			errors3 = file.readline().strip()
			run4 = file.readline().strip()
			errors4 = file.readline().strip()
			row.append(run4)
		
		# split the name and the controller layout eg: HighwindsCG0 -> Highwinds, CG0
		name = row[0][:-3]
		controller_layout = row[0].split(name)[1]
		row[0] = name
		row.insert(1,controller_layout)
		print(row)
		output = ",".join(row)
		f.write("{}\n".format(output))

if __name__ == '__main__':
    parser = argparse.ArgumentParser(description='Data Processing Program.')
    parser.add_argument('--filename', "-f", type=str, dest="filename", help='name of the data file')

    args = parser.parse_args()
    run()