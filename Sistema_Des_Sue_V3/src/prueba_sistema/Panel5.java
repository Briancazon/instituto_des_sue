
package prueba_sistema;

import Pagos.Historial;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import javax.swing.table.DefaultTableModel;


public class Panel5 extends javax.swing.JPanel {
      ResultSet rs;
    Connection cx=Conexion.conexion.conexion();
    DefaultComboBoxModel ls= new DefaultComboBoxModel();
    DefaultComboBoxModel ls2= new DefaultComboBoxModel();
     asistencias a;
     Panel3 p3;
     
    
     DefaultTableModel tabla=new DefaultTableModel();
     Object[] datos=new Object[5];

CardLayout cardLayout;
    public Panel5() {
        initComponents();
        desactivarBoxMes();
        desactivarCampos();
        desactivarCamposNoEntry();
        cargarComboBoxTipoPago();
        validarCamposVacios();
        cardLayout = (CardLayout)(contenedor.getLayout());
        
    }
    
   ////metodo para validar que antes de pagar, no haya campos vacios o invalidos..
    void validarCamposVacios(){
        if(txtDni.getText().isEmpty() || txtAlumno.getText().isEmpty() || txtServicio.getText().isEmpty() || txtPrecio.getText().isEmpty() || jDateFecha.getDateFormatString().isEmpty() || boxTipoPago.getSelectedItem().equals("Seleccione un tipo de Pago") || txtRecargo.getText().isEmpty() || txtTotal.getText().isEmpty()){
           labelPagar.setEnabled(false);
        }else{
            labelPagar.setEnabled(true);
        }
    }
    
    void limpiar(){
        txtDni.setText("");
        txtAlumno.setText("");
        txtServicio.setText("");
        txtPrecio.setText("");
     
        boxMes.removeAllItems();
        jDateFecha.setDate(null); // Limpia la fecha seleccionada
        boxTipoPago.setSelectedItem("Seleccione un tipo de Pago");
        txtRecargo.setText("");
        txtAreaObservacion.setText("");
        txtTotal.setText("");
        
        
        desactivarCampos();
        boxMes.setEnabled(false);
        txtDni.setEnabled(true);
    }
    void desactivarCampos(){
        jDateFecha.setEnabled(false);
        boxTipoPago.setEnabled(false);
        txtAreaObservacion.setEnabled(false);
    }
    
    void activarCampos(){
       
        jDateFecha.setEnabled(true);
        boxTipoPago.setEnabled(true);
        txtAreaObservacion.setEnabled(true);
    }
    
    
    void calcularRecargoYTotal(){
         // validamos primero que haya una fecha seleccionada
         if (jDateFecha.getDate() == null) {
                 // todavía no hay fecha, no hacemos nada
                return;
         }
         float total=0;
         float recargo=0;
         float precioServicio=0;
         
         if(!txtPrecio.getText().isEmpty()){
             precioServicio=Float.parseFloat(txtPrecio.getText());
         }
         
         ///si el mes esta activado quiere decir que el servicio es mensual por lo tanto se debera ver el tema del recargo
         if(boxMes.isEnabled()){
         
            
              Calendar fechaSeleccionada=  jDateFecha.getCalendar(); ///obtener la fecha seleccionada y guardarla en la variable fechaSeleccionada
              int dia=fechaSeleccionada.get(Calendar.DAY_OF_MONTH);  /// obtener el dia de la fecha seleccionada, y guardarla en la variable dia
              int mes=1+fechaSeleccionada.get(Calendar.MONTH);  //obteener el mes de la decha seleecionada y guardarla en la variable mes
              int año=fechaSeleccionada.get(Calendar.YEAR); //obtener el año de la fecha seleccionada...
              try{
                
                  int codigo_mes=Clases.Asistencia.obtenerCodigoMes(cx,  boxMes.getSelectedItem().toString());
                  int año_inscripcion=Clases.Inscripcion.obtenerAñoInscripcion(cx, Integer.parseInt(txtDni.getText()));

                  if(dia>15  || (mes>codigo_mes || año>año_inscripcion)) {
                     recargo=(float) (precioServicio*0.20);
                     txtRecargo.setText(String.valueOf(recargo));
                  }else{
                     txtRecargo.setText(String.valueOf(recargo));
                  }
      
                  total=precioServicio+recargo;
                  txtTotal.setText(String.valueOf(total));
              }catch(Exception e){
                       JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar obtener el codigo del mes","ERROR",ERROR_MESSAGE);
               }
      
         // si el mes esta desactivado quiere decir que el servicio es por clase, por lo tanto no se cobrará ningun recargo..unicamente el precio del servicio   
         }else{
             
              txtRecargo.setText(String.valueOf(recargo));
              total=precioServicio+recargo;
              txtTotal.setText(String.valueOf(total));
         }  
        
   
       
    }
    
