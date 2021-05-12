package classes;

import config.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ximo
 */
public class Projectes {
    
    RealitzarConnexio newconnection= new RealitzarConnexio();
    
    public void inserirProjecte(String nom, String data) throws SQLException {
        String sql = "insert into proyectos (id_proposta, nom_projecte, estat) values ('"+1+"','"+nom+"','actiu')";
        newconnection.afegirsql(sql);
    }
    
    
    public void modificarprojecte(String id,  String nom, String data) throws SQLException {
        String sql = "update proyectos SET nom_projecte='"+nom+"',data_inici='"+data+"' where proyectos.id="+id;
        newconnection.afegirsql(sql);
    }
    
    
    public void esborrarprojecte(String id,  String nom, String data) throws SQLException {
        String estat = "inactiu";
        String sql = "update proyectos SET estat='"+estat+"' where proyectos.id="+id;
        newconnection.afegirsql(sql);
    }
}
