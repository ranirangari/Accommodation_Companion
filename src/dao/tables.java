
package dao;

import javax.swing.JOptionPane;

public class tables {
    public static void main(String[] args) {
        try{ 
        String userTable = "create table student(id int AUTO_INCREMENT primary key, name varchar(200), email varchar(200), mobileNumber varchar(10), address varchar(200), password varchar(200), securityQuestion varchar(200), answer varchar(200), status varchar(20), UNIQUE(email))";
        String adminDetails = "insert into student(name,email,mobileNumber,address,password,securityQuestion,answer,status) values('Admin','admin@gmail.com','1234567890','India','admin','What primary school did you attend?','ABC','true')";
        String categoryTable = "create table category(id int AUTO_INCREMENT primary key, name varchar(200))";
        String productTable = "create table product(id int AUTO_INCREMENT primary key, name varchar(200), category varchar(200), price varchar(200), address varchar(200), description varchar (200))";
            DbOperations.setDataOrDelete(userTable, "User Table Created Successfully ");
            DbOperations.setDataOrDelete(adminDetails, "Admin Details Added Successfully ");
            DbOperations.setDataOrDelete(categoryTable, "Category table created Successfully ");
            DbOperations.setDataOrDelete(productTable, "Product table created Successfully ");
        }catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        }
    }
}
