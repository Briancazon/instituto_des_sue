
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ObraSocial {
    public static void cargar(Connection cx, String nombre )throws Exception {
        PreparedStatement stm=cx.prepareStatement("INSERT INTO obra_social (nombre, borrado) values (?, 0)");
        stm.setString(1, nombre);
        
        try{
           stm.executeUpdate();
        }catch(SQLException e){
            
        }
              
    }
    
     public static ResultSet mostrarOS(Connection cx)throws Exception{
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("SELECT codigo, nombre FROM obra_social");
        try{
            rs=stm.executeQuery();
        }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    }
       
     public static ResultSet buscarOS(Connection cx, String nom)throws Exception{
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("select codigo, nombre from obra_social where nombre= ? ");
        stm.setString(1, nom);
        try{
            rs=stm.executeQuery();
        }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    }
    
    
    
    
}
