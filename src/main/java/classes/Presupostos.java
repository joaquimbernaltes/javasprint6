/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import config.Conexio;
import config.realitzarConnexio;

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
    realitzarConnexio newconnection= new realitzarConnexio();
    public void inserirPressupost(String nom_cost,Double preu_cost,int quantitat_cost) throws SQLException {
        double total_linia_producte = preu_cost *quantitat_cost;
        String sql = "insert into linia_presupuestos (id_pressupost, nom_cost,preu_cost, quantitat_cost ,total_linia_producte ,iva ,procedencia ,estat_proposta , estat) values('"+1+"','"+nom_cost+"','"+preu_cost+"','"+quantitat_cost+"' ,'" +total_linia_producte+ "', '21½' ,'Entitat','Acceptat','actiu')";
        newconnection.afegirsql(sql);
    }
    public void modificarPressupost(String id, String nom_cost,Double preu_cost,int quantitat_cost) throws SQLException {

        String sql = "update linia_presupuestos SET nom_cost='"+nom_cost+"',preu_cost='"+preu_cost+"',quantitat_cost='"+quantitat_cost+"' where linia_presupuestos.id="+id;
        newconnection.afegirsql(sql);
    }


    public void esborrarPressupost(String id) throws SQLException {
        String estat = "inactiu";
        String sql = "update linia_presupuestos SET estat='"+estat+"' where linia_presupuestos.id="+id;
        newconnection.afegirsql(sql);
    }



}


