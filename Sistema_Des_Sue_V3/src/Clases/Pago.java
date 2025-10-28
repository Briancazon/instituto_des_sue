
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Pago {
    
    
    ///metodo para consultar el servicio y el precio de dicho servicio de un alumno dado su dni....recordando que se busca esos datos de la inscripcion actual o activa del alumno
    public static ResultSet consultarServicioYPrecio(Connection cx, int dni)throws Exception {
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("select al.nombre, al.apellido, ser.nombre, ser.precio, ser.codigo_modalidad_cobro from servicios as ser inner join inscripcion as inc on inc.codigo_servicio=ser.codigo inner join alumno as al on inc.codigo_alumno=al.codigo where al.dni=? and inc.estado='ACTIVO' and (ser.codigo_modalidad_cobro=1 or ser.codigo_modalidad_cobro=2 )");
        stm.setInt(1, dni);
        try{
            rs=stm.executeQuery();
        }catch(SQLException e){
               JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    }
    
    /// metdo que devuelve todos los tipos de pagos que hay..
    public static ResultSet verTIposPagos(Connection cx)throws Exception {
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("select tipo_pago from tipo_pago");
        try{
            rs=stm.executeQuery();
        }catch(SQLException e){
                JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    }
    
    public static int obtenerCodigoTipoPago(Connection cx, String tipo_pago)throws Exception {
        ResultSet rs=null;
        int codigo=0;
        PreparedStatement stm=cx.prepareStatement("select codigo from tipo_pago where tipo_pago=?");
        stm.setString(1, tipo_pago);
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
    
    ///metodo para ver el historial de todos los pagos de un alumno tanto activos como inactivos,, incluyendo los distintos servicios que tuvo...
    public static ResultSet verHistorialPagosAlumno(Connection cx, int dni)throws Exception {
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("select tp.tipo_pago, al.nombre, al.apellido, al.dni, pa.fecha_pago, ser.nombre , pa.recargo, me.mes, cl.año, pa.observacion, pa.total from pagos as pa left join tipo_pago as tp on pa.codigo_tipo_pago=tp.codigo left join inscripcion as inc on pa.codigo_inscripcion=inc.codigo left join alumno as al on inc.codigo_alumno=al.codigo left join servicios as ser on pa.codigo_servicio=ser.codigo  left join meses as me on pa.codigo_mes=me.codigo left join ciclo_lectivo as cl on pa.codigo_ciclo_lectivo=cl.codigo where al.dni=? order by pa.codigo desc");
        stm.setInt(1, dni);
        try{
           rs= stm.executeQuery();
        }catch(SQLException e){
              JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    }
    
    //metodo para ver el historial de todos los pagos de todos los alumnos tanto activos como inactivos, incluyendo los distintos servicios que tuvo...
    public static ResultSet verHistorialPagos(Connection cx)throws Exception {
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("select tp.tipo_pago, al.nombre, al.apellido, al.dni, pa.fecha_pago, ser.nombre , pa.recargo, me.mes, cl.año, pa.observacion, pa.total from pagos as pa left join tipo_pago as tp on pa.codigo_tipo_pago=tp.codigo left join inscripcion as inc on pa.codigo_inscripcion=inc.codigo left join alumno as al on inc.codigo_alumno=al.codigo left join servicios as ser on pa.codigo_servicio=ser.codigo  left join meses as me on pa.codigo_mes=me.codigo left join ciclo_lectivo as cl on pa.codigo_ciclo_lectivo=cl.codigo order by pa.codigo desc");
   
        try{
           rs= stm.executeQuery();
        }catch(SQLException e){
              JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
    }
    
    ///metodo para pagar un servicio mensual o de clase personalizada
    public static void pagar(Connection cx, int codigo_tipo_pago, int codigo_inscripcion, String fecha_pago,  int codigo_servicio, float recargo, int codigo_mes, int ciclo_lectivo, String observacion, float total)throws Exception{
        if(codigo_mes==0){
             PreparedStatement stm=cx.prepareStatement("insert into pagos (codigo_tipo_pago, codigo_inscripcion, fecha_pago, codigo_servicio,  recargo, codigo_mes, codigo_ciclo_lectivo, observacion, total) values(?, ?, ?, ?, ?, null, ?, ?, ?)");
             stm.setInt(1, codigo_tipo_pago);
             stm.setInt(2, codigo_inscripcion);
             stm.setString(3, fecha_pago);
             stm.setInt(4, codigo_servicio);
             stm.setFloat(5, recargo);
             stm.setInt(6, ciclo_lectivo);
             stm.setString(7, observacion);
             stm.setFloat(8, total);
             try{
               stm.executeUpdate();
             }catch(SQLException e){
              JOptionPane.showMessageDialog(null,e.getMessage());
             }
        }else{
            PreparedStatement stm=cx.prepareStatement("insert into pagos (codigo_tipo_pago, codigo_inscripcion, fecha_pago, codigo_servicio,  recargo, codigo_mes, codigo_ciclo_lectivo, observacion, total) values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
             stm.setInt(1, codigo_tipo_pago);
             stm.setInt(2, codigo_inscripcion);
             stm.setString(3, fecha_pago);
             stm.setInt(4, codigo_servicio);
             stm.setFloat(5, recargo);
             stm.setInt(6, codigo_mes);
             stm.setInt(7, ciclo_lectivo);
             stm.setString(8, observacion);
             stm.setFloat(9, total);
             try{
               stm.executeUpdate();
             }catch(SQLException e){
              JOptionPane.showMessageDialog(null,e.getMessage());
             }
        }
        
    }
    
    /// este metodo devolvera todos los meses que le corresponde pagar al alumno, es decir, todos los meses en los que asistio, mostrando asi solos los meses que asistio y por lo tanto le corresponde pagar, en cambio, los meses que no asistio no se cobran, esto seria solo para servicios MENSUALES
    public static ResultSet verQueMesesPaga(Connection cx, int codigo_inscripcion)throws Exception {
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("select me.mes from asistencias_mensuales as am inner join meses as me on am.codigo_mes=me.codigo inner join inscripcion as inc on am.codigo_inscripcion= inc.codigo where am.asistio=\"SI\" and inc.codigo=?");
        stm.setInt(1, codigo_inscripcion);
        try{
            rs=stm.executeQuery();
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return rs;
            
    }
    
    
    //validacion: este metodo se encarga de validar que un alumno no pague dos veces el mismo mes del mismo año, osea que solo valida los pagos de los  servicios mensuales.
    public static ResultSet evitarDoblesPagosServicioMensual(Connection cx, int codigo_inscripcion, int codigo_mes, int codigo_ciclo_lectivo)throws Exception {
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("select * from pagos where codigo_inscripcion=? and codigo_mes=? and codigo_ciclo_lectivo=?"); /// se fija si hay registros existentes de ese mes y ese año, es decir, se fija si ya pagaste ese mes de ese año
        stm.setInt(1, codigo_inscripcion);
        stm.setInt(2, codigo_mes);
        stm.setInt(3, codigo_ciclo_lectivo);
        try{
            rs=stm.executeQuery();
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null,e.getMessage());
        }
            return rs;
    }
    
    
    
    // validacion: este étodo se encarga de de validar que un alumno no pague dos veces la misma clase personalizada, es decir, que no pague la misma fecha del mismo año dos veces, osea que solo valida los pagos de los servicios de clases personalizadas
     public static ResultSet evitarDoblesPagosServicioClase(Connection cx, int codigo_inscripcion, String fecha_pago, int codigo_ciclo_lectivo)throws Exception {
        ResultSet rs=null;
        PreparedStatement stm=cx.prepareStatement("select * from pagos where codigo_inscripcion=? and fecha_pago=? and codigo_ciclo_lectivo=?"); // se fija si hay registros existentes de esa fecha y ese año, es decir, se fija si ya pagaste esa fecha de ese año
        stm.setInt(1, codigo_inscripcion);
        stm.setString(2, fecha_pago);
        stm.setInt(3, codigo_ciclo_lectivo);
        try{
            rs=stm.executeQuery();
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null,e.getMessage());
        }
            return rs;
    }
     
     
     /// metodo para ver los pagos pendientes (osea, cuotas mensuales pendientes, en donde se mostrará los meses que un alumno asistió pero no pagó) de un alumno..con inscripcion activa
     public static ResultSet verPagosPendientesAlumno(Connection cx, int dni)throws Exception {
         ResultSet rs=null;;
         PreparedStatement stm=cx.prepareStatement("select al.nombre, al.apellido, al.dni, ser.nombre, me.mes, cl.año from asistencias_mensuales as am inner join inscripcion as inc on am.codigo_inscripcion=inc.codigo inner join alumno as al on inc.codigo_alumno=al.codigo inner join servicios as ser on inc.codigo_servicio=ser.codigo inner join meses as me on am.codigo_mes=me.codigo inner join ciclo_lectivo as cl on inc.codigo_ciclo_lectivo=cl.codigo where am.asistio=\"SI\" and al.dni=? and inc.estado=\"ACTIVO\" and not exists(select * from pagos as pa where pa.codigo_inscripcion=inc.codigo and pa.codigo_mes=am.codigo_mes and pa.codigo_ciclo_lectivo=inc.codigo_ciclo_lectivo)");
         stm.setInt(1, dni);
         try{
            rs= stm.executeQuery();
         }catch(SQLException e){
              JOptionPane.showMessageDialog(null,e.getMessage());
         }
         return rs;
     }
     
      
     /// metodo para ver los pagos pendientes (osea, cuotas mensuales pendientes, en donde se mostrará los meses que un alumno asistió pero no pagó) de todos los alumnos con inscripcion activa
     public static ResultSet verPagosPendientes(Connection cx)throws Exception {
         ResultSet rs=null;;
         PreparedStatement stm=cx.prepareStatement("select al.nombre, al.apellido, al.dni, ser.nombre, me.mes, cl.año from asistencias_mensuales as am inner join inscripcion as inc on am.codigo_inscripcion=inc.codigo inner join alumno as al on inc.codigo_alumno=al.codigo inner join servicios as ser on inc.codigo_servicio=ser.codigo inner join meses as me on am.codigo_mes=me.codigo inner join ciclo_lectivo as cl on inc.codigo_ciclo_lectivo=cl.codigo where am.asistio=\"SI\"  and inc.estado=\"ACTIVO\" and not exists(select * from pagos as pa where pa.codigo_inscripcion=inc.codigo and pa.codigo_mes=am.codigo_mes and pa.codigo_ciclo_lectivo=inc.codigo_ciclo_lectivo)");
    
         try{
            rs= stm.executeQuery();
         }catch(SQLException e){
              JOptionPane.showMessageDialog(null,e.getMessage());
         }
         return rs;
     }
    
    
    
    
    
    
    
}
