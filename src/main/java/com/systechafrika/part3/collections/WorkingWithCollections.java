package com.systechafrika.part3.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorkingWithCollections {

    public static void main(String[] args) {
        workingWithListAndArrayList();
        workingWithSetAndHashSet();
    }

    private static void workingWithSetAndHashSet() {

        Student winnie = new Student("winnie", "456t", "kimaniwinniew@gmail.com");
        Student maryann = new Student("maryann", "4040S", "kimanimaryann@gmail.com");
        Set<Student> students = new HashSet<>();

        // adding values
        students.add(winnie);
        students.add(maryann);

        printSet(students);
        System.out.println(students.size());
        System.out.println(students.isEmpty());
        System.out.println(students.contains(winnie));

    }

    private static void printSet(Set<Student> students) {
        for (Student student : students) {
            System.out.println(student);

        }

    }

    private static void workingWithListAndArrayList() {

        List<Student> students = new ArrayList<>();
        Student winnie = new Student("winnie", "456t", "kimaniwinniew@gmail.com");
        Student maryann = new Student("maryann", "4040S", "kimanimaryann@gmail.com");
        // adding values
        students.add(winnie);
        students.add(maryann);
        students.add(winnie);
        students.add(maryann);
        printList(students);

        Student student3 = new Student("wanjiku", "4560A", "Jacqlinew@gmail.com");
        // updating values
        students.set(0, student3);
        System.out.println("after");
        printList(students);
        // checking values
        System.out.println(students.contains(winnie));
        // indexOf
        System.out.println(students.indexOf(student3));
        System.out.println(students.indexOf(winnie));

        // remove
        students.remove(winnie);
        printList(students);

    }

    private static void printList(List<Student> students) {

        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }
    }

}
