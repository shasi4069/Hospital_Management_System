package com.pms.PatientManagementSystem.controller;

import java.util.Scanner;
import com.pms.PatientManagementSystem.service.impl.BillingServiceImpl;

public class BillingController {

    BillingServiceImpl service = new BillingServiceImpl();
    Scanner sc = new Scanner(System.in);

    public void generateBill() {
        System.out.print("Patient ID: ");
        int pid = sc.nextInt();
        System.out.print("Doctor ID: ");
        int did = sc.nextInt();

        service.generateBillAuto(pid, did);   // Auto fetch doctor fee
    }

    public void viewBills() {
        service.getBills().forEach(b ->
            System.out.println(b.getBillId()+" Patient:"+b.getPatientId()+" Amount:"+b.getTotalAmount()));
    }
}
