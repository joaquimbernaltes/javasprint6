package forms;

import config.Conexio;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import classes.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JFramePropostes extends javax.swing.JFrame {

    /* Connexió BD */
    Conexio con= new Conexio();
    Connection cn;
    Statement st;
    ResultSet rs;
    DefaultTableModel model;

    public JFramePropostes() {
        //initComponents();
        setLocationRelativeTo(null);
        llistarPropostes();
    }

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
            Propostes proposta = new Propostes();

            try {
                proposta.inserirProposta(field_nom.getText(), field_data.getText());
                JOptionPane.showMessageDialog(null, "S'ha afegit correctament les noves dades");

                //ll_prop.inserirProposta(field_nom.getText(), field_descripcio.getText(), prop);
                //enrereMouseClicked(evt);
            } catch (Exception e) {
                Logger.getLogger(JFramePropostes.class.getName()).log(Level.SEVERE, null, e);
                JOptionPane.showMessageDialog(null, "No s'han pogut afegir les noves dades per el següent error " + e.getMessage());

            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(JFramePropostes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFramePropostes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFramePropostes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFramePropostes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFramePropostes().setVisible(true);
            }
        });
    }

    void llistarPropostes(){
        String sql="select * from propuestas";
        try {
            cn=con.getConnection();
            st=cn.createStatement();
            rs=st.executeQuery(sql);
            Object[]proposta=new Object[6];
            //Iniciem el model
            model=(DefaultTableModel)TaulaPropostes.getModel();

            //Indiquem els camps i indiquem que s'afegeixi la línia
            while(rs.next()){
                proposta[0]=rs.getInt("id");
                proposta[1]=rs.getInt("nom");
                proposta[2]=rs.getString("descripcio");
                proposta[3]=rs.getString("requeriments");
                proposta[4]=rs.getString("estat");
                model.addRow(proposta);
            }
            //Envia les dades a la taula per mostrar-les
            TaulaPropostes.setModel(model);
        } catch (Exception e) {

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TaulaPropostes;
    private javax.swing.JTextField field_data;
    private javax.swing.JTextField field_nom;
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
