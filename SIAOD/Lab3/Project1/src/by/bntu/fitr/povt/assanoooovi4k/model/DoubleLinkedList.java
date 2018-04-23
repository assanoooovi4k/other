package by.bntu.fitr.povt.assanoooovi4k.model;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class DoubleLinkedList<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int size = 0;


    Node<Item> node(int index) {
        if (index < (size >> 1)) {
            Node<Item> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<Item> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    private static class Node<Item> {
        Item item;
        Node<Item> next;
        Node<Item> prev;

        Node(Node<Item> prev, Item element, Node<Item> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }


    public DoubleLinkedList() {
    }


    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ". Size " + size);
    }

    private void linkFirst(Item item) {
        Node<Item> f = first;
        Node<Item> newNode = new Node<>(null, item, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }

    private void linkLast(Item item) {
        final Node<Item> l = last;
        final Node<Item> newNode = new Node<>(l, item, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    Item unlink(Node<Item> x) {
        // assert x != null;
        Item element = x.item;
        Node<Item> next = x.next;
        Node<Item> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    private Item unlinkFirst(Node<Item> f) {
        Item element = f.item;
        Node<Item> next = f.next;
        f.item = null;
        f.next = null;
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        return element;
    }

    private Item unlinkLast(Node<Item> l) {
        Item element = l.item;
        Node<Item> prev = l.prev;
        l.item = null;
        l.prev = null; // help GC
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        return element;
    }

    public void addFirst(Item item) {
        linkFirst(item);
    }

    public void addLast(Item item) {
        linkLast(item);
    }

    public Item removeFirst() {
        final Node<Item> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return unlinkFirst(f);
    }

    public Item removeLast() {
        final Node<Item> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return unlinkLast(l);
    }

    public Item remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }


    public void clearList() {
        while (!isEmpty()) {
                removeFirst();
        }
    }


    public <Item> Item[] toArray(Item[] items) {
        Object[] objects = items;
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