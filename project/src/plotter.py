# Average host ping rtt for 1st, 2nd, 3rd and 4th times
import matplotlib.pyplot as plt
import numpy as np
import argparse

def run(filename):
	runs = []
	with open(filename) as file:
		topology = file.readline().strip()
		test = file.readline().strip()
		stat = file.readline().strip()
		nodes = file.readline().strip()
		run = file.readline().strip()
		while run:
			runs.append(round(float(run), 3))
			run = file.readline().strip()
	x_axis = list(range(1,len(runs)+1))

	plt.plot(x_axis, runs, linestyle='--', marker='o')
	for x_cor, y_cor in zip(x_axis, runs):
		plt.text(x_cor, y_cor, ' {}'.format(str(y_cor)))
	plt.title(f'{stat.capitalize()}, {test.capitalize()} for {topology} with {nodes} nodes')
	plt.ylabel('Ping RTT (ms)')
	plt.xlabel('Runs')

	plt.savefig(f'{topology}-{nodes}.png')
	# plt.show()

if __name__ == '__main__':
    parser = argparse.ArgumentParser(description='Pretty Picture Program.')
    parser.add_argument('--filename', "-f", type=str, dest="filename", help='name of the data file')

    args = parser.parse_args()
    run(args.filename)