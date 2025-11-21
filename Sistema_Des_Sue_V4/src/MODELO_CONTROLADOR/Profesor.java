
package MODELO_CONTROLADOR;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Profesor {
     public static void cargar(Connection cx, String nombre, String apellido, int dni, String residencia, String titulo )throws Exception {
        PreparedStatement stm=cx.prepareStatement("INSERT INTO profesor (nombre, apellido, dni, residencia, titulo, borrado) values (?, ?, ?, ?, ?, 0)");
        stm.setString(1, nombre);
        stm.setString(2, apellido );
        stm.setInt(3, dni);
        stm.setString(4, residencia);
        stm.setString(5,titulo);
        
       
           stm.executeUpdate();        
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
     
    
      public static ResultSet buscarProfesor(Connection cx, String nombre)throws Exception{
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("SELECT nombre, apellido, dni, residencia,titulo FROM profesor where nombre like ? and borrado=0 order by codigo desc");
        stm.setString(1, "%"+nombre+"%");
        try{
            rs=stm.executeQuery();
        }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    }
     
      public static void modificarProfe(Connection cx, String nombre, String apellido, int dni, String residencia, String titulo, int codigo)throws Exception{
          PreparedStatement stm=cx.prepareStatement("update profesor set nombre=?, apellido=?, dni=?, residencia=?, titulo=? where codigo=?");
          stm.setString(1, nombre);
          stm.setString(2, apellido);
          stm.setInt(3,dni);
          stm.setString(4,residencia);
          stm.setString(5,titulo);
          stm.setInt(6,codigo);
          
  
              stm.executeUpdate();
         
          
      }
       public static int buscarCodigo(Connection cx, int dni)throws Exception{
        ResultSet rs=null;
         int codigo=0;
        PreparedStatement stm=cx.prepareStatement("SELECT codigo from profesor where dni=?");
        stm.setInt(1, dni);
        try{
            rs=stm.executeQuery();
            while(rs.next()) 
                codigo=rs.getInt("codigo");
            
        }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return codigo;
    }
     
    public static ResultSet mostrarprofesoresactivos(Connection cx)throws SQLException{
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("SELECT codigo, nombre, apellido, dni, residencia, titulo, borrado from profesor where borrado=0 order by codigo desc");
      
        try{
            rs=stm.executeQuery();
        }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
        
    }
    
     public static ResultSet mostrarprofesoresinactivos(Connection cx)throws SQLException{
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("SELECT nombre, apellido, dni, residencia, titulo from profesor where borrado=1");
      
        try{
            rs=stm.executeQuery();
        }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
        
    }
    
    
     public static void eliminar(Connection cx, int codigo)throws Exception{
           PreparedStatement stm=cx.prepareStatement("UPDATE profesor set borrado= 1 where codigo=?");
           stm.setInt(1, codigo);
           try{
               stm.executeUpdate();
           }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e.getMessage());
           }
       }
    
   public static void habilitarP(Connection cx, int codigo) throws Exception{
         PreparedStatement stm=cx.prepareStatement("UPDATE profesor set borrado= 0 where codigo=?");
           stm.setInt(1, codigo);
           try{
               stm.executeUpdate();
           }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e.getMessage());
           } 
       
   }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
}
