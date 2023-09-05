package com.part2;

public class ClassesDemo {

    public static void main(String[] args) {
        ClassesDemo a = new ClassesDemo();
        // a.interns();
        // a.people();
        a.methodsExample();

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
