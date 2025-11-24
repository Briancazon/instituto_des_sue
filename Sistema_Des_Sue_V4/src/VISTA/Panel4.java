
package VISTA;

import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.table.DefaultTableModel;

public class Panel4 extends javax.swing.JPanel {
      DefaultTableModel tabla=new DefaultTableModel();
      Object[] datos=new Object[2];
      ResultSet rs;
      Connection cx=MODELO_CONTROLADOR.conexion.conexion();
      boolean labelGuardar2=true;
      boolean labelEditar2=true;
     

    public Panel4() {
        initComponents();
        cargarServicios();
        desactivarCampos();
        desactivarEditar();
        desactivarGuardar();
        
        
        TablaEstilo.personalizarTabla(tablaServicios);
    }
    
    
    void activarCampos(){
  
        txtPrecio.setEnabled(true);
    }
    
    void desactivarCampos(){
        txtServicio.setEnabled(false);
        txtPrecio.setEnabled(false);
    }
    
    
    void activarGuardar(){
        labelGuardar.setEnabled(true);
        labelGuardar2=true;
    }
    
     
    void desactivarGuardar(){
        labelGuardar.setEnabled(false);
         labelGuardar2=false;
    }
    
    
     void activarEditar(){
        labelEditar.setEnabled(true);
        labelEditar2=true;
    }
    
    void desactivarEditar(){
        labelEditar.setEnabled(false);
        labelEditar2=false;
    }
    