    ////este metodo llenara el box Mes con los meses que asistio el alumno, lo hace a traves de su inscripcion actual, pone unicamente los meses que asistió porque solo se corbran unicamente los meses que haya asistido, esto solo es para SERVICIOS MENSUALES..
    void cargarComboBoxMeses(int codigo_inscripcion){
         try{
            rs=Clases.Pago.verQueMesesPaga(cx, codigo_inscripcion);
          
            while(rs.next())
                ls2.addElement(rs.getString("me.mes"));
                boxMes.setModel(ls2);
            
        }catch(Exception e){
              JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar los meses que debe pagar","ERROR",ERROR_MESSAGE);
        }
    }

    
      void cargarComboBoxTipoPago(){
         try{
            rs=Clases.Pago.verTIposPagos(cx);
            ls.addElement("Seleccione un tipo de Pago");
            while(rs.next())
                ls.addElement(rs.getString("tipo_pago"));
                boxTipoPago.setModel(ls);
            
        }catch(Exception e){
              JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar los tipos de pagos","ERROR",ERROR_MESSAGE);
        }
    }
    
    void desactivarCamposNoEntry(){
        txtPrecio.setEnabled(false);
        txtServicio.setEnabled(false);
        txtRecargo.setEnabled(false);
        txtTotal.setEnabled(false);
        txtAlumno.setEnabled(false);
        JTextField editor = (JTextField) jDateFecha.getDateEditor().getUiComponent(); /// obtiene el editar osea el textfield que esta dentro del jDate
        editor.setEditable(false);  ///deshabilita dicho editor, para validar que no ingrese nada raro, asi nos aseguramps que ingrese un fecha correctamente

    }

    void desactivarBoxMes(){
        boxMes.setEnabled(false);
    }
    
    void activarBoxMes(){
        boxMes.setEnabled(true);
    }
    
   
    
    

   public class FondoPanel2 extends JPanel {

