import math


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
        middleKey = math.ceil(len(self.keys) / 2) - 1
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
            self.parent.keys.insert(index, removed)
            self.parent.pointers[index] = a
            try:
                self.parent.pointers.insert(index + 1, b)
            except:
                self.parent.pointers.append(b)
            a.parent = self.parent
            b.parent = self.parent
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
