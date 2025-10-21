
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
    
    ///este metodo busca a los alumnos (por nombre o apellido o por los dos) que tienen servicios mensuales, ya que sera utilizado en aistencias, recordando que en asistencias solo se  registran las asistencias de los servicios mensuales
     public static ResultSet buscarAlumnoServiciosMensuales(Connection cx, String nombre, String apellido)throws Exception{
        ResultSet rs=null;
        if(apellido.isEmpty()){
            PreparedStatement stm=cx.prepareStatement("select al.codigo, al.nombre, al.apellido, al.dni, ser.nombre from inscripcion as inc inner join alumno as al on inc.codigo_alumno=al.codigo inner join servicios as ser on inc.codigo_servicio=ser.codigo inner join modalidad_cobro as mc on ser.codigo_modalidad_cobro=mc.codigo where mc.codigo=1 and inc.estado='ACTIVO' and al.nombre like ?");
            stm.setString(1, "%"+nombre+"%");
            try{
               rs= stm.executeQuery();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }else{
            if(nombre.isEmpty()){
                  PreparedStatement stm=cx.prepareStatement("select al.codigo, al.nombre, al.apellido, al.dni, ser.nombre from inscripcion as inc inner join alumno as al on inc.codigo_alumno=al.codigo inner join servicios as ser on inc.codigo_servicio=ser.codigo inner join modalidad_cobro as mc on ser.codigo_modalidad_cobro=mc.codigo where mc.codigo=1 and inc.estado='ACTIVO' and al.apellido like ?");
                  stm.setString(1, "%"+apellido+"%");
                 try{
                   rs=stm.executeQuery();
                 }catch(SQLException e){
                  JOptionPane.showMessageDialog(null,e.getMessage());
                 }
            }else{
                  PreparedStatement stm=cx.prepareStatement("select al.codigo, al.nombre, al.apellido, al.dni, ser.nombre from inscripcion as inc inner join alumno as al on inc.codigo_alumno=al.codigo inner join servicios as ser on inc.codigo_servicio=ser.codigo inner join modalidad_cobro as mc on ser.codigo_modalidad_cobro=mc.codigo where mc.codigo=1 and inc.estado='ACTIVO' and al.nombre like ? and al.apellido like ?");
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
     
     /// este método busca los alumnos con servicios mensuales o clases personalizadas, se ejecutará cuando quieran buscar un alumno para pagar un servicio, ahi entra este metodo, para buscar y a su vez validar que solo devolverá aquellos alumnos que unicamente tengasn
     // esos dos servicios ya mencionadas, ya que , recordemos que solo esos servicios se pagan, los de inclusion escolar no entran en el sistema de pagos, de ahi el propósito de este método
      public static ResultSet buscarAlumnoServiciosMensualesYClases(Connection cx, String nombre, String apellido)throws Exception{
        ResultSet rs=null;
        if(apellido.isEmpty()){
            PreparedStatement stm=cx.prepareStatement("select al.codigo, al.nombre, al.apellido, al.dni, ser.nombre from inscripcion as inc inner join alumno as al on inc.codigo_alumno=al.codigo inner join servicios as ser on inc.codigo_servicio=ser.codigo inner join modalidad_cobro as mc on ser.codigo_modalidad_cobro=mc.codigo where (mc.codigo=1 or mc.codigo=2) and inc.estado='ACTIVO' and al.nombre like ?");
            stm.setString(1, "%"+nombre+"%");
            try{
               rs= stm.executeQuery();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
        }else{
            if(nombre.isEmpty()){
                  PreparedStatement stm=cx.prepareStatement("select al.codigo, al.nombre, al.apellido, al.dni, ser.nombre from inscripcion as inc inner join alumno as al on inc.codigo_alumno=al.codigo inner join servicios as ser on inc.codigo_servicio=ser.codigo inner join modalidad_cobro as mc on ser.codigo_modalidad_cobro=mc.codigo where (mc.codigo=1 or mc.codigo=2) and inc.estado='ACTIVO' and al.apellido like ?");
                  stm.setString(1, "%"+apellido+"%");
                 try{
                   rs=stm.executeQuery();
                 }catch(SQLException e){
                  JOptionPane.showMessageDialog(null,e.getMessage());
                 }
            }else{
                  PreparedStatement stm=cx.prepareStatement("select al.codigo, al.nombre, al.apellido, al.dni, ser.nombre from inscripcion as inc inner join alumno as al on inc.codigo_alumno=al.codigo inner join servicios as ser on inc.codigo_servicio=ser.codigo inner join modalidad_cobro as mc on ser.codigo_modalidad_cobro=mc.codigo where (mc.codigo=1 or mc.codigo=2) and inc.estado='ACTIVO' and al.nombre like ? and al.apellido like ?");
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
      
      
      //metodo para obtener el  codigo del ciclo lectivo en el que se encuentran actuamente
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
      
      
      /// este metodo obtiene el codigo del ciclo lectivo a traves del codigo de una inscripcion
       public static int obtenerCodigoCLPorInscripcion(Connection cx, int codigo_inscripcion)throws Exception {
         ResultSet rs=null;
         int codigo=0;
         PreparedStatement stm=cx.prepareStatement("select codigo_ciclo_lectivo from inscripcion where codigo=? and estado='ACTIVO' " );
         stm.setInt(1, codigo_inscripcion);
        
         try{
             rs=stm.executeQuery();
             while(rs.next())
                 codigo=rs.getInt("codigo_ciclo_lectivo");
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
      
       /// este metodo busca las inscripciones de servicios mensuales y activas
        public static ResultSet mostrarIncripcionesServiciosMensuales(Connection cx)throws Exception {
          ResultSet rs=null;
          PreparedStatement stm=cx.prepareStatement("select al.codigo, al.nombre, al.apellido, al.dni, ser.nombre from inscripcion as inc inner join alumno as al on inc.codigo_alumno=al.codigo inner join servicios as ser on ser.codigo=inc.codigo_servicio inner join modalidad_cobro as mc on mc.codigo=ser.codigo_modalidad_cobro where mc.codigo=1 and inc.estado='ACTIVO' ");
          try{
              rs=stm.executeQuery();
          }catch(SQLException e){
               JOptionPane.showMessageDialog(null,e.getMessage());
          }
          return rs;
      }
        
         /// este metodo busca las inscripciones activas de servicios mensuales y clases personalizadas , osea todos los servicios menos los de inclusion escolar
        public static ResultSet mostrarIncripcionesServiciosMensualesYClases(Connection cx)throws Exception {
          ResultSet rs=null;
          PreparedStatement stm=cx.prepareStatement("select al.codigo, al.nombre, al.apellido, al.dni, ser.nombre from inscripcion as inc inner join alumno as al on inc.codigo_alumno=al.codigo inner join servicios as ser on ser.codigo=inc.codigo_servicio inner join modalidad_cobro as mc on mc.codigo=ser.codigo_modalidad_cobro where (mc.codigo=1 or mc.codigo=2) and inc.estado='ACTIVO'");
          try{
              rs=stm.executeQuery();
          }catch(SQLException e){
               JOptionPane.showMessageDialog(null,e.getMessage());
          }
          return rs;
      }
        
        
      
      public static int verMesInscripcion(Connection cx, int codigo_inscripcion)throws Exception{
          int mes=0;
          ResultSet rs=null;
          PreparedStatement stm=cx.prepareStatement(" select month(fecha_inscripcion) from inscripcion where codigo=? and estado='ACTIVO' ");
          stm.setInt(1, codigo_inscripcion);
          try{
             rs= stm.executeQuery();
             if(rs.next())
                 mes=rs.getInt("month(fecha_inscripcion)");
          }catch(SQLException e){
               JOptionPane.showMessageDialog(null,e.getMessage());
          }
          return mes;
         
      }
          // este metodo busca ek codigo de inscripcion de un alumno a traves del codigo_alumno, es decir, busca la inscripcion actual que tiene el alumno 
          public static int buscarCodigo(Connection cx, int codigo_alumno)throws Exception {
              ResultSet rs=null;
              int codigo=0;
              PreparedStatement stm=cx.prepareStatement("select codigo from inscripcion where codigo_alumno = ? and estado='ACTIVO' ");
              stm.setInt(1, codigo_alumno);
              try{
                  rs=stm.executeQuery();
                  if(rs.next())
                      codigo=rs.getInt("codigo");
              }catch(SQLException e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
              }
              return codigo;
        
    }
          
          /// metodo para obtener el año de inscripcion de un alumno,  
          public static int obtenerAñoInscripcion(Connection cx, int dni)throws Exception {
              ResultSet rs=null;
              int año=0;
              PreparedStatement stm=cx.prepareStatement("select cl.año from inscripcion as inc inner join ciclo_lectivo as cl on inc.codigo_ciclo_lectivo=cl.codigo inner join alumno as al on inc.codigo_alumno=al.codigo where al.dni=? and inc.estado='ACTIVO'");
              stm.setInt(1, dni);
              try{
                  rs=stm.executeQuery();
                  if(rs.next()){
                      año=rs.getInt("cl.año");
                  }
              }catch(SQLException e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
              }
              return año;
          }

    }
