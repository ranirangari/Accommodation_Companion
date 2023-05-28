
package dao;
import entity.Product;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.*;
public class ProductDao {
    public static void save(Product product){
        String query = "insert into product(name,category,price, address, description)"
                + " values('"+product.getName()+"','"+product.getCategory()+"','"+product.getPrice()+"'"
                + ",'"+product.getAddress()+"',"
                + "'"+product.getDescription()+"')";
        DbOperations.setDataOrDelete(query, "Product Added Successfully");
    
    }
    public static ArrayList<Product> getAllRecords(){
        ArrayList<Product> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select * from product");
            while(rs.next()){
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getString("price"));
                product.setAddress(rs.getString("address"));
                product.setDescription(rs.getString("description"));
                arrayList.add(product);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        return arrayList;
    }
    
    public static void update(Product product){
        String query = "update product set name = '"+product.getName()+"', category='"+product.getCategory()+"',price='"+product.getPrice()+"', address='"+product.getAddress()+"', description= '"+product.getDescription()+"'where id = '"+product.getId()+"' ";
        DbOperations.setDataOrDelete(query, "Product updated successfully");
    }
    
    public static void delete(String id){
    String query = "delete from product where id = '"+id+"'";
    DbOperations.setDataOrDelete(query, "Product deleted successfully");
    }
}
