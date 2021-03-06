/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DescriptionPanel.java
 *
 * Created on Mar 8, 2012, 4:52:27 PM
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
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Administrator
 */
public class DescriptionPanel extends javax.swing.JPanel {
 public ResultSetMetaData rsmd;
    public Connection conn;
    public Statement st;    
    DefaultTableModel dtm=null;
    public int rowct;
    public int check1=0;
    /** Creates new form DescriptionPanel */
    public DescriptionPanel() {
        initComponents();
        Desc_Table.setEnabled(true);
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

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jCB_Desc = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        Desc_Table = new javax.swing.JTable();
        jButton_Delete = new javax.swing.JButton();
        jButton3_addColumn = new javax.swing.JButton();
        jButton_save = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jB_closeTab = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(51, 0, 204)));
        setMinimumSize(new java.awt.Dimension(800, 800));
        setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("Description  of a Table");
        add(jLabel2);
        jLabel2.setBounds(350, 100, 200, 38);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("TABLE NAME:");
        add(jLabel1);
        jLabel1.setBounds(320, 140, 100, 37);

        jCB_Desc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCB_DescItemStateChanged(evt);
            }
        });
        jCB_Desc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_DescActionPerformed(evt);
            }
        });
        add(jCB_Desc);
        jCB_Desc.setBounds(430, 150, 127, 20);

        Desc_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ColumnName", "DataType", "Width", "Precision", "Constraint"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int row, int column){
                if(row <StaticData.noOfRows) return false;
                return true;}
        });
        Desc_Table.setEditingColumn(0);
        Desc_Table.setEditingRow(0);
        Desc_Table.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                Desc_TableComponentAdded(evt);
            }
        });
        jScrollPane1.setViewportView(Desc_Table);

        add(jScrollPane1);
        jScrollPane1.setBounds(210, 200, 534, 260);

        jButton_Delete.setFont(new java.awt.Font("Dialog", 1, 12));
        jButton_Delete.setForeground(new java.awt.Color(0, 0, 204));
        jButton_Delete.setText("Delete Column");
        jButton_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteActionPerformed(evt);
            }
        });
        add(jButton_Delete);
        jButton_Delete.setBounds(260, 510, 120, 35);

        jButton3_addColumn.setFont(new java.awt.Font("Trebuchet MS", 1, 14));
        jButton3_addColumn.setForeground(new java.awt.Color(0, 0, 204));
        jButton3_addColumn.setText("Add column");
        jButton3_addColumn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3_addColumnActionPerformed(evt);
            }
        });
        add(jButton3_addColumn);
        jButton3_addColumn.setBounds(410, 510, 110, 35);

        jButton_save.setFont(new java.awt.Font("Trebuchet MS", 1, 14));
        jButton_save.setForeground(new java.awt.Color(0, 0, 153));
        jButton_save.setText("Save Changes");
        jButton_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_saveActionPerformed(evt);
            }
        });
        add(jButton_save);
        jButton_save.setBounds(550, 510, 130, 34);

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 3, 24));
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("SQL SUITE FOR ORACLE");
        jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 0, 204), new java.awt.Color(51, 0, 204), null, null));
        add(jLabel4);
        jLabel4.setBounds(290, 50, 330, 40);

        jB_closeTab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sqlsuite/cross.jpg"))); // NOI18N
        jB_closeTab.setToolTipText("Close Tab");
        jB_closeTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_closeTabActionPerformed(evt);
            }
        });
        add(jB_closeTab);
        jB_closeTab.setBounds(870, 50, 30, 30);

        jButton1.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 204));
        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(610, 150, 90, 27);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sqlsuite/powerpoint-curve-background.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        add(jLabel3);
        jLabel3.setBounds(0, 0, 1020, 670);
    }// </editor-fold>//GEN-END:initComponents

private void jCB_DescItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCB_DescItemStateChanged
((DefaultTableModel)Desc_Table.getModel()).setRowCount(0);
//        int n=jScrollPane1.getComponentCount();
//        for(int i=0;i<n;i++)
//            for(int j=0;j<5;j++)
//            ((DefaultTableModel)Desc_Table.getModel()).setValueAt("", i, j);
//            ((DefaultTableModel)Desc_Table.getModel()).removeRow(i);
        check1=0;
        String name=(String)evt.getItem();
        retriveDescriptionOfGivenTable(name);
}//GEN-LAST:event_jCB_DescItemStateChanged

private void jCB_DescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_DescActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jCB_DescActionPerformed

