package com.systechafrika.part2.classes;

import java.util.ArrayList;
import java.util.List;

public class ClassesDemo {

    public static void main(String[] args) {
        ClassesDemo a = new ClassesDemo();

        int num = 5;
        do {
            System.out.println(num-- + "");
        } while (num == 0);

        // a.interns();
        // a.people();
        // a.methodsExample();
        // a.names();

        // String names[] = { "Thomas", "Peter", "Joseph" };
        // String pwd[] = new String[3];
        // int idx = 0;
        // try {
        // for (String n : names) {
        // pwd[idx] = n.substring(2, 6);
        // idx++;
        // }
        // } catch (Exception e) {
        // System.out.println("Invalid name");
        // }
        // for (String p : pwd) {
        // System.out.println(p);
        // }

        // int numbers[];
        // numbers = new int[2];
        // numbers[0] = 10;
        // numbers[1] = 20;
        // numbers = new int[4];
        // numbers[2] = 30;
        // numbers[3] = 40;

        // for (int x : numbers) {
        // System.out.println("" + x);
        // }

        // ArrayList<Integer> points = new ArrayList<>();
        // points.add(1);
        // points.add(2);
        // points.add(3);
        // points.add(4);
        // points.add(null);
        // points.remove(2);
        // points.remove(null);
        // System.out.println(points);

        // Base b1 = new DerivedB();// derivedb
        // Base b2 = new DerivedA();// deriveda
        // Base b3 = new DerivedB();// deriveda
        // b1 = (Base) b3;
        // Base b4 = (DerivedA) b3;
        // b1.test();
        // b4.test();

    }

    public void names() {
        List<String> names = new ArrayList<>();
        names.add("Robb");
        names.add("Bran");
        names.add("Rick");
        names.add("Bran");
        if (names.remove("Bran")) {
            names.remove("Jon");
        }
        System.out.println(names);
    }

    public void methodsExample() {
        MethodsExample a = new MethodsExample();
        a.sayHello();// calling the method without parameters
        System.out.println(a.add(10, 10));
    }

    public void interns() {
        Intern a = new Intern();
        a.name = "winnie";
        a.email = "kimaniwinniew@gmail.com";
        a.phoneNumber = "0909090807";
        System.out.println("intern a name is " + a.name);
        System.out.println("intern a email is " + a.email);
        a.doAssignment();
        a.attendClass();

        Intern b = new Intern();
        b.name = "njeri";
        b.email = "njerwanjru45@gmail.com";
        b.phoneNumber = "0735678990";
        b.doAssignment();
        b.attendClass();
    }

    public void people() {
        Person a = new Person();
        a.age = 20;
        a.skinColor = "black";
        a.department = "finance";
        System.out.println(
                "This person is of age " + a.age + "," + "and his skincolor is " + a.skinColor + "." + "Department:"
                        + a.department);
        a.startRunning();
        a.startEating();

        Person b = new Person();
        b.age = 40;
        b.skinColor = "white";
        b.department = "ICT";
        b.startRunning();
        b.startEating();

    }

}
