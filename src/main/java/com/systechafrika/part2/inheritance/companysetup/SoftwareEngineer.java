package com.systechafrika.part2.inheritance.companysetup;

public class SoftwareEngineer extends Employee {
    private String title;

    public SoftwareEngineer(String employeeNo, String employeeName, String employeeAdress, String title) {
        super(employeeNo, employeeName, employeeAdress);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "SoftwareEngineer [title=" + title + "]";
    }

}
