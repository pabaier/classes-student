# A BTree has an order and a node, which is the root
# A Node has keys and pointers to other nodes
# 	as well as a single parent, which is a node, and an order, which is the same as the BTree root

# Aside from researching the definition of a b-tree, I used this interactive b-tree app extensively
# in order to understand the rules in different scenarios (https://www.cs.usfca.edu/~galles/visualization/BTree.html)
# I also used the wikipedia "depth first search" page
# which inspired the "printMe" method (https://en.wikipedia.org/wiki/Depth-first_search)

import math

class BTree():
	def __init__(self, order):
		self.order = order
		self.node = Node(self.order)

	# starting point for inserting a key
	def insert(self, value):
		# get the leaf node where the value will be inserted
		node = self.getLeafNode(value)
		keys = node.keys
		# for the first insert
		if len(keys) == 0:
			keys.append(value)
		else:
			position = BTree.findInsertIndex(value, node)
			keys.insert(position, value)
			self.checkTooBig(node)

	# checks if the node is bigger than the tree's order
	# if it is, split the node (which inserts a key into the parent)
	# the parent is returned from the split() method, which is also checked
	# for size and the nodes will continue to be split up the tree until they
	# are not too big or they have no parent (which means they are the new root node)
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

	# once a value is found in the tree, this method removes it and starts the merge if needed
	def startDeleteProcess(self, value, node, keyIndex):
		if node.isLeafNode():
			node.keys.pop(keyIndex)
			if len(node.keys) == 0:
				self.merge(node)
		else:
			leaf = self.getLeafNode(value, node)
			biggestValueInLeaf = leaf.keys.pop()
			node.keys[keyIndex] = biggestValueInLeaf
			if len(leaf.keys) == 0:
				self.merge(leaf)

	# when a value is deleted, if the node has no keys left, a merge takes place with it, its parent, and its
	# right or left sibling. If the sibling has more than one key, the node can take the parent’s key and replace
	# it with the sibling’s key. If a sibling only has one key, however, the two siblings and the parent value are
	# merged into one node. If the parent node has more values, then the pointers are reassigned and the process
	# is over. If the parent node has no more keys, however, then another merge takes place with its parent and
	# sibling. This process continues until no inner nodes are empty.
	def merge(self, node):
		parentPointerIndex = node.getParentPointerIndex()
		parent = node.parent
		rightSibling = False

		if parentPointerIndex == 0:
			# we get the right sibling
			rightSibling = True
			sibling = parent.pointers[1]
		else:
			# we get the left sibling
			sibling = parent.pointers[parentPointerIndex - 1]

		# stealing - when the sibling can spare a value:
		if len(sibling.keys) > 1:
			# if stealing from the right sibling, take the lowest value
			if rightSibling:
				parentKey = parent.keys[parentPointerIndex]
				stolenKey = sibling.keys.pop(0)
			# if stealing from the left sibling, take the highest value
			else:
				parentKey = parent.keys[parentPointerIndex - 1]
				stolenKey = sibling.keys.pop()
			node.keys.append(parentKey)
			if rightSibling:
				parent.keys[parentPointerIndex] = stolenKey
			else:
				parent.keys[parentPointerIndex - 1] = stolenKey

		# otherwise - merge the values and check if parent is empty
		else:
			# if merging with right sibling, take the parent value at the parentPointerIndex
			if rightSibling:
				parentKey = parent.keys.pop(parentPointerIndex)
				node.keys.append(parentKey)
				node.keys = node.keys + sibling.keys
				node.pointers = node.pointers + sibling.pointers
				parent.pointers.pop(parentPointerIndex + 1)
			# if merging with left sibling, take the parent value at the parentPointerIndex - 1
			else:
				parentKey = parent.keys.pop(parentPointerIndex - 1)
				node.keys = sibling.keys.copy()
				node.keys.append(parentKey)
				existingPointers = node.pointers.copy()
				node.pointers = sibling.pointers.copy()
				node.pointers = node.pointers + existingPointers
				# point the parent to this node and remove the next pointer
				parent.pointers[parentPointerIndex - 1] = node
				parent.pointers.pop(parentPointerIndex)
			#  continue merging up the tree if this merged caused the parent to become empty
			if len(parent.keys) == 0:
				if parent.hasParent():
					self.merge(parent)
				else:
					node.parent = None
					self.node = node

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

	# prints the tree by going through each node and adding its children nodes to a queue
	# it gets the next node from the queue, which means that the queue holds the nodes
	# in a breadth first arrangement
	def printMe(self):
		queue = [self.node]
		i = 0
		while i < len(queue):
			for node in queue[i].pointers:
				queue.append(node)
			i = i + 1
		print(queue)

class Node():
	def __init__(self, order):
		self.keys = []
		self.pointers = []
		self.parent = None
		self.order = order

	# helper method to check if the node is a leaf node
	def isLeafNode(self):
		return len(self.pointers) == 0

	# helper method to check if the node has exceeded the tree's order
	def isTooBig(self):
		return len(self.keys) == self.order

	# helper method to check if the node has a parent
	def hasParent(self):
		return self.parent != None

	# helper method to check if the node has children (similar to 'isLeafNode()'
	# but provides better readability in certain situations
	def hasChildren(self):
		return len(self.pointers) > 0

	# finds the index where a key should be inserted in a node
	def findInsertIndex(self, key):
		i = 0
		while i < len(self.keys):
			if key < self.keys[i]:
				break
			i = i + 1
		return i

	# finds the index of the pointer to this node
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

	# used in insertions to split this node if it holds more keys than the order of the tree
	# its functionality includes dividing this node's keys, dividing this node's pointers,
	# setting the parents of the new nodes, setting the pointers of the parent the respective new nodes,
	# setting the parent nodes of the two new nodes' children to the respective new nodes,
	# and inserting the overflow key into the parent node
	def split(self):
		middleKey = math.ceil(len(self.keys)/2) - 1
		middlePointer = middleKey + 1

		# make two new nodes and divide the keys and pointers
		a = Node(self.order)
		b = Node(self.order)
		a.keys = self.keys[0:middleKey]
		b.keys = self.keys[middleKey + 1:]
		a.pointers = self.pointers[0:middlePointer]
		b.pointers = self.pointers[middlePointer:]

		# set the new nodes as parents to their children
		for node in a.pointers:
			node.parent = a
		for node in b.pointers:
			node.parent = b

		# get the key being removed
		removed = self.keys[middleKey]

		# if this node has a parent, insert the removed key into the parent and
		# arrange the parent's pointers to accommodate the new key
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
		# if this is the root node, create a new root node from the removed key
		else:
			newParent = Node(self.order)
			newParent.pointers.append(a)
			newParent.pointers.append(b)
			newParent.keys.append(removed)
			a.parent = newParent
			b.parent = newParent
			return newParent

	# helper method to print the node
	def __str__(self):
		b = '('
		for i in self.keys:
			b = b + str(i) + ','
		b = b[:-1] + ')'
		return b

	# helper method to print the node
	def __repr__(self):
		return str(self)
