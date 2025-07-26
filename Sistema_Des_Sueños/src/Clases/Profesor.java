
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Profesor {
    
     public static void cargar(Connection cx, String nombre, String apellido, int dni, String residencia, String titulo )throws Exception {
        PreparedStatement stm=cx.prepareStatement("INSERT INTO profesor (nombre, apellido, dni, residencia, titulo, borado) values (?, ?, ?, ?, ?, 0)");
        stm.setString(1, nombre);
        stm.setString(2, apellido );
        stm.setInt(3, dni);
        stm.setString(4, residencia);
        stm.setString(5,titulo);
        
        try{
           stm.executeUpdate();
        }catch(SQLException e){
           
        
        }
            
            
    }
      public static ResultSet mostrarProfesor(Connection cx)throws Exception{
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("SELECT nombre, apellido, dni, residencia,titulo FROM profesor");
        try{
            rs=stm.executeQuery();
        }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    }
     
    
      public static ResultSet buscarProfesor(Connection cx, int dni)throws Exception{
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("SELECT nombre, apellido, dni, residencia,titulo FROM profesor where dni=?");
        stm.setInt(1, dni);
        try{
            rs=stm.executeQuery();
        }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    }
     
      public static void modificarProfe(Connection cx, String nombre, String apellido, int dni, String residencia, String titulo)throws Exception{
          PreparedStatement stm=cx.prepareStatement("update profesor set nombre=?, apellido=?, residencia=?, titulo=? where dni=?");
          stm.setString(1, nombre);
          stm.setString(2, apellido);
          stm.setString(3,residencia);
          stm.setString(4,titulo);
          stm.setInt(5,dni);
          
          
          try{
              stm.executeUpdate();
          }catch(SQLException e){
               JOptionPane.showMessageDialog(null,e.getMessage());
          }
          
      }
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
