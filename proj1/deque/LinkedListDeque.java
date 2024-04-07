package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T> ,Iterable<T>{
    private Tnode sentail;
    private int size;


    public LinkedListDeque() {
        sentail = new Tnode(null, null, null);
        sentail.pre = sentail;
        sentail.next = sentail;
        size = 0;
    }

    public void addFirst(T t) {
        size += 1;
        sentail.next = new Tnode(t, sentail, sentail.next);
        sentail.next.next.pre = sentail.next;
    }

    public void addLast(T t) {
        size += 1;
        sentail.pre.next = new Tnode(t, sentail.pre, sentail);
        sentail.pre = sentail.pre.next;
    }


    public int size() {
        return size;
    }

    public void printDeque() {
        Tnode p = sentail.next;
        while (p != sentail) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        T t;
        if (sentail.next == sentail) {
            return null;
        } else {
            size -= 1;
            Tnode rmNode = sentail.next;
            t = rmNode.item;
            sentail.next = rmNode.next;
            rmNode.next.pre = sentail;
            rmNode.item = null;
            rmNode.next = null;
            rmNode.pre = null;
            return t;
        }
    }

    public T removeLast() {
        T t;
        if (sentail.next == sentail) {
            return null;
        } else {
            size -= 1;
            Tnode rmNode = sentail.pre;
            t = rmNode.item;
            sentail.pre = rmNode.pre;
            rmNode.pre.next = sentail;
            rmNode.item = null;
            rmNode.next = null;
            rmNode.pre = null;
            return t;
        }
    }

    public T get(int index) {
        if(size==0){
            return null;
        }
        Tnode t = sentail.next;
        if (index > size) {
            return null;
        } else {
            while (index != 0) {
                t = t.next;
                index--;
            }
            return t.item;
        }
    }

    public T getRecursive(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        if(size==0){
            return null;
        }
        return getRecursivehelp(sentail.next, index);
    }

    private T getRecursivehelp(Tnode t, int index) {
        if (index == 0) {
            return t.item;
        }
        return getRecursivehelp(t.next, index - 1);
    }

    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    public boolean equals(Object o) {
        if (!(o instanceof Deque)) {
            return false;
        }
        Deque<T> o1 = (Deque<T>) o;
        if (o1.size() != this.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!this.get(i).equals(o1.get(i))) {
                return false;
            }
        }
        return true;
    }

    private class Tnode {
        public T item;
        public Tnode pre;
        public Tnode next;

        public Tnode(T t, Tnode p, Tnode n) {
            item = t;
            pre = p;
            next = n;
        }
    }

    private class LinkedListDequeIterator implements Iterator<T> {
        private int wize;

        public LinkedListDequeIterator() {
            wize = 0;
        }


        @Override
        public boolean hasNext() {
            return wize < size;
        }

        @Override
        public T next() {
            T returnItem = get(wize);
            wize += 1;
            return returnItem;
        }
    }
}
