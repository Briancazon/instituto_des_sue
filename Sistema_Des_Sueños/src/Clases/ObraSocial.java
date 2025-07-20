
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
    
        
   
    
       public static ResultSet mostrarObrasSociales(Connection cx)throws SQLException{
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("SELECT codigo,nombre from obra_social");
      
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
    
    
 
       public static int obtenerCodigo(Connection cx, String nombre) throws Exception{
           ResultSet rs=null;
           int codigo=0;
           PreparedStatement stm=cx.prepareStatement("SELECT codigo from obra_social where nombre=?");
           stm.setString(1, nombre) ;
           try{
               rs=stm.executeQuery();
                if(rs.next()){
                    codigo=rs.getInt("codigo");
                }
           }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,e.getMessage());
           }
           
           return codigo;
           
           }

    
}
