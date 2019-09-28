package data;

import javax.management.RuntimeErrorException;

public class QueueGeneric<T> {

    public static final int N = 1000000;
    public int front, rear, count;
    private T[] qarray;

    public QueueGeneric() {
        count = rear = front = 0;
        qarray = (T[]) new Object[N];
    }

    public QueueGeneric(int n) {
        count = rear = front = 0;
        qarray = (T[]) new Object[n];
    }

    public void enqueue(T item) {
        if (!full()) {
            qarray[rear] = item;
            count++;
            rear = (rear + 1) % N;
        } else {
            throw new RuntimeException("queue is full ");
        }

    }

    public T dequeue() {
        T item = null;
        if (!empty()) {
            item = qarray[front];
            front = (front + 1) % N;
            count--;
        } else {
            throw new RuntimeException("queue is empty");
        }
        return item;
    }

    public boolean empty() {
        return count <= 0;
    }

    public boolean full() {
        return count >= N;
    }

    public void show() {
        for (int i = 0; i < N; i++) {
            System.out.println(qarray[i].toString());
        }
    }

    public void show(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(qarray[i].toString());
        }
    }

    public int size() {
        return N;
    }

    public T[] actualizador() {
        return qarray;
    }
}
