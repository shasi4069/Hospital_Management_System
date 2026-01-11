package com.pms.PatientManagementSystem.service.impl;
import com.pms.PatientManagementSystem.dao.impl.AppointmentDAOImpl;
import com.pms.PatientManagementSystem.model.Appointment;
import com.pms.PatientManagementSystem.service.AppointmentService;
import java.util.List;

public class AppointmentServiceImpl implements AppointmentService {
    AppointmentDAOImpl dao = new AppointmentDAOImpl();

    public void bookAppointment(Appointment a) {
        dao.bookAppointment(a);
    }

    public List<Appointment> getAppointments() {
        return dao.getAllAppointments();
    }

	public boolean bookAppointmentWithCheck(Appointment a) {
		// TODO Auto-generated method stub
		return false;
	}
}
