
package MODELO_CONTROLADOR;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class Servicios {
    public static void actualizarPrecio(Connection cx, String nombre, float precio)throws Exception {
        PreparedStatement stm=cx.prepareStatement("UPDATE servicios set precio=? where nombre=?");
        stm.setFloat(1, precio);
        stm.setString(2, nombre);
        stm.executeUpdate();
    }
    
}
