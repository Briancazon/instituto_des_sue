
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
        PreparedStatement stm=cx.prepareStatement("SELECT nombre, precio from servicios");
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
     
     ///metodo para ver que dias viene un alumno de servicio de clase personalizada...
     public static ResultSet verDIas(Connection cx, int dni)throws Exception {
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("select inc.dias from inscripcion as inc inner join alumno as al on inc.codigo_alumno=al.codigo where al.dni=? and inc.estado='ACTIVO'");
        stm.setInt(1, dni);
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
          if(codigo_horarios==0){
                PreparedStatement stm=cx.prepareStatement("INSERT INTO inscripcion (codigo_alumno, dias, codigo_horarios, codigo_profesor, codigo_servicio, fecha_inscripcion, codigo_ciclo_lectivo, estado) values (?, ?, null, ?, ?, ?, ?, 'ACTIVO') ");
                stm.setInt(1, codigo_alumno);
                stm.setString(2, dias);
                
                stm.setInt(3, codigo_profesor);
                stm.setInt(4, codigo_servicio);
                stm.setString(5, fecha);
                stm.setInt(6, codigo_ciclo_lectivo);
         
                stm.executeUpdate();
          }else{
                PreparedStatement stm=cx.prepareStatement("INSERT INTO inscripcion (codigo_alumno, dias, codigo_horarios, codigo_profesor, codigo_servicio, fecha_inscripcion, codigo_ciclo_lectivo, estado) values (?, ?, ?, ?, ?, ?, ?, 'ACTIVO') ");
                stm.setInt(1, codigo_alumno);
                stm.setString(2, dias);
                stm.setInt(3, codigo_horarios);
                stm.setInt(4, codigo_profesor);
                stm.setInt(5, codigo_servicio);
                stm.setString(6, fecha);
                stm.setInt(7, codigo_ciclo_lectivo);
         
                stm.executeUpdate();
         
          }
        
          
      }
      
      //metodo que muestra inscripciones tanto activas como inactivas
      public static ResultSet mostrarIncripciones(Connection cx)throws Exception {
          ResultSet rs=null;
          PreparedStatement stm=cx.prepareStatement("select al.nombre, al.apellido, al.dni ,inc.dias, ho.horario, pro.nombre, pro.apellido, pro.dni,  ser.nombre, inc.fecha_inscripcion, ci.año, inc.estado from inscripcion as inc left join alumno as al on al.codigo=inc.codigo_alumno left join horarios as ho on ho.codigo=inc.codigo_horarios left join profesor as pro on pro.codigo=inc.codigo_profesor left join servicios as ser on ser.codigo=inc.codigo_servicio left join ciclo_lectivo as ci on ci.codigo=inc.codigo_ciclo_lectivo order by inc.codigo desc");
         
              rs=stm.executeQuery();
         
          return rs;
      }
      
      
      ///metodo que unicamente mustra las inscripciones activas...
        public static ResultSet mostrarIncripcionesActivas(Connection cx)throws Exception {
          ResultSet rs=null;
          PreparedStatement stm=cx.prepareStatement("select al.nombre, al.apellido, al.dni ,inc.dias, ho.horario, pro.nombre, pro.apellido, ser.nombre, inc.fecha_inscripcion, ci.año, inc.estado from inscripcion as inc inner join alumno as al on al.codigo=inc.codigo_alumno inner join horarios as ho on ho.codigo=inc.codigo_horarios inner join profesor as pro on pro.codigo=inc.codigo_profesor inner join servicios as ser on ser.codigo=inc.codigo_servicio inner join ciclo_lectivo as ci on ci.codigo=inc.codigo_ciclo_lectivo where inc.estado='ACTIVO' order by inc.codigo desc");
          
              rs=stm.executeQuery();
         
          return rs;
      }
      
        ///metodo para buscar la inscripcion de un alummno por nombre(inscripciones tanto activas como inactivas)...
       public static ResultSet buscarAlumnoPorNombre(Connection cx, String nombre)throws Exception{
           ResultSet rs=null;
           PreparedStatement stm=cx.prepareStatement("select al.nombre, al.apellido, al.dni ,inc.dias, ho.horario, pro.nombre, pro.apellido, pro.dni,  ser.nombre, inc.fecha_inscripcion, ci.año, inc.estado from inscripcion as inc left join alumno as al on al.codigo=inc.codigo_alumno left join horarios as ho on ho.codigo=inc.codigo_horarios left join profesor as pro on pro.codigo=inc.codigo_profesor left join servicios as ser on ser.codigo=inc.codigo_servicio left join ciclo_lectivo as ci on ci.codigo=inc.codigo_ciclo_lectivo where al.nombre like ?  order by inc.codigo desc");
           stm.setString(1, "%"+nombre+"%");
           rs=stm.executeQuery();
           return rs;
       }
      
       /// este metodo busca las inscripciones de servicios mensuales y activas
        public static ResultSet mostrarIncripcionesServiciosMensuales(Connection cx)throws Exception {
          ResultSet rs=null;
          PreparedStatement stm=cx.prepareStatement("select al.codigo, al.nombre, al.apellido, al.dni, ser.nombre from inscripcion as inc inner join alumno as al on inc.codigo_alumno=al.codigo inner join servicios as ser on ser.codigo=inc.codigo_servicio inner join modalidad_cobro as mc on mc.codigo=ser.codigo_modalidad_cobro where mc.codigo=1 and inc.estado='ACTIVO' ");
          
              rs=stm.executeQuery();
         
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
        
        
      ///metodo para ver el mes de una incripcion activa, te muestra el mes en numero, por ejemplo enero seria: 1
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
          
          /// metodo para obtener el año de inscripcion de un alumno activo
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
          
          
          //obtener el mes de incripcion de una incripcion a traves del dni, siempre y cuando sea una inscripciona actuva
           public static int obtenerMesInscripcion(Connection cx, int dni)throws Exception {
              ResultSet rs=null;
              int mes=0;
              PreparedStatement stm=cx.prepareStatement("select month(inc.fecha_inscripcion) from inscripcion as inc inner join alumno as al on inc.codigo_alumno=al.codigo where al.dni=? and inc.estado='ACTIVO' ");
              stm.setInt(1, dni);
              try{
                  rs=stm.executeQuery();
                  if(rs.next()){
                      mes=rs.getInt("month(inc.fecha_inscripcion)");
                  }
              }catch(SQLException e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
              }
              return mes;
          }
           
             public static int obtenerDiaInscripcion(Connection cx, int dni)throws Exception {
              ResultSet rs=null;
              int dia=0;
              PreparedStatement stm=cx.prepareStatement("select day(inc.fecha_inscripcion) from inscripcion as inc inner join alumno as al on inc.codigo_alumno=al.codigo where al.dni=? and inc.estado='ACTIVO' ");
              stm.setInt(1, dni);
              try{
                  rs=stm.executeQuery();
                  if(rs.next()){
                      dia=rs.getInt("day(inc.fecha_inscripcion)");
                  }
              }catch(SQLException e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
              }
              return dia;
          }
          
          /// metodo para validar que el usuario no haga una doble inscripcion repetida de forma consecutiva, es decir ,si ya se inscribio el alumno al servicio x de ciclo_lectivo tanto, y quiere de nuevo volver a inscribir con esos mismos valores, el sistema no le permitira hacerlo
          // pero si se inscribi a otro, y depues quiere volver al primero, sí podrá por supuesto, esto solo valida que de forma consecutiva el ususario no vuelva a inscribir al alumno al mismo servicio del mismo ciclo lectivo dos veces de forma seguida,
          public static ResultSet evitarDobleInscripcionConsecutiva(Connection cx, int codigo_alumno, int codigo_servicio, int codigo_ciclo_lectivo)throws Exception{
              ResultSet rs=null;
              PreparedStatement stm=cx.prepareStatement("select * from inscripcion where codigo_alumno=? and codigo_servicio=? and codigo_ciclo_lectivo=? and estado='ACTIVO'");
              stm.setInt(1, codigo_alumno);
              stm.setInt(2, codigo_servicio);
              stm.setInt(3, codigo_ciclo_lectivo);
              try{
                 rs= stm.executeQuery();
              }catch(SQLException e){
                   JOptionPane.showMessageDialog(null,e.getMessage());
              }
              return rs;
          }
          
          
          public static void darBajaInscripcion(Connection cx, int codigo_alumno)throws Exception {
              PreparedStatement stm=cx.prepareStatement("UPDATE inscripcion set estado='INACTIVO' where codigo_alumno=? and estado='ACTIVO' " );
              stm.setInt(1, codigo_alumno);
   
                  stm.executeUpdate();
            
          }
          
          
          //metodo para actualizar algunos campos de una inscripcion activa...
          public static void actualizarInscripcion(Connection cx, String dias, int codigo_horarios,int codigo_profesor, int codigo_alumno)throws Exception{
              if(dias==null && codigo_horarios==0){
                     PreparedStatement stm=cx.prepareStatement("UPDATE inscripcion set codigo_profesor=? where codigo_alumno=? and estado='ACTIVO'");
                    
                      stm.setInt(1, codigo_profesor);
 
                      stm.setInt(2, codigo_alumno);
                      stm.executeUpdate();
              }else{
                      PreparedStatement stm=cx.prepareStatement("UPDATE inscripcion set dias=?, codigo_horarios=?, codigo_profesor=? where codigo_alumno=? and estado='ACTIVO'");
                      stm.setString(1, dias);
                      stm.setInt(2, codigo_horarios);
                      stm.setInt(3, codigo_profesor);
 
                      stm.setInt(4, codigo_alumno);
                      stm.executeUpdate();
              }
              
          }
          
       
          

    }
