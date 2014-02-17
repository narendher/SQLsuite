/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UserCreationFrame.java
 *
 * Created on Dec 6, 2011, 11:51:42 PM
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
 * @author Narendher
 */
public class UserCreationFrame extends javax.swing.JFrame {
    private Connection conn;
    private Statement st;
    /** Creates new form UserCreationFrame */
    public UserCreationFrame() {
        initComponents();
        setLocationRelativeTo(null);
        resultSetRetrieve();
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
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("User Creation");
        setMinimumSize(new java.awt.Dimension(689, 447));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel1.setText("UserName:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(169, 83, 115, 31);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(312, 89, 165, 20);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel2.setText("Password:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(169, 133, 61, 17);
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(312, 132, 165, 20);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel3.setText("Confirm Password:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(169, 171, 139, 17);
        getContentPane().add(jPasswordField2);
        jPasswordField2.setBounds(312, 170, 165, 20);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jButton1.setText("Create");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(63, 346, 119, 40);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel4.setText("Privileges:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(169, 207, 75, 17);

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "select", "update", "alter", "delete", "insert", "create", "grant", " ", " " };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(312, 207, 119, 139);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel5.setText("On");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(457, 207, 32, 26);

        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(493, 211, 130, 20);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sqlsuite/powerpoint-curve-background.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 680, 430);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection("jdbc:odbc:MyPrjDSN", "system", "oracle");
            st = conn.createStatement();
            if((jPasswordField1.getText()).compareTo(jPasswordField2.getText())!=0)
            {
                JOptionPane.showMessageDialog(null,"The passwords you typed do not match.Please retype the new password in both boxes" );
				jPasswordField1.setText("");
				jPasswordField2.setText("");
            }
            else
            {
                if(!jComboBox1.getSelectedItem().equals(" "))
                {
                    if(jList1.getSelectedIndices().length!=0)
                    {
                        String query="create user "+jTextField1.getText()+" identified by "+jPasswordField1.getText();
                        EstablishConnection.connec(query);
                        //StaticData.userid=jTextField1.getText();
                        //StaticData.password=jPasswordField1.getText();
                        int selections[] = jList1.getSelectedIndices();
                        Object selectedValues[] =jList1.getSelectedValues();
                        String query2="grant ";
                        for (int x = 0, n = selections.length; x < n; x++) 
                        {
                                query2+=selectedValues[x]+",";
                        }
                        query2=query2.substring(0,query2.length()-1);
                        query2+=" on "+jComboBox1.getSelectedItem();
                        query2+=" to "+jTextField1.getText()+";";
                        System.out.println(query2);
                        EstablishConnection.connec(query2);
                        JOptionPane.showMessageDialog(null, "User "+jTextField1.getText()+" created successfully");
                        dispose();
                        JFrame MenuWindowFrame=new MenuWindowFrame();

                        MenuWindowFrame.setVisible(true);
                      }
                      else
                      {
                        JOptionPane.showMessageDialog(null,"Please select atleast onc Privilege");
                      }
                    }
                else
                {
                   JOptionPane.showMessageDialog(null,"Please select the table"); 
                }
              }
        } catch (SQLException ex) {
            Logger.getLogger(UserCreationFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserCreationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int confirm=JOptionPane.showConfirmDialog(null,"Are you sure to QUIT?","Message",JOptionPane.YES_NO_OPTION);
 if(confirm==0)
    {
        new MenuWindowFrame().setVisible(true);
        dispose();
 return;
 }
 else
     return;
    }//GEN-LAST:event_formWindowClosing
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UserCreationFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList jList1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    public void resultSetRetrieve() {
     try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conn=DriverManager.getConnection("jdbc:odbc:MyPrjDSN",StaticData.userid,StaticData.password);
            Statement stmt=conn.createStatement();
            ResultSet resultSet=stmt.executeQuery("select * from tab");
            jComboBox1.addItem(" ");
            while(resultSet.next())
            {
                String value=resultSet.getString("TNAME");
                System.out.println("TName:"+value);
               jComboBox1.addItem((Object)value);
            }
            resultSet.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception: "+e);
        }   
    }
}