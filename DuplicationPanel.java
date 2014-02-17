/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DuplicationPanel.java
 *
 * Created on Mar 8, 2012, 5:03:30 PM
 */
package sqlsuite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class DuplicationPanel extends javax.swing.JPanel {
    public JScrollPane jsp;
    public Connection conn;
    public Statement statement;
    public ResultSetMetaData rsmd;
    public String selectname;
    DefaultTableModel dtm=null;
    /** Creates new form DuplicationPanel */
    public DuplicationPanel() {
        initComponents();
     resultSetRetieve();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Cb_DuplicateTableSelection = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        Dup_Table = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jB_closeTab = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setLayout(null);

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 3, 36));
        jLabel4.setText("SQL SUITE FOR ORACLE");
        jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 51), new java.awt.Color(0, 0, 0), null, new java.awt.Color(0, 51, 51)));
        add(jLabel4);
        jLabel4.setBounds(260, 50, 486, 57);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 3, 15));
        jLabel1.setForeground(new java.awt.Color(102, 0, 102));
        jLabel1.setText("New Table Name:");
        add(jLabel1);
        jLabel1.setBounds(340, 220, 130, 17);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        add(jTextField1);
        jTextField1.setBounds(480, 220, 136, 20);

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 3, 15));
        jLabel2.setForeground(new java.awt.Color(102, 0, 102));
        jLabel2.setText("Existing Table Name:");
        add(jLabel2);
        jLabel2.setBounds(310, 250, 160, 17);

        Cb_DuplicateTableSelection.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Cb_DuplicateTableSelectionItemStateChanged(evt);
            }
        });
        Cb_DuplicateTableSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_DuplicateTableSelectionActionPerformed(evt);
            }
        });
        add(Cb_DuplicateTableSelection);
        Cb_DuplicateTableSelection.setBounds(480, 250, 142, 20);

        Dup_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Column Name", "Data Type", "Width", "Precision", "Constraint"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        jScrollPane1.setViewportView(Dup_Table);

        add(jScrollPane1);
        jScrollPane1.setBounds(230, 280, 583, 215);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12));
        jLabel3.setText("Note: Please Select the rows using ctrl key to create a duplicate table.");
        add(jLabel3);
        jLabel3.setBounds(310, 520, 390, 22);

        jButton1.setFont(new java.awt.Font("Dialog", 1, 14));
        jButton1.setForeground(new java.awt.Color(51, 51, 255));
        jButton1.setText("Create Table");
        jButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 0, 153)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(420, 550, 139, 52);

        jB_closeTab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sqlsuite/cross.jpg"))); // NOI18N
        jB_closeTab.setToolTipText("Close Tab");
        jB_closeTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_closeTabActionPerformed(evt);
            }
        });
        add(jB_closeTab);
        jB_closeTab.setBounds(870, 60, 30, 30);

        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(680, 220, 90, 23);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sqlsuite/powerpoint-curve-background.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        add(jLabel5);
        jLabel5.setBounds(0, 0, 1020, 690);
    }// </editor-fold>//GEN-END:initComponents

private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextField1ActionPerformed

private void Cb_DuplicateTableSelectionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Cb_DuplicateTableSelectionItemStateChanged
    int n=jScrollPane1.getComponentCount();
        for(int i=0;i<n;i++)
            for(int j=0;j<5;j++)
            ((DefaultTableModel)Dup_Table.getModel()).setValueAt("", i, j);
            //((DefaultTableModel)Dup_Table.getModel()).removeRow(i);
    String name=(String)evt.getItem();
    retriveDescriptionOfGivenTable(name);
}//GEN-LAST:event_Cb_DuplicateTableSelectionItemStateChanged

