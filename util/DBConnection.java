package com.pms.PatientManagementSystem.util;

import java.sql.*;


public class DBConnection {

	private static final String HOST = "jdbc:mysql://localhost:3306/";
    private static final String DB = "pms_db";
    private static final String USER = "root";
    private static final String PASS = "shourya123";

    private static void createDatabase() {
        try {
            Connection con = DriverManager.getConnection(HOST, USER, PASS);
            Statement st = con.createStatement();
            st.execute("CREATE DATABASE IF NOT EXISTS " + DB);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Step 2 – Get connection to that database
    public static Connection getConnection() {
        try {
            createDatabase();   // ensure DB exists
            return DriverManager.getConnection(HOST + DB, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public static void createTables() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();

            // PATIENT TABLE (from synopsis)
            String patientTable = "CREATE TABLE IF NOT EXISTS patients ("
                    + "patient_id INT PRIMARY KEY AUTO_INCREMENT, "
                    + "name VARCHAR(100), "
                    + "age VARCHAR(20), "
                    + "gender VARCHAR(20), "
                    + "contact VARCHAR(30), "
                    + "address VARCHAR(300))";

            // DOCTOR TABLE
            String doctorTable = "CREATE TABLE IF NOT EXISTS doctors ("
                    + "doctor_id INT PRIMARY KEY AUTO_INCREMENT, "
                    + "name VARCHAR(100), "
                    + "specialization VARCHAR(200), "
                    + "contact VARCHAR(30), "
                    + "fee INT)";

            // APPOINTMENT TABLE
            String appointmentTable = "CREATE TABLE IF NOT EXISTS appointments ("
                    + "appointment_id INT PRIMARY KEY AUTO_INCREMENT, "
                    + "patient_id INT, "
                    + "doctor_id INT, "
                    + "appointment_date DATE, "
                    + "appointment_time TIME, "
                    + "FOREIGN KEY(patient_id) REFERENCES patients(patient_id), "
                    + "FOREIGN KEY(doctor_id) REFERENCES doctors(doctor_id))";

            // BILLING TABLE
            String billingTable = "CREATE TABLE IF NOT EXISTS billing ("
                    + "bill_id INT PRIMARY KEY AUTO_INCREMENT, "
                    + "patient_id INT, "
                    + "doctor_fee VARCHAR(50), "
                    + "total_amount INT, "
                    + "FOREIGN KEY(patient_id) REFERENCES patients(patient_id))";

            st.execute(patientTable);
            st.execute(doctorTable);
            st.execute(appointmentTable);
            st.execute(billingTable);

            System.out.println("All tables created successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}
