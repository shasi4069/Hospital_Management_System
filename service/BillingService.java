package com.pms.PatientManagementSystem.service;

import com.pms.PatientManagementSystem.model.Billing;
import java.util.List;

public interface BillingService {

    void generateBillAuto(int patientId, int doctorId);
    List<Billing> getBills();
}
