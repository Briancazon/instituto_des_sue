
package Consultas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleInsets;


public class consultas3 extends javax.swing.JPanel {
       DefaultTableModel tabla=new DefaultTableModel();
     Object[] datos=new Object[4];
      ResultSet rs;
      Statement st;
     Connection cx=Conexion.conexion.conexion();
    
    public consultas3() {
        initComponents();
          Grafico.setLayout(new java.awt.BorderLayout());
           // 🔹 Seleccionado por defecto
        inicial.setSelected(true);
        // 🔹 Mostrar su contenido automáticamente
        inicial.doClick();
        cantidad1.setEditable(false);
        cantidad2.setEditable(false);
        cantidad3.setEditable(false);
    }

    
    
    
    public void barra(){
        
         int cantidad = Integer.parseInt(cantidad1.getText());
           
            if (cantidad > 60) cantidad = 60; // límite

            int restantes = 60 - cantidad;

        
   
         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(cantidad, "Total de Alumnos", "Total de Alumnos ");
        dataset.addValue(restantes, "Disponible", "Disponibles");

        // === Crear gráfico base ===
        JFreeChart chart = ChartFactory.createBarChart(
                "Cantidad de Alumnos de Nivel Inicial",
                "Categoria", // sin etiqueta eje X
                "Valor",
                dataset,
                PlotOrientation.HORIZONTAL,
                true, true, false
        );

        // === Personalizar estilo ===
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(245, 245, 245)); // fondo suave
        plot.setOutlineVisible(false);
        plot.setDomainGridlinePaint(Color.LIGHT_GRAY);
        plot.setRangeGridlinePaint(new Color(180, 180, 180));
        plot.setInsets(new RectangleInsets(10, 10, 10, 10));

        // === Personalizar las barras ===
        BarRenderer renderer = (BarRenderer) plot.getRenderer();

        // Colores personalizados
        Paint[] colores = new Paint[]{
                new GradientPaint(0, 0, new Color(52, 152, 219), 0, 0, new Color(41, 128, 185)), // azul degradado
                new GradientPaint(0, 0, new Color(231, 76, 60), 0, 0, new Color(192, 57, 43))    // rojo degradado
        };

        for (int i = 0; i < colores.length; i++) {
            renderer.setSeriesPaint(i, colores[i]);
        }

        // Quitar bordes de barra
        renderer.setDrawBarOutline(false);

        // Mostrar valor encima de la barra
      
