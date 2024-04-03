package deque;

public class ArrayDeque<T> implements Deque<T>{
    int size;
    T[] Ar;
    int nextf;
    int nextb;
    public ArrayDeque(){
        Ar=(T[]) new Object[8];
        nextf=3;
        nextb=4;
        size=0;
    }
    public void resize(int cap){
        T[] ar=(T[]) new Object[cap];
        //以四分之一为一块，放在中间两块
        for(int i=0;i<size;i++){
            int idx=arrindex(i);
            ar[cap/4+i]=Ar[idx];
        }
        Ar=ar;
        nextf=cap/4-1;
        nextb=cap/4+size;
    }
    public int arrindex(int x){
        if(nextf+1+x>=Ar.length){
            return nextf+1+x-Ar.length;
        }return nextf+1+x;
    }
    public void addFirst(T item){
        if(size==Ar.length-2){
            resize((int) Ar.length*2);
        }
        Ar[nextf]=item;
        if(nextf==0){
            nextf=Ar.length-1;
        }else{
            nextf--;
        }
        size++;
    }
    public void addLast(T item){
        if(size==Ar.length-2){
            resize((int)Ar.length*2);
        }
        Ar[nextb]=item;
        if(nextb==Ar.length-1){
            nextb=0;
        }else{
            nextb++;
        }
        size++;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        for(int i=0;i<size;i++){
            int idx=arrindex(i);
            System.out.print(Ar[idx]+" ");
        }
    }
    public T removeFirst(){
        T t;
        if(isEmpty()){
            return null;
        }
        if ((size < Ar.length / 4) && (size > 8)) {
            resize(Ar.length / 2);
        }
        if(nextf!=Ar.length-1) {
            nextf++;
        }else {
            nextf=0;
        }
        t=Ar[nextf];
        Ar[nextf]=null;
        size-=1;
        return t;

    }
    public T removeLast(){
        T t;
        if(isEmpty()){
            return null;
        }
        if ((size < Ar.length / 4) && (size > 8)) {
            resize((int) Ar.length / 2);
        }
        if(nextb!=0) {
            nextb--;
        }else {
            nextb=Ar.length-1;
        }
        t=Ar[nextb];
        Ar[nextb]=null;
        size-=1;
        return t;

    }
    public T get(int index){
        int idx=arrindex(index);
        return Ar[idx];
    }

}