package com.pms.PatientManagementSystem.controller;

import java.util.Scanner;
import com.pms.PatientManagementSystem.model.Patient;
import com.pms.PatientManagementSystem.service.impl.PatientServiceImpl;

public class PatientController {

    PatientServiceImpl service = new PatientServiceImpl();
    Scanner sc = new Scanner(System.in);

    public void addPatient() {
        Patient p = new Patient();
        System.out.print("Name: ");
        p.setName(sc.next());
        System.out.print("Age: ");
        p.setAge(sc.next());
        System.out.print("Gender: ");
        p.setGender(sc.next());
        System.out.print("Contact: ");
        p.setContact(sc.next());
        System.out.print("Address: ");
        p.setAddress(sc.next());
        service.registerPatient(p);
        System.out.println("Patient Registered Successfully");
    }

    public void viewPatients() {
        service.getPatients().forEach(p ->
            System.out.println(p.getPatientId()+" "+p.getName()+" "+p.getContact()));
    }

    public void searchPatient() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        Patient p = service.searchPatient(id);
        if (p != null)
            System.out.println(p.getPatientId()+" "+p.getName()+" "+p.getContact());
        else
            System.out.println("Patient Not Found");
    }

    public void updatePatient() {
        Patient p = new Patient();
        System.out.print("Patient ID: ");
        p.setPatientId(sc.nextInt());
        System.out.print("New Name: ");
        p.setName(sc.next());
        System.out.print("New Age: ");
        p.setAge(sc.next());
        System.out.print("New Contact: ");
        p.setContact(sc.next());
        service.updatePatient(p);
        System.out.println("Patient Updated");
    }

    public void deletePatient() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        service.deletePatient(id);
        System.out.println("Patient Deleted");
    }
}
