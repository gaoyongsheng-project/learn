package com.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author gys
 * @version 1.0
 * @date 2021/3/15 下午1:04
 */
public class ArrayListDemo {
    /**
     * 定义一个集合
     *
     * @return
     */
    public static List<String> getStrList() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("e");
        list.add("f");
        list.add("c");
        list.add("d");
        return list;
    }

    /**
     * 过滤符合条件的元素
     */
    public static void filter() {
        List<String> list = new ArrayList<>();
        list.add("bb");
        list.add("aa");
        list.add("aa");
        list.add("cc");
        list.stream().filter(value -> {
            return value.equals("aa");
        }).forEach(value -> {
            System.out.println(value);
        });
    }

    /**
     * 循环遍历List
     */
    public static void forEach() {
        List<String> list = getStrList();
        list.stream().forEach(value -> {
            System.out.println(value);
        });
    }

    /**
     * list集合返回拼接字符串
     */
    public static void joinString() {
        List<String> list = getStrList();
        System.out.println("操作前list：" + list);
        String collect = list.stream().sorted((a, b) -> {
            return b.compareTo(a);
        }).collect(Collectors.joining(",", "前", "后"));
        System.out.println("操作后：" + collect);
    }

    /**
     * 升序或降序排序
     */
    public static void sorted() {
        List<String> list = getStrList();
        System.out.println("排序前list：");
        list.stream().forEach(value -> {
            System.out.print(value + "\t");
        });
        List<String> collect = list.stream().sorted((a, b) -> {
            return a.compareTo(b);
        }).collect(Collectors.toList());
        System.out.println();
        System.out.println("升序排序后：" + collect);

        collect = list.stream().sorted((a, b) -> {
            return b.compareTo(a);
        }).collect(Collectors.toList());
        System.out.println("降序排序后：" + collect);
    }

    /**
     * map 匹配操作元素
     */
    public static void map() {
        List<String> list = new ArrayList<>();
        list.add("bb");
        list.add("aa");
        list.add("cc");
        System.out.println("操作前list：" + list);
        List<String> collect = list.stream().map(value -> {
            if (value.equals("aa")) {
                return "dd";
            }
            return value;
        }).collect(Collectors.toList());
        System.out.println("操作后：" + collect);
    }

    /**
     * 合并多个数组
     */
    public static void flatMap() {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("cc");
        List<String> list1 = Arrays.asList("bb");
        System.out.println("操作前list：" + list + "\t" + "list1：" + list1);
        List<List> lists = Arrays.asList(list, list1);
        List<String> collect = (List<String>) lists.stream().flatMap(value -> value.stream()).collect(Collectors.toList());
        System.out.println("操作后：s" + collect);
    }

    public static void main(String[] args) {
        filter();
    }

}