private void Desc_TableComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_Desc_TableComponentAdded
        // TODO add your handling code here:
        rowct=((DefaultTableModel)Desc_Table.getModel()).getRowCount();
        rowct--;
        if(Desc_Table.getValueAt(rowct,1)=="VARCHAR2")
        {
            Desc_Table.setValueAt("", rowct,3);
            Desc_Table.setEditingColumn(3);
        }
}//GEN-LAST:event_Desc_TableComponentAdded

private void jButton_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteActionPerformed
        int p=0;
        // TODO add your handling code here: 
        if(((DefaultTableModel) Desc_Table.getModel()).getRowCount()==1 )
        {
           JOptionPane.showMessageDialog(null,"Atleast one row should present in the table","Message",JOptionPane.INFORMATION_MESSAGE); 
        }
        else
        {            
        int del[]=Desc_Table.getSelectedRows();
        if(del.length==0)
        {
            JOptionPane.showMessageDialog(null,"No row is selected","ERROR",JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            String st1="";
            int confirm=JOptionPane.showConfirmDialog(null,"Are you sure to Delete?","Message",JOptionPane.YES_NO_OPTION);
            if(confirm==0)
            {
                try 
                {
                    for(int i=0;i<del.length;i++)
                    {
                        System.out.println("number:"+del[i]);
    //                  int e=Desc_Table.getSelectedRow();
    //                  System.out.println(e);
                        if(del[i]<StaticData.noOfRows)
                        {
                                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                                Connection conn2 = DriverManager.getConnection("jdbc:odbc:MyPrjDSN", StaticData.userid, StaticData.password);
                                Statement stmt = conn2.createStatement();
                                String name=(String)jCB_Desc.getSelectedItem();
                                st1="alter table ";
                                st1+=name+" drop column "+((DefaultTableModel) Desc_Table.getModel()).getValueAt(del[i],0)+";";
                                System.out.println(st1);
                                stmt.execute(st1);
//                                ((DefaultTableModel) Desc_Table.getModel()).removeRow(del[i]);
//                                StaticData.noOfRows--;
                                JOptionPane.showMessageDialog(null,"QUERY:"+st1,"QUERY", JOptionPane.INFORMATION_MESSAGE);
                                p++;
                        }                        
                    }
                    for(int i=(del.length-1);i>=0;i++)
                    {
//                        if(del[i]<StaticData.noOfRows)
//                        {
//                                System.out.println("number:"+del[i]);
//                                ((DefaultTableModel) Desc_Table.getModel()).removeRow(del[i]);
//                                StaticData.noOfRows--;
//                        }
//                        else
//                        {
                                ((DefaultTableModel) Desc_Table.getModel()).removeRow(del[i]);
                       // }
                    }
                    StaticData.noOfRows=StaticData.noOfRows-p;                    
                   // JOptionPane.showMessageDialog(null,"QUERY:"+st1,"QUERY", JOptionPane.INFORMATION_MESSAGE);
                 } 
                catch (SQLException ex) 
                {
                    Logger.getLogger(DescriptionOfTableFrame.class.getName()).log(Level.SEVERE, null, ex);
                } 
                catch (ClassNotFoundException ex) 
                {
                    System.out.println("error:"+ex);
                }
            }
         }
      }
}//GEN-LAST:event_jButton_DeleteActionPerformed

private void jButton3_addColumnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3_addColumnActionPerformed
         System.out.println("count.....");    
//        if(timecount)
//        {
//            timecount=false;
//            return;
//                    
//        }
//        timecount=true;
//        
//        int t=0;       
//                rowct=((DefaultTableModel)Desc_Table.getModel()).getRowCount();
//                if(check1==0)
//                {
                        //jButton_saveActionPerformed(evt);
                        System.out.println("1st time");
                        ((DefaultTableModel)Desc_Table.getModel()).addRow(new Object[5]);
                        TableColumn sportColumn = Desc_Table.getColumnModel().getColumn(1);
                        JComboBox comboBox = new JComboBox();
                        comboBox.addItem("VARCHAR2");
                        comboBox.addItem("NUMBER");
                        //comboBox.addItem("INTEGER");
                        //comboBox.addItem("Speed reading");
                        //comboBox.addItem("Teaching high school");
                        //comboBox.addItem("None");
                        sportColumn.setCellEditor(new DefaultCellEditor(comboBox));
                        TableColumn conColumn=Desc_Table.getColumnModel().getColumn(4);
                        JComboBox comboBox2=new JComboBox();
                        comboBox2.addItem("NOT NULL");
                        comboBox2.addItem("NULL");
                        conColumn.setCellEditor(new DefaultCellEditor(comboBox2));               
                        check1++;
