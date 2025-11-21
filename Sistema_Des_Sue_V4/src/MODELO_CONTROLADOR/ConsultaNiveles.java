
package MODELO_CONTROLADOR;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConsultaNiveles {
    
    
     public static ResultSet mostrarInicial(Connection cx)throws Exception {
          ResultSet rs=null;
          PreparedStatement stm=cx.prepareStatement(" select nombre, apellido, grado, nivel from alumno where nivel='Inicial' and borrado= 0 ; ");
          try{
              rs=stm.executeQuery();
          }catch(SQLException e){
               JOptionPane.showMessageDialog(null,e.getMessage());
          }
          return rs;
      }
    
    
    
         public static ResultSet mostrarPrimario(Connection cx)throws Exception {
          ResultSet rs=null;
          PreparedStatement stm=cx.prepareStatement(" select nombre, apellido, grado, nivel from alumno where nivel='Primario' and borrado= 0 ; ");
          try{
              rs=stm.executeQuery();
          }catch(SQLException e){
               JOptionPane.showMessageDialog(null,e.getMessage());
          }
          return rs;
      }
    
    
    
    
         public static ResultSet mostrarSecundario(Connection cx)throws Exception {
          ResultSet rs=null;
          PreparedStatement stm=cx.prepareStatement(" select nombre, apellido, grado, nivel from alumno where nivel='Secundario' and borrado= 0 ; ");
          try{
              rs=stm.executeQuery();
          }catch(SQLException e){
               JOptionPane.showMessageDialog(null,e.getMessage());
          }
          return rs;
      }
    
    
    
    
    
    

}
