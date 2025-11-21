
package VISTA;

import MODELO_CONTROLADOR.TablaEstilo;
import VISTA.ABMs.ModificarP;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import VISTA.buscarObraSocial;






public class Gastos extends javax.swing.JPanel {
DefaultTableModel tabla=new DefaultTableModel();
      Object[] datos=new Object[2];
      Object[] fila=new Object[2];
      ResultSet rs;
       ResultSet lm;
      Connection cx=MODELO_CONTROLADOR.conexion.conexion();
      DefaultComboBoxModel ls= new DefaultComboBoxModel();
    public Gastos() {
        
        initComponents();
        //Mes();
        MostrarTabla();
        calcularTotal();
          
      eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            eliminarya(); // llamamos al método que actualiza los datos
        }
    });
         DefaultTableModel model = (DefaultTableModel) tablaG.getModel();
        model.addTableModelListener(e -> calcularTotal());
        ModificarP Mo = new ModificarP(); 
        int cantidadDocentes = Mo.getCantidadDocentes(); // Método que devuelve tblDocentes.getRowCount()
         total1.setText(String.valueOf(cantidadDocentes));

        total1.setEditable(false);
        int mesActual = LocalDate.now().getMonthValue();
         mesbox.setSelectedIndex(mesActual - 1);
       
      totalG.setEditable(false);
      total2.setEditable(false);
    
      mesbox.setEnabled(false);
     
      TablaEstilo.personalizarTabla(tablaG);
      
      
      
      
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
    
  /*  void Mes(){
        try{
            rs=Clases.GastosG.mostrarMes(cx);
            ls.addElement("Seleccionar");
            while(rs.next())
                ls.addElement(rs.getString("mes"));
                mesbox.setModel(ls);
            
        }catch(Exception e){
              JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar el mes","ERROR",ERROR_MESSAGE);
        }
    }*/
    
    public void MostrarTabla(){
         tabla.setRowCount(0);   
              tabla.setColumnCount(0);
              tabla.addColumn("Nombre");  
              tabla.addColumn("Precio");
               try{
            
                    rs=MODELO_CONTROLADOR.GastosG.mostrar(cx);
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
    
  

public void guardarGasto() {
   
        // Obtener mes y año actual
        int mesActual = LocalDate.now().getMonthValue();
        

       

        // Obtener mes seleccionado del combo (escrito a mano)
        String mesNombre = mesbox.getSelectedItem().toString().trim().toLowerCase();
        int mesSeleccionado = 0;

        switch (mesNombre) {
            case "enero": mesSeleccionado = 1; break;
            case "febrero": mesSeleccionado = 2; break;
            case "marzo": mesSeleccionado = 3; break;
            case "abril": mesSeleccionado = 4; break;
            case "mayo": mesSeleccionado = 5; break;
            case "junio": mesSeleccionado = 6; break;
            case "julio": mesSeleccionado = 7; break;
            case "agosto": mesSeleccionado = 8; break;
            case "septiembre": mesSeleccionado = 9; break;
            case "octubre": mesSeleccionado = 10; break;
            case "noviembre": mesSeleccionado = 11; break;
            case "diciembre": mesSeleccionado = 12; break;
            default:
                JOptionPane.showMessageDialog(null, "Mes inválido.");
                return;
        }
           
        // Validar que sea el mes actual
        if (mesSeleccionado != mesActual) {
            JOptionPane.showMessageDialog(null, "Solo se pueden cargar gastos del mes actual.");
            return;
        }
           String texto = preciotxt.getText().trim();

          // Cambiamos coma por punto
         texto = texto.replace(',', '.');
          String nombre= nombretxt.getText();
       float precio= Float.parseFloat(texto);
       String mes= mesbox.getSelectedItem().toString(); 
       
        try{
            
           int codigomes=MODELO_CONTROLADOR.GastosG.obtenerCodigo(cx, mes);
            int c_c_l=MODELO_CONTROLADOR.GastosG.obtenerCodigoCicloLectivo(cx);
           MODELO_CONTROLADOR.GastosG.cargarGastos(cx, nombre, precio, codigomes, c_c_l);
            JOptionPane.showMessageDialog(null, "Se guardo correctamente correctamente"); 
           MostrarTabla();
            
            nombretxt.setText("");
            preciotxt.setText("");
            mesbox.setSelectedItem("Seleccionar");
            
            
        }catch(Exception e){
                 JOptionPane.showMessageDialog(null,e.getMessage());
        }
            

}
    public void mostrarPorMes(String mesSeleccionado) {
    try {
        tabla.setRowCount(0);   
        tabla.setColumnCount(0);
        tabla.addColumn("Nombre");  
        tabla.addColumn("Precio");

        // Usamos tu método de clase GastosG, adaptado para filtrar por mes
        rs = MODELO_CONTROLADOR.GastosG.mostrarPorMes(cx, mesSeleccionado);
        

        while (rs.next()) {
            datos[0] = rs.getString("nombre");
            datos[1] = rs.getString("precio");
            tabla.addRow(datos);
        }

        tablaG.setModel(tabla);
        calcularTotal();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al mostrar los datos del mes seleccionado: " + e.getMessage());
    }
}

public void eliminarya() {
      
        
          try{
               MODELO_CONTROLADOR.GastosG.desactivarTodosLosGastos(cx);
               JOptionPane.showMessageDialog(null, "Se ha eliminado el registro correctamente");
              MostrarTabla();
                
            }catch(Exception e){
               JOptionPane.showMessageDialog(null, "Error al eliminar gasto");   
            }
 
}

    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new FondoPanel2();
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        nombretxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        preciotxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        mesbox = new javax.swing.JComboBox<>();
        codigoG = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        totalG = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        total1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        total2 = new javax.swing.JTextField();
        calcular = new javax.swing.JButton();
        guardar = new javax.swing.JLabel();
        eliminar = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaG = new javax.swing.JTable();

        setLayout(new java.awt.CardLayout());

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISTA/Imagenes/soll.gif"))); // NOI18N
        jLabel19.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Calcular Gastos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addContainerGap(793, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel14)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 153, 153));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre de gasto:");

        nombretxt.setBackground(new java.awt.Color(255, 204, 204));
        nombretxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nombretxt.setForeground(new java.awt.Color(0, 0, 0));
        nombretxt.setBorder(null);
        nombretxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombretxtActionPerformed(evt);
            }
        });
        nombretxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombretxtKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("                  Precio:");

        preciotxt.setBackground(new java.awt.Color(255, 204, 204));
        preciotxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        preciotxt.setForeground(new java.awt.Color(0, 0, 0));
        preciotxt.setBorder(null);
        preciotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preciotxtActionPerformed(evt);
            }
        });
        preciotxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                preciotxtKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText(" Mes:");

        mesbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        codigoG.setBackground(new java.awt.Color(255, 153, 153));
        codigoG.setForeground(new java.awt.Color(255, 153, 153));
        codigoG.setText("jLabel10");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(preciotxt))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nombretxt)))
                .addGap(52, 52, 52)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mesbox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(49, 49, 49))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(codigoG, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombretxt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(mesbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(preciotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(12, 12, 12)
                .addComponent(codigoG)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 102, 102));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Total:");

        totalG.setBackground(new java.awt.Color(255, 204, 204));
        totalG.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalG.setForeground(new java.awt.Color(0, 0, 0));
        totalG.setBorder(null);
        totalG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalGActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cantidad de Docente:");

        total1.setBackground(new java.awt.Color(255, 204, 204));
        total1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        total1.setForeground(new java.awt.Color(0, 0, 0));
        total1.setBorder(null);
        total1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                total1ActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Pago por Docente:");

        total2.setBackground(new java.awt.Color(255, 204, 204));
        total2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        total2.setForeground(new java.awt.Color(0, 0, 0));
        total2.setBorder(null);
        total2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                total2ActionPerformed(evt);
            }
        });

        calcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISTA/Imagenes/calculadora.png"))); // NOI18N
        calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcularActionPerformed(evt);
            }
        });

        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISTA/Imagenes/guardar_nuevo.png"))); // NOI18N
        guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarMouseClicked(evt);
            }
        });

        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISTA/Imagenes2/servidor.png"))); // NOI18N
        eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarMouseClicked(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISTA/Imagenes2/gastooss.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(total1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalG, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calcular, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(total2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(eliminar))
                                .addGap(9, 9, 9))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calcular, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(total2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(totalG, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7)
                                        .addComponent(total1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        tablaG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre", "Precio"
            }
        ));
        tablaG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaGMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaG);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        add(jPanel1, "gasto");
    }// </editor-fold>//GEN-END:initComponents

    private void nombretxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombretxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombretxtActionPerformed

    private void preciotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preciotxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_preciotxtActionPerformed

    private void totalGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalGActionPerformed

    private void guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarMouseClicked
     guardarGasto();
       
       
       
    }//GEN-LAST:event_guardarMouseClicked

    private void total1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_total1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_total1ActionPerformed

    private void total2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_total2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_total2ActionPerformed

    private void calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcularActionPerformed
        
         double totalGastos = Double.parseDouble(totalG.getText().replace(",", "."));
         int cantidadDocentes = Integer.parseInt(total1.getText());

         double totalPorDocente = totalGastos / cantidadDocentes;
         total2.setText(String.format("%.2f", totalPorDocente));

    }//GEN-LAST:event_calcularActionPerformed

    private void tablaGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaGMouseClicked
        
         int filaSeleccionada = tablaG.getSelectedRow();
            
            String nombre =tablaG.getValueAt(filaSeleccionada, 0).toString();
            
            try{
               int codigo= MODELO_CONTROLADOR.GastosG.obtenerCodigoGastos(cx, nombre);
                codigoG.setText(String.valueOf(codigo));
                
            }catch(Exception e){
               JOptionPane.showMessageDialog(null, "Error al obtener el código");   
            }
        
    }//GEN-LAST:event_tablaGMouseClicked

    private void eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarMouseClicked
     
    }//GEN-LAST:event_eliminarMouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
       JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this); 
      ConsultaGasto dialogo = new ConsultaGasto(
        new javax.swing.JFrame(), // padre
        true,                     // modal
        this                      // 👈 pasamos el JPanel Gastos actual
    );
    dialogo.setLocationRelativeTo(null);
    dialogo.setVisible(true);

