package bstmap;

import java.security.Key;
import java.util.*;

public class BSTMap <K extends Comparable,V> implements Map61B<K,V>{
    private class BSTnode{
        private K Key;
        private V Value;
        private BSTnode left,right;
        private int size;
        public BSTnode(K key,V value){
            Key=key;
            Value=value;
            left=null;
            right=null;
            size=1;
        }
    }
    private BSTnode root;
    @Override
    public void clear() {
        root=null;
    }

    @Override
    public boolean containsKey(K key) {
        Set set=keySet();
        if(set.contains(key)) {
            return true;
        } else{
            return false;
        }
    }
    @Override
    public V get(K key) {
        return getval(root,key);
    }
    public V getval(BSTnode node, K key){
        if(node==null){
            return null;
        }
        int cmp=key.compareTo(node.Key);
        if(cmp<0){
            return getval(node.left,key);
        }else if(cmp>0){
            return getval(node.right,key);
        }
        return node.Value;
    }

    @Override
    public int size() {
        return size(root);
    }
    private int size(BSTnode node){
        if(node==null){
            return 0;
        }
        return size(node.left)+size(node.right)+node.size;
    }
    @Override
    public void put(K key, V value) {
        root=put(root,key,value);
    }
    private BSTnode put(BSTnode node,K key, V value){
        if(node==null){
             return new BSTnode(key, value);
        }
        int cmp = key.compareTo(node.Key);
        if(cmp<0){
            node.left = put(node.left,key,value);
        }else if(cmp>0){
            node.right = put(node.right,key,value);
        }else {
            node.Key=key;
            node.Value=value;
        }
        return node;
    }

    @Override
    public Set keySet() {
        Set<K> set= new HashSet<>();
        addset(root,set);
        return set;
    }
    private void addset(BSTnode node,Set<K> set){
        if(node != null){
            addset(node.left,set);
            set.add(node.Key);
            addset(node.right,set);
        }
    }

    @Override
    public V remove(K key) {
        V move = get(key);
        root=remove(root,key);
        return move;
    }
    private BSTnode remove(BSTnode node ,K key){
       int cmp = key.compareTo(node.Key);
       if(cmp<0){
           node.left=remove(node.left,key);
           return node;
       } else if (cmp>0) {
           node.right=remove(node.right,key);
           return node;
       }else {
           if (node.left == null && node.right == null) {
               node = null;
               return node;
           } else if (node.left == null && node.right != null) {
               node = node.right;
               return node;
           } else if (node.left != null && node.right == null) {
               node = node.left;
               return node;
           } else {
               BSTnode rightmin = Min(root.right);
               node.Key = rightmin.Key;
               node.Value = rightmin.Value;
               node.right = remove(node.right, node.Key);
               return node;
           }
       }
    }
    private BSTnode Min(BSTnode node){
        BSTnode temp=node;
        while(temp.left!=null){
            temp=temp.left;
        }
        return temp;
    }

    @Override
    public V remove(K key, V value) {
        V result=get(key);
        if(result==value){
            root=remove(root,key);
        }else {
            throw new InputMismatchException();
        }
        return result;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
