package forms;

import config.Conexio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JFramePresupostos extends javax.swing.JFrame {

    /* Connexió BD */
    Conexio con = new Conexio();
    Connection cn;
    Statement st;
    ResultSet rs;
    DefaultTableModel model;

    public JFramePresupostos() {

        setLocationRelativeTo(null);
        llistarPresupostos();
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
                new JFramePresupostos().setVisible(true);
            }
        });
    }




    void llistarPresupostos() {
        String sql = "select * from linia_presupuesto";
        try {
            cn = con.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            Object[] presupost = new Object[6];
            //Iniciem el model
            model = (DefaultTableModel) tablaDatos.getModel();

            //Indiquem els camps i indiquem que s'afegeixi la línia
            while (rs.next()) {
                presupost[0] = rs.getInt("id");
                presupost[1] = rs.getInt("id_presupost");
                presupost[2] = rs.getString("nom_cost");
                presupost[3] = rs.getString("preu_cost");
                presupost[4] = rs.getString("quantitat_cost");
                presupost[5] = rs.getString("estat_proposta");
                presupost[6] = rs.getString("estat");
                model.addRow(presupost);
            }
            //Envia les dades a la taula per mostrar-les
            tablaDatos.setModel(model);
        } catch (Exception e) {


        }
    }


        private JTable tablaDatos;
        private JPanel Jpanel;
        private JTextField txtId;
        private JTextField txtNomCost;
        private JTextField textField3;
        private JTextField txtQuantitat;
        private JButton afegirButton;
        private JButton modificarButton;
        private JButton eliminarButton;
        private JButton nouButton;
        private JLabel txtPreu;
    private JButton enrrerebtn;

}

