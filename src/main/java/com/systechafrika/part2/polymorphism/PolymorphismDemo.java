package com.systechafrika.part2.polymorphism;

import com.systechafrika.part2.inheritance.companysetup.DatabaseEngineer;
import com.systechafrika.part2.inheritance.companysetup.Employee;
import com.systechafrika.part2.inheritance.companysetup.QualityAssurance;
import com.systechafrika.part2.inheritance.companysetup.SoftwareEngineer;

public class PolymorphismDemo {
    public static void main(String[] args) {

        Employee james = new QualityAssurance("001", "James",
                "047", "Quality Assurance Chief Engineer");

        Employee ivy = new SoftwareEngineer("002", "Ivy",
                "035", "Senior Software Engineer");

        Employee lenna = new DatabaseEngineer("003", "Lenna",
                "035", "Senior Database Engineer");

        System.out.println(james);
        System.out.println(ivy);
        System.out.println(lenna);

    }
}
