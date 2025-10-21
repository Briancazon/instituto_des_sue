
package prueba_sistema;

import java.awt.Frame;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JFrame;

import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.table.DefaultTableModel;

public class buscarAlumno extends javax.swing.JDialog {
      ResultSet rs;
    Connection cx=Conexion.conexion.conexion();
    Panel3 p3;
    asistencias a;
    Panel5 p5;
    
    DefaultTableModel tabla=new DefaultTableModel();
     Object[] datos=new Object[5]; 
     int origen;


    public buscarAlumno(Frame parent, boolean modal, Panel3 panel, asistencias a, Panel5 panel5, int origen) {
        super(parent, "Seleccionar un alumno",modal);
        this.p3=panel;
        this.a=a;
        this.origen=origen;
        this.p5=panel5;
        initComponents();
        setLocationRelativeTo(parent); ///centrar el dialog con respecto a la ventana 
        desactivarSeleccionar();
        if(this.origen==1){
            cargarTablaAlumno(); // si viene del form inscripcion, se ejecuta el metodo que carga los alumnos activos, para su respectiva inscripcion
        }else if(this.origen==2){
            cargarTablaAlumnoServiciosPorMes(); /// si viene del form asistencias, se ejecuta el metodo que carga los alunos que unicamente tiene servicios mensuales, ya que solo los servicios mensuales se pueden poner asistencias de los meses que vengan o no
        }else{
             cargarTablaAlumnoServiciosMensualesYClases();  /// por ultimo, si viene del form pagos, se ejecuta el metodo que carga los alumnos con servicios mensuales y clases personalizadas, ya que solo estos servivios se pagan , los de incluion escolar estan fuera del sistema de pagos
        }
        

    }
    
    ///este metodo carga en la tabla los alumnos con servicios mensuales, es decir, este metodo se ejecutaria unicamente si el origen viene del formulario de asistencias, ya que en asistencias se cargan unicamente las asistencias de los alumnos
    // con servicio mensual
       void cargarTablaAlumnoServiciosPorMes(){
        
           tabla.setRowCount(0);   
           tabla.setColumnCount(0);
            tabla.addColumn("Codigo");
           tabla.addColumn("Nombre");
          tabla.addColumn("Apellido");
          tabla.addColumn("DNI");
          tabla.addColumn("Servicio");

     try{
        
        rs=Clases.Inscripcion.mostrarIncripcionesServiciosMensuales(cx);
     
        while(rs.next()){
            datos[0]=rs.getString("al.codigo");
            datos[1]=rs.getString("al.nombre");
            datos[2]=rs.getString("al.apellido");
            datos[3]=rs.getString("al.dni");
            datos[4]=rs.getString("ser.nombre");
            
           
            tabla.addRow(datos);
        }
         tablaAlumnos.setModel(tabla);
       
    }catch(Exception e){
          JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar los alumnos con servicios mensuales","ERROR",ERROR_MESSAGE);
        
    }
       }
       
       /// este metodo se ejecutará si el origen viene del formulario pagos, ya que recordemos que solo se pagan los servicios mensuales y el de clases personalizadas, menos los de inclusion escolar
       /// mostrando asi los alumos activos de servicios mensuales y de clases personalizadas
        void cargarTablaAlumnoServiciosMensualesYClases(){
        
           tabla.setRowCount(0);   
           tabla.setColumnCount(0);
            tabla.addColumn("Codigo");
           tabla.addColumn("Nombre");
          tabla.addColumn("Apellido");
          tabla.addColumn("DNI");
          tabla.addColumn("Servicio");

     try{
        
        rs=Clases.Inscripcion.mostrarIncripcionesServiciosMensualesYClases(cx);
     
        while(rs.next()){
            datos[0]=rs.getString("al.codigo");
            datos[1]=rs.getString("al.nombre");
            datos[2]=rs.getString("al.apellido");
            datos[3]=rs.getString("al.dni");
            datos[4]=rs.getString("ser.nombre");
            
           
            tabla.addRow(datos);
        }
         tablaAlumnos.setModel(tabla);
       
    }catch(Exception e){
          JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar los alumnos con servicios mensuales o clases personalizadas","ERROR",ERROR_MESSAGE);
        
    }
       }

       
       
       /// este metodo carga en la tabla los alumnos activos del sistema, es decir, se ejecuta si el origen viene del formulario inscripcion, ya que ahi deberá seleccionar al alumno que se desea inscribir,
    void cargarTablaAlumno(){
        
           tabla.setRowCount(0);   
           tabla.setColumnCount(0);
            tabla.addColumn("Codigo");
           tabla.addColumn("Nombre");
          tabla.addColumn("Apellido");
          tabla.addColumn("DNI");

     try{
        
        rs=Clases.Alumno.mostrarAlumnos(cx);
     
        while(rs.next()){
            datos[0]=rs.getString("al.codigo");
            datos[1]=rs.getString("al.nombre");
            datos[2]=rs.getString("al.apellido");
            datos[3]=rs.getString("al.dni");
            
           
            tabla.addRow(datos);
        }
         tablaAlumnos.setModel(tabla);
       
    }catch(Exception e){
          JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar los alumnos","ERROR",ERROR_MESSAGE);
        
    }
    }
      
    void activarSeleccionar(){
        botonSeleccionar.setEnabled(true);
    }
    
