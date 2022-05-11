/*
Queue with two stacks.
Implement a queue with two stacks so that each queue operations 
takes a constant amortized number of stack operations.
*/

public class Queue<T> 
{
    private Stack<T> a;
    private Stack<T> b;

    public Queue() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void push(T value) {
        a.push(value);
    }

    public T pop() {
        if(b.isEmpty()) {
            while(!a.isEmpty()) {
                b.push(a.pop());
            }
            return b.pop();
        }
        else {
            return b.pop();
        }
    }

    public boolean isEmpty() {
        return a.isEmpty() && b.isEmpty();
    }

    public static void main(String[] args)
    {
        Queue<String> a = new Queue<>();

        a.push("Hello");  
        a.push("World");  
        a.push("how");
        a.pop(); 
        a.pop(); 
        a.pop();
        a.push("are");  
        a.push("you");  
        a.push("doing");

        while(!a.isEmpty()) {
            StdOut.println(a.pop()); 
        }

    }
}