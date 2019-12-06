# Average host ping rtt for 1st, 2nd, 3rd and 4th times
import matplotlib.pyplot as plt
import numpy as np
import argparse
import os
from os.path import isfile
import json

def autolabel(rects, ax):
    """Attach a text label above each bar in *rects*, displaying its height."""
    for rect in rects:
        height = rect.get_height()
        voffset = 0
        if height < 0:
            voffset = -12
        ax.annotate('{}'.format(height),
                    xy=(rect.get_x() + rect.get_width() / 2, height),
                    xytext=(0, voffset),
                    textcoords="offset points",
                    ha='center', va='bottom')

def run(data=None):
	if not data:
		with open("data/results.json") as file:
			data = json.load(file)
	filename = 1
	for topology in list(data.keys()):
		for num_controllers in data[topology]:
			for optimalCGName in data[topology][num_controllers]:
				optimalCG = data[topology][num_controllers][optimalCGName]
				dataA = []
				dataB = []
				dataALabel = list(optimalCG.keys())[0]
				dataBLabel = list(optimalCG.keys())[1]
				toggle = True
				for controllerGroup in optimalCG:
					for stat in optimalCG[controllerGroup]:
						if toggle:
							dataA.append(float('%.1f'%(optimalCG[controllerGroup][stat])))
						else:
							dataB.append(float('%.1f'%(optimalCG[controllerGroup][stat])))
					toggle = not toggle
				labels = ['Max', 'Min', 'Avg']
				x = np.arange(len(labels))  # the label locations
				width = 0.35  # the width of the bars
				dataA = dataA[1:]
				dataB = dataB[1:]
				fig, ax = plt.subplots()
				rects1 = ax.bar(x - width/2, dataA, width, label=dataALabel)
				rects2 = ax.bar(x + width/2, dataB, width, label=dataBLabel)

				# Add some text for labels, title and custom x-axis tick labels, etc.
				ax.set_ylabel('Average RTT Percent Delta From Optimal')
				ax.set_title(f"{topology} | {num_controllers} Controllers | {optimalCGName} Optimal")
				ax.set_xticks(x)
				ax.set_xticklabels(labels, rotation=50)
				ax.legend()

				autolabel(rects1, ax)
				autolabel(rects2, ax)

				fig.tight_layout()

				plt.savefig(f'img/{filename}.png')
				plt.close()
				filename += 1

if __name__ == '__main__':
    run()