     void desactivarSeleccionar(){
        botonSeleccionar.setEnabled(false);
    }
     

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlumnos = new javax.swing.JTable();
        botonSeleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Buscar Alumno");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido");

        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });

        botonBuscar.setText("BUSCAR");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Apellido", "DNI"
            }
        ));
        tablaAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAlumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaAlumnos);

        botonSeleccionar.setText("SELECCIONAR ALUMNO");
        botonSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSeleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(31, 31, 31)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(botonBuscar)
                        .addGap(25, 25, 25))))
            .addGroup(layout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addComponent(botonSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(botonSeleccionar)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
       if(origen==1){
             tabla.setRowCount(0);   
             tabla.setColumnCount(0);
             tabla.addColumn("Codigo");
             tabla.addColumn("Nombre");
             tabla.addColumn("Apellido");
             tabla.addColumn("DNI");

             try{
        
             rs=Clases.Inscripcion.buscarAlumno(cx, txtNombre.getText(), txtApellido.getText());
     
             while(rs.next()){
              datos[0]=rs.getString("codigo");
              datos[1]=rs.getString("nombre");
              datos[2]=rs.getString("apellido");
              datos[3]=rs.getString("dni");
            
           
              tabla.addRow(datos);
             }
             tablaAlumnos.setModel(tabla);
       
            }catch(Exception e){
                 JOptionPane.showMessageDialog(null, "Ha ocurrido un error al buscar el alumno","ERROR",ERROR_MESSAGE);
        
             }
       }else if(origen==2){ 
             tabla.setRowCount(0);   
             tabla.setColumnCount(0);
             tabla.addColumn("Codigo");
             tabla.addColumn("Nombre");
             tabla.addColumn("Apellido");
             tabla.addColumn("DNI");
             tabla.addColumn("Servicio");

             try{
        
             rs=Clases.Inscripcion.buscarAlumnoServiciosMensuales(cx, txtNombre.getText(), txtApellido.getText());
     
             while(rs.next()){
              datos[0]=rs.getString("al.codigo");
              datos[1]=rs.getString("al.nombre");
              datos[2]=rs.getString("al.apellido");
              datos[3]=rs.getString("al.dni");
               datos[4]=rs.getString("ser.nombre");
            
           
              tabla.addRow(datos);
             }
             tablaAlumnos.setModel(tabla);
       
            }catch(Exception e){
                 JOptionPane.showMessageDialog(null, "Ha ocurrido un error al buscar el alumno","ERROR",ERROR_MESSAGE);
        
             }
       }else{
             tabla.setRowCount(0);   
             tabla.setColumnCount(0);
             tabla.addColumn("Codigo");
             tabla.addColumn("Nombre");
             tabla.addColumn("Apellido");
             tabla.addColumn("DNI");
             tabla.addColumn("Servicio");

             try{
        
                 rs=Clases.Inscripcion.buscarAlumnoServiciosMensualesYClases(cx, txtNombre.getText(), txtApellido.getText());
     
                 while(rs.next()){
                    datos[0]=rs.getString("al.codigo");
                    datos[1]=rs.getString("al.nombre");
                    datos[2]=rs.getString("al.apellido");
                    datos[3]=rs.getString("al.dni");
                    datos[4]=rs.getString("ser.nombre");
            
           
                    tabla.addRow(datos);
                  }
                  tablaAlumnos.setModel(tabla);
       
             }catch(Exception e){
                 JOptionPane.showMessageDialog(null, "Ha ocurrido un error al buscar el alumno","ERROR",ERROR_MESSAGE);
        
             }
       }
          
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void botonSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSeleccionarActionPerformed
        try{
           int filaSeleccionada=tablaAlumnos.getSelectedRow();
           String codigo=tablaAlumnos.getValueAt(filaSeleccionada, 0).toString();
           String nombre=tablaAlumnos.getValueAt(filaSeleccionada, 1).toString();
           String apellido=tablaAlumnos.getValueAt(filaSeleccionada, 2).toString();
           String dni=tablaAlumnos.getValueAt(filaSeleccionada, 3).toString();
           
           
           
           String apenom=nombre+" "+apellido;
           System.out.print(origen);
           if(origen==1){
                 p3.setTxtAlumno(apenom);
                 p3.setLabelCodigoAlumno(codigo);
           }else{
               if(origen==2){
                 
                    a.setTxtAlumno(apenom);
                    a.setLabelCodigoAlumno(codigo);
               }else{
                   p5.setTxtAlumno(apenom);
                   p5.setTxtDni(dni);
               }
              
           }
         
           dispose();
          
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "No hay datos en la tabla","ERROR",ERROR_MESSAGE);
       }
    }//GEN-LAST:event_botonSeleccionarActionPerformed

    private void tablaAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAlumnosMouseClicked
        try{
           int filaSeleccionada=tablaAlumnos.getSelectedRow();
           String codigo=tablaAlumnos.getValueAt(filaSeleccionada, 0).toString();
           String nombre=tablaAlumnos.getValueAt(filaSeleccionada, 1).toString();
           String apellido=tablaAlumnos.getValueAt(filaSeleccionada, 2).toString();
           
           activarSeleccionar();
          
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "No hay datos en la tabla","ERROR",ERROR_MESSAGE);
       }
    }//GEN-LAST:event_tablaAlumnosMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(buscarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(buscarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(buscarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(buscarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame(); // padre temporal
    Panel3 p3 = new Panel3();    // panel de prueba
    asistencias a=new asistencias();
    Panel5 p5=new Panel5();
    int origen = 0;
               buscarAlumno dialog = new buscarAlumno( frame, true,p3,a, p5, origen);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaAlumnos;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
