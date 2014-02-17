/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SelectTableFrame.java
 *
 * Created on Dec 26, 2011, 8:53:44 PM
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
public class SelectTableFrame extends javax.swing.JFrame {

    /** Creates new form SelectTableFrame */
    public SelectTableFrame() {
        try {
//            if(StaticData.choice==3)
//            {
//                jLabel2.setText("NOTE: Please slect the TABLE Name  from the below list To create a View");            
//            }
            initComponents();
            resultSetRetrieve();
            setLocationRelativeTo(null);
        } catch (SQLException ex) {
            Logger.getLogger(SelectTableFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCB_TableList = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jButton_Showcontents = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("SelectTableFrame");
        setMinimumSize(new java.awt.Dimension(800, 300));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jCB_TableList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCB_TableListItemStateChanged(evt);
            }
        });
        getContentPane().add(jCB_TableList);
        jCB_TableList.setBounds(195, 150, 207, 35);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("TableName:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 150, 80, 24);

        jButton_Showcontents.setFont(new java.awt.Font("Dialog", 1, 14));
        jButton_Showcontents.setForeground(new java.awt.Color(0, 102, 102));
        jButton_Showcontents.setText("ShowContents");
        jButton_Showcontents.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 102, 102)));
        jButton_Showcontents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ShowcontentsActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Showcontents);
        jButton_Showcontents.setBounds(200, 210, 140, 38);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("NOTE: Please slect the TABLE Name  from the below list");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(104, 105, 310, 31);

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 3, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 51));
        jLabel3.setText("SQL SUITE FOR ORACLE");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(0, 153, 153), null, new java.awt.Color(0, 102, 102)));
        getContentPane().add(jLabel3);
        jLabel3.setBounds(44, 21, 466, 57);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sqlsuite/powerpoint-curve-background.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        jLabel4.setBorder(javax.swing.BorderFactory.createMatteBorder(6, 6, 6, 6, new java.awt.Color(0, 102, 102)));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 580, 370);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ShowcontentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ShowcontentsActionPerformed
        try {
            // TODO add your handling code here:
                switch(StaticData.choice)
                {
                    case 0:
                    {
                        dispose();
                        new ChooseTableFrame().setVisible(true);
                        break;
                    }
                    case 1:
                    {
                        dispose();
                        new ConditionFrame().setVisible(true);
                        break;
                    }
                    case 2:
                    {
                        dispose();
                        new ModifyFrame().setVisible(true);
                        break;
                    }
                    case 3:
                    {
                        dispose();
                        new ConditionFrame().setVisible(true);
                        break;
                    }    
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(SelectTableFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jButton_ShowcontentsActionPerformed

private void jCB_TableListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCB_TableListItemStateChanged
// TODO add your handling code here:
   StaticData.tablename=(String) jCB_TableList.getSelectedItem();
}//GEN-LAST:event_jCB_TableListItemStateChanged

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
                new SelectTableFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Showcontents;
    private javax.swing.JComboBox jCB_TableList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables

    public void resultSetRetrieve() throws SQLException {
   System.out.println("TName: are as follow");
        try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conn=DriverManager.getConnection("jdbc:odbc:MyPrjDSN",StaticData.userid,StaticData.password);
            Statement stmt=conn.createStatement();
            ResultSet resultSet=stmt.executeQuery("select * from tab");
            while(resultSet.next())
            {
                String value=resultSet.getString("TNAME");
                System.out.println("TName:"+value);
               jCB_TableList.addItem((Object)value);
            }
            resultSet.close();
        }
        catch(Exception e)
        {
            System.out.println("Exception: "+e);
        }
       StaticData.tablename=(String) jCB_TableList.getSelectedItem();
    }
}
