package deque;

public class ArrayDeque<T>{
    public int size;

    public ArrayDeque(T t){
        T[] Ar=(T[]) new Object[8];
        Ar[0]=t;
    }
    public ArrayDeque(){
        T[] Ar=(T[]) new Object[0];
    }
    public static void main(String[] args){
    }
}
