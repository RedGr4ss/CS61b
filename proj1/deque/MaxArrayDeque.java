package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private final Comparator<T> Comp;

    public MaxArrayDeque(Comparator<T> t) {
        super();
        Comp = t;
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
