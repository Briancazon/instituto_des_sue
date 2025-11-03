
package Alumno;

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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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

import prueba_sistema.buscarObraSocial;
import prueba_sistema.buscarTutor;

public class ModificarA extends javax.swing.JPanel {
 DefaultTableModel tabla=new DefaultTableModel();
      Object[] datos=new Object[12];
      ResultSet rs;
      Connection cx=Conexion.conexion.conexion();
      DefaultComboBoxModel ls= new DefaultComboBoxModel();
      DefaultComboBoxModel lp= new DefaultComboBoxModel();
  
    public ModificarA() {
        initComponents();


        MostrarAlumno();
        desactivarmodificar();
        desactivareliminar();
        desactivarCampo();
        desactivarguardar();
        activarMas();
        desactivarhabilitar();
        validarRangoFecha();
        
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
    
    
   
 
 
    public void MostrarAlumno(){
         tabla.setRowCount(0);   
         tabla.setColumnCount(0);
        
         tabla.addColumn("Nombre");  
         tabla.addColumn("Apellido"); 
         tabla.addColumn("Fecha Nacimiento"); 
         tabla.addColumn("DNI"); 
         tabla.addColumn("Escuela"); 
         tabla.addColumn("Grado");
         tabla.addColumn("Nivel");
         tabla.addColumn("Obra Social");
         tabla.addColumn("Nombre del Tutor");
         tabla.addColumn("Apellido del Tutor");
          tabla.addColumn("Teléfono del Tutor");
         tabla.addColumn("Parentesco");
        
         
         try{
            
             rs=Clases.Alumno.mostrarAlumnos(cx);
              while(rs.next()){
                   datos[0]=rs.getString("al.nombre");
                   datos[1]=rs.getString("al.apellido");
                   datos[2]=rs.getString("al.fecha_nac");
                   datos[3]=rs.getString("al.dni");
                   datos[4]=rs.getString("al.escuela");
                   datos[5]=rs.getString("al.grado");
                   datos[6]=rs.getString("al.nivel");
                   datos[7]=rs.getString("os.nombre");
                   datos[8]=rs.getString("t.nombre");
                   datos[9]=rs.getString("t.apellido");
                   datos[10]=rs.getString("t.telefono");
                   datos[11]=rs.getString("at.parentesco");
                 
                  if(datos[7]==null){
                      datos[7]="Sin Obra Social";
                  }
                   tabla.addRow(datos);
                   TablaAlumno.setModel(tabla);
                   
              } 
              
          }catch(Exception e){
                   JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar los alumnos en la tabla","ERROR",ERROR_MESSAGE); 
          }
        
    }
    public void MostrarAlumnoInactivo(){
         tabla.setRowCount(0);   
         tabla.setColumnCount(0);
        
         tabla.addColumn("Nombre");  
         tabla.addColumn("Apellido"); 
         tabla.addColumn("Fecha Nacimiento"); 
         tabla.addColumn("DNI"); 
         tabla.addColumn("Escuela"); 
         tabla.addColumn("Grado");
         tabla.addColumn("Nivel");
         tabla.addColumn("Obra Social");
         tabla.addColumn("Nombre del Tutor");
         tabla.addColumn("Apellido del Tutor");
         tabla.addColumn("Teléfono del Tutor");
         tabla.addColumn("Parentesco");
        
         
         try{
            
             rs=Clases.Alumno.mostrarAlumnosInactivo(cx);
              while(rs.next()){
                   datos[0]=rs.getString("al.nombre");
                   datos[1]=rs.getString("al.apellido");
                   datos[2]=rs.getString("al.fecha_nac");
                   datos[3]=rs.getString("al.dni");
                   datos[4]=rs.getString("al.escuela");
                   datos[5]=rs.getString("al.grado");
                   datos[6]=rs.getString("al.nivel");
                   datos[7]=rs.getString("os.nombre");
                   datos[8]=rs.getString("t.nombre");
                   datos[9]=rs.getString("t.apellido");
                   datos[10]=rs.getString("t.telefono");
                   datos[11]=rs.getString("at.parentesco");
                 
                        if(datos[7]==null){
                      datos[7]="Sin Obra Social";
                  }
                   tabla.addRow(datos);
                   TablaAlumno.setModel(tabla);
                   
              } 
              
          }catch(Exception e){
                   JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar los alumnos en la tabla","ERROR",ERROR_MESSAGE); 
          }
        
    }
   
     void limpiar(){
         nombretxt.setText("");
         apellidotxt.setText("");
         dateFecha.setDate(null);
         dnitxt.setText("");
         escuelatxt.setText("");
         txtOS.setText("");
         nivel.setSelectedItem("Seleccionar");
         gradotxt.setText("");
         txtTutor.setText("");
         labelCodigoTutor.setText("");
         labelCodigoOS.setText("");
         parentescotxt.setText("");
         desactivarguardar();
         desactivarmodificar();
         desactivareliminar();
         activarMas();
         codA.setText("");
         
     }
 
     public void activarguardar(){
         guardar.setEnabled(true);
     }
     public void activarmodificar(){
         modificar.setEnabled(true);
     }
     public void activareliminar(){
         eliminar.setEnabled(true);
     }
    public void activarrecargar(){
        recargar.setEnabled(true);
    }
    public void activarbuscar(){
        buscar.setEnabled(true);
    }
    public void activarhabilitar(){
        habilitar.setEnabled(true);
    }
     public void desactivarguardar(){
         guardar.setEnabled(false);
     }
     public void desactivarmodificar(){
         modificar.setEnabled(false);
     }
     public void desactivareliminar(){
         eliminar.setEnabled(false);
     }
    public void desactivarrecargar(){
        recargar.setEnabled(false);
    }
    public void desactivarbuscar(){
        buscar.setEnabled(false);
    }
    public void desactivarhabilitar(){
        habilitar.setEnabled(false);
    }
    
   void desactivarMas(){
       mas.setEnabled(false);
   }
   
    void activarMas(){
       mas.setEnabled(true);
   }
   
 
    public void activarCampo(){
        nombretxt.setEnabled(true);
         apellidotxt.setEnabled(true);
         dateFecha.setEnabled(true);
         dnitxt.setEnabled(true);
         escuelatxt.setEnabled(true);

         nivel.setEnabled(true);
      
          gradotxt.setEnabled(true);
         parentescotxt.setEnabled(true);
         
    }
 
  public void desactivarCampo(){
        nombretxt.setEnabled(false);
        apellidotxt.setEnabled(false);
         dateFecha.setEnabled(false);
         dnitxt.setEnabled(false);
         escuelatxt.setEnabled(false);
         txtOS.setEnabled(false);
         nivel.setEnabled(false);
         txtOS.setEnabled(false);
         txtTutor.setEnabled(false);
         parentescotxt.setEnabled(false);
         gradotxt.setEnabled(false);
         ((JTextField) dateFecha.getDateEditor().getUiComponent()).setEditable(false); // desactiva el campo de texxto del choooser, para que unicamente solo pueda poner la fecha desde el calendario
         
         
    }
 
 
 
 void validarRangoFecha(){
      // Configurar rango de fechas para la fecha de nacimiento
    Date hoy = new Date();
    dateFecha.setMaxSelectableDate(hoy); // la fecha maxima que puede elegir es hoy, despues de eso no hay

    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.YEAR, -20); // hace 100 años
    dateFecha.setMinSelectableDate(cal.getTime());

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
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombretxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        apellidotxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dnitxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        escuelatxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        parentescotxt = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        nivel = new javax.swing.JComboBox<>();
        txtOS = new javax.swing.JTextField();
        codA = new javax.swing.JLabel();
        gradotxt = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        labelCodigoOS = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        txtTutor = new javax.swing.JTextField();
        labelCodigoTutor = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        dateFecha = new com.toedter.calendar.JDateChooser();
        jPanel6 = new javax.swing.JPanel();
        buscar = new javax.swing.JLabel();
        cancelar = new javax.swing.JLabel();
        modificar = new javax.swing.JLabel();
        guardar = new javax.swing.JLabel();
        recargar = new javax.swing.JLabel();
        mas = new javax.swing.JLabel();
        eliminar = new javax.swing.JLabel();
        habilitar = new javax.swing.JLabel();
        inactivo = new javax.swing.JCheckBox();
        txtNombreBuscador = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaAlumno = new javax.swing.JTable();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(598, 525));

