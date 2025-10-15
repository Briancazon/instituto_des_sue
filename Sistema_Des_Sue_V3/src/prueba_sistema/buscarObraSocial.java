
package prueba_sistema;

import Alumno.ModificarA;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.table.DefaultTableModel;


public class buscarObraSocial extends javax.swing.JDialog {
    ResultSet rs;
    Connection cx=Conexion.conexion.conexion();
   
    
    DefaultTableModel tabla=new DefaultTableModel();
    Object[] datos=new Object[4]; 
    
    ModificarA pA;


  
    public buscarObraSocial(java.awt.Frame parent, boolean modal, ModificarA panel) {
        super(parent,"Seleccionar una Obra Social", modal);
        initComponents();
        this.pA=panel;
        cargarTablaOS();
        setLocationRelativeTo(parent); ///centrar el dialog con respecto a la ventana 
        desactivarSeleccionar();
    }
    
      void activarSeleccionar(){
        botonSeleccionar.setEnabled(true);
    }
    
     void desactivarSeleccionar(){
        botonSeleccionar.setEnabled(false);
    }
    
    void cargarTablaOS(){
             tabla.setRowCount(0);   
           tabla.setColumnCount(0);
            tabla.addColumn("Codigo");
           tabla.addColumn("Obra Social");
  

     try{
        
        rs=Clases.ObraSocial.mostrarObrasSocialesActivas(cx);
     
        while(rs.next()){
            datos[0]=rs.getString("codigo");
            datos[1]=rs.getString("nombre");
  
           
            tabla.addRow(datos);
        }
         tablaOS.setModel(tabla);
       
    }catch(Exception e){
          JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar las obras sociales","ERROR",ERROR_MESSAGE);
        
    }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaOS = new javax.swing.JTable();
        botonSeleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Buscar Obra Social");

        jLabel2.setText("Obra Social");

        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tablaOS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Codigo", "Obra Social"
            }
        ));
        tablaOS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaOSMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaOS);

        botonSeleccionar.setText("SELECCIONAR OBRA SOCIAL");
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
                .addGap(234, 234, 234)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel2)
                        .addGap(40, 40, 40)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(66, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(74, 74, 74))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(botonSeleccionar)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            tabla.setRowCount(0);   
           tabla.setColumnCount(0);
            tabla.addColumn("Codigo");
           tabla.addColumn("Obra Social");
  

     try{
        
        rs=Clases.ObraSocial.buscarOS2(cx,txtNombre.getText());
     
        while(rs.next()){
            datos[0]=rs.getString("codigo");
            datos[1]=rs.getString("nombre");
  
           
            tabla.addRow(datos);
        }
         tablaOS.setModel(tabla);
       
    }catch(Exception e){
          JOptionPane.showMessageDialog(null, "Ha ocurrido un error al buscar la obra social","ERROR",ERROR_MESSAGE);
        
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botonSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSeleccionarActionPerformed
          try{
           int filaSeleccionada=tablaOS.getSelectedRow();
           String codigo=tablaOS.getValueAt(filaSeleccionada, 0).toString();
           String nombre=tablaOS.getValueAt(filaSeleccionada, 1).toString();
          
           pA.setTxtOS(nombre);
           pA.setLabelCodigoOS(codigo);

           dispose();
          
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "No hay datos en la tabla","ERROR",ERROR_MESSAGE);
       }
    }//GEN-LAST:event_botonSeleccionarActionPerformed

    private void tablaOSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaOSMouseClicked
         try{
           int filaSeleccionada=tablaOS.getSelectedRow();
           String codigo=tablaOS.getValueAt(filaSeleccionada, 0).toString();
           String nombre=tablaOS.getValueAt(filaSeleccionada, 1).toString();
          
          activarSeleccionar();
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "No hay datos en la tabla","ERROR",ERROR_MESSAGE);
       }
    }//GEN-LAST:event_tablaOSMouseClicked

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
            java.util.logging.Logger.getLogger(buscarObraSocial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(buscarObraSocial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(buscarObraSocial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(buscarObraSocial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                   JFrame frame = new JFrame(); // padre temporal
    ModificarA pA = new ModificarA();    // panel de prueba
                buscarObraSocial dialog = new buscarObraSocial(frame, true, pA);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaOS;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
