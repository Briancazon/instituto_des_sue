
package VISTA.ABMs;

import VISTA.TablaEstilo;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.FileOutputStream;
import java.sql.Connection;

import java.sql.ResultSet;
import java.time.LocalDate;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JPanel;

import javax.swing.table.DefaultTableModel;


public class OS extends javax.swing.JPanel {
     DefaultTableModel tabla1=new DefaultTableModel();
      Object[] datos1=new Object[2];
      ResultSet rs;
      Connection cx=MODELO_CONTROLADOR.conexion.conexion();
      boolean lBuscar=true;
     boolean lAgregar=true;
     boolean lGuardar=true;
     boolean lEditar=true;
     boolean lEliminar=true;
     boolean lHabilitar=true;
    
   
    public OS() {
        initComponents();
         mostrarO();
      
         desactivarGuardar();
         desactivarCampo();
        desactivarEditar();
        desactivarEliminar();

        desactivarbuscar();
        desactivarhabilitado();
        
    
         TablaEstilo.personalizarTabla(tablaOS);
        
    }
    
    
    void limpiar(){
        desactivarGuardar();
        desactivarEditar();
        desactivarEliminar();
        activarAgregar();
        desactivarCampo();
        nombretxt.setText("");
         labelCodigo.setText("");
    }
    
    
    
    void verfiicarBusqueda(){
        if(nomtxt.getText().isEmpty()){
            desactivarbuscar();
        }else{
            activarbuscar();
        }
    }
    
   void check(){
        
      
        ///si el checkbox (de os inactivas) es seleccionado , mostramos las obras inactivas..
        if( checkInactivo.isSelected()){
            limpiar();
            desactivarEliminar();
            desactivarEditar();
            desactivarGuardar();
            desactivarAgregar();
            
            
            tabla1.setRowCount(0);   
              tabla1.setColumnCount(0);
              tabla1.addColumn("Nº");  
              tabla1.addColumn("Obra Social");
        
               try{
            
                    rs=MODELO_CONTROLADOR.ObraSocial.mostrarObrasSocialesInactivas(cx);
                    while(rs.next()){
                        datos1[0]=rs.getString("codigo");
                        datos1[1]=rs.getString("nombre");
                   
                  
                        tabla1.addRow(datos1);
                   
                    }
              
                    tablaOS.setModel(tabla1);
             
              
                  }catch(Exception e){
                         JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar las obras sociales en la tabla","ERROR",ERROR_MESSAGE); 
                   }

          
                   ///sino mostramos las ob acivas..
        }else{
            activarAgregar();
            desactivarhabilitado();
               tabla1.setRowCount(0);   
              tabla1.setColumnCount(0);
              tabla1.addColumn("Nº");  
              tabla1.addColumn("Obra Social");
        
               try{
            
                    rs=MODELO_CONTROLADOR.ObraSocial.mostrarObrasSocialesActivas(cx);
                    while(rs.next()){
                        datos1[0]=rs.getString("codigo");
                        datos1[1]=rs.getString("nombre");
                   
                  
                        tabla1.addRow(datos1);
                   
                    }
              
                    tablaOS.setModel(tabla1);
             
   
                  }catch(Exception e){
                         JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar las obras sociales en la tabla","ERROR",ERROR_MESSAGE); 
                   }
          
        }
        
        
    
      
    }

    private void desactivarGuardar() {
          labelGuardar.setEnabled(false);
          lGuardar=false;
    }

    private void desactivarAgregar() {
           labelAgregar.setEnabled(false);
           lAgregar=false;
    }

    private void desactivarEditar() {
        labelEditar.setEnabled(false);
        lEditar=false;
    }

    private void desactivarEliminar() {
        labelEliminar.setEnabled(false);
        lEliminar=false;
    }

    private void activarGuardar() {
           labelGuardar.setEnabled(true);
           lGuardar=true;
    }

    private void activarAgregar() {
        labelAgregar.setEnabled(true);
        lAgregar=true;
    }

    private void desactivarCampo() {
       nombretxt.setEnabled(false);
    }

    private void activarEditar() {
         labelEditar.setEnabled(true);
         lEditar=true;
    }

    private void activarCampo() {
        nombretxt.setEnabled(true);
    }

    private void activarEliminar() {
        labelEliminar.setEnabled(true);
        lEliminar=true;
    }
   void activarbuscar(){
        buscar.setEnabled(true);
        lBuscar=true;
    }
    
