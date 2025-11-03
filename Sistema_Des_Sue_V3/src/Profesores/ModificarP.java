
package Profesores;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mahu
 */
public class ModificarP extends javax.swing.JPanel {

    FondoPanel2 fn= new FondoPanel2();
    FondoPanel f=new FondoPanel();
     DefaultTableModel tabla=new DefaultTableModel();
     Object[] datos=new Object[5];
      ResultSet rs;
      Statement st;
     Connection cx=Conexion.conexion.conexion();
    
    
    
    
    public ModificarP() {
        initComponents();
        mostrarP();
        desactivarguardar();
        desactivarmodificar();
        desactivarcampo();
        desactivarcargar();
        desactivarbuscar();
        desactivareliminar();
        desactivarhabilitar();
        
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
        public void paint(Graphics g){
            imagen= new ImageIcon(getClass().getResource("/Imagenes2/2.jpg")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
            
    
    }
        public class FondoPanel extends JPanel {
    
    private Image imagen;
        public void paint(Graphics g){
            imagen= new ImageIcon(getClass().getResource("/Imagenes/t.png")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
            
    
    }
        
        
        
        
     public void mostrarP(){
         tabla.setRowCount(0);   
         tabla.setColumnCount(0);
        
         tabla.addColumn("Nombre");  
         tabla.addColumn("Apellido");  
         tabla.addColumn("DNI"); 
         tabla.addColumn("Residencia"); 
         tabla.addColumn("Titulo");
      
         
         try{
            
             rs=Clases.Profesor.mostrarprofesoresactivos(cx);
              while(rs.next()){
                   datos[0]=rs.getString("nombre");
                   datos[1]=rs.getString("apellido");
                   datos[2]=rs.getString("dni");
                   datos[3]=rs.getString("residencia");
                   datos[4]=rs.getString("titulo");
                   
                 
                  
                   tabla.addRow(datos);
                   tablaProfesor.setModel(tabla);
                   
              } 
              
          }catch(Exception e){
                   JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar los Profesores en la tabla","ERROR",ERROR_MESSAGE); 
          }
    }
     public void inhabilitado(){
         
          tabla.setRowCount(0);   
         tabla.setColumnCount(0);
        
         tabla.addColumn("Nombre");  
         tabla.addColumn("Apellido");  
         tabla.addColumn("DNI"); 
         tabla.addColumn("Residencia"); 
         tabla.addColumn("Titulo");
      
         
         try{
            
             rs=Clases.Profesor.mostrarprofesoresinactivos(cx);
              while(rs.next()){
                   datos[0]=rs.getString("nombre");
                   datos[1]=rs.getString("apellido");
                   datos[2]=rs.getString("dni");
                   datos[3]=rs.getString("residencia");
                   datos[4]=rs.getString("titulo");
                   
                 
                  
                   tabla.addRow(datos);
                   tablaProfesor.setModel(tabla);
                   
              } 
              
          }catch(Exception e){
                   JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar los Profesores en la tabla","ERROR",ERROR_MESSAGE); 
          }
         
         
         
         
         
         
     }
          
     public void limpiar(){
         
         nombretxt.setText("");
         apellidotxt.setText("");
         dnitxt.setText("");
         residenciatxt.setText("");
         titulotxt.setText("");
         prueba.setText("");
         desactivarguardar();
         desactivarmodificar();
         desactivareliminar();
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
         residenciatxt.setEnabled(true);
         titulotxt.setEnabled(true);
    }
    public void desactivarcampo(){
         nombretxt.setEnabled(false);
         apellidotxt.setEnabled(false);
         dnitxt.setEnabled(false);
         residenciatxt.setEnabled(false);
         titulotxt.setEnabled(false);
    }
    public void desactivaragregar(){
        agregar.setEnabled(false);
    }
    public void activaragregar(){
        agregar.setEnabled(true);
    }
    public void activarcargar(){
        cargar.setEnabled(true);
    }
    public void desactivarcargar(){
        cargar.setEnabled(false);
    }
        
       public void activareliminar(){
         eliminar.setEnabled(true);
     }
     public void desactivareliminar(){
         eliminar.setEnabled(false);
     }   
        
     public void activarhabilitar(){
         Habilitar.setEnabled(true);
     }   
     public void desactivarhabilitar(){
         Habilitar.setEnabled(false);
     }
        
        
        
        
        
                     
 public int getCantidadDocentes() {
    return tablaProfesor.getRowCount(); // Devuelve la cantidad de filas de la tabla
}
   
        
        
        
        
        
        
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new FondoPanel2();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nombretxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        apellidotxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dnitxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        titulotxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        residenciatxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProfesor = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        txtNombreBuscador = new javax.swing.JTextField();
        Cancelar = new javax.swing.JLabel();
        modificar = new javax.swing.JLabel();
        guardar = new javax.swing.JLabel();
        prueba = new javax.swing.JLabel();
        agregar = new javax.swing.JLabel();
        buscar = new javax.swing.JLabel();
        cargar = new javax.swing.JLabel();
        eliminar = new javax.swing.JLabel();
        Inactivo = new javax.swing.JCheckBox();
        Habilitar = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(100, 90));
        jPanel2.setPreferredSize(new java.awt.Dimension(598, 525));

        jPanel4.setBackground(new java.awt.Color(255, 204, 204));
        jPanel4.setPreferredSize(new java.awt.Dimension(650, 300));

        jPanel6.setBackground(new java.awt.Color(255, 102, 102));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(1000, 70));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Registrar Profesor");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/agregar.png"))); // NOI18N

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/soll.gif"))); // NOI18N
        jLabel21.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("E. P. Despertado Sueños ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel2.setBackground(new java.awt.Color(255, 102, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre:");

        jLabel7.setBackground(new java.awt.Color(255, 102, 51));
        jLabel7.setForeground(new java.awt.Color(255, 102, 51));
        jLabel7.setText("*******************************************************");

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

        jLabel4.setBackground(new java.awt.Color(255, 102, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Apellido:");

        apellidotxt.setBackground(new java.awt.Color(255, 204, 204));
        apellidotxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        apellidotxt.setForeground(new java.awt.Color(255, 51, 102));
        apellidotxt.setBorder(null);
        apellidotxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apellidotxtKeyTyped(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 102, 51));
        jLabel8.setForeground(new java.awt.Color(255, 102, 51));
        jLabel8.setText("    *******************************************************");

        jLabel3.setBackground(new java.awt.Color(255, 102, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("DNI:");

        dnitxt.setBackground(new java.awt.Color(255, 204, 204));
        dnitxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dnitxt.setForeground(new java.awt.Color(255, 51, 102));
        dnitxt.setBorder(null);
        dnitxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dnitxtKeyTyped(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 102, 51));
        jLabel9.setForeground(new java.awt.Color(255, 102, 51));
        jLabel9.setText("    *****************************************************");

        jLabel5.setBackground(new java.awt.Color(255, 102, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Titulo:");

        titulotxt.setBackground(new java.awt.Color(255, 204, 204));
        titulotxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        titulotxt.setForeground(new java.awt.Color(255, 51, 102));
        titulotxt.setBorder(null);
        titulotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titulotxtActionPerformed(evt);
            }
        });
        titulotxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                titulotxtKeyTyped(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(255, 102, 51));
        jLabel11.setForeground(new java.awt.Color(255, 102, 51));
        jLabel11.setText("************************************************************");

        jLabel6.setBackground(new java.awt.Color(255, 102, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Residencia:");

        residenciatxt.setBackground(new java.awt.Color(255, 204, 204));
        residenciatxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        residenciatxt.setForeground(new java.awt.Color(255, 51, 102));
        residenciatxt.setBorder(null);
        residenciatxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                residenciatxtActionPerformed(evt);
            }
        });
        residenciatxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                residenciatxtKeyTyped(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 102, 51));
        jLabel10.setForeground(new java.awt.Color(255, 102, 51));
        jLabel10.setText("************************************************************");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(116, 116, 116)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(3, 3, 3))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(nombretxt)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel6)
                                .addGap(11, 11, 11)
                                .addComponent(residenciatxt)
                                .addGap(20, 20, 20))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(13, 13, 13)
                                .addComponent(apellidotxt)
                                .addGap(32, 32, 32))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dnitxt)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(20, 20, 20))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(28, 28, 28)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel5)
                                .addGap(11, 11, 11)
                                .addComponent(titulotxt)
                                .addGap(10, 10, 10))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(47, 47, 47))
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 1385, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(nombretxt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6)
                    .addComponent(residenciatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel7))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(apellidotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(jLabel5)
                    .addComponent(titulotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dnitxt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        tablaProfesor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "DNI", "Residencia", "Titulo"
            }
        ));
        tablaProfesor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProfesorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaProfesor);

        jPanel5.setBackground(new java.awt.Color(255, 102, 102));

        txtNombreBuscador.setBackground(new java.awt.Color(255, 153, 153));
        txtNombreBuscador.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNombreBuscador.setForeground(new java.awt.Color(0, 0, 0));
        txtNombreBuscador.setBorder(null);
        txtNombreBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreBuscadorActionPerformed(evt);
            }
        });
        txtNombreBuscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreBuscadorKeyTyped(evt);
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
        });

        prueba.setForeground(new java.awt.Color(0, 0, 0));
        prueba.setLabelFor(apellidotxt);

        agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        agregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregarMouseClicked(evt);
            }
        });

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/Buscar_1.png"))); // NOI18N
        buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarMouseClicked(evt);
            }
        });

        cargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recargar.png"))); // NOI18N
        cargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cargarMouseClicked(evt);
            }
        });

        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/e.png"))); // NOI18N
        eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarMouseClicked(evt);
            }
        });

        Inactivo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Inactivo.setForeground(new java.awt.Color(255, 255, 255));
        Inactivo.setText("Inactivo");
        Inactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InactivoActionPerformed(evt);
            }
        });

        Habilitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/activo1.png"))); // NOI18N
        Habilitar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HabilitarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(prueba, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombreBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Habilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Inactivo, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cancelar))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buscar))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(modificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cargar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGap(16, 16, 16)
                                    .addComponent(txtNombreBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(eliminar, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addComponent(Inactivo))
                                .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Habilitar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(prueba, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1385, Short.MAX_VALUE)
                .addGap(2, 2, 2))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        add(jPanel1, "modificarP");
    }// </editor-fold>//GEN-END:initComponents

    private void nombretxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombretxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombretxtActionPerformed

    private void titulotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titulotxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titulotxtActionPerformed

    private void residenciatxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_residenciatxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_residenciatxtActionPerformed

    private void buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarMouseClicked
desactivarhabilitar();      
       
        
       tabla.setRowCount(0);   
         tabla.setColumnCount(0);
         tabla.addColumn("Nombre");  
         tabla.addColumn("Apellido");  
         tabla.addColumn("DNI"); 
         tabla.addColumn("Residencia"); 
         tabla.addColumn("Titulo");
        try{
         rs=Clases.Profesor.buscarProfesor(cx, txtNombreBuscador.getText());
         while(rs.next()){
                   datos[0]=rs.getString("nombre");
                   datos[1]=rs.getString("apellido");
                   datos[2]=rs.getString("dni");
                   datos[3]=rs.getString("residencia");
                   datos[4]=rs.getString("titulo");
                  
                  
                   tabla.addRow(datos);
                   tablaProfesor.setModel(tabla);
                   
         }
                
              
             
    }catch(Exception e){
          
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al buscar al Profesor","ERROR",ERROR_MESSAGE);
            mostrarP();
       }
        
     
      
     
     
     
     
     
     
     
     
     
     
    }//GEN-LAST:event_buscarMouseClicked

    private void tablaProfesorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProfesorMouseClicked
        int filaSeleccionada = tablaProfesor.getSelectedRow();
            
            String nombre =tablaProfesor.getValueAt(filaSeleccionada, 0).toString();
            String apellido =tablaProfesor.getValueAt(filaSeleccionada, 1).toString();
            String dni =tablaProfesor.getValueAt(filaSeleccionada, 2).toString();
            String residencia=tablaProfesor.getValueAt(filaSeleccionada, 3).toString();
            String titulo =tablaProfesor.getValueAt(filaSeleccionada, 4).toString();
        try{    
              int codigo= Clases.Profesor.buscarCodigo(cx, Integer.parseInt(dni));
              prueba.setText(String.valueOf(codigo));   //pone el codigo del profesor en el label prueba
            if (Inactivo.isSelected()){
              desactivareliminar();
              desactivarmodificar();
              activarhabilitar();
            }else{
        
        
        
      
           
          
       
              
           
                nombretxt.setText(nombre);
                apellidotxt.setText(apellido);
                dnitxt.setText(dni);
               residenciatxt.setText(residencia);
               titulotxt.setText(titulo);
               activarmodificar();
               desactivarguardar();
               desactivarcampo();
               desactivaragregar();
               activareliminar();
            
     
       
             }
      }catch(Exception e){
                
                }
    }//GEN-LAST:event_tablaProfesorMouseClicked

    private void guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarMouseClicked
        
      
      
         try{
             
             //validar campos vacios..
             if(nombretxt.getText().isEmpty() || apellidotxt.getText().isEmpty() || dnitxt.getText().isEmpty() || residenciatxt.getText().isEmpty() || titulotxt.getText().isEmpty()){
                   JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                  return; // Detiene la ejecución del método
             }
              int dni= Integer.parseInt(dnitxt.getText());
             String nombre1= nombretxt.getText();
             String apellido1=apellidotxt.getText();
             String residencia1= residenciatxt.getText();
             String titulo1=titulotxt.getText();
             String codigoProfesor= prueba.getText();
             if(!codigoProfesor.isEmpty()){
                 
               Clases.Profesor.modificarProfe(cx, nombre1, apellido1, dni, residencia1, titulo1,Integer.parseInt(codigoProfesor));
                   JOptionPane.showMessageDialog(null, "Los datos se actualizaron correctamente"); 
                   limpiar();
                   mostrarP();
                   
                  
             }else{
                  
                   
                     Clases.Profesor.cargar(cx, nombre1, apellido1, dni, residencia1, titulo1);
                  JOptionPane.showMessageDialog(null, "Los datos se guardaron correctamente"); 
                  mostrarP();
                  limpiar();
                  desactivarcampo();
             }
           
           
             
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar cargar o actualizar los datos","ERROR",ERROR_MESSAGE);  
          

        }
       limpiar();
    }//GEN-LAST:event_guardarMouseClicked

    private void CancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelarMouseClicked
        
        desactivarcampo();
        
        limpiar();
    }//GEN-LAST:event_CancelarMouseClicked

    private void agregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarMouseClicked
       activarcampo();
       activarguardar();
       desactivaragregar();
       
       
    }//GEN-LAST:event_agregarMouseClicked

    private void modificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificarMouseClicked
       
        activarcampo();
        desactivarmodificar();
        desactivareliminar();
        desactivaragregar();
        activarguardar();
    }//GEN-LAST:event_modificarMouseClicked

    private void cargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargarMouseClicked
        mostrarP();
         txtNombreBuscador.setText("");
         desactivarhabilitar();
    }//GEN-LAST:event_cargarMouseClicked

    private void InactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InactivoActionPerformed
      
          if (Inactivo.isSelected()){
        
          
              tabla.setRowCount(0);   
         tabla.setColumnCount(0);
         tabla.addColumn("Nombre");  
         tabla.addColumn("Apellido");  
         tabla.addColumn("DNI"); 
         tabla.addColumn("Residencia"); 
         tabla.addColumn("Titulo");
      
         
         try{
            
             rs=Clases.Profesor.mostrarprofesoresinactivos(cx);
              while(rs.next()){
                   datos[0]=rs.getString("nombre");
                   datos[1]=rs.getString("apellido");
                   datos[2]=rs.getString("dni");
                   datos[3]=rs.getString("residencia");
                   datos[4]=rs.getString("titulo");
                 
                  
                   tabla.addRow(datos);
                   tablaProfesor.setModel(tabla);
                   
              } 
              
          }catch(Exception e){
                   JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar los Profesores en la tabla","ERROR",ERROR_MESSAGE); 
          }
            
        }else {
              desactivarhabilitar();
           mostrarP();
          }
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_InactivoActionPerformed

    private void eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarMouseClicked
          int codigo=Integer.parseInt(prueba.getText());
       
       int n= JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro seleccionado?","Eliminación", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE); 
       if(n==JOptionPane.YES_NO_OPTION){
           
           try{
               Clases.Profesor.eliminar(cx, codigo);
               JOptionPane.showMessageDialog(null, "Se ha eliminado el registro correctamente");
               limpiar();
              mostrarP();

              
             }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se ha podido eliminar el registro seleccionado","ERROR",ERROR_MESSAGE); 
            limpiar();
             }
           
           
       }else{
           JOptionPane.showMessageDialog(null, "Se ha cancelado la eliminación"); 
            mostrarP();
            limpiar();
       }
       
    }//GEN-LAST:event_eliminarMouseClicked

    private void HabilitarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HabilitarMouseClicked
       
         
       
       int n= JOptionPane.showConfirmDialog(null, "¿Desea habilitar el registro seleccionado?","Habilitar", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE); 
       if(n==JOptionPane.YES_NO_OPTION){
           
           try{
                int codigo=Integer.parseInt(prueba.getText());
               Clases.Profesor.habilitarP(cx, codigo);
               JOptionPane.showMessageDialog(null, "Se ha habilitado el registro correctamente");
                desactivarhabilitar();
              inhabilitado();

              
             }catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se ha podido habiliar el registro seleccionado","ERROR",ERROR_MESSAGE); 
             desactivarhabilitar();
             }
           
           
       }else{
           JOptionPane.showMessageDialog(null, "Se ha cancelado "); 
            inhabilitado();
            desactivarhabilitar();
       }
        
        
        
        
        
        
        
    }//GEN-LAST:event_HabilitarMouseClicked

    private void txtNombreBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreBuscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreBuscadorActionPerformed

    private void nombretxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombretxtKeyTyped
         char c=evt.getKeyChar();
         // verificar si el carácter ingresado es unicamente letra
      if ((!Character.isLetter(c) && c != ' ') || nombretxt.getText().length()>20) {
        evt.consume(); 
    }  
    }//GEN-LAST:event_nombretxtKeyTyped

    private void apellidotxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellidotxtKeyTyped
        char c=evt.getKeyChar();
         // verificar si el carácter ingresado es unicamente letra
      if ((!Character.isLetter(c) && c != ' ') || apellidotxt.getText().length()>20) {
        evt.consume(); 
    }  
    }//GEN-LAST:event_apellidotxtKeyTyped

    private void dnitxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dnitxtKeyTyped
         char c=evt.getKeyChar();
         // verificar si el carácter ingresado es unicamente numeros
      if (!Character.isDigit(c) || dnitxt.getText().length()>8) {
        evt.consume(); 
    }  
    }//GEN-LAST:event_dnitxtKeyTyped

    private void residenciatxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_residenciatxtKeyTyped
        char c=evt.getKeyChar();
         // verificar si el carácter ingresado es unicamente letra y numeros
      if ((!Character.isLetter(c) &&  !Character.isDigit(c) && c != ' ') || apellidotxt.getText().length()>20) {
        evt.consume(); 
    }  
    }//GEN-LAST:event_residenciatxtKeyTyped

    private void titulotxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_titulotxtKeyTyped
          char c=evt.getKeyChar();
         // verificar si el carácter ingresado es unicamente letra
      if ((!Character.isLetter(c) && c != ' ') || titulotxt.getText().length()>20) {
        evt.consume(); 
    }  
    }//GEN-LAST:event_titulotxtKeyTyped

    private void txtNombreBuscadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreBuscadorKeyTyped
            char c=evt.getKeyChar();
         // verificar si el carácter ingresado es unicamente letra
      if ((!Character.isLetter(c)  && c != ' ')|| txtNombreBuscador.getText().length()>20) {
        evt.consume(); 
    }  
    }//GEN-LAST:event_txtNombreBuscadorKeyTyped

    
    
    
    
    
    
    
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cancelar;
    private javax.swing.JLabel Habilitar;
    private javax.swing.JCheckBox Inactivo;
    private javax.swing.JLabel agregar;
    private javax.swing.JTextField apellidotxt;
    private javax.swing.JLabel buscar;
    private javax.swing.JLabel cargar;
    private javax.swing.JTextField dnitxt;
    private javax.swing.JLabel eliminar;
    private javax.swing.JLabel guardar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel modificar;
    private javax.swing.JTextField nombretxt;
    private javax.swing.JLabel prueba;
    private javax.swing.JTextField residenciatxt;
    private javax.swing.JTable tablaProfesor;
    private javax.swing.JTextField titulotxt;
    private javax.swing.JTextField txtNombreBuscador;
    // End of variables declaration//GEN-END:variables
}