        jPanel5.setBackground(new java.awt.Color(255, 102, 102));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(1000, 70));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registrar Alumno");

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
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        jLabel7.setBackground(new java.awt.Color(255, 102, 51));
        jLabel7.setForeground(new java.awt.Color(255, 102, 51));
        jLabel7.setText("*******************************************************");

        jLabel2.setBackground(new java.awt.Color(255, 102, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre:");

        nombretxt.setBackground(new java.awt.Color(255, 204, 204));
        nombretxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nombretxt.setForeground(new java.awt.Color(255, 51, 102));
        nombretxt.setBorder(null);
        nombretxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombretxtKeyTyped(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 102, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Apellido:");

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
        jLabel8.setText("*******************************************************");

        jLabel4.setBackground(new java.awt.Color(255, 102, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Fecha Nac:");

        jLabel9.setBackground(new java.awt.Color(255, 102, 51));
        jLabel9.setForeground(new java.awt.Color(255, 102, 51));
        jLabel9.setText("*******************************************************");

        jLabel5.setBackground(new java.awt.Color(255, 102, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("DNI:");

        dnitxt.setBackground(new java.awt.Color(255, 204, 204));
        dnitxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dnitxt.setForeground(new java.awt.Color(255, 51, 102));
        dnitxt.setBorder(null);
        dnitxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dnitxtKeyTyped(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 102, 51));
        jLabel10.setForeground(new java.awt.Color(255, 102, 51));
        jLabel10.setText("*******************************************************");

        jLabel6.setBackground(new java.awt.Color(255, 102, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Escuela:");

        escuelatxt.setBackground(new java.awt.Color(255, 204, 204));
        escuelatxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        escuelatxt.setForeground(new java.awt.Color(255, 51, 102));
        escuelatxt.setBorder(null);
        escuelatxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                escuelatxtKeyTyped(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(255, 102, 51));
        jLabel11.setForeground(new java.awt.Color(255, 102, 51));
        jLabel11.setText("*******************************************************");

        jLabel12.setBackground(new java.awt.Color(255, 102, 0));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Grado:");

        jLabel13.setBackground(new java.awt.Color(255, 102, 51));
        jLabel13.setForeground(new java.awt.Color(255, 102, 51));
        jLabel13.setText("*******************************************************");

        jLabel15.setBackground(new java.awt.Color(255, 102, 0));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Parentesco:");

        jLabel17.setBackground(new java.awt.Color(255, 102, 0));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Nivel:");

        jLabel20.setBackground(new java.awt.Color(255, 102, 0));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Obra Social:");

        jLabel21.setBackground(new java.awt.Color(255, 102, 0));
        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Tutor:");

        parentescotxt.setBackground(new java.awt.Color(255, 204, 204));
        parentescotxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        parentescotxt.setForeground(new java.awt.Color(255, 51, 102));
        parentescotxt.setBorder(null);
        parentescotxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                parentescotxtKeyTyped(evt);
            }
        });

        jLabel22.setBackground(new java.awt.Color(255, 102, 51));
        jLabel22.setForeground(new java.awt.Color(255, 102, 51));
        jLabel22.setText("*******************************************************");

        nivel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nivel.setForeground(new java.awt.Color(0, 0, 0));
        nivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Inicial", "Primario", "Secundario" }));

        txtOS.setBackground(new java.awt.Color(255, 204, 204));
        txtOS.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtOS.setForeground(new java.awt.Color(255, 51, 102));
        txtOS.setBorder(null);

        codA.setForeground(new java.awt.Color(0, 0, 0));

        gradotxt.setBackground(new java.awt.Color(255, 204, 204));
        gradotxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        gradotxt.setForeground(new java.awt.Color(255, 51, 102));
        gradotxt.setBorder(null);
        gradotxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                gradotxtKeyTyped(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(255, 102, 51));
        jLabel16.setForeground(new java.awt.Color(255, 102, 51));
        jLabel16.setText("*******************************************************");

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel23.setBackground(new java.awt.Color(255, 102, 51));
        jLabel23.setForeground(new java.awt.Color(255, 102, 51));
        jLabel23.setText("*******************************************************");

        txtTutor.setBackground(new java.awt.Color(255, 204, 204));
        txtTutor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTutor.setForeground(new java.awt.Color(255, 51, 102));
        txtTutor.setBorder(null);

        jButton2.setText("...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel5)
                        .addGap(36, 36, 36)
                        .addComponent(dnitxt, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(484, 484, 484))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21)
                        .addGap(472, 472, 472))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel3))
                        .addGap(475, 475, 475))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(escuelatxt))
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(7, 7, 7)))
                                .addGap(323, 323, 323))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(gradotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(jLabel13)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(codA, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(labelCodigoTutor, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelCodigoOS, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(nombretxt, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1112, Short.MAX_VALUE)
                                        .addComponent(jLabel17))
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(45, 45, 45))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel20))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(parentescotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtOS, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTutor, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)))
                        .addGap(87, 87, 87))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(apellidotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelCodigoOS, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel7))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(nombretxt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(nivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(apellidotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20)
                                    .addComponent(txtOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel16)))
                            .addComponent(jLabel3))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(txtTutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel23))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jButton2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel21)
                                            .addComponent(jLabel4))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel22)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(dnitxt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15)
                                .addComponent(parentescotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(escuelatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel11)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(gradotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(labelCodigoTutor, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel13))))
                    .addComponent(codA, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 102, 102));

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/Buscar_1.png"))); // NOI18N
        buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buscarMouseEntered(evt);
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

        recargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/recargar.png"))); // NOI18N
        recargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recargarMouseClicked(evt);
            }
        });

        mas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        mas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                masMouseClicked(evt);
            }
        });

        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/e.png"))); // NOI18N
        eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarMouseClicked(evt);
            }
        });

        habilitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/activo1.png"))); // NOI18N
        habilitar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                habilitarMouseClicked(evt);
            }
        });

        inactivo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        inactivo.setForeground(new java.awt.Color(255, 255, 255));
        inactivo.setText("Inactivos");
        inactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inactivoActionPerformed(evt);
            }
        });

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

        jButton4.setText("GENERAR REPORTE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(recargar)
                .addGap(76, 76, 76)
                .addComponent(mas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(modificar)
                .addGap(68, 68, 68)
                .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(habilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(inactivo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(cancelar)
                .addGap(78, 78, 78)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscar)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(txtNombreBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(recargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(mas))
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(guardar)
                            .addComponent(eliminar)
                            .addComponent(modificar)
                            .addComponent(habilitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cancelar, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(inactivo)
                .addGap(21, 21, 21))
        );

        TablaAlumno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Fecha Nac", "DNI", "Escuela", "Grado", "Nivel", "Obra Social", "Nombre del Tutor", "Apellido del Tutor ", "Teléfono Tutor", "Parentesco"
            }
        ));
        TablaAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaAlumnoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaAlumno);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1960, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        add(jPanel1, "modificarA");
    }// </editor-fold>//GEN-END:initComponents

    private void guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarMouseClicked
       
        
          
       
    
        try{
        
                if(nombretxt.getText().isEmpty() || apellidotxt.getText().isEmpty() || dateFecha.getDate()==null || dnitxt.getText().isEmpty() || escuelatxt.getText().isEmpty() || gradotxt.getText().isEmpty() || nivel.getSelectedItem().equals("Seleccionar") || txtTutor.getText().isEmpty() || parentescotxt.getText().isEmpty()){
                       JOptionPane.showMessageDialog(null, "Algunos campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                       return; // Detiene la ejecución del método
                }          
      
                int dni= Integer.parseInt(dnitxt.getText());
                String niveles=nivel.getSelectedItem().toString(); // cua
                String A= codA.getText();
                String Nombre= nombretxt.getText();
                String Apellido=apellidotxt.getText();
                Date fecha = dateFecha.getDate(); //obtenemos la fecha que esta en formato dd-mm-aaaa
                String Escuela=escuelatxt.getText();
                String Grado= gradotxt.getText();
                String Parentesco= parentescotxt.getText();   
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                String fechaSQL = formato.format(fecha); ///pasamos nuestra fecha a formato base de datos para poder hacer el insert

                
                if(!codA.getText().isEmpty()){
                         int codigoOS=0;
                         int codigoT=0;
                         int filaSeleccionada = TablaAlumno.getSelectedRow();
                         String os =TablaAlumno.getValueAt(filaSeleccionada, 7).toString();
                  
                           ////////////verificar si el label del codigo OS esta vacio, si es asi se le pone el codigo de la OS que ya tiene, buscando el codigo de su OS a traves de la tabla, en donde esta el nombre, asi obtendremos el codigo de su OS
                          if( labelCodigoOS.getText().isEmpty()){
                                      if(os.equalsIgnoreCase("Sin Obra Social")){
                                            codigoOS=0;
                                      }else{
                                            codigoOS=Clases.ObraSocial.obtenerCodigo(cx,os );
                                            labelCodigoOS.setText(String.valueOf(codigoOS));
                                            codigoOS= Integer.parseInt(labelCodigoOS.getText());
                                      }
                           }else{
                   
                                      codigoOS=Integer.parseInt(labelCodigoOS.getText());
                           }
      
                           /////////////verificar si el label del codigo tutor esta vacio, si es asi se le pone el codigo del tutor que ya tiene, buscando el codigo de su tutor a traves de la tabla, especifacamente por el telefono
                           if(labelCodigoTutor.getText().isEmpty() ){
                                     String telefono_tutor =TablaAlumno.getValueAt(filaSeleccionada, 10).toString();
                                     codigoT=Clases.Tutor.obtenerCodigo(cx, telefono_tutor);
                                     labelCodigoTutor.setText(String.valueOf(codigoT));
                                     codigoT=Integer.parseInt(labelCodigoTutor.getText());
                     
                           }else{ /////////en caso de que este lleno, es porque ya previamente el usuario selecciono un nuevo tutor, por lo tanto el label quedo con ese el codigo del nuevo tutor
                      
                                     codigoT=Integer.parseInt(labelCodigoTutor.getText());
                      
                           }
                           Clases.Alumno.actualizarAlumno(cx, Nombre, Apellido, fechaSQL, dni, Escuela, Grado, niveles, codigoOS, Integer.parseInt(A));
                           Clases.Alumno.modificaralumno_tutor(cx,codigoT , Parentesco,  Integer.parseInt(A) );
                           JOptionPane.showMessageDialog(null, "Los datos se actualizaron correctamente"); 
                           MostrarAlumno();
                           limpiar();
                           desactivarCampo();
                       
                  
                  
                    
                    
                    
                
                
                
                } else{ 
                            int codigoOS;
                            if(labelCodigoOS.getText().isEmpty()){
                                      codigoOS=0;
                            }else{
                                      codigoOS=Integer.parseInt(labelCodigoOS.getText());
                            }
                     
                            int codigo_tutor=Integer.parseInt(labelCodigoTutor.getText());
                            Clases.Alumno.cargar(cx, Nombre, Apellido, fechaSQL, dni, Escuela, Grado, niveles, codigoOS);
                            int codigoAlumno=Clases.Alumno.obtenerCodigo(cx, dni);
                            Clases.Alumno.cargarAlumnoTutor(cx, codigoAlumno, codigo_tutor, Parentesco);
                            JOptionPane.showMessageDialog(null, "Se ha cargado correctamente al alumno"); 
                            MostrarAlumno();
                            limpiar();
                            desactivarCampo();
                 }
             
        }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar cargar o actualizar los datos","ERROR",ERROR_MESSAGE);

            MostrarAlumno();
           
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
            
    }//GEN-LAST:event_guardarMouseClicked

    private void eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarMouseClicked
        try{
             int codigo=Integer.parseInt(codA.getText());
             int filaSeleccionada = TablaAlumno.getSelectedRow();
             String dni =TablaAlumno.getValueAt(filaSeleccionada, 3).toString(); /// obtenemos el dni del alumno seleccionado en la tabla
             rs=Clases.Pago.verPagosPendientesAlumno(cx,Integer.parseInt(dni) );  /// vemos si este dni(alumno) tiene pagos pendientes..
             
             /// si tiene registros, es que por que tiene pagos pendientes, por lo tanto el sistema no le permitirá dar de baja al alumno no sin antes haber saldado los meses que debe
             while(rs.next()){
                  JOptionPane.showMessageDialog(null, "El alumno que trata de eliminar tiene pagos pendientes de un servicio mensual, el sistema no permite dar de baja a alumnos con cuotas sin saldar","ERROR",ERROR_MESSAGE);
                  return;
             }
                 
             int respuesta = JOptionPane.showConfirmDialog( null, "¿Estás seguro de que deseas eliminar a este alumno?" , "Confirmar eliminación", JOptionPane.YES_NO_OPTION , JOptionPane.WARNING_MESSAGE);
        
             if (respuesta == JOptionPane.YES_OPTION) {
                           Clases.Inscripcion.darBajaInscripcion(cx, codigo);  // dar de baja insccripcion activa del alumno antes de darlo de baja a él
                           Clases.Alumno.eliminar(cx, codigo);
                           
                           JOptionPane.showMessageDialog(null, "Se ha eliminado al alumno correctamente");
                           MostrarAlumno();
                           limpiar();
                  
             }else{
                           JOptionPane.showMessageDialog(null, "Se ha cancelado la eliminación");
                           MostrarAlumno();
                          limpiar();
                           
                          
             }
        }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar eliminar el alumno","ERROR",ERROR_MESSAGE);
        }
       
    }//GEN-LAST:event_eliminarMouseClicked

    private void inactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inactivoActionPerformed
        
        if(inactivo.isSelected()){
            
            MostrarAlumnoInactivo();
            
            
            
        
        }else{
            desactivarhabilitar();
            MostrarAlumno();
        }
        
       
        
    }//GEN-LAST:event_inactivoActionPerformed

    private void habilitarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_habilitarMouseClicked
        
        int codigo=Integer.parseInt(codA.getText());
        int respuesta = JOptionPane.showConfirmDialog( null, "¿Estás seguro de que deseas habilitar a este alumno?" , "Confirmar habilitación", JOptionPane.YES_NO_OPTION , JOptionPane.WARNING_MESSAGE);
        
         if (respuesta == JOptionPane.YES_OPTION) {
                  try{
                           Clases.Alumno.HabilitarA(cx, codigo);
                           JOptionPane.showMessageDialog(null, "Se ha habilitado al alumno correctamente");
                           MostrarAlumnoInactivo();
                           
                  }catch(Exception e){
            
                            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar habilitar el alumno","ERROR",ERROR_MESSAGE);
                  }
         }else{
             JOptionPane.showMessageDialog(null, "Se ha cancelado");
            MostrarAlumno();
         }
        
        
        
        
        
        
    }//GEN-LAST:event_habilitarMouseClicked

    private void TablaAlumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaAlumnoMouseClicked
        
        try{
            int filaSeleccionada = TablaAlumno.getSelectedRow();
            
            String nombre =TablaAlumno.getValueAt(filaSeleccionada, 0).toString();
            String apellido =TablaAlumno.getValueAt(filaSeleccionada, 1).toString();
            String fecha =TablaAlumno.getValueAt(filaSeleccionada, 2).toString();
            String dni=TablaAlumno.getValueAt(filaSeleccionada, 3).toString();
            String escuela =TablaAlumno.getValueAt(filaSeleccionada, 4).toString();
            String grado =TablaAlumno.getValueAt(filaSeleccionada, 5).toString();
            String nivele =TablaAlumno.getValueAt(filaSeleccionada, 6).toString();
            Object valorObraSocial=TablaAlumno.getValueAt(filaSeleccionada, 7).toString();
            String nombre_tutor =TablaAlumno.getValueAt(filaSeleccionada, 8).toString();
            String apellido_tutor =TablaAlumno.getValueAt(filaSeleccionada, 9).toString();
            String telefono_tutor =TablaAlumno.getValueAt(filaSeleccionada, 10).toString();
            String parentesco =TablaAlumno.getValueAt(filaSeleccionada, 11).toString();
            if(inactivo.isSelected()){
                activarhabilitar();
            }else{
                desactivarMas();
                desactivarguardar();
                
                  try{
                     int codigo= Clases.Alumno.obtenerCodigo(cx, Integer.parseInt(dni));
                     codA.setText(String.valueOf(codigo));   //pone el codigo del alumno en el label prueba
                  }catch(Exception e){
                     JOptionPane.showMessageDialog(null, "Error al intentar obtener el codigo del alumno");   
                  }
                  String apenomTutor=nombre_tutor+" "+apellido_tutor;
            
                  nombretxt.setText(nombre);
                  apellidotxt.setText(apellido);
                  // 1️ Convertir el texto de la base a Date
                  SimpleDateFormat formatoBD = new SimpleDateFormat("yyyy-MM-dd");
                  Date fechaConvertida = formatoBD.parse(fecha);

                  //  Mostrar esa fecha en el JDateChooser
                  dateFecha.setDate(fechaConvertida);

                   //  Cambiar el formato visible del JDateChooser (esto es lo que lo hace "legible")
                  dateFecha.setDateFormatString("dd-MM-yyyy");

                  dnitxt.setText(dni);
            
                  escuelatxt.setText(escuela);
                  gradotxt.setText(grado);
                  nivel.setSelectedItem(nivele);
                  txtTutor.setText(apenomTutor);
                  parentescotxt.setText(parentesco);
            
        
                   boolean o_s=valorObraSocial==null;
                   if (o_s==true){
                     txtOS.setText("Sin Obra Social");
                   }else{
                     txtOS.setText(valorObraSocial.toString());
                   }
           
                   activarmodificar();
                   activareliminar();
            
            }
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, "No hay datos en la tabla","ERROR",ERROR_MESSAGE);

            
      }
            
          
          
    }//GEN-LAST:event_TablaAlumnoMouseClicked

    private void buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarMouseClicked
       try{
        desactivarhabilitar();
       
         
         
        tabla.setRowCount(0);  
        tabla.setColumnCount(0);
         tabla.addColumn("Nombre");  
         tabla.addColumn("Apellido"); 
         tabla.addColumn("Fecha Nacimiento"); 
         tabla.addColumn("DNI"); 
         tabla.addColumn("Escuela"); 
         tabla.addColumn("Grado");
         tabla.addColumn("Nivel");
         tabla.addColumn("Obra Social");
         tabla.addColumn("Nombre del Tutor");
         tabla.addColumn("Apellido del Tutor");
         tabla.addColumn("Parentesco");
        
         
         
            
             rs=Clases.Alumno.buscarAlumno(cx, txtNombreBuscador.getText());
               while(rs.next()){
                   datos[0]=rs.getString("al.nombre");
                   datos[1]=rs.getString("al.apellido");
                   datos[2]=rs.getString("al.fecha_nac");
                   datos[3]=rs.getString("al.dni");
                   datos[4]=rs.getString("al.escuela");
                   datos[5]=rs.getString("al.grado");
                   datos[6]=rs.getString("al.nivel");
                   datos[7]=rs.getString("os.nombre");
                   datos[8]=rs.getString("t.nombre");
                   datos[9]=rs.getString("t.apellido");
                   datos[10]=rs.getString("at.parentesco");
                 
                        if(datos[7]==null){
                      datos[7]="Sin Obra Social";
                  }
                   tabla.addRow(datos);
                   
                   
              }  
               TablaAlumno.setModel(tabla);
              
          }catch(Exception e){
                   JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar el alumno","ERROR",ERROR_MESSAGE); 
          }  
        
      
        
    }//GEN-LAST:event_buscarMouseClicked

    public void setTxtOS(String nombre) {
        txtOS.setText(nombre);
    }

    public void setLabelCodigoOS(String nombre) {
        labelCodigoOS.setText(nombre);
    }

    public void setLabelCodigoTutor(String nombre) {
        labelCodigoTutor.setText(nombre);
    }

    public void setTxtTutor(String nombre) {
        txtTutor.setText(nombre);
    }

    private void txtNombreBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreBuscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreBuscadorActionPerformed

    private void recargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recargarMouseClicked
        MostrarAlumno();
        txtNombreBuscador.setText("");
        desactivarhabilitar();
    }//GEN-LAST:event_recargarMouseClicked

    private void cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarMouseClicked
        limpiar();
       desactivarmodificar();
       desactivareliminar();
       desactivarguardar();
       desactivarCampo();
       activarMas();
       codA.setText(" ");
    }//GEN-LAST:event_cancelarMouseClicked

    private void masMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masMouseClicked
       activarguardar();
       activarCampo();
       desactivarMas();
       desactivarmodificar();
       desactivareliminar();
       
    }//GEN-LAST:event_masMouseClicked

    private void modificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modificarMouseClicked
        activarCampo();
        desactivarmodificar();
        activarguardar();
        desactivareliminar();
        
    }//GEN-LAST:event_modificarMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
       
