# Average host ping rtt for 1st, 2nd, 3rd and 4th times
import matplotlib.pyplot as plt
import numpy as np
import argparse

def run(filename):
	runs = []
	errors = []
	flag = True
	with open("data/" + filename) as file:
		title = file.readline().strip()
		subtitle = file.readline().strip()
		run = file.readline().strip()
		while run:
			if flag:
				runs.append(round(float(run), 3))
			else:
				errors.append(int(run))
			flag = not flag
			run = file.readline().strip()
	x_axis = list(range(1,len(runs)+1))

	plt.plot(x_axis, runs, linestyle='--', marker='o', label='data')
	plt.plot(x_axis, errors, linestyle='--', marker='x', label='errors')

	for x_cor, y_cor in zip(x_axis, runs):
		plt.text(x_cor, y_cor, ' {}'.format(str(y_cor)))
	for x_cor, y_cor in zip(x_axis, errors):
		plt.text(x_cor, y_cor, ' {}'.format(str(y_cor)))
	
	plt.title(f'{title}\n{subtitle}')

	plt.ylabel('Time (ms)')
	plt.xlabel('Runs')
 
	plt.savefig(f'img/{filename}.png')
	# plt.show()

if __name__ == '__main__':
    parser = argparse.ArgumentParser(description='Pretty Picture Program.')
    parser.add_argument('--filename', "-f", type=str, dest="filename", help='name of the data file')

    args = parser.parse_args()
    run(args.filename)