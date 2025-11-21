
package MODELO_CONTROLADOR;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConsultaPofesor {
    
     
      public static ResultSet buscaAlumno(Connection cx, int codigo)throws Exception{
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("select al.nombre, al.apellido, h.horario, inc.dias From inscripcion as inc left join alumno as al on inc.codigo_alumno=al.codigo left join horarios as h on inc.codigo_horarios = h.codigo left join profesor as p on inc.codigo_profesor = p.codigo where p.codigo= ? and inc.estado='ACTIVO'");
        stm.setInt(1, codigo);
        try{
            rs=stm.executeQuery();
        }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    }
    
    
}
