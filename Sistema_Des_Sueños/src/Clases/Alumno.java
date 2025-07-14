
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
            
    
}
