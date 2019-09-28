package data;

public class NodeGeneric<T> {

    private T data;
    private NodeGeneric<T> next;

    public NodeGeneric() {
        this(null);
    }

    public NodeGeneric(T data) {
        this.data = data;
        next = null;
    }

    public T etData() {
        return data;
    }

    public NodeGeneric getNext() {
        return next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(NodeGeneric next) {
        this.next = next;
    }

}
