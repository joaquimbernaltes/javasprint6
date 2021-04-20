package forms;

import config.*;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import classes.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ximo
 */
public class JFrameProjectes extends javax.swing.JFrame {

    /* Connexió BD */
    RealitzarConnexio newconnection= new RealitzarConnexio();
    ResultSet rs;   
    DefaultTableModel model;
    
    /**
     * Creates new form JFrameProjectes
     */
    public JFrameProjectes() {
        initComponents();
        setLocationRelativeTo(null);
        llistarProjectes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        field_id = new javax.swing.JTextField();
        field_nom = new javax.swing.JTextField();
        field_data = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TaulaProjectes = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("CRUD Projectes");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dades"));
        jPanel1.setName(""); // NOI18N

        jLabel2.setText("Nom Projecte:");

        jLabel3.setText("Data Inici:");

        jLabel4.setText("Proposta:");

        jLabel5.setText("ID");

        field_id.setEditable(false);

        field_data.setText("2021-01-01");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(field_data, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(field_nom))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(field_id, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(field_nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(field_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(field_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Operacions"));

        jButton1.setText("Crear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Modificar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Esborrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("List Prop.");

        jButton6.setText("Clear");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Llistat"));

        TaulaProjectes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID_Proposta", "Nom Projecte", "Data Inici", "Data Final", "Estat"
            }
        ));
        TaulaProjectes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TaulaProjectesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TaulaProjectes);
        if (TaulaProjectes.getColumnModel().getColumnCount() > 0) {
            TaulaProjectes.getColumnModel().getColumn(0).setPreferredWidth(10);
            TaulaProjectes.getColumnModel().getColumn(1).setPreferredWidth(50);
            TaulaProjectes.getColumnModel().getColumn(5).setPreferredWidth(40);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(248, 248, 248))
        );

        jButton5.setText("Enrere");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleName("");
        jPanel1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Botó Tornar menú principal
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //creem la nova finestra LlistatJFrame
        JFrameMenuPrincipal obj = new JFrameMenuPrincipal(); 	
        //la fem visible
        obj.setVisible(true);           
        //eliminem la finestra actual
        dispose(); 
    }//GEN-LAST:event_jButton5ActionPerformed

    //Botó Crear
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         if (field_nom.getText().equals("")) {
            //Mostrem error si no selecciona res
            JOptionPane.showMessageDialog(this, "Per favor, introdueix les dades", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            Projectes projecte = new Projectes();

             try {
                projecte.inserirProjecte(field_nom.getText(), field_data.getText());
                JOptionPane.showMessageDialog(null, "S'ha afegit correctament les noves dades");
                resetprojecte();
             } catch (Exception e) {
                Logger.getLogger(JFrameProjectes.class.getName()).log(Level.SEVERE, null, e);
                JOptionPane.showMessageDialog(null, "No s'han pogut afegir les noves dades per el següent error " + e.getMessage());

             }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    //Funció que recupera les dades de la taula i les insereix als textfields
    private void TaulaProjectesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TaulaProjectesMouseClicked
        int fila=TaulaProjectes.getSelectedRow();
        if(fila==-1){
            JOptionPane.showMessageDialog(null, "Projecte no seleccionat");
        }else{
            
            try{
                int id=Integer.parseInt((String)TaulaProjectes.getValueAt(fila,0).toString());
                String nom_projecte=(String)TaulaProjectes.getValueAt(fila, 2);
                String data_inici=(String)TaulaProjectes.getValueAt(fila, 3);
                field_id.setText(""+id);
                field_nom.setText(nom_projecte);
                field_data.setText(data_inici);    
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, "No hi han projectes");
            }
        }
    }//GEN-LAST:event_TaulaProjectesMouseClicked

    //Botó modificar
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         if (field_nom.getText().equals("") || field_id.getText().equals("") || field_data.getText().equals("")) {
            //Mostrem error si no selecciona res
            JOptionPane.showMessageDialog(this, "Per favor, introdueix les dades", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            Projectes projecte = new Projectes();

             try {
                projecte.modificarprojecte(field_id.getText(),field_nom.getText(), field_data.getText());
                JOptionPane.showMessageDialog(null, "S'han modificat correctament les dades!");
                resetprojecte();
             } catch (Exception e) {
                Logger.getLogger(JFrameProjectes.class.getName()).log(Level.SEVERE, null, e);
                JOptionPane.showMessageDialog(null, "No s'ha modificat el projecte correctament " + e.getMessage());
             }
        }        
    }//GEN-LAST:event_jButton2ActionPerformed

    //Botó llimpiar camps
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        resetprojecte();
    }//GEN-LAST:event_jButton6ActionPerformed

    //Botó "Esborrar"
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int filaseleccionada=TaulaProjectes.getSelectedRow();
        if(filaseleccionada==-1){
            JOptionPane.showMessageDialog(null, "Has de seleccionar la fila que vols esborrar!");
        }else{
            Projectes projecte = new Projectes();
            try {
                projecte.esborrarprojecte(field_id.getText(),field_nom.getText(), field_data.getText());
                JOptionPane.showMessageDialog(null, "S'ha esborrat correctament la fila seleccionada!");
                resetprojecte();
             } catch (Exception e) {
                Logger.getLogger(JFrameProjectes.class.getName()).log(Level.SEVERE, null, e);
                JOptionPane.showMessageDialog(null, "No s'ha esborrat el projecte correctament " + e.getMessage());
             }
        }    
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameProjectes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameProjectes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameProjectes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameProjectes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameProjectes().setVisible(true);
            }
        });
    }
    
    void resetprojecte(){
        llimpiartaula();
        llistarProjectes();
        llimpiarcamps();
    }
    
    void llistarProjectes(){
        String sql="select * from proyectos";
        try {
            rs = newconnection.consultasql(sql);
            //Indiquem la grandaria del nou objecte
            Object[]projecte=new Object[6];
            //Iniciem el model
            model=(DefaultTableModel)TaulaProjectes.getModel();
            
            //Indiquem els camps i indiquem que s'afegeixi la línia
            while(rs.next()){
                projecte[0]=rs.getInt("id");
                projecte[1]=rs.getInt("id_proposta");
                projecte[2]=rs.getString("nom_projecte");
                projecte[3]=rs.getString("data_inici");
                projecte[4]=rs.getString("data_final");
                projecte[5]=rs.getString("estat");
                //Revisar en Joan!!!
                if(projecte[5].equals("actiu")){
                    model.addRow(projecte);
                }
            }
            //Envia les dades a la taula per mostrar-les

            TaulaProjectes.setModel(model);
        } catch (Exception e) {
            
        }
    }
    //Funció que serveix per a llimpiar tota la taula cada vegada que llistem
    void llimpiartaula(){
        for(int i=0;i<TaulaProjectes.getRowCount();i++){
            model.removeRow(i);
            i=i-1;
        }
    }
    
    void llimpiarcamps(){
        field_id.setText("");
        field_nom.setText("");
        field_data.setText("2021-01-01");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TaulaProjectes;
    private javax.swing.JTextField field_data;
    private javax.swing.JTextField field_id;
    private javax.swing.JTextField field_nom;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
