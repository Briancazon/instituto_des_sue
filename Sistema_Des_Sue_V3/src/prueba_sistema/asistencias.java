
package prueba_sistema;

import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDate;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;


public class asistencias extends javax.swing.JPanel {
     ResultSet rs;
    Connection cx=Conexion.conexion.conexion();
    DefaultComboBoxModel modelo= new DefaultComboBoxModel();
    JPanel p3;
    Panel5 p5;
     DefaultTableModel tabla=new DefaultTableModel();
     Object[] datos=new Object[7];
 
   
    public asistencias() {
        initComponents();
        activarGuardar();
        desactivarCampoAlumno();
        verTodasAsistencias();
        

    }
    void limpiar(){
        txtAlumno.setText("");
        labelCodigoAlumno.setText("");
        boxMes.addItem("Seleccione un Mes");
        boxMes.setSelectedItem("Seleccione un Mes");
        boxAsistencia.setSelectedItem("Seleccione una Opción");
    }
    
    void desactivarCampoAlumno(){
        txtAlumno.setEnabled(false);
    }
    
    void activarGuardar(){
        if(txtAlumno.getText().isEmpty() || boxMes.getSelectedItem().equals("Seleccione un Mes") || boxAsistencia.getSelectedItem().equals("Seleccione una Opción")){
            botonGuardar.setEnabled(false);
        }else{
            botonGuardar.setEnabled(true);
        }
    }
    
    
    void verTodasAsistencias(){
           
       tabla.setRowCount(0);   
         tabla.setColumnCount(0);
         tabla.addColumn("Nombre Alumno");  
         tabla.addColumn("Apellido Alumno");  
         tabla.addColumn("DNI"); 
         tabla.addColumn("Servicio"); 
         tabla.addColumn("Mes");
         tabla.addColumn("Ciclo Lectivo");
         tabla.addColumn("¿Asistió?");
        try{
         rs=Clases.Asistencia.verAsistencias(cx);
         while(rs.next()){
                   datos[0]=rs.getString("al.nombre");
                   datos[1]=rs.getString("al.apellido");
                   datos[2]=rs.getString("al.dni");
                   datos[3]=rs.getString("ser.nombre");
                   datos[4]=rs.getString("me.mes");
                   datos[5]=rs.getString("ci.año");
                   datos[6]=rs.getString("a.asistio");
                   
                  
                  
                   tabla.addRow(datos);
                   tablaAsistencias.setModel(tabla);
                   
          }
                
              
             
    }catch(Exception e){
          
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrarr las asistencias de los alumnos","ERROR",ERROR_MESSAGE);
           
       }
    }
      
   
   void cargarMesesDesdeInscripcion(int mesInscripcion) {
       
     try {
          // Desactivar temporalmente el listener
        ItemListener[] listeners = boxMes.getItemListeners();
        for (ItemListener l : listeners) {
            boxMes.removeItemListener(l);
        }

        
          // Limpio el combo antes de cargar
        boxMes.removeAllItems();
        // Nombres de los meses
        String[] nombresMeses = {
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };

     
        // Cargo solo los meses desde la inscripción hasta diciembre
        for (int i = mesInscripcion; i <= 12; i++) {
            boxMes.addItem(nombresMeses[i - 1]);
        }


        
          // Volver a activar el listener
        for (ItemListener l : listeners) {
            boxMes.addItemListener(l);
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al cargar meses: " + e.getMessage());
        
    }
    
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        boxMes = new javax.swing.JComboBox<>();
        boxAsistencia = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtAlumno = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaAsistencias = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtDniBuscador = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JLabel();
        labelCodigoAlumno = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setBackground(new java.awt.Color(255, 204, 204));

        jPanel5.setBackground(new java.awt.Color(255, 102, 102));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(1000, 70));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Asistencias");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Alumno");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Mes");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("¿Asistió?");

        boxMes.setBackground(new java.awt.Color(255, 255, 255));
        boxMes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        boxMes.setForeground(new java.awt.Color(255, 0, 102));
        boxMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un Mes" }));
        boxMes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxMesItemStateChanged(evt);
            }
        });
        boxMes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                boxMesMouseReleased(evt);
            }
        });

        boxAsistencia.setBackground(new java.awt.Color(255, 255, 255));
        boxAsistencia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        boxAsistencia.setForeground(new java.awt.Color(255, 0, 102));
        boxAsistencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una Opción", "SI", "NO" }));
        boxAsistencia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxAsistenciaItemStateChanged(evt);
            }
        });
        boxAsistencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                boxAsistenciaMouseReleased(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(255, 102, 51));
        jLabel11.setForeground(new java.awt.Color(255, 102, 51));
        jLabel11.setText("******************************************************");

        txtAlumno.setBackground(new java.awt.Color(255, 255, 255));
        txtAlumno.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtAlumno.setForeground(new java.awt.Color(255, 51, 102));
        txtAlumno.setBorder(null);
        txtAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAlumnoKeyReleased(evt);
            }
        });

        jButton1.setText("...");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tablaAsistencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre Alumno", "Apellido Alumno", "DNI", "Servico", "Mes", "Año", "¿Asistió?"
            }
        ));
        jScrollPane2.setViewportView(tablaAsistencias);

        jPanel4.setBackground(new java.awt.Color(255, 102, 102));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/Buscar_1.png"))); // NOI18N
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });

        txtDniBuscador.setBackground(new java.awt.Color(255, 204, 204));
        txtDniBuscador.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDniBuscador.setForeground(new java.awt.Color(0, 0, 0));
        txtDniBuscador.setBorder(null);
        txtDniBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniBuscadorActionPerformed(evt);
            }
        });

        botonGuardar.setFont(new java.awt.Font("Segoe Print", 1, 10)); // NOI18N
        botonGuardar.setForeground(new java.awt.Color(255, 255, 255));
        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/g.png"))); // NOI18N
        botonGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonGuardarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDniBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonGuardar)
                .addGap(62, 62, 62)
                .addComponent(labelCodigoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15)
            .addComponent(botonGuardar)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDniBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCodigoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boxMes, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(boxAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(boxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(boxAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(102, 102, 102)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(240, 240, 240)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(241, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void boxMesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxMesItemStateChanged
activarGuardar();     
    }//GEN-LAST:event_boxMesItemStateChanged

    private void boxMesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxMesMouseReleased

    }//GEN-LAST:event_boxMesMouseReleased

    private void boxAsistenciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxAsistenciaItemStateChanged
    activarGuardar();  
    }//GEN-LAST:event_boxAsistenciaItemStateChanged

    private void boxAsistenciaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxAsistenciaMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_boxAsistenciaMouseReleased

    private void txtAlumnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlumnoKeyReleased
activarGuardar();        
    }//GEN-LAST:event_txtAlumnoKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
       
