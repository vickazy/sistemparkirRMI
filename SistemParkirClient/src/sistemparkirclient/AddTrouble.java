/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemparkirclient;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import object.IClient;

/**
 *
 * @author Kid
 */
public class AddTrouble extends javax.swing.JFrame {

    /**
     * Creates new form AddTrouble
     */
    public AddTrouble() {
        initComponents();
        Object columnName[] = {"ID Customer","Jenis Kehilangan","Tanggal","Keterangan","Denda"};
        DefaultTableModel model =  new DefaultTableModel(columnName, 0);
        jTable2.setModel(model);
        Object columnName2[] = {"ID Customer","Nama","Tanggal Lahir","Jenis Kelamin","Jenis Identitas","No Identitas","Alamat","No Hp"};
        DefaultTableModel model2 =  new DefaultTableModel(columnName2,0);
        jTable1.setModel(model2);
        popolatetable();
        customertable();
    }
    
     private void popolatetable()
    {
        try 
        {
           Registry reg = LocateRegistry.getRegistry("127.0.0.1", 9999);
            IClient obj = (IClient) reg.lookup("log");
           ArrayList data = obj.getTrouble();
           
           for (int i = 0; i< data.size(); i+=5)
           {
               String idcustomer = data.get(i).toString();
               String jeniskehilangan = data.get(i+1).toString();
               String keterangan = data.get(i+2).toString();
               String denda = data.get(i+3).toString();
               String tanggal = data.get(i+4).toString();
               
               String[] data_field = {idcustomer, jeniskehilangan, keterangan, denda , tanggal};
               DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
               model.addRow(data_field);
           }
            
        } 
        catch (Exception e) {
        }
    }
     
      private void customertable()
    {
        try 
        {
           Registry reg = LocateRegistry.getRegistry("127.0.0.1", 9999);
            IClient obj = (IClient) reg.lookup("log");
            ArrayList data = obj.getCustomerID();
            
            
            //jTable1.setModel(DbUtils.resultSetToTableModel(data));
           //System.out.println(data.);
           
           for (int i = 0; i< data.size(); i+=8)
           {
               System.out.println("COOL");
               String idcustomer = data.get(i).toString();
               String nama = data.get(i+1).toString();
               String tgllahir = data.get(i+2).toString();
               String jeniskelamin = data.get(i+3).toString();
               String jenisidentitas = data.get(i+4).toString();
               String noidentitas = data.get(i+5).toString();
               String alamat = data.get(i+6).toString();
               String nohp = data.get(i+7).toString();
               
               
               String[] data_field = {idcustomer, nama, tgllahir, jeniskelamin, jenisidentitas,noidentitas,alamat,nohp};
               
               DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
               model.addRow(data_field);
           }
            
        } 
        catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jidcustomer = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cb_jenis = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jketerangan = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1200, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jidcustomer.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        getContentPane().add(jidcustomer);
        jidcustomer.setBounds(160, 100, 170, 21);

        jLabel2.setFont(new java.awt.Font("Trajan Pro 3", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Add Trouble");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 30, 188, 25);

        jLabel4.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Jenis :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 140, 50, 15);

        cb_jenis.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        cb_jenis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Karcis Parkir", "STNK", "Lainnya" }));
        getContentPane().add(cb_jenis);
        cb_jenis.setBounds(160, 140, 170, 21);

        jLabel1.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID Customer :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 100, 100, 15);

        jTable1.setFont(new java.awt.Font("Myriad Pro", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setEnabled(false);
        jScrollPane2.setViewportView(jTable1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(350, 100, 804, 204);

        jketerangan.setColumns(20);
        jketerangan.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jketerangan.setRows(5);
        jScrollPane1.setViewportView(jketerangan);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(160, 180, 170, 90);

        jLabel5.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Keterangan :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 180, 80, 15);

        jTable2.setFont(new java.awt.Font("Myriad Pro", 0, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.setEnabled(false);
        jScrollPane3.setViewportView(jTable2);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(220, 350, 790, 199);

        jLabel6.setFont(new java.awt.Font("Trajan Pro 3", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Daftar Kehilangan");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(450, 320, 230, 30);

        jLabel7.setFont(new java.awt.Font("Trajan Pro 3", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Customer List");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(350, 70, 190, 19);

        jButton1.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(160, 290, 75, 23);

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(10, 470, 55, 20);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kid\\Documents\\NetBeansProjects\\SistemParkirClient\\src\\imgprk\\2560x1440-black-solid-color-background.jpg")); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 1200, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void SaveTrouble() 
    {
         try
         {
            Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1", 9999);
            IClient f = (IClient) myRegistry.lookup("log");
            System.out.println("cool");
            
            String idcustomer = jidcustomer.getText().toString();
            String jenis = cb_jenis.getSelectedItem().toString();
            String keterangan = jketerangan.getText().toString();
            
            
            
            f.setIDCustomer(idcustomer);
            f.setJenisKehilangan(jenis);
            f.setKeterangan(keterangan);
            

            
            int i = f.SaveTrouble();
            
            if(i != 0)
            {
                System.out.println("cool");
                JOptionPane.showMessageDialog(null, "Success");
                
            
                
            }
            else
            {
                  JOptionPane.showMessageDialog(null, "Error");
            }
             
         }
         catch(Exception ex)
         {
             JOptionPane.showMessageDialog(null,"Error asdsad: " + ex);
         }
         
         
         
     }
    
    private int Validation(){
        int flag = 0;
        String error = "";
        
        
        if(jidcustomer.getText().equals("")){
            flag = 1;
            error += "ID Customer Tidak Boleh Kosong.\n";
        }
        if(jketerangan.getText().equals("")){
            flag = 1;
            error += "Keterangan Tidak Boleh Kosong.\n";
        }
        
      
        if(flag == 0)
        {
            
        }
        else
        {
            JOptionPane.showMessageDialog(this, error);
        }
        return flag;
    }
    
    private void clear(){
        jidcustomer.setText("");
        jketerangan.setText("");
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         // TODO add your handling code here:
         try 
        {
            if(Validation() == 0){
                 SaveTrouble();
                 clear();
                 DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                 model.setRowCount(0);
                 popolatetable();
            }
          
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Error : " + e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }//GEN-LAST:event_formWindowClosing

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Trouble cs = new Trouble();
        cs.setLocationRelativeTo(null);
        cs.setVisible(true);
        this.hide();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddTrouble.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddTrouble.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddTrouble.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddTrouble.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddTrouble().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cb_jenis;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jidcustomer;
    private javax.swing.JTextArea jketerangan;
    // End of variables declaration//GEN-END:variables
}
