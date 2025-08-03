
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Servicio {
    
    public static ResultSet mostrarServicios(Connection cx) throws Exception{
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("SELECT ser.nombre, ser.precio, moda.tipo from servicios as ser inner join modalidad_servicio as moda on ser.codigo_modalidad_servicio=moda.codigo");
        try{
            rs=stm.executeQuery();
        }catch(SQLException e){
              JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    }
    
    
    
    public static void actualizarPrecio(Connection cx, float precio, String nombre)throws Exception {
        PreparedStatement stm=cx.prepareStatement("UPDATE servicios set precio= ? where nombre =?");
        stm.setFloat(1, precio);
        stm.setString(2, nombre);
        try{
            stm.executeUpdate();        
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    
}
