
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Tutor {
    
    public static void cargar(Connection cx, String nombre, String apellido, int dni, String telefono) throws Exception {
        PreparedStatement stm=cx.prepareStatement("INSERT INTO tutor (nombre, apellido, dni, telefono, borrado) values (?, ?, ?, ?, 0) ");
        stm.setString(1, nombre);
        stm.setString(2, apellido);
        stm.setInt(3, dni);
        stm.setString(4, telefono);
        try{
            stm.executeUpdate();
        }catch(SQLException e){
               JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    
    
    public static ResultSet mostrarTutores(Connection cx)throws Exception {
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("SELECT nombre, apellido, dni, telefono from tutor where borrado=0");
        try{
             rs=stm.executeQuery();
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    }
    
    public static ResultSet mostrarTutor(Connection cx, int dni)throws Exception {
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("SELECT nombre, apellido, dni, telefono from tutor where dni =? and  borrado=0");
        stm.setInt(1, dni);
        try{
             rs=stm.executeQuery();
             
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    }
    
    
    public static void actualizar(Connection cx, String nombre, String apellido, int dni, String telefono, int codigo)throws Exception {
        PreparedStatement stm=cx.prepareStatement("UPDATE tutor set nombre=?, apellido=?, dni=?, telefono=? where codigo=?");
        stm.setString(1, nombre);
        stm.setString(2, apellido);
        stm.setInt(3, dni);
        stm.setString(4, telefono);
        stm.setInt(5, codigo);
        try{
            stm.executeUpdate();
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    
    
    
    
    public static int obtenerCodigo(Connection cx, int dni)throws Exception{
        int codigo=0;
        ResultSet rs= null;
        PreparedStatement stm=cx.prepareStatement("SELECT codigo from tutor where dni=?");
        stm.setInt(1, dni);
        try{
            rs=stm.executeQuery();
            if (rs.next()){
                codigo=rs.getInt("codigo");
            }
        }catch(SQLException e){
              JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return codigo;
    }
    
    
    public static void eliminar(Connection cx, int dni)throws Exception{
        PreparedStatement stm=cx.prepareStatement("UPDATE tutor set borrado=1 where dni = ?");
        stm.setInt(1, dni);
        try{
            stm.executeUpdate();
        }catch(SQLException e){
              JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    
    
   
    
}
