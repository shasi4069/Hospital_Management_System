package com.pms.PatientManagementSystem.controller;

import java.util.Scanner;
import com.pms.PatientManagementSystem.model.Doctor;
import com.pms.PatientManagementSystem.service.impl.DoctorServiceImpl;

public class DoctorController {

    DoctorServiceImpl service = new DoctorServiceImpl();
    Scanner sc = new Scanner(System.in);

    public void addDoctor() {
        Doctor d = new Doctor();
        System.out.print("Name: ");
        d.setName(sc.next());
        System.out.print("Specialization: ");
        d.setSpecialization(sc.next());
        System.out.print("Contact: ");
        d.setContact(sc.next());
        System.out.print("Fee: ");
        d.setFee(sc.nextInt());
        service.addDoctor(d);
        System.out.println("Doctor Added Successfully");
    }

    public void viewDoctors() {
        service.getDoctors().forEach(d ->
            System.out.println(d.getDoctorId()+" "+d.getName()+" "+d.getSpecialization()));
    }
}
