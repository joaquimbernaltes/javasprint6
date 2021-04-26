package forms;

import classes.Presupostos;

import config.Conexio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JFramePresupostos extends javax.swing.JFrame {

    /* Connexió BD */
    Conexio con = new Conexio();
    Connection cn;
    Statement st;
    ResultSet rs;
    DefaultTableModel model;

    public JFramePresupostos() {
        initComponents();
        setLocationRelativeTo(null);
        llistarPresupostos();
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        field_nom = new javax.swing.JTextField();
        field_cost = new javax.swing.JTextField();
        field_quantitat = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("CRUD Pressupost");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dades"));
        jPanel1.setName(""); // NOI18N

        jLabel2.setText("Nom del cost:");

        jLabel3.setText("Preu:");

        jLabel4.setText("Quantitat:");


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
                                                        .addComponent(field_cost, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                                        .addComponent(field_nom)
                                                        .addComponent(field_quantitat))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(field_nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(field_cost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(field_quantitat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jButton3.setText("Esborrar");

        jButton4.setText("List Prop.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(28, 28, 28)
                                .addComponent(jButton3)
                                .addGap(26, 26, 26)
                                .addComponent(jButton4)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2)
                                        .addComponent(jButton3)
                                        .addComponent(jButton4))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Llistat"));

        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "id","id_pressupost", "nom_cost","preu_cost", "quantitat_cost" ,"total_linea_producte" ,"iva" ,"procedencia" ,"estat_proposta" , "estat"
                }
        ));
        jScrollPane1.setViewportView(tablaDatos);
        if (tablaDatos.getColumnModel().getColumnCount() > 0) {
            tablaDatos.getColumnModel().getColumn(0).setPreferredWidth(10);
            tablaDatos.getColumnModel().getColumn(1).setPreferredWidth(50);
            tablaDatos.getColumnModel().getColumn(5).setPreferredWidth(40);
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
            Presupostos presupost = new Presupostos();

            try {
                Double cost = Double.parseDouble(field_cost.getText());
                int quantitat = Integer.parseInt(field_quantitat.getText());
                presupost.inserirPressupost(field_nom.getText(), cost, quantitat); //String nom_cost,String preu_cost,String quantitat_cost
                JOptionPane.showMessageDialog(null, "S'ha afegit correctament les noves dades");


                //enrereMouseClicked(evt);
            } catch (Exception e) {
                Logger.getLogger(JFramePresupostos.class.getName()).log(Level.SEVERE, null, e);
                JOptionPane.showMessageDialog(null, "No s'han pogut afegir les noves dades per el següent error " + e.getMessage());

            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    void llimpiarcamps(){
        field_id.setText("");
        field_nom.setText("");
        field_cost.setText("30$");
    }

    void resetprojecte(){
        llimpiartaula();
        llistarPresupostos();
        llimpiarcamps();
    }

    void llimpiartaula(){
        for(int i=0;i<tablaDatos.getRowCount();i++){
            model.removeRow(i);
            i=i-1;
        }
    }
    //Botó "Esborrar"
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int filaseleccionada=tablaDatos.getSelectedRow();
        if(filaseleccionada==-1){
            JOptionPane.showMessageDialog(null, "Has de seleccionar la fila que vols esborrar!");
        }else{
            Presupostos projecte = new Presupostos();
            try {
                projecte.esborrarPressupost(field_id.getText(),field_nom.getText(), field_data.getText());
                JOptionPane.showMessageDialog(null, "S'ha esborrat correctament la fila seleccionada!");
                resetprojecte();
            } catch (Exception e) {
                Logger.getLogger(JFrameProjectes.class.getName()).log(Level.SEVERE, null, e);
                JOptionPane.showMessageDialog(null, "No s'ha esborrat el projecte correctament " + e.getMessage());
            }
        }
    }

    //Botó modificar
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (field_nom.getText().equals("") || field_id.getText().equals("") || field_data.getText().equals("")) {
            //Mostrem error si no selecciona res
            JOptionPane.showMessageDialog(this, "Per favor, introdueix les dades", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            Presupostos projecte = new Presupostos();

            try {
                projecte.modificarPressupost(field_id.getText(),field_nom.getText(), field_cost.getText());
                JOptionPane.showMessageDialog(null, "S'han modificat correctament les dades!");
                resetprojecte();
            } catch (Exception e) {
                Logger.getLogger(JFrameProjectes.class.getName()).log(Level.SEVERE, null, e);
                JOptionPane.showMessageDialog(null, "No s'ha modificat el projecte correctament " + e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    //Funció que recupera les dades de la taula i les insereix als textfields
    private void tablaDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDatosMouseClicked
        int fila=tablaDatos.getSelectedRow();
        if(fila==-1){
            JOptionPane.showMessageDialog(null, "Projecte no seleccionat");
        }else{

            try{
                int id=Integer.parseInt((String)tablaDatos.getValueAt(fila,0).toString());
                String nom_projecte=(String)tablaDatos.getValueAt(fila, 2);
                String data_inici=(String)tablaDatos.getValueAt(fila, 3);
                field_id.setText(""+id);
                field_nom.setText(nom_projecte);
                field_data.setText(data_inici);
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, "No hi han projectes");
            }
        }
    }

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
            java.util.logging.Logger.getLogger(JFramePresupostos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFramePresupostos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFramePresupostos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFramePresupostos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFramePresupostos().setVisible(true);
            }
        });
    }




    void llistarPresupostos() {
        String sql = "select * from linia_presupuestos";
        try {
            cn = con.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            Object[] presupost = new Object[10];
            //Iniciem el model
            model = (DefaultTableModel) tablaDatos.getModel();

            //Indiquem els camps i indiquem que s'afegeixi la línia
            while (rs.next()) {
                presupost[0] = rs.getInt("id");
                presupost[1] = rs.getInt("id_pressupost");
                presupost[2] = rs.getString("nom_cost");
                presupost[3] = rs.getString("preu_cost");
                presupost[4] = rs.getString("quantitat_cost");
                presupost[5] = rs.getString("total_linea_producte");
                presupost[6] = rs.getString("iva");
                presupost[7] = rs.getString("procedencia");
                presupost[8] = rs.getString("estat_proposta");
                presupost[9] = rs.getString("estat");
                model.addRow(presupost);
            }
            //Envia les dades a la taula per mostrar-les
            tablaDatos.setModel(model);
        } catch (Exception e) {


        }
    }


    private javax.swing.JTable tablaDatos;
    private javax.swing.JTextField field_cost;
    private javax.swing.JTextField field_nom;
    private javax.swing.JTextField field_quantitat;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}


