
package Tutores;

import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.table.DefaultTableModel;


public class Modificar_Tutor extends javax.swing.JPanel {
         Connection cx=Conexion.conexion.conexion();
            DefaultTableModel tabla=new DefaultTableModel();
           Object[] datos=new Object[4];
           ResultSet rs;

   
    public Modificar_Tutor() {
        initComponents();
        mostrarTutores();
        desactivarEditar();
        desactivarGuardar();
        desactivarCampos();
        habilitarBotonBuscar();
        desactivarCancelar();
    }
    
    
     
       //metodo que valida si todos los campos estan llenos, si es asi, habilita al boton guardar, de lo contrario, seguirá inhabilitado
    public void habilitarBotonGuardar(){
       if( !txtNombre.getText().isEmpty() && !txtApellido.getText().isEmpty() && !txtDni.getText().isEmpty() && !txtTelefono.getText().isEmpty() ){
           botonGuardar.setEnabled(true);
       }else{
           botonGuardar.setEnabled(false);
       }
    }
    
    
    
       //metodo que valida si el campo buscar (donde tiene que poner el dni), tiene algun dni, si tiene habilita al boton buscarr, de lo contrario, seguirá inhabilitado
    public void habilitarBotonBuscar(){
       if( !txtDniBuscador.getText().isEmpty()  ){
           botonBuscar.setEnabled(true);
       }else{
           botonBuscar.setEnabled(false);
       }
    }
    
    
    void desactivarCancelar(){
        botonCancelar.setEnabled(false);
    }
    
      void activarCancelar(){
        botonCancelar.setEnabled(true);
    }
    
    
    void desactivarEditar(){
        botonEditar.setEnabled(false);
    }
    
    void desactivarGuardar(){
        botonGuardar.setEnabled(false);
    }
    
    void activarEditar() {
        botonEditar.setEnabled(true);
    }
    
    void activarGuardar(){
        botonGuardar.setEnabled(true);
    }
    
    void desactivarCampos(){
        txtNombre.setEnabled(false);
        txtApellido.setEnabled(false);
        txtDni.setEnabled(false);
        txtTelefono.setEnabled(false);
       
    }
    
    void limpiar(){
         
        txtNombre.setText("");
        txtApellido.setText("");
        txtDni.setText("");
        txtTelefono.setText("");
    }
    
