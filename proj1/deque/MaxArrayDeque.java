package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private final Comparator<T> Comp;

    public MaxArrayDeque(Comparator<T> t) {
        super();
        Comp = t;
    }

    public static void main(String[] args) {
        Comparator<Integer> Comp = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return 1;
                } else if (o1 < o2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
        MaxArrayDeque<Integer> Alist = new MaxArrayDeque<>(Comp);
        for (int i = 0; i < 500; i++) {
            Alist.addFirst(i);
        }
        System.out.println(Alist.max());
    }

    public T max() {
        if (isEmpty()) {
            return null;
        } else {
            T t = this.get(0);
            for (int i = 0; i < this.size(); i++) {
                if (Comp.compare(this.get(i) , t) > 0) {
                    t = this.get(i);
                }
            }
            return t;
        }
    }

    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        } else {
            T t = this.get(0);
            for (int i = 0; i < this.size(); i++) {
                if (c.compare(this.get(i), t) > 0) {
                    t = this.get(i);
                }
            }
            return t;
        }
    }
}