buscarObraSocial dialog = new buscarObraSocial(frame, true, this);
dialog.setVisible(true);  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
           JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
       
buscarTutor dialog = new buscarTutor(frame, true, this);
dialog.setVisible(true);  
    }//GEN-LAST:event_jButton2ActionPerformed

    private void buscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarMouseEntered

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

    private void escuelatxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_escuelatxtKeyTyped
        char c=evt.getKeyChar();
         // verificar si el carácter ingresado es unicamente letra y numeros
      if ((!Character.isLetter(c) &&  !Character.isDigit(c) && c != ' ') || escuelatxt.getText().length()>40) {
        evt.consume(); 
    }  
    }//GEN-LAST:event_escuelatxtKeyTyped

    private void gradotxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gradotxtKeyTyped
         char c=evt.getKeyChar();
         // verificar si el carácter ingresado es unicamente letra y numeros
      if ((!Character.isLetter(c) &&  !Character.isDigit(c)) || gradotxt.getText().length()>20) {
        evt.consume(); 
    }  
    }//GEN-LAST:event_gradotxtKeyTyped

    private void parentescotxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_parentescotxtKeyTyped
       char c=evt.getKeyChar();
         // verificar si el carácter ingresado es unicamente letra
      if (!Character.isLetter(c) || parentescotxt.getText().length()>20) {
        evt.consume(); 
    }  
    }//GEN-LAST:event_parentescotxtKeyTyped

    private void txtNombreBuscadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreBuscadorKeyTyped
         char c=evt.getKeyChar();
         // verificar si el carácter ingresado es unicamente letra
      if ((!Character.isLetter(c) && c != ' ')|| txtNombreBuscador.getText().length()>20) {
        evt.consume(); 
    }  
    }//GEN-LAST:event_txtNombreBuscadorKeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
   try {
               //  Ruta donde se guardará el PDF (en el Escritorio del usuario)
               String ruta = System.getProperty("user.home") + "\\Downloads\\REPORTES\\ALUMNOS\\reporteAlumnos.pdf";


               // Crear el documento en formato A4 horizontal (más ancho para las tablas)
               Document documento = new Document(PageSize.A4.rotate());

               // Asociar el documento con un "escritor" que lo guardará en la ruta indicada
               PdfWriter.getInstance(documento, new FileOutputStream(ruta));

               // Abrir el documento para comenzar a escribir contenido en él
               documento.open();

   
               //ENCABEZADO DEL DOCUMENTO
               // Título centrado y en negrita
               Paragraph titulo = new Paragraph("Reporte de Alumnos Activos",
               FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));
               titulo.setAlignment(Element.ALIGN_CENTER);
               documento.add(titulo);

               //  Subtítulo e información adicional
               documento.add(new Paragraph("Instituto Pedagógico Despertando Sueños"));
               documento.add(new Paragraph("Fecha: " + LocalDate.now()));
               documento.add(new Paragraph("\nListado de alumnos activos:\n"));

   
               //  CREACIÓN DE LA TABLA PDF
               // Crear una tabla con 11 columnas
               PdfPTable tablaPDF = new PdfPTable(13);
               tablaPDF.setWidthPercentage(100);   // Ocupa el ancho total de la página
               tablaPDF.setSpacingBefore(10f);     // Espacio antes de la tabla
               tablaPDF.setSpacingAfter(10f);      // Espacio después de la tabla

               // Nombres de las columnas
               String[] columnas = {
                  "Nombre Alumno", "Apellido Alumno", "Fecha de Nacimiento", "DNI", "Escuela",
                  "Grado", "Nivel", "Obra Social",
                  "Nombre Tutor", "Apellido Tutor", "Teléfono Tutor", "Parentesco", "Estado"
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
                           // Se llama al método del modelo que devuelve los alumnos activos
                           rs = Clases.Alumno.mostrarAlumnos(cx);

                           // Se recorre cada fila del ResultSet y se agregan las celdas a la tabla
                          while (rs.next()) {
                            tablaPDF.addCell(new Phrase(rs.getString("al.nombre"), fontData));          // 1
                            tablaPDF.addCell(new Phrase(rs.getString("al.apellido"), fontData));        // 2
                            tablaPDF.addCell(new Phrase(rs.getString("al.fecha_nac"), fontData));       // 3
                            tablaPDF.addCell(new Phrase(rs.getString("al.dni"), fontData));             // 4
                            tablaPDF.addCell(new Phrase(rs.getString("al.escuela"), fontData));         // 5
                            tablaPDF.addCell(new Phrase(rs.getString("al.grado"), fontData));           // 6 ← Faltaba
                            tablaPDF.addCell(new Phrase(rs.getString("al.nivel"), fontData));           // 7
                            tablaPDF.addCell(new Phrase(rs.getString("os.nombre"), fontData));          // 8
                            tablaPDF.addCell(new Phrase(rs.getString("t.nombre"), fontData));           // 9
                            tablaPDF.addCell(new Phrase(rs.getString("t.apellido"), fontData));         // 10
                            tablaPDF.addCell(new Phrase(rs.getString("t.telefono"), fontData));         // 11
                            tablaPDF.addCell(new Phrase(rs.getString("at.parentesco"), fontData));      // 12
                            int estado=rs.getInt("al.borrado");
                            if(estado==0){
                                tablaPDF.addCell(new Phrase("ACTIVO", fontData));      // 13
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
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaAlumno;
    private javax.swing.JTextField apellidotxt;
    private javax.swing.JLabel buscar;
    private javax.swing.JLabel cancelar;
    private javax.swing.JLabel codA;
    private com.toedter.calendar.JDateChooser dateFecha;
    private javax.swing.JTextField dnitxt;
    private javax.swing.JLabel eliminar;
    private javax.swing.JTextField escuelatxt;
    private javax.swing.JTextField gradotxt;
    private javax.swing.JLabel guardar;
    private javax.swing.JLabel habilitar;
    private javax.swing.JCheckBox inactivo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCodigoOS;
    private javax.swing.JLabel labelCodigoTutor;
    private javax.swing.JLabel mas;
    private javax.swing.JLabel modificar;
    private javax.swing.JComboBox<String> nivel;
    private javax.swing.JTextField nombretxt;
    private javax.swing.JTextField parentescotxt;
    private javax.swing.JLabel recargar;
    private javax.swing.JTextField txtNombreBuscador;
    private javax.swing.JTextField txtOS;
    private javax.swing.JTextField txtTutor;
    // End of variables declaration//GEN-END:variables
}
