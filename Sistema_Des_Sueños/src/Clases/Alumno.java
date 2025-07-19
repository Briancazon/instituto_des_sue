
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Alumno {
    public static void cargar(Connection cx, String nombre, String apellido, String fecha_nac, int dni, String escuela, String grado, String nivel, int obra_social )throws Exception {
        PreparedStatement stm=cx.prepareStatement("INSERT INTO alumno (nombre, apellido, fecha_nac, dni, escuela, grado, nivel, obra_social, borrado) values (?, ?, ?, ?, ?, ?, ?, ?, 0)");
        stm.setString(1, nombre);
        stm.setString(2, apellido );
        stm.setString(3, fecha_nac);
        stm.setInt(4, dni);
        stm.setString(5, escuela);
        stm.setString(6, grado);
        stm.setString(7, nivel);
        stm.setInt(8, obra_social);
        
        try{
           stm.executeUpdate();
        }catch(SQLException e){
            
        }
            
            
    }
    
    public static ResultSet mostrarAlumnos(Connection cx)throws Exception{
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("SELECT al.nombre, al.apellido, al.fecha_nac, al.dni, al.escuela, al.grado, al.nivel, os.nombre from alumno as al inner join obra_social as os on os.codigo=al.obra_social");
        try{
            rs=stm.executeQuery();
        }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    }
       
    
      public static ResultSet mostrarAlumno(Connection cx, int dni)throws Exception{
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("SELECT al.nombre, al.apellido, al.fecha_nac, al.dni, al.escuela, al.grado, al.nivel, os.nombre from alumno as al inner join obra_social as os on os.codigo=al.obra_social where al.dni=?");
        stm.setInt(1, dni);
        try{
            rs=stm.executeQuery();
        }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    }
      
      public static void actualizarAlumno(Connection cx, String nombre, String apellido, String fecha_nac, int dni, String escuela, String grado, String nivel, int obra_social, int codigo)throws Exception{
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
          
          try{
              stm.executeUpdate();
          }catch(SQLException e){
               JOptionPane.showMessageDialog(null,e.getMessage());
          }
          
      }
      
      
      //metodo para obtener el codigo de un alumno dado su dni...
      public static int obtenerCodigo(Connection cx, int dni)throws Exception{
          ResultSet rs=null;
          int codigo=0;
          PreparedStatement stm=cx.prepareStatement("SELECT codigo from alumno where dni=?");
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
      
        
    
}
