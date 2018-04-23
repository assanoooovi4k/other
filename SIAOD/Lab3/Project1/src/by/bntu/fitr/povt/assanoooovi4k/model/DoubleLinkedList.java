package by.bntu.fitr.povt.assanoooovi4k.model;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class DoubleLinkedList<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int size;


    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
        private Node<Item> prev;
    }


    public DoubleLinkedList() {
        first = null;
        last  = null;
        size = 0;
    }


    public boolean isEmpty() {
        return first == null;
    }


    public int size() {
        return size;
    }


    public void addFront(Item item) {
        Node<Item> newNode = new Node<Item>();
        newNode.item = item;

        if(first == null) {
            first = last = newNode;
        }
        else {
            newNode.next = first;
            first = newNode;
            newNode.next.prev = first;
        }

        size++;
    }

    public Item deleteFront() {
        if (first == null) {
            throw new NoSuchElementException("List is empty!");
        }
        else {
            Node<Item> temp = first;

            if(first.next != null) {
                first.next.prev = null;
            }

            first = first.next;
            size--;
            return temp.item;
        }
    }

    public void addBack(Item item) {
        Node<Item> newNode = new Node<Item>();
        newNode.item = item;

        if(first == null) {
            first = last = newNode;
        }
        else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }

        size++;
    }

    public Item deleteBack() {
        if (last == null) {
            throw new NoSuchElementException("List is empty!");
        }
        else {
            Node<Item> temp = last;

            if(last.prev != null) {
                last.prev.next = null;
            }

            last = last.prev;
            size--;
            return temp.item;
        }
    }

    public Item deleteElement(int index) {
        if (index<1 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Error!");
        }
        else if (index == 1){
            return deleteFront();
        }
        else if (index == size) {
            return deleteBack();
        }
        else {
            int count = 1;
            Node<Item> current;
            current = first;

            while (current != null && count != index) {
                current = current.next;
                count++;
            }

            Node<Item> deleted = current;

            current.prev.next = current.next;
            current.next.prev = current.prev;

            return deleted.item;
        }
    }


    public void clearList() {
        while (!isEmpty()) {
                deleteFront();
        }
    }


    public Item[] toArray() {
        Object[] objects = new Object[size()];
        Iterator iterator = iterator();
        int i = 0;
        while (iterator.hasNext()) {
            objects[i] = iterator.next();
            i++;
        }
        return (Item[]) objects;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first);
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}