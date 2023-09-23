package com.systechafrika.part2.encapsulation;

import java.util.Scanner;

public class StudentMS {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter number of students: ");
            int noOfStudents = scanner.nextInt(); // \n After reading a value using nextInt, there is a trailing new
                                                  // line
                                                  // that
            // needs to be read before reading other subsequent inputs
            scanner.nextLine();

            Student[] students = new Student[noOfStudents];
            for (int i = 0; i < students.length; i++) {
                System.out.print("Enter student ID: ");
                int studentID = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter student Reg No: ");
                String regNo = scanner.nextLine();

                System.out.print("Enter student name: ");
                String name = scanner.nextLine();

                Student s = new Student(studentID, regNo, name);
                students[i] = s;
            }
            for (Student student : students) {
                System.out.println(student);
            }
        }

    }

}
