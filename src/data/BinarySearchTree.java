package data;

import java.io.Serializable;
import java.util.Scanner;

public class BinarySearchTree implements Serializable {

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insertBST(int num) {
        root = insert(num, root);
    }

    public void borrar() {
        root = null;
    }

    public void preFix() {
        System.out.print("Prefix:");
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node p) {
        System.out.print(p.data);
        if (!(p.left == null || p.right == null)) {
            preOrder(p.left);
            preOrder(p.right);
        }
    }

    public void inFix() {
        System.out.print("Prefix:");
        inOrder(root);
        System.out.println();
    }

    public void inOrder(Node p) {
        if (!(p.left == null || p.right == null)) {
            inOrder(p.left);
            System.out.print(p.data);
            inOrder(p.right);
        } else {
            System.out.print(p.data);
        }
    }

    public void createTree() {
        System.out.println("enter a prefix arttimetich expression");
        System.out.println("");
        root = inputData();
    }

    public Node inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter operator: ...");
        char ch = sc.next().charAt(0);
        Node p = new Node(ch);

        if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            p.left = inputData();
            p.right = inputData();
        }
        return p;
    }

    public void traverseBST() {
        System.out.println("the tree is:");
        if (root != null) {
            traverse(root);
        } else {
            System.out.println(" Empty");
            System.out.println();
        }
    }

    //inorder
    private void traverse(Node p) {
        if (p.left != null) {
            traverse(p.left);
        }
        System.out.println("" + p.data);
        if (p.right != null) {
            traverse(p.right);
        }
    }

    private Node insert(int num, Node p) {

        if (p == null) {
            p = new Node(num);
        } else {
            if (num < p.data) {
                p.left = insert(num, p.left);
            } else {
                if (num > p.data) {
                    p.right = insert(num, p.right);
                } else {
                    System.out.println("Ite in tree and not inserted");
                }
            }
        }
        return p;
    }

    private Node findMin(Node p) {
        if (p != null) {
            while (p.left != null) {
                p = p.left;
            }
        }
        return p;
    }

    private Node findMax(Node p) {
        if (p != null) {
            while (p.right != null) {
                p = p.right;
            }
        }
        return p;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public Boolean removeBTS(int num) {
        root = remove(num, root);
        if (root.data == num) {
            return true;
        } else {
            return false;
        }
    }

    public Node remove(int num, Node p) {
        if (p != null) {
            if (num < p.data) {
                p.left = remove(num, p.left);
            } else {
                if (p.left == null && p.right == null) {
                    p = null;
                } else {
                    if (p.left == null) {
                        p = p.right;
                    } else {
                        if (p.right == null) {
                            p = p.left;
                        } else {
                            Node t = findMin(p.right);
                            p.data = t.data;
                            p.right = remove(p.data, p.right);
                        }
                    }
                }
            }
        } else {
            System.out.println("item not in tree and not removed");
        }
        return p;
    }

    public boolean find(int id) {
        Node act = root;
        while (act != null) {
            if (act.data == id) {
                return true;
            } else if (act.data > id) {
                act = act.left;
            } else {
                act = act.right;
            }
        }
        return false;
    }

    private class Node implements Serializable {

        public Node left;
        public Node right;
        public int data;

        public Node() {

        }

        public Node(int data) {
            left = null;
            right = null;
            this.data = data;
        }
    }
}
