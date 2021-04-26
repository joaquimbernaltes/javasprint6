package config;


import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ximo
 */
public class realitzarConnexio {
    /* Connexió BD */
    Conexio con= new Conexio();
    Connection cn;
    Statement st;
    ResultSet rs;
    DefaultTableModel model;

    //Connexió SQL para fitxer classes.Projectes
    public void afegirsql(String sql) throws SQLException {
        cn=con.getConnection();
        st=cn.createStatement();
        st.executeUpdate(sql);
    }

    //Connexió SQL para fitxer classes.Projectes
    public ResultSet consultasql(String sql) throws SQLException {
        cn=con.getConnection();
        st=cn.createStatement();
        return st.executeQuery(sql);
    }

}

