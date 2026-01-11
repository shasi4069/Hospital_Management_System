package com.pms.PatientManagementSystem.service.impl;
import com.pms.PatientManagementSystem.dao.impl.DoctorDAOImpl;
import com.pms.PatientManagementSystem.model.Doctor;
import com.pms.PatientManagementSystem.service.DoctorService;
import java.util.List;

public class DoctorServiceImpl implements DoctorService {
    DoctorDAOImpl dao = new DoctorDAOImpl();

    public void addDoctor(Doctor d) {
        dao.addDoctor(d);
    }

    public List<Doctor> getDoctors() {
        return dao.getAllDoctors();
    }
}