// Intentamos obtener la ventana padre (JFrame) automáticamente
//                JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(Gastos.this);
  //              ConsultaGasto dialogo = new ConsultaGasto(parent, true);
    //            dialogo.setVisible(true); // abre el JDialog
              
    }//GEN-LAST:event_jLabel9MouseClicked

    private void nombretxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombretxtKeyTyped
          char c = evt.getKeyChar();
        // Solo letras, espacio y borrar
        if (!Character.isLetter(c) && c != ' ' && c != '\b') {
            evt.consume(); // no se escribe el carácter
            javax.swing.JOptionPane.showMessageDialog(null, "Solo se permiten letras");
        }  
    }//GEN-LAST:event_nombretxtKeyTyped

    private void preciotxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_preciotxtKeyTyped
         char c = evt.getKeyChar();

        // Permitir solo dígitos, punto y coma decimal
        if (!Character.isDigit(c) && c != '.' && c != ',' && c != '\b') {
            evt.consume(); // Bloquea la tecla
            JOptionPane.showMessageDialog(null, "Solo se permiten números decimales");
        }
       
  
    }//GEN-LAST:event_preciotxtKeyTyped

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calcular;
    private javax.swing.JLabel codigoG;
    private javax.swing.JLabel eliminar;
    private javax.swing.JLabel guardar;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> mesbox;
    private javax.swing.JTextField nombretxt;
    private javax.swing.JTextField preciotxt;
    private javax.swing.JTable tablaG;
    private javax.swing.JTextField total1;
    private javax.swing.JTextField total2;
    private javax.swing.JTextField totalG;
    // End of variables declaration//GEN-END:variables
}
