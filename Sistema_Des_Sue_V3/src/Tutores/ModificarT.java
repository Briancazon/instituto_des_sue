
package Tutores;

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
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;

public class ModificarT extends javax.swing.JPanel {

    DefaultTableModel tabla=new DefaultTableModel();
     Object[] datos=new Object[5];
      ResultSet rs;
      Statement st;
     Connection cx=Conexion.conexion.conexion();
    public ModificarT() {
        initComponents();
        mostrarT();
        
         desactivarguardar();
        desactivarmodificar();
        desactivarcampo();
       desactivarcargar();
        desactivarbuscar();
        desactivarHabilitar();
        desactivareliminar();
        
        txtNombreBuscador.getDocument().addDocumentListener(new javax.swing.event.DocumentListener(){
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
                buscar.setEnabled(!txtNombreBuscador.getText().trim().isEmpty());
                cargar.setEnabled(!txtNombreBuscador.getText().trim().isEmpty());
            }
                   
            
        });
        
        
        
        
        
        
        
        
        
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
    
   
    
    public void mostrarT(){
         tabla.setRowCount(0);   
         tabla.setColumnCount(0);
        
         tabla.addColumn("Nombre");  
         tabla.addColumn("Apellido");  
         tabla.addColumn("DNI"); 
         tabla.addColumn("Telefono"); 
         tabla.addColumn("Estado"); 
        
         
         try{
            
             rs=Clases.Tutor.mostrartutoresactivos(cx);
              while(rs.next()){
                   datos[0]=rs.getString("nombre");
                   datos[1]=rs.getString("apellido");
                   datos[2]=rs.getString("dni");
                   datos[3]=rs.getString("telefono");
                   datos[4]=rs.getString("borrado");
                  
                    if( datos[4].equals("0")){
                        datos[4]="ACTIVO";
                   }else{
                        datos[4]="INACTIVO";
                   }
                 
                  
                   tabla.addRow(datos);
             
                   
              } 
               tablaTutor.setModel(tabla);
              
          }catch(Exception e){
                   JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar los tutores en la tabla","ERROR",ERROR_MESSAGE); 
          }
        
    }
    
