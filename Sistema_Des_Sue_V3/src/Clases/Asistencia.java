
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Asistencia {
    public static ResultSet verMeses(Connection cx)throws Exception {
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("SELECT mes from meses");
        try{
          rs=  stm.executeQuery();
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    }
    
    
     public static int obtenerCodigoMes(Connection cx, String mes)throws Exception {
        ResultSet rs=null;
        int codigo=0;
        PreparedStatement stm=cx.prepareStatement("SELECT codigo from meses where mes =?");
        stm.setString(1, mes);
        try{
          rs=  stm.executeQuery();
          if(rs.next()){
              codigo=rs.getInt("codigo");
          }
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return codigo;
    }

    
    public static void insertar(Connection cx, int codigo_inscripcion, int codigo_mes, int codigo_ciclo_lectivo, String asistencia)throws Exception {
        PreparedStatement stm=cx.prepareStatement("insert into asistencias_mensuales (codigo_inscripcion, codigo_mes, codigo_ciclo_lectivo, asistio) values (?, ?, ?, ?)");
        stm.setInt(1, codigo_inscripcion);
        stm.setInt(2, codigo_mes);
        stm.setInt(3, codigo_ciclo_lectivo);
        stm.setString(4, asistencia);
        try{
            stm.executeUpdate();
        }catch(SQLException e){
              JOptionPane.showMessageDialog(null,e.getMessage());
        }
            
    }
    
    public static ResultSet buscarAsistenciasAlumno(Connection cx, int dni)throws Exception{
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("SELECT al.nombre, al.apellido, al.dni, ser.nombre, me.mes, ci.año, a.asistio from asistencias_mensuales as a inner join inscripcion as inc on a.codigo_inscripcion=inc.codigo inner join alumno as al on inc.codigo_alumno=al.codigo inner join servicios as ser on inc.codigo_servicio=ser.codigo inner join meses as me on a.codigo_mes=me.codigo inner join ciclo_lectivo as ci on a.codigo_ciclo_lectivo=ci.codigo where al.dni=?");
        stm.setInt(1, dni);
        try{
             rs=   stm.executeQuery();
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    }
    
    /// metodo para ver todas las asistencias...
    public static ResultSet verAsistencias(Connection cx)throws Exception{
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("SELECT al.nombre, al.apellido, al.dni, ser.nombre, me.mes, ci.año, a.asistio from asistencias_mensuales as a inner join inscripcion as inc on a.codigo_inscripcion=inc.codigo inner join alumno as al on inc.codigo_alumno=al.codigo inner join servicios as ser on inc.codigo_servicio=ser.codigo inner join meses as me on a.codigo_mes=me.codigo inner join ciclo_lectivo as ci on a.codigo_ciclo_lectivo=ci.codigo");
        
        try{
             rs=   stm.executeQuery();
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    }
    
    
    public static boolean consultarDuplicados(Connection cx, int codigo_inscripcion, int codigo_ciclo_lectivo, int codigo_mes)throws Exception {
        boolean existe=false;
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("select * from asistencias_mensuales where codigo_inscripcion=? and codigo_ciclo_lectivo=? and codigo_mes=?");
        stm.setInt(1, codigo_inscripcion);
        stm.setInt(2, codigo_ciclo_lectivo);
        stm.setInt(3, codigo_mes);
        try{
            rs=stm.executeQuery();
            if(rs.next()){
                existe=true;
            }
        }catch(SQLException e){
              JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return existe;
    }
}