    private Image imagen;
        public void paint(Graphics g){
            imagen= new ImageIcon(getClass().getResource("/Imagenes2/2.jpg")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
            
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel5 = new FondoPanel2();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Pagos = new javax.swing.JLabel();
        Historial = new javax.swing.JLabel();
        contenedor = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        labelPagar = new javax.swing.JLabel();
        labelCancelar = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        boxTipoPago = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaObservacion = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        txtRecargo = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtServicio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        boxMes = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jDateFecha = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtAlumno = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        pagosPendientes = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        panel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 102, 102));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(1000, 70));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Realizar Pagos");

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/instalaciones.png"))); // NOI18N

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/soll.gif"))); // NOI18N
        jLabel19.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("E. P. Despertando Sueños ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addGap(57, 57, 57))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel18)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));

        Pagos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Pagos.setForeground(new java.awt.Color(255, 255, 255));
        Pagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prueba_sistema/output-onlinegiftools (1).gif"))); // NOI18N
        Pagos.setText(" PAGOS");
        Pagos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Pagos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PagosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PagosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PagosMouseExited(evt);
            }
        });

        Historial.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Historial.setForeground(new java.awt.Color(255, 255, 255));
        Historial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prueba_sistema/historial-de-transacciones.png"))); // NOI18N
        Historial.setText("HISTORIAL");
        Historial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Historial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HistorialMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HistorialMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HistorialMouseExited(evt);
            }
        });

        contenedor.setPreferredSize(new java.awt.Dimension(845, 456));
        contenedor.setLayout(new java.awt.CardLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 102, 102));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Opciones:");

        labelPagar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelPagar.setForeground(new java.awt.Color(255, 255, 255));
        labelPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prueba_sistema/dinero.png"))); // NOI18N
        labelPagar.setText("Pagar");
        labelPagar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelPagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelPagarMouseClicked(evt);
            }
        });

        labelCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/c.png"))); // NOI18N
        labelCancelar.setText("Cancelar");
        labelCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelCancelarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel22)
                .addGap(24, 24, 24)
                .addComponent(labelPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1206, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel22)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 204, 204));

        jLabel2.setBackground(new java.awt.Color(255, 102, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("     DNI:");

        txtDni.setBackground(new java.awt.Color(255, 204, 204));
        txtDni.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDni.setForeground(new java.awt.Color(255, 51, 102));
        txtDni.setBorder(null);
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

        jLabel11.setBackground(new java.awt.Color(255, 102, 51));
        jLabel11.setForeground(new java.awt.Color(255, 102, 51));
        jLabel11.setText("******************************************************");

        jLabel3.setBackground(new java.awt.Color(255, 102, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("  Servicio:");

        jLabel4.setBackground(new java.awt.Color(255, 102, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("   Precio:");

        txtPrecio.setBackground(new java.awt.Color(255, 204, 204));
        txtPrecio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtPrecio.setForeground(new java.awt.Color(255, 51, 102));
        txtPrecio.setBorder(null);
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioKeyReleased(evt);
            }
        });

        boxTipoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxTipoPago.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxTipoPagoItemStateChanged(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 102, 0));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Observación:");

        jLabel10.setBackground(new java.awt.Color(255, 102, 0));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Tipo de Pago: ");

        txtAreaObservacion.setColumns(20);
        txtAreaObservacion.setRows(5);
        jScrollPane1.setViewportView(txtAreaObservacion);

        jLabel16.setBackground(new java.awt.Color(255, 102, 0));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("   Recargo:");

        txtRecargo.setBackground(new java.awt.Color(255, 204, 204));
        txtRecargo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtRecargo.setForeground(new java.awt.Color(255, 51, 102));
        txtRecargo.setBorder(null);
        txtRecargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRecargoActionPerformed(evt);
            }
        });
        txtRecargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRecargoKeyReleased(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(255, 102, 51));
        jLabel17.setForeground(new java.awt.Color(255, 102, 51));
        jLabel17.setText("******************************************************");

        jLabel20.setBackground(new java.awt.Color(255, 102, 0));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("    Total:");

        txtTotal.setBackground(new java.awt.Color(255, 204, 204));
        txtTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(255, 51, 102));
        txtTotal.setBorder(null);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        txtTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTotalKeyReleased(evt);
            }
        });

        jLabel21.setBackground(new java.awt.Color(255, 102, 51));
        jLabel21.setForeground(new java.awt.Color(255, 102, 51));
        jLabel21.setText("******************************************************");

        jLabel25.setBackground(new java.awt.Color(255, 102, 51));
        jLabel25.setForeground(new java.awt.Color(255, 102, 51));
        jLabel25.setText("******************************************************");

        jLabel13.setBackground(new java.awt.Color(255, 102, 51));
        jLabel13.setForeground(new java.awt.Color(255, 102, 51));
        jLabel13.setText("******************************************************");

        txtServicio.setBackground(new java.awt.Color(255, 204, 204));
        txtServicio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtServicio.setForeground(new java.awt.Color(255, 51, 102));
        txtServicio.setBorder(null);
        txtServicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtServicioKeyReleased(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 102, 0));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("    Mes:");

        boxMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "..." }));
        boxMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxMesActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 102, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("    Fecha:");

        jDateFecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateFechaPropertyChange(evt);
            }
        });
        jDateFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jDateFechaKeyTyped(evt);
            }
        });

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 102, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Alumno:");

        txtAlumno.setBackground(new java.awt.Color(255, 204, 204));
        txtAlumno.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtAlumno.setForeground(new java.awt.Color(255, 51, 102));
        txtAlumno.setBorder(null);
        txtAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAlumnoKeyReleased(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(255, 102, 51));
        jLabel15.setForeground(new java.awt.Color(255, 102, 51));
        jLabel15.setText("******************************************************");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addComponent(jLabel11)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(txtAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 778, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(boxTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(182, 182, 182)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRecargo, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 83, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(boxMes, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(140, 140, 140)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jDateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(boxTipoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(1, 1, 1)
                                .addComponent(jLabel11)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel16)
                                            .addComponent(txtRecargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6)
                                            .addComponent(txtAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15)
                                        .addGap(17, 17, 17)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)
                                .addComponent(jLabel13)
                                .addGap(12, 12, 12)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(7, 7, 7)
                                .addComponent(jLabel9)
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel25)
                                .addGap(27, 27, 27)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(boxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addComponent(jDateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159))
        );

        contenedor.add(jPanel2, "unooo");

        pagosPendientes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pagosPendientes.setForeground(new java.awt.Color(255, 255, 255));
        pagosPendientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prueba_sistema/historial-de-transacciones.png"))); // NOI18N
        pagosPendientes.setText("PAGOS PENDIENTES");
        pagosPendientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pagosPendientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pagosPendientesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pagosPendientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pagosPendientesMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(Pagos, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Historial, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pagosPendientes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 1576, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Pagos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Historial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pagosPendientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1576, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel5Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(261, 261, 261))
        );

        add(panel5, "cinco");
    }// </editor-fold>//GEN-END:initComponents

    private void HistorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HistorialMouseClicked
        Historial panelprimero = new Historial();
        contenedor.add(panelprimero,"dos");
        contenedor.getLayout();
        cardLayout.show(contenedor, "dos");
    }//GEN-LAST:event_HistorialMouseClicked

    private void PagosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PagosMouseClicked
        cardLayout.show(contenedor, "unooo");
    }//GEN-LAST:event_PagosMouseClicked

    private void labelPagarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelPagarMouseClicked
       try{
           int codigo_tipo_pago=Clases.Pago.obtenerCodigoTipoPago(cx, boxTipoPago.getSelectedItem().toString());
           int codigo_alumno=Clases.Alumno.obtenerCodigo(cx, Integer.parseInt(txtDni.getText()));
           int codigo_inscripcion=Clases.Inscripcion.buscarCodigo(cx, codigo_alumno);
           Date fechaSeleccionada = jDateFecha.getDate();
            // Crear el formateador
           SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
           
           // Convertir la fecha al formato deseado
           String fechaFormateada = formato.format(fechaSeleccionada);
           int codigo_servicio=Clases.Inscripcion.obtenerCodigoServicio(cx, txtServicio.getText());
           float recargo=Float.parseFloat(txtRecargo.getText());
           
           int codigo_mes=0;
           if(boxMes.isEnabled()){
              codigo_mes=Clases.Asistencia.obtenerCodigoMes(cx, boxMes.getSelectedItem().toString());
           }
                
           
           int codigo_ciclo_lectivo=Clases.Inscripcion.obtenerCodigoCLPorInscripcion(cx, codigo_inscripcion);
           String obervacion=txtAreaObservacion.getText();
           float total=Float.parseFloat(txtTotal.getText());
           
           
           //////VALIDACION: PARA QUE NO HAGA INSERTE EL MISMO PAGO DOS VECES...
           // si el codigo_mes = 0, quiere decir que el servicio es clase personalizada, por lo tanto la validacion es por fecha y año
            int año_inscripcion=Clases.Inscripcion.obtenerAñoInscripcion(cx, Integer.parseInt(txtDni.getText()));
            
           if (codigo_mes==0){
              
              
               rs=Clases.Pago.evitarDoblesPagosServicioClase(cx, codigo_inscripcion, fechaFormateada, codigo_ciclo_lectivo); /// consulta para ver si ya pagó esa fecha del ciclo lectivo al que pertenezca esa inscripcion
               if(rs.next()){  ///si hay datos, quiere decir que ya pagó, por lo tanto el sistema no le debe permitir realizar de nuevo el mismo pago
                   SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy"); /// creamos un formato de  fecha en formato dia-mes-año
                   String fechaBonita = formato2.format(fechaSeleccionada); /// a ese formato creado lo guardamos en la variable fechaBonita, mas que nada para mostrarle al usuario una fecha legible, y no un año--me-dia...
                   JOptionPane.showMessageDialog(null, "El alumno "+txtAlumno.getText()+" ya tiene registrado un pago de la fecha "+fechaBonita+" del Ciclo Lectivo "+año_inscripcion,"ERROR",ERROR_MESSAGE);
                   return;
               }
           }else{///sino quiere decir que el servicio es mensual, por lo tanto la validacion es por mes y año
               rs=Clases.Pago.evitarDoblesPagosServicioMensual(cx, codigo_inscripcion, codigo_mes, codigo_ciclo_lectivo);  //consulta para ver si ya pagó el ese mes del ciclo lectivo al que pertenezca esa isncripcion
              if(rs.next()){ /// si hay datos, quiere decir que ya pagó ese mes del ciclo lecctivo al que pertenezca esa inscripcion, por lo tanto el sistema no le debe permitir realizar el pago
                   JOptionPane.showMessageDialog(null, "El alumno "+txtAlumno.getText()+" ya tiene registrado un pago del mes "+boxMes.getSelectedItem()+" del Ciclo Lectivo "+año_inscripcion,"ERROR",ERROR_MESSAGE);
                   return;
              }
           }
           //////insertar el pago...
           Clases.Pago.pagar(cx, codigo_tipo_pago, codigo_inscripcion, fechaFormateada, codigo_servicio, recargo, codigo_mes, codigo_ciclo_lectivo, obervacion, total);
            JOptionPane.showMessageDialog(null, "Se ha pagado correctamente el servicio");
            limpiar();
          
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar pagar el servicio","ERROR",ERROR_MESSAGE);
       }
        
  
    }//GEN-LAST:event_labelPagarMouseClicked

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        char c=evt.getKeyChar();
         // verificar si el carácter ingresado es unicamente numeros
      if (!Character.isDigit(c) || txtDni.getText().length()>8) {
        evt.consume(); 
    }    
    }//GEN-LAST:event_txtDniKeyTyped

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
     ///este evento se ejecuta cuando el usuario presione unicamente ENTER,, en caso de que ponga un dni inexistente, saldra el mensaje del catch...
       
        try{
         rs=Clases.Pago.consultarServicioYPrecio(cx, Integer.parseInt(txtDni.getText()));
         while(rs.next()){
                   datos[0]=rs.getString("al.nombre");
                   datos[1]=rs.getString("al.apellido");
                   datos[2]=rs.getString("ser.nombre");
                   datos[3]=rs.getString("ser.precio");
                   datos[4]=rs.getInt("ser.codigo_modalidad_cobro");         
          }
         
         int modalidad_cobro=(int) datos[4];
         String apenom=datos[0].toString()+" "+datos[1].toString();
         txtAlumno.setText(apenom);
         txtServicio.setText(datos[2].toString());
         txtPrecio.setText(datos[3].toString());
         int codigo_alumno=Clases.Alumno.obtenerCodigo(cx, Integer.parseInt(txtDni.getText()));   ///obtener el codigo del alumno
         int codigo_inscripcion=Clases.Inscripcion.buscarCodigo(cx, codigo_alumno); //obtener el codigo de inscripcion del alumno, nos devolvera su actual inscripcion
         if(modalidad_cobro==1){
            activarBoxMes();
           
            cargarComboBoxMeses(codigo_inscripcion);
          
         }
             
         
         activarCampos();
         txtDni.setEnabled(false);
                
              
             
    }catch(Exception e){
          
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al buscar el servicio y el precio del servicio del alumno","ERROR",ERROR_MESSAGE);
          
       }
    }//GEN-LAST:event_txtDniActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtRecargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRecargoActionPerformed
       
    }//GEN-LAST:event_txtRecargoActionPerformed

    private void jDateFechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateFechaPropertyChange
         validarCamposVacios();
        calcularRecargoYTotal();
    }//GEN-LAST:event_jDateFechaPropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
          buscarAlumno dialog = new buscarAlumno(frame, true, p3, a, this, 3);
          dialog.setVisible(true);
          
          try{
              rs=Clases.Pago.consultarServicioYPrecio(cx, Integer.parseInt(txtDni.getText()));
              while(rs.next()){
                  datos[0]=rs.getString("al.nombre");
                  datos[1]=rs.getString("al.apellido");
                   datos[2]=rs.getString("ser.nombre");
                   datos[3]=rs.getString("ser.precio");
                   datos[4]=rs.getInt("ser.codigo_modalidad_cobro");         
              }
         
              int modalidad_cobro=(int) datos[4];
              
              txtServicio.setText(datos[2].toString());
              txtPrecio.setText(datos[3].toString());
              int codigo_alumno=Clases.Alumno.obtenerCodigo(cx, Integer.parseInt(txtDni.getText()));   ///obtener el codigo del alumno
              int codigo_inscripcion=Clases.Inscripcion.buscarCodigo(cx, codigo_alumno); //obtener el codigo de inscripcion del alumno, nos devolvera su actual inscripcion
              if(modalidad_cobro==1){
                activarBoxMes();
           
                cargarComboBoxMeses(codigo_inscripcion);
          
              }else{
                activarCampos();
              }
              txtDni.setEnabled(false);
          }catch(Exception e){
          
               JOptionPane.showMessageDialog(null, "Ha ocurrido un error al buscar el servicio del alumno","ERROR",ERROR_MESSAGE);
           
         }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void labelCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelCancelarMouseClicked
           limpiar();        
    }//GEN-LAST:event_labelCancelarMouseClicked

    private void boxMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxMesActionPerformed
       activarCampos();
    }//GEN-LAST:event_boxMesActionPerformed

    private void txtDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyReleased
        validarCamposVacios();
    }//GEN-LAST:event_txtDniKeyReleased

    private void txtAlumnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlumnoKeyReleased
        validarCamposVacios();
    }//GEN-LAST:event_txtAlumnoKeyReleased

    private void txtServicioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtServicioKeyReleased
        validarCamposVacios();
    }//GEN-LAST:event_txtServicioKeyReleased

    private void txtPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyReleased
         validarCamposVacios();
    }//GEN-LAST:event_txtPrecioKeyReleased

    private void boxTipoPagoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxTipoPagoItemStateChanged
         validarCamposVacios();
    }//GEN-LAST:event_boxTipoPagoItemStateChanged

    private void txtRecargoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRecargoKeyReleased
          validarCamposVacios();
    }//GEN-LAST:event_txtRecargoKeyReleased

    private void txtTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalKeyReleased
         validarCamposVacios();
    }//GEN-LAST:event_txtTotalKeyReleased

    private void jDateFechaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateFechaKeyTyped
       
    
    }//GEN-LAST:event_jDateFechaKeyTyped

    private void pagosPendientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pagosPendientesMouseClicked
         pagosPendientes pp = new pagosPendientes();
        contenedor.add(pp,"tres");
        contenedor.getLayout();
        cardLayout.show(contenedor, "tres");        
    }//GEN-LAST:event_pagosPendientesMouseClicked

    private void PagosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PagosMouseEntered
         Pagos.setBackground(new Color(255,204,204));
    }//GEN-LAST:event_PagosMouseEntered

    private void PagosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PagosMouseExited
         Pagos.setBackground(new Color(255,102,102));
    }//GEN-LAST:event_PagosMouseExited

    private void HistorialMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HistorialMouseEntered
         Historial.setBackground(new Color(255,204,204));
    }//GEN-LAST:event_HistorialMouseEntered

    private void HistorialMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HistorialMouseExited
       Historial.setBackground(new Color(255,102,102));
    }//GEN-LAST:event_HistorialMouseExited

    private void pagosPendientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pagosPendientesMouseEntered
         pagosPendientes.setBackground(new Color(255,204,204));
    }//GEN-LAST:event_pagosPendientesMouseEntered

    private void pagosPendientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pagosPendientesMouseExited
         pagosPendientes.setBackground(new Color(255,102,102));
    }//GEN-LAST:event_pagosPendientesMouseExited

    public void setTxtAlumno(String nombre) {
        txtAlumno.setText(nombre);
    }

    public void setTxtDni(String dni) {
        txtDni.setText(dni);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Historial;
    private javax.swing.JLabel Pagos;
    private javax.swing.JComboBox<String> boxMes;
    private javax.swing.JComboBox<String> boxTipoPago;
    private javax.swing.JPanel contenedor;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCancelar;
    private javax.swing.JLabel labelPagar;
    private javax.swing.JLabel pagosPendientes;
    private javax.swing.JPanel panel5;
    private javax.swing.JTextField txtAlumno;
    private javax.swing.JTextArea txtAreaObservacion;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtRecargo;
    private javax.swing.JTextField txtServicio;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
