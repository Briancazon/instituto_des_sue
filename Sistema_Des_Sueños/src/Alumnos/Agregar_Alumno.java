
package Alumnos;


import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mahu
 */
public class Agregar_Alumno extends javax.swing.JPanel {
      DefaultTableModel tabla=new DefaultTableModel();
      Object[] datos=new Object[8];
      ResultSet rs;
      Connection cx=Conexion.conexion.conexion();
      DefaultComboBoxModel ls= new DefaultComboBoxModel();

    public Agregar_Alumno() {
        initComponents();
        mostrarAlumnos();
        cargarComboObraSocial();
        habilitarBotonGuardar();
    }
    
      //metodo que valida si todos los campos estan llenos, si es asi, habilita al boton guardar, de lo contrario, seguirá inhabilitado
    public void habilitarBotonGuardar(){
       if( !txtNombre.getText().isEmpty() && !txtApellido.getText().isEmpty() &&  !txtFechaNac.getText().isEmpty() && !txtDni.getText().isEmpty() &&  !txtEscuela.getText().isEmpty() && !txtGrado.getText().isEmpty()){
           botonGuardar.setEnabled(true);
       }else{
           botonGuardar.setEnabled(false);
       }
    }
    
    
    void cargarComboObraSocial(){
        try{
            rs=Clases.ObraSocial.mostrarObrasSociales(cx);
            ls.addElement("Sin Obra Social");
            while(rs.next())
                ls.addElement(rs.getString("nombre"));
                boxObraSocial.setModel(ls);
            
        }catch(Exception e){
              JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar las Obras Sociales","ERROR",ERROR_MESSAGE);
        }
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
            
    void limpiar(){
        txtNombre.setText("");
        txtApellido.setText("");
        txtFechaNac.setText("");
        txtDni.setText("");
        txtEscuela.setText("");
        txtGrado.setText("");
        boxObraSocial.setSelectedItem("Sin Obra Social");
        
        
    }
    
    void cargarTabla(){
        
         
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
        boxNivel = new javax.swing.JComboBox<>();
        boxObraSocial = new javax.swing.JComboBox<>();

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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaAlumnos);

        jPanel1.setBackground(new java.awt.Color(204, 102, 0));

        jLabel10.setFont(new java.awt.Font("DialogInput", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("AGREGAR ALUMNOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(88, 88, 88))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17))
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
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, 20));

        jLabel6.setText("Grado:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, 20));

        jLabel7.setText("Escuela:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, 30));

        jLabel8.setText("Nivel:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, 20));

        jLabel9.setText("Obra Social");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, 30));

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 390, -1));

        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApellidoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });
        jPanel2.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 380, -1));

        txtFechaNac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFechaNacKeyReleased(evt);
            }
        });
        jPanel2.add(txtFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 350, -1));

        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDniKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });
        jPanel2.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 360, -1));

        txtGrado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGradoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGradoKeyTyped(evt);
            }
        });
        jPanel2.add(txtGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 430, -1));

        txtEscuela.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEscuelaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEscuelaKeyTyped(evt);
            }
        });
        jPanel2.add(txtEscuela, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 420, -1));

        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/g.png"))); // NOI18N
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(botonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 520, 163, 134));

        boxNivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inicial", "Primario", "Secundario" }));
        boxNivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxNivelActionPerformed(evt);
            }
        });
        jPanel2.add(boxNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 370, -1));

        boxObraSocial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(boxObraSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 450, 370, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        int dni= Integer.parseInt(txtDni.getText());
        String obra_social= boxObraSocial.getSelectedItem().toString(); //cualquiera de las obras sociales que elija el usuario se guardará en la variable obra_social...
        String nivel=boxNivel.getSelectedItem().toString(); // cualquiera de los tres niveles que elija el usuario se guardarà en la variable nivel
        try{
            int codigoObraSocial=Clases.ObraSocial.obtenerCodigo(cx, obra_social);   //obtener el codigo de la obra social, dado su nombre... para posterior poder enviar este codigo en el insert del alumno
  
             Clases.Alumno.cargar(cx, txtNombre.getText(), txtApellido.getText(), txtFechaNac.getText(), dni, txtEscuela.getText(), txtGrado.getText(), nivel , codigoObraSocial);
              JOptionPane.showMessageDialog(null, "Se ha cargado correctamente al alumno"); 
              limpiar();
              mostrarAlumnos();
              habilitarBotonGuardar();
        }catch(Exception e){
            
        }
            
       
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void boxNivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxNivelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxNivelActionPerformed

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

    private void txtEscuelaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEscuelaKeyTyped
          char c=evt.getKeyChar();
      // verificar si el carácter ingresado es una letra y nùmeros
      if (!( Character.isLetter(c) || c==' ' || Character.isDigit(c))  || txtEscuela.getText().length()>65) {
          evt.consume();  // si no es una letra o número, consume el evento y no permite el ingreso, tambien consumira si se pasa de 65 caracteres
      }
    }//GEN-LAST:event_txtEscuelaKeyTyped

    private void txtGradoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGradoKeyTyped
         char c=evt.getKeyChar();
      // verificar si el carácter ingresado es una letra y nùmeros
      if (!( Character.isLetter(c) || c==' ' || Character.isDigit(c))  || txtGrado.getText().length()>15) {
          evt.consume();  // si no es una letra o número, consume el evento y no permite el ingreso, tambien consumira si se pasa de 15 caracteres
      }
    }//GEN-LAST:event_txtGradoKeyTyped

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        habilitarBotonGuardar();
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyReleased
        habilitarBotonGuardar();
    }//GEN-LAST:event_txtApellidoKeyReleased

    private void txtFechaNacKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaNacKeyReleased
        habilitarBotonGuardar();
    }//GEN-LAST:event_txtFechaNacKeyReleased

    private void txtDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyReleased
        habilitarBotonGuardar();
    }//GEN-LAST:event_txtDniKeyReleased

    private void txtEscuelaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEscuelaKeyReleased
        habilitarBotonGuardar();
    }//GEN-LAST:event_txtEscuelaKeyReleased

    private void txtGradoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGradoKeyReleased
        habilitarBotonGuardar();
    }//GEN-LAST:event_txtGradoKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardar;
    private javax.swing.JComboBox<String> boxNivel;
    private javax.swing.JComboBox<String> boxObraSocial;
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
    private javax.swing.JTextField txtEscuela;
    private javax.swing.JTextField txtFechaNac;
    private javax.swing.JTextField txtGrado;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
