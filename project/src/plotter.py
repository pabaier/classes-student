# Average host ping rtt for 1st, 2nd, 3rd and 4th times
import matplotlib.pyplot as plt
import numpy as np
import argparse
import os

def run():
	allFiles = os.listdir('data')
	for file in allFiles:
		if file[0] == '.':
			allFiles.remove(file)

	for filename in allFiles:
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

		fig, ax1 = plt.subplots()

		ax2 = ax1.twinx()
		# ax1.plot(x, y1, 'g-')
		# ax2.plot(x, y2, 'b-')

		# ax1.set_xlabel('X data')
		# ax1.set_ylabel('Y1 data', color='g')
		# ax2.set_ylabel('Y2 data', color='b')

		# plt.show()


		l1, = ax1.plot(x_axis, runs, linestyle='-', marker='o', label='time', color='b', linewidth=4)
		l2, = ax2.plot(x_axis, errors, linestyle='--', marker='x', label='errors', color='orange', linewidth=3)
		l3 = ax1.axvline(x=2.5, linestyle=':', label='off')
		l4 = ax1.axvline(x=4.5, linestyle=':', label='on')

		# ax1.legend()
		# ax2.legend()
		plt.legend([l1, l2, l3, l4], ['time', 'errors', 'off', 'on'])

		for x_cor, y_cor in zip(x_axis, runs):
			ax1.text(x_cor, y_cor, ' {}'.format(str(y_cor)))
		for x_cor, y_cor in zip(x_axis, errors):
			if y_cor != 0:
				ax2.text(x_cor, y_cor, ' {}'.format(str(y_cor)))
		
		plt.title(f'{title}\n{subtitle}')

		ax1.set_ylabel('Time (ms)')
		ax2.set_ylabel('Errors')
		ax1.set_xlabel('Runs')
	
		plt.savefig(f'img/{filename}.png')
		plt.clf()
		# plt.show()

if __name__ == '__main__':
    parser = argparse.ArgumentParser(description='Pretty Picture Program.')
    parser.add_argument('--filename', "-f", type=str, dest="filename", help='name of the data file')

    args = parser.parse_args()
    run()