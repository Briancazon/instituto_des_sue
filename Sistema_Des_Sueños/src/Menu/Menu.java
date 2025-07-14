
package Menu;

import Alumnos.Agregar_Alumno;
import Alumnos.Eliminar_Alumno;
import Alumnos.Modificar_Alumno;
import Profesores.Agregar_Profe;
import Profesores.Eliminar_Profe;
import Profesores.Modificar_Profe;
import Tutores.Agregar_Tutor;
import Tutores.Eliminar_Tutor;
import Tutores.Modificar_Tutor;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;






public class Menu extends javax.swing.JFrame {

   FondoPanel fondo= new FondoPanel();
    public Menu() {
       // this.setContentPane(fondo);
       
        initComponents();
        
       // this.setLocationRelativeTo(null);
       
        this.setExtendedState(this.MAXIMIZED_BOTH);
        
                
    }

    
   

    
    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu4 = new javax.swing.JMenu();
        panelprincipal = new FondoPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        agregarT = new javax.swing.JMenuItem();
        modificarT = new javax.swing.JMenuItem();
        eliminarT = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        agregarA = new javax.swing.JMenuItem();
        modificarA = new javax.swing.JMenuItem();
        eliminarA = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        agregarP = new javax.swing.JMenuItem();
        modificarP = new javax.swing.JMenuItem();
        eliminarP = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        inicio = new javax.swing.JMenuItem();
        salir = new javax.swing.JMenuItem();

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelprincipal.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                panelprincipalComponentAdded(evt);
            }
        });

        javax.swing.GroupLayout panelprincipalLayout = new javax.swing.GroupLayout(panelprincipal);
        panelprincipal.setLayout(panelprincipalLayout);
        panelprincipalLayout.setHorizontalGroup(
            panelprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1380, Short.MAX_VALUE)
        );
        panelprincipalLayout.setVerticalGroup(
            panelprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );

        jMenu1.setText("Servicios");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Pagos");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Tutor");

        agregarT.setText("Agregar");
        agregarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarTActionPerformed(evt);
            }
        });
        jMenu3.add(agregarT);

        modificarT.setText("Modificar");
        modificarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarTActionPerformed(evt);
            }
        });
        jMenu3.add(modificarT);

        eliminarT.setText("Eliminar");
        eliminarT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarTActionPerformed(evt);
            }
        });
        jMenu3.add(eliminarT);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Alumnos");

        agregarA.setText("Agregar");
        agregarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarAActionPerformed(evt);
            }
        });
        jMenu5.add(agregarA);

        modificarA.setText("Modificar");
        modificarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarAActionPerformed(evt);
            }
        });
        jMenu5.add(modificarA);

        eliminarA.setText("Eliminar");
        eliminarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarAActionPerformed(evt);
            }
        });
        jMenu5.add(eliminarA);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Obra Social");
        jMenuBar1.add(jMenu6);

        jMenu7.setText("Profesores");

        agregarP.setText("Agregar");
        agregarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPActionPerformed(evt);
            }
        });
        jMenu7.add(agregarP);

        modificarP.setText("Modificar");
        modificarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarPActionPerformed(evt);
            }
        });
        jMenu7.add(modificarP);

        eliminarP.setText("Eliminar");
        eliminarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPActionPerformed(evt);
            }
        });
        jMenu7.add(eliminarP);

        jMenuBar1.add(jMenu7);

        jMenu8.setText("Gastos");
        jMenuBar1.add(jMenu8);

        jMenu9.setText("Opciones");

        inicio.setText("Inicio");
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });
        jMenu9.add(inicio);

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jMenu9.add(salir);

        jMenuBar1.add(jMenu9);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelprincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelprincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelprincipalComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_panelprincipalComponentAdded
        
    }//GEN-LAST:event_panelprincipalComponentAdded

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
       System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
       Inicio p1= new Inicio();
        this.setContentPane(p1);
         this.revalidate();
         this.repaint();
    }//GEN-LAST:event_inicioActionPerformed

    private void agregarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarAActionPerformed
        Agregar_Alumno a= new Agregar_Alumno();
         this.setContentPane(a);
         this.revalidate();
         this.repaint();
         
    }//GEN-LAST:event_agregarAActionPerformed

    private void modificarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarAActionPerformed
        Modificar_Alumno m= new Modificar_Alumno();
        this.setContentPane(m);
         this.revalidate();
         this.repaint();
    }//GEN-LAST:event_modificarAActionPerformed

    private void eliminarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarAActionPerformed
        Eliminar_Alumno e= new Eliminar_Alumno();
         this.setContentPane(e);
         this.revalidate();
         this.repaint();
        
    }//GEN-LAST:event_eliminarAActionPerformed

    private void agregarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarPActionPerformed
        Agregar_Profe ap= new Agregar_Profe();
        this.setContentPane(ap);
         this.revalidate();
         this.repaint();
    }//GEN-LAST:event_agregarPActionPerformed

    private void modificarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarPActionPerformed
       Modificar_Profe mp= new Modificar_Profe();
       this.setContentPane(mp);
         this.revalidate();
         this.repaint();
       
    }//GEN-LAST:event_modificarPActionPerformed

    private void eliminarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPActionPerformed
        Eliminar_Profe ep= new Eliminar_Profe();
        this.setContentPane(ep);
         this.revalidate();
         this.repaint();
       
    }//GEN-LAST:event_eliminarPActionPerformed

    private void agregarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarTActionPerformed
        Agregar_Tutor at= new Agregar_Tutor();
         this.setContentPane(at);
         this.revalidate();
         this.repaint();
    }//GEN-LAST:event_agregarTActionPerformed

    private void modificarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarTActionPerformed
        Modificar_Tutor mt= new Modificar_Tutor();
        this.setContentPane(mt);
         this.revalidate();
         this.repaint();
    }//GEN-LAST:event_modificarTActionPerformed

    private void eliminarTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarTActionPerformed
       Eliminar_Tutor et= new Eliminar_Tutor();
       this.setContentPane(et);
         this.revalidate();
         this.repaint();
    }//GEN-LAST:event_eliminarTActionPerformed
  
   public class FondoPanel extends JPanel {
    
    private Image imagen;
        @Override
        public void paint(Graphics g){
            imagen= new ImageIcon(getClass().getResource("/Imagenes/1.jpg")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(), this);
            setOpaque(false);
            super.paint(g);
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
    private javax.swing.JMenuItem eliminarA;
    private javax.swing.JMenuItem eliminarP;
    private javax.swing.JMenuItem eliminarT;
    private javax.swing.JMenuItem inicio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem modificarA;
    private javax.swing.JMenuItem modificarP;
    private javax.swing.JMenuItem modificarT;
    private javax.swing.JPanel panelprincipal;
    private javax.swing.JMenuItem salir;
    // End of variables declaration//GEN-END:variables
}
