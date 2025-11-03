
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Servicios {
    public static void actualizarPrecio(Connection cx, String nombre, float precio)throws Exception {
        PreparedStatement stm=cx.prepareStatement("UPDATE servicios set precio=? where nombre=?");
        stm.setFloat(1, precio);
        stm.setString(2, nombre);
        stm.executeUpdate();
    }
    
}
