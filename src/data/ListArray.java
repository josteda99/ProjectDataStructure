package data;

public class ListArray {

    public static final int N = 5;
    public int count, position, larray[];

    public ListArray() {
        larray = new int[N];
        count = position = 0;
    }

    public ListArray(int n) {
        larray = new int[n];
        count = 0;
    }

    public boolean empty() {
        return count <= 0;
    }

    public boolean full() {
        return count >= N;
    }

    public boolean insert(int item) {
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

   

    public boolean delete(int item) {
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

    public boolean search(int item) {
        boolean found = false, stop = false;

        position = 0;

        while (position < count && !stop) {
            if (larray[position] >= item) {
                stop = true;
                if (larray[position] == item) {
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

}
