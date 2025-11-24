
package VISTA;

import VISTA.Pagos.Panel5;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;

import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JPanel;

import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;


public class asistencias extends javax.swing.JPanel {
     ResultSet rs;
    Connection cx=MODELO_CONTROLADOR.conexion.conexion();
    DefaultComboBoxModel modelo= new DefaultComboBoxModel();
    JPanel p3;
    Panel5 p5;
     DefaultTableModel tabla=new DefaultTableModel();
     Object[] datos=new Object[8];
     boolean labelBuscar=true;
 
   
    public asistencias() {
        initComponents();

        desactivarCampoAlumno();
        verTodasAsistencias();
        verificarBusquedaAsistencia();

        
        TablaEstilo2.personalizarTabla(tablaAsistencias);
        

    }
    
    
    
    
    void verificarBusquedaAsistencia(){
        if(txtNombreBuscador.getText().isEmpty()){
            desactivarBuscar();
        }else{
            activarBuscar();
        }
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
    
    
    
    void activarBuscar(){
        buscar.setEnabled(true);
        labelBuscar=true;
    }
    
    void desactivarBuscar(){
        buscar.setEnabled(false);
        labelBuscar=false;
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
          tabla.addColumn("Estado");
        try{
         rs=MODELO_CONTROLADOR.Asistencia.verAsistencias(cx);
         while(rs.next()){
                   datos[0]=rs.getString("al.nombre");
                   datos[1]=rs.getString("al.apellido");
                   datos[2]=rs.getString("al.dni");
                   datos[3]=rs.getString("ser.nombre");
                   datos[4]=rs.getString("me.mes");
                   datos[5]=rs.getString("ci.año");
                   datos[6]=rs.getString("a.asistio");
                   datos[7]=rs.getString("inc.estado");
                   
                  
                  
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
        jLabel14 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
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
        buscar = new javax.swing.JLabel();
        txtNombreBuscador = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JLabel();
        labelCodigoAlumno = new javax.swing.JLabel();
        recargar = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

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

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Asistencias");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISTA/Imagenes/soll.gif"))); // NOI18N
        jLabel19.setPreferredSize(new java.awt.Dimension(40, 40));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Alumno:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Mes:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("¿Asistió?:");

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

        txtAlumno.setBackground(new java.awt.Color(255, 204, 204));
        txtAlumno.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtAlumno.setForeground(new java.awt.Color(255, 51, 102));
        txtAlumno.setBorder(null);
        txtAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAlumnoKeyReleased(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISTA/Imagenes2/alumno.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tablaAsistencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre Alumno", "Apellido Alumno", "DNI", "Servico", "Mes", "Ciclo Lectivo", "¿Asistió?", "Estado"
            }
        ));
        jScrollPane2.setViewportView(tablaAsistencias);

        jPanel4.setBackground(new java.awt.Color(255, 102, 102));

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISTA/Imagenes2/buscar.png"))); // NOI18N
        buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarMouseClicked(evt);
            }
        });

        txtNombreBuscador.setBackground(new java.awt.Color(255, 204, 204));
        txtNombreBuscador.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNombreBuscador.setForeground(new java.awt.Color(0, 0, 0));
        txtNombreBuscador.setBorder(null);
        txtNombreBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreBuscadorActionPerformed(evt);
            }
        });
        txtNombreBuscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreBuscadorKeyReleased(evt);
            }
        });

        botonGuardar.setFont(new java.awt.Font("Segoe Print", 1, 10)); // NOI18N
        botonGuardar.setForeground(new java.awt.Color(255, 255, 255));
        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISTA/Imagenes/guardar_nuevo.png"))); // NOI18N
        botonGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonGuardarMouseClicked(evt);
            }
        });

        labelCodigoAlumno.setForeground(new java.awt.Color(255, 102, 102));

        recargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISTA/Imagenes2/recargar.png"))); // NOI18N
        recargar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        recargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recargarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(buscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombreBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(recargar)
                .addGap(50, 50, 50)
                .addComponent(botonGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCodigoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(199, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonGuardar)
                            .addComponent(labelCodigoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreBuscador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(recargar, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(2, 2, 2)))))
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
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
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
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
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(37, 37, 37)
                .addComponent(jLabel5)
                .addGap(53, 53, 53)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(240, 240, 240)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(260, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void boxMesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxMesItemStateChanged

    }//GEN-LAST:event_boxMesItemStateChanged

    private void boxMesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxMesMouseReleased

    }//GEN-LAST:event_boxMesMouseReleased

    private void boxAsistenciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxAsistenciaItemStateChanged

    }//GEN-LAST:event_boxAsistenciaItemStateChanged

    private void boxAsistenciaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxAsistenciaMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_boxAsistenciaMouseReleased

    private void txtAlumnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlumnoKeyReleased
      
    }//GEN-LAST:event_txtAlumnoKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
       
