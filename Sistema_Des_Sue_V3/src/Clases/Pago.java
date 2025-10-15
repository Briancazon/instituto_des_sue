
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Pago {
    
    
    ///metodo para consultar el servicio y el precio de dicho servicio de un alumno dado su dni....recordando que se busca la esos datos de la inscripcion actual o activa del alumno
    public static ResultSet consultarServicioYPrecio(Connection cx, int dni)throws Exception {
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("select ser.nombre, ser.precio, ser.codigo_modalidad_cobro from servicios as ser inner join inscripcion as inc on inc.codigo_servicio=ser.codigo inner join alumno as al on inc.codigo_alumno=al.codigo where al.dni=? and inc.estado='ACTIVO'");
        stm.setInt(1, dni);
        try{
            rs=stm.executeQuery();
        }catch(SQLException e){
               JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    }
    
    /// metdo que devuelve todos los tipos de pagos que hay..
    public static ResultSet verTIposPagos(Connection cx)throws Exception {
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("select tipo_pago from tipo_pago");
        try{
            rs=stm.executeQuery();
        }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    }
    
}
