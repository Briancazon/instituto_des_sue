
package ObraSocial;

import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;


public class OS extends javax.swing.JPanel {
     DefaultTableModel tabla1=new DefaultTableModel();
      Object[] datos1=new Object[8];
      ResultSet rs;
      Connection cx=Conexion.conexion.conexion();
   
    public OS() {
        initComponents();
         mostrarO();
         configurarColumn();
         desactivarGuardar();
         desactivarCampo();
        desactivarEditar();
        desactivarEliminar();
        desactivarcargar();
        desactivarbuscar();
        desactivarhabilitado();
        
         nomtxt.getDocument().addDocumentListener(new javax.swing.event.DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
              
                verificarcampo();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                 verificarcampo();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                verificarcampo();
            }
            private void verificarcampo(){
                buscar.setEnabled(!nomtxt.getText().trim().isEmpty());
                cargar.setEnabled(!nomtxt.getText().trim().isEmpty());
            }
                   
         });
        
    }
    
    private void check(){
        
      
        
        if( checkInactivo.isSelected()){
            activarhabilitado();
            desactivarEliminar();
            desactivarEditar();
            
            
            tabla1.setRowCount(0);   
              tabla1.setColumnCount(0);
              tabla1.addColumn("Nº");  
              tabla1.addColumn("Obra Social");
        
               try{
            
                    rs=Clases.ObraSocial.mostrarObrasSocialesInactivas(cx);
                    while(rs.next()){
                        datos1[0]=rs.getString("codigo");
                        datos1[1]=rs.getString("nombre");
                   
                  
                        tabla1.addRow(datos1);
                   
                    }
              
                    tablaOS.setModel(tabla1);
             
              
                  }catch(Exception e){
                         JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar las obras sociales en la tabla","ERROR",ERROR_MESSAGE); 
                   }
                   configurarColumn();  
                   
        }else{
               tabla1.setRowCount(0);   
              tabla1.setColumnCount(0);
              tabla1.addColumn("Nº");  
              tabla1.addColumn("Obra Social");
        
               try{
            
                    rs=Clases.ObraSocial.mostrarObrasSocialesActivas(cx);
                    while(rs.next()){
                        datos1[0]=rs.getString("codigo");
                        datos1[1]=rs.getString("nombre");
                   
                  
                        tabla1.addRow(datos1);
                   
                    }
              
                    tablaOS.setModel(tabla1);
             
              
                  }catch(Exception e){
                         JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar las obras sociales en la tabla","ERROR",ERROR_MESSAGE); 
                   }
                   configurarColumn();  
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
      /*  if (checkInactivo.isSelected() && checkActivo.isSelected()){
                tabla1.setRowCount(0);   
        tabla1.setColumnCount(0);
        tabla1.addColumn("Nº");  
        tabla1.addColumn("Obra Social");
        
        try{
            
             rs=Clases.ObraSocial.mostrasTodasObrasSociales(cx);
              while(rs.next()){
                   datos1[0]=rs.getString("codigo");
                   datos1[1]=rs.getString("nombre");
                   
                  
                   tabla1.addRow(datos1);
                   
              }
              
              tablaOS.setModel(tabla1);
             
              
          }catch(Exception e){
                   JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar las obras sociales en la tabla","ERROR",ERROR_MESSAGE); 
          }
      configurarColumn();   
        
      
    
        }else if(checkActivo.isSelected()){
                    tabla1.setRowCount(0);   
                    tabla1.setColumnCount(0);
                   tabla1.addColumn("Nº");  
                   tabla1.addColumn("Obra Social");
        
                   try{
            
                      rs=Clases.ObraSocial.mostrarObrasSocialesActivas(cx);
                      while(rs.next()){
                          datos1[0]=rs.getString("codigo");
                          datos1[1]=rs.getString("nombre");
                   
                  
                          tabla1.addRow(datos1);
                   
                     }
              
                      tablaOS.setModel(tabla1);
             
              
                   }catch(Exception e){
                         JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar las obras sociales en la tabla","ERROR",ERROR_MESSAGE); 
                   }
      configurarColumn(); 
         
        
        }else 
         {
              tabla1.setRowCount(0);   
              tabla1.setColumnCount(0);
              tabla1.addColumn("Nº");  
              tabla1.addColumn("Obra Social");
        
               try{
            
                    rs=Clases.ObraSocial.mostrarObrasSocialesInactivas(cx);
                    while(rs.next()){
                        datos1[0]=rs.getString("codigo");
                        datos1[1]=rs.getString("nombre");
                   
                  
                        tabla1.addRow(datos1);
                   
                    }
              
                    tablaOS.setModel(tabla1);
             
              
                  }catch(Exception e){
                         JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar las obras sociales en la tabla","ERROR",ERROR_MESSAGE); 
                   }
                   configurarColumn();  
                  
        
        }
        */
    }

    private void desactivarGuardar() {
          labelGuardar.setEnabled(false);
    }

    private void desactivarAgregar() {
           labelAgregar.setEnabled(false);
    }

    private void desactivarEditar() {
        labelEditar.setEnabled(false);
    }

    private void desactivarEliminar() {
        labelEliminar.setEnabled(false);
    }

    private void activarGuardar() {
           labelGuardar.setEnabled(true);
    }

    private void activarAgregar() {
        labelAgregar.setEnabled(true);
    }

    private void desactivarCampo() {
       nombretxt.setEnabled(false);
    }

    private void activarEditar() {
         labelEditar.setEnabled(true);
    }

    private void activarCampo() {
        nombretxt.setEnabled(true);
    }

    private void activarEliminar() {
        labelEliminar.setEnabled(true);
    }
    private void activarbuscar(){
        buscar.setEnabled(true);
    }
    private void activarcargar(){
        cargar.setEnabled(true);
    } 
    private void desactivarcargar(){
        cargar.setEnabled(false);
    }
     private void desactivarbuscar(){
       buscar.setEnabled(false);
    }
    private void activarhabilitado(){
        habilitar.setEnabled(true);
    }
    private void desactivarhabilitado(){
      habilitar.setEnabled(false);
    }
    
    
    
    
    
     public class FondoPanel2 extends JPanel {
    
    private Image imagen;
    @Override
        public void paint(Graphics g){
            imagen= new ImageIcon(getClass().getResource("/Imagenes2/2.jpg")).getImage();
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
            
             rs=Clases.ObraSocial.mostrarObrasSocialesActivas(cx);
              while(rs.next()){
                   datos1[0]=rs.getString("codigo");
                   datos1[1]=rs.getString("nombre");
                   
                  
                   tabla1.addRow(datos1);
                   
              }
              
              tablaOS.setModel(tabla1);
             
              
          }catch(Exception e){
                   JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar las obras sociales en la tabla","ERROR",ERROR_MESSAGE); 
          }
      configurarColumn();   
    }
     
     public void inhabilitado(){
          
        tabla1.setRowCount(0);   
        tabla1.setColumnCount(0);
        tabla1.addColumn("Nº");  
        tabla1.addColumn("Obra Social");
        
        try{
            
             rs=Clases.ObraSocial.mostrarObrasSocialesInactivas(cx);
              while(rs.next()){
                   datos1[0]=rs.getString("codigo");
                   datos1[1]=rs.getString("nombre");
                   
                  
                   tabla1.addRow(datos1);
                   
              }
              
              tablaOS.setModel(tabla1);
               
              
          }catch(Exception e){
                   JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar las obras sociales en la tabla","ERROR",ERROR_MESSAGE); 
          }
      configurarColumn(); 
         
       
     }
     
     
     
     
     
     
     
     
     
     
     
    private void configurarColumn(){
         tablaOS.getColumnModel().getColumn(0).setMinWidth(60);
        tablaOS.getColumnModel().getColumn(0).setPreferredWidth(80);
        tablaOS.getColumnModel().getColumn(0).setMaxWidth(60);
        
        
        
    }
    
     
     
     
     
     
     
     
     
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new FondoPanel2();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        buscar = new javax.swing.JLabel();
        nomtxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaOS = new javax.swing.JTable();
        labelCodigo = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 102, 102));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(1000, 70));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Obra Social");

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/os.png"))); // NOI18N

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sol.png"))); // NOI18N
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addGap(14, 14, 14))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel14)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/Buscar_1.png"))); // NOI18N
        buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarMouseClicked(evt);
            }
        });

        nomtxt.setBackground(new java.awt.Color(255, 204, 204));
        nomtxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nomtxt.setForeground(new java.awt.Color(0, 0, 0));
        nomtxt.setBorder(null);
        nomtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomtxtActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 204, 204));
        jLabel7.setForeground(new java.awt.Color(255, 102, 51));
        jLabel7.setText("*********************************************************");

        cargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recargar.png"))); // NOI18N
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
                .addGap(263, 263, 263)
                .addComponent(buscar, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addComponent(nomtxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cargar, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addGap(288, 288, 288))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cargar)
                    .addComponent(buscar)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(nomtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 102, 102));

        labelEditar.setFont(new java.awt.Font("Segoe Print", 1, 10)); // NOI18N
        labelEditar.setForeground(new java.awt.Color(255, 255, 255));
        labelEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/m.png"))); // NOI18N
        labelEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelEditarMouseClicked(evt);
            }
        });

        labelGuardar.setFont(new java.awt.Font("Segoe Print", 1, 10)); // NOI18N
        labelGuardar.setForeground(new java.awt.Color(255, 255, 255));
        labelGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/g.png"))); // NOI18N
        labelGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelGuardarMouseClicked(evt);
            }
        });

        labelEliminar.setFont(new java.awt.Font("Segoe Print", 1, 10)); // NOI18N
        labelEliminar.setForeground(new java.awt.Color(255, 255, 255));
        labelEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/e.png"))); // NOI18N
        labelEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelEliminarMouseClicked(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 102, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
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

        labelAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        labelAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAgregarMouseClicked(evt);
            }
        });

        Cancelar.setFont(new java.awt.Font("Segoe Print", 1, 10)); // NOI18N
        Cancelar.setForeground(new java.awt.Color(255, 255, 255));
        Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/c.png"))); // NOI18N
        Cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelarMouseClicked(evt);
            }
        });

        habilitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/activo1.png"))); // NOI18N
        habilitar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                habilitarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombretxt, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(195, 195, 195)
                .addComponent(labelAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(habilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkInactivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cancelar)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelEditar)
                    .addComponent(labelEliminar))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(nombretxt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(labelAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(habilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(labelGuardar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Cancelar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(checkInactivo)
                        .addGap(18, 18, 18))))
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
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18)
                .addComponent(labelCodigo)
                .addGap(36, 36, 36))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                        .addGap(39, 39, 39))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(labelCodigo)
                        .addContainerGap(189, Short.MAX_VALUE))))
        );

        add(jPanel1, "os");
    }// </editor-fold>//GEN-END:initComponents

    private void nombretxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombretxtActionPerformed
       
    }//GEN-LAST:event_nombretxtActionPerformed

    private void labelGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelGuardarMouseClicked
          String nombre= nombretxt.getText();
          String codigo=labelCodigo.getText();
        
        try{
            if(!codigo.isEmpty()){
                    Clases.ObraSocial.update(cx, nombre, Integer.parseInt(codigo));
                   JOptionPane.showMessageDialog(null, "Los datos se actualizaron correctamente"); 
                   labelCodigo.setText("");
                   desactivarGuardar();
                   desactivarCampo();
            }else{
                  Clases.ObraSocial.cargar(cx, nombre);
                  JOptionPane.showMessageDialog(null, "Los datos se guardaron correctamente"); 
                  desactivarGuardar();
                  activarAgregar();
                  desactivarCampo();
            }
          
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se ha cargado correctamente"); 
        }
        nombretxt.setText("");
        mostrarO();
    }//GEN-LAST:event_labelGuardarMouseClicked

    private void labelEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEliminarMouseClicked
   
      
            
            
        
        
        
        
        
        
        int codigo=Integer.parseInt(labelCodigo.getText());
       
       int n= JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro seleccionado?","Eliminación", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE); 
       if(n==JOptionPane.YES_NO_OPTION){
           
           try{
               Clases.ObraSocial.eliminar(cx, codigo);
               JOptionPane.showMessageDialog(null, "Se ha eliminado el registro correctamente");
                desactivarGuardar();
      desactivarEditar();
      desactivarEliminar();
      activarAgregar();
      desactivarCampo();
      nombretxt.setText("");
      mostrarO();

              
             }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se ha podido eliminar el registro seleccionado","ERROR",ERROR_MESSAGE); 
              desactivarGuardar();
      desactivarEditar();
      desactivarEliminar();
      activarAgregar();
      desactivarCampo();
      nombretxt.setText("");
      mostrarO();
             }
           
           
       }else{
           JOptionPane.showMessageDialog(null, "Se ha cancelado la eliminación"); 
            desactivarGuardar();
      desactivarEditar();
      desactivarEliminar();
      activarAgregar();
      desactivarCampo();
      nombretxt.setText("");
       }
        
      
    }//GEN-LAST:event_labelEliminarMouseClicked

    private void buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarMouseClicked
       String nom=nomtxt.getText();
         ResultSet rs;
    tabla1.setRowCount(0);   
    tabla1.setColumnCount(0);
    tabla1.addColumn("Nº");
    tabla1.addColumn("Obra Social");
     try{
         rs=Clases.ObraSocial.buscarOS(cx, nom);
         if(rs.next()){
                   datos1[0]=rs.getString("codigo");
                   datos1[1]=rs.getString("nombre");
                  
                  
                   tabla1.addRow(datos1);
                   tablaOS.setModel(tabla1);
                   
          }else{
              JOptionPane.showMessageDialog(null, "La Obra Social "+nomtxt.getText()+" no existe","ERROR",ERROR_MESSAGE);
              mostrarO();
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
            
            desactivarEliminar();
            desactivarEditar();
            
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
       activarCampo();
       desactivarEditar();
       activarGuardar();
       
    }//GEN-LAST:event_labelEditarMouseClicked

    private void labelAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAgregarMouseClicked
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
        desactivarGuardar();
        desactivarEditar();
        desactivarEliminar();
        activarAgregar();
        desactivarCampo();
        nombretxt.setText("");
    }//GEN-LAST:event_CancelarMouseClicked

    private void cargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargarMouseClicked
         mostrarO();
    }//GEN-LAST:event_cargarMouseClicked

    private void habilitarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_habilitarMouseClicked
       
        int codigo=Integer.parseInt(labelCodigo.getText());
       
       int n= JOptionPane.showConfirmDialog(null, "¿Desea habilitar el registro seleccionado?","Habiliatar", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE); 
       if(n==JOptionPane.YES_NO_OPTION){
           
           try{
               Clases.ObraSocial.habilitarOS(cx, codigo);
               JOptionPane.showMessageDialog(null, "Se ha habilitado el registro correctamente");
              nombretxt.setText("");
              inhabilitado();

              
             }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se ha podido habilitar el registro seleccionado","ERROR",ERROR_MESSAGE); 
               nombretxt.setText("");
     
             }
           
           
       }else{
           JOptionPane.showMessageDialog(null, "Se ha cancelado"); 
       
      nombretxt.setText("");
       }
       
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_habilitarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cancelar;
    private javax.swing.JLabel buscar;
    private javax.swing.JLabel cargar;
    private javax.swing.JCheckBox checkInactivo;
    private javax.swing.JLabel habilitar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
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
