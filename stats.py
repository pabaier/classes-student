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
    i = 0
    for datapoint in data:
        if funcName == 'delete':
            print(datapoint)
            i += 1
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
    # collectData(tree.delete, 'delete', data, tree)

    # inp = input('>')
    # while True:
    #     if inp.startswith('f'):
    #         inp = input('enter value to find>')
    #         a.find(int(inp))
    #     elif inp.startswith('d'):
    #         inp = input('enter value to delete>')
    #         a.delete(int(inp))
    #     elif inp.startswith('p'):
    #         a.printMe()
    #     elif inp == 'exit' or inp == 'x':
    #         break
    #     else:
    #         a.insert(int(inp))
    #         a.printMe()
    #     inp = input('>')


if __name__ == '__main__':
	main()