    public void inhabilitado(){
         tabla.setRowCount(0);   
         tabla.setColumnCount(0);
        
         tabla.addColumn("Nombre");  
         tabla.addColumn("Apellido");  
         tabla.addColumn("DNI"); 
         tabla.addColumn("Telefono"); 
         tabla.addColumn("Estado");
        
         
         try{
            
             rs=Clases.Tutor.mostrartutoresinactivos(cx);
              while(rs.next()){
                   datos[0]=rs.getString("nombre");
                   datos[1]=rs.getString("apellido");
                   datos[2]=rs.getString("dni");
                   datos[3]=rs.getString("telefono");
                   datos[4]=rs.getString("borrado");
                  
                    if( datos[4].equals("0")){
                        datos[4]="ACTIVO";
                   }else{
                        datos[4]="INACTIVO";
                   }
                 
                  
                   tabla.addRow(datos);
                   tablaTutor.setModel(tabla);
                   
              } 
              
          }catch(Exception e){
                   JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar los tutores en la tabla","ERROR",ERROR_MESSAGE); 
          }
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    void activarHabilitar(){
         habilitar.setEnabled(true);
    }
    
     void desactivarHabilitar(){
         habilitar.setEnabled(false);
    }
    
    
    
    
    
    
    
    public void limpiar(){
        
         nombretxt.setText("");
         apellidotxt.setText("");
         dnitxt.setText("");
         telefonotxt.setText("");
         cod.setText("");
         desactivareliminar();
         desactivarmodificar();
         desactivarguardar();
         activaragregar();
    }
    
     public void desactivarguardar(){
         guardar.setEnabled(false);
     } 
     public void activarguardar(){
         guardar.setEnabled(true);
     }
     public void desactivarmodificar(){
         modificar.setEnabled(false);
     }
    public void activarmodificar(){
        modificar.setEnabled(true);
    }
    public void desactivarbuscar(){
        buscar.setEnabled(false);
    }
    public void activarbuscar(){
        buscar.setEnabled(true);
    }
    public void activarcampo(){
        nombretxt.setEnabled(true);
         apellidotxt.setEnabled(true);
         dnitxt.setEnabled(true);
         telefonotxt.setEnabled(true);
             }
    public void desactivarcampo(){
         nombretxt.setEnabled(false);
         apellidotxt.setEnabled(false);
         dnitxt.setEnabled(false);
         telefonotxt.setEnabled(false);
        
    }
    public void desactivaragregar(){
        agregar.setEnabled(false);
    }
    public void activaragregar(){
        agregar.setEnabled(true);
    }
    public void desactivarcargar(){
        cargar.setEnabled(false);
    }
        
      public void activarcargar(){
        cargar.setEnabled(true);
    }
    
     public void activareliminar(){
         eliminar.setEnabled(true);
     }
     public void desactivareliminar(){
         eliminar.setEnabled(false);
     }
    public void activarhabilitado(){
        habilitar.setEnabled(true);
    }
    public void desactivarhabilitado(){
        habilitar.setEnabled(false);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new FondoPanel2();
        jPanel2 = new FondoPanel2();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nombretxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dnitxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        telefonotxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        apellidotxt = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        buscar = new javax.swing.JLabel();
        txtNombreBuscador = new javax.swing.JTextField();
        modificar = new javax.swing.JLabel();
        guardar = new javax.swing.JLabel();
        cancelar = new javax.swing.JLabel();
        cargar = new javax.swing.JLabel();
        agregar = new javax.swing.JLabel();
        eliminar = new javax.swing.JLabel();
        inactivo = new javax.swing.JCheckBox();
        habilitar = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTutor = new javax.swing.JTable();
        cod = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 102, 102));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(1000, 70));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registrar Tutor");

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/agregar.png"))); // NOI18N

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
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addGap(21, 21, 21))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel14)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));

        jLabel2.setBackground(new java.awt.Color(255, 102, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre:");

        jLabel4.setBackground(new java.awt.Color(255, 102, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Apellido:");

        nombretxt.setBackground(new java.awt.Color(255, 204, 204));
        nombretxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nombretxt.setForeground(new java.awt.Color(255, 51, 102));
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

        jLabel7.setBackground(new java.awt.Color(255, 204, 204));
        jLabel7.setForeground(new java.awt.Color(255, 102, 51));
        jLabel7.setText("*******************************************************");

        jLabel3.setBackground(new java.awt.Color(255, 102, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("DNI:");

        jLabel8.setBackground(new java.awt.Color(255, 204, 204));
        jLabel8.setForeground(new java.awt.Color(255, 102, 51));
        jLabel8.setText("*******************************************************");

        dnitxt.setBackground(new java.awt.Color(255, 204, 204));
        dnitxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dnitxt.setForeground(new java.awt.Color(255, 51, 102));
        dnitxt.setBorder(null);
        dnitxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dnitxtKeyTyped(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 204, 204));
        jLabel9.setForeground(new java.awt.Color(255, 102, 51));
        jLabel9.setText("******************************************************");

        jLabel5.setBackground(new java.awt.Color(255, 102, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Telefono:");

        telefonotxt.setBackground(new java.awt.Color(255, 204, 204));
        telefonotxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        telefonotxt.setForeground(new java.awt.Color(255, 51, 102));
        telefonotxt.setBorder(null);
        telefonotxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                telefonotxtKeyTyped(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(255, 204, 204));
        jLabel11.setForeground(new java.awt.Color(255, 102, 51));
        jLabel11.setText("******************************************************");

        apellidotxt.setBackground(new java.awt.Color(255, 204, 204));
        apellidotxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        apellidotxt.setForeground(new java.awt.Color(255, 51, 102));
        apellidotxt.setBorder(null);
        apellidotxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apellidotxtKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(apellidotxt)
                        .addGap(429, 429, 429))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(234, 234, 234))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dnitxt)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(305, 305, 305))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombretxt)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(telefonotxt)
                                .addGap(25, 25, 25)))
                        .addGap(65, 65, 65))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombretxt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(telefonotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(apellidotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jLabel8)
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dnitxt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 102, 102));

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/Buscar_1.png"))); // NOI18N
        buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarMouseClicked(evt);
            }
        });

        txtNombreBuscador.setBackground(new java.awt.Color(255, 204, 204));
        txtNombreBuscador.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNombreBuscador.setForeground(new java.awt.Color(0, 0, 0));
        txtNombreBuscador.setBorder(null);
        txtNombreBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreBuscadorActionPerformed(evt);
            }
        });
        txtNombreBuscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreBuscadorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreBuscadorKeyTyped(evt);
            }
        });

        modificar.setFont(new java.awt.Font("Segoe Print", 1, 10)); // NOI18N
        modificar.setForeground(new java.awt.Color(255, 255, 255));
        modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/m.png"))); // NOI18N
        modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modificarMouseClicked(evt);
            }
        });

        guardar.setFont(new java.awt.Font("Segoe Print", 1, 10)); // NOI18N
        guardar.setForeground(new java.awt.Color(255, 255, 255));
        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/g.png"))); // NOI18N
        guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                guardarMouseEntered(evt);
            }
        });

        cancelar.setFont(new java.awt.Font("Segoe Print", 1, 10)); // NOI18N
        cancelar.setForeground(new java.awt.Color(255, 255, 255));
        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/c.png"))); // NOI18N
        cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelarMouseClicked(evt);
            }
        });

        cargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recargar.png"))); // NOI18N
        cargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cargarMouseClicked(evt);
            }
        });

        agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        agregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregarMouseClicked(evt);
            }
        });

        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/e.png"))); // NOI18N
        eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarMouseClicked(evt);
            }
        });

        inactivo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inactivo.setForeground(new java.awt.Color(255, 255, 255));
        inactivo.setText("Inactivo");
        inactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inactivoActionPerformed(evt);
            }
        });

        habilitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/activo1.png"))); // NOI18N
        habilitar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                habilitarMouseClicked(evt);
            }
        });

        jButton1.setText("GENERAR REPORTE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombreBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(agregar)
                .addGap(89, 89, 89)
                .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(modificar)
                .addGap(85, 85, 85)
                .addComponent(eliminar)
                .addGap(57, 57, 57)
                .addComponent(habilitar)
                .addGap(50, 50, 50)
                .addComponent(inactivo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(cancelar)
                .addGap(92, 92, 92)
                .addComponent(jButton1)
                .addGap(21, 21, 21))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buscar)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(txtNombreBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cancelar)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(eliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(habilitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(inactivo)
                .addGap(23, 23, 23))
        );

        tablaTutor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "DNI", "Telefono", "Estado"
            }
        ));
        tablaTutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaTutorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaTutor);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1609, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(cod)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addGap(28, 28, 28))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(cod))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        add(jPanel1, "modificarT");
    }// </editor-fold>//GEN-END:initComponents

    private void nombretxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombretxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombretxtActionPerformed

    private void txtNombreBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreBuscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreBuscadorActionPerformed

    private void cargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargarMouseClicked
        desactivarhabilitado();        
        txtNombreBuscador.setText("");
        mostrarT();
    }//GEN-LAST:event_cargarMouseClicked

    private void guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarMouseClicked
       try{
            //  Validación de campos vacios
        if (nombretxt.getText().isEmpty() || apellidotxt.getText().isEmpty() || dnitxt.getText().isEmpty() || telefonotxt.getText().isEmpty()   ) {
            JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Detiene la ejecución del método
        }
        int dni= Integer.parseInt(dnitxt.getText());
         String nombre1= nombretxt.getText();
         String apellido1=apellidotxt.getText();
         String telefono1= telefonotxt.getText(); 
         String p= cod.getText();
         
        
                  /// si p, que es el codig del tutor, esa lleno, quiere decir que hizo click en la tabla y al hacer eso se guardo en un label e codigo del profesor al que le haya echo click, por lo tanto es una actualizacion
               if(!p.isEmpty()){
                 
                 Clases.Tutor.modificarTutor(cx, nombre1, apellido1, dni, telefono1, Integer.parseInt(p));
                   JOptionPane.showMessageDialog(null, "Los datos se actualizaron correctamente"); 
                 
                   limpiar();
                  mostrarT();
                  desactivarguardar();
                  activaragregar();
                  desactivarcampo();
                 
             }
             else{ ///sino, quiere decir que el codigo del tutor,esta vacio, por lo tanto no hizo click en la tabla, es una carga
                  Clases.Tutor.cargar(cx, nombre1, apellido1, dni, telefono1);
                  JOptionPane.showMessageDialog(null, "Los datos se guardaron correctamente"); 
                  limpiar();
                   mostrarT();
                    desactivarguardar();
                  activaragregar();
                  desactivarcampo();
                  
             }
            
         }catch(Exception e){
             JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar cargar o actualizar los datos","ERROR",ERROR_MESSAGE); 
         }
          
        
    }//GEN-LAST:event_guardarMouseClicked

    private void tablaTutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTutorMouseClicked
         
        if(inactivo.isSelected()){
            try{
                  int filaSeleccionada = tablaTutor.getSelectedRow();
                  String dni =tablaTutor.getValueAt(filaSeleccionada, 2).toString();
                  int codigo= Clases.Tutor.buscarCodigo(cx, Integer.parseInt(dni));
                  cod.setText(String.valueOf(codigo));
                  String estado=tablaTutor.getValueAt(filaSeleccionada, 4).toString();
                  if(estado.equalsIgnoreCase("INACTIVO")){
                     activarHabilitar();
                     desactivaragregar();
                  }
            }catch(Exception e){
                
            }
             
               desactivareliminar();
               desactivarmodificar();     
          
               
            
            
            
        } else{
                       
        desactivarHabilitar();
       
        try{
            int filaSeleccionada = tablaTutor.getSelectedRow();
            
            String nombre =tablaTutor.getValueAt(filaSeleccionada, 0).toString();
            String apellido =tablaTutor.getValueAt(filaSeleccionada, 1).toString();
            String dni =tablaTutor.getValueAt(filaSeleccionada, 2).toString();
            String telefono=tablaTutor.getValueAt(filaSeleccionada, 3).toString();
           
          
            try{
               int codigo= Clases.Tutor.buscarCodigo(cx, Integer.parseInt(dni));
                cod.setText(String.valueOf(codigo));
                
            }catch(Exception e){
               JOptionPane.showMessageDialog(null, "Error al obtener el código");   
            }
            nombretxt.setText(nombre);
            apellidotxt.setText(apellido);
            dnitxt.setText(dni);
            telefonotxt.setText(telefono);
           activarmodificar();
            desactivarguardar();
            desactivarcampo();
            desactivaragregar();
            activareliminar();
     
       }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No hay datos en la tabla","ERROR",ERROR_MESSAGE);
       }
        }
    }//GEN-LAST:event_tablaTutorMouseClicked

    private void buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarMouseClicked
      desactivarhabilitado();         
      
       tabla.setRowCount(0);   
         tabla.setColumnCount(0);
        
         tabla.addColumn("Nombre");  
         tabla.addColumn("Apellido");  
         tabla.addColumn("DNI"); 
         tabla.addColumn("Telefono"); 
          tabla.addColumn("Estado");  
         
        try{
             rs=Clases.Tutor.buscarTutor(cx, txtNombreBuscador.getText());
         while(rs.next()){
                  
                   datos[0]=rs.getString("nombre");
                   datos[1]=rs.getString("apellido");
                   datos[2]=rs.getString("dni");
                   datos[3]=rs.getString("telefono");
                   datos[4]=rs.getString("borrado");
                  
                    if( datos[4].equals("0")){
                        datos[4]="ACTIVO";
                   }else{
                        datos[4]="INACTIVO";
                   }
                  
                  
                   tabla.addRow(datos);
                   tablaTutor.setModel(tabla);
                   
          }
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al buscar al profesor","ERROR",ERROR_MESSAGE);
              mostrarT();
        }
          
    }//GEN-LAST:event_buscarMouseClicked

    private void cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarMouseClicked
        desactivarHabilitar();
        desactivarguardar();
        desactivarmodificar();
        desactivarcampo();
        activaragregar();
        desactivareliminar();
        limpiar();
   
        
        
        
    }//GEN-LAST:event_cancelarMouseClicked

    private void agregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarMouseClicked
       activarcampo();
       activarguardar();
       desactivaragregar();
       desactivarmodificar();
       desactivareliminar();
               
    }//GEN-LAST:event_agregarMouseClicked

    private void modificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificarMouseClicked
         activarcampo();
        desactivarmodificar();
        activarguardar();
        desactivareliminar();
        desactivaragregar();
    }//GEN-LAST:event_modificarMouseClicked

    private void inactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inactivoActionPerformed
        
         if (inactivo.isSelected()){
           desactivareliminar();
           desactivarmodificar();
              tabla.setRowCount(0);   
         tabla.setColumnCount(0);
         tabla.addColumn("Nombre");  
         tabla.addColumn("Apellido");  
         tabla.addColumn("DNI"); 
         tabla.addColumn("Telefono"); 
         tabla.addColumn("Estado"); 
         
         
         try{
            
             rs=Clases.Tutor.mostrartutoresinactivos(cx);
              while(rs.next()){
                   datos[0]=rs.getString("nombre");
                   datos[1]=rs.getString("apellido");
                   datos[2]=rs.getString("dni");
                   datos[3]=rs.getString("telefono");
                   datos[4]=rs.getString("borrado");
                  
                    if( datos[4].equals("0")){
                        datos[4]="ACTIVO";
                   }else{
                        datos[4]="INACTIVO";
                   }
                
                  
                   tabla.addRow(datos);
                   tablaTutor.setModel(tabla);
                   
              } 
              
          }catch(Exception e){
                   JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar los Profesores en la tabla","ERROR",ERROR_MESSAGE); 
          }
            
            
        }
        else{
             desactivarhabilitado();
           mostrarT();
           
        } 
          
    }//GEN-LAST:event_inactivoActionPerformed

    private void eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarMouseClicked
          int codigo=Integer.parseInt(cod.getText());
       
       int n= JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro seleccionado?","Eliminación", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE); 
       if(n==JOptionPane.YES_NO_OPTION){
           
           try{
               Clases.Tutor.eliminar(cx, codigo);
               JOptionPane.showMessageDialog(null, "Se ha eliminado el registro correctamente");
                 mostrarT();
                 
                 limpiar();
      

              
             }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se ha podido eliminar el registro seleccionado","ERROR",ERROR_MESSAGE); 
              mostrarT();
                 
                 limpiar();
            
             }
           
           
       }else{
           JOptionPane.showMessageDialog(null, "Se ha cancelado la eliminación"); 
           mostrarT();
               
                 limpiar();
       }
    }//GEN-LAST:event_eliminarMouseClicked

    private void habilitarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_habilitarMouseClicked
       
          
       
       int n= JOptionPane.showConfirmDialog(null, "¿Desea habilitar el registro seleccionado?","Habilitar", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE); 
       if(n==JOptionPane.YES_NO_OPTION){
           
           try{
               Clases.Tutor.habilitarT(cx, Integer.parseInt(cod.getText()));
               JOptionPane.showMessageDialog(null, "Se ha habilitado el registro correctamente");
                inhabilitado();
                desactivarHabilitar();
                limpiar();
                activaragregar();
      

              
             }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se ha podido habilitar el registro seleccionado","ERROR",ERROR_MESSAGE); 
                inhabilitado();
                desactivarHabilitar();
                limpiar();
                activaragregar();
            
             }
           
           
       }else{
           JOptionPane.showMessageDialog(null, "Se ha cancelado "); 
          inhabilitado();
                desactivarHabilitar();
                limpiar();
                activaragregar();
       }
         
    }//GEN-LAST:event_habilitarMouseClicked

    private void nombretxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombretxtKeyTyped
          char c=evt.getKeyChar();
         // verificar si el carácter ingresado es unicamente letra
      if ((!Character.isLetter(c) && c != ' ')|| nombretxt.getText().length()>20) {
        evt.consume(); 
    }  
    }//GEN-LAST:event_nombretxtKeyTyped

    private void dnitxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dnitxtKeyTyped
          char c=evt.getKeyChar();
         // verificar si el carácter ingresado es unicamente numeros
      if (!Character.isDigit(c) || dnitxt.getText().length()>8) {
        evt.consume(); 
    }  
    }//GEN-LAST:event_dnitxtKeyTyped

    private void telefonotxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_telefonotxtKeyTyped
          char c=evt.getKeyChar();
         // verificar si el carácter ingresado es unicamente numeros
      if (!Character.isDigit(c) || telefonotxt.getText().length()>10) {
        evt.consume(); 
    }  
    }//GEN-LAST:event_telefonotxtKeyTyped

    private void apellidotxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellidotxtKeyTyped
            char c=evt.getKeyChar();
         // verificar si el carácter ingresado es unicamente letra
      if ((!Character.isLetter(c) && c != ' ') || apellidotxt.getText().length()>20) {
        evt.consume(); 
    }  
    }//GEN-LAST:event_apellidotxtKeyTyped

    private void txtNombreBuscadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreBuscadorKeyTyped
             char c=evt.getKeyChar();
         // verificar si el carácter ingresado es unicamente letra
      if ((!Character.isLetter(c) && c != ' ')|| txtNombreBuscador.getText().length()>20) {
        evt.consume(); 
    }  
    }//GEN-LAST:event_txtNombreBuscadorKeyTyped

    private void txtNombreBuscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreBuscadorKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreBuscadorKeyReleased

    private void guardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_guardarMouseEntered

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  try {
               //  Ruta donde se guardará el PDF (en el Escritorio del usuario)
               String ruta = System.getProperty("user.home") + "\\Downloads\\REPORTES\\TUTOR\\reporteTutores.pdf";


               // Crear el documento en formato A4 horizontal (más ancho para las tablas)
               Document documento = new Document(PageSize.A4.rotate());

               // Asociar el documento con un "escritor" que lo guardará en la ruta indicada
               PdfWriter.getInstance(documento, new FileOutputStream(ruta));

               // Abrir el documento para comenzar a escribir contenido en él
               documento.open();

   
               //ENCABEZADO DEL DOCUMENTO
               // Título centrado y en negrita
               Paragraph titulo = new Paragraph("Reporte de Tutores Activos",
               FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));
               titulo.setAlignment(Element.ALIGN_CENTER);
               documento.add(titulo);

               //  Subtítulo e información adicional
               documento.add(new Paragraph("Instituto Pedagógico Despertando Sueños"));
               documento.add(new Paragraph("Fecha: " + LocalDate.now()));
               documento.add(new Paragraph("\nListado de tutores activos:\n"));

   
               //  CREACIÓN DE LA TABLA PDF
               // Crear una tabla con 11 columnas
               PdfPTable tablaPDF = new PdfPTable(5);
               tablaPDF.setWidthPercentage(100);   // Ocupa el ancho total de la página
               tablaPDF.setSpacingBefore(10f);     // Espacio antes de la tabla
               tablaPDF.setSpacingAfter(10f);      // Espacio después de la tabla

               // Nombres de las columnas
               String[] columnas = {
                  "Nombre Tutor", "Apellido Tutor", "DNI Tutor", "Teléfono", "Estado"
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
                           // Se llama al método del modelo que devuelve los tutores activos
                           rs = Clases.Tutor.mostrartutoresactivos(cx);

                           // Se recorre cada fila del ResultSet y se agregan las celdas a la tabla
                          while (rs.next()) {
                            tablaPDF.addCell(new Phrase(rs.getString("nombre"), fontData));          // 1
                            tablaPDF.addCell(new Phrase(rs.getString("apellido"), fontData));          // 2
                            tablaPDF.addCell(new Phrase(rs.getString("dni"), fontData));          // 3
                            tablaPDF.addCell(new Phrase(rs.getString("telefono"), fontData));          // 4
                            int estado=rs.getInt("borrado");
                            if(estado==0){
                                 tablaPDF.addCell(new Phrase("ACTIVO", fontData));        // 5
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel agregar;
    private javax.swing.JTextField apellidotxt;
    private javax.swing.JLabel buscar;
    private javax.swing.JLabel cancelar;
    private javax.swing.JLabel cargar;
    private javax.swing.JLabel cod;
    private javax.swing.JTextField dnitxt;
    private javax.swing.JLabel eliminar;
    private javax.swing.JLabel guardar;
    private javax.swing.JLabel habilitar;
    private javax.swing.JCheckBox inactivo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel modificar;
    private javax.swing.JTextField nombretxt;
    private javax.swing.JTable tablaTutor;
    private javax.swing.JTextField telefonotxt;
    private javax.swing.JTextField txtNombreBuscador;
    // End of variables declaration//GEN-END:variables
}
