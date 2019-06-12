import math

class BTree():
	def __init__(self, degree):
		self.degree = degree
		self.node = Node(self.degree)
		self.middle = math.ceil(self.degree/2) - 1
		self.height = 1

	def insert(self, value, node=None):
		if node == None:
			node = self.getLeafNode(value)
		keys = node.keys
		if len(keys) == 0:
			keys.append(value)
		else: # inserts the key into the correct position
			position = BTree.findInsertIndex(value, node)
			keys.insert(position, value)
			self.checkTooBig(node)

	def checkTooBig(self, node):
		while node.isTooBig():
			node = node.split()
			if not node.hasParent():
				self.node = node

	# helper function to get the index of where the input should go
	def findInsertIndex(value, node):
		i = 0
		while i < len(node.keys):
			if value < node.keys[i]:
				break
			i = i + 1
		return i

	# helper function to get the leaf node of a node
	def getLeafNode(self, value, node=None):
		if node == None:
			node = self.node
		i = 0
		while i < len(node.keys):
			key = node.keys[i]
			if key > value:
				break
			i = i + 1

		if node.hasChildren():
			return self.getLeafNode(value, node.pointers[i])
		else:
			return node

	def startDeleteProcess(self, value, node, keyIndex):
		if node.isLeafNode():
			node.keys.pop(keyIndex)
			if len(node.keys) == 0:
				self.merge(node)
		# leaf node, multi key
		if node.isLeafNode() and len(node.keys) > 1:
			node.keys.pop(keyIndex)
			return

		# leaf node, one key
		if node.isLeafNode() and len(node.keys) == 1:
			parent = node.parent
			index = BTree.findInsertIndex(value, parent)
			if index == 0:
				sibling = parent.pointers[1]
			else:
				sibling = parent.pointers[index]
			self.merge(parent, sibling)

		# inner node, multi key

		# inner node, one key

		leaf = self.getLeafNode(value, node)
		biggestValueInLeaf = leaf.keys.pop
		node.keys[index] = biggestValueInLeaf
		if len(leaf.keys == 0):
			self.merge(leaf)

	def merge(self, node):
		pass

	def delete(self, value, node=None):
		if node == None:
			node = self.node
		i = 0
		while i < len(node.keys):
			key = node.keys[i]
			if key == value:
				# found it
				self.startDeleteProcess(value, node, i)
				return
			if key > value:
				break
			i = i + 1

		if node.hasChildren():
			self.delete(value, node.pointers[i])
		else:
			print('Not Found')
			return

	def find(self, value, node=None):
		if node == None:
			node = self.node
		i = 0
		while i < len(node.keys):
			key = node.keys[i]
			if key == value:
				print(str(key))
				return
			if key > value:
				break
			i = i + 1

		if node.hasChildren():
			self.find(value, node.pointers[i])
		else:
			print('Not Found')
			return

	def printMe(self):
		queue = [self.node]
		i = 0
		while i < len(queue):
			for node in queue[i].pointers:
				queue.append(node)
			i = i + 1
		print(queue)
		# level = 0
		# printed = 0
		# for node in queue:
		# 	print(node.keys, end="  ")
		# 	# print(node.pointers, end="  ")
		# 	printed = printed + 1
		# 	if math.pow(self.degree, level) == printed:
		# 		printed = 0
		# 		level = level + 1
		# 		print("")
		# print("")
		# nodeLength = (self.degree-1)*2+2
		# (length,width) = (self.height, nodeLength * self.degree * self.height + self.height)

class Node():
	def __init__(self, degree):
		self.keys = []
		self.pointers = []
		self.parent = None
		self.degree = degree

	def isLeafNode(self):
		return len(self.pointers) == 0

	def isTooBig(self):
		return len(self.keys) == self.degree

	def hasParent(self):
		return self.parent != None

	def hasChildren(self):
		return len(self.pointers) > 0

	def findInsertIndex(self, value):
		i = 0
		while i < len(self.keys):
			if value < self.keys[i]:
				break
			i = i + 1
		return i

	def getParentPointerIndex(self):
		parent = self.parent
		if parent == None:
			return None
		i = 0
		while i < len(parent.pointers):
			if parent.pointers[i] == self:
				return i
			i = i + 1
		return None

	def split(self):
		middleKey = math.ceil(len(self.keys)/2) - 1
		middlePointer = middleKey + 1
		
		a = Node(self.degree)
		b = Node(self.degree)
		a.keys = self.keys[0:middleKey]
		b.keys = self.keys[middleKey + 1:]
		a.pointers = self.pointers[0:middlePointer]
		b.pointers = self.pointers[middlePointer:]

		for node in a.pointers:
			node.parent = a
		for node in b.pointers:
			node.parent = b

		removed = self.keys[middleKey]

		if self.hasParent():
			index = self.parent.findInsertIndex(removed)
			self.parent.keys.insert(index,removed)
			self.parent.pointers[index] = a
			try:
				self.parent.pointers.insert(index + 1, b)
			except:
				self.parent.pointers.append(b)
			a.parent=self.parent
			b.parent=self.parent
			return self.parent
		else:
			newParent = Node(self.degree)
			newParent.pointers.append(a)
			newParent.pointers.append(b)
			newParent.keys.append(removed)
			a.parent = newParent
			b.parent = newParent
			return newParent
	
	def __str__(self):
		b = '('
		for i in self.keys:
			b = b + str(i) + ','
		b = b[:-1] + ')'
		return b

	def __repr__(self):
		return str(self)
# # test node split with odd number of keys
# a = Node(7)
# a.keys=[1,3,5,7,9]
# a.pointers=[0,2,4,6,8,10]
# (b,c,removed)=a.split()
# print(b.keys)
# print(b.pointers)
# print(c.keys)
# print(c.pointers)
# print(removed)


# # test node split with even number of keys
# d = Node(7)
# d.keys=[1,3,5,7]
# d.pointers=[0,2,4,6,8]
# (e,f,removedD)=d.split()
# print(e.keys)
# print(e.pointers)
# print(f.keys)
# print(f.pointers)
# print(removedD)

def loadData(tree):
	with open('hundred-thousand', 'r') as file:
		data = file.readlines()
		for datapoint in data:
			tree.insert(int(datapoint))

a = BTree(5)
loadData(a)
inp = input('>')
while True:
	if inp.startswith('f'):
		inp = input('enter value to find>')
		a.find(int(inp))
	elif inp.startswith('d'):
		inp = input('enter value to delete>')
		a.delete(int(inp))
	elif inp == 'exit' or inp == 'x':
		break
	else:
		a.insert(int(inp))
		a.printMe()
	inp = input('>')
