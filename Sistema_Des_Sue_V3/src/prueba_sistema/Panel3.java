
package prueba_sistema;


import Consultas.consultas4;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;

import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import java.awt.Color;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;


public class Panel3 extends javax.swing.JPanel {
     ResultSet rs;
     consultas4 pp;
    Connection cx=Conexion.conexion.conexion();
    DefaultComboBoxModel ls= new DefaultComboBoxModel();
      DefaultComboBoxModel ls2= new DefaultComboBoxModel();
      Panel5 p5;
  
     DefaultTableModel tabla=new DefaultTableModel();
     Object[] datos=new Object[12]; 
      asistencias a;

   
    public Panel3() {
        initComponents();
        cargarComboBoxServicios();
        cargarComboBoxHorarios();
        desactivarCampoAlumno();
        desactivarCampoProfesor();

        mostrarTablaInscripcion();
        desactivarCampos();
        
    }
    
    void limpiar(){
        txtAlumno.setText("");
        labelCodigoAlumno.setText("");
        boxServicios.setSelectedItem("Seleccione un Servicio");
        boxDias.setSelectedItem("Seleccione unos días");
        boxHorarios.setSelectedItem("Seleccione un Horario");
        txtProfesor.setText("");
        labelCodigoProfesor.setText("");
        txtFecha.setText("");
        txtAuxiliar.setText("");
        desactivarCampos();
        botonAlumno.setEnabled(true);
    }
    