    void limpiar(){
        txtServicio.setText("");
        txtPrecio.setText("");
        desactivarCampos();
        desactivarGuardar();
        desactivarEditar();
    }
    
    
///metodo para cargar la tabla con los servicios que tiene la  institución
   void cargarServicios(){
         tabla.setRowCount(0);   
         tabla.setColumnCount(0);
        
         tabla.addColumn("Servicio");  
         tabla.addColumn("Precio"); 
       
        
         
         try{
            
             rs=MODELO_CONTROLADOR.Inscripcion.verServicios(cx);
              while(rs.next()){
                   datos[0]=rs.getString("nombre");
                   datos[1]=rs.getString("precio");
                 
                   ///si el precio del servicio es 0.0, quiere decir que es un servicio de inclusion escolar, y dicho servicio no tiene un precio fijo, son variables y dependen mucho de lo que ocurre por fuera de la institución, por lo tanto no se muestra un precio, unicamente se muestran precios de los servicio que sí tienen servicios fijos
                   if( datos[1].equals("0.0")){
                       datos[1]="- - -";
                   }
                
                   tabla.addRow(datos);
                
                   
              } 
              tablaServicios.setModel(tabla);
              
          }catch(Exception e){
                   JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar los servicios en la tabla","ERROR",ERROR_MESSAGE); 
          }
        
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelcuatro = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaServicios = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txtServicio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        labelGuardar = new javax.swing.JLabel();
        labelEditar = new javax.swing.JLabel();
        labelCancelar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        panelcuatro.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 102, 102));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(1000, 70));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Servicios");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISTA/Imagenes/soll.gif"))); // NOI18N
        jLabel19.setPreferredSize(new java.awt.Dimension(40, 40));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel14)))
                .addGap(16, 16, 16))
        );

        tablaServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre", "Precio"
            }
        ));
        tablaServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaServiciosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaServicios);

        jPanel4.setBackground(new java.awt.Color(255, 153, 153));

        txtServicio.setBackground(new java.awt.Color(255, 204, 204));
        txtServicio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtServicio.setForeground(new java.awt.Color(255, 51, 102));
        txtServicio.setBorder(null);
        txtServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtServicioActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Servicio:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Precio:");

        txtPrecio.setBackground(new java.awt.Color(255, 204, 204));
        txtPrecio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPrecio.setForeground(new java.awt.Color(255, 51, 102));
        txtPrecio.setBorder(null);
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 102, 102));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(1000, 70));

        labelGuardar.setFont(new java.awt.Font("Segoe Print", 1, 10)); // NOI18N
        labelGuardar.setForeground(new java.awt.Color(255, 255, 255));
        labelGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISTA/Imagenes/guardar_nuevo.png"))); // NOI18N
        labelGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelGuardarMouseClicked(evt);
            }
        });

        labelEditar.setFont(new java.awt.Font("Segoe Print", 1, 10)); // NOI18N
        labelEditar.setForeground(new java.awt.Color(255, 255, 255));
        labelEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISTA/Imagenes2/nota.png"))); // NOI18N
        labelEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelEditarMouseClicked(evt);
            }
        });

        labelCancelar.setFont(new java.awt.Font("Segoe Print", 1, 10)); // NOI18N
        labelCancelar.setForeground(new java.awt.Color(255, 255, 255));
        labelCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISTA/Imagenes/expediente.png"))); // NOI18N
        labelCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCancelarMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Opciones :");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(labelGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelCancelar)
                .addContainerGap(678, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(labelEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout panelcuatroLayout = new javax.swing.GroupLayout(panelcuatro);
        panelcuatro.setLayout(panelcuatroLayout);
        panelcuatroLayout.setHorizontalGroup(
            panelcuatroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE)
            .addGroup(panelcuatroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        panelcuatroLayout.setVerticalGroup(
            panelcuatroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelcuatroLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(panelcuatro, "cuatro");
    }// </editor-fold>//GEN-END:initComponents

    private void txtServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtServicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtServicioActionPerformed

    private void tablaServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaServiciosMouseClicked
         try{
            int filaSeleccionada = tablaServicios.getSelectedRow();
            
            String nombre_servicio =tablaServicios.getValueAt(filaSeleccionada, 0).toString();
            String precio =tablaServicios.getValueAt(filaSeleccionada, 1).toString();
            
            ///validar que solo se pongan en los campos txt de arriba unicamente los servicios que si tienen un precio, que serian los servicios mensuales y el de clase personalizada, en caso de que haga click sobre el resto de los servicios que no tienen un precio
            //no hará nada...
            if(!precio.equalsIgnoreCase("- - -")){
                  ////pasar los valores de la tabla a los campos txt de arriba
                  txtServicio.setText(nombre_servicio);
                  txtPrecio.setText(precio);
                  activarEditar();
                  desactivarCampos();
            }else{
                txtServicio.setText("");
                txtPrecio.setText("");
                desactivarGuardar();
                desactivarEditar();
                
            }
           desactivarGuardar();
          
         }catch(Exception e){
                  JOptionPane.showMessageDialog(null, "Error al seleccionar un registro","ERROR",ERROR_MESSAGE);
         
            
         }
    }//GEN-LAST:event_tablaServiciosMouseClicked

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void labelEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEditarMouseClicked
       //si el editar esta desctivado, no se ejecutara esta accion..
       if(!labelEditar2){
           return;
       } 
       activarCampos();
       desactivarEditar();
       activarGuardar();
    }//GEN-LAST:event_labelEditarMouseClicked

    private void labelGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelGuardarMouseClicked
       /// si el guardar esta desactivado, no se puede ejecutar esta accion..
        if(!labelGuardar2){
            return;
        }
        try{
           MODELO_CONTROLADOR.Servicios.actualizarPrecio(cx, txtServicio.getText(), Float.parseFloat(txtPrecio.getText()));
            JOptionPane.showMessageDialog(null, "Se ha actualizado el precio del servicio "+txtServicio.getText());
            desactivarGuardar();
            desactivarCampos();
            cargarServicios();
            limpiar();
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Error al actualizar el precio del servicio","ERROR",ERROR_MESSAGE);
           e.printStackTrace();
       }
    }//GEN-LAST:event_labelGuardarMouseClicked

    private void labelCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCancelarMouseClicked
        limpiar();
    }//GEN-LAST:event_labelCancelarMouseClicked

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
              char c=evt.getKeyChar();
         // verificar si el carácter ingresado es unicamente numeros
      if (!Character.isDigit(c) || txtPrecio.getText().length()>8) {
        evt.consume(); 
    }  
    }//GEN-LAST:event_txtPrecioKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCancelar;
    private javax.swing.JLabel labelEditar;
    private javax.swing.JLabel labelGuardar;
    private javax.swing.JPanel panelcuatro;
    private javax.swing.JTable tablaServicios;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtServicio;
    // End of variables declaration//GEN-END:variables
}
