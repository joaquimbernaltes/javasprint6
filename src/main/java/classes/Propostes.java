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
public class Propostes {

    /* Connexió BD */
    realitzarConnexio newconnection= new realitzarConnexio();
    public void inserirProposta(String nom, String motiu, String descripio) throws SQLException {
        String sql = "insert into propuestas (id_empresa, id_institut, id_categoria, id_responsable, nom, descripcio, requeriments, estimacio_economica, estat_Proposta, motiu, estat) values('"+1+"','"+1+"','"+1+"','"+1+"' ,'" +nom+ "', '"+descripio+"' ,'Requeriment minim','1000','Disponible','"+motiu+"','actiu')";
        newconnection.afegirsql(sql);
    }
    public void modificarProposta(String id, String nom,String descripcio ,String motiu) throws SQLException {
        String sql = "update propuestas SET nom='"+nom+"',descripcio='"+descripcio+"',motiu='"+motiu+"' where propuestas.id="+id;
        newconnection.afegirsql(sql);
    }


    public void esborrarProposta(String id) throws SQLException {
        String estat = "inactiu";
        String sql = "update propuestas SET estat='"+estat+"' where propuestas.id="+id;
        newconnection.afegirsql(sql);
    }
}
