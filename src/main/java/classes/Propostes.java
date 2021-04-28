/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import config.Conexio;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alumne
 */
public class Propostes {

    /* Connexió BD */
    Conexio con= new Conexio();
    Connection cn;
    Statement st;
    ResultSet rs;
    DefaultTableModel model;

    public void inserirProposta(String nom, String data) throws SQLException {
        // Projecte m = new Projecte(contador + 1, nom, descripcio, proposta);
        String sql = "insert into propuestas (id, nom, estat) values ('"+1+"','"+nom+"','actiu')";
        cn=con.getConnection();
        st=cn.createStatement();
        st.executeUpdate(sql);
    }
}
