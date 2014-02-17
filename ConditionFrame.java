/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * ConditionFrame.java
 *
 * Created on Jan 1, 2012, 10:15:56 PM
 */

package sqlsuite;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Narendher
 */
public class ConditionFrame extends javax.swing.JFrame {
    private ResultSetMetaData rsmd;
    public JList list;
    public String qry;
    int cn=0;
    private String abc;
    private ResultSetMetaData rsmd2;
    /** Creates new form ConditionFrame */
    public ConditionFrame() 
    {
        initComponents();   
        if(StaticData.choice!=3)
        {
            jButton_createView.setVisible(false);
            jTF_Viewname.setVisible(false);
            jLabel_ViewName.setVisible(false);
        }
        setLocationRelativeTo(null);
        getColumnNames();
        validate();
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList_columnNames = new javax.swing.JList();
        jLabel_ColumnName = new javax.swing.JLabel();
        jLabel_Conditioncolumn = new javax.swing.JLabel();
        jComboBox_columnNames = new javax.swing.JComboBox();
        jComboBox_operators = new javax.swing.JComboBox();
        jTextField_Conditon_value = new javax.swing.JTextField();
        jButton_GetData = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_CondtionData = new javax.swing.JTable();
        jButton_ClearDara = new javax.swing.JButton();
        jLabel_operators = new javax.swing.JLabel();
        jLabel_value = new javax.swing.JLabel();
        jButton_createView = new javax.swing.JButton();
        jLabel_ViewName = new javax.swing.JLabel();
        jTF_Viewname = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("RetrievalUponCondition");
        setMinimumSize(new java.awt.Dimension(677, 516));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jScrollPane1.setViewportView(jList_columnNames);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(140, 11, 135, 60);

        jLabel_ColumnName.setText("Columns to be displayed:");
        getContentPane().add(jLabel_ColumnName);
        jLabel_ColumnName.setBounds(10, 41, 120, 30);

        jLabel_Conditioncolumn.setText("Where Condition:");
        getContentPane().add(jLabel_Conditioncolumn);
        jLabel_Conditioncolumn.setBounds(46, 77, 84, 31);

        jComboBox_columnNames.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_columnNamesItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBox_columnNames);
        jComboBox_columnNames.setBounds(140, 82, 135, 20);

