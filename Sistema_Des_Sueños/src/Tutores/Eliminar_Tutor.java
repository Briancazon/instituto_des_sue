
package Tutores;

import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.table.DefaultTableModel;


public class Eliminar_Tutor extends javax.swing.JPanel {
            Connection cx=Conexion.conexion.conexion();
            DefaultTableModel tabla=new DefaultTableModel();
            Object[] datos=new Object[4];
            ResultSet rs;

    
    public Eliminar_Tutor() {
        initComponents();
        habilitarBotonBuscar();
        desactivarEliminar();
        mostrarTutores();
    }
    
      void mostrarTutores(){
         tabla.setRowCount(0);   
         tabla.setColumnCount(0);
         tabla.addColumn("Nombre");  
         tabla.addColumn("Apellido"); 
         tabla.addColumn("DNI"); 
         tabla.addColumn("Teléfono");
         try{
             rs=Clases.Tutor.mostrarTutores(cx);
             while(rs.next()){
                   datos[0]=rs.getString("nombre");
                   datos[1]=rs.getString("apellido");
                   datos[2]=rs.getString("dni");
                   datos[3]=rs.getString("telefono");
                   tabla.addRow(datos);
             }
             tablaTutores.setModel(tabla);
         }catch(Exception e){
              JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar la tabla de tutores","ERROR",ERROR_MESSAGE); 
         }
    }
    
     //metodo que valida si todos los campos estan llenos, si es asi, habilita al boton buscar, de lo contrario, seguirá inhabilitado
    public void habilitarBotonBuscar(){
       if( !txtDni.getText().isEmpty()){
           botonBuscar.setEnabled(true);
       }else{
           botonBuscar.setEnabled(false);
       }
    }
    
    void desactivarEliminar(){
        botonEliminar.setEnabled(false);
    }
    
     void activarEliminar(){
        botonEliminar.setEnabled(true);
    }
    

   private Image imagen;
        @Override
        public void paint(Graphics g){
            imagen= new ImageIcon(getClass().getResource("/Imagenes/2.jpg")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
          
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        botonBuscar = new javax.swing.JButton();
        txtDni = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTutores = new javax.swing.JTable();
        botonEliminar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        labelCodigoTutor = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(204, 102, 0));

        jLabel10.setFont(new java.awt.Font("DialogInput", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ELIMINAR TUTOR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel10)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        botonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/b.png"))); // NOI18N
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDniKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });

        tablaTutores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "DNI", "Telefono"
            }
        ));
        tablaTutores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaTutoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaTutores);

        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/e.png"))); // NOI18N
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/c.png"))); // NOI18N

        labelCodigoTutor.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 427, Short.MAX_VALUE)
                .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(labelCodigoTutor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonEliminar)
                .addGap(31, 31, 31)
                .addComponent(jButton4)
                .addGap(103, 103, 103))
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1)
                .addGap(70, 70, 70))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonBuscar)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonEliminar)
                            .addComponent(jButton4))
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelCodigoTutor)
                        .addGap(118, 118, 118))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

    private void txtDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyReleased
        habilitarBotonBuscar(); // se invica al metodo habilitarBotonBuscar para verificar si el campo esta o no vacío
    }//GEN-LAST:event_txtDniKeyReleased

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
       char c=evt.getKeyChar();
       // verificar si el carácter ingresado es unicamente un numero
      if (!Character.isDigit(c) || txtDni.getText().length()>7) {
        evt.consume();  // si no es un numero, consume el evento y no permite el ingreso, tambien consumirá si se pasa de 7 digitos
    }
    }//GEN-LAST:event_txtDniKeyTyped

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
           int dni=Integer.parseInt(txtDni.getText());
          tabla.setRowCount(0);   
         tabla.setColumnCount(0);
         tabla.addColumn("Nombre");  
         tabla.addColumn("Apellido"); 
         tabla.addColumn("DNI"); 
         tabla.addColumn("Teléfono");
        try{
            rs=Clases.Tutor.mostrarTutor(cx, dni);
        
            if(rs.next()){
                   datos[0]=rs.getString("nombre");
                   datos[1]=rs.getString("apellido");
                   datos[2]=rs.getString("dni");
                   datos[3]=rs.getString("telefono");
                   tabla.addRow(datos);
                   
                    tablaTutores.setModel(tabla);
            }else{
                   JOptionPane.showMessageDialog(null, "No existe un tutor con el DNI "+txtDni.getText(),"ERROR",ERROR_MESSAGE); 
                   mostrarTutores();
                
            }
          
            
        }catch(Exception e){
               JOptionPane.showMessageDialog(null, "Ha ocurrido un error al buscar el tutor","ERROR",ERROR_MESSAGE); 
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void tablaTutoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTutoresMouseClicked
        int filaSeleccionada = tablaTutores.getSelectedRow();
            
            String dni =tablaTutores.getValueAt(filaSeleccionada, 2).toString();
            labelCodigoTutor.setText(dni);
            activarEliminar(); // se activa el boton eliminar al hacer click en algun registro que el usuario desee eliminar..
    }//GEN-LAST:event_tablaTutoresMouseClicked

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
         int dni=Integer.parseInt(labelCodigoTutor.getText());
         int respuesta = JOptionPane.showConfirmDialog( null, "¿Estás seguro de que deseas eliminar a este tutor?" , "Confirmar eliminación", JOptionPane.YES_NO_OPTION , JOptionPane.WARNING_MESSAGE);
         
         if (respuesta == JOptionPane.YES_OPTION) {
             
                  try{
                           Clases.Tutor.eliminar(cx, dni);
                           JOptionPane.showMessageDialog(null, "Se ha eliminado el tutor correctamente");
                           desactivarEliminar();
                           mostrarTutores();
                  }catch(Exception e){
            
                            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar eliminar el tutor","ERROR",ERROR_MESSAGE);
                            desactivarEliminar();
                            mostrarTutores();
        }
         }else{
             JOptionPane.showMessageDialog(null, "Se ha cancelado la eliminación del tutor");
             desactivarEliminar();
             mostrarTutores();
         }
      
    }//GEN-LAST:event_botonEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCodigoTutor;
    private javax.swing.JTable tablaTutores;
    private javax.swing.JTextField txtDni;
    // End of variables declaration//GEN-END:variables
}