    void desactivarCampos(){
        boxDias.setEnabled(false);
        boxHorarios.setEnabled(false);
        botonProfesor.setEnabled(false);
        txtFecha.setEnabled(false);
         boxServicios.setEnabled(false);
         labelEditar.setEnabled(false);
    }
    
    
    void mostrarTablaInscripcion(){
        
           tabla.setRowCount(0);   
           tabla.setColumnCount(0);
            tabla.addColumn("Nombre Alumno");
           tabla.addColumn("Apellido Alumno");
           tabla.addColumn("DNI Alumno");
          tabla.addColumn("Días");
          tabla.addColumn("Horarios");
          tabla.addColumn("Nombre Profesor");
          tabla.addColumn("Apellido Profesor");
          tabla.addColumn("DNI Profesor");
          tabla.addColumn("Servicio");
          tabla.addColumn("Fecha Inscripción");
          tabla.addColumn("Ciclo Lectivo");
           tabla.addColumn("Estado");
          

     try{
        
        rs=Clases.Inscripcion.mostrarIncripciones(cx);
     
        while(rs.next()){
            datos[0]=rs.getString("al.nombre");
            datos[1]=rs.getString("al.apellido");
            datos[2]=rs.getString("al.dni");
            datos[3]=rs.getString("inc.dias");
            datos[4]=rs.getString("ho.horario");
            datos[5]=rs.getString("pro.nombre");
            datos[6]=rs.getString("pro.apellido");
             datos[7]=rs.getString("pro.dni");
            datos[8]=rs.getString("ser.nombre");
            datos[9]=rs.getString("inc.fecha_inscripcion");
            datos[10]=rs.getString("ci.año");
            datos[11]=rs.getString("inc.estado");
            
                   
            
           
            tabla.addRow(datos);
        }
         tablaInscripciones.setModel(tabla);
       
    }catch(Exception e){
          JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar las inscripciones","ERROR",ERROR_MESSAGE);
        
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

     public int getCantidadI() {
    return tablaInscripciones.getRowCount(); // Devuelve la cantidad de filas de la tabla
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
        botonAlumno = new javax.swing.JButton();
        boxHorarios = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        txtProfesor = new javax.swing.JTextField();
        botonProfesor = new javax.swing.JButton();
        boxDias = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInscripciones = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtNombreBuscador = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JLabel();
        labelCodigoAlumno = new javax.swing.JLabel();
        labelCodigoProfesor = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        labelEditar = new javax.swing.JLabel();
        txtAuxiliar = new javax.swing.JLabel();
        labelLimpiar = new javax.swing.JLabel();
        recargar = new javax.swing.JLabel();

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
                .addGap(38, 38, 38)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(430, 430, 430))
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

        botonAlumno.setText("...");
        botonAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAlumnoActionPerformed(evt);
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

        botonProfesor.setText("...");
        botonProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonProfesorActionPerformed(evt);
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
                .addComponent(botonAlumno)
                .addGap(0, 822, Short.MAX_VALUE)
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
                                .addComponent(botonProfesor))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(txtFecha)))))
                .addContainerGap(367, Short.MAX_VALUE))
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
                            .addComponent(botonProfesor))
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
                .addComponent(botonAlumno)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tablaInscripciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre Alumno", "Apellido Alumno", "DNI Alumno", "Dias", "Horarios", "Nombre Profesor", "Apellido Profesor", "DNI Profesor", "Servicio", "Fecha Inscripción", "Ciclo Lectivo", "Estado"
            }
        ));
        tablaInscripciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaInscripcionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaInscripciones);

        jPanel4.setBackground(new java.awt.Color(255, 102, 102));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/Buscar_1.png"))); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
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

        botonGuardar.setFont(new java.awt.Font("Segoe Print", 1, 10)); // NOI18N
        botonGuardar.setForeground(new java.awt.Color(255, 255, 255));
        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/g.png"))); // NOI18N
        botonGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonGuardarMouseClicked(evt);
            }
        });

        jButton3.setText("GENERAR REPORTE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        labelEditar.setFont(new java.awt.Font("Segoe Print", 1, 10)); // NOI18N
        labelEditar.setForeground(new java.awt.Color(255, 255, 255));
        labelEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/m.png"))); // NOI18N
        labelEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelEditarMouseClicked(evt);
            }
        });

        labelLimpiar.setFont(new java.awt.Font("Segoe Print", 1, 10)); // NOI18N
        labelLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        labelLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/c.png"))); // NOI18N
        labelLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelLimpiarMouseClicked(evt);
            }
        });

        recargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recargar.png"))); // NOI18N
        recargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recargarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombreBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(recargar)
                .addGap(72, 72, 72)
                .addComponent(botonGuardar)
                .addGap(87, 87, 87)
                .addComponent(labelEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelLimpiar)
                .addGap(29, 29, 29)
                .addComponent(labelCodigoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(labelCodigoProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(306, 306, 306)
                .addComponent(txtAuxiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jButton3)
                .addGap(285, 285, 285))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCodigoAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelCodigoProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAuxiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonGuardar, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelEditar, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelLimpiar, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(recargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(txtNombreBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout paneltresLayout = new javax.swing.GroupLayout(paneltres);
        paneltres.setLayout(paneltresLayout);
        paneltresLayout.setHorizontalGroup(
            paneltresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1949, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(paneltresLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(paneltresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1708, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );

        add(paneltres, "tres");
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreBuscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreBuscadorActionPerformed

    private void botonAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAlumnoActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
       
buscarAlumno dialog = new buscarAlumno(frame, true, this, a, p5, 1);
dialog.setVisible(true);
       if(!txtAlumno.getText().isEmpty()){
            boxServicios.setEnabled(true);
            // Obtener la fecha actual
             Date fechaActual = new Date();

             // Formatear la fecha al formato  dd-MM-yyyy
               SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
             String fechaFormateada = formato.format(fechaActual);
               // Mostrarla en el JTextField
              txtFecha.setText(fechaFormateada);

       }
      
    }//GEN-LAST:event_botonAlumnoActionPerformed

    private void botonProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonProfesorActionPerformed
    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
       
buscarProfesor dialog = new buscarProfesor(frame, true, this, pp, 2);
dialog.setVisible(true);

    }//GEN-LAST:event_botonProfesorActionPerformed

    private void botonGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGuardarMouseClicked

      
        String servicio=boxServicios.getSelectedItem().toString();
       
        String horario=boxHorarios.getSelectedItem().toString();
        
         
        
        try{ 
               if(txtAuxiliar.getText().isEmpty()){
                      int c_c_l=Clases.Inscripcion.obtenerCodigoCicloLectivo(cx);///obtenemos el codigo ciclo lectivo actual de este año
                      int cantidad_activos_inscriptos=Clases.Inscripcion.cantidadActivosInscriptos(cx, c_c_l);  //obtengo la cantidad de inscripciones activas de este ciclo lectivo
                      int codigoProfesor=Integer.parseInt(labelCodigoProfesor.getText()); //obtenemos el codigo del profesor
                      
                      ////pregunto si la cantidad de inscripciones activas de este año es mayor o igual a 60
                      if(cantidad_activos_inscriptos>=60){
                           JOptionPane.showMessageDialog(null, "No se puede inscribir. El instituto alcanzó el límite de 60 alumnos activos de este ciclo lectivo.","ERROR",ERROR_MESSAGE); /// si es asi, entonces el sistema no le permitirá realizar otra inscripcion
                               return;
                      }
                      
                     int cantidad_alumnos_activos_de_docente= Clases.Inscripcion.cantidadAlumnosDeUnDocente(cx, c_c_l, codigoProfesor); ///obtenemos la cantidad de alumnos activos que tiene el docente
                     
                     ////si la cantidad de alumnos activos que tiene un docente es mayor o igual a 10, el sistema no le permite realizar la inscripcion, ya que el profe tiene cupo lleno, por lo tanto debera esocjer otro profesor
                     if(cantidad_alumnos_activos_de_docente>=10){
                          JOptionPane.showMessageDialog(null, "No se puede inscribir. El profesor "+txtProfesor.getText()+" ya tiene cupo lleno de alumnos (10) en este ciclo lectivo, deberá elegir otro profesor","ERROR",ERROR_MESSAGE); 
                               return;
                     }
                   
                      int codigo_servicio=Clases.Inscripcion.obtenerCodigoServicio(cx, servicio);
                      int codigo_horario=0;
                      if(!horario.equalsIgnoreCase("Seleccione un Horario")){
                           codigo_horario=Clases.Inscripcion.obtenerCodigoHorario(cx, horario);
                      }
                    
                    
                      int codigoAlumno=Integer.parseInt(labelCodigoAlumno.getText());
                      String dias=boxDias.getSelectedItem().toString();
                      String diasF="";
                      if(dias.equalsIgnoreCase("Seleccione unos Días")){
                          diasF=null;
                      }else{
                          diasF=dias;
                      }
                      String fecha=txtFecha.getText();
                      Calendar fechaSeleccionada = Calendar.getInstance();
                      fechaSeleccionada.setTime(new SimpleDateFormat("dd-MM-yyyy").parse(txtFecha.getText()));

                      // Crear el formateador
                      SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

                      // Convertir la fecha al formato deseado
                      String fechaFormateada = formato.format(fechaSeleccionada.getTime());
                      
                
                      ///VALIDACION: valida que un alumno con servicio mensual no tenga pagos pendientes, si es que tiene el sistema no le permitirá registrar una nueva inscripcion no sin antes haber saldado todo lo que debe
                      int dni_alumno=Clases.Alumno.obtenerDni(cx, codigoAlumno);
                      rs=Clases.Pago.verPagosPendientesAlumno(cx, dni_alumno); ///se fija si este alumno tiene registros de pagos pendientes en caso de que se tenga un servicio mensual, si es que tiene un servicio de clase personalizada, pasa este filtro, ya que en dicho servicio no existe deuda pendiente, asi que en ese caso si podría realizar una nueva inscripcion sin problemas
                      while(rs.next()){// en caso de que si haya registros de pagos pendientes(meses en los que si vino pero no pago, osea cuotas sin pagar), el sistema no le permitirá realizar otra inscripción
                               JOptionPane.showMessageDialog(null, "El alumno "+txtAlumno.getText()+" tiene pagos de cuotas pendientes de su servicio mensual actual, deberá saldar todo lo que deba para poder realizar otra inscripcion","ERROR",ERROR_MESSAGE);
                               return;
                       }
                
                       ///VALIDACION: valida que no registre la misma inscripcion dos veces, es decir, que si ya se inscribió, y por accidiente quiere volver a inscribir a ese alumno de nuevo a ese servicio de ese ciclo lectivo, el sistema le bloqueará la inscripcion, 
                       /// solo en caso de que se inscriba a x servicio, y depues se pasa a m servicio, y despues se vuelve a inscribir a x servicio, asi sí se permite, pero intentar registrar x servicio dos veces de forma consecutiva no será permitido por el sistema
                       rs=Clases.Inscripcion.evitarDobleInscripcionConsecutiva(cx, codigoAlumno, codigo_servicio, c_c_l);
                       while(rs.next()){
                                 JOptionPane.showMessageDialog(null, "Ya ha registrado recientemente al "+txtAlumno.getText()+" con ese servicio y del ciclo lectivo actual","ERROR",ERROR_MESSAGE);
                                 return;
                       }
                
                        /// una vez pasados todos los filtros, recien podra realizar la inscripcion...pero antes el sistema tendrá que dar como INACTIVO su servicio actual y, el nuevo pasaría a ser el ACTIVO..
                        Clases.Inscripcion.darBajaInscripcion(cx, codigoAlumno);
                        Clases.Inscripcion.insertarInscripcion(cx, codigoAlumno, diasF, codigo_horario, codigoProfesor, codigo_servicio, fechaFormateada, c_c_l);
                        JOptionPane.showMessageDialog(null, "Se registro la inscripcion correctamente");
                        mostrarTablaInscripcion();
                        limpiar();
                        
                        
                  }else{//// SiNO, QUIERE DECIR QUE ES UNA ACTUALIZACION
                   
                   
                         int filaSeleccionada = tablaInscripciones.getSelectedRow();
                         ///rescato datos relevantes que se usaran para una actualizacion de la tabla.. 
                         String dniAlumno =tablaInscripciones.getValueAt(filaSeleccionada, 2).toString();
                         Object dias =tablaInscripciones.getValueAt(filaSeleccionada, 3);
                         if(dias == null){
                                String diasF="";
                                diasF=null;
                                int codigo_horario=0;
                                /// si el labelCodigoProfesor esta vacio, quiere decir que no fue al apartado profesor y seleccionó otro profesor, no, quiere decir que se queda con el preofesor que tiene nomas, que seria el que esta en el tabla, por lo tanto ponemos el codigo del profesor que esta en la tabla
                                int codigo_profesor=0;
                                if(labelCodigoProfesor.getText().isEmpty()){
                                       codigo_profesor=Integer.parseInt(txtAuxiliar.getText());
                                }else{///sino, quiere decir que sí seleccionó otro profesor y por lo tanto tendriamos que poner el codigo de ese nuevo profesor
                                       codigo_profesor=Integer.parseInt(labelCodigoProfesor.getText());
                                }
                         
                                int codigo_alumno=Clases.Alumno.obtenerCodigo(cx,Integer.parseInt( dniAlumno));
                                Clases.Inscripcion.actualizarInscripcion(cx, diasF, codigo_horario, codigo_profesor, codigo_alumno);
                                JOptionPane.showMessageDialog(null, "Se han actualizado algunos datos de la inscripcion del alumno "+txtAlumno.getText());      
                                mostrarTablaInscripcion();
                                limpiar();
                         }else{
                              String d=boxDias.getSelectedItem().toString();
                              int codigo_horario=Clases.Inscripcion.obtenerCodigoHorario(cx, horario);
                         
                              /// si el labelCodigoProfesor esta vacio, quiere decir que no fue al apartado profesor y seleccionó otro profesor, no, quiere decir que se queda con el preofesor que tiene nomas, que seria el que esta en el tabla, por lo tanto ponemos el codigo del profesor que esta en la tabla
                              int codigo_profesor=0;
                              if(labelCodigoProfesor.getText().isEmpty()){
                                   codigo_profesor=Integer.parseInt(txtAuxiliar.getText());
                               }else{///sino, quiere decir que sí seleccionó otro profesor y por lo tanto tendriamos que poner el codigo de ese nuevo profesor
                                   codigo_profesor=Integer.parseInt(labelCodigoProfesor.getText());
                               }
                         
                               int codigo_alumno=Clases.Alumno.obtenerCodigo(cx,Integer.parseInt( dniAlumno));
                               Clases.Inscripcion.actualizarInscripcion(cx, d, codigo_horario, codigo_profesor, codigo_alumno);
                               JOptionPane.showMessageDialog(null, "Se han actualizado algunos datos de la inscripcion del alumno "+txtAlumno.getText());      
                               mostrarTablaInscripcion();
                               limpiar();
                           }
                        
                 }            
              
      
        }catch(Exception e){
              JOptionPane.showMessageDialog(null, "Ha ocurrido un error","ERROR",ERROR_MESSAGE);
              e.printStackTrace();
        }
     
       
       
    }//GEN-LAST:event_botonGuardarMouseClicked

    private void txtAlumnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAlumnoKeyReleased

    }//GEN-LAST:event_txtAlumnoKeyReleased

    private void txtProfesorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProfesorKeyReleased

    }//GEN-LAST:event_txtProfesorKeyReleased

    private void txtFechaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaKeyReleased

    }//GEN-LAST:event_txtFechaKeyReleased

    private void boxServiciosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxServiciosMouseReleased

    }//GEN-LAST:event_boxServiciosMouseReleased

    private void boxDiasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxDiasMouseReleased
      
    }//GEN-LAST:event_boxDiasMouseReleased

    private void boxHorariosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxHorariosMouseReleased
     
    }//GEN-LAST:event_boxHorariosMouseReleased

    private void boxServiciosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxServiciosItemStateChanged


             if(boxServicios.getSelectedItem().equals("Inclusión Escolar: Acompañamiento") || boxServicios.getSelectedItem().equals("Inclusión Escolar: Itinerancia")){
                 boxHorarios.setEnabled(false);
                 boxHorarios.setSelectedItem("Seleccione un Horario");
                 botonProfesor.setEnabled(true);
                 boxDias.setEnabled(false);
                 boxDias.setSelectedItem("Seleccione unos días");
                 
             }else{
                 boxDias.setEnabled(true);
                  boxHorarios.setEnabled(true);
                 botonProfesor.setEnabled(true);
             }
         
    }//GEN-LAST:event_boxServiciosItemStateChanged

    private void boxDiasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxDiasItemStateChanged

    }//GEN-LAST:event_boxDiasItemStateChanged

    private void boxHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxHorariosActionPerformed

    }//GEN-LAST:event_boxHorariosActionPerformed

    private void boxHorariosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxHorariosItemStateChanged

    }//GEN-LAST:event_boxHorariosItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     try {
               //  Ruta donde se guardará el PDF (en el Escritorio del usuario)
               String ruta = System.getProperty("user.home") + "/OneDrive/Desktop/reporte.pdf";

               // Crear el documento en formato A4 horizontal (más ancho para las tablas)
               Document documento = new Document(PageSize.A4.rotate());

               // Asociar el documento con un "escritor" que lo guardará en la ruta indicada
               PdfWriter.getInstance(documento, new FileOutputStream(ruta));

               // Abrir el documento para comenzar a escribir contenido en él
               documento.open();

   
               //ENCABEZADO DEL DOCUMENTO
               // Título centrado y en negrita
               Paragraph titulo = new Paragraph("Reporte de Inscripciones Activas",
               FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));
               titulo.setAlignment(Element.ALIGN_CENTER);
               documento.add(titulo);

               //  Subtítulo e información adicional
               documento.add(new Paragraph("Instituto Pedagógico Despertando Sueños"));
               documento.add(new Paragraph("Fecha: " + LocalDate.now()));
               documento.add(new Paragraph("\nListado de inscripciones activas:\n"));

   
               //  CREACIÓN DE LA TABLA PDF
               // Crear una tabla con 11 columnas
               PdfPTable tablaPDF = new PdfPTable(11);
               tablaPDF.setWidthPercentage(100);   // Ocupa el ancho total de la página
               tablaPDF.setSpacingBefore(10f);     // Espacio antes de la tabla
               tablaPDF.setSpacingAfter(10f);      // Espacio después de la tabla

               // Nombres de las columnas
               String[] columnas = {
                  "Nombre Alumno", "Apellido Alumno", "DNI Alumno", "Días", "Horarios",
                  "Nombre Profesor", "Apellido Profesor", "Servicio",
                  "Fecha Inscripción", "Ciclo Lectivo", "Estado"
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
                           // Se llama al método del modelo que devuelve las inscripciones activas
                           rs = Clases.Inscripcion.mostrarIncripcionesActivas(cx);

                           // Se recorre cada fila del ResultSet y se agregan las celdas a la tabla
                           while (rs.next()) {
                              tablaPDF.addCell(new Phrase(rs.getString("al.nombre"), fontData));
                              tablaPDF.addCell(new Phrase(rs.getString("al.apellido"), fontData));
                              tablaPDF.addCell(new Phrase(rs.getString("al.dni"), fontData));
                              tablaPDF.addCell(new Phrase(rs.getString("inc.dias"), fontData));
                              tablaPDF.addCell(new Phrase(rs.getString("ho.horario"), fontData));
                              tablaPDF.addCell(new Phrase(rs.getString("pro.nombre"), fontData));
                              tablaPDF.addCell(new Phrase(rs.getString("pro.apellido"), fontData));
                              tablaPDF.addCell(new Phrase(rs.getString("ser.nombre"), fontData));
                              tablaPDF.addCell(new Phrase(rs.getString("inc.fecha_inscripcion"), fontData));
                              tablaPDF.addCell(new Phrase(rs.getString("ci.año"), fontData));
                              tablaPDF.addCell(new Phrase(rs.getString("inc.estado"), fontData));
                           }

                  } catch (Exception e) {
                             JOptionPane.showMessageDialog(null, "Error al cargar datos: " + e.getMessage());
                  }

                  // Agregar la tabla al documento PDF
                   documento.add(tablaPDF);

                  // Se cierra el documento (muy importante)
                  documento.close();

                   // Aviso al usuario
                   JOptionPane.showMessageDialog(this, "PDF generado correctamente en el Escritorio.");

                   // Abrir el archivo automáticamente
                   java.awt.Desktop.getDesktop().open(new java.io.File(ruta));

   }catch (Exception ex) {
   
        JOptionPane.showMessageDialog(this, "Error al generar el PDF: " + ex.getMessage());
   }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
             tabla.setRowCount(0);   
           tabla.setColumnCount(0);
            tabla.addColumn("Nombre Alumno");
           tabla.addColumn("Apellido Alumno");
           tabla.addColumn("DNI Alumno");
          tabla.addColumn("Días");
          tabla.addColumn("Horarios");
          tabla.addColumn("Nombre Profesor");
          tabla.addColumn("Apellido Profesor");
          tabla.addColumn("DNI Profesor");
          tabla.addColumn("Servicio");
          tabla.addColumn("Fecha Inscripción");
          tabla.addColumn("Ciclo Lectivo");
           tabla.addColumn("Estado");
          

     try{
        
        rs=Clases.Inscripcion.buscarAlumnoPorNombre(cx, txtNombreBuscador.getText());
     
        while(rs.next()){
            datos[0]=rs.getString("al.nombre");
            datos[1]=rs.getString("al.apellido");
            datos[2]=rs.getString("al.dni");
            datos[3]=rs.getString("inc.dias");
            datos[4]=rs.getString("ho.horario");
            datos[5]=rs.getString("pro.nombre");
            datos[6]=rs.getString("pro.apellido");
            datos[7]=rs.getString("pro.dni");
            datos[8]=rs.getString("ser.nombre");
            datos[9]=rs.getString("inc.fecha_inscripcion");
            datos[10]=rs.getString("ci.año");
            datos[11]=rs.getString("inc.estado");
            
                   
            
           
            tabla.addRow(datos);
        }
         tablaInscripciones.setModel(tabla);
       
    }catch(Exception e){
          JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar las inscripciones del alumno "+txtNombreBuscador.getText(),"ERROR",ERROR_MESSAGE);
        
    }       
    }//GEN-LAST:event_jLabel15MouseClicked

    private void tablaInscripcionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaInscripcionesMouseClicked
         try{
            int filaSeleccionada = tablaInscripciones.getSelectedRow();
            ///rescato datos relevantes que se usaran para una actualizacion de la tabla.. 
            String nombreAlumno =tablaInscripciones.getValueAt(filaSeleccionada, 0).toString();
            String apellidoAlumno =tablaInscripciones.getValueAt(filaSeleccionada, 1).toString();
            Object dias =tablaInscripciones.getValueAt(filaSeleccionada, 3);
            if(dias!=null){
                dias.toString();
            }
            Object horarios =tablaInscripciones.getValueAt(filaSeleccionada, 4);
            if(horarios!=null){
                horarios.toString();
            }
            String nombreProfesor =tablaInscripciones.getValueAt(filaSeleccionada, 5).toString();
            String apellidoProfesor =tablaInscripciones.getValueAt(filaSeleccionada, 6).toString();
            String dniProfesor =tablaInscripciones.getValueAt(filaSeleccionada, 7).toString();
            String servicio =tablaInscripciones.getValueAt(filaSeleccionada, 8).toString();
            String fecha =tablaInscripciones.getValueAt(filaSeleccionada, 9).toString();
            String estado =tablaInscripciones.getValueAt(filaSeleccionada, 11).toString();
            
            if(estado.equalsIgnoreCase("ACTIVO")){
                  int codigo_profesor=Clases.Profesor.buscarCodigo(cx, Integer.parseInt(dniProfesor) );
                  if(dias==null && horarios==null){
                      txtAlumno.setText(nombreAlumno+" "+apellidoAlumno);
                      boxDias.setSelectedItem("Seleccione unos Días");
                      boxHorarios.setSelectedItem("Seleccione un Horario");
                      txtProfesor.setText(nombreProfesor+" "+apellidoProfesor);
                      boxServicios.setSelectedItem(servicio);
                      SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd"); // o el formato original 
                      SimpleDateFormat formatoSalida = new SimpleDateFormat("dd-MM-yyyy");
                      Date fechaDate = formatoEntrada.parse(fecha); // convertir String a Date
                      String fechaFormateada = formatoSalida.format(fechaDate); // convertir Date a String con nuevo formato
                      txtFecha.setText(fechaFormateada);
                      
                      txtAuxiliar.setText(String.valueOf(codigo_profesor));
                      botonAlumno.setEnabled(false);
                      boxServicios.setEnabled(false);
                      txtFecha.setEnabled(false);
                      boxDias.setEnabled(false);
                      boxHorarios.setEnabled(false);
                      botonProfesor.setEnabled(false);
                      labelEditar.setEnabled(true);
                  }else{
                       txtAlumno.setText(nombreAlumno+" "+apellidoAlumno);
                       boxDias.setSelectedItem(dias);
                       boxHorarios.setSelectedItem(horarios);
                       txtProfesor.setText(nombreProfesor+" "+apellidoProfesor);
                       boxServicios.setSelectedItem(servicio);
                       SimpleDateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd"); // o el formato original 
                       SimpleDateFormat formatoSalida = new SimpleDateFormat("dd-MM-yyyy");
                       Date fechaDate = formatoEntrada.parse(fecha); // convertir String a Date
                       String fechaFormateada = formatoSalida.format(fechaDate); // convertir Date a String con nuevo formato
                       txtFecha.setText(fechaFormateada);

                       txtAuxiliar.setText(String.valueOf(codigo_profesor));
                       botonAlumno.setEnabled(false);
                       boxServicios.setEnabled(false);
                       txtFecha.setEnabled(false);
                       boxDias.setEnabled(false);
                       boxHorarios.setEnabled(false);
                       botonProfesor.setEnabled(false);
                       labelEditar.setEnabled(true);
                  }
                 
            }else{
                 txtAlumno.setText("");
                 labelCodigoAlumno.setText("");
                 boxServicios.setSelectedItem("Seleccione un Servicio");
                 boxDias.setSelectedItem("Seleccione unos días");
                 boxHorarios.setSelectedItem("Seleccione un Horario");
                 txtProfesor.setText("");
                 labelCodigoProfesor.setText("");
                 txtFecha.setText("");
                 txtAuxiliar.setText("");
                desactivarCampos();
                botonAlumno.setEnabled(false);
                 JOptionPane.showMessageDialog(null, "No se puede modificar inscripciones INACTIIVAS","ERROR",ERROR_MESSAGE);
            }
          
         }catch(Exception e){
              
         }
    }//GEN-LAST:event_tablaInscripcionesMouseClicked

    private void labelEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEditarMouseClicked
          int filaSeleccionada = tablaInscripciones.getSelectedRow();

            Object dias =tablaInscripciones.getValueAt(filaSeleccionada, 3); 
            if(dias==null){
                  botonProfesor.setEnabled(true);   
                  labelEditar.setEnabled(false);
            }else{
                  boxDias.setEnabled(true);
                  boxHorarios.setEnabled(true);
                  botonProfesor.setEnabled(true);      
                  labelEditar.setEnabled(false);
            }
        
    }//GEN-LAST:event_labelEditarMouseClicked

    private void labelLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelLimpiarMouseClicked
        limpiar();      
    }//GEN-LAST:event_labelLimpiarMouseClicked

    private void recargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recargarMouseClicked
 mostrarTablaInscripcion();
    }//GEN-LAST:event_recargarMouseClicked

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
    private javax.swing.JButton botonAlumno;
    private javax.swing.JLabel botonGuardar;
    private javax.swing.JButton botonProfesor;
    private javax.swing.JComboBox<String> boxDias;
    private javax.swing.JComboBox<String> boxHorarios;
    private javax.swing.JComboBox<String> boxServicios;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JLabel labelCodigoAlumno;
    private javax.swing.JLabel labelCodigoProfesor;
    private javax.swing.JLabel labelEditar;
    private javax.swing.JLabel labelLimpiar;
    private javax.swing.JPanel paneltres;
    private javax.swing.JLabel recargar;
    private javax.swing.JTable tablaInscripciones;
    private javax.swing.JTextField txtAlumno;
    private javax.swing.JLabel txtAuxiliar;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNombreBuscador;
    private javax.swing.JTextField txtProfesor;
    // End of variables declaration//GEN-END:variables
}
