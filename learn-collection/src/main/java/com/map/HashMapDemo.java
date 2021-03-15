package com.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gys
 * @version 1.0
 * @date 2021/3/15 下午1:02
 */
public class HashMapDemo {
    public static void testHashMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("test1", "1");
        map.put("test2", "2");
        map.put("test3", "3");

        //当循环中只需要获取Map 的主键key时，迭代keySet()
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(value);
        }

        //当需要主键key 和取值value 时，迭代entrySet() 才是更高效的做法，其比先迭代keySet() 后再去通过get 取值性能更佳。
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "->" + value);
        }
    }

    public static void main(String[] args) {
        testHashMap();
    }
}
