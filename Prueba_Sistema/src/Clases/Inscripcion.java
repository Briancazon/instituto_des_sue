
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Inscripcion {
    
    public static ResultSet buscarAlumno(Connection cx, String nombre, String apellido)throws Exception{
        ResultSet rs=null;
        if(apellido.isEmpty()){
            PreparedStatement stm=cx.prepareStatement("SELECT codigo, nombre, apellido, dni from alumno where nombre like ? and borrado=0");
            stm.setString(1, "%"+nombre+"%");
            try{
               rs= stm.executeQuery();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }else{
            if(nombre.isEmpty()){
                  PreparedStatement stm=cx.prepareStatement("SELECT codigo, nombre, apellido, dni from alumno where apellido like ? and borrado=0");
                  stm.setString(1, "%"+apellido+"%");
                 try{
                   rs=stm.executeQuery();
                 }catch(SQLException e){
                  JOptionPane.showMessageDialog(null,e.getMessage());
                 }
            }else{
                  PreparedStatement stm=cx.prepareStatement("SELECT codigo, nombre, apellido, dni from alumno where (nombre like ? and apellido like ?) and borrado=0");
                  stm.setString(1, "%"+nombre+"%");
                  stm.setString(2, "%"+apellido+"%");
                   try{
                     rs=stm.executeQuery();
                    }catch(SQLException e){
                        JOptionPane.showMessageDialog(null,e.getMessage());
                    }
            }
        }
        return rs;
        
    }
    
    
   public static ResultSet buscarProfesor(Connection cx, String nombre, String apellido)throws Exception {
      ResultSet rs=null;
      if(apellido.isEmpty()){
           PreparedStatement stm=cx.prepareStatement("SELECT codigo, nombre, apellido, dni from profesor where nombre like ? and borrado=0");
           stm.setString(1, "%"+nombre+"%");
           try{
               rs=stm.executeQuery();
           }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e.getMessage());
           }
      }else{
           if(nombre.isEmpty()){
                PreparedStatement stm=cx.prepareStatement("SELECT codigo, nombre, apellido, dni from profesor where apellido like ? and borrado=0");
                stm.setString(1, apellido);
                try{
                  rs=  stm.executeQuery();
                }catch(SQLException e){
                     JOptionPane.showMessageDialog(null,e.getMessage());
                }
           }else{
                 PreparedStatement stm=cx.prepareStatement("SELECT codigo, nombre, apellido, dni from profesor where nombre like ? and apellido like ? and borrado=0");
                 stm.setString(1, "%"+nombre+"%");
                 try{
                     rs=stm.executeQuery();
                 }catch(SQLException e){
                      JOptionPane.showMessageDialog(null,e.getMessage());
                 }
           }
      }
      return rs;
   }
    
    
    
    public static ResultSet verServicios(Connection cx)throws Exception {
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("SELECT nombre from servicios");
        try{
            rs=stm.executeQuery();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    }
    
     public static ResultSet verHorarios(Connection cx)throws Exception {
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("SELECT horario  from horarios");
        try{
            rs=stm.executeQuery();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    }
     
     
     
     public static int obtenerCodigoServicio(Connection cx, String nombre)throws Exception {
         ResultSet rs=null;
         int codigo=0;
         PreparedStatement stm=cx.prepareStatement("SELECT codigo from servicios where nombre=?");
         stm.setString(1, nombre);
         try{
             rs=stm.executeQuery();
             while(rs.next())
                 codigo=rs.getInt("codigo");
         }catch(SQLException e){
             JOptionPane.showMessageDialog(null,e.getMessage());
         }
         return codigo;
     }
     
      public static int obtenerCodigoHorario(Connection cx, String horario)throws Exception {
         ResultSet rs=null;
         int codigo=0;
         PreparedStatement stm=cx.prepareStatement("SELECT codigo from horarios where horario=?");
         stm.setString(1, horario);
         try{
             rs=stm.executeQuery();
             while(rs.next())
                 codigo=rs.getInt("codigo");
         }catch(SQLException e){
             JOptionPane.showMessageDialog(null,e.getMessage());
         }
         return codigo;
     }
      
      public static int obtenerCodigoCicloLectivo(Connection cx)throws Exception {
         ResultSet rs=null;
         int codigo=0;
         PreparedStatement stm=cx.prepareStatement("SELECT codigo from ciclo_lectivo order by codigo desc limit 1");
        
         try{
             rs=stm.executeQuery();
             while(rs.next())
                 codigo=rs.getInt("codigo");
         }catch(SQLException e){
             JOptionPane.showMessageDialog(null,e.getMessage());
         }
         return codigo;
     }
      
      
      
      public static void insertarInscripcion(Connection cx, int codigo_alumno, String dias, int codigo_horarios, int codigo_profesor, int codigo_servicio, String fecha, int codigo_ciclo_lectivo )throws Exception{
          PreparedStatement stm=cx.prepareStatement("INSERT INTO inscripcion (codigo_alumno, dias, codigo_horarios, codigo_profesor, codigo_servicio, fecha_inscripcion, codigo_ciclo_lectivo, estado) values (?, ?, ?, ?, ?, ?, ?, 'ACTIVO') ");
          stm.setInt(1, codigo_alumno);
          stm.setString(2, dias);
          stm.setInt(3, codigo_horarios);
          stm.setInt(4, codigo_profesor);
          stm.setInt(5, codigo_servicio);
          stm.setString(6, fecha);
          stm.setInt(7, codigo_ciclo_lectivo);
          try{
              stm.executeUpdate();
          }catch(SQLException e){
               JOptionPane.showMessageDialog(null,e.getMessage());
          }
          
      }
      
      public static ResultSet mostrarIncripciones(Connection cx)throws Exception {
          ResultSet rs=null;
          PreparedStatement stm=cx.prepareStatement("select al.nombre, al.apellido, inc.dias, ho.horario, pro.nombre, pro.apellido, ser.nombre, inc.fecha_inscripcion, ci.año, inc.estado from inscripcion as inc inner join alumno as al on al.codigo=inc.codigo_alumno inner join horarios as ho on ho.codigo=inc.codigo_horarios inner join profesor as pro on pro.codigo=inc.codigo_profesor inner join servicios as ser on ser.codigo=inc.codigo_servicio inner join ciclo_lectivo as ci on ci.codigo=inc.codigo_ciclo_lectivo order by inc.codigo desc");
          try{
              rs=stm.executeQuery();
          }catch(SQLException e){
               JOptionPane.showMessageDialog(null,e.getMessage());
          }
          return rs;
      }

    }
