
package Clases;

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
    
        public static ResultSet mostrar(Connection cx)throws SQLException{
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("SELECT nombre, precio from gastos where borrado=0 ");
      
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
