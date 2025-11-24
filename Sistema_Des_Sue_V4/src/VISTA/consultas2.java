
package VISTA;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import org.jfree.data.category.DefaultCategoryDataset;



public class consultas2 extends javax.swing.JPanel {

    DefaultTableModel tabla=new DefaultTableModel();
     Object[] datos=new Object[4];
      ResultSet rs;
      Statement st;
     Connection cx=MODELO_CONTROLADOR.conexion.conexion();
    public consultas2() {
        initComponents();
        grafico.setLayout(new java.awt.BorderLayout());
        // 🔹 Seleccionado por defecto
        //clasepersonalizada.setSelected(true);
        // 🔹 Mostrar su contenido automáticamente
        //clasepersonalizada.doClick();
      cantidad1.setEditable(false);
      cantidad2.setEditable(false);
      cantidad3.setEditable(false);
      cantidad4.setEditable(false);
      cantidad5.setEditable(false);
      
      TablaEstilo.personalizarTabla(TablaServicio);
      
    }
    
    
    
    public void Conteo1(){
        
        int cantidad = TablaServicio.getRowCount();
     
        cantidad1.setText(String.valueOf(cantidad));
    }
    
    
    public void Conteo2(){
        int cantidad = TablaServicio.getRowCount();
        cantidad2.setText(String.valueOf(cantidad));
    }
    
    
     public void Conteo3(){
        int cantidad = TablaServicio.getRowCount();
        cantidad3.setText(String.valueOf(cantidad));
    }
    
    
    public void Conteo4(){
        int cantidad = TablaServicio.getRowCount();
        cantidad4.setText(String.valueOf(cantidad));
    }
    
