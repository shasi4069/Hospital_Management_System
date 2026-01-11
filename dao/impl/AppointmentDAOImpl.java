package com.pms.PatientManagementSystem.dao.impl;

import com.pms.PatientManagementSystem.dao.AppointmentDAO;
import com.pms.PatientManagementSystem.model.Appointment;
import com.pms.PatientManagementSystem.util.DBConnection;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class AppointmentDAOImpl implements AppointmentDAO {

    public void bookAppointment(Appointment a) {
        try {
            String sql = "INSERT INTO appointments(patient_id,doctor_id,appointment_date,appointment_time) VALUES(?,?,?,?)";
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setInt(1, a.getPatientId());
            ps.setInt(2, a.getDoctorId());
            ps.setDate(3, a.getAppointmentDate());
            ps.setTime(4, a.getAppointmentTime());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
        if (!isSlotAvailable(a.getDoctorId(), a.getAppointmentDate(), a.getAppointmentTime())) {
            System.out.println("Doctor already booked for this slot!");
            return;
        }

    }

    public List<Appointment> getAllAppointments() {
        List<Appointment> list = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getConnection()
                    .createStatement().executeQuery("SELECT * FROM appointments");
            while (rs.next()) {
                Appointment a = new Appointment();
                a.setAppointmentId(rs.getInt(1));
                a.setPatientId(rs.getInt(2));
                a.setDoctorId(rs.getInt(3));
                a.setAppointmentDate(rs.getDate(4));
                a.setAppointmentTime(rs.getTime(5));
                list.add(a);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
    
    public boolean isSlotAvailable(int doctorId, Date date, Time time) {
        try {
            String sql = "SELECT * FROM appointments WHERE doctor_id=? AND appointment_date=? AND appointment_time=?";
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setInt(1, doctorId);
            ps.setDate(2, date);
            ps.setTime(3, time);
            ResultSet rs = ps.executeQuery();
            return !rs.next();   // if record found → slot NOT available
        } catch (Exception e) { e.printStackTrace(); }
        return false;
    }

}
