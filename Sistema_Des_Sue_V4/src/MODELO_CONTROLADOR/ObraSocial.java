
package MODELO_CONTROLADOR;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ObraSocial {
     public static void cargar(Connection cx, String nombre )throws Exception {
        PreparedStatement stm=cx.prepareStatement("INSERT INTO obra_social (nombre, borrado) values (UPPER(?), 0)");
        stm.setString(1, nombre);
        
        
           stm.executeUpdate();
      
              
    }
    
        
   
    
       public static ResultSet mostrarObrasSocialesActivas(Connection cx)throws SQLException{
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("SELECT codigo,nombre, borrado from obra_social where borrado=0 order by codigo desc");
      
        try{
            rs=stm.executeQuery();
        }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    }
       
        public static ResultSet mostrasTodasObrasSociales(Connection cx)throws SQLException{
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("SELECT * from obra_social");
      
        try{
            rs=stm.executeQuery();
        }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    }
 
     public static ResultSet buscarOS(Connection cx, String nom)throws Exception{
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("select codigo, nombre from obra_social where nombre like ? and borrado=0");
        stm.setString(1, "%"+nom+"%");
        try{
            rs=stm.executeQuery();
        }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    }
     
     ////bussqueda por like y solo de las obras activas...
     public static ResultSet buscarOS2(Connection cx, String nom)throws Exception{
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("select codigo, nombre from obra_social where nombre like ? and borrado=0 ");
        stm.setString(1, "%"+nom+"%");
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
           PreparedStatement stm=cx.prepareStatement("SELECT codigo from obra_social where nombre=?");
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
       
       public static void update(Connection cx, String nombre, int codigo)throws Exception {
           PreparedStatement stm=cx.prepareStatement("UPDATE obra_social set nombre=UPPER(?) where codigo =?");
           stm.setString(1, nombre);
           stm.setInt(2, codigo);
           
               stm.executeUpdate();

       }
       
       public static void eliminar(Connection cx, int codigo)throws Exception{
           PreparedStatement stm=cx.prepareStatement("UPDATE obra_social set borrado= 1 where codigo=?");
           stm.setInt(1, codigo);
           try{
               stm.executeUpdate();
           }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e.getMessage());
           }
       }
       
       
       public static ResultSet mostrarObrasSocialesInactivas(Connection cx)throws SQLException{
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("SELECT codigo,nombre from obra_social where borrado=1");
      
        try{
            rs=stm.executeQuery();
        }catch(SQLException e){
                 JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    }

       
    public static void habilitarOS(Connection cx, int codigo)throws Exception{
        
          PreparedStatement stm=cx.prepareStatement("UPDATE obra_social set borrado= 0 where codigo=?");
           stm.setInt(1, codigo);
           try{
               stm.executeUpdate();
           }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e.getMessage());
           }
        
        
        
    }    
    
      
}
