
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class conexion {
     public static Connection conexion(){
          Connection conexion=null;
          String servidor="jdbc:mysql://localhost/instituto";
          String usuario="root";
          String pass="";
          
          
          try{
              Class.forName("com.mysql.cj.jdbc.Driver");
              conexion=(Connection) DriverManager.getConnection(servidor,usuario,pass);
              
          }catch(ClassNotFoundException ex){
              JOptionPane.showMessageDialog(null,ex.getMessage());
          }catch(Exception ex){
             JOptionPane.showMessageDialog(null,ex.getMessage());
          }
          finally{
                 return conexion;
          }
       
         
    }
    
}
