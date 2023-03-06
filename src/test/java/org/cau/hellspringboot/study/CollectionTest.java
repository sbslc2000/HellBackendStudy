package org.cau.hellspringboot.study;

import org.junit.jupiter.api.Test;

import java.util.*;

public class CollectionTest {

    @Test
    void collectionTest1 () {
        //Collection은 자료구조 클래스들의 조상클래스입니다.
        Collection<Integer> collection = new ArrayList<Integer>();
        collection.add(1);
        collection.add(2);
        System.out.println("Collection size: "+collection.size());

        //다형성을 이용할 수 있습니다.
        List<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();

        //추측가능한 경우 Generics 부분을 생략할 수 있습니다.
        List<String> list3 = new ArrayList<>();

        //여러 메소드를 제공합니다.
        list3.add("Hello, Collection");
        String s = list3.get(0); // Hello, Collection
        boolean isContain = list3.contains("hello, Collection"); //false
        int size = list3.size(); // 1
        boolean isEmpty = list3.isEmpty(); // FALSE
        list3.remove("Hello, Collection"); // TRUE
        list3.remove(0); // error


        //map 자료형도 있습니다
        Map<String,String> map = new HashMap<>();
        map.put("key","value");
        String value = map.get("key"); // value
    }
}