    public void Conteo5(){
        int cantidad = TablaServicio.getRowCount();
        cantidad5.setText(String.valueOf(cantidad));
    }
    
    
       public void actualizar(){
      try {
            int cantidad = Integer.parseInt(cantidad1.getText());
           
            if (cantidad > 60) cantidad = 60; // límite

            int restantes = 60 - cantidad;

            // Crear dataset
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            dataset.addValue(cantidad, "Matricula", "Matricula");
            dataset.addValue(restantes, "Disponible", "Disponibles");

            // Crear gráfico de barras horizontal
            JFreeChart chart = ChartFactory.createBarChart(
                    "Clase Personalizada",     // Título
                    "Categoría",              // Eje X (nombre)
                    "Valor",                  // Eje Y (valor numérico)
                    dataset,
                    org.jfree.chart.plot.PlotOrientation.HORIZONTAL, // <--- clave
                    false,                    // leyenda
                    true,                     // tooltips
                    false                     // URLs
            );

            // Mostrar gráfico en el panel
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(500, 300));

            grafico.removeAll();
            grafico.add(chartPanel, BorderLayout.CENTER);
            grafico.revalidate();
            grafico.repaint();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
     public void actualizar2(){
      
      try {
            int cantidad = Integer.parseInt(cantidad2.getText());
           
            if (cantidad > 60) cantidad = 60; // límite

            int restantes = 60 - cantidad;

            // Crear dataset
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            dataset.addValue(cantidad, "Matricula", "Matricula");
            dataset.addValue(restantes, "Disponibles", "Disponibles");

            // Crear gráfico de barras horizontal
            JFreeChart chart = ChartFactory.createBarChart(
                    "Apoyo Pedagogico",     // Título
                    "Categoria",              // Eje X (nombre)
                    "Valor",                  // Eje Y (valor numérico)
                    dataset,
                    org.jfree.chart.plot.PlotOrientation.HORIZONTAL, // <--- clave
                    false,                    // leyenda
                    true,                     // tooltips
                    false                     // URLs
            );

            // Mostrar gráfico en el panel
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(500, 300));

            grafico.removeAll();
            grafico.add(chartPanel, BorderLayout.CENTER);
            grafico.revalidate();
            grafico.repaint();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

      public void actualizar3(){
      
      try {
            int cantidad = Integer.parseInt(cantidad3.getText());
           
            if (cantidad > 60) cantidad = 60; // límite

            int restantes = 60 - cantidad;

            // Crear dataset
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            dataset.addValue(cantidad, "Matricula", "Matricula");
            dataset.addValue(restantes, "Disponible", "Disponible");

            // Crear gráfico de barras horizontal
            JFreeChart chart = ChartFactory.createBarChart(
                    "Educación Temprana",     // Título
                    "Categoria",              // Eje X (nombre)
                    "Valor",                  // Eje Y (valor numérico)
                    dataset,
                    org.jfree.chart.plot.PlotOrientation.HORIZONTAL, // <--- clave
                    false,                    // leyenda
                    true,                     // tooltips
                    false                     // URLs
            );

            // Mostrar gráfico en el panel
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(500, 300));

            grafico.removeAll();
            grafico.add(chartPanel, BorderLayout.CENTER);
            grafico.revalidate();
            grafico.repaint();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

      public void actualizar4(){
      
      try {
            int cantidad = Integer.parseInt(cantidad4.getText());
           
            if (cantidad > 60) cantidad = 60; // límite

            int restantes = 60 - cantidad;

            // Crear dataset
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            dataset.addValue(cantidad, "Matricula", "Matricula");
            dataset.addValue(restantes, "Disponible", "Disponible");

            // Crear gráfico de barras horizontal
            JFreeChart chart = ChartFactory.createBarChart(
                    "Inclusión Escolar: Acompñamientos",     // Título
                    "Categoria",              // Eje X (nombre)
                    "Valor",                  // Eje Y (valor numérico)
                    dataset,
                    org.jfree.chart.plot.PlotOrientation.HORIZONTAL, // <--- clave
                    false,                    // leyenda
                    true,                     // tooltips
                    false                     // URLs
            );

            // Mostrar gráfico en el panel
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(500, 300));

            grafico.removeAll();
            grafico.add(chartPanel, BorderLayout.CENTER);
            grafico.revalidate();
            grafico.repaint();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

      public void actualizar5(){
      
      try {
            int cantidad = Integer.parseInt(cantidad5.getText());
           
            if (cantidad > 60) cantidad = 60; // límite

            int restantes = 60 - cantidad;

            // Crear dataset
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            dataset.addValue(cantidad, "Matricula", "Matricula");
            dataset.addValue(restantes, "Disponible", "Disponible");

            // Crear gráfico de barras horizontal
            JFreeChart chart = ChartFactory.createBarChart(
                    "Inclusión Escolar: Itinerancia",     // Título
                    "Categoria",              // Eje X (nombre)
                    "Valor",                  // Eje Y (valor numérico)
                    dataset,
                    org.jfree.chart.plot.PlotOrientation.HORIZONTAL, // <--- clave
                    false,                    // leyenda
                    true,                     // tooltips
                    false                     // URLs
            );

            // Mostrar gráfico en el panel
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(500, 300));

            grafico.removeAll();
            grafico.add(chartPanel, BorderLayout.CENTER);
            grafico.revalidate();
            grafico.repaint();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    

    //metodo que muestra la cantidad de alumnos que estan activos en clases personalizadas
     public void mostrar1(){
    
     tabla.setRowCount(0);   
         tabla.setColumnCount(0);
        
         tabla.addColumn("Nombre");  
         tabla.addColumn("Apellido");  
         tabla.addColumn("Servicio"); 
         tabla.addColumn("Año"); 
        
        // Asignar el modelo vacio ANTES
        TablaServicio.setModel(tabla);
         
         try{
             int codigo_ciclo_lectivo=MODELO_CONTROLADOR.Inscripcion.obtenerCodigoCicloLectivo(cx);  //obtener el codigo ciclo_lectvo actual
             rs=MODELO_CONTROLADOR.ConsultaServicios.mostrarClasePersonalizada(cx,  codigo_ciclo_lectivo); //metodo que nos muestra los alumnos activos de clases personalizadas
             
             
              while(rs.next()){
                   datos[0]=rs.getString("al.nombre");
                   datos[1]=rs.getString("al.apellido");
                   datos[2]=rs.getString("ser.nombre");
                   datos[3]=rs.getString("ci.año");
                   
                  
                
                 
                  
                   tabla.addRow(datos);
                   TablaServicio.setModel(tabla);
                   
              } 
              
          }catch(Exception e){
                   JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar la tabla","ERROR",ERROR_MESSAGE); 
          }
        
        Conteo1();
        actualizar();
    
}
       
     public void mostrar2(){
         
         
           tabla.setRowCount(0);   
         tabla.setColumnCount(0);
        
         tabla.addColumn("Nombre");  
         tabla.addColumn("Apellido");  
         tabla.addColumn("Servicio"); 
         tabla.addColumn("Año"); 
        
          // Asignar el modelo vacio ANTES
        TablaServicio.setModel(tabla);
         
         try{
              int codigo_ciclo_lectivo=MODELO_CONTROLADOR.Inscripcion.obtenerCodigoCicloLectivo(cx); ///nos da el codigo ciclo_lectivo actual
             rs=MODELO_CONTROLADOR.ConsultaServicios.mostrarApoyoPedagogico(cx, codigo_ciclo_lectivo);
              while(rs.next()){
                   datos[0]=rs.getString("al.nombre");
                   datos[1]=rs.getString("al.apellido");
                   datos[2]=rs.getString("ser.nombre");
                   datos[3]=rs.getString("ci.año");
                   
                  
                
                 
                  
                   tabla.addRow(datos);
                   TablaServicio.setModel(tabla);
                   
              } 
              
          }catch(Exception e){
                   JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar la tabla","ERROR",ERROR_MESSAGE); 
          }
         
         Conteo2();
          actualizar2();
      
         
         
     }
       
       
       public void mostrar3(){
              tabla.setRowCount(0);   
         tabla.setColumnCount(0);
        
         tabla.addColumn("Nombre");  
         tabla.addColumn("Apellido");  
         tabla.addColumn("Servicio"); 
         tabla.addColumn("Año"); 
        
          // Asignar el modelo vacio ANTES
        TablaServicio.setModel(tabla);
         
         try{
             int codigo_ciclo_lectivo=MODELO_CONTROLADOR.Inscripcion.obtenerCodigoCicloLectivo(cx); /// obtener el codigo_ciclo_lectivo actual
             rs=MODELO_CONTROLADOR.ConsultaServicios.mostrarEducacionTemprana(cx, codigo_ciclo_lectivo);
              while(rs.next()){
                   datos[0]=rs.getString("al.nombre");
                   datos[1]=rs.getString("al.apellido");
                   datos[2]=rs.getString("ser.nombre");
                   datos[3]=rs.getString("ci.año");
                   
                  
                
                 
                  
                   tabla.addRow(datos);
                   TablaServicio.setModel(tabla);
                   
              } 
              
          }catch(Exception e){
                   JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar la tabla","ERROR",ERROR_MESSAGE); 
          }
         Conteo3();
          actualizar3();
       }
       
       
       public void mostrar4(){
              tabla.setRowCount(0);   
         tabla.setColumnCount(0);
        
         tabla.addColumn("Nombre");  
         tabla.addColumn("Apellido");  
         tabla.addColumn("Servicio"); 
         tabla.addColumn("Año"); 
        
          // Asignar el modelo vacio ANTES
        TablaServicio.setModel(tabla);
         
         try{
             int codigo_ciclo_lectivo=MODELO_CONTROLADOR.Inscripcion.obtenerCodigoCicloLectivo(cx);
             rs=MODELO_CONTROLADOR.ConsultaServicios.mostrarAcompañamiento(cx, codigo_ciclo_lectivo);
              while(rs.next()){
                   datos[0]=rs.getString("al.nombre");
                   datos[1]=rs.getString("al.apellido");
                   datos[2]=rs.getString("ser.nombre");
                   datos[3]=rs.getString("ci.año");
                   
                  
                
                 
                  
                   tabla.addRow(datos);
                   TablaServicio.setModel(tabla);
                   
              } 
              
          }catch(Exception e){
                   JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar la tabla","ERROR",ERROR_MESSAGE); 
          }
        
        Conteo4();
        actualizar4();
           
       }
       
       public void mostrar5(){
              tabla.setRowCount(0);   
         tabla.setColumnCount(0);
        
         tabla.addColumn("Nombre");  
         tabla.addColumn("Apellido");  
         tabla.addColumn("Servicio"); 
         tabla.addColumn("Año"); 
        
          // Asignar el modelo vacio ANTES
        TablaServicio.setModel(tabla);
         
         try{
             int codigo_ciclo_lectivo=MODELO_CONTROLADOR.Inscripcion.obtenerCodigoCicloLectivo(cx);
             rs=MODELO_CONTROLADOR.ConsultaServicios.mostrarItinerancia(cx,codigo_ciclo_lectivo);
              while(rs.next()){
                   datos[0]=rs.getString("al.nombre");
                   datos[1]=rs.getString("al.apellido");
                   datos[2]=rs.getString("ser.nombre");
                   datos[3]=rs.getString("ci.año");
                   
                  
                
                 
                  
                   tabla.addRow(datos);
                   TablaServicio.setModel(tabla);
                   
              } 
              
          }catch(Exception e){
                   JOptionPane.showMessageDialog(null, "Ha ocurrido un error al mostrar la tabla","ERROR",ERROR_MESSAGE); 
          }
         Conteo5();
         actualizar5();
       }
       
       
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        clasepersonalizada = new javax.swing.JRadioButton();
        apoyopedagogico = new javax.swing.JRadioButton();
        educaciontemprana = new javax.swing.JRadioButton();
        acompañamiento = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaServicio = new javax.swing.JTable();
        grafico = new javax.swing.JPanel();
        itinerancia = new javax.swing.JRadioButton();
        cantidad1 = new javax.swing.JTextField();
        cantidad2 = new javax.swing.JTextField();
        cantidad3 = new javax.swing.JTextField();
        cantidad4 = new javax.swing.JTextField();
        cantidad5 = new javax.swing.JTextField();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("SERVICIOS:");

        grupo1.add(clasepersonalizada);
        clasepersonalizada.setText("CLASES PERSONALIZADAS");
        clasepersonalizada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clasepersonalizadaActionPerformed(evt);
            }
        });

        grupo1.add(apoyopedagogico);
        apoyopedagogico.setText("APOYO PEDAGOGICO");
        apoyopedagogico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apoyopedagogicoActionPerformed(evt);
            }
        });

        grupo1.add(educaciontemprana);
        educaciontemprana.setText("EDUCACIÓN TEMPRANA");
        educaciontemprana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                educaciontempranaActionPerformed(evt);
            }
        });

        grupo1.add(acompañamiento);
        acompañamiento.setText("ACOMPAÑAMIENTO");
        acompañamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acompañamientoActionPerformed(evt);
            }
        });

        TablaServicio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Servicio", "Ciclo Lectivo"
            }
        ));
        jScrollPane1.setViewportView(TablaServicio);

        javax.swing.GroupLayout graficoLayout = new javax.swing.GroupLayout(grafico);
        grafico.setLayout(graficoLayout);
        graficoLayout.setHorizontalGroup(
            graficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        graficoLayout.setVerticalGroup(
            graficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 218, Short.MAX_VALUE)
        );

        grupo1.add(itinerancia);
        itinerancia.setText("ITINERANCIA");
        itinerancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itineranciaActionPerformed(evt);
            }
        });

        cantidad5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidad5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(grafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clasepersonalizada)
                            .addComponent(cantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(apoyopedagogico)
                            .addComponent(cantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(educaciontemprana)
                            .addComponent(cantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(acompañamiento)
                            .addComponent(cantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itinerancia)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(cantidad5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)))
                        .addGap(0, 54, Short.MAX_VALUE)))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(clasepersonalizada)
                        .addComponent(apoyopedagogico)
                        .addComponent(educaciontemprana)
                        .addComponent(acompañamiento)
                        .addComponent(itinerancia))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidad5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(grafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        add(jPanel1, "dos");
    }// </editor-fold>//GEN-END:initComponents

    private void cantidad5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidad5ActionPerformed
    
    }//GEN-LAST:event_cantidad5ActionPerformed

    private void clasepersonalizadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clasepersonalizadaActionPerformed
        mostrar1();
        cantidad2.setText("");
        cantidad3.setText("");
        cantidad4.setText("");
        cantidad5.setText("");
      
    }//GEN-LAST:event_clasepersonalizadaActionPerformed

    private void apoyopedagogicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apoyopedagogicoActionPerformed
       mostrar2();
        cantidad1.setText("");
        cantidad3.setText("");
        cantidad4.setText("");
        cantidad5.setText("");
    }//GEN-LAST:event_apoyopedagogicoActionPerformed

    private void educaciontempranaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_educaciontempranaActionPerformed
       mostrar3();
        cantidad1.setText("");
        cantidad2.setText("");
        cantidad4.setText("");
        cantidad5.setText("");
    }//GEN-LAST:event_educaciontempranaActionPerformed

    private void acompañamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acompañamientoActionPerformed
        
       mostrar4();
        cantidad1.setText("");
        cantidad2.setText("");
        cantidad3.setText("");
        cantidad5.setText("");
    }//GEN-LAST:event_acompañamientoActionPerformed

    private void itineranciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itineranciaActionPerformed
       
        mostrar5();
        cantidad1.setText("");
        cantidad2.setText("");
        cantidad3.setText("");
        cantidad4.setText("");
    }//GEN-LAST:event_itineranciaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaServicio;
    private javax.swing.JRadioButton acompañamiento;
    private javax.swing.JRadioButton apoyopedagogico;
    private javax.swing.JTextField cantidad1;
    private javax.swing.JTextField cantidad2;
    private javax.swing.JTextField cantidad3;
    private javax.swing.JTextField cantidad4;
    private javax.swing.JTextField cantidad5;
    private javax.swing.JRadioButton clasepersonalizada;
    private javax.swing.JRadioButton educaciontemprana;
    private javax.swing.JPanel grafico;
    private javax.swing.ButtonGroup grupo1;
    private javax.swing.JRadioButton itinerancia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
