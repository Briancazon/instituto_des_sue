
package VISTA;

import MODELO_CONTROLADOR.TablaEstilo;
import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDate;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.table.DefaultTableModel;
import VISTA.Menu;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConsultaGasto extends java.awt.Dialog {
     DefaultTableModel tabla=new DefaultTableModel();
      Object[] datos=new Object[2];
      ResultSet rs;
      Connection cx=MODELO_CONTROLADOR.conexion.conexion();
      DefaultComboBoxModel ls= new DefaultComboBoxModel();
      private Gastos panelGastos;
    private int[] idsMes = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    public ConsultaGasto(java.awt.Frame parent, boolean modal, Gastos panelGastos) {
        super(parent, modal);
        this.panelGastos = panelGastos;
        initComponents();
        
       
        MostrarTabla();
         setLocationRelativeTo(parent);
        
          verificarMesActual();
        mesbox.addActionListener(e -> verificarMesActual());
       
        TablaEstilo.personalizarTabla(tablaG);
        
        
    }

    
       
    
    
    
    
  
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        mesbox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaG = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        totalG = new javax.swing.JLabel();
        mostrar = new javax.swing.JLabel();
        SeleccionarMes = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));

        mesbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diiciembre" }));
        mesbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesboxActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ver gastos por mese:");

        tablaG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre ", "Gasto"
            }
        ));
        jScrollPane1.setViewportView(tablaG);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Total:");

        totalG.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        totalG.setForeground(new java.awt.Color(255, 255, 255));
        totalG.setText("............");

        mostrar.setText("jLabel4");

        SeleccionarMes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISTA/Imagenes2/modificar.png"))); // NOI18N
        SeleccionarMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarMesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(mesbox, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SeleccionarMes))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(mostrar)
                                .addGap(132, 132, 132)
                                .addComponent(jLabel1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalG, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mesbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SeleccionarMes))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalG, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    public void MostrarTabla(){
        
        
         mesbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = mesbox.getSelectedIndex(); // posición seleccionada
                if (index >= 0) {
                    int idMes = idsMes[index]; // obtener ID
                     
                    
                   
                    mostrar.setText(String.valueOf(idMes)); // mostrar en JLabel
                    
                  
                    validacion();
                 
                    
                    
                }
            }
        });
        
         int mesActual = java.time.LocalDate.now().getMonthValue(); // 1 a 12
        mesbox.setSelectedIndex(mesActual - 1); // ajustar índice 0-11
        
        
    }
    
   
    
    
    
    
    
    public void tabla(){
            int codigo= Integer.parseInt(mostrar.getText());
        
           tabla.setRowCount(0);   
              tabla.setColumnCount(0);
              tabla.addColumn("Nombre");  
              tabla.addColumn("Precio");
               try{
            
                    rs=MODELO_CONTROLADOR.GastosG.mostrarGastosAnteriores(cx, codigo);
                    while(rs.next()){
                        datos[0]=rs.getString("nombre");
                        datos[1]=rs.getString("precio");
                   
                  
                        tabla.addRow(datos);
                   
                    }
              
                    tablaG.setModel(tabla);
             
              
                  }catch(Exception e){
                         JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar  la tabla","ERROR",ERROR_MESSAGE); 
                   }
        
        
    }
    
    public void validacion(){
        
         int mesSeleccionado = mesbox.getSelectedIndex() + 1; // 1 a 12
                int mesActual = LocalDate.now().getMonthValue();

                // Validar si el mes seleccionado es futuro
                if (mesSeleccionado > mesActual) {
                    JOptionPane.showMessageDialog(null, 
                        "No se pueden seleccionar meses futuros.",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);

                    // Volver al mes actual
                    mesbox.setSelectedIndex(mesActual - 1);
                } else {
                    tabla();
                    calcularTotal();
                    
                }
        
        
        
        
        
    }
    

     
    public void calcularTotal() {
    DefaultTableModel model = (DefaultTableModel) tablaG.getModel();
    
   
            double total = 0.0;
   
          for (int i = 0; i < model.getRowCount(); i++) {
               Object valor = model.getValueAt(i, 1); // Columna precio (índice 1)
               if (valor != null && !valor.toString().isEmpty()) {
                  total += Double.parseDouble(valor.toString());
                }
     
          }
          totalG.setText(String.format("%.2f",total));  
    
  
            
     } 
    
     public int convertirMesANumero(String mes) {
        switch (mes) {
            case "enero": return 1;
            case "febrero": return 2;
            case "marzo": return 3;
            case "abril": return 4;
            case "mayo": return 5;
            case "junio": return 6;
            case "julio": return 7;
            case "agosto": return 8;
            case "septiembre": return 9;
            case "octubre": return 10;
            case "noviembre": return 11;
            case "diciembre": return 12;
        }
        return 0;
    }
    
    
    private void verificarMesActual() {
        String mesSeleccionado = mesbox.getSelectedItem().toString().toLowerCase();
        int numeroMes = convertirMesANumero(mesSeleccionado);
        int mesActual = java.time.LocalDate.now().getMonthValue();

        boolean esMesActual = numeroMes == mesActual;

        if (esMesActual) {
        // Color cuando está habilitado
        SeleccionarMes.setBackground(new Color(255, 102, 102));
    } else {
        // Color cuando está deshabilitado
        SeleccionarMes.setBackground(Color.GRAY);
    }

        SeleccionarMes.setCursor(esMesActual ? new Cursor(Cursor.HAND_CURSOR) : new Cursor(Cursor.DEFAULT_CURSOR));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private void mesboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mesboxActionPerformed

    private void SeleccionarMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarMesActionPerformed
     String Seleccionado = mesbox.getSelectedItem().toString();
  
  
    
      
 
        try {
        MODELO_CONTROLADOR.GastosG.activarGastosPorMes(MODELO_CONTROLADOR.conexion.conexion(), Seleccionado);
        JOptionPane.showMessageDialog(this, "Los gastos del mes " + Seleccionado + " fueron activados correctamente.");

        // 👇 Si el panel principal fue pasado correctamente
        if (panelGastos != null) {
            panelGastos.mostrarPorMes(Seleccionado); // refresca la tabla en el JPanel
        }

        dispose(); // cerrar el diálogo
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al activar los gastos: " + e.getMessage());
    }





        
        
        
 
    dispose();
            
   

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }//GEN-LAST:event_SeleccionarMesActionPerformed

   
    public static void main(String args[]) {
         try{
//            UIManager.setLookAndFeel(new FlatLightLaf());
              FlatArcOrangeIJTheme.setup();
        } catch (Exception ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);

        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Gastos panelGastos = new Gastos();
                ConsultaGasto dialog = new ConsultaGasto(new java.awt.Frame(), true, panelGastos);
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
    private javax.swing.JButton SeleccionarMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> mesbox;
    private javax.swing.JLabel mostrar;
    private javax.swing.JTable tablaG;
    private javax.swing.JLabel totalG;
    // End of variables declaration//GEN-END:variables
}
