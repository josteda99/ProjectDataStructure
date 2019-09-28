package data;

public class StackArrayGeneric<T> {

    public int top;
    public static final int size = 5;
    public T[] sarray;

    public StackArrayGeneric() {
        this(size);
    }

    public StackArrayGeneric(int n) {
        top = 0;
        sarray = (T[]) new Object[n];
    }

    public boolean empty() {
        return top <= 0;
    }

    public boolean full() {
        return top >= sarray.length;
    }

    public T pop() {
        if (!empty()) {
            top--;
        } else {
            throw new RuntimeException("stak is empty");
        }
        return sarray[top];
    }

    public void push(T item) {
        if (!full()) {
            sarray[top] = item;
            top++;
        } else {
            throw new RuntimeException("Stack is full, please pop an element");
        }
    }

    public void show() {
        for (int i = 0; i < sarray.length; i++) {
            System.out.println(sarray[i]);
        }
    }

    public T peek() {
        return sarray[top];
    }

    public int sizeStack() {
        return top;
    }
}
