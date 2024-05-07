package bstmap;

import java.util.Iterator;
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
        }
    }
    private BSTnode root;
    @Override
    public void clear() {
        root=null;
    }

    @Override
    public boolean containsKey(K key) {
        if(get(key)!=null) {
            return true;
        }
        return false;
    }

    @Override
    public V get(K key) {
        BSTnode node = root;
        return get(node,key);
    }
    public V get(BSTnode node, K key){
        if(node==null){
            return null;
        }
        int cmp=key.compareTo(node.Key);
        if(cmp<0){
            get(node.left,key);
        }else if(cmp>0){
            get(node.right,key);
        }
        return node.Value;
    }

    @Override
    public int size() {
        return root.size;
    }

    @Override
    public void put(K key, V value) {
        if(containsKey(key)){
            return;
        }
         put(root,key,value);
    }
    private void put(BSTnode node,K key, V value){
        if(node==null){
            node.Key=key;
            node.Value=value;
            node.left=null;
            node.right=null;
        }
        int cmp = key.compareTo(node.Key);
        if(cmp<0){
            put(node.left,key,value);
        }else {
            put(node.right,key,value);
        }
    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
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
