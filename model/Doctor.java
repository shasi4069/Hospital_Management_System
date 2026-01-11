package com.pms.PatientManagementSystem.model;

public class Doctor {
    private int doctorId;
    private String name;
    private String specialization;
    private String contact;
    private int fee;
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", name=" + name + ", specialization=" + specialization + ", contact="
				+ contact + ", fee=" + fee + ", getDoctorId()=" + getDoctorId() + ", getName()=" + getName()
				+ ", getSpecialization()=" + getSpecialization() + ", getContact()=" + getContact() + ", getFee()="
				+ getFee() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

  
    
}
