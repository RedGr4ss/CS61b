package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    Comparator<T> Ilist;

    public MaxArrayDeque(Comparator<T> t){
        super();
        Ilist=t;
    }
    public T max(){
        if(isEmpty()){
            return null;
        }else{
            T t= this.get(0);
            for(int i=0;i< this.size;i++){
                if(Ilist.compare(t,this.get(i))>0){
                    t=this.get(i);
                }
            }
            return t;
        }
    }
    public T max(Comparator<T> c){
        if(isEmpty()){
            return null;
        }else{
            T t= this.get(0);
            for(int i=0;i< this.size;i++){
                if(c.compare(t,this.get(i))>0){
                    t=this.get(i);
                }
            }
            return t;
        }
    }
}
