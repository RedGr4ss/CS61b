package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T> {
    int size;
    T[] ar;
    int nextf;
    int nextb;

    public ArrayDeque() {
        ar = (T[]) new Object[8];
        nextf = 3;
        nextb = 4;
        size = 0;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> ar = new ArrayDeque<>();
        ar.addFirst(1);
        ar.addFirst(2);
        Iterator<Integer> ser = ar.iterator();
        while (ser.hasNext()) {
            System.out.println(ser.next());
        }
    }

    public void resize(int cap) {
        T[] ar = (T[]) new Object[cap];
        //以四分之一为一块，放在中间两块
        for (int i = 0; i < size; i++) {
            int idx = arrindex(i);
            ar[cap / 4 + i] = this.ar[idx];
        }
        this.ar = ar;
        nextf = cap / 4 - 1;
        nextb = cap / 4 + size;
    }

    public int arrindex(int x) {
        if (nextf + 1 + x >= ar.length) {
            return nextf + 1 + x - ar.length;
        }
        return nextf + 1 + x;
    }

    public void addFirst(T item) {
        if (size == ar.length - 2) {
            resize(ar.length * 2);
        }
        ar[nextf] = item;
        if (nextf == 0) {
            nextf = ar.length - 1;
        } else {
            nextf--;
        }
        size++;
    }

    public void addLast(T item) {
        if (size == ar.length - 2) {
            resize(ar.length * 2);
        }
        ar[nextb] = item;
        if (nextb == ar.length - 1) {
            nextb = 0;
        } else {
            nextb++;
        }
        size++;
    }

    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            int idx = arrindex(i);
            System.out.print(ar[idx] + " ");
        }
    }

    public T removeFirst() {
        T t;
        if (isEmpty()) {
            return null;
        }
        if ((size < ar.length / 4) && (size > 8)) {
            resize(ar.length / 2);
        }
        if (nextf != ar.length - 1) {
            nextf++;
        } else {
            nextf = 0;
        }
        t = ar[nextf];
        ar[nextf] = null;
        size -= 1;
        return t;

    }

    public T removeLast() {
        T t;
        if (isEmpty()) {
            return null;
        }
        if ((size < ar.length / 4) && (size > 8)) {
            resize(ar.length / 2);
        }
        if (nextb != 0) {
            nextb--;
        } else {
            nextb = ar.length - 1;
        }
        t = ar[nextb];
        ar[nextb] = null;
        size -= 1;
        return t;

    }

    public T get(int index) {
        int idx = arrindex(index);
        return ar[idx];
    }

    public boolean equals(Object o) {
        if (!(o instanceof Deque)) {
            return false;
        }
        ArrayDeque<T> o1 = (ArrayDeque<T>) o;
        if (o1.size() != this.size()) {
            return false;
        }
        if (o1.size != this.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!this.get(i).equals(o1.get(i))) {
                return false;
            }
        }
        return true;
    }

    public class ArrayDequeIterator implements Iterator<T> {
        public int wize;

        public ArrayDequeIterator() {
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
