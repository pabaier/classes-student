# Average host ping rtt for 1st, 2nd, 3rd and 4th times
import argparse
import os
from os.path import isfile
from functools import reduce
import json

def notes():
	pass
	# Topology|Controller Grouping|Controller Count|Average RTT|Downed Controllers|Average RTT
	# For Each Topology
	# 	For Each Controller Count
	# 		For Each Controller Grouping as "Optimized"
	# Total Percentage Change|Max Percentage Change|Min Percentage Change|Avg PC

	# # Highwinds:
	# 	# AvgRTT: 10
	# 	# 5 Controllers:
	# 		# CG0 AS Optimized:
	# 			# CG1 Total %D, %max, %min, %avg
	# 			# CG2 Total %D, %max, %min, %avg
	# 		# CG1 AS Optimized:
	# 			# CG0 %D, %max, %min, %avg
	# 			# CG2 %D, %max, %min, %avg
	# 		# CG2 AS Optimized:
	# 			# CG0 %D, %max, %min, %avg
	# 			# CG1 %D, %max, %min, %avg
	# 	# 6 Controllers:
	# 		# CG0 AS Optimized:
	# 			# CG1 %D, %max, %min, %avg
	# 			# CG2 %D, %max, %min, %avg
	# 		# CG1 AS Optimized:
	# 			# CG0 %D, %max, %min, %avg
	# 			# CG2 %D, %max, %min, %avg
	# 		# CG2 AS Optimized:
	# 			# CG0 %D, %max, %min, %avg
	# 			# CG1 %D, %max, %min, %avg
	# results = {
	# 	"Highwinds":{
	# 		5:{
	# 			"CG0":{
	# 				"CG1":{
	# 					"%D":0,
	# 					"max%":0,
	# 					"min%":0,
	# 					"avg%":0
	# 				},
	# 				"CG2":{
	# 					"%D":0,
	# 					"max%":0,
	# 					"min%":0,
	# 					"avg%":0
	# 				}
	# 			},
	# 			"CG1":{
	# 				"CG0":{
	# 					"%D":0,
	# 					"max%":0,
	# 					"min%":0,
	# 					"avg%":0
	# 				},
	# 				"CG2":{
	# 					"%D":0,
	# 					"max%":0,
	# 					"min%":0,
	# 					"avg%":0
	# 				}
	# 			}
	# 		}
	# 	}
	# }

def run():
	# f = open("data/results.json", "w")
	results = {"Highwinds":{}, "Bics":{}, "Internet2":{}}
	highwinds, bics, internet2 = getData()
	data = {"Highwinds":highwinds, "Bics":bics, "Internet2":internet2}
	for r in results:
		# results[r] = analyze(data[r])
		results[r] = analyze2(data[r])
	print(results)
	# f.write(json.dumps(results))

def analyze2(data):
	res = {}
	res[5]={}
	res[6]={}
	for controller_count in range(5,7):
		print(controller_count)
		controller_count_filtered_data = filterByControllerCount(data, controller_count)
		optimalCG, avgRtt = computeOptimalControllerPlacement(controller_count_filtered_data)
		topology = optimalCG[0][0]
		cg = optimalCG[0][1]
		res[controller_count][cg]={}
		percentageChangeList = getPercentageChangeList(optimalCG, avgRtt)

		totalPercentageChange = getTotalPercentageChange(percentageChangeList)
		res[controller_count][cg]["totalPercentageChange"] = totalPercentageChange
		res[controller_count][cg]["maxPercentageChange"] = getMaxPercentageChange(percentageChangeList)
		res[controller_count][cg]["minPercentageChange"] = getMinPercentageChange(percentageChangeList)
		res[controller_count][cg]["avgPercentageChange"] = getAveragePercentageChange(totalPercentageChange, len(percentageChangeList))

		# print(f'{optimalCG[0][0]}-{controller_count}:')
		# print(f'\t{totalPercentageChange}')
		# print(f'\t{maxPercentageChange}')
		# print(f'\t{minPercentageChange}')
		# print(f'\t{avgPercentageChange}')
	return res

