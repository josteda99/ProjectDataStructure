package data;

public class ListArrayGeneric<T extends Comparable<T>> {

    public static final int N = 10000000;
    public int count, position;
    public T larray[];
    T reference;

    public ListArrayGeneric() {
        larray = (T[]) new Comparable[N];
        count = position = 0;
    }

    public ListArrayGeneric(int n) {
        larray = (T[]) new Comparable[n];
        count = 0;
    }

    public boolean empty() {
        return count <= 0;
    }

    public boolean full() {
        return count >= N;
    }

    public boolean insert(T item) {
        boolean inserted = false;
        if (!full()) {
            if (!search(item)) {
                for (int i = count; i > position; i--) {
                    larray[i] = larray[i - 1];
                }
                larray[position] = item;
                count++;
                inserted = true;
            }
        } else {
            System.out.println("lleno papu");
        }
        return inserted;
    }

    public boolean delete(T item) {
        boolean deleted = false;
        if (!empty()) {
            if (search(item)) {
                for (int i = position; i < count - 1; i++) {
                    larray[i] = larray[i + 1];
                }
                count--;
                deleted = true;
            }
        } else {
            System.out.println("vaio papu");
        }

        return false;
    }

    public boolean search(T item) {
        boolean found = false, stop = false;

        position = 0;

        while (position < count && !stop) {
            if (larray[position].compareTo(item) >= 0) {
                stop = true;
                if (larray[position].compareTo(item) == 0) {
                    found = true;
                }
            } else {
                position++;
            }
        }

        return found;
    }

    public void show() {
        for (int i = 0; i < count; i++) {
            System.out.println(larray[i]);
        }
    }

    public int compareTo(T item) {
        int result;
        if (reference.compareTo(item) > 0) {
            result = 1;
        } else {
            if (reference.compareTo(item) < 0) {
                result = -1;
            } else {
                result = 0;
            }
        }
        return result;
    }

    public int size() {
        return N;
    }
}
