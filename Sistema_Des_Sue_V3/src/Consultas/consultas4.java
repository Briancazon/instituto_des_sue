/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Consultas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import prueba_sistema.Panel3;
import prueba_sistema.buscarProfesor;

public class consultas4 extends javax.swing.JPanel {
    Panel3 p3;
  DefaultTableModel tabla=new DefaultTableModel();
     Object[] datos=new Object[4];
      ResultSet rs;
      Statement st;
     Connection cx=Conexion.conexion.conexion();
     private String ultimoId = ""; // Para detectar cambios

  
    public consultas4() {
        initComponents();
        
     // Agregar listener para detectar cambios en el JLabel
        // (como JLabel no tiene DocumentListener, lo haremos con un Timer que "escucha" el cambio)
        javax.swing.Timer timer = new javax.swing.Timer(300, e -> actualizar());
        timer.start();
        
        txtNombre.setEditable(false);
        
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelP = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        labelCodigo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        alumnoP = new javax.swing.JTable();

        setLayout(new java.awt.CardLayout());

        PanelP.setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/profesor.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        labelCodigo.setText("jLabel1");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("CANTIDAD DE ALUMNOS POR PROFESOR");

        alumnoP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Horario", "Dias"
            }
        ));
        jScrollPane1.setViewportView(alumnoP);

        javax.swing.GroupLayout PanelPLayout = new javax.swing.GroupLayout(PanelP);
        PanelP.setLayout(PanelPLayout);
        PanelPLayout.setHorizontalGroup(
            PanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPLayout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addGroup(PanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPLayout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(labelCodigo)
                        .addGap(85, 85, 85))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(txtNombre)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(202, 202, 202))))
            .addGroup(PanelPLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1)
                .addGap(36, 36, 36))
        );
        PanelPLayout.setVerticalGroup(
            PanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(PanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCodigo)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(PanelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );

        add(PanelP, "cuatro");
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

        buscarProfesor dialog= new buscarProfesor(frame, true, p3, this, 1);
        dialog.setVisible(true);
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    public void setTxtNombre(String nombre) {
        this.txtNombre.setText(nombre);
    }

    public void setLabelCodigo(String codigo) {
        this.labelCodigo.setText(codigo);
    }
    
    public void actualizar(){
        
        String idActual = labelCodigo.getText().trim();

        // Si el ID cambió desde la última vez, actualizamos la tabla
        if (!idActual.equals(ultimoId)) {
            ultimoId = idActual;
            Mostrar(idActual);
        }
        
        
        
        
        
        
    }
            
    
    
    
    
    
    
    
    
    
    
    public void Mostrar(String Codigo){
          

          
           tabla.setRowCount(0);   
         tabla.setColumnCount(0);
        
         tabla.addColumn("Nombre");  
         tabla.addColumn("Apellido");  
         tabla.addColumn("Horario"); 
         tabla.addColumn("Dias"); 
        
         try{
             int codigo= Integer.parseInt(Codigo);
            
             rs= Consultas.ConsultaPofesor.buscaAlumno(cx, codigo);
              while(rs.next()){
                   datos[0]=rs.getString("al.nombre");
                   datos[1]=rs.getString("al.apellido");
                   datos[2]=rs.getString("h.horario");
                   datos[3]=rs.getString("inc.dias");
                
                   tabla.addRow(datos);
                   alumnoP.setModel(tabla);
                   
              } 
              
          }catch(Exception e){
                  
          }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelP;
    private javax.swing.JTable alumnoP;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
