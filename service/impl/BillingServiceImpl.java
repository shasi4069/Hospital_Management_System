package com.pms.PatientManagementSystem.service.impl;

import com.pms.PatientManagementSystem.dao.BillingDAO;
import com.pms.PatientManagementSystem.dao.impl.BillingDAOImpl;
import com.pms.PatientManagementSystem.model.Billing;
import com.pms.PatientManagementSystem.service.BillingService;
import com.pms.PatientManagementSystem.util.DBConnection;

import java.sql.*;
import java.util.List;

public class BillingServiceImpl implements BillingService {

    BillingDAO dao = new BillingDAOImpl();

    // 🔥 Auto generate bill using Doctor Fee
    public void generateBillAuto(int patientId, int doctorId) {
        try {
            String sql = "SELECT fee FROM doctors WHERE doctor_id=?";
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setInt(1, doctorId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int fee = rs.getInt("fee");

                Billing b = new Billing();
                b.setPatientId(patientId);
                b.setDoctorFee(String.valueOf(fee));
                b.setTotalAmount(fee);

                dao.saveBill(b);
                System.out.println("Bill Generated Successfully. Amount = " + fee);
            } else {
                System.out.println("Doctor not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Billing> getBills() {
        return dao.getAllBills();
    }
}