//               }
//               else
//               {
//                   rowct=((DefaultTableModel)Desc_Table.getModel()).getRowCount();
//                   rowct--;
//                    if("".equals(Desc_Table.getValueAt(rowct,0))||"".equals(Desc_Table.getValueAt(rowct,0))||Desc_Table.getValueAt(rowct,2)==""||Desc_Table.getValueAt(rowct,4)=="")
//                    {
//                        JOptionPane.showMessageDialog(null,"Please fill all the entries");
//                        return;                     
//                    }
//                    else
//                    {
//                       //jButton_saveActionPerformed(evt);
//                        saveChanges();
//                        System.out.println("2nd time");
//                        //((DefaultTableModel)Desc_Table.getModel()).addRow(new Object[3]);
//                        TableColumn sportColumn = Desc_Table.getColumnModel().getColumn(1);
//                        JComboBox comboBox = new JComboBox();
//                        comboBox.addItem("VARCHAR2");
//                        comboBox.addItem("NUMBER");
//                        //comboBox.addItem("INTEGER");
//        //                comboBox.addItem("Speed reading");
//        //                comboBox.addItem("Teaching high school");
//        //                comboBox.addItem("None");
//                        sportColumn.setCellEditor(new DefaultCellEditor(comboBox));
//                        TableColumn conColumn=Desc_Table.getColumnModel().getColumn(4);
//                        JComboBox comboBox2=new JComboBox();
//                        comboBox2.addItem("NOT NULL");
//                        comboBox2.addItem("NULL");
//                        conColumn.setCellEditor(new DefaultCellEditor(comboBox2));
//                    }                   
//               }               
}//GEN-LAST:event_jButton3_addColumnActionPerformed

private void jButton_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_saveActionPerformed
        saveChanges();
            // TODO add your handling code here:
//            if(Desc_Table.getValueAt(rowct,1)=="VARCHAR2")
//            {
//                
//            }
//            String str="alter table "+jCB_Desc.getSelectedItem()+" add ("+Desc_Table.getValueAt(rowct, 0)+" "+Desc_Table.getValueAt(rowct, 1)+"("+Desc_Table.getValueAt(rowct, 2);
//            if("VARCHAR2".equals(Desc_Table.getValueAt(rowct, 1)))
//            {
//                str+="));";
//            }    
//            else
//            {
//                str+=","+Desc_Table.getValueAt(rowct, 3)+"));";
//            }
//            System.out.println(str);
//            int x=EstablishConnection.connec(str);
//                        if(x==0)
//                            JOptionPane.showMessageDialog(null,"Table Not Updated");
//                        else
//                            JOptionPane.showMessageDialog(null,"Table UPdated");
//  System.out.println("after table ...... ");
}//GEN-LAST:event_jButton_saveActionPerformed