        jComboBox_operators.setEditable(true);
        jComboBox_operators.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_operatorsActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_operators);
        jComboBox_operators.setBounds(308, 82, 104, 20);
        getContentPane().add(jTextField_Conditon_value);
        jTextField_Conditon_value.setBounds(430, 82, 108, 20);

        jButton_GetData.setText("Get Data");
        jButton_GetData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GetDataActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_GetData);
        jButton_GetData.setBounds(203, 119, 90, 43);

        jTable_CondtionData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_CondtionData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable_CondtionDataMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_CondtionData);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(56, 180, 546, 225);

        jButton_ClearDara.setText("Choose Another Table");
        jButton_ClearDara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ClearDaraActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_ClearDara);
        jButton_ClearDara.setBounds(373, 119, 139, 42);

        jLabel_operators.setText("Operators:");
        getContentPane().add(jLabel_operators);
        jLabel_operators.setBounds(308, 57, 80, 14);

        jLabel_value.setText("value:");
        getContentPane().add(jLabel_value);
        jLabel_value.setBounds(430, 57, 44, 14);

        jButton_createView.setText("Create View");
        jButton_createView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_createViewActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_createView);
        jButton_createView.setBounds(266, 440, 122, 39);

        jLabel_ViewName.setText("View Name:");
        getContentPane().add(jLabel_ViewName);
        jLabel_ViewName.setBounds(21, 133, 60, 14);
        getContentPane().add(jTF_Viewname);
        jTF_Viewname.setBounds(91, 130, 94, 20);

        jComboBox1.setEditable(true);
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(548, 82, 90, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sqlsuite/powerpoint-curve-background.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 0, 650, 490);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jButton_GetDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GetDataActionPerformed
        try {
            int ab=1;
            //TODO add your handling code here:
            //int col=jComboBox1.getSelectedItem();            
            //int x=jComboBox1.getX();
            //System.out.println(x);
            String pattern="[0-9]*";
            String pattern2="[a-zA-Z0-9]*";
            String fg=(String)jComboBox1.getSelectedItem();
           // String fg=(String)jTextField_Conditon_value.getText();
//            if("".equals(jTextField_Conditon_value.getText()))
//            {
//                JOptionPane.showMessageDialog(null,"Please enter the value in the condition field");
//            }
            if(("DECIMAL".equals(abc))&&(fg.matches(pattern)))
            {
                ab=0;
            }
            if(("VARCHAR2".equals(abc))&&(fg.matches(pattern2)))
            {
                ab=0;
            }
            if(ab==1)
            {
                JOptionPane.showMessageDialog(null,"Please enter Valid Value in the TextField");
                //jTextField_Conditon_value.requestFocus();
                jComboBox1.requestFocus();
            }
            else
            {
//                if(jTable1.getRowCount()>0)
//                {
//                    for(int p=0;p<jTable1.getRowCount();p++)
//                    {
//                       jTable1.remove(p);
//                       //((DefaultTableModel) jTable1.getModel()).re(p);
//                    }
//                }
//                ((DefaultTableModel)jTable1.getModel()).setColumnCount(0);
//                ((DefaultTableModel)jTable1.getModel()).setRowCount(0);
//                if(jList_columnNames.getSelectedValue()=="ALL")
//                {
//                    String str=(String) jComboBox_operators.getSelectedItem();
//                    if(">".equals(str)||"<".equals(str)||">=".equals(str)||"<=".equals(str))
//                    {
//                        qry = "select * from " + StaticData.tablename + " where " + jComboBox_columnNames.getSelectedItem() + " " + jComboBox_operators.getSelectedItem() + " " + jTextField_Conditon_value.getText();
//                    }
//                    if("Starting with".equals(str))
//                    {
//                        qry="select * from "+StaticData.tablename+" where "+jComboBox_columnNames.getSelectedItem()+" like '"+jTextField_Conditon_value.getText()+"%'";
//                    }
//                    if("Ending with".equals(str))
//                    {
//                        qry="select * from "+StaticData.tablename+" where "+jComboBox_columnNames.getSelectedItem()+" like '%"+jTextField_Conditon_value.getText()+"'";
//                    }
//                    ResultSet rs = EstablishConnection.executeQuery(qry);
//                    rsmd = rs.getMetaData();
//                    int columnCount = rsmd.getColumnCount();
//                    for (int i = 1; i <= columnCount; i++)
//                    {
//                        String value = rsmd.getColumnName(i);
//                        ((DefaultTableModel) jTable1.getModel()).addColumn(value);
//                    }
//                    String[] data = new String[columnCount];
//                    while (rs.next()) 
//                    {
//                        for (int i = 1, k = 0; i <= columnCount; i++, k++)
//                        {
//                            data[k] = rs.getString(i);
//                        }
//                        //jTable1.addRow((Object[])data);
//                        ((DefaultTableModel) jTable1.getModel()).addRow((Object[]) data);
//                    }
//                    jTable1.setCellEditor(null);
//                }
//                else
//                {
                    ((DefaultTableModel)jTable_CondtionData.getModel()).setColumnCount(0);
                    ((DefaultTableModel)jTable_CondtionData.getModel()).setRowCount(0);
                    String str=(String) jComboBox_operators.getSelectedItem();
                    int selections[] = jList_columnNames.getSelectedIndices();
                    Object selectedValues[] =jList_columnNames.getSelectedValues();
                    qry="select ";
                    for (int x = 0, n = selections.length; x < n; x++) 
                    {
                        qry+=selectedValues[x]+",";
                    }
                    qry=qry.substring(0,qry.length()-1);
//                    if("=".equals(str))
//                    {
//                        
//                    }
                    if(">".equals(str)||"<".equals(str)||">=".equals(str)||"<=".equals(str)||"=".equals(str))
                    {
                        qry+=" from " + StaticData.tablename + " where " + jComboBox_columnNames.getSelectedItem() + " " + jComboBox_operators.getSelectedItem() + " " + jComboBox1.getSelectedItem();
                    }
                    if("Starting with".equals(str))
                    {
                        qry+=" from "+StaticData.tablename+" where "+jComboBox_columnNames.getSelectedItem()+" like '"+jComboBox1.getSelectedItem()+"%'";
                    }
                    if("Ending with".equals(str))
                    {
                        qry+=" from "+StaticData.tablename+" where "+jComboBox_columnNames.getSelectedItem()+" like '%"+jComboBox1.getSelectedItem()+"'";
                    }
                    ResultSet rs = EstablishConnection.executeQuery(qry);
                    rsmd = rs.getMetaData();
                    int columnCount = rsmd.getColumnCount();
                    System.out.println("s"+columnCount);
                    for (int i = 1; i <= columnCount; i++) 
                    {
                        String value = rsmd.getColumnName(i);
                        ((DefaultTableModel) jTable_CondtionData.getModel()).addColumn(value);
                    }
                    String[] data = new String[columnCount];
                    while (rs.next()) 
                    {
                        for (int i = 1, k = 0; i <= columnCount; i++, k++) 
                        {
                            data[k] = rs.getString(i);
                        }
                        //jTable1.addRow((Object[])data);
                        ((DefaultTableModel) jTable_CondtionData.getModel()).addRow((Object[]) data);
                    }
                    jTable_CondtionData.setCellEditor(null);                
                }
         } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ConditionFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_GetDataActionPerformed