     private void desactivarbuscar(){
       buscar.setEnabled(false);
        lBuscar=false;
    }
    private void activarhabilitado(){
        habilitar.setEnabled(true);
        lHabilitar=true;
    }
    private void desactivarhabilitado(){
      habilitar.setEnabled(false);
       lHabilitar=false;
    }
    
    
    
    
    
     public class FondoPanel2 extends JPanel {
    
    private Image imagen;
    @Override
        public void paint(Graphics g){
            imagen= new ImageIcon(getClass().getResource("/VISTA/Imagenes2/2.jpg")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
        
       
       
    
    }
     public void mostrarO(){
        
        tabla1.setRowCount(0);   
        tabla1.setColumnCount(0);
        tabla1.addColumn("Nº");  
        tabla1.addColumn("Obra Social");
        
        try{
            
             rs=MODELO_CONTROLADOR.ObraSocial.mostrarObrasSocialesActivas(cx);
              while(rs.next()){
                   datos1[0]=rs.getString("codigo");
                   datos1[1]=rs.getString("nombre");
                   
                  
                   tabla1.addRow(datos1);
                   
              }
              
              tablaOS.setModel(tabla1);
             
              
          }catch(Exception e){
                   JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar las obras sociales en la tabla","ERROR",ERROR_MESSAGE); 
          }
  
    }
     
     public void inhabilitado(){
          
        tabla1.setRowCount(0);   
        tabla1.setColumnCount(0);
        tabla1.addColumn("Nº");  
        tabla1.addColumn("Obra Social");
        
        try{
            
             rs=MODELO_CONTROLADOR.ObraSocial.mostrarObrasSocialesInactivas(cx);
              while(rs.next()){
                   datos1[0]=rs.getString("codigo");
                   datos1[1]=rs.getString("nombre");
                   
                  
                   tabla1.addRow(datos1);
                   
              }
              
              tablaOS.setModel(tabla1);
               
              
          }catch(Exception e){
                   JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar las obras sociales en la tabla","ERROR",ERROR_MESSAGE); 
          }
 
         
       
     }
     
     
     
     
     
     
     
     
     
     

     
     
     
     
     
     
     
     
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new FondoPanel2();
        jPanel5 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        buscar = new javax.swing.JLabel();
        nomtxt = new javax.swing.JTextField();
        cargar = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        labelEditar = new javax.swing.JLabel();
        labelGuardar = new javax.swing.JLabel();
        labelEliminar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombretxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        checkInactivo = new javax.swing.JCheckBox();
        labelAgregar = new javax.swing.JLabel();
        Cancelar = new javax.swing.JLabel();
        habilitar = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel28 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaOS = new javax.swing.JTable();
        labelCodigo = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 102, 102));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(1000, 70));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISTA/Imagenes/soll.gif"))); // NOI18N
        jLabel19.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Obra Social");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel14)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISTA/Imagenes2/buscar.png"))); // NOI18N
        buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarMouseClicked(evt);
            }
        });

        nomtxt.setBackground(new java.awt.Color(255, 153, 153));
        nomtxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nomtxt.setForeground(new java.awt.Color(0, 0, 0));
        nomtxt.setBorder(null);
        nomtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomtxtActionPerformed(evt);
            }
        });
        nomtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomtxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomtxtKeyTyped(evt);
            }
        });

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
                .addGap(14, 14, 14)
                .addComponent(buscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nomtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cargar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nomtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar)
                    .addComponent(cargar))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 102, 102));

        labelEditar.setFont(new java.awt.Font("Segoe Print", 1, 10)); // NOI18N
        labelEditar.setForeground(new java.awt.Color(255, 255, 255));
        labelEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISTA/Imagenes2/nota.png"))); // NOI18N
        labelEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelEditarMouseClicked(evt);
            }
        });

        labelGuardar.setFont(new java.awt.Font("Segoe Print", 1, 10)); // NOI18N
        labelGuardar.setForeground(new java.awt.Color(255, 255, 255));
        labelGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISTA/Imagenes/guardar_nuevo.png"))); // NOI18N
        labelGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelGuardarMouseClicked(evt);
            }
        });

        labelEliminar.setFont(new java.awt.Font("Segoe Print", 1, 10)); // NOI18N
        labelEliminar.setForeground(new java.awt.Color(255, 255, 255));
        labelEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISTA/Imagenes2/carpeta (1).png"))); // NOI18N
        labelEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelEliminarMouseClicked(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 102, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(" Obra Social:");

        nombretxt.setBackground(new java.awt.Color(255, 204, 204));
        nombretxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nombretxt.setForeground(new java.awt.Color(255, 0, 102));
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

        jLabel8.setBackground(new java.awt.Color(255, 204, 204));
        jLabel8.setForeground(new java.awt.Color(255, 204, 204));
        jLabel8.setText("*****************************************************************************");

        checkInactivo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        checkInactivo.setForeground(new java.awt.Color(255, 255, 255));
        checkInactivo.setText("Inactivo");
        checkInactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkInactivoActionPerformed(evt);
            }
        });

        labelAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISTA/Imagenes2/agregar.png"))); // NOI18N
        labelAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAgregarMouseClicked(evt);
            }
        });

        Cancelar.setFont(new java.awt.Font("Segoe Print", 1, 10)); // NOI18N
        Cancelar.setForeground(new java.awt.Color(255, 255, 255));
        Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISTA/Imagenes/expediente.png"))); // NOI18N
        Cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelarMouseClicked(evt);
            }
        });

        habilitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISTA/Imagenes2/habilitar.png"))); // NOI18N
        habilitar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        habilitar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                habilitarMouseClicked(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISTA/Imagenes/impresora.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Opciones");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Estados");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Imprimir");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombretxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(labelAgregar)
                .addGap(87, 87, 87)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(labelGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(labelEditar)
                        .addGap(18, 18, 18)
                        .addComponent(labelEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(Cancelar))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel28)))
                .addGap(31, 31, 31)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(checkInactivo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(habilitar))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel22)))
                .addGap(30, 30, 30)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jLabel17))
                .addGap(757, 757, 757))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(habilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(nombretxt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelGuardar)
                                    .addComponent(labelEditar)
                                    .addComponent(labelEliminar)
                                    .addComponent(Cancelar))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(jLabel8))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel28))))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(checkInactivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel22))))
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablaOS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nº", "Obra Social"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaOS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaOSMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaOS);
        if (tablaOS.getColumnModel().getColumnCount() > 0) {
            tablaOS.getColumnModel().getColumn(0).setResizable(false);
            tablaOS.getColumnModel().getColumn(0).setPreferredWidth(60);
            tablaOS.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1707, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(3, 3, 3))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE))
        );

        add(jPanel1, "os");
    }// </editor-fold>//GEN-END:initComponents

    private void nombretxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombretxtActionPerformed
       
    }//GEN-LAST:event_nombretxtActionPerformed

    private void labelGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelGuardarMouseClicked
        //si el lGuardar es false, quiere decir que esta accion esta desactivada
     if(!lGuardar){
         return;
     }          
        
        try{
            ///validacion de campos vacios
            if(nombretxt.getText().isEmpty()){
                 JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                  return; // Detiene la ejecución del método
            }
            String nombre= nombretxt.getText();
            String codigo=labelCodigo.getText();
            if(!codigo.isEmpty()){
                    MODELO_CONTROLADOR.ObraSocial.update(cx, nombre, Integer.parseInt(codigo));
                   JOptionPane.showMessageDialog(null, "Los datos se actualizaron correctamente"); 
                  limpiar();
            }else{
                  MODELO_CONTROLADOR.ObraSocial.cargar(cx, nombre);
                  JOptionPane.showMessageDialog(null, "Los datos se guardaron correctamente"); 
                  limpiar();
            }
          
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar cargar o actualizar la obra social","ERROR",ERROR_MESSAGE); 
        }
    
        mostrarO();
    }//GEN-LAST:event_labelGuardarMouseClicked

    private void labelEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEliminarMouseClicked
   
      
          //si el lEliminar es false, quiere decir que esta accion esta desactivada        
         if(!lEliminar){
             return;
         }
        int codigo=Integer.parseInt(labelCodigo.getText());
       
       int n= JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro seleccionado?","Eliminación", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE); 
       if(n==JOptionPane.YES_NO_OPTION){
           
           try{
                 MODELO_CONTROLADOR.ObraSocial.eliminar(cx, codigo);
                 JOptionPane.showMessageDialog(null, "Se ha eliminado el registro correctamente");
                 limpiar();
                 mostrarO();

              
             }catch(Exception e){
               JOptionPane.showMessageDialog(null, "No se ha podido eliminar el registro seleccionado","ERROR",ERROR_MESSAGE); 
               limpiar();
               mostrarO();
             }
           
           
       }else{
           JOptionPane.showMessageDialog(null, "Se ha cancelado la eliminación"); 
            limpiar();
       }
        
      
    }//GEN-LAST:event_labelEliminarMouseClicked

    private void buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarMouseClicked
       ///si el lBUscar  es false, quiere decir que esta accion esta desactivada....
       if(!lBuscar){
           return;
       } 
        desactivarhabilitado(); /// una simple validacion para que este label se desactive...
        String nom=nomtxt.getText();

    tabla1.setRowCount(0);   
    tabla1.setColumnCount(0);
    tabla1.addColumn("Nº");
    tabla1.addColumn("Obra Social");
     try{
         rs=MODELO_CONTROLADOR.ObraSocial.buscarOS(cx, nom);
         while(rs.next()){
                   datos1[0]=rs.getString("codigo");
                   datos1[1]=rs.getString("nombre");
                  
                  
                   tabla1.addRow(datos1);
                   tablaOS.setModel(tabla1);
                   
          }
                
              
             
    }catch(Exception e){
          
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al buscar la Obra Social","ERROR",ERROR_MESSAGE);
            mostrarO();
       }
    }//GEN-LAST:event_buscarMouseClicked

    private void nomtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomtxtActionPerformed

    private void tablaOSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaOSMouseClicked
        
         if(checkInactivo.isSelected()){
             int filaSeleccionada = tablaOS.getSelectedRow();
            
             String codigo =tablaOS.getValueAt(filaSeleccionada, 0).toString();
             labelCodigo.setText(codigo);
       
             activarhabilitado();
            
            
         } else{    
        
        
        
        
        try{
            int filaSeleccionada = tablaOS.getSelectedRow();
            
            String codigo =tablaOS.getValueAt(filaSeleccionada, 0).toString();
            String nombre =tablaOS.getValueAt(filaSeleccionada, 1).toString();
           
       
            
            nombretxt.setText(nombre);
           labelCodigo.setText(codigo);
           activarEditar();
           activarEliminar();
           desactivarAgregar();
           desactivarCampo();
           desactivarGuardar();
       }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No hay datos en la tabla","ERROR",ERROR_MESSAGE);
       }
      }
    }//GEN-LAST:event_tablaOSMouseClicked

    private void labelEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEditarMouseClicked
         //si el lEditar es false, quiere decir que esta accion esta desactivada
       if(!lEditar){
           return;
       }
       activarCampo();
       desactivarEditar();
       desactivarEliminar();
       desactivarAgregar();
       activarGuardar();
       
    }//GEN-LAST:event_labelEditarMouseClicked

    private void labelAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAgregarMouseClicked
      //si el lAgregar es false, quiere decir que esta accion esta desactivada
       if(!lAgregar){
           return;
       } 
       limpiar();
       activarCampo();
       desactivarAgregar();
       activarGuardar();
    
       nombretxt.setText("");
       labelCodigo.setText("");
    }//GEN-LAST:event_labelAgregarMouseClicked

    private void checkInactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkInactivoActionPerformed
      
        check();
    }//GEN-LAST:event_checkInactivoActionPerformed

    private void CancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelarMouseClicked
      limpiar();
    }//GEN-LAST:event_CancelarMouseClicked

    private void cargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargarMouseClicked
         mostrarO();
         nomtxt.setText("");
         desactivarhabilitado();
         verfiicarBusqueda();

    }//GEN-LAST:event_cargarMouseClicked

    private void habilitarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_habilitarMouseClicked
         //si el lHabilitar es false, quiere decir que esta accion esta desactivada       
        if(!lHabilitar){
            return;
        }
       
       int n= JOptionPane.showConfirmDialog(null, "¿Desea habilitar el registro seleccionado?","Habiliatar", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE); 
       if(n==JOptionPane.YES_NO_OPTION){
           
           try{
               int codigo=Integer.parseInt(labelCodigo.getText());
               MODELO_CONTROLADOR.ObraSocial.habilitarOS(cx, codigo);
               JOptionPane.showMessageDialog(null, "Se ha habilitado el registro correctamente");
               limpiar();
               desactivarhabilitado();
              inhabilitado();
              desactivarAgregar();

              
             }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se ha podido habilitar el registro seleccionado","ERROR",ERROR_MESSAGE); 
              limpiar();
               desactivarhabilitado();
               inhabilitado();
               desactivarAgregar();
     
             }
           
           
       }else{
           JOptionPane.showMessageDialog(null, "Se ha cancelado"); 
           limpiar();       
           desactivarhabilitado();
           desactivarAgregar();
       
       }
       
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_habilitarMouseClicked

    private void nombretxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombretxtKeyTyped
      char c=evt.getKeyChar();
         // verificar si el carácter ingresado es unicamente letra
      if ((!Character.isLetter(c) && c != ' ')|| nombretxt.getText().length()>25) {
        evt.consume(); 
    }  
    }//GEN-LAST:event_nombretxtKeyTyped

    private void nomtxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomtxtKeyTyped
         char c=evt.getKeyChar();
         // verificar si el carácter ingresado es unicamente letra
      if ((!Character.isLetter(c) && c != ' ') || nomtxt.getText().length()>25) {
        evt.consume(); 
    }  
    }//GEN-LAST:event_nomtxtKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      try {
               //  Ruta donde se guardará el PDF (en el Escritorio del usuario)
               String ruta = System.getProperty("user.home") + "\\Downloads\\REPORTES\\OBRA SOCIAL\\reporteObrasSociales.pdf";


               // Crear el documento en formato A4 horizontal (más ancho para las tablas)
               Document documento = new Document(PageSize.A4.rotate());

               // Asociar el documento con un "escritor" que lo guardará en la ruta indicada
               PdfWriter.getInstance(documento, new FileOutputStream(ruta));

               // Abrir el documento para comenzar a escribir contenido en él
               documento.open();

   
               //ENCABEZADO DEL DOCUMENTO
               // Título centrado y en negrita
               Paragraph titulo = new Paragraph("Reporte de Obras Sociales Activas",
               FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));
               titulo.setAlignment(Element.ALIGN_CENTER);
               documento.add(titulo);

               //  Subtítulo e información adicional
               documento.add(new Paragraph("Espacio Pedagógico Despertando Sueños"));
               documento.add(new Paragraph("Fecha: " + LocalDate.now()));
               documento.add(new Paragraph("\nListado de obras sociales activas:\n"));

   
               //  CREACIÓN DE LA TABLA PDF
               // Crear una tabla con 11 columnas
               PdfPTable tablaPDF = new PdfPTable(2);
               tablaPDF.setWidthPercentage(100);   // Ocupa el ancho total de la página
               tablaPDF.setSpacingBefore(10f);     // Espacio antes de la tabla
               tablaPDF.setSpacingAfter(10f);      // Espacio después de la tabla

               // Nombres de las columnas
               String[] columnas = {
                  "Obra Social", "Estado"
               };

               // Fuente para el encabezado (blanca sobre fondo azul)
               Font fontHeader = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10, Color.WHITE);

               // Agregar cada columna como una celda de encabezado
               for (String col : columnas) {
                   PdfPCell celda = new PdfPCell(new Phrase(col, fontHeader)); // Contenido de la celda
                   celda.setBackgroundColor(new Color(50, 100, 150));          // Color de fondo azul
                   celda.setHorizontalAlignment(Element.ALIGN_CENTER);          // Texto centrado
                   celda.setPadding(5);                                         // Espaciado interno
                   tablaPDF.addCell(celda);
               }

 
                //  LLENAR TABLA CON DATOS
                 Font fontData = FontFactory.getFont(FontFactory.HELVETICA, 9); // Fuente para los datos

                try {
                           // Se llama al método del modelo que devuelve las OS activas...
                           rs = MODELO_CONTROLADOR.ObraSocial.mostrarObrasSocialesActivas(cx);

                           // Se recorre cada fila del ResultSet y se agregan las celdas a la tabla
                          while (rs.next()) {
                            tablaPDF.addCell(new Phrase(rs.getString("nombre"), fontData));          // 1
                            int estado=rs.getInt("borrado");
                            if(estado==0){
                                 tablaPDF.addCell(new Phrase("ACTIVO", fontData));        // 2
                            }
                           
                          
}


                  } catch (Exception e) {
                             JOptionPane.showMessageDialog(null, "Error al cargar datos: " + e.getMessage());
                  }

                  // Agregar la tabla al documento PDF
                   documento.add(tablaPDF);

                  // Se cierra el documento (muy importante)
                  documento.close();

                   // Aviso al usuario
                   JOptionPane.showMessageDialog(this, "PDF generado correctamente.");

                   // Abrir el archivo automáticamente
                   java.awt.Desktop.getDesktop().open(new java.io.File(ruta));

   }catch (Exception ex) {
   
        JOptionPane.showMessageDialog(this, "Error al generar el PDF: " + ex.getMessage());
   }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void nomtxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomtxtKeyReleased
     verfiicarBusqueda();
    }//GEN-LAST:event_nomtxtKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cancelar;
    private javax.swing.JLabel buscar;
    private javax.swing.JLabel cargar;
    private javax.swing.JCheckBox checkInactivo;
    private javax.swing.JLabel habilitar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel labelAgregar;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelEditar;
    private javax.swing.JLabel labelEliminar;
    private javax.swing.JLabel labelGuardar;
    private javax.swing.JTextField nombretxt;
    private javax.swing.JTextField nomtxt;
    private javax.swing.JTable tablaOS;
    // End of variables declaration//GEN-END:variables
}
