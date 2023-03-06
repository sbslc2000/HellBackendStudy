package org.cau.hellspringboot.study;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LambdaTest {

    @FunctionalInterface
    interface IntegerListMapper {
        int map(int a);
    }

    static class MyIntegerList {
        private List<Integer> list = new ArrayList<>();

        public void print() {
            list.forEach(System.out::println);
        }

        public void add(int n) {
            list.add(n);
        }


        public void map(IntegerListMapper integerListMapper) {
            for(int i=0; i<list.size(); i++) {
                list.set(i,integerListMapper.map(list.get(i)));
            }
        }


    }

    @Test
    void test1() {
        MyIntegerList myIntegerList = new MyIntegerList();

        myIntegerList.add(1);
        myIntegerList.add(2);
        myIntegerList.add(3);

        myIntegerList.map(new IntegerListMapper() {
            @Override
            public int map(int a) {
                return a*a;
            }
        });

        myIntegerList.map(e-> e+e);

        myIntegerList.print();

    }
}
