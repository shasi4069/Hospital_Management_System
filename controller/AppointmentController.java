package com.pms.PatientManagementSystem.controller;

import java.util.Scanner;
import com.pms.PatientManagementSystem.model.Appointment;
import com.pms.PatientManagementSystem.service.impl.AppointmentServiceImpl;

public class AppointmentController {

    AppointmentServiceImpl service = new AppointmentServiceImpl();
    Scanner sc = new Scanner(System.in);

    public void bookAppointment() {
        Appointment a = new Appointment();
        System.out.print("Patient ID: ");
        a.setPatientId(sc.nextInt());
        System.out.print("Doctor ID: ");
        a.setDoctorId(sc.nextInt());
        System.out.print("Date (yyyy-mm-dd): ");
        a.setAppointmentDate(java.sql.Date.valueOf(sc.next()));
        System.out.print("Time (hh:mm:ss): ");
        a.setAppointmentTime(java.sql.Time.valueOf(sc.next()));

        boolean success = service.bookAppointmentWithCheck(a);
        if (success)
            System.out.println("Appointment Booked");
        else
            System.out.println("Doctor already booked for this slot!");
    }

    public void viewAppointments() {
        service.getAppointments().forEach(a ->
            System.out.println(a.getAppointmentId()+" P:"+a.getPatientId()+" D:"+a.getDoctorId()+" "+a.getAppointmentDate()+" "+a.getAppointmentTime()));
    }
}
