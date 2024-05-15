package bstmap;

import net.sf.saxon.expr.instruct.ITemplateCall;

import java.util.*;

public class BSTMap <K extends Comparable,V> implements Map61B<K,V>{
    private node root;

    private class node{
        K key;
        V value;
        int size;
        node left;
        node right;
        public node(K key,V value){
            this.key=key;
            this.value=value;
            size=1;
            left=null;
            right=null;
        }
    }
    @Override
    public void clear() {
        root=null;
    }

    @Override
    public boolean containsKey(K key) {
        Set<K> set = keySet();
        if(set.contains(key)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public V get(K key) {
        if(!containsKey(key)){
            return null;
        }
        V result=get(root,key);
        return result;
    }
    private V get(node n,K key){
        if(n==null){
            return null;
        }
        int cmp = key.compareTo(n.key);
        if(cmp<0){
            return get(n.left,key);
        }else if(cmp>0){
            return get(n.right,key);
        }else {
            return n.value;
        }
    }
    @Override
    public int size() {
        return size(root);

    }
    private int size(node n){
        if(n==null){
            return 0;
        }
        return size(n.left)+size(n.right)+n.size;
    }
    @Override
    public void put(K key, V value) {
        root=put(root,key,value);
    }

    private node put(node n,K key,V value){
        if(n==null){
            return new node(key,value);
        }
        int cmp = key.compareTo(n.key);
        if(cmp < 0){
            n.left = put(n.left,key,value);
        }else if(cmp > 0){
            n.right = put(n.right,key,value);
        }else {
            n.value=value;
            n.key=key;
            n.size=1;
        }
        return n;
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        addset(root,set);
        return set;
    }

    private void addset(node node,Set<K> set) {
        if(node != null){
            addset(node.left,set);
            set.add(node.key);
            addset(node.right,set);
        }
    }

    @Override
    public V remove(K key) {
        V result=get(key);
        root=remove(root,key);
        return result;
    }
    private node remove(node n ,K key){
        if(n.key==key){
            if(n.left==null&&n.right==null){
                n=null;
            }
            else if(n.left==null&&n.right!=null){
                n=n.right;
            }
            else if(n.right==null&&n.left!=null){
                n=n.left;
            }
            else {
                node Tempn=findmin(n.right);
                n.key= Tempn.key;
                n.value= Tempn.value;
                n.right=remove(n.right,n.key);
            }
            return n;
        }else {
            int cmp = key.compareTo(n.key);
            if(cmp<0){
                n.left=remove(n.left,key);
            }else if(cmp>0){
                n.right=remove(n.right,key);
            }
        }
        return n;
    }
    private node findmin(node n){
        while(n.left!=null){
            n=n.left;
        }
        return n;
    }

    @Override
    public V remove(K key, V value) {
        V result=get(key);
        if(result==value){
            root=remove(root,key);
        }else {
            throw new RuntimeException("error");
        }
        return result;
    }
    public void printInorder(node n){
        if(n.left==null){
            return;
        }
        printInorder(n.left);
        System.out.println();
        printInorder(n.right);
    }

    @Override
    public Iterator<K> iterator() {
        return new BSTMapIterator();
    }

    private class BSTMapIterator implements Iterator<K> {
        private Stack<node> stack;
        public BSTMapIterator(){
            stack=new Stack<>();
            pushleft(root);
        }
        private void pushleft(node n){
            while(n!=null){
                stack.push(n);
                n=n.left;
            }
        }
        @Override
        public boolean hasNext() {
            return !stack.empty();
        }

        @Override
        public K next() {
            if(hasNext()){
                node temp=stack.pop();
                K next=temp.key;
                if(temp.right!=null){
                    pushleft(temp.right);
                }
                return next;
            }else {
                throw new NoSuchElementException();
            }
        }
    }
}
