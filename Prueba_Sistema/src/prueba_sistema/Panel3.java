
package prueba_sistema;

import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;


public class Panel3 extends javax.swing.JPanel {
     ResultSet rs;
    Connection cx=Conexion.conexion.conexion();
    DefaultComboBoxModel ls= new DefaultComboBoxModel();
      DefaultComboBoxModel ls2= new DefaultComboBoxModel();
  
     DefaultTableModel tabla=new DefaultTableModel();
     Object[] datos=new Object[10]; 

   
    public Panel3() {
        initComponents();
        cargarComboBoxServicios();
        cargarComboBoxHorarios();
        desactivarCampoAlumno();
        desactivarCampoProfesor();
        validarCamposVacios();
        mostrarTablaInscripcion();
    }
    
    
    void mostrarTablaInscripcion(){
        
           tabla.setRowCount(0);   
           tabla.setColumnCount(0);
            tabla.addColumn("Nombre Alumno");
           tabla.addColumn("Apellido Alumno");
          tabla.addColumn("Días");
          tabla.addColumn("Horarios");
          tabla.addColumn("Nombre Profesor");
          tabla.addColumn("Apellido Profesor");
          tabla.addColumn("Servicio");
          tabla.addColumn("Fecha Inscripción");
          tabla.addColumn("Ciclo Lectivo");
           tabla.addColumn("Estado");
          

     try{
        
        rs=Clases.Inscripcion.mostrarIncripciones(cx);
     
        while(rs.next()){
            datos[0]=rs.getString("al.nombre");
            datos[1]=rs.getString("al.apellido");
            datos[2]=rs.getString("inc.dias");
            datos[3]=rs.getString("ho.horario");
            datos[4]=rs.getString("pro.nombre");
            datos[5]=rs.getString("pro.apellido");
            datos[6]=rs.getString("ser.nombre");
            datos[7]=rs.getString("inc.fecha_inscripcion");
            datos[8]=rs.getString("ci.año");
            datos[9]=rs.getString("inc.estado");
            
                   
            
           
            tabla.addRow(datos);
        }
         tablaInscripciones.setModel(tabla);
       
    }catch(Exception e){
          JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar las inscripciones","ERROR",ERROR_MESSAGE);
        
    }
    }
    
    void validarCamposVacios(){
        if(txtAlumno.getText().isEmpty() || txtProfesor.getText().isEmpty() || txtFecha.getText().isEmpty() || boxDias.getSelectedItem().equals("Seleccione unos días") || boxServicios.getSelectedItem().equals("Seleccione un Servicio") || boxHorarios.getSelectedItem().equals("Seleccione un Horario")){
            botonGuardar.setEnabled(false);          
        }else{
            botonGuardar.setEnabled(true);
        }
    }
    
    void desactivarCampoAlumno(){
        txtAlumno.setEnabled(false);
        
    }
    
    void desactivarCampoProfesor(){
        txtProfesor.setEnabled(false);
        
    }
    
    void cargarComboBoxHorarios(){
         try{
            rs=Clases.Inscripcion.verHorarios(cx);
            ls2.addElement("Seleccione un Horario");
            while(rs.next())
                ls2.addElement(rs.getString("horario"));
                boxHorarios.setModel(ls2);
            
        }catch(Exception e){
              JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar los horarios","ERROR",ERROR_MESSAGE);
        }
    }
    
