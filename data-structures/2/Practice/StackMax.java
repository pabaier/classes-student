/*
Stack with max.
Create a data structure that efficiently supports the stack operations
(push and pop) and also a return-the-maximum operation.
Assume the elements are reals numbers so that you can compare them.
*/

public class StackMax {

    Node first = null;
    Node max = null;

    public StackMax() {
        first = new Node();
        max = new Node();
    }

    public void push(int value) {
        Node temp = first;
        first = new Node();
        first.value = value;
        first.next = temp;

        Node newNode = max;
        max = new Node();
        max.next = newNode;

        if(value > newNode.value)
            max.value = value;
        else
            max.value = newNode.value;
    }

    public int pop() {
        int temp = first.value;
        first = first.next;
        max = max.next;
        return temp;
    }

    public int getMax() {
        return max.value;
    }

    private class Node  {
        int value;
        Node next;
    }

    public static void main(String[] args) {
        StackMax m = new StackMax();
        m.push(10);
        m.push(11);
        m.push(9);
        m.push(12);
        m.push(3);
        StdOut.println(m.getMax());
    }

}