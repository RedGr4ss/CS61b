package bstmap;

import java.security.Key;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

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
        return containsKey(root,key);
    }
    private boolean containsKey(BSTnode node,K key) {
        if(node==null){
            return false;
        }
        int cmp= key.compareTo(node.Key);
        if(cmp<0){
            return containsKey(node.left,key);
        }
        if (cmp>0){
            return containsKey(node.right,key);
        }
        return true;
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
        throw new UnsupportedOperationException("Remove operation is not supported.");
    }
    private V remove(BSTnode node ,K key){
        throw new UnsupportedOperationException("Remove operation is not supported.");
    }

    @Override
    public V remove(K key, V value) {
        return null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
