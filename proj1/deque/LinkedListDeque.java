package deque;

public class LinkedListDeque <T>{
    public class Tnode{
        public T item;
        public Tnode pre;
        public Tnode next;
        public Tnode(T t,Tnode p,Tnode n){
            item=t;
            pre=p;
            next=n;
        }
    }
    public Tnode sentail;
    public int size;
    public LinkedListDeque(T t){
        sentail=new Tnode(null,null,null);
        sentail.next=new Tnode(t,sentail,sentail);
        sentail.pre=sentail.next;
        size+=1;
    }
    public LinkedListDeque(){
        sentail=new Tnode(null,null,null);
        sentail.pre=sentail;
        sentail.next=sentail;
        size=0;
    }
    public void addFirst(T t){
        size+=1;
        sentail.next = new Tnode(t, sentail, sentail.next);
        sentail.next.next.pre=sentail.next;
    }
    public void addLast(T t){
        size+=1;
        sentail.pre.next=new Tnode(t, sentail.pre, sentail);
        sentail.pre=sentail.pre.next;
    }
    public boolean isEmpty(){
        if(sentail.next==sentail)return true;
        else return false;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        Tnode p=sentail.next;
        while(p!=sentail){
            System.out.print(p.item+" ");
            p=p.next;
        }
    }
    public T removeFirst(){
        size-=1;
        T t;
        if(sentail.next==sentail){
            return null;
        }else {
            t=sentail.next.item;
            sentail.next=sentail.next.next;
            sentail.next.next.pre=sentail;
            return t;
        }
    }
    public T removeLast(){
        size-=1;
        T t;
        if(sentail.next==sentail){
            return null;
        }else {
            t=sentail.pre.item;
            sentail.pre=sentail.pre.pre;
            sentail.pre.pre.next=sentail;
            return t;
        }
    }
    public T get(int index){
        Tnode t=sentail;
        if(index>size){
            return null;
        }else{
            while(index!=0){
                t=t.next;
                index--;
            }
            return t.item;
        }
    }
    public static void main(String[] args){
        LinkedListDeque<String> L1 = new LinkedListDeque<String>("to");
        L1.addFirst("love");
        L1.addLast("you");
        if(L1.isEmpty()){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
        L1.printDeque();
        L1.removeFirst();
        L1.printDeque();
        System.out.println(L1.get(100));
    }
}
