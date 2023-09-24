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
    public static final String DB = "jdbc:derby://localhost:1527/gover;create=true";
    
    Connection con;
    Statement stm;
    ResultSet rs;
    
    
    
}
