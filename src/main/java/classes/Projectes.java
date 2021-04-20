/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import config.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alumne
 */
public class Projectes {
    
    RealitzarConnexio newconnection= new RealitzarConnexio();
    
    public void inserirProjecte(String nom, String data) throws SQLException {
           // Projecte m = new Projecte(contador + 1, nom, descripcio, proposta);
            String sql = "insert into proyectos (id_proposta, nom_projecte, estat) values ('"+1+"','"+nom+"','actiu')";
            newconnection.afegirsql(sql);
    }
    
    
    public void modificarprojecte(String id,  String nom, String data) throws SQLException {
           // Projecte m = new Projecte(contador + 1, nom, descripcio, proposta);
            String sql = "insert into proyectos (id_proposta, nom_projecte, estat) values ('"+1+"','"+nom+"','actiu')";
            newconnection.afegirsql(sql);
    }
    

}
