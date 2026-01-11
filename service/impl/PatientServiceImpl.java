package com.pms.PatientManagementSystem.service.impl;
import com.pms.PatientManagementSystem.dao.impl.PatientDAOImpl;
import com.pms.PatientManagementSystem.model.Patient;
import com.pms.PatientManagementSystem.service.PatientService;
import java.util.List;

public class PatientServiceImpl implements PatientService {
 PatientDAOImpl dao=new PatientDAOImpl();
 public void registerPatient(Patient p){ dao.addPatient(p);}
 public List<Patient> getPatients(){ return dao.getAllPatients();}
 public Patient searchPatient(int id) {
     return dao.getPatientById(id);
 }

 public void updatePatient(Patient p) {
     dao.updatePatient(p);
 }

 public void deletePatient(int id) {
     dao.deletePatient(id);
 }


}
