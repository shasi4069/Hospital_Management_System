package com.pms.PatientManagementSystem.dao;
import com.pms.PatientManagementSystem.model.Patient;
import java.util.List;

public interface PatientDAO {
 void addPatient(Patient p);
 List<Patient> getAllPatients();
 void updatePatient(Patient p);
 void deletePatient(int id);
}