        // === Aplicar gráfico al panel ===
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 300));
        chartPanel.setBackground(Color.WHITE);

        Grafico.removeAll();
        Grafico.add(chartPanel, BorderLayout.CENTER);
        Grafico.revalidate();
        Grafico.repaint();
        
        
    }
    
     
    public void barra2(){
        
         int cantidad = Integer.parseInt(cantidad2.getText());
           
            if (cantidad > 60) cantidad = 60; // límite

            int restantes = 60 - cantidad;

        
   
         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(cantidad, "Total de Alumnos", "Total de Alumnos");
        dataset.addValue(restantes, "Disponible", "Disponble");

        // === Crear gráfico base ===
        JFreeChart chart = ChartFactory.createBarChart(
                "Cantidad de Alumnos de Nivel Primario",
                "Categoria", // sin etiqueta eje X
                "Valor",
                dataset,
                PlotOrientation.HORIZONTAL,
                true, true, false
        );

        // === Personalizar estilo ===
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(245, 245, 245)); // fondo suave
        plot.setOutlineVisible(false);
        plot.setDomainGridlinePaint(Color.LIGHT_GRAY);
        plot.setRangeGridlinePaint(new Color(180, 180, 180));
        plot.setInsets(new RectangleInsets(10, 10, 10, 10));

        // === Personalizar las barras ===
        BarRenderer renderer = (BarRenderer) plot.getRenderer();

        // Colores personalizados
        Paint[] colores = new Paint[]{
                new GradientPaint(0, 0, new Color(52, 152, 219), 0, 0, new Color(41, 128, 185)), // azul degradado
                new GradientPaint(0, 0, new Color(231, 76, 60), 0, 0, new Color(192, 57, 43))    // rojo degradado
        };

        for (int i = 0; i < colores.length; i++) {
            renderer.setSeriesPaint(i, colores[i]);
        }

        // Quitar bordes de barra
        renderer.setDrawBarOutline(false);

        // Mostrar valor encima de la barra
      
        // === Aplicar gráfico al panel ===
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 300));
        chartPanel.setBackground(Color.WHITE);

        Grafico.removeAll();
        Grafico.add(chartPanel, BorderLayout.CENTER);
        Grafico.revalidate();
        Grafico.repaint();
        
        
    }
     
    public void barra3(){
        
         int cantidad = Integer.parseInt(cantidad3.getText());
           
            if (cantidad > 60) cantidad = 60; // límite

            int restantes = 60 - cantidad;

        
   
         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(cantidad, "Total de Alumnos", "Total de Alumnos");
        dataset.addValue(restantes, "Disponible", "Disponibles");

        // === Crear gráfico base ===
        JFreeChart chart = ChartFactory.createBarChart(
                "Cantidad de Alumnos de Nivel Secundario",
                "Categoria", // sin etiqueta eje X
                "Valor",
                dataset,
                PlotOrientation.HORIZONTAL,
                true, true, false
        );

        // === Personalizar estilo ===
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(245, 245, 245)); // fondo suave
        plot.setOutlineVisible(false);
        plot.setDomainGridlinePaint(Color.LIGHT_GRAY);
        plot.setRangeGridlinePaint(new Color(180, 180, 180));
        plot.setInsets(new RectangleInsets(10, 10, 10, 10));

        // === Personalizar las barras ===
        BarRenderer renderer = (BarRenderer) plot.getRenderer();

        // Colores personalizados
        Paint[] colores = new Paint[]{
                new GradientPaint(0, 0, new Color(52, 152, 219), 0, 0, new Color(41, 128, 185)), // azul degradado
                new GradientPaint(0, 0, new Color(231, 76, 60), 0, 0, new Color(192, 57, 43))    // rojo degradado
        };

        for (int i = 0; i < colores.length; i++) {
            renderer.setSeriesPaint(i, colores[i]);
        }

        // Quitar bordes de barra
        renderer.setDrawBarOutline(false);

        // Mostrar valor encima de la barra
      
        // === Aplicar gráfico al panel ===
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 300));
        chartPanel.setBackground(Color.WHITE);

        Grafico.removeAll();
        Grafico.add(chartPanel, BorderLayout.CENTER);
        Grafico.revalidate();
        Grafico.repaint();
        
        
    }
    
    
  
    
    
    public void Conteo1(){
        int cantidad = TablaNiveles.getRowCount();
        cantidad1.setText(String.valueOf(cantidad));
    }
    
    
    public void Conteo2(){
        int cantidad = TablaNiveles.getRowCount();
        cantidad2.setText(String.valueOf(cantidad));
    }
    
    
     public void Conteo3(){
        int cantidad = TablaNiveles.getRowCount();
        cantidad3.setText(String.valueOf(cantidad));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GRUPO2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inicial = new javax.swing.JRadioButton();
        primario = new javax.swing.JRadioButton();
        secundario = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaNiveles = new javax.swing.JTable();
        Grafico = new javax.swing.JPanel();
        cantidad1 = new javax.swing.JTextField();
        cantidad2 = new javax.swing.JTextField();
        cantidad3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("NIVELES:");

        GRUPO2.add(inicial);
        inicial.setText("INICIAL");
        inicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicialActionPerformed(evt);
            }
        });

        GRUPO2.add(primario);
        primario.setText("PRIMARIO");
        primario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                primarioActionPerformed(evt);
            }
        });

        GRUPO2.add(secundario);
        secundario.setText("SECUNDARIO");
        secundario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secundarioActionPerformed(evt);
            }
        });

        TablaNiveles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Grado ", "Nivel"
            }
        ));
        jScrollPane1.setViewportView(TablaNiveles);

        javax.swing.GroupLayout GraficoLayout = new javax.swing.GroupLayout(Grafico);
        Grafico.setLayout(GraficoLayout);
        GraficoLayout.setHorizontalGroup(
            GraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        GraficoLayout.setVerticalGroup(
            GraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 216, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("TOTAL:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Grafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(inicial, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(primario, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(secundario))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(cantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addComponent(cantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(cantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inicial)
                    .addComponent(primario)
                    .addComponent(secundario))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Grafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        add(jPanel1, "tres");
    }// </editor-fold>//GEN-END:initComponents

    private void inicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicialActionPerformed
            tabla.setRowCount(0);   
         tabla.setColumnCount(0);
        
         tabla.addColumn("Nombre");  
         tabla.addColumn("Apellido");  
         tabla.addColumn("Grado"); 
         tabla.addColumn("Nivel"); 
        
        
         
         try{
            
             rs=Consultas.ConsultaNiveles.mostrarInicial(cx);
              while(rs.next()){
                   datos[0]=rs.getString("nombre");
                   datos[1]=rs.getString("apellido");
                   datos[2]=rs.getString("grado");
                   datos[3]=rs.getString("nivel");
                   
                  
                
                 
                  
                   tabla.addRow(datos);
                   TablaNiveles.setModel(tabla);
                   
              } 
              
          }catch(Exception e){
                   JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar la tabla","ERROR",ERROR_MESSAGE); 
          }
        
       
        Conteo1();
        barra();
        cantidad2.setText("");
         cantidad3.setText("");
    }//GEN-LAST:event_inicialActionPerformed

    private void primarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_primarioActionPerformed
         tabla.setRowCount(0);   
         tabla.setColumnCount(0);
        
         tabla.addColumn("Nombre");  
         tabla.addColumn("Apellido");  
         tabla.addColumn("Grado"); 
         tabla.addColumn("Nivel"); 
        
        
         
         try{
            
             rs=Consultas.ConsultaNiveles.mostrarPrimario(cx);
              while(rs.next()){
                   datos[0]=rs.getString("nombre");
                   datos[1]=rs.getString("apellido");
                   datos[2]=rs.getString("grado");
                   datos[3]=rs.getString("nivel");
                   
                  
                
                 
                  
                   tabla.addRow(datos);
                   TablaNiveles.setModel(tabla);
                   
              } 
              
          }catch(Exception e){
                   JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar la tabla","ERROR",ERROR_MESSAGE); 
          }
        Conteo2();
        barra2();
       cantidad1.setText("");
       cantidad3.setText("");
    }//GEN-LAST:event_primarioActionPerformed

    private void secundarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secundarioActionPerformed
             tabla.setRowCount(0);   
         tabla.setColumnCount(0);
        
         tabla.addColumn("Nombre");  
         tabla.addColumn("Apellido");  
         tabla.addColumn("Grado"); 
         tabla.addColumn("Nivel"); 
        
        
         
         try{
            
             rs=Consultas.ConsultaNiveles.mostrarSecundario(cx);
              while(rs.next()){
                   datos[0]=rs.getString("nombre");
                   datos[1]=rs.getString("apellido");
                   datos[2]=rs.getString("grado");
                   datos[3]=rs.getString("nivel");
                   
                  
                
                 
                  
                   tabla.addRow(datos);
                   TablaNiveles.setModel(tabla);
                   
              } 
              
          }catch(Exception e){
                   JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar la tabla","ERROR",ERROR_MESSAGE); 
          }
        Conteo3();
        barra3();
        cantidad1.setText("");
       cantidad2.setText("");
    }//GEN-LAST:event_secundarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GRUPO2;
    private javax.swing.JPanel Grafico;
    private javax.swing.JTable TablaNiveles;
    private javax.swing.JTextField cantidad1;
    private javax.swing.JTextField cantidad2;
    private javax.swing.JTextField cantidad3;
    private javax.swing.JRadioButton inicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton primario;
    private javax.swing.JRadioButton secundario;
    // End of variables declaration//GEN-END:variables
}
