package com.pms.PatientManagementSystem.dao;
import com.pms.PatientManagementSystem.model.Doctor;
import java.util.List;

public interface DoctorDAO {
    void addDoctor(Doctor d);
    List<Doctor> getAllDoctors();
}