    void cargarComboBoxServicios(){
         try{
            rs=Clases.Inscripcion.verServicios(cx);
            ls.addElement("Seleccione un Servicio");
            while(rs.next())
                ls.addElement(rs.getString("nombre"));
                boxServicios.setModel(ls);
            
        }catch(Exception e){
              JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar los servicios","ERROR",ERROR_MESSAGE);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneltres = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        boxServicios = new javax.swing.JComboBox<>();
        txtAlumno = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        boxHorarios = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        txtProfesor = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        boxDias = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInscripciones = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JLabel();
        labelCodigoAlumno = new javax.swing.JLabel();
        labelCodigoProfesor = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        paneltres.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 102, 102));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(1000, 70));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Inscripciones");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sol.png"))); // NOI18N
        jLabel19.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("E. P. Despertando Sueños ");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/servicio.png"))); // NOI18N
        jLabel7.setText("jLabel7");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel14))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addGap(10, 10, 10))
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setForeground(new java.awt.Color(255, 102, 51));

        jLabel2.setBackground(new java.awt.Color(255, 102, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Alumnos:");

        jLabel4.setBackground(new java.awt.Color(255, 102, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Servicios:");

        jLabel3.setBackground(new java.awt.Color(255, 102, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Dias:");

        boxServicios.setBackground(new java.awt.Color(255, 204, 204));
        boxServicios.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        boxServicios.setForeground(new java.awt.Color(255, 0, 102));
        boxServicios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxServicios.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxServiciosItemStateChanged(evt);
            }
        });
        boxServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                boxServiciosMouseReleased(evt);
            }
        });

        txtAlumno.setBackground(new java.awt.Color(255, 204, 204));
        txtAlumno.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtAlumno.setForeground(new java.awt.Color(255, 51, 102));
        txtAlumno.setBorder(null);
        txtAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAlumnoKeyReleased(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(255, 102, 51));
        jLabel11.setForeground(new java.awt.Color(255, 102, 51));
        jLabel11.setText("******************************************************");

        jLabel5.setBackground(new java.awt.Color(255, 102, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Profesor/a:");

        jLabel6.setBackground(new java.awt.Color(255, 102, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Horarios:");

        jLabel8.setBackground(new java.awt.Color(255, 102, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Fecha:");

        txtFecha.setBackground(new java.awt.Color(255, 204, 204));
        txtFecha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtFecha.setForeground(new java.awt.Color(255, 51, 102));
        txtFecha.setBorder(null);
        txtFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFechaKeyReleased(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(255, 102, 51));
        jLabel13.setForeground(new java.awt.Color(255, 102, 51));
        jLabel13.setText("***********************************************************");

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        boxHorarios.setBackground(new java.awt.Color(255, 204, 204));
        boxHorarios.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        boxHorarios.setForeground(new java.awt.Color(255, 0, 102));
        boxHorarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxHorarios.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxHorariosItemStateChanged(evt);
            }
        });
        boxHorarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                boxHorariosMouseReleased(evt);
            }
        });
        boxHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxHorariosActionPerformed(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(255, 102, 51));
        jLabel17.setForeground(new java.awt.Color(255, 102, 51));
        jLabel17.setText("***********************************************************");

        txtProfesor.setBackground(new java.awt.Color(255, 204, 204));
        txtProfesor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtProfesor.setForeground(new java.awt.Color(255, 51, 102));
        txtProfesor.setBorder(null);
        txtProfesor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProfesorKeyReleased(evt);
            }
        });

        jButton2.setText("...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        boxDias.setBackground(new java.awt.Color(255, 204, 204));
        boxDias.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        boxDias.setForeground(new java.awt.Color(255, 0, 102));
        boxDias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione unos días", "Martes - Jueves", "Lunes - Miercoles", "Miercoles - Viernes" }));
        boxDias.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxDiasItemStateChanged(evt);
            }
        });
        boxDias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                boxDiasMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(boxServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(boxDias, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(0, 837, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boxHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtProfesor))
                                .addGap(29, 29, 29)
                                .addComponent(jButton2))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(txtFecha)))))
                .addContainerGap(381, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(boxHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(boxServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17))
                            .addComponent(jButton2))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(boxDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel13)))
                        .addContainerGap(17, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tablaInscripciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre Alumno", "Apellido Alumno", "Dias", "Horarios", "Nombre Profesor", "Apellido Profesor", "Servicio", "Fecha Inscripción", "Ciclo Lectivo", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tablaInscripciones);

        jPanel4.setBackground(new java.awt.Color(255, 102, 102));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/Buscar_1.png"))); // NOI18N

        jTextField11.setBackground(new java.awt.Color(255, 204, 204));
        jTextField11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField11.setForeground(new java.awt.Color(0, 0, 0));
        jTextField11.setBorder(null);
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });

        botonGuardar.setFont(new java.awt.Font("Segoe Print", 1, 10)); // NOI18N
        botonGuardar.setForeground(new java.awt.Color(255, 255, 255));
        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/g.png"))); // NOI18N
        botonGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonGuardarMouseClicked(evt);
            }
        });

        labelCodigoAlumno.setText("jLabel9");

        labelCodigoProfesor.setText("jLabel9");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonGuardar)
                .addGap(63, 63, 63)
                .addComponent(labelCodigoAlumno)
                .addGap(103, 103, 103)
                .addComponent(labelCodigoProfesor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(botonGuardar)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCodigoAlumno)
                    .addComponent(labelCodigoProfesor))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout paneltresLayout = new javax.swing.GroupLayout(paneltres);
        paneltres.setLayout(paneltresLayout);
        paneltresLayout.setHorizontalGroup(
            paneltresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1972, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneltresLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(87, 87, 87))
        );
        paneltresLayout.setVerticalGroup(
            paneltresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneltresLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );

        add(paneltres, "tres");
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
       
