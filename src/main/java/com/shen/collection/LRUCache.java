package com.shen.collection;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> extends LinkedHashMap<K,V> {

    /** 最大数据存储容量 */  
    private static final int  LRU_MAX_CAPACITY     = 1024;  

    /** 存储数据容量  */  
    private int               capacity;  

    public LRUCache() {  
        super();  
    }  

    public LRUCache(int initialCapacity, float loadFactor,Boolean useCache) {  
        super(initialCapacity, loadFactor, useCache);  
        capacity = LRU_MAX_CAPACITY;  
    }  

 
    public LRUCache(int initialCapacity, float loadFactor,Boolean useCache, int lruCapacity) {  
        super(initialCapacity, loadFactor, true);  
        this.capacity = lruCapacity;  
    }  

    @Override 
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        System.out.println(eldest.getKey() + "=" + eldest.getValue());  
        return size () > LRUCache.this.capacity;
    }  
    
    
    public static void main(String[] args) {  
    	  
    	LRUCache<String, String> map = new LRUCache<String, String>(16, 0.75f,true);  
        map.put("a", "a"); //a  a  
        map.put("b", "b"); //a  a b  
        map.put("c", "c"); //a  a b c  
        map.put("a", "a2"); //   b c a       
        map.put("d", "d"); //b  b c a d  
        map.put("a", "a3"); //   b c d a  
        map.put("b", "b2"); //   c d a b       
        map.put("f", "f"); //c  c d a b f  
        map.put("g", "g"); //c  c d a b f g  
      
        map.get("d"); //c a b f g d  
        for (java.util.Map.Entry<String, String> entry : map.entrySet()) {  
            System.out.print(entry.getValue() + ", ");  
        }  
        System.out.println();  
      
        /*map.get("a"); //c b f g d a  
        for (Entry<String, String> entry : map.entrySet()) {  
            System.out.print(entry.getValue() + ", ");  
        }  
        System.out.println();  
      
        map.get("c"); //b f g d a c  
        for (Entry<String, String> entry : map.entrySet()) {  
            System.out.print(entry.getValue() + ", ");  
        }  
        System.out.println();  
      
        map.get("b"); //f g d a c b  
        for (Entry<String, String> entry : map.entrySet()) {  
            System.out.print(entry.getValue() + ", ");  
        }  
        System.out.println();  
      
        map.put("h", "h"); //f  f g d a c b h  
        for (Entry<String, String> entry : map.entrySet()) {  
            System.out.print(entry.getValue() + ", ");  
        }  
        System.out.println();  */
    }
}
