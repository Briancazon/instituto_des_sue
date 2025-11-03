
package prueba_sistema;

import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.table.DefaultTableModel;

public class Panel4 extends javax.swing.JPanel {
      DefaultTableModel tabla=new DefaultTableModel();
      Object[] datos=new Object[2];
      ResultSet rs;
      Connection cx=Conexion.conexion.conexion();

    public Panel4() {
        initComponents();
        cargarServicios();
        desactivarCampos();
        desactivarEditar();
        desactivarGuardar();
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
    }
    
     
    void desactivarGuardar(){
        labelGuardar.setEnabled(false);
    }
    
    
     void activarEditar(){
        labelEditar.setEnabled(true);
    }
    
    void desactivarEditar(){
        labelEditar.setEnabled(false);
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
            
             rs=Clases.Inscripcion.verServicios(cx);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaServicios = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txtServicio = new javax.swing.JTextField();
        labelCancelar = new javax.swing.JLabel();
        labelGuardar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        labelEditar = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        panelcuatro.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 102, 102));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(1000, 70));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Servicios");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sol.png"))); // NOI18N
        jLabel19.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("E. P. Despertando Sueños ");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/servicio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
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
        txtServicio.setForeground(new java.awt.Color(0, 0, 0));
        txtServicio.setBorder(null);
        txtServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtServicioActionPerformed(evt);
            }
        });

        labelCancelar.setFont(new java.awt.Font("Segoe Print", 1, 10)); // NOI18N
        labelCancelar.setForeground(new java.awt.Color(255, 255, 255));
        labelCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/c.png"))); // NOI18N
        labelCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCancelarMouseClicked(evt);
            }
        });

        labelGuardar.setFont(new java.awt.Font("Segoe Print", 1, 10)); // NOI18N
        labelGuardar.setForeground(new java.awt.Color(255, 255, 255));
        labelGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/g.png"))); // NOI18N
        labelGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelGuardarMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Servicio");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Precio");

        txtPrecio.setBackground(new java.awt.Color(255, 204, 204));
        txtPrecio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPrecio.setForeground(new java.awt.Color(0, 0, 0));
        txtPrecio.setBorder(null);
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        labelEditar.setFont(new java.awt.Font("Segoe Print", 1, 10)); // NOI18N
        labelEditar.setForeground(new java.awt.Color(255, 255, 255));
        labelEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/m.png"))); // NOI18N
        labelEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelEditarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)
                        .addComponent(labelGuardar)
                        .addGap(60, 60, 60)
                        .addComponent(labelEditar)
                        .addGap(66, 66, 66)
                        .addComponent(labelCancelar)))
                .addContainerGap(545, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)))
                        .addGap(6, 6, 6))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelEditar)
                        .addComponent(labelGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelcuatroLayout = new javax.swing.GroupLayout(panelcuatro);
        panelcuatro.setLayout(panelcuatroLayout);
        panelcuatroLayout.setHorizontalGroup(
            panelcuatroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1423, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelcuatroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(53, 53, 53))
        );
        panelcuatroLayout.setVerticalGroup(
            panelcuatroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelcuatroLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addGap(110, 110, 110))
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
            }
           
         }catch(Exception e){
                  JOptionPane.showMessageDialog(null, "Error al seleccionar un registro","ERROR",ERROR_MESSAGE);
         
            
         }
    }//GEN-LAST:event_tablaServiciosMouseClicked

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void labelEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEditarMouseClicked
       activarCampos();
       desactivarEditar();
       activarGuardar();
    }//GEN-LAST:event_labelEditarMouseClicked

    private void labelGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelGuardarMouseClicked
       try{
           Clases.Servicios.actualizarPrecio(cx, txtServicio.getText(), Integer.parseInt(txtPrecio.getText()));
            JOptionPane.showMessageDialog(null, "Se ha actualizado el precio del servicio "+txtServicio.getText());
            desactivarGuardar();
            desactivarCampos();
            cargarServicios();
            limpiar();
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Error al actualizar el precio del servicio","ERROR",ERROR_MESSAGE);
       }
    }//GEN-LAST:event_labelGuardarMouseClicked

    private void labelCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCancelarMouseClicked
        limpiar();
    }//GEN-LAST:event_labelCancelarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
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
