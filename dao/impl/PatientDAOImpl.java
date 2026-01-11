package com.pms.PatientManagementSystem.dao.impl;
import com.pms.PatientManagementSystem.dao.PatientDAO;
import com.pms.PatientManagementSystem.model.Patient;
import com.pms.PatientManagementSystem.util.DBConnection;
import java.sql.*;
import java.util.*;

public class PatientDAOImpl implements PatientDAO {
 public void addPatient(Patient p){
  try{
   Connection c=DBConnection.getConnection();
   PreparedStatement ps=c.prepareStatement(
   "INSERT INTO patients(name,age,gender,contact,address) VALUES(?,?,?,?,?)");
   ps.setString(1,p.getName());
   ps.setString(2,p.getAge());
   ps.setString(3,p.getGender());
   ps.setString(4,p.getContact());
   ps.setString(5,p.getAddress());
   ps.executeUpdate();
  }catch(Exception e){e.printStackTrace();}
 }

 public List<Patient> getAllPatients(){
  List<Patient> list=new ArrayList<>();
  try{
   ResultSet rs=DBConnection.getConnection()
     .createStatement().executeQuery("SELECT * FROM patients");
   while(rs.next()){
    Patient p=new Patient();
    p.setPatientId(rs.getInt(1));
    p.setName(rs.getString(2));
    list.add(p);
   }
  }catch(Exception e){}
  return list;
 }
 
 public Patient getPatientById(int id) {
     try {
         String sql = "SELECT * FROM patients WHERE patient_id=?";
         PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
         ps.setInt(1, id);
         ResultSet rs = ps.executeQuery();

         if (rs.next()) {
             Patient p = new Patient();
             p.setPatientId(rs.getInt("patient_id"));
             p.setName(rs.getString("name"));
             p.setAge(rs.getString("age"));
             p.setGender(rs.getString("gender"));
             p.setContact(rs.getString("contact"));
             p.setAddress(rs.getString("address"));
             return p;
         }
     } catch (Exception e) { e.printStackTrace(); }
     return null;
 }

 
 public void updatePatient(Patient p) {
	    try {
	        String q="UPDATE patients SET name=?, age=?, contact=? WHERE patient_id=?";
	        PreparedStatement ps=DBConnection.getConnection().prepareStatement(q);
	        ps.setString(1,p.getName());
	        ps.setString(2,p.getAge());
	        ps.setString(3,p.getContact());
	        ps.setInt(4,p.getPatientId());
	        ps.executeUpdate();
	    }catch(Exception e){}
	}
 
 public void deletePatient(int id){
	    try{
	        PreparedStatement ps=DBConnection.getConnection()
	            .prepareStatement("DELETE FROM patients WHERE patient_id=?");
	        ps.setInt(1,id);
	        ps.executeUpdate();
	    }catch(Exception e){}
	}





}
