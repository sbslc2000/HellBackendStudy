package org.cau.hellspringboot.study;


import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {


    static class Student extends Person {

        @Override
        public String toString() {
            return "Student{" +
                    "studentId=" + studentId +
                    ", id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        private int studentId;

        public Student(Long id, String name, int age) {
            super(id, name, age);
        }

        public Student(Long id, String name, int age, int studentId) {
            super(id, name, age);
            this.studentId = studentId;
        }
    }

    static class Person {
        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        protected Long id;
        protected String name;
        protected int age;

        public Person(Long id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }



    @Test
    void generateStream() {
        //arr to Stream
        String[] sourceArr = new String[] {"Seo","Kim","Son","Han","Lim"};
        Stream<String> arrStream = Arrays.stream(sourceArr);

        //List to Stream
        List<String> sourceList = Arrays.asList("Seo","Kim","Son","Han","Lim");
        Stream<String> listStream = sourceList.stream();

        //StreamBuilder
        Stream<String> builderStream = Stream.<String>builder()
                .add("Seo")
                .add("Kim")
                .add("Son")
                .add("Han")
                .add("Lim")
                .build();

        //generate
        Stream<String> generateStream = Stream.generate(() -> "Seo")
                .limit(5);

        //iterate
        Stream<Integer> limit = Stream.iterate(10, n -> n * 2)
                .limit(5); //10 20 40 80 160


        //가공하기

        List<Person> userList= Arrays.asList(
                new Person(1L,"서범석",24),
                new Person(2L,"김신웅",24),
                new Person(3L, "한정민", 24),
                new Person(4L, "임수현",23),
                new Person(5L,"손유진",22)
        );

        //filter
        Stream<Person> userUnder24 = userList.stream()
                .filter(user -> user.getAge() < 24);

        //map
        Stream<Student> studentStream = userList.stream()
                .map(user -> new Student(user.getId(), user.getName(), user.getAge(), 20190000));

        studentStream.forEach(System.out::println);

        //sorted

        Stream<Person> sortedPerson = userList.stream()
                .sorted(Comparator.comparing(Person::getName));

        sortedPerson.forEach(System.out::println);


        //결과 만들기

        long count = userList.stream()
                .filter(user -> user.getAge() == 24)
                .count();

        System.out.println("count = " + count);


        List<Person> kimList = userList.stream()
                .filter(user -> user.getName()
                        .startsWith("김"))
                .collect(Collectors.toList());

        kimList.forEach(System.out::println);

        Set<Person> collect = userList.stream()
                .collect(Collectors.toSet());

    }

}
