package com.pms.PatientManagementSystem.model;

public class Billing {
    private int billId;
    private int patientId;
    private String doctorFee;
    private int totalAmount;
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getDoctorFee() {
		return doctorFee;
	}
	public void setDoctorFee(String doctorFee) {
		this.doctorFee = doctorFee;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "Billing [billId=" + billId + ", patientId=" + patientId + ", doctorFee=" + doctorFee + ", totalAmount="
				+ totalAmount + ", getBillId()=" + getBillId() + ", getPatientId()=" + getPatientId()
				+ ", getDoctorFee()=" + getDoctorFee() + ", getTotalAmount()=" + getTotalAmount() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
