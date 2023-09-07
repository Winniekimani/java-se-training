package com.systechafrika.part2.encapsulation;

public class Student {
    private int id;
    private String regNo;
    private String name;

    public Student() {
    }

    public Student(int id, String regNo, String name) {
        this.id = id;
        this.regNo = regNo;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", regNo=" + regNo + ", name=" + name + "]";
    }

}
