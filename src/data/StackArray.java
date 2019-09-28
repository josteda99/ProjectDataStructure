package data;

public class StackArray {

    public int top;
    public static final int size = 5;
    public int[] sarray;

    public StackArray() {
        this(size);
    }

    public StackArray(int n) {
        top = 0;
        sarray = new int[n];
    }

    public boolean empty() {
        return top <= 0;
    }

    public boolean full() {
        return top >= sarray.length;
    }

    public int pop() {
        int item = -1;
        if (!empty()) {
            top--;
            item = sarray[top];
        } else {
            throw new RuntimeException("stak is empty");
        }
        return item;
    }

    public void push(int item) {
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

    public int peek() {
        return sarray[top];
    }
    
    public int sizeStack(){
        return top;
    }
}
