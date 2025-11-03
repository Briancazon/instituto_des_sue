
package prueba_sistema;



import Alumno.ModificarA;
import Consultas.Consultas1;
import Gastos.Gastos;
import ObraSocial.OS;
import Profesores.ModificarP;
import Tutores.ModificarT;
import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;

import java.awt.CardLayout;
import java.awt.Color;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import javax.swing.JPanel;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Menu extends javax.swing.JFrame {

  FondoPanel fondo= new FondoPanel();
  FondoPanel2 fondo2=new FondoPanel2();
  CardLayout cardLayout;
   
    public Menu() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

     
        
        cardLayout = (CardLayout)(contenedor.getLayout());
        
        
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        serviciobt = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pagoinsbt = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        pagobt = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        insbt = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        asistencia = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        contenedor = new javax.swing.JPanel();
        panel1 = new FondoPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();

        jMenu5.setText("jMenu5");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 650));
        setResizable(false);

        jPanel5.setBackground(new java.awt.Color(255, 102, 102));
        jPanel5.setPreferredSize(new java.awt.Dimension(200, 800));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/hm.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        serviciobt.setBackground(new java.awt.Color(255, 102, 102));
        serviciobt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                serviciobtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                serviciobtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                serviciobtMouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Servicios");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salon-de-clases.png"))); // NOI18N
        jLabel7.setText("jLabel7");

        javax.swing.GroupLayout serviciobtLayout = new javax.swing.GroupLayout(serviciobt);
        serviciobt.setLayout(serviciobtLayout);
        serviciobtLayout.setHorizontalGroup(
            serviciobtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(serviciobtLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel2)
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(serviciobtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(serviciobtLayout.createSequentialGroup()
                    .addGap(60, 60, 60)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(78, Short.MAX_VALUE)))
        );
        serviciobtLayout.setVerticalGroup(
            serviciobtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(serviciobtLayout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
            .addGroup(serviciobtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(serviciobtLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel7)
                    .addContainerGap(36, Short.MAX_VALUE)))
        );

        pagoinsbt.setBackground(new java.awt.Color(255, 102, 102));
        pagoinsbt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pagoinsbtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pagoinsbtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pagoinsbtMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Pago de Instalacion");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/instalaciones.png"))); // NOI18N
        jLabel10.setText("jLabel7");

        javax.swing.GroupLayout pagoinsbtLayout = new javax.swing.GroupLayout(pagoinsbt);
        pagoinsbt.setLayout(pagoinsbtLayout);
        pagoinsbtLayout.setHorizontalGroup(
            pagoinsbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pagoinsbtLayout.createSequentialGroup()
                .addGroup(pagoinsbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pagoinsbtLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pagoinsbtLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pagoinsbtLayout.setVerticalGroup(
            pagoinsbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pagoinsbtLayout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        pagobt.setBackground(new java.awt.Color(255, 102, 102));
        pagobt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pagobtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pagobtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pagobtMouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Pago de Cuotas");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/dinero-en-efectivo.png"))); // NOI18N
        jLabel9.setText("jLabel7");

        javax.swing.GroupLayout pagobtLayout = new javax.swing.GroupLayout(pagobt);
        pagobt.setLayout(pagobtLayout);
        pagobtLayout.setHorizontalGroup(
            pagobtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pagobtLayout.createSequentialGroup()
                .addGroup(pagobtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pagobtLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pagobtLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pagobtLayout.setVerticalGroup(
            pagobtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pagobtLayout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        insbt.setBackground(new java.awt.Color(255, 102, 102));
        insbt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insbtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                insbtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                insbtMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Realizar Inscripción");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inscripto .png"))); // NOI18N
        jLabel8.setText("jLabel7");

        javax.swing.GroupLayout insbtLayout = new javax.swing.GroupLayout(insbt);
        insbt.setLayout(insbtLayout);
        insbtLayout.setHorizontalGroup(
            insbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(insbtLayout.createSequentialGroup()
                .addGroup(insbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(insbtLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3))
                    .addGroup(insbtLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        insbtLayout.setVerticalGroup(
            insbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, insbtLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        asistencia.setBackground(new java.awt.Color(255, 102, 102));
        asistencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                asistenciaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                asistenciaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                asistenciaMouseExited(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Asistencias");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ausencia.png"))); // NOI18N
        jLabel12.setText("jLabel7");

        javax.swing.GroupLayout asistenciaLayout = new javax.swing.GroupLayout(asistencia);
        asistencia.setLayout(asistenciaLayout);
        asistenciaLayout.setHorizontalGroup(
            asistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(asistenciaLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(asistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        asistenciaLayout.setVerticalGroup(
            asistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(asistenciaLayout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pagoinsbt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1))
                    .addComponent(serviciobt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(insbt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pagobt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(asistencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(serviciobt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(insbt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pagobt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(pagoinsbt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(asistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5, java.awt.BorderLayout.WEST);

        contenedor.setBackground(new java.awt.Color(255, 255, 255));
        contenedor.setPreferredSize(new java.awt.Dimension(700, 525));
        contenedor.setLayout(new java.awt.CardLayout());

        panel1.setBackground(new java.awt.Color(204, 204, 255));
        panel1.setPreferredSize(new java.awt.Dimension(900, 525));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 794, Short.MAX_VALUE)
        );

        contenedor.add(panel1, "uno");

        getContentPane().add(contenedor, java.awt.BorderLayout.CENTER);

        jMenuBar1.setBackground(new java.awt.Color(255, 204, 204));
        jMenuBar1.setForeground(new java.awt.Color(0, 0, 0));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/alumno.png"))); // NOI18N
        jMenu1.setText("Alumnos");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/profesor.png"))); // NOI18N
        jMenu2.setText("Profesores");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/construccion-de-comunidad.png"))); // NOI18N
        jMenu3.setText("Obra Social");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/tutor.png"))); // NOI18N
        jMenu4.setText("Tutores");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/entrevista.png"))); // NOI18N
        jMenu8.setText("Consultas");
        jMenu8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu8MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu8);

        jMenu9.setBackground(new java.awt.Color(255, 153, 153));
        jMenu9.setForeground(new java.awt.Color(0, 0, 0));
        jMenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/salir.png"))); // NOI18N
        jMenu9.setText("Salir");
        jMenu9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu9MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu9);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void serviciobtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serviciobtMouseEntered
        serviciobt.setBackground(new Color(255,204,204));
    }//GEN-LAST:event_serviciobtMouseEntered

    private void serviciobtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serviciobtMouseExited
       serviciobt.setBackground(new Color(255, 102, 102));
    }//GEN-LAST:event_serviciobtMouseExited

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
       
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
       
    }//GEN-LAST:event_jLabel3MouseExited

    private void insbtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insbtMouseEntered
        insbt.setBackground(new Color(255,204,204));
    }//GEN-LAST:event_insbtMouseEntered

    private void insbtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insbtMouseExited
       insbt.setBackground(new Color(255,102,102));
    }//GEN-LAST:event_insbtMouseExited

    private void pagobtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pagobtMouseEntered
        pagobt.setBackground(new Color(255,204,204));
    }//GEN-LAST:event_pagobtMouseEntered

    private void pagobtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pagobtMouseExited
        pagobt.setBackground(new Color(254, 102, 102));
    }//GEN-LAST:event_pagobtMouseExited

    private void pagoinsbtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pagoinsbtMouseEntered
        pagoinsbt.setBackground(new Color(255,204,204));
    }//GEN-LAST:event_pagoinsbtMouseEntered

    private void pagoinsbtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pagoinsbtMouseExited
        pagoinsbt.setBackground(new Color(254, 102, 102));
    }//GEN-LAST:event_pagoinsbtMouseExited

    private void serviciobtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serviciobtMouseClicked
        Panel4 panelcuatro = new Panel4(); 
        contenedor.add(panelcuatro,"cuatro");
        cardLayout.show(contenedor, "cuatro");
        contenedor.setSize( 1000,900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        
    }//GEN-LAST:event_serviciobtMouseClicked

    private void insbtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insbtMouseClicked
         Panel3 paneltres = new Panel3(); 
        contenedor.add(paneltres,"tres");
        cardLayout.show(contenedor, "tres");
        contenedor.setSize( 1000,900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }//GEN-LAST:event_insbtMouseClicked

    private void pagobtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pagobtMouseClicked
         Panel5 panelcinco = new Panel5(); 
        contenedor.add(panelcinco,"cinco");
        cardLayout.show(contenedor, "cinco");
        contenedor.setSize( 1000,900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }//GEN-LAST:event_pagobtMouseClicked

    private void pagoinsbtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pagoinsbtMouseClicked
         Gastos g = new Gastos();
        
        contenedor.add(g,"gasto");
        cardLayout.show(contenedor, "gasto");
        contenedor.setSize( 1000, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }//GEN-LAST:event_pagoinsbtMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        cardLayout.show(contenedor, "uno");
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jMenu9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu9MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jMenu9MouseClicked

    private void asistenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asistenciaMouseClicked
       asistencias a = new asistencias(); 
        contenedor.add(a,"asistencias");
        cardLayout.show(contenedor, "asistencias");
        contenedor.setSize( 598, 525);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }//GEN-LAST:event_asistenciaMouseClicked

    private void asistenciaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asistenciaMouseEntered
          asistencia.setBackground(new Color(255,204,204));
    }//GEN-LAST:event_asistenciaMouseEntered

    private void asistenciaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asistenciaMouseExited
          asistencia.setBackground(new Color(255,102,102));
    }//GEN-LAST:event_asistenciaMouseExited

    private void jMenu8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu8MouseClicked
      Consultas1 con=new Consultas1();
       contenedor.add(con,"consulta");
        cardLayout.show(contenedor, "consulta");
        contenedor.setSize( 598, 525);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        
    }//GEN-LAST:event_jMenu8MouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
       ModificarA m = new ModificarA(); 
        contenedor.add(m,"modificarA");
        cardLayout.show(contenedor, "modificarA");
        contenedor.setSize( 1000, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
          ModificarP mp = new ModificarP(); 
        contenedor.add(mp,"modificarP");
        cardLayout.show(contenedor, "modificarP");
        contenedor.setSize( 598, 525);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        OS O = new OS(); 
        contenedor.add(O,"os");
        cardLayout.show(contenedor, "os");
        contenedor.setSize( 598, 525);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
       ModificarT mt = new ModificarT(); 
        contenedor.add(mt,"modificarT");
        cardLayout.show(contenedor, "modificarT");
        contenedor.setSize( 598, 525);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }//GEN-LAST:event_jMenu4MouseClicked

    
    
    
    public class FondoPanel extends JPanel {
    
    private Image imagen;
    @Override
        public void paint(Graphics g){
            imagen= new ImageIcon(getClass().getResource("/Imagenes/5.jpg")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
            
    
    }
    public class FondoPanel2 extends JPanel {
    
    private Image imagen;
    @Override
        public void paint(Graphics g){
            imagen= new ImageIcon(getClass().getResource("/Imagenes2/8.png")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
            
    
    }
    public class EjemploCardLayout extends JFrame{
       public EjemploCardLayout(){
           CardLayout cardLayout= new CardLayout();
           getContentPane().setLayout(cardLayout);
       } 
    
    
    }
    
    public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
          
        try{
//            UIManager.setLookAndFeel(new FlatLightLaf());
              FlatArcOrangeIJTheme.setup();
        } catch (Exception ex) {
           Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);

        }

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel asistencia;
    private javax.swing.JPanel contenedor;
    private javax.swing.JPanel insbt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel pagobt;
    private javax.swing.JPanel pagoinsbt;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel serviciobt;
    // End of variables declaration//GEN-END:variables
}
