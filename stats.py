# data is random numbers from 1 to 100,000
# inserting, finding, and deleting 100 random numbers ranging from 1 to 100,000

import argparse
import statistics
from btree import BTree
from timeit import default_timer as timer

def loadTree(tree, file):
    with open(file, 'r') as file:
        data = file.readlines()
        for datapoint in data:
            tree.insert(int(datapoint))

def collectData(func, funcName, data, tree):
    times = []
    for datapoint in data:
        start = timer()
        func(int(datapoint))
        stop = timer()
        times.append(stop - start)

    mean = statistics.mean(times)
    print(f'mean {funcName} time: {mean}')

    median = statistics.median(times)
    print(f'median {funcName} time: {median}')

    minimum = min(times)
    print(f'minimum {funcName} time: {minimum}')

    maximum = max(times)
    print(f'maximum {funcName} time: {maximum}')

def main():
    parser = argparse.ArgumentParser(description='Get stats of btree')
    parser.add_argument('--data', type=str, help='data file')
    parser.add_argument('--order', type=int, default='3', help='order of the btree')
    args = parser.parse_args()

    tree = BTree(args.order)

    loadTree(tree, args.data)
    with open('data', 'r') as file:
         data = file.readlines()

    collectData(tree.insert, 'insert', data, tree)
    collectData(tree.find, 'find', data, tree)
    collectData(tree.delete, 'delete', data, tree)
# -----------------------------------------------------------
#     inp = input('>')
#     while True:
#         if inp.startswith('f'):
#             inp = input('enter value to find>')
#             tree.find(int(inp))
#         elif inp.startswith('d'):
#             inp = input('enter value to delete>')
#             tree.delete(int(inp))
#         elif inp.startswith('p'):
#             tree.printMe()
#         elif inp == 'exit' or inp == 'x':
#             break
#         else:
#             tree.insert(int(inp))
#             tree.printMe()
#         inp = input('>')


if __name__ == '__main__':
	main()