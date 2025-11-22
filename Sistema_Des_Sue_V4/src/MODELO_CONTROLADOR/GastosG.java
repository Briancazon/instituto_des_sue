
package MODELO_CONTROLADOR;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class GastosG {
    public static void cargarGastos(Connection cx, String nombre, float precio, int codigo_mes, int año)throws Exception{
        PreparedStatement stm=cx.prepareStatement("INSERT INTO gastos (nombre, precio, codigo_mes, año, borrado) VALUES (?, ?, ?, ? , 0)");
        stm.setString(1, nombre);
        stm.setFloat(2, precio);
        stm.setInt(3, codigo_mes);
        stm.setInt(4, año);
        
        try{
            stm.executeUpdate();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    
    
     public static ResultSet mostrarMes(Connection cx)throws SQLException{
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("select mes from meses");
      
        try{
            rs=stm.executeQuery();
        }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    }
    
     
     //obtener codigo mes
     public static int obtenerCodigo(Connection cx, String nombre) throws Exception{
           ResultSet rs=null;
           int codigo=0;
           PreparedStatement stm=cx.prepareStatement("SELECT codigo from meses where mes=?");
           stm.setString(1, nombre) ;
           try{
               rs=stm.executeQuery();
                if(rs.next()){
                    codigo=rs.getInt("codigo");
                }
           }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,e.getMessage());
           }
           
           return codigo;
           
           }
    
    public static int obtenerCodigoGastos(Connection cx, String nombre) throws Exception{
           ResultSet rs=null;
           int codigo=0;
           PreparedStatement stm=cx.prepareStatement("SELECT codigo from gastos where nombre=?");
           stm.setString(1, nombre) ;
   
               rs=stm.executeQuery();
                if(rs.next()){
                    codigo=rs.getInt("codigo");
                }
           
           
           return codigo;
           
           }
    
    //obtener el codigo de un gasto dado el nombre, mes y año con el que fue cargado
     public static int obtenerCodigoGasto(Connection cx, String nombre, int codigo_mes, int año) throws Exception{
           ResultSet rs=null;
           int codigo=0;
           PreparedStatement stm=cx.prepareStatement("SELECT codigo from gastos where nombre=? and codigo_mes=? and año=?");
           stm.setString(1, nombre) ;
           stm.setInt(2, codigo_mes);
           stm.setInt(3, año);
   
               rs=stm.executeQuery();
                if(rs.next()){
                    codigo=rs.getInt("codigo");
                }
         
           
           return codigo;
           
           }
    
        public static ResultSet mostrar(Connection cx)throws SQLException{
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("SELECT ga.nombre, ga.precio , me.mes from gastos as ga inner join meses as me on ga.codigo_mes=me.codigo where ga.borrado=0 ");
      
        try{
            rs=stm.executeQuery();
        }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    }
    
        public static void eliminar(Connection cx, int codigo)throws Exception{
           PreparedStatement stm=cx.prepareStatement("UPDATE gastos set borrado= 1 where codigo=?");
            stm.setInt(1, codigo);
           try{
               stm.executeUpdate();
           }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e.getMessage());
           }
       }
        
        
        ///metodo para eliminar un gasto no deseado o mal cargado, lo eliminamos de manera definitiva(delete)
        public static void eliminarDefinitivamente(Connection cx, int codigo)throws Exception{
           PreparedStatement stm=cx.prepareStatement("DELETE from gastos where codigo=?");
            stm.setInt(1, codigo);
  
               stm.executeUpdate();
         
       }
         ///metodo para ver todos los gastos que el usuario haya cargado y ya haya limpiado, de todos los meses de todos lo años en orden desc..
        public static ResultSet verGastosAnteriores(Connection cx)throws Exception{
            ResultSet rs=null;
            PreparedStatement stm=cx.prepareStatement("SELECT SUM(ga.precio), SUM(ga.precio)/(SELECT COUNT(codigo) FROM profesor WHERE borrado=0) , me.mes, me.codigo, ci.año FROM gastos AS ga INNER JOIN meses AS me ON ga.codigo_mes = me.codigo INNER JOIN ciclo_lectivo AS ci ON ga.año = ci.codigo WHERE ga.borrado = 1 GROUP BY me.mes, me.codigo, ci.año ORDER BY ci.año DESC, me.codigo DESC");
            rs=stm.executeQuery();
            return rs;
        }
        
      
        public static ResultSet mostrarGastosAnteriores(Connection cx, int codigo)throws SQLException{
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("select g.nombre, g.precio from gastos as g inner join meses as m on m.codigo=g.codigo_mes where borrado=1 and m.codigo=?; ");
          stm.setInt(1, codigo);
        try{
            rs=stm.executeQuery();
        }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    }
        
        
        ///metodo que nos permite validar si ya cargó gastos en el mes de enero de 2025 por ejemplo...
        public static int verSiHayGastos(Connection cx, int codigo_mes, int codigo_ciclo_lectivo)throws Exception{
            ResultSet rs=null;
            int tiene=0;
            PreparedStatement stm=cx.prepareStatement("select codigo from gastos where codigo_mes=? and año=?");
            stm.setInt(1, codigo_mes);
            stm.setInt(2, codigo_ciclo_lectivo);
            rs=stm.executeQuery();
            while(rs.next()){
                tiene=rs.getInt("codigo");
            }
            return tiene;
        }
        
      public static int obtenerCodigoCicloLectivo(Connection cx)throws Exception {
         ResultSet rs=null;
         int codigo=0;
         PreparedStatement stm=cx.prepareStatement("SELECT codigo from ciclo_lectivo order by codigo desc limit 1");
        
         try{
             rs=stm.executeQuery();
             while(rs.next())
                 codigo=rs.getInt("codigo");
         }catch(SQLException e){
             JOptionPane.showMessageDialog(null,e.getMessage());
         }
         return codigo;
     }    
        
        
        
       public static ResultSet mostrarPorMes(Connection cx, String mes) throws SQLException {
    String sql = "SELECT nombre, precio FROM gastos g " +
                 "JOIN meses m ON g.codigo_mes = m.codigo " +
                 "WHERE LOWER(m.mes) = LOWER(?) and g.borrado= '0' ";
    PreparedStatement ps = cx.prepareStatement(sql);
    ps.setString(1, mes);
    return ps.executeQuery();
    
    
}
        
        
    public static void activarGastosPorMes(Connection cx, String mes) throws SQLException {
    String sql = "UPDATE gastos g " +
                 "JOIN meses m ON g.codigo_mes = m.codigo " +
                 "SET g.borrado = '0' " +
                 "WHERE LOWER(m.mes) = LOWER(?) AND g.borrado = '1'";
    PreparedStatement ps = cx.prepareStatement(sql);
    ps.setString(1, mes);
    ps.executeUpdate();
    ps.close();
}
        
   public static void desactivarTodosLosGastos(Connection cx) throws SQLException {
    String sql = "UPDATE gastos SET borrado = '1' WHERE borrado = '0'";
    PreparedStatement ps = cx.prepareStatement(sql);
    ps.executeUpdate();
    ps.close();
} 
        
        
        
        
        
        
        
        
        
    
}
