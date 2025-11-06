
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import javax.swing.JOptionPane;

public class cicloLectivo {
         
        public static void insertar(Connection cx) throws Exception {
        ResultSet rs = null;
        int añoActual = Year.now().getValue(); // obtenemos el año actual

        // verificamos si ya existe un registro con ese año
        PreparedStatement stm = cx.prepareStatement("SELECT COUNT(codigo) FROM ciclo_lectivo WHERE año = ?");
        stm.setInt(1, añoActual);
        rs = stm.executeQuery();

        // verificamos si hay o no registros
        if (rs.next()) { // siempre devuelve una fila
            int cantidad = rs.getInt(1); // leemos el resultado del COUNT

            // si cantidad == 0, no hay registros de ese año
            if (cantidad == 0) {
                PreparedStatement stm2 = cx.prepareStatement("INSERT INTO ciclo_lectivo (año) VALUES (?)");
                stm2.setInt(1, añoActual);
                stm2.executeUpdate(); // ejecutamos el insert
       
            } 
               
            
        }
    }
}
