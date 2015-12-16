package com.shen.collection;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * Created by shenge on 15/12/16.
 *
 * 2种put方法其实是一样的，第二种更简洁，不会丢值。
 *
 */
public class MapPut {

    public static void main(String[] args) {
        Map<Integer,List<String>> maps1 = Maps.newHashMap();
        Map<Integer,List<String>> maps2 = Maps.newHashMap();
        MapPut.put1(maps1);
        MapPut.put2(maps2);
    }

    static void put1(Map<Integer,List<String>> maps){
        for(int i = 0; i<5; i++){
            List<String> values = maps.get(i);
            if(null == values){
                values = Lists.newArrayList();
                values.add("v"+i);
                maps.put(i,values);
            }else{
                values.add("v"+i);
            }
        }
        System.out.println(maps);
    }

    static void put2(Map<Integer,List<String>> maps){
        for(int i = 0; i<5; i++){
            List<String> values = maps.get(i);
            if(null == values){
                values = Lists.newArrayList();
                maps.put(i,values);
            }
            values.add("vv"+i);
        }
        System.out.println(maps);
    }

}
