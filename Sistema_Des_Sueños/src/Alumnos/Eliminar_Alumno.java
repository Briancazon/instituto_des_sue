package Alumnos;




import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.table.DefaultTableModel;


public class Eliminar_Alumno extends javax.swing.JPanel {
     DefaultTableModel tabla=new DefaultTableModel();
     Object[] datos=new Object[8];
      ResultSet rs;
     Connection cx=Conexion.conexion.conexion();

    
    public Eliminar_Alumno() {
        initComponents();
        mostrarAlumnos();
        desactivarEliminar();
        habilitarBotonBuscar();
    }
    
    
    void activarEliminar(){
        botonEliminar.setEnabled(true);
    }
    
    void desactivarEliminar(){
        botonEliminar.setEnabled(false);
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
    
    
    
       //metodo que valida si todos los campos estan llenos, si es asi, habilita al boton buscar, de lo contrario, seguirá inhabilitado
    public void habilitarBotonBuscar(){
       if( !txtDni.getText().isEmpty()){
           botonBuscar.setEnabled(true);
       }else{
           botonBuscar.setEnabled(false);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlumnos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        botonBuscar = new javax.swing.JButton();
        txtDni = new javax.swing.JTextField();
        botonEliminar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        labelCodigoAlumno = new javax.swing.JLabel();

        tablaAlumnos.setForeground(new java.awt.Color(0, 0, 0));
        tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Fecha de Nacimineto", "DNI", "Escuela", "Grado", "Nivel", "Obra Social"
            }
        ));
        tablaAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAlumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaAlumnos);

        jPanel1.setBackground(new java.awt.Color(204, 102, 0));

        jLabel10.setFont(new java.awt.Font("DialogInput", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ELIMINAR ALUMNOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(0, 26, Short.MAX_VALUE))
        );

        botonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/b.png"))); // NOI18N
        botonBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
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

        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/e.png"))); // NOI18N
        botonEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/c.png"))); // NOI18N

        labelCodigoAlumno.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(labelCodigoAlumno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(170, 170, 170))
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1235, Short.MAX_VALUE)
                        .addGap(77, 77, 77))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(68, 68, 68)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelCodigoAlumno)
                        .addGap(114, 114, 114))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
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
         
         int dni=Integer.parseInt(txtDni.getText());
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
                       JOptionPane.showMessageDialog(null, "El alumno con dni "+txtDni.getText()+" no existe","ERROR",ERROR_MESSAGE);
                       mostrarAlumnos();
                 }
              
          }catch(Exception e){
                   JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar los alumnos en la tabla","ERROR",ERROR_MESSAGE); 
          }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void tablaAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAlumnosMouseClicked
           try{
            int filaSeleccionada = tablaAlumnos.getSelectedRow();
            
            String dni =tablaAlumnos.getValueAt(filaSeleccionada, 3).toString();
            labelCodigoAlumno.setText(dni);
            activarEliminar();
            
            
     
       }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No hay datos en la tabla","ERROR",ERROR_MESSAGE);
       }
    }//GEN-LAST:event_tablaAlumnosMouseClicked

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        int dni=Integer.parseInt(labelCodigoAlumno.getText());
        int respuesta = JOptionPane.showConfirmDialog( null, "¿Estás seguro de que deseas eliminar a este alumno?" , "Confirmar eliminación", JOptionPane.YES_NO_OPTION , JOptionPane.WARNING_MESSAGE);
        
         if (respuesta == JOptionPane.YES_OPTION) {
                  try{
                           Clases.Alumno.eliminar(cx, dni);
                           JOptionPane.showMessageDialog(null, "Se ha eliminado al alumno correctamente");
                           mostrarAlumnos();
                           desactivarEliminar();
                  }catch(Exception e){
            
                            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar eliminar el alumno","ERROR",ERROR_MESSAGE);
                  }
         }else{
             JOptionPane.showMessageDialog(null, "Se ha cancelado la eliminación");
             mostrarAlumnos();
             desactivarEliminar();
         }
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
           char c=evt.getKeyChar();
       // verificar si el carácter ingresado es unicamente un numero
      if (!Character.isDigit(c) || txtDni.getText().length()>7) {
        evt.consume();  // si no es un numero, consume el evento y no permite el ingreso, tambien consumirá si se pasa de 7 digitos
    }
    }//GEN-LAST:event_txtDniKeyTyped

    private void txtDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyReleased
      habilitarBotonBuscar();
    }//GEN-LAST:event_txtDniKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCodigoAlumno;
    private javax.swing.JTable tablaAlumnos;
    private javax.swing.JTextField txtDni;
    // End of variables declaration//GEN-END:variables
}
