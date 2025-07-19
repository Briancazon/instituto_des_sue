
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ObraSocial {
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
       public static ResultSet mostrarObrasSociales(Connection cx)throws SQLException{
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("SELECT nombre from obra_social");
        
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
