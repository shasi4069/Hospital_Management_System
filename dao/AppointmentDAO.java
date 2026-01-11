package com.pms.PatientManagementSystem.dao;
import com.pms.PatientManagementSystem.model.Appointment;
import java.util.List;

public interface AppointmentDAO {
    void bookAppointment(Appointment a);
    List<Appointment> getAllAppointments();
}
