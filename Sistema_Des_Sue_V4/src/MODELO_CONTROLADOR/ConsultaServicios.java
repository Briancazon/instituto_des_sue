
package MODELO_CONTROLADOR;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConsultaServicios {
    
    
    //metodo que nos da los alumnos activos de clases personalizades del actual ciclo_lectivo
      public static ResultSet mostrarClasePersonalizada(Connection cx, int codigo_ciclo_lectivo)throws Exception {
          ResultSet rs=null;
          PreparedStatement stm=cx.prepareStatement("select al.nombre, al.apellido, ser.nombre, ci.año from inscripcion as inc inner join alumno as al on al.codigo=inc.codigo_alumno inner join servicios as ser on ser.codigo=inc.codigo_servicio inner join ciclo_lectivo as ci on ci.codigo=inc.codigo_ciclo_lectivo where ser.nombre='Clases Personalizadas' and inc.estado='ACTIVO'  and inc.codigo_ciclo_lectivo =? order by inc.codigo desc");
          stm.setInt(1, codigo_ciclo_lectivo);
          try{
              rs=stm.executeQuery();
          }catch(SQLException e){
               JOptionPane.showMessageDialog(null,e.getMessage());
          }
          return rs;
      }
    
    
        //metodo que nos da los alumnos activos de apoyo pedagógico del actual ciclo_lectivo
     public static ResultSet mostrarApoyoPedagogico(Connection cx, int codigo_ciclo_lectivo)throws Exception {
          ResultSet rs=null;
          PreparedStatement stm=cx.prepareStatement("select al.nombre, al.apellido, ser.nombre, ci.año from inscripcion as inc inner join alumno as al on al.codigo=inc.codigo_alumno inner join servicios as ser on ser.codigo=inc.codigo_servicio inner join ciclo_lectivo as ci on ci.codigo=inc.codigo_ciclo_lectivo where ser.nombre='Apoyo Pedagógico' and inc.estado='ACTIVO' and inc.codigo_ciclo_lectivo =? order by inc.codigo desc");
          stm.setInt(1, codigo_ciclo_lectivo);
          try{
              rs=stm.executeQuery();
          }catch(SQLException e){
               JOptionPane.showMessageDialog(null,e.getMessage());
          }
          return rs;
      }
    
            //metodo que nos da los alumnos activos de educación temprana del actual ciclo_lectivo
      public static ResultSet mostrarEducacionTemprana(Connection cx, int codigo_ciclo_lectivo)throws Exception {
          ResultSet rs=null;
          PreparedStatement stm=cx.prepareStatement("select al.nombre, al.apellido, ser.nombre, ci.año from inscripcion as inc inner join alumno as al on al.codigo=inc.codigo_alumno inner join servicios as ser on ser.codigo=inc.codigo_servicio inner join ciclo_lectivo as ci on ci.codigo=inc.codigo_ciclo_lectivo where ser.nombre='Educación Temprana' and inc.estado='ACTIVO'  and inc.codigo_ciclo_lectivo =? order by inc.codigo desc");
          stm.setInt(1, codigo_ciclo_lectivo);
          try{
              rs=stm.executeQuery();
          }catch(SQLException e){
               JOptionPane.showMessageDialog(null,e.getMessage());
          }
          return rs;
      }
    
     
     
             //metodo que nos da los alumnos activos de aompañamiento del actual ciclo_lectivo
      public static ResultSet mostrarAcompañamiento(Connection cx, int codigo_ciclo_lectivo)throws Exception {
          ResultSet rs=null;
          PreparedStatement stm=cx.prepareStatement(" select al.nombre, al.apellido, ser.nombre, ci.año from inscripcion as inc inner join alumno as al on al.codigo=inc.codigo_alumno inner join servicios as ser on ser.codigo=inc.codigo_servicio inner join ciclo_lectivo as ci on ci.codigo=inc.codigo_ciclo_lectivo where ser.nombre='Inclusión Escolar: Acompañamiento' and inc.estado='ACTIVO' and inc.codigo_ciclo_lectivo =?  order by inc.codigo desc");
          stm.setInt(1, codigo_ciclo_lectivo);
          try{
              rs=stm.executeQuery();
          }catch(SQLException e){
               JOptionPane.showMessageDialog(null,e.getMessage());
          }
          return rs;
      }
    
               //metodo que nos da los alumnos activos de Itinerancia del actual ciclo_lectivo
          public static ResultSet mostrarItinerancia(Connection cx, int codigo_ciclo_lectivo)throws Exception {
          ResultSet rs=null;
          PreparedStatement stm=cx.prepareStatement("select al.nombre, al.apellido, ser.nombre, ci.año from inscripcion as inc inner join alumno as al on al.codigo=inc.codigo_alumno inner join servicios as ser on ser.codigo=inc.codigo_servicio inner join ciclo_lectivo as ci on ci.codigo=inc.codigo_ciclo_lectivo where ser.nombre='Inclusión Escolar: Itinerancia' and inc.estado='ACTIVO'  and inc.codigo_ciclo_lectivo =? order by inc.codigo desc");
          stm.setInt(1, codigo_ciclo_lectivo);
          try{
              rs=stm.executeQuery();
          }catch(SQLException e){
               JOptionPane.showMessageDialog(null,e.getMessage());
          }
          return rs;
      }
    
     
     
     
     
     
     
    
    
    
}
