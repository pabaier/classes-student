import math

class BTree():
	def __init__(self, degree):
		self.degree = degree
		self.node = Node(self.degree)
		self.middle = math.ceil(self.degree/2) - 1
		self.height = 1

	def insert(self, input, node=None):
		if node == None:
			node = self.node
		else:
			node = getLeafNode(input, node)
		self.insertA(input, node)

	def insertA(self, input, node):
		keys = node.keys
		i = 0	# tracks where the key is inserted
		if len(keys) == 0:
			keys.append(input)
		else: # inserts the key into the correct position
			oldLength = len(keys)
			while i < len(keys):
				if input < keys[i]:
					keys.insert(i, input)
					break
				i = i + 1
			if oldLength == len(keys):
				keys.append(input)
		if node.isTooBig():
			(leftNode, rightNode, removedKey) = node.split()
			if node.hasParent():
				self.node.pointers.append(leftNode)
				self.node.pointers.append(rightNode)
				self.insertA(removedKey, node)
			else:
				self.node = Node(self.degree)
				self.node.pointers.append(leftNode)
				self.node.pointers.append(rightNode)
				self.node.keys.append(removedKey)
		# 	if node.hasParent:
		# 		self.insertA(median, node)
		# 	else:
		# 		pass
				# split

		# if this has a parent, insert(median)
		# if len(self.node.keys) < self.degree - 1:
		# 	self.node.keys.append(key)

	# helper function to get the leaf node of a node
	def getLeafNode(input, node):
		if (node.isLeafNode()):
			return node
		else:
			child = getChildNode(input, node)
			return getleafNode(input, child)

	# helper function to get the correct child node of a key value
	def getChildNode(input, node):
		i = 0
		while i < len(node.keys):
			if(node.keys[i] > input):
				break
		return node.pointers[i]



	def delete(self, key):
		pass
	def search(self, key):
		pass

	def printMe(self):
		queue = [self.node]
		i = 0
		while i < len(queue):
			for node in queue[i].pointers:
				queue.append(node)
			i = i + 1
		level = 0
		printed = 0
		for node in queue:
			print(node.keys, end="  ")
			printed = printed + 1
			if math.pow(self.degree - 1, level) == printed:
				printed = 0
				level = level + 1
				print("")
		print("")
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
		return len(pointers) > 0

	def split(self):
		middleKey = math.ceil(len(self.keys)/2) - 1
		middlePointer = middleKey + 1
		aKey = self.keys[0:middleKey]
		bKey = self.keys[middleKey + 1:]
		removed = self.keys[middleKey]
		# if len(self.pointers)%2==0:
		# 	middlePointer = math.ceil(len(self.pointers)/2)
		# else:
		# 	middlePointer = math.ceil(len(self.pointers)/2) - 1
		aPointer = self.pointers[0:middlePointer]
		bPointer = self.pointers[middlePointer:]
		a = Node(self.degree)
		b = Node(self.degree)
		a.keys = aKey
		b.keys = bKey
		a.pointers = aPointer
		b.pointers = bPointer
		a.parent=self.parent
		b.parent=self.parent
		return (a,b,removed)
	
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

a = BTree(3)
inp = input('>')
while True:
	a.insert(int(inp))
	a.printMe()
	inp = input('>')
	if inp == 'exit' or inp == 'x':
		break