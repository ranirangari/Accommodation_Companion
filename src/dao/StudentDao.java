package dao;

import entity.Student;
import javax.swing.JOptionPane;
import java.sql.*;

public class StudentDao {

    public static void save(Student student) {
        String query = "insert into student(name,email,mobileNumber,address,password,securityQuestion,answer,status)"
                + " values('" + student.getName() + "','" + student.getEmail() + "','" + student.getMobileNumber()
                + "','" + student.getAddress() + "','" + student.getPassword() + "','" + student.getSecurityQuestion()
                + "','" + student.getAnswer() + "','false')";
        DbOperations.setDataOrDelete(query, "Registered Successfully! ");
    }

    public static Student login(String email, String password) {
        Student student = null;
        try {
            ResultSet rs = DbOperations.getData("select * from student where email='" + email + "' and password='" + password + "'");
            while (rs.next()) {
                student = new Student();
                student.setStatus(rs.getString("status"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return student;
    }

    public static Student getSecurityQuestion(String email) {
        Student student = null;
        try {
            ResultSet rs = DbOperations.getData("select * from student where email = '" + email + "'");
            while (rs.next()) {
                student = new Student();
                student.setSecurityQuestion(rs.getString("securityQuestion"));
                student.setAnswer(rs.getString("answer"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return student;
    }

    public static void update(String email, String newPassword) {
        String query = "update student set password = '" + newPassword + "' where email = '" + email + "'";
        DbOperations.setDataOrDelete(query, "Password changed successfully");
    }
}
