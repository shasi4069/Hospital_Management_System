package com.pms.PatientManagementSystem.dao.impl;

import com.pms.PatientManagementSystem.dao.DoctorDAO;
import com.pms.PatientManagementSystem.model.Doctor;
import com.pms.PatientManagementSystem.util.DBConnection;
import java.sql.*;
import java.util.*;

public class DoctorDAOImpl implements DoctorDAO {

    public void addDoctor(Doctor d) {
        try {
            String sql = "INSERT INTO doctors(name,specialization,contact,fee) VALUES(?,?,?,?)";
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setString(1, d.getName());
            ps.setString(2, d.getSpecialization());
            ps.setString(3, d.getContact());
            ps.setInt(4, d.getFee());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public List<Doctor> getAllDoctors() {
        List<Doctor> list = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getConnection()
                    .createStatement().executeQuery("SELECT * FROM doctors");
            while (rs.next()) {
                Doctor d = new Doctor();
                d.setDoctorId(rs.getInt(1));
                d.setName(rs.getString(2));
                d.setSpecialization(rs.getString(3));
                d.setContact(rs.getString(4));
                d.setFee(rs.getInt(5));
                list.add(d);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
}
