package com.pms.PatientManagementSystem.dao;
import com.pms.PatientManagementSystem.model.Billing;
import java.util.List;

public interface BillingDAO {
    void generateBill(Billing b);
    List<Billing> getAllBills();
	void saveBill(Billing b);
}
