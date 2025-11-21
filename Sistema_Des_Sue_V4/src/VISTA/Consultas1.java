
package VISTA;

import VISTA.consultas3;
import VISTA.consultas4;
import VISTA.consultas2;
import VISTA.ABMs.ModificarP;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import VISTA.Panel3;
import VISTA.Panel4;


public class Consultas1 extends javax.swing.JPanel {
CardLayout cardLayout;
    public Consultas1() {
        initComponents();
        
         circular.setLayout(new java.awt.BorderLayout());
       alumno.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            actualizar();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            actualizar();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
           
        }
    });
        
        Panel3 frmAlumno = new Panel3();
int cantidadDocentes = frmAlumno.getCantidadI(); // Método que devuelve tblDocentes.getRowCount()
alumno.setText(String.valueOf(cantidadDocentes));

        alumno.setEditable(false);
        
        cardLayout = (CardLayout)(contenedor.getLayout());
        
        
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
    
      public void actualizar(){
     
      String texto = alumno.getText().trim();

    if (texto.isEmpty()) {
        circular.removeAll();
        circular.revalidate();
        circular.repaint();
        return;
    }

    try {
        int cantidadAlumnos = Integer.parseInt(texto);
        int restante = 60 - cantidadAlumnos;

        if (restante < 0) {
            restante = 0; // Evita valores negativos
        }

        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Alumnos", cantidadAlumnos);
        dataset.setValue("Restante", restante);

        JFreeChart chart = ChartFactory.createPieChart(
                "Matricula de Alumnos Inscriptos", dataset, true, true, false);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(400,200));
        chartPanel.setMouseWheelEnabled(true);
        circular.removeAll();  // ✅ PRIMERO LIMPIAMOS
        circular.add(chartPanel, java.awt.BorderLayout.CENTER); // ✅ SIEMPRE EN CENTER
        circular.revalidate(); // ✅ ACTUALIZAR PANEL
        circular.repaint();    // ✅ REDIBUJAR SOLO PANEL


    

    } catch (NumberFormatException ex) {
        // Si se ingresa letra o símbolo
        circular.removeAll();
        circular.revalidate();
        circular.repaint();
    }  
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new FondoPanel2();
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        panel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        AlumnoCantidad = new javax.swing.JButton();
        AlumnoServicio = new javax.swing.JButton();
        AlumnoNivel = new javax.swing.JButton();
        AlumnoProfesor = new javax.swing.JButton();
        contenedor = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        alumno = new javax.swing.JTextField();
        circular = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISTA/Imagenes/soll.gif"))); // NOI18N
        jLabel19.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Consultas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(30, Short.MAX_VALUE))
        );

        panel1.setBackground(new java.awt.Color(255, 153, 153));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ver Cantidad de Alumno Inscripto");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Ver Alumnos por servicios");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ver Alumno por nivel");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ver cantidad de alumnos por profesores");

        AlumnoCantidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISTA/Imagenes/chat.png"))); // NOI18N
        AlumnoCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlumnoCantidadActionPerformed(evt);
            }
        });

        AlumnoServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISTA/Imagenes/chat.png"))); // NOI18N
        AlumnoServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlumnoServicioActionPerformed(evt);
            }
        });

        AlumnoNivel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISTA/Imagenes/chat.png"))); // NOI18N
        AlumnoNivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlumnoNivelActionPerformed(evt);
            }
        });

        AlumnoProfesor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/VISTA/Imagenes/chat.png"))); // NOI18N
        AlumnoProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlumnoProfesorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AlumnoCantidad)
                .addGap(31, 31, 31)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AlumnoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(AlumnoNivel)
                .addGap(23, 23, 23)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AlumnoProfesor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AlumnoCantidad)
                    .addComponent(AlumnoServicio)
                    .addComponent(AlumnoNivel)
                    .addComponent(AlumnoProfesor))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        contenedor.setBackground(new java.awt.Color(255, 255, 255));
        contenedor.setLayout(new java.awt.CardLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("CANTIDAD DE ALUMNOS INSCRIPTOS:");

        alumno.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        alumno.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout circularLayout = new javax.swing.GroupLayout(circular);
        circular.setLayout(circularLayout);
        circularLayout.setHorizontalGroup(
            circularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 836, Short.MAX_VALUE)
        );
        circularLayout.setVerticalGroup(
            circularLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 315, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(alumno, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(circular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(90, 90, 90))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(circular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );

        contenedor.add(jPanel4, "uno");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1, "consulta");
    }// </editor-fold>//GEN-END:initComponents

    private void AlumnoServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlumnoServicioActionPerformed
       consultas2 as = new consultas2(); 
        contenedor.add(as,"dos");
        contenedor.getLayout();
        cardLayout.show(contenedor, "dos");
   
    }//GEN-LAST:event_AlumnoServicioActionPerformed

    private void AlumnoNivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlumnoNivelActionPerformed
       consultas3 an= new consultas3();
        contenedor.add(an,"tres");
        contenedor.getLayout();
        cardLayout.show(contenedor, "tres");
    }//GEN-LAST:event_AlumnoNivelActionPerformed

    private void AlumnoProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlumnoProfesorActionPerformed
       consultas4 ap= new consultas4();
        contenedor.add(ap,"cuatro");
        contenedor.getLayout();
        cardLayout.show(contenedor, "cuatro");  
        
    }//GEN-LAST:event_AlumnoProfesorActionPerformed

    private void AlumnoCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlumnoCantidadActionPerformed
         cardLayout.show(contenedor, "uno");
    }//GEN-LAST:event_AlumnoCantidadActionPerformed

  public class EjemploCardLayout extends JFrame{
       public EjemploCardLayout(){
           CardLayout cardLayout= new CardLayout();
           getContentPane().setLayout(cardLayout);
       } 
    
    
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AlumnoCantidad;
    private javax.swing.JButton AlumnoNivel;
    private javax.swing.JButton AlumnoProfesor;
    private javax.swing.JButton AlumnoServicio;
    private javax.swing.JTextField alumno;
    private javax.swing.JPanel circular;
    private javax.swing.JPanel contenedor;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel panel1;
    // End of variables declaration//GEN-END:variables
}
