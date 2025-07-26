
package Profesores;

import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.table.DefaultTableModel;


public class Modificar_Profe extends javax.swing.JPanel {
    DefaultTableModel tabla=new DefaultTableModel();
     Object[] datos=new Object[5];
      ResultSet rs;
      Statement st;
     Connection cx=Conexion.conexion.conexion();
 
    public Modificar_Profe() {
        initComponents();
        mostrarP();
    }

    private Image imagen;
        @Override
        public void paint(Graphics g){
            imagen= new ImageIcon(getClass().getResource("/Imagenes/2.jpg")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
     
      public void mostrarP(){
         tabla.setRowCount(0);   
         tabla.setColumnCount(0);
        
         tabla.addColumn("Nombre");  
         tabla.addColumn("Apellido");  
         tabla.addColumn("DNI"); 
         tabla.addColumn("Residencia"); 
         tabla.addColumn("Titulo");
      
         
         try{
            
             rs=Clases.Profesor.mostrarProfesor(cx);
              while(rs.next()){
                   datos[0]=rs.getString("nombre");
                   datos[1]=rs.getString("apellido");
                   datos[2]=rs.getString("dni");
                   datos[3]=rs.getString("residencia");
                   datos[4]=rs.getString("titulo");
                   
                 
                  
                   tabla.addRow(datos);
                   tablaProfesor.setModel(tabla);
                   
              } 
              
          }catch(Exception e){
                   JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar los Profesores en la tabla","ERROR",ERROR_MESSAGE); 
          }
    }
          
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nombretxt = new javax.swing.JTextField();
        apellidotxt = new javax.swing.JTextField();
        dnitxt = new javax.swing.JTextField();
        residenciatxt = new javax.swing.JTextField();
        titulotxt = new javax.swing.JTextField();
        guardar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProfesor = new javax.swing.JTable();
        buscar = new javax.swing.JButton();
        aptxt = new javax.swing.JTextField();

        jPanel2.setBackground(new java.awt.Color(255, 204, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Apellido:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 20));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("DNI");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 30));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Residencia:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, 20));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Titulo:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 216, -1, 20));
        jPanel2.add(nombretxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 410, -1));
        jPanel2.add(apellidotxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 410, -1));
        jPanel2.add(dnitxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 410, -1));
        jPanel2.add(residenciatxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 400, -1));
        jPanel2.add(titulotxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 420, -1));

        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/g.png"))); // NOI18N
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jPanel2.add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 163, 134));

        modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/m.png"))); // NOI18N
        jPanel2.add(modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 163, 134));

        jPanel1.setBackground(new java.awt.Color(204, 102, 0));

        jLabel10.setFont(new java.awt.Font("DialogInput", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("MODIFICAR PROFESOR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel10)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        tablaProfesor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "DNI", "Residencia", "Titulo"
            }
        ));
        tablaProfesor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProfesorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProfesor);

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/b.png"))); // NOI18N
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(aptxt, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(aptxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1)))
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
         int dni=Integer.parseInt(aptxt.getText());
      ResultSet rs;
       tabla.setRowCount(0);   
         tabla.setColumnCount(0);
         tabla.addColumn("Nombre");  
         tabla.addColumn("Apellido");  
         tabla.addColumn("DNI"); 
         tabla.addColumn("Residencia"); 
         tabla.addColumn("Titulo");
        try{
         rs=Clases.Profesor.buscarProfesor(cx, dni);
         if(rs.next()){
                   datos[0]=rs.getString("nombre");
                   datos[1]=rs.getString("apellido");
                   datos[2]=rs.getString("dni");
                   datos[3]=rs.getString("residencia");
                   datos[4]=rs.getString("titulo");
                  
                  
                   tabla.addRow(datos);
                   tablaProfesor.setModel(tabla);
                   
          }else{
              JOptionPane.showMessageDialog(null, "El profesor "+aptxt.getText()+" no existe","ERROR",ERROR_MESSAGE);
              mostrarP();
         }
                
              
             
    }catch(Exception e){
          
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al buscar al Profesor","ERROR",ERROR_MESSAGE);
            mostrarP();
       }
        
    
              
    }//GEN-LAST:event_buscarActionPerformed

    private void tablaProfesorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProfesorMouseClicked
        try{
            int filaSeleccionada = tablaProfesor.getSelectedRow();
            
            String nombre =tablaProfesor.getValueAt(filaSeleccionada, 0).toString();
            String apellido =tablaProfesor.getValueAt(filaSeleccionada, 1).toString();
            String dni =tablaProfesor.getValueAt(filaSeleccionada, 2).toString();
            String residencia=tablaProfesor.getValueAt(filaSeleccionada, 3).toString();
            String titulo =tablaProfesor.getValueAt(filaSeleccionada, 4).toString();
          
            
            nombretxt.setText(nombre);
            apellidotxt.setText(apellido);
            dnitxt.setText(dni);
            residenciatxt.setText(residencia);
            titulotxt.setText(titulo);
            
     
       }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No hay datos en la tabla","ERROR",ERROR_MESSAGE);
       }
    }//GEN-LAST:event_tablaProfesorMouseClicked

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
         int dni= Integer.parseInt(dnitxt.getText());
         String nombre1= nombretxt.getText();
         String apellido1=apellidotxt.getText();
         String residencia1= residenciatxt.getText();
         String titulo1=titulotxt.getText();
       
         
         try{
         
          Clases.Profesor.modificarProfe(cx, nombre1, apellido1, dni, residencia1, titulo1);
          
          JOptionPane.showMessageDialog(null, "Cargado");
          mostrarP();
         
             
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "No se pudieron cargar los datos");  
        }
       
         
         
         
         
         
         
         
         
         //Este es otro metodo para poder modificar y gardar los datos.. Los dejo aqui por la duda nos sirve mas adelante :)
         /*
       try{
         
          String sql= "update profesor set nombre='"+nombre1+"',apellido='"+apellido1+"',residencia='"+residencia1+"',titulo='"+titulo1+"' where dni="+dni;
          
          st=cx.createStatement();
          st.executeUpdate(sql);
          
          JOptionPane.showMessageDialog(null, "Cargado");
          mostrarP();
         
             
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "No se pudieron cargar los datos");  
        }
       */
       
    }//GEN-LAST:event_guardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidotxt;
    private javax.swing.JTextField aptxt;
    private javax.swing.JButton buscar;
    private javax.swing.JTextField dnitxt;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField nombretxt;
    private javax.swing.JTextField residenciatxt;
    private javax.swing.JTable tablaProfesor;
    private javax.swing.JTextField titulotxt;
    // End of variables declaration//GEN-END:variables
}
