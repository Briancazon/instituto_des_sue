
package Servicios;

import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.table.DefaultTableModel;


public class Servicios extends javax.swing.JPanel {
    DefaultTableModel tabla=new DefaultTableModel();
     Object[] datos=new Object[8];
      ResultSet rs;
     Connection cx=Conexion.conexion.conexion();

  
    public Servicios() {
        initComponents();
        mostrarServicios();
        desactivarEditar();
        desactivarCancelar();
        desactivarActualizar();
        desactivarCampo();
    }
    
    void activarCancelar(){
        botonCancelar.setEnabled(true);
    }
     
     void desactivarCancelar(){
        botonCancelar.setEnabled(false);
    }
    
    void activarActualizar(){
        botonActualizar.setEnabled(true);
    }
    
       void desactivarActualizar(){
        botonActualizar.setEnabled(false);
       }
    
    void activarEditar(){
        botonEditar.setEnabled(true);
    }
    
    void desactivarEditar(){
        botonEditar.setEnabled(false);
    }
    
    void desactivarCampo(){
        txtPrecio.setEnabled(false);
        
    }
    void limpiar(){
        txtPrecio.setText("");
    }
    
    void activarCampo(){
        txtPrecio.setEnabled(true);
    }
    
    
    void mostrarServicios(){
          tabla.setRowCount(0);   
         tabla.setColumnCount(0);
         tabla.addColumn("Servicio");  
         tabla.addColumn("Precio"); 
         tabla.addColumn("Modalidad Servicio"); 
        
         
         try{
            
             rs=Clases.Servicio.mostrarServicios(cx);
              while(rs.next()){
                   datos[0]=rs.getString("ser.nombre");
                   datos[1]=rs.getString("ser.precio");
                   datos[2]=rs.getString("moda.tipo");
                 
                  
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaServicios = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        botonActualizar = new javax.swing.JButton();
        labelNombreServicio = new javax.swing.JLabel();
        botonEditar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();

        setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel1.setText("SERVICIOS");

        tablaServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Servicio", "Precio", "Modalidad Servicio"
            }
        ));
        tablaServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaServiciosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaServicios);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setText("Precio");

        botonActualizar.setText("ACTUALIZAR");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        labelNombreServicio.setText("jLabel3");

        botonEditar.setText("EDITAR");
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
            }
        });

        botonCancelar.setText("CANCELAR");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(botonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182)
                .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1045, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(500, 500, 500))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(labelNombreServicio))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(botonEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(labelNombreServicio)
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tablaServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaServiciosMouseClicked
           try{
            int filaSeleccionada = tablaServicios.getSelectedRow();
            
            String nombre =tablaServicios.getValueAt(filaSeleccionada, 0).toString();
            String precio =tablaServicios.getValueAt(filaSeleccionada, 1).toString();
      
            txtPrecio.setText(precio);
            labelNombreServicio.setText(nombre);
            
            desactivarCancelar();
            desactivarActualizar();
            desactivarCampo();
            
            activarEditar();

       }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No hay datos en la tabla","ERROR",ERROR_MESSAGE);
       }
    }//GEN-LAST:event_tablaServiciosMouseClicked

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
       if(txtPrecio.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "No ha cargado un precio","ERROR",ERROR_MESSAGE);
           return;
       }
        float precio= Float.parseFloat(txtPrecio.getText());
       try{
           Clases.Servicio.actualizarPrecio(cx, precio, labelNombreServicio.getText());
              JOptionPane.showMessageDialog(null, "Se ha actualizado el precio del servicio '"+labelNombreServicio.getText()+"' correctamente");
              mostrarServicios();
              desactivarActualizar();
              limpiar();
              desactivarCancelar();
              desactivarCampo();
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Ha ocurrido un error al actualizar el precio del servicio","ERROR",ERROR_MESSAGE);
           mostrarServicios();
       }
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
        activarCampo();
        activarActualizar();
        activarCancelar();
        desactivarEditar();
        
    }//GEN-LAST:event_botonEditarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
          desactivarCampo();
          limpiar();
          desactivarActualizar();
          desactivarCancelar();
    }//GEN-LAST:event_botonCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelNombreServicio;
    private javax.swing.JTable tablaServicios;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
