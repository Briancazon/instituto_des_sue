//
package prueba_sistema;

import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.table.DefaultTableModel;


public class pagosPendientes extends javax.swing.JPanel {
       DefaultTableModel tabla=new DefaultTableModel();
      ResultSet rs;
     Connection cx=Conexion.conexion.conexion();
      Object[] datos=new Object[12];

   
    public pagosPendientes() {
        initComponents();
        cargarTablaPagosPendientes();
    }
    
    void cargarTablaPagosPendientes(){
        
        tabla.setRowCount(0);
        tabla.setColumnCount(0);

        tabla.addColumn("Nombre Alumno");
        tabla.addColumn("Apellido Alumno");
        tabla.addColumn("DNI Alumno" );
        tabla.addColumn("Servicio");
        tabla.addColumn("Mes");
        tabla.addColumn("Ciclo Lectivo");
        

        try{

            rs=Clases.Pago.verPagosPendientes(cx);
            while(rs.next()){
                datos[0]=rs.getString("al.nombre");
                datos[1]=rs.getString("al.apellido");
                datos[2]=rs.getString("al.dni");
                datos[3]=rs.getString("ser.nombre");
                datos[4]=rs.getString("me.mes");
                datos[5]=rs.getString("cl.año");
            

                tabla.addRow(datos);

            }
            tablaPagos.setModel(tabla);

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar los pagos pendientes del alumno","ERROR",ERROR_MESSAGE);
        }

    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        buscar = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cargar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPagos = new javax.swing.JTable();

        jPanel3.setBackground(new java.awt.Color(255, 102, 102));

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/Buscar_1.png"))); // NOI18N
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 204, 204));
        jLabel7.setForeground(new java.awt.Color(255, 102, 51));
        jLabel7.setText("*********************************************************");

        cargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recargar.png"))); // NOI18N
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
                .addGap(217, 217, 217)
                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                    .addComponent(txtNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cargar)
                .addGap(302, 302, 302))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cargar)
                    .addComponent(buscar)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablaPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre Alumno", "Apellido Alumno", "DNI Alumno", "Servicio", "Mes", "Ciclo Lectivo"
            }
        ));
        jScrollPane1.setViewportView(tablaPagos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarMouseClicked

        tabla.setRowCount(0);
        tabla.setColumnCount(0);

        tabla.addColumn("Nombre Alumno");
        tabla.addColumn("Apellido Alumno");
        tabla.addColumn("DNI Alumno" );
        tabla.addColumn("Servicio");
        tabla.addColumn("Mes");
        tabla.addColumn("Ciclo Lectivo");
        

        try{

            rs=Clases.Pago.verPagosPendientesAlumnoPorNombre(cx, txtNombre.getText());
            while(rs.next()){
                datos[0]=rs.getString("al.nombre");
                datos[1]=rs.getString("al.apellido");
                datos[2]=rs.getString("al.dni");
                datos[3]=rs.getString("ser.nombre");
                datos[4]=rs.getString("me.mes");
                datos[5]=rs.getString("cl.año");
            

                tabla.addRow(datos);

            }
            tablaPagos.setModel(tabla);

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar los pagos pendientes del alumno","ERROR",ERROR_MESSAGE);
        }

    }//GEN-LAST:event_buscarMouseClicked

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void cargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargarMouseClicked
            cargarTablaPagosPendientes();
    }//GEN-LAST:event_cargarMouseClicked

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
      char c=evt.getKeyChar();
         // verificar si el carácter ingresado es unicamente letra
      if ((!Character.isLetter(c) && c != ' ') || txtNombre.getText().length()>20) {
        evt.consume(); 
      }
    }//GEN-LAST:event_txtNombreKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel buscar;
    private javax.swing.JLabel cargar;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPagos;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