def analyze(data):
	res = {}
	for controller_count in range(5,7):
		res[controller_count] = {}
		# get data by controller (ex: get all controller 5 data from this one topology)
		controller_count_filtered_data = filterByControllerCount(data, controller_count)
		controller_group_names = [("CG0", "CG1", "CG2"),("CG1", "CG0", "CG2"),("CG2", "CG0", "CG1"), ]
		for controller_group in controller_group_names:
			# returns a dict with the group name as the key and data list as the value
			controller_groups = filterByControllerGroup(controller_count_filtered_data)
			optimalAvg = getAvgRTT(controller_groups[controller_group[0]], True)

			percentageChangeOne = getPercentageChangeList(controller_groups[controller_group[1]],optimalAvg)
			percentageChangeTwo = getPercentageChangeList(controller_groups[controller_group[2]], optimalAvg)

			totalPercentageChangeOne = getTotalPercentageChange(percentageChangeOne)
			totalPercentageChangeTwo = getTotalPercentageChange(percentageChangeTwo)

			maxPercentageChangeOne = getMaxPercentageChange(percentageChangeOne)
			maxPercentageChangeTwo = getMaxPercentageChange(percentageChangeTwo)

			minPercentageChangeOne = getMinPercentageChange(percentageChangeOne)
			minPercentageChangeTwo = getMinPercentageChange(percentageChangeTwo)

			avgPercentageChangeOne = totalPercentageChangeOne/len(controller_groups[controller_group[1]])
			avgPercentageChangeTwo = totalPercentageChangeTwo/len(controller_groups[controller_group[2]])

			res[controller_count][controller_group[0]] = {
				controller_group[1]:{
					"totalPercentageChange":totalPercentageChangeOne,
					"maxPercentageChange":maxPercentageChangeOne,
					"minPercentageChange":minPercentageChangeOne,
					"avgPercentageChange":avgPercentageChangeOne
				},
				controller_group[2]:{
					"totalPercentageChange":totalPercentageChangeTwo,
					"maxPercentageChange":maxPercentageChangeTwo,
					"minPercentageChange":minPercentageChangeTwo,
					"avgPercentageChange":avgPercentageChangeTwo
				}
			}
	return res

def getPercentageChangeList(lst, optimalAvg):
	res = []
	for record in lst:
		res.append(((record[5] - optimalAvg)/optimalAvg)*100)
	return res

def getTotalPercentageChange(lst):
	summ = reduce((lambda x, y: x + y), lst)
	return summ

def getMaxPercentageChange(lst):
	return max(lst)

def getMinPercentageChange(lst):
	return min(lst)

def getAveragePercentageChange(total, length):
	return total/length

def getAvgRTT(lst, initialRTT=False):
	index = 5
	if initialRTT:
		index = 3
	summ = 0
	for record in lst:
		summ += record[index]
	return summ/len(lst)

# returns the data filtered by optimal congroller group and the avgRTT
# optimal is the controller group with the lowest
# average average RTT
def computeOptimalControllerPlacement(topology):
	cgs = filterByControllerGroup(topology)
	res = {
		'CG0': getAvgRTT(cgs['CG0']),
		'CG1': getAvgRTT(cgs['CG1']),
		'CG2': getAvgRTT(cgs['CG2'])
	}
	mini = min(res, key=res.get)
	return cgs[mini], res[mini]

# returns a dict with the controller group (CG0, CG1, ...) as the key and data list as the value
def filterByControllerGroup(lst):
	cg0 = list(filter(lambda x: x[1] == "CG0", lst))
	cg1 = list(filter(lambda x: x[1] == "CG1", lst))
	cg2 = list(filter(lambda x: x[1] == "CG2", lst))
	return {"CG0":cg0, "CG1":cg1, "CG2":cg2}

def filterByControllerCount(lst,controller_count):
	return list(filter(lambda x: x[2] == controller_count, lst))

def getData():
	highwinds = []
	bics = []
	internet2 = []
	allFiles = os.listdir('data')
	for file in allFiles:
		if file[0] == '.' or not isfile('data/' + file) or file=="results.json":
			allFiles.remove(file)

	for filename in allFiles:
		# this little bit of code is necessary to rename internet2 files to match the others
		f = filename
		if f.find("Internet") >= 0:
			index = f.find("-")
			f = f[:index] + f[index+1:]

		row = f.split('-') #ex: bicscg2,5,c1,c2
		row[1] = int(row[1])
		if len(row) == 4:
			row[2] = row[2] + "-" + row.pop(3)

		with open("data/" + filename) as file:
			title = file.readline().strip()
			subtitle = file.readline().strip()
			run1 = file.readline().strip()
			errors1 = file.readline().strip()
			run2 = file.readline().strip()
			errors2 = file.readline().strip()
			row.insert(2, float(run2))
			run3 = file.readline().strip()
			errors3 = file.readline().strip()
			run4 = file.readline().strip()
			errors4 = file.readline().strip()
			row.append(float(run4))
		
		# split the name and the controller layout eg: HighwindsCG0 -> Highwinds, CG0
		name = row[0][:-3]
		controller_layout = row[0].split(name)[1]
		row[0] = name
		row.insert(1,controller_layout)
		# output = ",".join(row)
		if name.lower() == "highwinds":
			highwinds.append(row)
		elif name.lower() == "bics":
			bics.append(row)
		else:
			internet2.append(row)
	return highwinds, bics, internet2

if __name__ == '__main__':
    run()