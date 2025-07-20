
package Alumnos;


import java.awt.Graphics;
import java.awt.Image;


import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.table.DefaultTableModel;

import Conexion.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;

public class Modificar_Alumno extends javax.swing.JPanel {
     
     DefaultTableModel tabla=new DefaultTableModel();
     Object[] datos=new Object[8];
      ResultSet rs;
     Connection cx=Conexion.conexion.conexion();
     DefaultComboBoxModel ls= new DefaultComboBoxModel();
   
     

   
    public Modificar_Alumno() {
        initComponents();
        mostrarAlumnos();
        desactivarCampos();
        desactivarGuardar();
        cargarComboObraSocial();
        desactivarEditar();
    }
    
    void cargarComboObraSocial(){
        try{
            rs=Clases.ObraSocial.mostrarObrasSociales(cx);
            ls.addElement("Selecione la Obra Social");
            ls.addElement("Ninguna");
            while(rs.next())
                ls.addElement(rs.getString("nombre"));
                boxObraSocial.setModel(ls);
            
        }catch(Exception e){
              JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar las Obras Social","ERROR",ERROR_MESSAGE);
        }
    }
    
    
    
    
    void desactivarCampos(){
        txtNombre.setEnabled(false);
        txtApellido.setEnabled(false);
        txtFechaNac.setEnabled(false);
        txtDni.setEnabled(false);
        txtGrado.setEnabled(false);
        boxNivel.setEnabled(false);
        txtEscuela.setEnabled(false);
        boxObraSocial.setEnabled(false);
        
        
        txtNombre.setText("");
        txtApellido.setText("");
        txtFechaNac.setText("");
        txtDni.setText("");
        txtGrado.setText("");
        boxNivel.setSelectedItem("");
        txtEscuela.setText("");
        boxObraSocial.setSelectedItem("Seleccione la Obra Social");
    }
    
    
    void activarCampos(){
        txtNombre.setEnabled(true);
        txtApellido.setEnabled(true);
        txtFechaNac.setEnabled(true);
        txtDni.setEnabled(true);
        txtGrado.setEnabled(true);
        boxNivel.setEnabled(true);
        txtEscuela.setEnabled(true);
        boxObraSocial.setEnabled(true);
    }
    
    void  desactivarGuardar(){
        botonGuardar.setEnabled(false);
    }
    
    
    void activarGuardar(){
        botonGuardar.setEnabled(true);
        
    }
      void mostrarAlumnos(){
         tabla.setRowCount(0);   
         tabla.setColumnCount(0);
         tabla.addColumn("Nombre");  
         tabla.addColumn("Apellido"); 
         tabla.addColumn("Fecha Nacimiento"); 
         tabla.addColumn("DNi"); 
         tabla.addColumn("Escuela"); 
         tabla.addColumn("Grado");
         tabla.addColumn("Nivel");
         tabla.addColumn("Obra Social"); 
         
         try{
            
             rs=Clases.Alumno.mostrarAlumnos(cx);
              while(rs.next()){
                   datos[0]=rs.getString("al.nombre");
                   datos[1]=rs.getString("al.apellido");
                   datos[2]=rs.getString("al.fecha_nac");
                   datos[3]=rs.getString("al.dni");
                   datos[4]=rs.getString("al.escuela");
                   datos[5]=rs.getString("al.grado");
                   datos[6]=rs.getString("al.nivel");
                   datos[7]=rs.getString("os.nombre");
                  
                   tabla.addRow(datos);
                   
              }
              
              tablaAlumnos.setModel(tabla);
             
              
          }catch(Exception e){
                   JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar los alumnos en la tabla","ERROR",ERROR_MESSAGE); 
          }
    }
    
    
    void activarEditar(){
        botonEditar.setEnabled(true);
        
    }
    
