
package prueba_sistema;

import Alumno.ModificarA;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.table.DefaultTableModel;


public class buscarTutor extends javax.swing.JDialog {
       ResultSet rs;
    Connection cx=Conexion.conexion.conexion();
   
    
    DefaultTableModel tabla=new DefaultTableModel();
    Object[] datos=new Object[4]; 
    
    ModificarA pA;


    public buscarTutor(java.awt.Frame parent, boolean modal, ModificarA panel) {
        super(parent, "Seleccionar un Tutor",modal);
        initComponents();
        this.pA=panel;
        desactivarSeleccionar();
        cargarTablaTutor();
           setLocationRelativeTo(parent); ///centrar el dialog con respecto a la ventana 
           cargarTablaTutor();
    }
    
    void cargarTablaTutor(){
          tabla.setRowCount(0);   
           tabla.setColumnCount(0);
            tabla.addColumn("Codigo");
           tabla.addColumn("Nombre");
           tabla.addColumn("Apellido");
           tabla.addColumn("DNI");
  

     try{
        
        rs=Clases.Tutor.mostrartutoresactivos(cx);
     
        while(rs.next()){
            datos[0]=rs.getString("codigo");
            datos[1]=rs.getString("nombre");
            datos[2]=rs.getString("apellido");
            datos[3]=rs.getString("dni");
  
           
            tabla.addRow(datos);
        }
         tablaTutor.setModel(tabla);
       
    }catch(Exception e){
          JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar los tutores","ERROR",ERROR_MESSAGE);
        
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
        tablaTutor = new javax.swing.JTable();
        botonSeleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Buscar Tutor");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido");

        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tablaTutor.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaTutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaTutorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaTutor);

        botonSeleccionar.setText("SELECCIONAR TUTOR");
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
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(23, 23, 23))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonSeleccionar)
                .addContainerGap(14, Short.MAX_VALUE))
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
        
        rs=Clases.Tutor.buscarTutor2(cx, txtNombre.getText(), txtApellido.getText());
     
        while(rs.next()){
            datos[0]=rs.getString("codigo");
            datos[1]=rs.getString("nombre");
            datos[2]=rs.getString("apellido");
            datos[3]=rs.getString("dni");
  
           
            tabla.addRow(datos);
        }
         tablaTutor.setModel(tabla);
       
    }catch(Exception e){
          JOptionPane.showMessageDialog(null, "Ha ocurrido un error al buscar el tutor","ERROR",ERROR_MESSAGE);
        
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botonSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSeleccionarActionPerformed
              try{
           int filaSeleccionada=tablaTutor.getSelectedRow();
           String codigo=tablaTutor.getValueAt(filaSeleccionada, 0).toString();
           String nombre=tablaTutor.getValueAt(filaSeleccionada, 1).toString();
           String apellido=tablaTutor.getValueAt(filaSeleccionada, 2).toString();
           String dni=tablaTutor.getValueAt(filaSeleccionada, 3).toString();
           
           String apenom=nombre+" "+apellido;
          
           pA.setTxtTutor(apenom);
           pA.setLabelCodigoTutor(codigo);

           dispose();
          
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "No hay datos en la tabla","ERROR",ERROR_MESSAGE);
       }
    }//GEN-LAST:event_botonSeleccionarActionPerformed

    private void tablaTutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTutorMouseClicked
              try{
           int filaSeleccionada=tablaTutor.getSelectedRow();
           String codigo=tablaTutor.getValueAt(filaSeleccionada, 0).toString();
           String nombre=tablaTutor.getValueAt(filaSeleccionada, 1).toString();
           String apellido=tablaTutor.getValueAt(filaSeleccionada, 2).toString();
           String dni=tablaTutor.getValueAt(filaSeleccionada, 3).toString();
           
           activarSeleccionar();
          
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "No hay datos en la tabla","ERROR",ERROR_MESSAGE);
       }
    }//GEN-LAST:event_tablaTutorMouseClicked

  
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
            java.util.logging.Logger.getLogger(buscarTutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(buscarTutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(buscarTutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(buscarTutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                   JFrame frame = new JFrame(); // padre temporal
    ModificarA pA = new ModificarA();    // panel de prueba
                buscarTutor dialog = new buscarTutor(frame, true, pA);
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
    private javax.swing.JTable tablaTutor;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
