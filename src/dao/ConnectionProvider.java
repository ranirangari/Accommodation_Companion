
package dao;
import java.sql.*;
public class ConnectionProvider {
    public static Connection getCon(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accomodation", "root", "1999");
        return con;
        }catch(Exception e){
        return null;
        
        }
    }
}
