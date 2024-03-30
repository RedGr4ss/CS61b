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
        return sentail.next == sentail;
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
        System.out.println();
    }
    public T removeFirst(){
        T t;
        if(sentail.next==sentail){
            return null;
        }else {
            size-=1;
            Tnode rmNode=sentail.next;
            t=rmNode.item;
            sentail.next=rmNode.next;
            rmNode.next.pre=sentail;
            rmNode.item = null;
            rmNode.next = null;
            rmNode.pre = null;
            return t;
        }
    }
    public T removeLast(){
        T t;
        if(sentail.next==sentail){
            return null;
        }else {
            size-=1;
            Tnode rmNode=sentail.pre;
            t=rmNode.item;
            sentail.pre=rmNode.pre;
            rmNode.pre.next=sentail;
            rmNode.item = null;
            rmNode.next = null;
            rmNode.pre = null;
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
    public T getRecursive(int index){
        if(index<0||index>size){
            return null;
        }
        return getRecursivehelp(sentail,index);
    }
    public T getRecursivehelp(Tnode t,int index){
        if (index == 0) {
            return t.item;
        }
        return getRecursivehelp(t.next, index - 1);
    }
}
