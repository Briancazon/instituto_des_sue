
package MODELO_CONTROLADOR;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConsultaServicios {
    
      public static ResultSet mostrarClasePersonalizada(Connection cx)throws Exception {
          ResultSet rs=null;
          PreparedStatement stm=cx.prepareStatement("select al.nombre, al.apellido, ser.nombre, ci.año from inscripcion as inc inner join alumno as al on al.codigo=inc.codigo_alumno inner join servicios as ser on ser.codigo=inc.codigo_servicio inner join ciclo_lectivo as ci on ci.codigo=inc.codigo_ciclo_lectivo where ser.nombre='Clases Personalizadas' and inc.estado='ACTIVO' order by inc.codigo desc; ");
          try{
              rs=stm.executeQuery();
          }catch(SQLException e){
               JOptionPane.showMessageDialog(null,e.getMessage());
          }
          return rs;
      }
    
    
    
     public static ResultSet mostrarApoyoPedagogico(Connection cx)throws Exception {
          ResultSet rs=null;
          PreparedStatement stm=cx.prepareStatement("select al.nombre, al.apellido, ser.nombre, ci.año from inscripcion as inc inner join alumno as al on al.codigo=inc.codigo_alumno inner join servicios as ser on ser.codigo=inc.codigo_servicio inner join ciclo_lectivo as ci on ci.codigo=inc.codigo_ciclo_lectivo where ser.nombre='Apoyo Pedagógico' and inc.estado='ACTIVO' order by inc.codigo desc;");
          try{
              rs=stm.executeQuery();
          }catch(SQLException e){
               JOptionPane.showMessageDialog(null,e.getMessage());
          }
          return rs;
      }
    
    
      public static ResultSet mostrarEducacionTemprana(Connection cx)throws Exception {
          ResultSet rs=null;
          PreparedStatement stm=cx.prepareStatement("select al.nombre, al.apellido, ser.nombre, ci.año from inscripcion as inc inner join alumno as al on al.codigo=inc.codigo_alumno inner join servicios as ser on ser.codigo=inc.codigo_servicio inner join ciclo_lectivo as ci on ci.codigo=inc.codigo_ciclo_lectivo where ser.nombre='Educación Temprana' and inc.estado='ACTIVO' order by inc.codigo desc; ");
          try{
              rs=stm.executeQuery();
          }catch(SQLException e){
               JOptionPane.showMessageDialog(null,e.getMessage());
          }
          return rs;
      }
    
     
     
     
      public static ResultSet mostrarAcompañamiento(Connection cx)throws Exception {
          ResultSet rs=null;
          PreparedStatement stm=cx.prepareStatement(" select al.nombre, al.apellido, ser.nombre, ci.año from inscripcion as inc inner join alumno as al on al.codigo=inc.codigo_alumno inner join servicios as ser on ser.codigo=inc.codigo_servicio inner join ciclo_lectivo as ci on ci.codigo=inc.codigo_ciclo_lectivo where ser.nombre='Inclusión Escolar: Acompañamiento' and inc.estado='ACTIVO' order by inc.codigo desc;");
          try{
              rs=stm.executeQuery();
          }catch(SQLException e){
               JOptionPane.showMessageDialog(null,e.getMessage());
          }
          return rs;
      }
    
     
          public static ResultSet mostrarItinerancia(Connection cx)throws Exception {
          ResultSet rs=null;
          PreparedStatement stm=cx.prepareStatement("select al.nombre, al.apellido, ser.nombre, ci.año from inscripcion as inc inner join alumno as al on al.codigo=inc.codigo_alumno inner join servicios as ser on ser.codigo=inc.codigo_servicio inner join ciclo_lectivo as ci on ci.codigo=inc.codigo_ciclo_lectivo where ser.nombre='Inclusión Escolar: Itinerancia' and inc.estado='ACTIVO' order by inc.codigo desc;");
          try{
              rs=stm.executeQuery();
          }catch(SQLException e){
               JOptionPane.showMessageDialog(null,e.getMessage());
          }
          return rs;
      }
    
     
     
     
     
     
     
    
    
    
}