buscarAlumno dialog = new buscarAlumno(frame, true, (Panel3) p3, this, p5, 2);
dialog.setVisible(true);
if(!labelCodigoAlumno.getText().isEmpty()){
    
    int codigo_alumno=Integer.parseInt(labelCodigoAlumno.getText());
    try{
       int codigo_inscripcion= Clases.Inscripcion.buscarCodigo(cx, codigo_alumno);
       
       
        int mes_inscripcion=Clases.Inscripcion.verMesInscripcion(cx, codigo_inscripcion);
        
          
        cargarMesesDesdeInscripcion(mes_inscripcion);
        
        
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Error al cargar los meses en el combo box","ERROR",ERROR_MESSAGE);
    }
    
}
    


    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtDniBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniBuscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniBuscadorActionPerformed

    private void botonGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGuardarMouseClicked
   try{
       int codigo_inscripcion=Clases.Inscripcion.buscarCodigo(cx, Integer.parseInt(labelCodigoAlumno.getText()));
       int codigo_mes=Clases.Asistencia.obtenerCodigoMes(cx, boxMes.getSelectedItem().toString());
       int codigo_ciclo_lectivo=Clases.Inscripcion.obtenerCodigoCLPorInscripcion(cx, codigo_inscripcion);
       
       ///verifcar que no haya registros duplicados..
       boolean existe=Clases.Asistencia.consultarDuplicados(cx, codigo_inscripcion, codigo_ciclo_lectivo, codigo_mes);
       if(existe==true){
           JOptionPane.showMessageDialog(null, "Ya ha cargado la asistencia del alumno "+txtAlumno.getText()+" del mes "+boxMes.getSelectedItem(),"ERROR",ERROR_MESSAGE);
           return;
          
           
       }else{
             Clases.Asistencia.insertar(cx, codigo_inscripcion, codigo_mes, codigo_ciclo_lectivo, boxAsistencia.getSelectedItem().toString());
             JOptionPane.showMessageDialog(null, "Se ha cargado la asistencia correctamente");
             limpiar();
             verTodasAsistencias();
       }
     
   }catch(Exception e){
       JOptionPane.showMessageDialog(null, "Error al intentar cargar la asistencia del alumno","ERROR",ERROR_MESSAGE);
   }

    }//GEN-LAST:event_botonGuardarMouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
 
        
     
       
       tabla.setRowCount(0);   
         tabla.setColumnCount(0);
         tabla.addColumn("Nombre Alumno");  
         tabla.addColumn("Apellido Alumno");  
         tabla.addColumn("DNI"); 
         tabla.addColumn("Servicio"); 
         tabla.addColumn("Mes");
         tabla.addColumn("Ciclo Lectivo");
         tabla.addColumn("¿Asistió?");
        try{
         rs=Clases.Asistencia.buscarAsistenciasAlumno(cx, Integer.parseInt(txtDniBuscador.getText()));
         while(rs.next()){
                   datos[0]=rs.getString("al.nombre");
                   datos[1]=rs.getString("al.apellido");
                   datos[2]=rs.getString("al.dni");
                   datos[3]=rs.getString("ser.nombre");
                   datos[4]=rs.getString("me.mes");
                   datos[5]=rs.getString("ci.año");
                   datos[6]=rs.getString("a.asistio");
                   
                  
                  
                   tabla.addRow(datos);
                   tablaAsistencias.setModel(tabla);
                   
          }
                
              
             
    }catch(Exception e){
          
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al buscar al Alumno","ERROR",ERROR_MESSAGE);
           
       }
      
     
     
     
    }//GEN-LAST:event_jLabel15MouseClicked

    public void setTxtAlumno(String nombre) {
        txtAlumno.setText(nombre);
    }

    public void setLabelCodigoAlumno(String codigo) {
        labelCodigoAlumno.setText(codigo);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel botonGuardar;
    private javax.swing.JComboBox<String> boxAsistencia;
    private javax.swing.JComboBox<String> boxMes;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelCodigoAlumno;
    private javax.swing.JTable tablaAsistencias;
    private javax.swing.JTextField txtAlumno;
    private javax.swing.JTextField txtDniBuscador;
    // End of variables declaration//GEN-END:variables
}
