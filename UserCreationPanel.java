/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UserCreationPanel.java
 *
 * Created on Mar 8, 2012, 5:51:51 PM
 */
package sqlsuite;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Administrator
 */
public class UserCreationPanel extends javax.swing.JPanel {
 private Connection conn;
    private Statement st;
    /** Creates new form UserCreationPanel */
    public UserCreationPanel() {
        initComponents();
     //   resultSetRetrieve();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        jButton_create = new javax.swing.JButton();
        jB_closeTab = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel1.setText("UserName:");
        add(jLabel1);
        jLabel1.setBounds(280, 190, 115, 31);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        add(jTextField1);
        jTextField1.setBounds(420, 200, 165, 20);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel2.setText("Password:");
        add(jLabel2);
        jLabel2.setBounds(280, 240, 61, 17);
        add(jPasswordField1);
        jPasswordField1.setBounds(420, 240, 165, 20);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel3.setText("Confirm Password:");
        add(jLabel3);
        jLabel3.setBounds(280, 280, 139, 17);
        add(jPasswordField2);
        jPasswordField2.setBounds(420, 280, 165, 20);

        jButton_create.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jButton_create.setText("Create");
        jButton_create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_createActionPerformed(evt);
            }
        });
        add(jButton_create);
        jButton_create.setBounds(410, 350, 119, 40);

        jB_closeTab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sqlsuite/cross.jpg"))); // NOI18N
        jB_closeTab.setToolTipText("Close Tab");
        jB_closeTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_closeTabActionPerformed(evt);
            }
        });
        add(jB_closeTab);
        jB_closeTab.setBounds(850, 50, 40, 40);

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("SQL SUITE FOR ORACLE");
        add(jLabel4);
        jLabel4.setBounds(340, 60, 250, 40);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sqlsuite/powerpoint-curve-background.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        add(jLabel6);
        jLabel6.setBounds(0, 0, 970, 650);
    }// </editor-fold>//GEN-END:initComponents

private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextField1ActionPerformed

private void jButton_createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_createActionPerformed
        try {
            // TODO add your handling code here:
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection("jdbc:odbc:MyPrjDSN", "system", "oracle");
            st = conn.createStatement();
            if(jTextField1.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter User Name");
                jTextField1.requestFocus();
            }
            else
            {
            if(jPasswordField1.getText().equals("")||jPasswordField2.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please enter passwords","ERROR",JOptionPane.WARNING_MESSAGE);
            }
            else
            {
            if((jPasswordField1.getText()).compareTo(jPasswordField2.getText())!=0)
            {
                JOptionPane.showMessageDialog(null,"The passwords you typed do not match.Please retype the new password in both boxes","ERROR",JOptionPane.WARNING_MESSAGE);
				jPasswordField1.setText("");
				jPasswordField2.setText("");
            }
            else
            {
//                if(!jComboBox1.getSelectedItem().equals(" "))
//                {
//                    if(jList1.getSelectedIndices().length!=0)
//                    {
                        String query="create user "+jTextField1.getText()+" identified by "+jPasswordField1.getText()+";";
                        EstablishConnection.connec(query);
                        //StaticData.userid=jTextField1.getText();
                        //StaticData.password=jPasswordField1.getText();
//                        int selections[] = jList1.getSelectedIndices();
//                        Object selectedValues[] =jList1.getSelectedValues();
                        String query2="grant connect,resource to "+jTextField1.getText()+";";
                        EstablishConnection.connec(query2);
                        String query3="grant all privileges to "+jTextField1.getText()+";";
//                        for (int x = 0, n = selections.length; x < n; x++) 
//                        {
//                                query2+=selectedValues[x]+",";
//                        }
//                        query2=query2.substring(0,query2.length()-1);
//                        query2+=" on "+jComboBox1.getSelectedItem();
//                        query2+=" to "+jTextField1.getText()+";";
//                        System.out.println(query2);
                        EstablishConnection.connec(query3);
                       // String str="insert into project_users values("+jTextField1.getText()+");";
                       // EstablishConnection.connec(str);
                        JOptionPane.showMessageDialog(null, "User "+jTextField1.getText()+" created successfully \n \n QUERY :"+query,"Query Information",JOptionPane.INFORMATION_MESSAGE);
                        //dispose();
                       // JFrame MenuWindowFrame=new MenuWindowFrame();
                        //MenuWindowFrame.setVisible(true);
                        MainWindowClass.jTabbedPane_view.remove(MainWindowClass.tabcu);
                        MainWindowClass.jTabbedPane_view.add(new UserCreationPanel(),MainWindowClass.tabcu);
                        MainWindowClass.jTabbedPane_view.setTitleAt(MainWindowClass.tabcu,"CreateUser");
                        MainWindowClass.jTabbedPane_view.setSelectedIndex(MainWindowClass.tabcu);
                      }
//                      else
//                      {
//                        JOptionPane.showMessageDialog(null,"Please select atleast onc Privilege","ERROR",JOptionPane.ERROR_MESSAGE);
//                      }
//                    }
//                else
//                {
//                   JOptionPane.showMessageDialog(null,"Please select the table","Message",JOptionPane.INFORMATION_MESSAGE); 
//                }
//              }
            }
        }
        } catch (SQLException ex) {
            Logger.getLogger(UserCreationFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserCreationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_jButton_createActionPerformed

private void jB_closeTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_closeTabActionPerformed
int confirm=JOptionPane.showConfirmDialog(null,"Are you sure to close this tab?","Message",JOptionPane.YES_NO_OPTION);
//int confirm=JOptionPane.showConfirmDialog(null, "Error is here", "Error", YES, WIDTH)       
if(confirm==0)
         {
                MainWindowClass.jTabbedPane_view.remove(MainWindowClass.tabcu);
                MainWindowClass.cu="close";
                //MainWindowClass.jTabbedPane_view.
                MyUtilities.closeTab(MainWindowClass.tabcu);
         }
}//GEN-LAST:event_jB_closeTabActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_closeTab;
    private javax.swing.JButton jButton_create;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
//
//    private void resultSetRetrieve() {
//        try{
//            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//            Connection conn=DriverManager.getConnection("jdbc:odbc:MyPrjDSN",StaticData.userid,StaticData.password);
//            Statement stmt=conn.createStatement();
//            ResultSet resultSet=stmt.executeQuery("select * from tab");
//            jComboBox1.addItem(" ");
//            while(resultSet.next())
//            {
//                String value=resultSet.getString("TNAME");
//                System.out.println("TName:"+value);
//               jComboBox1.addItem((Object)value);
//            }
//            resultSet.close();
//        }
//        catch(Exception e)
//        {
//            System.out.println("Exception: "+e);
//        }
//    }
}
