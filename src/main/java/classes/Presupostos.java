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
public class Presupostos {

    /* Connexió BD */
    Conexio con= new Conexio();
    Connection cn;
    Statement st;
    ResultSet rs;
    DefaultTableModel model;

    public void inserirPressupost(String nom_cost,String preu_cost,String quantitat_cost) throws SQLException {

        String sql = "insert into linia_presupuestos (id,id_pressupost, nom_cost,preu_cost,quantitat_cost,estat_proposta , estat) values ('"+1+"','"+1+"','"+nom_cost+"','"+preu_cost+"','"+quantitat_cost+"','Acceptat','actiu')";
        cn=con.getConnection();
        st=cn.createStatement();
        st.executeUpdate(sql);
    }

}