private void jButton_ClearDaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ClearDaraActionPerformed
// TODO add your handling code here:
    //StaticData.choice=1;
    dispose();
    new SelectTableFrame().setVisible(true);
}//GEN-LAST:event_jButton_ClearDaraActionPerformed

private void jComboBox_columnNamesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_columnNamesItemStateChanged
        try {
            // TODO add your handling code here:
                //System.out.println("ITEM="+evt.getItem()+","+jComboBox_columnNames.getSelectedIndex());
                jComboBox_operators.removeAllItems();
                int i=jComboBox_columnNames.getSelectedIndex();
                abc=StaticData.columntype[i+1];
                int x=jComboBox_operators.getComponentCount();
                if( "DECIMAL".equals(abc))
                {
                    jComboBox_operators.addItem(">");
                    jComboBox_operators.addItem("<");
                    jComboBox_operators.addItem(">=");
                    jComboBox_operators.addItem("<=");
                    jComboBox_operators.addItem("=");
                }
                if( "VARCHAR2".equals(abc))
                {
                    jComboBox_operators.addItem("Starting with");
                    jComboBox_operators.addItem("Ending with");
                    jComboBox_operators.addItem("=");
                }
                jComboBox1.removeAllItems();
                String str2="SELECT DISTINCT "+jComboBox_columnNames.getSelectedItem()+" FROM "+StaticData.tablename+";";
                ResultSet rs1=EstablishConnection.executeQuery(str2);
//                rsmd2 = rs1.getMetaData();
//                int columnCount = rsmd2.getColumnCount();
                while(rs1.next())
                {                    
                    jComboBox1.addItem(rs1.getString(1));
                }
        } catch (SQLException ex) {
            Logger.getLogger(ConditionFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}//GEN-LAST:event_jComboBox_columnNamesItemStateChanged

private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
 // TODO add your handling code here:
    int confirm=JOptionPane.showConfirmDialog(null,"Are you sure to QUIT?","Message",JOptionPane.YES_NO_OPTION);
    if(confirm==0)
    {       
        dispose();
        new MenuWindowFrame().setVisible(true);
                
    }
    else
         return;
}//GEN-LAST:event_formWindowClosing

private void jComboBox_operatorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_operatorsActionPerformed
// TODO add your handling code here:
    //jComboBox2.additem
}//GEN-LAST:event_jComboBox_operatorsActionPerformed

    private void jButton_createViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_createViewActionPerformed
        // TODO add your handling code here:
        String str2="CREATE VIEW "+jTF_Viewname.getText()+" AS SELECT ";
        int selections[] = jList_columnNames.getSelectedIndices();
        Object selectedValues[] =jList_columnNames.getSelectedValues();
        for (int x = 0, n = selections.length; x < n; x++) 
        {
            str2+=selectedValues[x]+",";
        }
        str2=str2.substring(0,str2.length()-1);
        str2+=" FROM "+StaticData.tablename+" WHERE "+jComboBox_columnNames.getSelectedItem()+" "+jComboBox_operators.getSelectedItem()+" "+jComboBox1.getSelectedItem()+";";
        System.out.println("View"+str2);
        EstablishConnection.connec(str2);
        JOptionPane.showMessageDialog(null,"View has been Successfully Created");
    }//GEN-LAST:event_jButton_createViewActionPerformed

    private void jTable_CondtionDataMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_CondtionDataMouseEntered
        // TODO add your handling code here:
     
    }//GEN-LAST:event_jTable_CondtionDataMouseEntered

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConditionFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_ClearDara;
    private javax.swing.JButton jButton_GetData;
    private javax.swing.JButton jButton_createView;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox_columnNames;
    private javax.swing.JComboBox jComboBox_operators;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_ColumnName;
    private javax.swing.JLabel jLabel_Conditioncolumn;
    private javax.swing.JLabel jLabel_ViewName;
    private javax.swing.JLabel jLabel_operators;
    private javax.swing.JLabel jLabel_value;
    private javax.swing.JList jList_columnNames;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTF_Viewname;
    private javax.swing.JTable jTable_CondtionData;
    private javax.swing.JTextField jTextField_Conditon_value;
    // End of variables declaration//GEN-END:variables
    private void getColumnNames() {
        try {
            String qry1 = "select * from " + StaticData.tablename;
            ResultSet rs = EstablishConnection.executeQuery(qry1);
            rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            DefaultListModel dlm=new DefaultListModel();
            for (int i = 1; i <= columnCount; i++) {
                StaticData.columntype[i]=rsmd.getColumnTypeName(i);
                dlm.addElement(rsmd.getColumnName(i));
                String value = rsmd.getColumnName(i);
                jComboBox_columnNames.addItem(value);
            }
            //dlm.addElement("ALL");
            jList_columnNames.setModel(dlm);
            JScrollPane jsp = new JScrollPane(list);
        } catch (SQLException ex) {
            Logger.getLogger(ConditionFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
