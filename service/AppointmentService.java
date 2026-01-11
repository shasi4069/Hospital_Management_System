package com.pms.PatientManagementSystem.service;
import com.pms.PatientManagementSystem.model.Appointment;
import java.util.List;

public interface AppointmentService {
    void bookAppointment(Appointment a);
    List<Appointment> getAppointments();
}
