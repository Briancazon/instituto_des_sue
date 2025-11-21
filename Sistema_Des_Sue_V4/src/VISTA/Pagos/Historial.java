
package VISTA.Pagos;

import MODELO_CONTROLADOR.TablaEstilo;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


public class Historial extends javax.swing.JPanel {
     DefaultTableModel tabla=new DefaultTableModel();
      ResultSet rs;
     Connection cx=MODELO_CONTROLADOR.conexion.conexion();
      Object[] datos=new Object[11];
      boolean labelBuscar=true;
     

    public Historial() {
        initComponents();
        cargarHistorialPagosAlumnos();
         verificarBusqueda();
        
        TablaEstilo.personalizarTabla(tablaPagos);
    }

 
    
   public class FondoPanel2 extends JPanel {

    private Image imagen;
        public void paint(Graphics g){
            imagen= new ImageIcon(getClass().getResource("/VISTA/Imagenes2/2.jpg")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
            
    
    }
   
   void verificarBusqueda(){
       if(txtNombre.getText().isEmpty()){
           desactivarBuscar();
       }else{
           activarBuscar();
       }
   }
   
   
   void activarBuscar(){
       buscar.setEnabled(true);
       labelBuscar=true;
       
   }
   
    void desactivarBuscar(){
       buscar.setEnabled(false);
       labelBuscar=false;
       
   }
    
    
    void cargarHistorialPagosAlumnos(){
          
          tabla.setRowCount(0);   
         tabla.setColumnCount(0);
        
         tabla.addColumn("Nombre Alumno");  
         tabla.addColumn("Apellido Alumno");  
         tabla.addColumn("DNI"); 
         tabla.addColumn("Servicio"); 
         tabla.addColumn("Fecha");
         tabla.addColumn("Mes");
         tabla.addColumn("Ciclo Lectivo");
         tabla.addColumn("Tipo de Pago");
         tabla.addColumn("Observación");
         tabla.addColumn("Recargo");
         tabla.addColumn("Total");
                
      
         
         try{
            
             rs=MODELO_CONTROLADOR.Pago.verHistorialPagos(cx);
              while(rs.next()){
                   datos[0]=rs.getString("al.nombre");
                   datos[1]=rs.getString("al.apellido");
                   datos[2]=rs.getString("al.dni");
                   datos[3]=rs.getString("ser.nombre");
                   datos[4]=rs.getString("pa.fecha_pago");
                   datos[5]=rs.getString("me.mes");
                   datos[6]=rs.getString("cl.año");
                   datos[7]=rs.getString("tp.tipo_pago");
                   datos[8]=rs.getString("pa.observacion");
                   datos[9]=rs.getString("pa.recargo");
                    datos[10]=rs.getString("pa.total");
                   
                 
                  
                   tabla.addRow(datos);
                  
                   
              } 
              tablaPagos.setModel(tabla);
              
          }catch(Exception e){
                   JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar el historial de  pagos del alumno","ERROR",ERROR_MESSAGE); 
          }
    }
    
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel2 = new javax.swing.JPanel();
        jPanel1 = new FondoPanel2();
        jPanel3 = new javax.swing.JPanel();
        buscar = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cargar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPagos = new javax.swing.JTable();

        setLayout(new java.awt.CardLayout());

        panel2.setBackground(new java.awt.Color(255, 102, 102));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(845, 456));

        jPanel3.setBackground(new java.awt.Color(255, 102, 102));

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISTA/Imagenes2/buscar.png"))); // NOI18N
        buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarMouseClicked(evt);
            }
        });

        txtNombre.setBackground(new java.awt.Color(255, 204, 204));
        txtNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));
        txtNombre.setBorder(null);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 204, 204));
        jLabel7.setForeground(new java.awt.Color(255, 102, 51));
        jLabel7.setText("*********************************************************");

        cargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISTA/Imagenes/recargar.png"))); // NOI18N
        cargar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cargarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(256, 256, 256)
                .addComponent(buscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                    .addComponent(txtNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cargar)
                .addGap(272, 272, 272))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar)
                    .addComponent(cargar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablaPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre Alumno", "Apellido Alumno", "DNI", "Servicio", "Fecha", "Mes", "Ciclo Lectivo", "Tipo de Pago", "Observación", "Recargo", "Total"
            }
        ));
        jScrollPane1.setViewportView(tablaPagos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1006, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        add(panel2, "dos");
    }// </editor-fold>//GEN-END:initComponents

    private void buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarMouseClicked
        //si la accion esta inactiva no se permite continuar...  
        if(!labelBuscar){
              return;
          }
          tabla.setRowCount(0);   
         tabla.setColumnCount(0);
        
         tabla.addColumn("Nombre Alumno");  
         tabla.addColumn("Apellido Alumno");  
         tabla.addColumn("DNI"); 
         tabla.addColumn("Servicio"); 
         tabla.addColumn("Fecha");
         tabla.addColumn("Mes");
         tabla.addColumn("Ciclo Lectivo");
         tabla.addColumn("Tipo de Pago");
         tabla.addColumn("Observación");
         tabla.addColumn("Recargo");
         tabla.addColumn("Total");
                
      
         
         try{
            
             rs=MODELO_CONTROLADOR.Pago.verHistorialPagosAlumno(cx, txtNombre.getText());
              while(rs.next()){
                   datos[0]=rs.getString("al.nombre");
                   datos[1]=rs.getString("al.apellido");
                   datos[2]=rs.getString("al.dni");
                   datos[3]=rs.getString("ser.nombre");
                   datos[4]=rs.getString("pa.fecha_pago");
                   datos[5]=rs.getString("me.mes");
                   datos[6]=rs.getString("cl.año");
                   datos[7]=rs.getString("tp.tipo_pago");
                   datos[8]=rs.getString("pa.observacion");
                   datos[9]=rs.getString("pa.recargo");
                    datos[10]=rs.getString("pa.total");
                   
                 
                  
                   tabla.addRow(datos);
                  
                   
              } 
              tablaPagos.setModel(tabla);
              
          }catch(Exception e){
                   JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar el historial de  pagos del alumno","ERROR",ERROR_MESSAGE); 
          }
                
    }//GEN-LAST:event_buscarMouseClicked

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void cargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargarMouseClicked
            cargarHistorialPagosAlumnos();
            txtNombre.setText("");
            verificarBusqueda();
    }//GEN-LAST:event_cargarMouseClicked

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
          char c=evt.getKeyChar();
         // verificar si el carácter ingresado es unicamente letra
      if ((!Character.isLetter(c) && c != ' ') || txtNombre.getText().length()>20) {
        evt.consume(); 
    }  

    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        verificarBusqueda();
    }//GEN-LAST:event_txtNombreKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel buscar;
    private javax.swing.JLabel cargar;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel2;
    private javax.swing.JTable tablaPagos;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