private void Cb_DuplicateTableSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_DuplicateTableSelectionActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_Cb_DuplicateTableSelectionActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int rowSelected[]=Dup_Table.getSelectedRows();
        if(rowSelected.length==0)
	{
		JOptionPane.showMessageDialog(null,"No Row Selected","ERROR",JOptionPane.ERROR_MESSAGE);
		return;
	}
        else
        {
            String qry="create table "+jTextField1.getText()+" as select ";
            for(int i=0;i<rowSelected.length;i++)
            {
                    qry+=""+Dup_Table.getValueAt(rowSelected[i],0)+",";
            }
            qry=qry.substring(0,qry.length()-1);
            qry+=" from "+Cb_DuplicateTableSelection.getSelectedItem();
            try
            {
                    int confirm=statement.executeUpdate(qry);
                    if(confirm ==0)
                            JOptionPane.showMessageDialog(null,"Table Not Created","ERROR",JOptionPane.WARNING_MESSAGE);
                    else
                            JOptionPane.showMessageDialog(null,"Table Created \n"+"QUERY:"+qry,"QUERY INFORMATION",JOptionPane.INFORMATION_MESSAGE);
            }
            catch(Exception e)
            {
                    JOptionPane.showMessageDialog(null,"ERROR :"+e,"ERROR",JOptionPane.ERROR_MESSAGE);
                    return;
            }
           // JOptionPane.showMessageDialog(null, " Query:" +qry);
            //dispose();
            //new MenuWindowFrame().setVisible(true);
            MainWindowClass.jTabbedPane_view.remove(MainWindowClass.tabdup);
            MainWindowClass.jTabbedPane_view.add(new DuplicationPanel(),MainWindowClass.tabdup);
            MainWindowClass.jTabbedPane_view.setTitleAt(MainWindowClass.tabdup,"Duplication");
            MainWindowClass.jTabbedPane_view.setSelectedIndex(MainWindowClass.tabdup);
        }
}

    private void retriveDescriptionOfGivenTable(String name) {
        try {
            String qry = "select * from "+name;
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conn=DriverManager.getConnection("jdbc:odbc:MyPrjDSN",StaticData.userid,StaticData.password);
            Statement stmt=conn.createStatement();
            ResultSet resultset = stmt.executeQuery(qry);
            rsmd = resultset.getMetaData();
            int columnCount = rsmd.getColumnCount();
            //Dup_Table.addRowSelectionInterval(0,columnCount);
            for (int i = 0; i < columnCount; i++) {
                Dup_Table.setValueAt(rsmd.getColumnName(i + 1), i, 0);
                Dup_Table.setValueAt(rsmd.getColumnTypeName(i + 1), i, 1);
                if ((""+rsmd.getColumnTypeName(i + 1)).equals("number")) {
                    Dup_Table.setValueAt(""+(rsmd.getColumnDisplaySize(i + 1) - 2), i, 2);
                } else {
                    Dup_Table.setValueAt(""+rsmd.getColumnDisplaySize(i + 1), i, 2);
                }
                Dup_Table.setValueAt(""+rsmd.getScale(i + 1), i, 3);
                if ((""+rsmd.isNullable(i + 1)).equals("1")) {
                    Dup_Table.setValueAt("NULL", i, 4);
                } else {
                    Dup_Table.setValueAt("NOT NULL", i, 4);
                }
            }
        } catch (Exception ex) {
                        System.out.println("Exception in retriveDescriptionOfGivenTable:"+ex);
        }
}//GEN-LAST:event_jButton1ActionPerformed

private void jB_closeTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_closeTabActionPerformed
int confirm=JOptionPane.showConfirmDialog(null,"Are you sure to close this tab?","QUIT",JOptionPane.YES_NO_OPTION);
//int confirm=JOptionPane.showConfirmDialog(null, "Error is here", "Error", YES, WIDTH)       
if(confirm==0)
         {
                MainWindowClass.jTabbedPane_view.remove(MainWindowClass.tabdup);
                MainWindowClass.dup="close";
                //MainWindowClass.jTabbedPane_view.
                MyUtilities.closeTab(MainWindowClass.tabdup);
         }
}//GEN-LAST:event_jB_closeTabActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            // TODO add your handling code here:
            Cb_DuplicateTableSelection.removeAllItems();
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                        conn = DriverManager.getConnection("jdbc:odbc:MyPrjDSN",StaticData.userid,StaticData.password);
                        statement = conn.createStatement();
                        ResultSet rs = statement.executeQuery("select * from tab");
                        while(rs.next())
                        {
                            String value=rs.getString("TNAME");
                            System.out.println("TName:"+value);
                            Cb_DuplicateTableSelection.addItem((Object)value);
                        }
                       rs.close();
            //        MainWindowClass.jTabbedPane_view.remove(MainWindowClass.tabdesc);
            //        MainWindowClass.jTabbedPane_view.add(new DescriptionPanel(),MainWindowClass.tabdesc);
            //        MainWindowClass.jTabbedPane_view.setSelectedIndex(MainWindowClass.tabdesc);
            //        MainWindowClass.jTabbedPane_view.setSelectedIndex(MainWindowClass.tabdesc);
        } catch (SQLException ex) {
            Logger.getLogger(DuplicationPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DuplicationPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Cb_DuplicateTableSelection;
    private javax.swing.JTable Dup_Table;
    private javax.swing.JButton jB_closeTab;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void resultSetRetieve() {
        try {
            //((DefaultTableModel)Dup_Table.getModel()).setRowCount(1000);
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection("jdbc:odbc:MyPrjDSN",StaticData.userid,StaticData.password);
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from tab");
            while(rs.next())
            {
                String value=rs.getString("TNAME");
                System.out.println("TName:"+value);
                Cb_DuplicateTableSelection.addItem((Object)value);
            }
           rs.close();
        } catch (Exception ex) {
            System.out.println("Exception in Duplication of Table:"+ex);
        }
        String name=(String)Cb_DuplicateTableSelection.getSelectedItem();
        retriveDescriptionOfGivenTable(name);
    }
}
