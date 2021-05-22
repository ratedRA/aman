package com;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

// eviction policy
// whenver we have to remove the any element from cache we would remove the least recently used.
public class LRUCache {
    public static final Integer DEFAULT_CACHE_SIZE = 100;

    private Set<Object> pageNumberToFrameMap;
    private Deque<Object> cache;
    private Integer cacheSize = DEFAULT_CACHE_SIZE;

    public LRUCache(Integer cacheSize) {
        this.cache = new LinkedList<>();
        this.pageNumberToFrameMap = new HashSet();
        if(cacheSize!=null){
            this.cacheSize = cacheSize;
        }
    }

    private void refer(Object data){
        if(!pageNumberToFrameMap.contains(data)){
            if(cache.size()==cacheSize){
                Object lastElement = cache.removeLast();
                pageNumberToFrameMap.remove(lastElement);
            }
        } else {
            cache.remove(data);
        }
        cache.push(data);
        pageNumberToFrameMap.add(data);
    }

    private void display(){
        Iterator<Object> itr = cache.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(10);
        for(int i = 0; i<100; i+=1){
            lruCache.refer((Integer) i);
        }
        //lruCache.display();
        lruCache.refer(1);
        lruCache.display();
    }
}
