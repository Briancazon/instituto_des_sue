
package controlador;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import modelo.Alumno;


public class alumnoControlador {
    
    
    public void guardarAlumno(String nombre, String apellido, String fecha_nacimiento, int dni, String escuela, String grado, String nivel, String obra_social) {
        Alumno a = new Alumno(nombre, apellido, fecha_nacimiento, dni, escuela, grado, nivel, obra_social);
        try{
          a.insertar();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al cargar el alumno","ERROR",ERROR_MESSAGE);
        }
    }
     
     
     public ResultSet cargarTabla() throws Exception{
        
          return Alumno.listarAlumnos();
         
     }
     
     public Alumno buscarAlumno(int dni){
         Alumno a =new Alumno();
         a.buscarAlumno(dni);
         return a;
     }
     
     public void actualizarAlumno(String nombre, String apellido, String fecha_nacimiento, int dni, String escuela, String grado, String nivel, String obra_social){
         Alumno a=new Alumno(nombre, apellido, fecha_nacimiento, dni, escuela, grado, nivel, obra_social);
         try{
             a.actualizarAlumno();
         }catch(Exception e){
             JOptionPane.showMessageDialog(null, "Ha ocurrido un error al actualizar el alumno","ERROR",ERROR_MESSAGE);
         }
     }
    
}
