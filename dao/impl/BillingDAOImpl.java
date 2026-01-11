package com.pms.PatientManagementSystem.dao.impl;

import com.pms.PatientManagementSystem.dao.BillingDAO;
import com.pms.PatientManagementSystem.model.Billing;
import com.pms.PatientManagementSystem.util.DBConnection;

import java.sql.*;
import java.util.*;

public class BillingDAOImpl implements BillingDAO {

    public void saveBill(Billing b) {
        try {
            String sql = "INSERT INTO billing(patient_id,doctor_fee,total_amount) VALUES(?,?,?)";
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setInt(1, b.getPatientId());
            ps.setInt(2, Integer.parseInt(b.getDoctorFee()));
            ps.setInt(3, b.getTotalAmount());
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public List<Billing> getAllBills() {
        List<Billing> list = new ArrayList<>();
        try {
            ResultSet rs = DBConnection.getConnection()
                    .createStatement().executeQuery("SELECT * FROM billing");

            while (rs.next()) {
                Billing b = new Billing();
                b.setBillId(rs.getInt("bill_id"));
                b.setPatientId(rs.getInt("patient_id"));
                b.setDoctorFee(rs.getString("doctor_fee"));
                b.setTotalAmount(rs.getInt("total_amount"));
                list.add(b);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

	@Override
	public void generateBill(Billing b) {
		// TODO Auto-generated method stub
		
	}
}