buscarAlumno dialog = new buscarAlumno(frame, true, this);
dialog.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
       
buscarProfesor dialog = new buscarProfesor(frame, true, this);
dialog.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void botonGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGuardarMouseClicked

      
        String servicio=boxServicios.getSelectedItem().toString();
       
        String horario=boxHorarios.getSelectedItem().toString();
        
         
        
        try{
               int codigo_servicio=Clases.Inscripcion.obtenerCodigoServicio(cx, servicio);
               int codigo_horario=Clases.Inscripcion.obtenerCodigoHorario(cx, horario);
               int codigoProfesor=Integer.parseInt(labelCodigoProfesor.getText());
               int codigoAlumno=Integer.parseInt(labelCodigoAlumno.getText());
                String dias=boxDias.getSelectedItem().toString();
                String fecha=txtFecha.getText();
                int c_c_l=Clases.Inscripcion.obtenerCodigoCicloLectivo(cx);
                Clases.Inscripcion.insertarInscripcion(cx, codigoAlumno, dias, codigo_horario, codigoProfesor, codigo_servicio, fecha, c_c_l);
                 JOptionPane.showMessageDialog(null, "Se registro la inscripcion correctamente");
                 mostrarTablaInscripcion();
      
        }catch(Exception e){
              JOptionPane.showMessageDialog(null, "Ha ocurrido un error","ERROR",ERROR_MESSAGE);
        }
     
       
       
    }//GEN-LAST:event_botonGuardarMouseClicked

    private void txtAlumnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlumnoKeyReleased
       validarCamposVacios();
    }//GEN-LAST:event_txtAlumnoKeyReleased

    private void txtProfesorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProfesorKeyReleased
       validarCamposVacios();
    }//GEN-LAST:event_txtProfesorKeyReleased

    private void txtFechaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaKeyReleased
        validarCamposVacios();
    }//GEN-LAST:event_txtFechaKeyReleased

    private void boxServiciosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxServiciosMouseReleased

    }//GEN-LAST:event_boxServiciosMouseReleased

    private void boxDiasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxDiasMouseReleased
      
    }//GEN-LAST:event_boxDiasMouseReleased

    private void boxHorariosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxHorariosMouseReleased
     
    }//GEN-LAST:event_boxHorariosMouseReleased

    private void boxServiciosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxServiciosItemStateChanged
         validarCamposVacios();
    }//GEN-LAST:event_boxServiciosItemStateChanged

    private void boxDiasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxDiasItemStateChanged
         validarCamposVacios();
    }//GEN-LAST:event_boxDiasItemStateChanged

    private void boxHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxHorariosActionPerformed

    }//GEN-LAST:event_boxHorariosActionPerformed

    private void boxHorariosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxHorariosItemStateChanged
          validarCamposVacios();
    }//GEN-LAST:event_boxHorariosItemStateChanged

    public void setTxtAlumno(String nombre) {
        txtAlumno.setText(nombre);
    }

    public void setLabelCodigoAlumno(String codigo) {
        labelCodigoAlumno.setText(codigo);
    }

    public void setLabelCodigoProfesor(String codigo) {
       labelCodigoProfesor.setText(codigo);
    }

    public void setTxtProfesor(String nombre) {
        txtProfesor.setText(nombre);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel botonGuardar;
    private javax.swing.JComboBox<String> boxDias;
    private javax.swing.JComboBox<String> boxHorarios;
    private javax.swing.JComboBox<String> boxServicios;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JLabel labelCodigoAlumno;
    private javax.swing.JLabel labelCodigoProfesor;
    private javax.swing.JPanel paneltres;
    private javax.swing.JTable tablaInscripciones;
    private javax.swing.JTextField txtAlumno;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtProfesor;
    // End of variables declaration//GEN-END:variables
}
