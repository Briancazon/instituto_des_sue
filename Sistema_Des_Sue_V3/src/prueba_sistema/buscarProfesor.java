
package prueba_sistema;

import Consultas.consultas4;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.table.DefaultTableModel;

public class buscarProfesor extends javax.swing.JDialog {
      ResultSet rs;
    Connection cx=Conexion.conexion.conexion();
     DefaultTableModel tabla=new DefaultTableModel();
     Object[] datos=new Object[4]; 
     Panel3 p3;
      consultas4 pp;
     int origen;

   
    
    public buscarProfesor(java.awt.Frame parent, boolean modal, Panel3 panel, consultas4 pp, int origen) {
        super(parent,"Seleccionar un Profesor", modal);
        initComponents();
        this.p3=panel;
        this.pp=pp;
        this.origen=origen;
        desactivarSeleccionar();
        setLocationRelativeTo(parent); ///centrar el dialog con respecto a la ventana 
        cargarTablaProfesor();
        getContentPane().setBackground(new Color(255,102,102));
        }
    void cargarTablaProfesor(){
        
           tabla.setRowCount(0);   
           tabla.setColumnCount(0);
            tabla.addColumn("Codigo");
           tabla.addColumn("Nombre");
          tabla.addColumn("Apellido");
          tabla.addColumn("DNI");

     try{
        
        rs=Clases.Profesor.mostrarprofesoresactivos(cx);
     
        while(rs.next()){
            datos[0]=rs.getString("codigo");
            datos[1]=rs.getString("nombre");
            datos[2]=rs.getString("apellido");
            datos[3]=rs.getString("dni");
            
           
            tabla.addRow(datos);
        }
         tablaProfesor.setModel(tabla);
       
    }catch(Exception e){
          JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar los profesores","ERROR",ERROR_MESSAGE);
        
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
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProfesor = new javax.swing.JTable();
        botonSeleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("BUSCAR PROFESOR");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido");

        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tablaProfesor.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaProfesor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProfesorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProfesor);

        botonSeleccionar.setText("SELECCIONAR PROFESOR");
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
                .addGap(51, 51, 51)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jLabel3)
                .addGap(36, 36, 36)
                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(224, 224, 224))
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(botonSeleccionar)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     
           tabla.setRowCount(0);   
           tabla.setColumnCount(0);
            tabla.addColumn("Codigo");
           tabla.addColumn("Nombre");
          tabla.addColumn("Apellido");
          tabla.addColumn("DNI");

     try{
        
        rs=Clases.Inscripcion.buscarProfesor(cx, txtNombre.getText(), txtApellido.getText());
     
        while(rs.next()){
            datos[0]=rs.getString("codigo");
            datos[1]=rs.getString("nombre");
            datos[2]=rs.getString("apellido");
            datos[3]=rs.getString("dni");
            
           
            tabla.addRow(datos);
        }
         tablaProfesor.setModel(tabla);
       
    }catch(Exception e){
          JOptionPane.showMessageDialog(null, "Ha ocurrido un error al buscar el profesor","ERROR",ERROR_MESSAGE);
        
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botonSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSeleccionarActionPerformed
      try{
           int filaSeleccionada=tablaProfesor.getSelectedRow();
           String codigo=tablaProfesor.getValueAt(filaSeleccionada, 0).toString();
           String nombre=tablaProfesor.getValueAt(filaSeleccionada, 1).toString();
           String apellido=tablaProfesor.getValueAt(filaSeleccionada, 2).toString();
           
           
           if(origen==1){
               String apenom=nombre+" "+apellido;
               pp.setTxtNombre(apenom);
               pp.setLabelCodigo(codigo);
           }else{
                   
           String apenom=nombre+" "+apellido;
           p3.setTxtProfesor(apenom);
           p3.setLabelCodigoProfesor(codigo);
           }
          
           
    
           dispose();
          
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "No hay datos en la tabla","ERROR",ERROR_MESSAGE);
       }
    }//GEN-LAST:event_botonSeleccionarActionPerformed

    private void tablaProfesorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProfesorMouseClicked
       try{
           int filaSeleccionada=tablaProfesor.getSelectedRow();
           String codigo=tablaProfesor.getValueAt(filaSeleccionada, 0).toString();
           String nombre=tablaProfesor.getValueAt(filaSeleccionada, 1).toString();
           String apellido=tablaProfesor.getValueAt(filaSeleccionada, 2).toString();
           
           activarSeleccionar();
          
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "No hay datos en la tabla","ERROR",ERROR_MESSAGE);
       }
    }//GEN-LAST:event_tablaProfesorMouseClicked

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
            java.util.logging.Logger.getLogger(buscarProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(buscarProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(buscarProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(buscarProfesor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
             public void run() {
                 JFrame frame = new JFrame(); // padre temporal
                 Panel3 p3 = new Panel3();    // panel de prueba
                 consultas4 pp = new consultas4();
                 int origen=0;
                 buscarProfesor dialog = new buscarProfesor(frame, true,p3,pp, origen);
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
    private javax.swing.JButton botonSeleccionar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProfesor;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
