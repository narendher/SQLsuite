/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PractisingPanel.java
 *
 * Created on Mar 23, 2012, 7:10:14 PM
 */
package sqlsuite;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class PractisingPanel extends javax.swing.JPanel {
    private ResultSetMetaData rsmd;
    public int table=0;
    /** Creates new form PractisingPanel */
    public PractisingPanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setLayout(null);

        jTextField1.setFont(new java.awt.Font("Comic Sans MS", 2, 18));
        add(jTextField1);
        jTextField1.setBounds(390, 330, 576, 29);

        jLabel1.setFont(new java.awt.Font("Brush Script MT", 2, 24));
        jLabel1.setText("COMMAND:");
        add(jLabel1);
        jLabel1.setBounds(240, 330, 122, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1);
        jScrollPane1.setBounds(240, 410, 734, 216);

        jButton1.setFont(new java.awt.Font("Comic Sans MS", 2, 18));
        jButton1.setText("Execute");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(520, 370, 112, 40);

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        add(jScrollPane2);
        jScrollPane2.setBounds(230, 70, 734, 255);

        jButton2.setText("Create Syntax");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(28, 19, 146, 48);

        jButton3.setText("Insert Syntax");
        add(jButton3);
        jButton3.setBounds(28, 105, 146, 46);

        jButton4.setText("Delete Syntax");
        add(jButton4);
        jButton4.setBounds(28, 181, 146, 51);

        jButton5.setText("Select Syntax");
        add(jButton5);
        jButton5.setBounds(28, 260, 146, 50);

        jButton6.setText("Alter Syntax");
        add(jButton6);
        jButton6.setBounds(28, 349, 146, 48);

        jButton7.setText("Update syntax");
        add(jButton7);
        jButton7.setBounds(28, 438, 146, 47);

        jButton8.setText("Drop Syntax");
        add(jButton8);
        jButton8.setBounds(28, 521, 146, 48);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sqlsuite/cross.jpg"))); // NOI18N
        jButton9.setToolTipText("Close Tab");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        add(jButton9);
        jButton9.setBounds(890, 20, 30, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sqlsuite/powerpoint-curve-background.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        add(jLabel2);
        jLabel2.setBounds(10, 0, 980, 630);
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try
        {
            ((DefaultTableModel)jTable1.getModel()).setColumnCount(0);
            ((DefaultTableModel)jTable1.getModel()).setRowCount(0);
            String qry = jTextField1.getText();
            ResultSet rs=EstablishConnection.executeQuery(qry);
            rsmd =rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            int rowcount=0;
            for(int i=1,t=0;i<=columnCount;i++,t++)
            {
                    //StaticData.columntype[t]=rsmd.getColumnTypeName(i);
                    //System.out.println(StaticData.columntype[i]);
                    String value=rsmd.getColumnName(i);
                    if(rsmd.getColumnTypeName(i).equals("DECIMAL"))
                    {
                        value+="(Number)";
                    }
                    else
                    {
                        value+="(String)";
                    }
                    ((DefaultTableModel)jTable1.getModel()).addColumn(value);
//                        if(rsmd.getColumnTypeName(i).equals("DECIMAL"))
//                        {
//                            ((DefaultTableModel)jTable1.getModel()).
//                        }
                    //((DefaultTableModel)jTable1.getModel()).
            }           
            String data[]=new String[columnCount];
            while(rs.next())
            { 
               for(int i=1,t=0;i<=columnCount;i++,t++)
               {
                      data[t]=rs.getString(i);
                      System.out.println("zxdf:"+data[t]);                     
               }                   
               rowcount++;
               ((DefaultTableModel)jTable1.getModel()).addRow((Object[])data);
            }
            table=1;
        } catch (SQLException ex) {
            Logger.getLogger(PractisingPanel.class.getName()).log(Level.SEVERE, null, ex);
        }   
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
    jTextArea1.setText("sdjkfhdjksg;");
}//GEN-LAST:event_jButton2ActionPerformed

private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
// TODO add your handling code here:
 int confirm=JOptionPane.showConfirmDialog(null,"Are you sure to close this tab?","Message",JOptionPane.YES_NO_OPTION);
//int confirm=JOptionPane.showConfirmDialog(null, "Error is here", "Error", YES, WIDTH)       
if(confirm==0)
         {
                MainWindowClass.jTabbedPane_view.remove(MainWindowClass.tabins);
                MainWindowClass.pr="close";
                //MainWindowClass.jTabbedPane_view.
                MyUtilities.closeTab(MainWindowClass.tabpr);
         }

}//GEN-LAST:event_jButton9ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
