
package MODELO_CONTROLADOR;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConsultaPofesor {
    
     ///metodo que nos devuelve los alumnos activos que tiene un profesor del actual ciclo_lectivo...
      public static ResultSet buscaAlumno(Connection cx, int codigo_profesor, int codigo_ciclo_lectivo)throws Exception{
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("select al.nombre, al.apellido, al.dni,  h.horario, inc.dias, ci.año From inscripcion as inc left join alumno as al on inc.codigo_alumno=al.codigo left join horarios as h on inc.codigo_horarios = h.codigo left join profesor as p on inc.codigo_profesor = p.codigo left join ciclo_lectivo as ci on inc.codigo_ciclo_lectivo=ci.codigo where p.codigo= ? and inc.estado='ACTIVO' and inc.codigo_ciclo_lectivo=?");
        stm.setInt(1, codigo_profesor);
        stm.setInt(2, codigo_ciclo_lectivo);
        try{
            rs=stm.executeQuery();
        }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    }
    
    
}
