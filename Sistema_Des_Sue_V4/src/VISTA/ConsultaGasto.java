
package VISTA;

import MODELO_CONTROLADOR.TablaEstilo;
import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;


import java.sql.Connection;
import java.sql.ResultSet;



import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.table.DefaultTableModel;
import VISTA.Menu;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConsultaGasto extends java.awt.Dialog {
     DefaultTableModel tabla=new DefaultTableModel();
      Object[] datos=new Object[4];
      ResultSet rs;
      Connection cx=MODELO_CONTROLADOR.conexion.conexion();



    public ConsultaGasto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();
        
       mostrarGastosAnteriores();

         setLocationRelativeTo(parent);
        
    

       
        TablaEstilo.personalizarTabla(tablaG);
        
        
    }

    
       
    
    
    
    
  
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaG = new javax.swing.JTable();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));
        jPanel1.setMaximumSize(new java.awt.Dimension(693, 485));
        jPanel1.setMinimumSize(new java.awt.Dimension(693, 485));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ver Gastos");

        tablaG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Total Gastos", "Total Pago por Docente", "Mes", "Año"
            }
        ));
        jScrollPane1.setViewportView(tablaG);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(286, 286, 286))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addGap(70, 70, 70)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

   
    
    
    
    
    
    void mostrarGastosAnteriores(){

        
           tabla.setRowCount(0);   
           tabla.setColumnCount(0);
           tabla.addColumn("Total Gastos");  
           tabla.addColumn("Total Pago por Docente");
           tabla.addColumn("Mes");
           tabla.addColumn("Año");
               try{
            
                    rs=MODELO_CONTROLADOR.GastosG.verGastosAnteriores(cx);
                    while(rs.next()){
                        datos[0]=rs.getString("SUM(ga.precio)");
                        datos[1]=rs.getString("SUM(ga.precio)/(SELECT COUNT(codigo) FROM profesor WHERE borrado=0)");
                        datos[2]=rs.getString("me.mes");
                        datos[3]=rs.getString("ci.año");

                   
                  
                        tabla.addRow(datos);
                   
                    }
              
                    tablaG.setModel(tabla);
             
              
                  }catch(Exception e){
                         JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar  la tabla","ERROR",ERROR_MESSAGE); 
                         e.printStackTrace();
                   }
        
        
    }
    
  

     
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
    public static void main(String args[]) {
         try{
//            UIManager.setLookAndFeel(new FlatLightLaf());
              FlatArcOrangeIJTheme.setup();
        } catch (Exception ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);

        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                ConsultaGasto dialog = new ConsultaGasto(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaG;
    // End of variables declaration//GEN-END:variables
}