     void activarCampos(){
        txtNombre.setEnabled(true);
        txtApellido.setEnabled(true);
        txtDni.setEnabled(true);
        txtTelefono.setEnabled(true);
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

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JButton();
        botonEditar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTutores = new javax.swing.JTable();
        botonBuscar = new javax.swing.JButton();
        txtDniBuscador = new javax.swing.JTextField();
        labelCodigoTutor = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(255, 204, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Nombre");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Apellido");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("DNI");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Telefono");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, 20));

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 340, -1));

        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApellidoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });
        jPanel2.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 340, -1));

        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDniKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });
        jPanel2.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 340, -1));

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        jPanel2.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 340, -1));

        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/g.png"))); // NOI18N
        botonGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(botonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 163, 134));

        botonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/m.png"))); // NOI18N
        botonEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
            }
        });
        jPanel2.add(botonEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 163, 134));

        botonCancelar.setText("CANCELAR");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(botonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 550, 190, 110));

        jPanel1.setBackground(new java.awt.Color(204, 102, 0));

        jLabel10.setFont(new java.awt.Font("DialogInput", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText(" MODIFICAR TUTOR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

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

        botonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/b.png"))); // NOI18N
        botonBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        txtDniBuscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDniBuscadorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniBuscadorKeyTyped(evt);
            }
        });

        labelCodigoTutor.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDniBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelCodigoTutor)
                        .addGap(149, 149, 149))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCodigoTutor)
                            .addComponent(txtDniBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(52, 52, 52))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        int dni=Integer.parseInt(txtDniBuscador.getText());
          tabla.setRowCount(0);   
         tabla.setColumnCount(0);
         tabla.addColumn("Nombre");  
         tabla.addColumn("Apellido"); 
         tabla.addColumn("DNI"); 
         tabla.addColumn("Teléfono");
        try{
            rs=Clases.Tutor.mostrarTutor(cx, dni);
            //while(rs.next()){
            if(rs.next()){
                   datos[0]=rs.getString("nombre");
                   datos[1]=rs.getString("apellido");
                   datos[2]=rs.getString("dni");
                   datos[3]=rs.getString("telefono");
                   tabla.addRow(datos);
                   
                    tablaTutores.setModel(tabla);
            }else{
                   JOptionPane.showMessageDialog(null, "No existe un tutor con el DNI "+txtDniBuscador.getText(),"ERROR",ERROR_MESSAGE); 
                   mostrarTutores();
            }
          
            
        }catch(Exception e){
               JOptionPane.showMessageDialog(null, "Ha ocurrido un error al buscar el tutor","ERROR",ERROR_MESSAGE); 
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void tablaTutoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTutoresMouseClicked
          int filaSeleccionada = tablaTutores.getSelectedRow();
            
            String nombre =tablaTutores.getValueAt(filaSeleccionada, 0).toString();
            String apellido =tablaTutores.getValueAt(filaSeleccionada, 1).toString();
            String dni =tablaTutores.getValueAt(filaSeleccionada, 2).toString();
            String telefono =tablaTutores.getValueAt(filaSeleccionada, 3).toString();
            
            txtNombre.setText(nombre);
            txtApellido.setText(apellido);
            txtDni.setText(dni);
            txtTelefono.setText(telefono);
            
            labelCodigoTutor.setText(dni);
            
            desactivarGuardar();
            desactivarCancelar();
            desactivarCampos();
            activarEditar(); /// se activa el boton editar cuando el usuario hace click en los datos
    }//GEN-LAST:event_tablaTutoresMouseClicked

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
        activarCampos();
        activarGuardar();
        activarCancelar();
        desactivarEditar();
    }//GEN-LAST:event_botonEditarActionPerformed

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
       habilitarBotonGuardar();
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyReleased
      habilitarBotonGuardar();
    }//GEN-LAST:event_txtApellidoKeyReleased

    private void txtDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyReleased
      habilitarBotonGuardar();
    }//GEN-LAST:event_txtDniKeyReleased

    private void txtTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyReleased
        habilitarBotonGuardar();
    }//GEN-LAST:event_txtTelefonoKeyReleased

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        int dni=Integer.parseInt(txtDni.getText());
        int codigo;
        try{
           codigo= Clases.Tutor.obtenerCodigo(cx, dni); // obtener el codigo del tutor para posterior poder hacer el update;
            Clases.Tutor.actualizar(cx, txtNombre.getText(), txtApellido.getText(), dni, txtTelefono.getText(), codigo);
            JOptionPane.showMessageDialog(null, "Se han actualizado los datos del tutor correctamente");
            desactivarGuardar();
            desactivarCampos();
            limpiar();
            mostrarTutores();
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, "Ha ocurrido un error al actualizar el tutor","ERROR",ERROR_MESSAGE); 
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void txtDniBuscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniBuscadorKeyReleased
        habilitarBotonBuscar();
    }//GEN-LAST:event_txtDniBuscadorKeyReleased

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        desactivarCampos();
        desactivarGuardar();
        limpiar();
        JOptionPane.showMessageDialog(null, "Se ha cancelado la edición del tutor"); 
        desactivarCancelar();
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
           char c=evt.getKeyChar();
      // verificar si el carácter ingresado es una letra
      if (!( Character.isLetter(c) || c==' ')  || txtNombre.getText().length()>21) {
        evt.consume();  // si no es una letra, consume el evento y no permite el ingreso, tambien consumira si se pasa de 21 caracteres
    }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
          char c=evt.getKeyChar();
      // verificar si el carácter ingresado es una letra
      if (!( Character.isLetter(c) || c==' ')  || txtApellido.getText().length()>21) {
        evt.consume();  // si no es una letra, consume el evento y no permite el ingreso, tambien consumira si se pasa de 21 caracteres
    }
    }//GEN-LAST:event_txtApellidoKeyTyped

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
              char c=evt.getKeyChar();
       // verificar si el carácter ingresado es unicamente un numero
      if (!Character.isDigit(c) || txtDni.getText().length()>7) {
        evt.consume();  // si no es un numero, consume el evento y no permite el ingreso, tambien consumirá si se pasa de 7 digitos
    }
    }//GEN-LAST:event_txtDniKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
              char c=evt.getKeyChar();
       // verificar si el carácter ingresado es unicamente un numero
      if (!Character.isDigit(c) || txtTelefono.getText().length()>15) {
        evt.consume();  // si no es un numero, consume el evento y no permite el ingreso, tambien consumirá si se pasa de 7 digitos
    }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtDniBuscadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniBuscadorKeyTyped
            char c=evt.getKeyChar();
       // verificar si el carácter ingresado es unicamente un numero
      if (!Character.isDigit(c) || txtDniBuscador.getText().length()>7) {
        evt.consume();  // si no es un numero, consume el evento y no permite el ingreso, tambien consumirá si se pasa de 7 digitos
    }
    }//GEN-LAST:event_txtDniBuscadorKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCodigoTutor;
    private javax.swing.JTable tablaTutores;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtDniBuscador;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
