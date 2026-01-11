package com.pms.PatientManagementSystem.service;
import com.pms.PatientManagementSystem.model.Doctor;
import java.util.List;

public interface DoctorService {
    void addDoctor(Doctor d);
    List<Doctor> getDoctors();
}
