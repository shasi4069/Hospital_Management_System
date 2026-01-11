package com.pms.PatientManagementSystem.service;
import com.pms.PatientManagementSystem.model.Patient;
import java.util.List;

public interface PatientService {
 void registerPatient(Patient p);
 List<Patient> getPatients();
 Patient searchPatient(int id);
 void updatePatient(Patient p);
 void deletePatient(int id);
}