    void desactivarEditar(){
        botonEditar.setEnabled(false);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtFechaNac = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        txtGrado = new javax.swing.JTextField();
        txtEscuela = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JButton();
        botonEditar = new javax.swing.JButton();
        boxNivel = new javax.swing.JComboBox<>();
        boxObraSocial = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlumnos = new javax.swing.JTable();
        txtDniBuscador = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 102, 0));

        jLabel10.setFont(new java.awt.Font("DialogInput", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("MODIFICAR ALUMNOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel10)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Nombre:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel3.setText("Apellido:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 20));

        jLabel4.setText("Fecha de Nacimineto:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 30));

        jLabel5.setText("DNI:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, 20));

        jLabel6.setText("Grado:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, 20));

        jLabel7.setText("Escuela:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, 30));

        jLabel8.setText("Nivel:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, 20));

        jLabel9.setText("Obra Social");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, 30));
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 420, -1));
        jPanel2.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 420, -1));
        jPanel2.add(txtFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 350, -1));
        jPanel2.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 450, -1));
        jPanel2.add(txtGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 430, -1));
        jPanel2.add(txtEscuela, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 420, -1));

        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/g.png"))); // NOI18N
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(botonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, 163, 134));

        botonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/m.png"))); // NOI18N
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
            }
        });
        jPanel2.add(botonEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 163, 134));

        boxNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inicial", "Primario", "Secundario" }));
        jPanel2.add(boxNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 350, -1));

        boxObraSocial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(boxObraSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 280, -1));

        jButton1.setText("CANCELAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 590, 170, 120));

        tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Fecha de Nacimiento", "DNI", "Escuela", "Grado", "Nivel", "Obra Social"
            }
        ));
        tablaAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAlumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaAlumnos);

        botonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/b.png"))); // NOI18N
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
                        .addGap(13, 13, 13))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDniBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtDniBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
     //'tabla' es el objeto creado de tipo DefaultTableModel(en donde le confuguramos un modelo) , y 'tablaAlumnos' es la tabla que hemos creado en el formulario.
   
    
    int dni=Integer.parseInt(txtDniBuscador.getText());
    ResultSet rs;
    tabla.setRowCount(0);   
    tabla.setColumnCount(0);
    tabla.addColumn("Nombre");
    tabla.addColumn("Apellido"); 
    tabla.addColumn("Fecha Nacimiento"); 
    tabla.addColumn("DNI"); 
    tabla.addColumn("Escuela"); 
    tabla.addColumn("Grado"); 
    tabla.addColumn("Nivel");
    tabla.addColumn("Obra Social"); 

    try{
         rs=Clases.Alumno.mostrarAlumno(cx, dni);
         if(rs.next()){
                   datos[0]=rs.getString("al.nombre");
                   datos[1]=rs.getString("al.apellido");
                   datos[2]=rs.getString("al.fecha_nac");
                   datos[3]=rs.getString("al.dni");
                   datos[4]=rs.getString("al.escuela");
                   datos[5]=rs.getString("al.grado");
                   datos[6]=rs.getString("al.nivel");
                   datos[7]=rs.getString("os.nombre");
                  
                   tabla.addRow(datos);
                  
                   tablaAlumnos.setModel(tabla);
                  
                   
          }else{
              JOptionPane.showMessageDialog(null, "El alumno con dni "+txtDniBuscador.getText()+" no existe","ERROR",ERROR_MESSAGE);
         }
                
              
             
    }catch(Exception e){
          
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al buscar al alumno","ERROR",ERROR_MESSAGE);
       }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void tablaAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAlumnosMouseClicked
         try{
            int filaSeleccionada = tablaAlumnos.getSelectedRow();
            
            String nombre =tablaAlumnos.getValueAt(filaSeleccionada, 0).toString();
            String apellido =tablaAlumnos.getValueAt(filaSeleccionada, 1).toString();
            String fecha_nac =tablaAlumnos.getValueAt(filaSeleccionada, 2).toString();
            String dni =tablaAlumnos.getValueAt(filaSeleccionada, 3).toString();
            String escuela =tablaAlumnos.getValueAt(filaSeleccionada, 4).toString();
            String grado =tablaAlumnos.getValueAt(filaSeleccionada, 5).toString();
            String nivel =tablaAlumnos.getValueAt(filaSeleccionada, 6).toString();
            String obra_social =tablaAlumnos.getValueAt(filaSeleccionada, 7).toString();
            
            txtNombre.setText(nombre);
            txtApellido.setText(apellido);
            txtFechaNac.setText(fecha_nac);
            txtDni.setText(dni);
            txtEscuela.setText(escuela);
            txtGrado.setText(grado);
            boxNivel.setSelectedItem(nivel);
            boxObraSocial.setSelectedItem(obra_social);
            
             activarEditar(); // se activa el boton editar , para que el usuario una vez haga clicl en los datos, se le permita editar si así lo desea
     
       }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No hay datos en la tabla","ERROR",ERROR_MESSAGE);
       }
    }//GEN-LAST:event_tablaAlumnosMouseClicked

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed

        String nivel=boxNivel.getSelectedItem().toString();
        int dni=Integer.parseInt(txtDni.getText());
        String obra_social=boxObraSocial.getSelectedItem().toString();
        int dniBuscador=Integer.parseInt(txtDniBuscador.getText());    ///dni del campo buscar, se lo utilizará para poder buscar cual es el código del alumno...
        
        try{
                ///// encontrar el codigo de la obra social..
               int codigoObraSocial= Clases.ObraSocial.obtenerCodigo(cx, obra_social);
           
               //encontrar el codgo del alumno, para posterior poder hacer el update del alumno...
               int codigoAlumno=Clases.Alumno.obtenerCodigo(cx, dniBuscador);
            
               Clases.Alumno.actualizarAlumno(cx, txtNombre.getText(), txtApellido.getText(), txtFechaNac.getText(), dni, txtEscuela.getText(), txtGrado.getText(), nivel, codigoObraSocial, codigoAlumno );
          
              JOptionPane.showMessageDialog(null, "Se han actualizado los datos del alumno correctamente");
          
          }  catch(Exception e){
              JOptionPane.showMessageDialog(null, "Error al actualizar el alumno","ERROR",ERROR_MESSAGE);
         }                   

    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
        activarCampos();
        activarGuardar();
        desactivarEditar();
    }//GEN-LAST:event_botonEditarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       desactivarCampos();
       desactivarGuardar();
       
    }//GEN-LAST:event_jButton1ActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JComboBox<String> boxNivel;
    private javax.swing.JComboBox<String> boxObraSocial;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaAlumnos;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtDniBuscador;
    private javax.swing.JTextField txtEscuela;
    private javax.swing.JTextField txtFechaNac;
    private javax.swing.JTextField txtGrado;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
