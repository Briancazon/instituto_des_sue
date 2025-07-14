
package modelo;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Alumno {
    private String nombre;
    private String apellido;
    private String fecha_nacimiento;
    private int dni;
    private String escuela;
    private String grado;
    private String nivel;
    private String obra_social;

    public Alumno(String nombre, String apellido, String fecha_nacimiento, int dni, String escuela, String grado, String nivel, String obra_social) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.dni = dni;
        this.escuela = escuela;
        this.grado = grado;
        this.nivel = nivel;
        this.obra_social = obra_social;
    }
    public Alumno(){
        
    }
    
    
   public void insertar() throws Exception{
       Connection con = conexion.conexion();
       try{
           String sql="INSERT INTO alumno (nombre, apellido, fecha_nac, dni, escuela, grado, nivel, obra_social, borrado) values (?, ?, ?, ?, ?, ?,?, ?, 0)";
           PreparedStatement stm=con.prepareStatement(sql);
           stm.setString(1, nombre);
           stm.setString(2, apellido);
           stm.setString(3, fecha_nacimiento);
           stm.setInt(4, dni);
           stm.setString(5, escuela);
           stm.setString(6, grado);
           stm.setString(7, nivel);
           stm.setString(8, obra_social);
           stm.executeUpdate();
           
       }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());  
       }       
       
   }
   
   public static ResultSet listarAlumnos()throws Exception{
       
       ResultSet rs=null;
       Connection con=conexion.conexion();
       try{
          String sql="SELECT nombre, apellido, fecha_nac, dni, escuela, grado, nivel, obra_social) from alumno where borrado= 0";
          PreparedStatement stm=con.prepareStatement(sql);
          rs=stm.executeQuery();
          
           
       }catch(SQLException e){
          JOptionPane.showMessageDialog(null,e.getMessage());     
       }
      return rs;
   }
   
   public  void buscarAlumno(int dniB){
       ResultSet rs=null;
       Connection con=conexion.conexion();
       try{
           String sql="SELECT al.nombre, al.apellido, al.fecha_nac, al.dni, al.escuela, al.grado, al.nivel, ob.nombre from alumno as al inner join obra_social as ob on ob.codigo=al.obra_social where al.dni =?";
           PreparedStatement stm=con.prepareStatement(sql);
           stm.setInt(1, dniB);
           rs=stm.executeQuery();
           while (rs.next()){
              nombre= rs.getString("al.nombre");
              apellido=rs.getString("al.apellido");
              fecha_nacimiento= rs.getString("al.fecha_nac");
              dni=rs.getInt("al.dni");
              escuela= rs.getString("al.escuela");
               grado=rs.getString("al.grado");
               nivel=rs.getString("al.nivel");
              obra_social= rs.getString("ob.nombre");
               
           }
           
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,e.getMessage()); 
       }
   }
   
   public void actualizarAlumno(){
       Connection con=conexion.conexion();
       try{
           String sql="UPDATE alumno set nombre= ?, apellido= ?, fecha_nac= ?, dni= ?, escuela= ?, grado= ?, nivel=?, obra_social=? where codigo= ?";
           PreparedStatement stm=con.prepareStatement(sql);
           stm.setString(1, nombre);
           stm.setString(2, apellido);
           stm.setString(3, fecha_nacimiento);
           stm.setInt(4, dni);
           stm.setString(5,escuela);
           stm.setString(6, grado);
           stm.setString(7, nivel);
           stm.setString(8, obra_social);
           stm.executeUpdate();
       }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
       }
   }
    
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getObra_social() {
        return obra_social;
    }

    public void setObra_social(String obra_social) {
        this.obra_social = obra_social;
    }
    
    
}
