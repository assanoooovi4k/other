package by.bntu.fitr.povt.assanoooovi4k.model;

import java.util.Comparator;


public class BinaryTree {
    private Comparator comparator;
    private Node root;


    public BinaryTree(Comparator comparator) {
        this.comparator = comparator;
    }

    public BinaryTree() {
        root = null;
    }

    public enum Direction {
        LEFT,RIGHT
    }

    class Node {
        private String getDate;
        private Node left;
        private Node right;

        Node(String data) {
            this.getDate = data;
            left = null;
            right = null;
        }

        String getData() {
            return getDate;
        }

        public void setData(String data) {
            this.getDate = data;
        }

        Node getLeft() {
            return left;
        }

        void setLeft(Node left) {
            this.left = left;
        }

        Node getRight() {
            return right;
        }

        void setRight(Node right) {
            this.right = right;
        }
    }


    public boolean find(String object) {
        Node current = root;
        while (current != null) {
            if (current.getData().equals(object)) {
                return true;
            } else if (current.getData().compareTo(object) > 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return false;
    }

    public int countList(){
        return countList(root);
    }

    private int countList(Node root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        return  countList(root.left) + countList(root.right);
    }

    public void insert(String object) {
        Node newNode = new Node(object);
        if (root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while (true) {
            parent = current;
            if (current.getData().compareTo(object) > 0) {
                current = current.getLeft();
                if (current == null) {
                    parent.setLeft(newNode);
                    return;
                }
            } else {
                current = current.getRight();
                if (current == null) {
                    parent.setRight(newNode);
                    return;
                }
            }
        }
    }

    public String getString(Direction direction) {
        StringBuilder stringBuilder = new StringBuilder();
        if (direction == Direction.LEFT) {
            displayLeft(root, stringBuilder);
        } else {
            displayRight(root, stringBuilder);
        }
        return stringBuilder.toString();
    }

    private void displayLeft(Node root, StringBuilder stringBuilder) {
        if (root != null) {
            displayLeft(root.getLeft(), stringBuilder);
            stringBuilder.append(root.getData()).append("\n");
            displayLeft(root.getRight(), stringBuilder);
        }
    }

    private void displayRight(Node root, StringBuilder stringBuilder) {
        if (root != null) {
            displayRight(root.getRight(), stringBuilder);
            stringBuilder.append(root.getData());
            displayRight(root.getLeft(), stringBuilder);
        }
    }

    @Override
    public String toString() {
        return getString(Direction.LEFT);
    }
}