public class Stack<T>
{

    private Node first = null;

    public boolean isEmpty()
    {
        return first == null;
    }

    public void push(T value)
    {
        Node oldFirst = first;
        first = new Node();
        first.value = value;
        first.next = oldFirst;
    }

    public T pop()
    {
        T temp = first.value;
        first = first.next;
        return temp;
    }

    public class Node
    {
        T value;
        Node next;
    }
}