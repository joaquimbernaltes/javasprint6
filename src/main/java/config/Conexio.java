package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Conexio {
    Connection con;
    public Conexio(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Intentar fer la conexió
            String user = "root";
            String psswd = "Alumne1234";
            String URL = "jdbc:mysql://localhost:3306/proiectussprint4";
            con=DriverManager.getConnection(URL,user,psswd);
            JOptionPane.showMessageDialog(null, "Connexió realitzada");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error connexió " + e.getMessage());
        }
    }
    public Connection getConnection(){
        return con;
    }

    public PreparedStatement prepareStatement(String SQL) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
