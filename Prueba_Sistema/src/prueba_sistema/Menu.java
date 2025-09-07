
package prueba_sistema;


import Alumno.AgregarA;
import Alumno.EliminarA;
import Alumno.ModificarA;
import ObraSocial.OS;
import Profesores.AgregarP;
import Profesores.EliminarP;
import Profesores.ModificarP;
import Tutores.AgregarT;
import Tutores.EliminarT;
import Tutores.ModificarT;
import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends javax.swing.JFrame {

  FondoPanel fondo= new FondoPanel();
  FondoPanel2 fondo2=new FondoPanel2();
  CardLayout cardLayout;
   
    public Menu() {
        initComponents();
      
        
        
        
        
        
        cardLayout = (CardLayout)(contenedor.getLayout());
        
        
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu5 = new javax.swing.JMenu();
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
        jLabel6 = new javax.swing.JLabel();
        contenedor = new javax.swing.JPanel();
        panel1 = new FondoPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        agregarA = new javax.swing.JMenuItem();
        modificarA = new javax.swing.JMenuItem();
        eliminarA = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        agregarP = new javax.swing.JMenuItem();
        modificarP = new javax.swing.JMenuItem();
        eliminarP = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        os = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        agregarT = new javax.swing.JMenuItem();
        modificarT = new javax.swing.JMenuItem();
        eliminarT = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        salir = new javax.swing.JMenuItem();

        jMenu5.setText("jMenu5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 650));

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

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/servicio.png"))); // NOI18N
        jLabel7.setText("jLabel7");

        javax.swing.GroupLayout serviciobtLayout = new javax.swing.GroupLayout(serviciobt);
        serviciobt.setLayout(serviciobtLayout);
        serviciobtLayout.setHorizontalGroup(
            serviciobtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(serviciobtLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(serviciobtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        serviciobtLayout.setVerticalGroup(
            serviciobtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(serviciobtLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
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
        pagobt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
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

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cuota.png"))); // NOI18N
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
                        .addGap(64, 64, 64)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pagobtLayout.setVerticalGroup(
            pagobtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pagobtLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        insbt.setBackground(new java.awt.Color(255, 102, 102));
        insbt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
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
                        .addGap(54, 54, 54)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(insbtLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3)))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        insbtLayout.setVerticalGroup(
            insbtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, insbtLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/er.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pagobt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pagoinsbt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1))
                    .addComponent(serviciobt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insbt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel6)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(serviciobt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(pagobt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(insbt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(pagoinsbt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
            .addGap(0, 800, Short.MAX_VALUE)
        );

        contenedor.add(panel1, "uno");

        getContentPane().add(contenedor, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Alumnos");

        agregarA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/agregar.png"))); // NOI18N
        agregarA.setText("Agregar");
        agregarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarAActionPerformed(evt);
            }
        });
        jMenu1.add(agregarA);

        modificarA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/modificar.png"))); // NOI18N
        modificarA.setText("Modificar");
        modificarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarAActionPerformed(evt);
            }
        });
        jMenu1.add(modificarA);

        eliminarA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/eliminar.png"))); // NOI18N
        eliminarA.setText("Eliminar");
        eliminarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarAActionPerformed(evt);
            }
        });
        jMenu1.add(eliminarA);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Profesores");

        agregarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/agregar.png"))); // NOI18N
        agregarP.setText("Agregar");
        agregarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPActionPerformed(evt);
            }
        });
        jMenu2.add(agregarP);

        modificarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/modificar.png"))); // NOI18N
        modificarP.setText("Modificar");
        modificarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarPActionPerformed(evt);
            }
        });
        jMenu2.add(modificarP);

        eliminarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/eliminar.png"))); // NOI18N
        eliminarP.setText("Eliminar");
        eliminarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPActionPerformed(evt);
            }
        });
        jMenu2.add(eliminarP);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Obra Social");

        os.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/os.png"))); // NOI18N
        os.setText("Ver");
        os.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                osActionPerformed(evt);
            }
        });
        jMenu3.add(os);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Tutores");

        agregarT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/agregar.png"))); // NOI18N
        agregarT.setText("Agregar");
        agregarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarTActionPerformed(evt);
            }
        });
        jMenu4.add(agregarT);

        modificarT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/modificar.png"))); // NOI18N
        modificarT.setText("Modificar");
        modificarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarTActionPerformed(evt);
            }
        });
        jMenu4.add(modificarT);

        eliminarT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/eliminar.png"))); // NOI18N
        eliminarT.setText("Eliminar");
        eliminarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarTActionPerformed(evt);
            }
        });
        jMenu4.add(eliminarT);

        jMenuBar1.add(jMenu4);

        jMenu6.setText("Opciones");

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/recursos.png"))); // NOI18N
        jMenuItem11.setText("Gastos");
        jMenu6.add(jMenuItem11);

        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes2/salir.png"))); // NOI18N
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jMenu6.add(salir);

        jMenuBar1.add(jMenu6);

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
        Panel2 paneldos = new Panel2(); 
        
        contenedor.add(paneldos,"dos");
       
        cardLayout.show(contenedor, "dos");
        
        
        contenedor.setSize( 1000,900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }//GEN-LAST:event_pagoinsbtMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        cardLayout.show(contenedor, "uno");
    }//GEN-LAST:event_jLabel1MouseClicked

    private void agregarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarAActionPerformed
        AgregarA Aa = new AgregarA(); 
        contenedor.add(Aa,"agregarA");
        cardLayout.show(contenedor, "agregarA");
        contenedor.setSize( 1000, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }//GEN-LAST:event_agregarAActionPerformed

    private void modificarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarAActionPerformed
        ModificarA m = new ModificarA(); 
        contenedor.add(m,"modificarA");
        cardLayout.show(contenedor, "modificarA");
        contenedor.setSize( 1000, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }//GEN-LAST:event_modificarAActionPerformed

    private void eliminarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarAActionPerformed
        EliminarA e = new EliminarA(); 
        contenedor.add(e,"eliminarA");
        cardLayout.show(contenedor, "eliminarA");
        contenedor.setSize( 1000, 9000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }//GEN-LAST:event_eliminarAActionPerformed

    private void agregarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarPActionPerformed
         AgregarP ap = new AgregarP(); 
        contenedor.add(ap,"agregarP");
        cardLayout.show(contenedor, "agregarP");
        contenedor.setSize(598, 525 );
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }//GEN-LAST:event_agregarPActionPerformed

    private void modificarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarPActionPerformed
        ModificarP mp = new ModificarP(); 
        contenedor.add(mp,"modificarP");
        cardLayout.show(contenedor, "modificarP");
        contenedor.setSize( 598, 525);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }//GEN-LAST:event_modificarPActionPerformed

    private void eliminarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPActionPerformed
        EliminarP ep = new EliminarP(); 
        contenedor.add(ep,"eliminarP");
        cardLayout.show(contenedor, "eliminarP");
        contenedor.setSize( 598, 525);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }//GEN-LAST:event_eliminarPActionPerformed

    private void osActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_osActionPerformed
        OS O = new OS(); 
        contenedor.add(O,"os");
        cardLayout.show(contenedor, "os");
        contenedor.setSize( 598, 525);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }//GEN-LAST:event_osActionPerformed

    private void agregarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarTActionPerformed
        AgregarT at = new AgregarT(); 
        contenedor.add(at,"agregarT");
        cardLayout.show(contenedor, "agregarT");
        contenedor.setSize( 598, 525);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }//GEN-LAST:event_agregarTActionPerformed

    private void modificarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarTActionPerformed
        ModificarT mt = new ModificarT(); 
        contenedor.add(mt,"modificarT");
        cardLayout.show(contenedor, "modificarT");
        contenedor.setSize( 598, 525);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }//GEN-LAST:event_modificarTActionPerformed

    private void eliminarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarTActionPerformed
        EliminarT et = new EliminarT(); 
        contenedor.add(et,"eliminarT");
        cardLayout.show(contenedor, "eliminarT");
        contenedor.setSize(598, 525);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }//GEN-LAST:event_eliminarTActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    
    
    
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
            System.getLogger(Menu.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem agregarA;
    private javax.swing.JMenuItem agregarP;
    private javax.swing.JMenuItem agregarT;
    private javax.swing.JPanel contenedor;
    private javax.swing.JMenuItem eliminarA;
    private javax.swing.JMenuItem eliminarP;
    private javax.swing.JMenuItem eliminarT;
    private javax.swing.JPanel insbt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JMenuItem modificarA;
    private javax.swing.JMenuItem modificarP;
    private javax.swing.JMenuItem modificarT;
    private javax.swing.JMenuItem os;
    private javax.swing.JPanel pagobt;
    private javax.swing.JPanel pagoinsbt;
    private javax.swing.JPanel panel1;
    private javax.swing.JMenuItem salir;
    private javax.swing.JPanel serviciobt;
    // End of variables declaration//GEN-END:variables
}
