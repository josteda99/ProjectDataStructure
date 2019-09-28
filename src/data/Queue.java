package data;

import javax.management.RuntimeErrorException;

public class Queue {

    public static final int N = 4;
    public int front, rear, count, qarray[];

    public Queue() {
        count = rear = front = 0;
        qarray = new int[N];
    }
    
    public Queue(int n) {
        count = rear = front = 0;
        qarray = new int[n];
    }
    

    public void enqueue(int item) {
        if (!full()) {
            qarray[rear] = item;
            count++;
            rear = (rear + 1) % N;
        } else {
            throw new RuntimeException("queue is full motherfacker");
        }

    }

    public int dequeue() {
        int item = -1;
        if (!empty()) {
            item = qarray[front];
            front = (front + 1) % N;
            count--;
        } else {
            throw new RuntimeException("queue is empty motherfacker");
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
            System.out.println(qarray[i]);
        }
    }
}
