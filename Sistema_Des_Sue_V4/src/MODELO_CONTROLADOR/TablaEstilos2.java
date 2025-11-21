package MODELO_CONTROLADOR;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class TablaEstilos2 {

    public static void personalizarTabla(JTable tabla) {

        tabla.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Colores de fondo intercalados (usando RGB)
                Color colorPar = new Color(230, 240, 250);   // Azul muy claro
                Color colorImpar = new Color(255, 255, 255); // Blanco

                // Obtener el valor del estado (última columna)
                int columnaEstado = table.getColumnCount() - 1;
                Object valorEstado = table.getValueAt(row, columnaEstado);

                // Si el alumno está inactivo
                if (valorEstado != null && valorEstado.toString().equalsIgnoreCase("inactivo")) {
                    c.setBackground(new Color(200, 0, 0)); // Fondo rojo
                    c.setForeground(Color.WHITE);           // Texto blanco
                } 
                else if (isSelected) {
                    // Color al seleccionar
                    c.setBackground(new Color(45, 65, 90)); // Azul oscuro
                    c.setForeground(Color.WHITE);
                    c.setFont(c.getFont().deriveFont(Font.BOLD));
                } 
                else {
                    // Colores normales intercalados
                    if (row % 2 == 0) {
                        c.setBackground(colorPar);
                    } else {
                        c.setBackground(colorImpar);
                    }
                    c.setForeground(Color.BLACK);
                }

                c.setFont(new Font("Segoe UI", Font.PLAIN, 13));
                return c;
            }
        });

        // Personalizar encabezado
        JTableHeader header = tabla.getTableHeader();
        header.setBackground(new Color(60, 120, 180)); // Azul medio
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
    }
}
