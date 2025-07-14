
package Tutores;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;


public class Eliminar_Tutor extends javax.swing.JPanel {

    
    public Eliminar_Tutor() {
        initComponents();
        desactivarBotonBuscar();
    }
    
     //metodo que valida si todos los campos estan llenos, si es asi, habilita al boton buscar, de lo contrario, seguirá inhabilitado
    public void habilitarBotonBuscar(){
       if( !txtDni.getText().isEmpty()){
           botonBuscar.setEnabled(true);
       }else{
           botonBuscar.setEnabled(false);
       }
    }
    
    void desactivarBotonBuscar(){
        botonBuscar.setEnabled(false);
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
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "DNI", "Telefono", "Borrado"
            }
        ));
        jScrollPane1.setViewportView(tablaTutores);

        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/e.png"))); // NOI18N

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/c.png"))); // NOI18N

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonEliminar)
                    .addComponent(jButton4))
                .addGap(62, 62, 62))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaTutores;
    private javax.swing.JTextField txtDni;
    // End of variables declaration//GEN-END:variables
}