private void jB_closeTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_closeTabActionPerformed
int confirm=JOptionPane.showConfirmDialog(null,"Are you sure to close this tab?","Message",JOptionPane.YES_NO_OPTION);
//int confirm=JOptionPane.showConfirmDialog(null, "Error is here", "Error", YES, WIDTH)       
if(confirm==0)
         {
                MainWindowClass.jTabbedPane_view.remove(MainWindowClass.tabdesc);
                MainWindowClass.desc="close";
                //MainWindowClass.jTabbedPane_view.
                MyUtilities.closeTab(MainWindowClass.tabdesc);
         }
}//GEN-LAST:event_jB_closeTabActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
        MainWindowClass.jTabbedPane_view.remove(MainWindowClass.tabdesc);
        MainWindowClass.jTabbedPane_view.add(new DescriptionPanel(),MainWindowClass.tabdesc);
        MainWindowClass.jTabbedPane_view.setTitleAt(MainWindowClass.tabdesc,"Description");
        MainWindowClass.jTabbedPane_view.setSelectedIndex(MainWindowClass.tabdesc);
}//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Desc_Table;
    private javax.swing.JButton jB_closeTab;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3_addColumn;
    private javax.swing.JButton jButton_Delete;
    public javax.swing.JButton jButton_save;
    private javax.swing.JComboBox jCB_Desc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void retriveDescriptionOfGivenTable(String name) {
        try
        {
                    String qry = "select * from "+name;
//                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//                    Connection conn=DriverManager.getConnection("jdbc:odbc:MyPrjDSN",StaticData.userid,StaticData.password);
//                    Statement stmt=conn.createStatement();
                    ResultSet rs = EstablishConnection.executeQuery(qry);
                    rsmd =rs.getMetaData();
                    int columnCount = rsmd.getColumnCount();
                    StaticData.noOfRows=columnCount;
                     //Desc_Table.setEnabled(true);
                    //Desc_Table.addRowSelectionInterval(0,columnCount);
                    ((DefaultTableModel)Desc_Table.getModel()).setRowCount(columnCount);
                    for (int i = 0; i < columnCount; i++)
                    {                        
                         Desc_Table.setValueAt(rsmd.getColumnName(i + 1), i, 0);
                         Desc_Table.setValueAt(rsmd.getColumnTypeName(i + 1), i, 1);
                         if ((""+rsmd.getColumnTypeName(i + 1)).equals("number")) {
                                Desc_Table.setValueAt(""+(rsmd.getColumnDisplaySize(i + 1) - 2), i, 2);
                         } else {
                                Desc_Table.setValueAt(""+rsmd.getColumnDisplaySize(i + 1), i, 2);
                         }
                           Desc_Table.setValueAt(""+rsmd.getScale(i + 1), i, 3);
                         if ((""+rsmd.isNullable(i + 1)).equals("1")) {
                                Desc_Table.setValueAt("NULL", i, 4);
                         } else {
                                Desc_Table.setValueAt("NOT NULL", i, 4);
                         }
//                         Desc_Table.setEditingRow(i);
                         //Desc_Table.setEditingColumn(1);
            }
        } catch (Exception ex) {
            System.out.println("Exception in retriveDescriptionOfGivenTable:"+ex);
        }
    }

    private void saveChanges() {
        String str4="";
        int re[]=new int[check1];
        int x=1;
        int k=0;
        for(int i=StaticData.noOfRows,r=0;i<(StaticData.noOfRows+check1);i++,r++)
        {
            re[r]=0;
            String str="alter table "+jCB_Desc.getSelectedItem()+" add ("+Desc_Table.getValueAt(i, 0)+" "+Desc_Table.getValueAt(i, 1)+"("+Desc_Table.getValueAt(i, 2);
            if("VARCHAR2".equals(Desc_Table.getValueAt(i, 1)))
            {
                str+="));";
            }    
            else
            {
                str+=","+Desc_Table.getValueAt(i, 3)+"));";
            }
            System.out.println(str);
            x=EstablishConnection.connec(str);            
            if(x==0)
                re[r]=1;
        }
        for(int j=0;j<check1;j++)
        {
            if(re[j]==1)
            {
               ((DefaultTableModel)Desc_Table.getModel()).moveRow(StaticData.noOfRows-1+j,StaticData.noOfRows-1+j,StaticData.noOfRows+check1-1); 
                k++;
                //str4+=+j+",";
            }
        }        
        if(k!=0)
        {
             JOptionPane.showMessageDialog(null,"Last"+k+"columns are not updated");
        }
        else
        {
             JOptionPane.showMessageDialog(null,"Table UPdated");
             StaticData.noOfRows=StaticData.noOfRows+check1-k;
             check1=0;
        }     
        MainWindowClass.jTabbedPane_view.remove(MainWindowClass.tabdesc);
        MainWindowClass.jTabbedPane_view.add(new DescriptionPanel(),MainWindowClass.tabdesc);
        MainWindowClass.jTabbedPane_view.setTitleAt(MainWindowClass.tabdesc,"Description");
        MainWindowClass.jTabbedPane_view.setSelectedIndex(MainWindowClass.tabdesc);
    }

    private void resultSetRetrieve() {
        System.out.println("TName: are as follow");
        try{
            //((DefaultTableModel)Desc_Table.getModel()).setRowCount(1000);
//            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//            Connection conn=DriverManager.getConnection("jdbc:odbc:MyPrjDSN",StaticData.userid,StaticData.password);
//            Statement stmt=conn.createStatement();
            ResultSet resultSet=EstablishConnection.executeQuery("select * from tab");
            while(resultSet.next())
            {
                String value=resultSet.getString("TNAME");
                System.out.println("TName:"+value);
                jCB_Desc.addItem((Object)value);
            }
            resultSet.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception: "+e);
        }
         String name=(String)jCB_Desc.getSelectedItem();
        retriveDescriptionOfGivenTable(name);
    }
}
