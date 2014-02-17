/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sqlsuite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Narendher
 */
public class EstablishConnection {
    static ResultSet executeQuery(String str)
    {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:odbc:MyPrjDSN",StaticData.userid,StaticData.password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(str);
            return(rs);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EstablishConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error:"+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
            System.out.println("ERROR:"+ex);
            return null;
        }
    }
    static int connec(String str)
    {
        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:odbc:MyPrjDSN",StaticData.userid,StaticData.password);
            Statement stmt = conn.createStatement();
            System.out.println(""+str);
            int x=stmt.executeUpdate(str);
            return x;
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Invalid Entry");
         return 0;
        }        catch (ClassNotFoundException ex) {
            Logger.getLogger(EstablishConnection.class.getName()).log(Level.SEVERE, null, ex);
         return 0;
        } 
       
    }

}
