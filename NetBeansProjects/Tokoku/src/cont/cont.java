/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cont;
import java.sql.*;

/**
 *
 * @author eater48
 */
public class cont {
    public static final String JD = "org.apache.derby.jdbc.EmbeddedDriver";
    public static final String DB = "jdbc:derby://localhost:1527/Jtokoku;create=true";
    
    public Connection conn;
    public Statement stm;
    public ResultSet rs;
    
   public void reg_usr(String us,String pass, String name){
       try {
           Class.forName(JD);
           conn = DriverManager.getConnection(DB);
           stm = conn.createStatement();
           ED ed = new ED();
           
           String fpass = ed.inec(pass);
           String in = "INSERT INTO APP.user_toko VALUES ('"+us+"','"+fpass+"','"+name+"')";
           stm.executeUpdate(in);
           
           stm.close();
           conn.close();
       } catch (Exception e) {
           e.printStackTrace();
       }
   }   
}
