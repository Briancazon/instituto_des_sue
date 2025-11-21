
package MODELO_CONTROLADOR;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Alumno {
    public static void cargar(Connection cx, String nombre, String apellido, String fecha_nac, int dni, String escuela, String grado, String nivel, int obra_social )throws Exception {
        if(obra_social==0){
               PreparedStatement stm=cx.prepareStatement("INSERT INTO alumno (nombre, apellido, fecha_nac, dni, escuela, grado, nivel, obra_social, borrado) values (?, ?, ?, ?, ?, ?, ?, null, 0)");
               stm.setString(1, nombre);
               stm.setString(2, apellido );
               stm.setString(3, fecha_nac);
               stm.setInt(4, dni);
               stm.setString(5, escuela);
               stm.setString(6, grado);
               stm.setString(7, nivel);
            
       
                       stm.executeUpdate();
               
        }else{
                 PreparedStatement stm=cx.prepareStatement("INSERT INTO alumno (nombre, apellido, fecha_nac, dni, escuela, grado, nivel, obra_social, borrado) values (?, ?, ?, ?, ?, ?, ?, ?, 0)");
                 stm.setString(1, nombre);
                 stm.setString(2, apellido );
                 stm.setString(3, fecha_nac);
                 stm.setInt(4, dni);
                 stm.setString(5, escuela);
                 stm.setString(6, grado);
                 stm.setString(7, nivel);
                 stm.setInt(8, obra_social);
        
                       stm.executeUpdate();
              
        }     
            
    }
    
    
    public static void cargarAlumnoTutor(Connection cx, int codigoAlumno, int codigoTutor, String parentesco)throws Exception{
        PreparedStatement stm=cx.prepareStatement("INSERT INTO alumno_tutor (codigo_alumno, codigo_tutor, parentesco) VALUES (?, ?, ?)");
        stm.setInt(1, codigoAlumno);
        stm.setInt(2, codigoTutor);
        stm.setString(3, parentesco);
        
            stm.executeUpdate();
      
    }
    
    public static int obtenerCodigo(Connection cx, int dni)throws Exception{
          ResultSet rs=null;
          int codigo=0;
          PreparedStatement stm=cx.prepareStatement("SELECT codigo from alumno where dni=? ");
          stm.setInt(1, dni);
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
    
    
   
    
    public static int obtenerDni(Connection cx, int codigo)throws Exception{
          ResultSet rs=null;
          int dni=0;
          PreparedStatement stm=cx.prepareStatement("SELECT dni from alumno where codigo=? and borrado=0");
          stm.setInt(1, codigo);
          try{
              rs=stm.executeQuery();
              if(rs.next()){
                  dni=rs.getInt("dni");
              }
          }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e.getMessage());
          }
          
          return dni;
              
      }
    
    public static ResultSet mostrarAlumnos(Connection cx)throws Exception{
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement(" SELECT al.codigo, al.nombre, al.apellido, al.borrado, al.fecha_nac, al.dni, al.escuela, al.grado, al.nivel, os.nombre, t.nombre, t.apellido, t.telefono, at.parentesco from alumno as al left join obra_social as os on os.codigo=al.obra_social left join alumno_tutor as at on at.codigo_alumno=al.codigo left join tutor as t on t.codigo=at.codigo_tutor  where al.borrado=0 order by al.codigo desc");
        try{
            rs=stm.executeQuery();
        }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    } 
    
    
     public static void eliminar(Connection cx, int codigo)throws Exception{
          PreparedStatement stm=cx.prepareStatement("UPDATE alumno set borrado= 1 where codigo = ?");
          stm.setInt(1, codigo);
          try{
              stm.executeUpdate();
          }catch(SQLException e){
               JOptionPane.showMessageDialog(null,e.getMessage());
          }
      } 
      
        
     public static void HabilitarA(Connection cx, int codigo)throws Exception{
          PreparedStatement stm=cx.prepareStatement("UPDATE alumno set borrado= 0 where codigo = ?");
          stm.setInt(1, codigo);
          try{
              stm.executeUpdate();
          }catch(SQLException e){
               JOptionPane.showMessageDialog(null,e.getMessage());
          }
      } 
      
     
    public static ResultSet mostrarAlumnosInactivo(Connection cx)throws Exception{
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement(" SELECT al.nombre, al.apellido, al.fecha_nac, al.dni, al.escuela, al.grado, al.nivel, os.nombre, t.nombre, t.apellido, t.telefono ,at.parentesco from alumno as al left join obra_social as os on os.codigo=al.obra_social left join alumno_tutor as at on at.codigo_alumno=al.codigo left join tutor as t on t.codigo=at.codigo_tutor  where al.borrado=1");
        try{
            rs=stm.executeQuery();
        }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    } 
    
    public static ResultSet buscarAlumno(Connection cx, String nombre)throws Exception{
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement(" SELECT al.nombre, al.apellido, al.fecha_nac, al.dni, al.escuela, al.grado, al.nivel, os.nombre, t.nombre, t.apellido, t.telefono, at.parentesco from alumno as al left join obra_social as os on os.codigo=al.obra_social left join alumno_tutor as at on at.codigo_alumno=al.codigo left join tutor as t on t.codigo=at.codigo_tutor  where al.nombre like ? and al.borrado=0 order by al.codigo desc");
        stm.setString(1, "%"+nombre+"%");
        try{
            rs=stm.executeQuery();
        }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    }
    
      
      public static void actualizarAlumno(Connection cx, String nombre, String apellido, String fecha_nac, int dni, String escuela, String grado, String nivel, int obra_social, int codigo)throws Exception{
          if (obra_social==0){
                PreparedStatement stm=cx.prepareStatement("update alumno set nombre= ?, apellido=?, fecha_nac=?, dni=?, escuela=?, grado=?, nivel=?, obra_social=null where codigo=?");
                stm.setString(1, nombre);
                stm.setString(2, apellido);
                stm.setString(3, fecha_nac);
                stm.setInt(4, dni);
                stm.setString(5, escuela);
                stm.setString(6, grado);
                stm.setString(7, nivel);
                stm.setInt(8, codigo);
          
        
                       stm.executeUpdate();
                
          }else{
                  PreparedStatement stm=cx.prepareStatement("update alumno set nombre= ?, apellido=?, fecha_nac=?, dni=?, escuela=?, grado=?, nivel=?, obra_social=? where codigo=?");
                  stm.setString(1, nombre);
                  stm.setString(2, apellido);
                  stm.setString(3, fecha_nac);
                  stm.setInt(4, dni);
                  stm.setString(5, escuela);
                  stm.setString(6, grado);
                  stm.setString(7, nivel);
                  stm.setInt(8, obra_social);
                  stm.setInt(9, codigo);
          
                          stm.executeUpdate();
                
          }
      }
      
     public static void modificaralumno_tutor(Connection cx, int tutor, String parentesco, int alumno)throws Exception{
          PreparedStatement stm=cx.prepareStatement("update alumno_tutor set  codigo_tutor=?, parentesco=?  where codigo_alumno=?");
         stm.setInt(1, tutor);
         stm.setString(2, parentesco);
         stm.setInt(3, alumno);
   
              stm.executeUpdate();
          
          
      }
    
    
    
    
    
    
    
}