buscarAlumno dialog = new buscarAlumno(frame, true, (Panel3) p3, this, p5, 2);
dialog.setVisible(true);
if(!labelCodigoAlumno.getText().isEmpty()){
    
    int codigo_alumno=Integer.parseInt(labelCodigoAlumno.getText());
    try{
       int codigo_inscripcion= MODELO_CONTROLADOR.Inscripcion.buscarCodigo(cx, codigo_alumno);
       
       
        int mes_inscripcion=MODELO_CONTROLADOR.Inscripcion.verMesInscripcion(cx, codigo_inscripcion);
        
          
        cargarMesesDesdeInscripcion(mes_inscripcion);
        
        
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "Error al cargar los meses en el combo box","ERROR",ERROR_MESSAGE);
    }
    
}
    


    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNombreBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreBuscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreBuscadorActionPerformed

    private void botonGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGuardarMouseClicked
   try{
       ///verifcar que no haya datos vacios..
       if(txtAlumno.getText().isEmpty() || boxMes.getSelectedItem().equals("Seleccione un Mes") || boxAsistencia.getSelectedItem().equals("Seleccione una Opción")){
           JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios","ERROR",ERROR_MESSAGE);
           return;
       }
       int codigo_inscripcion=MODELO_CONTROLADOR.Inscripcion.buscarCodigo(cx, Integer.parseInt(labelCodigoAlumno.getText()));
       int codigo_mes=MODELO_CONTROLADOR.Asistencia.obtenerCodigoMes(cx, boxMes.getSelectedItem().toString());
       int codigo_ciclo_lectivo=MODELO_CONTROLADOR.Inscripcion.obtenerCodigoCLPorInscripcion(cx, codigo_inscripcion);
       
       ///verifcar que no haya registros duplicados..
       boolean existe=MODELO_CONTROLADOR.Asistencia.consultarDuplicados(cx, codigo_inscripcion, codigo_ciclo_lectivo, codigo_mes);
       if(existe==true){
           JOptionPane.showMessageDialog(null, "Ya ha cargado la asistencia del alumno "+txtAlumno.getText()+" del mes "+boxMes.getSelectedItem(),"ERROR",ERROR_MESSAGE);
           return;
          
           
       }else{
             MODELO_CONTROLADOR.Asistencia.insertar(cx, codigo_inscripcion, codigo_mes, codigo_ciclo_lectivo, boxAsistencia.getSelectedItem().toString());
             JOptionPane.showMessageDialog(null, "Se ha cargado la asistencia correctamente");
             limpiar();
             verTodasAsistencias();
       }
     
   }catch(Exception e){
       JOptionPane.showMessageDialog(null, "Error al intentar cargar la asistencia del alumno","ERROR",ERROR_MESSAGE);
   }

    }//GEN-LAST:event_botonGuardarMouseClicked

    private void buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarMouseClicked
 
      //si el label buscar es false, quiere decir que el buscar esta inactivo, por lo tanto esta accion no se podria realizar....  
     if(!labelBuscar){
         return;
     }
       
       tabla.setRowCount(0);   
         tabla.setColumnCount(0);
         tabla.addColumn("Nombre Alumno");  
         tabla.addColumn("Apellido Alumno");  
         tabla.addColumn("DNI"); 
         tabla.addColumn("Servicio"); 
         tabla.addColumn("Mes");
         tabla.addColumn("Ciclo Lectivo");
         tabla.addColumn("¿Asistió?");
         tabla.addColumn("Estado");
        try{
         rs=MODELO_CONTROLADOR.Asistencia.buscarAsistenciasAlumno(cx, txtNombreBuscador.getText());
         while(rs.next()){
                   datos[0]=rs.getString("al.nombre");
                   datos[1]=rs.getString("al.apellido");
                   datos[2]=rs.getString("al.dni");
                   datos[3]=rs.getString("ser.nombre");
                   datos[4]=rs.getString("me.mes");
                   datos[5]=rs.getString("ci.año");
                   datos[6]=rs.getString("a.asistio");
                   datos[7]=rs.getString("inc.estado");
                   
                  
                  
                   tabla.addRow(datos);
                
                   
          }
                
                 tablaAsistencias.setModel(tabla);
             
    }catch(Exception e){
          
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al buscar al Alumno","ERROR",ERROR_MESSAGE);

       }
      
     
     
     
    }//GEN-LAST:event_buscarMouseClicked

    private void recargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recargarMouseClicked
          verTodasAsistencias();
          txtNombreBuscador.setText("");
          verificarBusquedaAsistencia();

    }//GEN-LAST:event_recargarMouseClicked

    private void txtNombreBuscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreBuscadorKeyReleased
       verificarBusquedaAsistencia();
    }//GEN-LAST:event_txtNombreBuscadorKeyReleased

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
    private javax.swing.JLabel buscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelCodigoAlumno;
    private javax.swing.JLabel recargar;
    private javax.swing.JTable tablaAsistencias;
    private javax.swing.JTextField txtAlumno;
    private javax.swing.JTextField txtNombreBuscador;
    // End of variables declaration//GEN-END:variables
}
