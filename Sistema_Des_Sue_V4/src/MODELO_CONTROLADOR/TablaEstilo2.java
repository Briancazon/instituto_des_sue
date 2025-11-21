
package MODELO_CONTROLADOR;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;


public class TablaEstilo2 {
    
    public static void personalizarTabla(JTable tabla) {

        tabla.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Colores de fondo intercalados (usando RGB)
                Color colorPar = new Color(255,204,204);   // coral claro
                Color colorImpar = new Color(255,153,153); // coral oscuro

                // Obtener el valor del estado (última columna)
                int columnaEstado = table.getColumnCount() - 1;
                Object valorEstado = table.getValueAt(row, columnaEstado);

                // Si el alumno está inactivo
                if (valorEstado != null && valorEstado.toString().equalsIgnoreCase("INACTIVO")) {
                    c.setBackground(new Color(255, 51, 51)); // Fondo rojo
                    c.setForeground(Color.WHITE);           // Texto blanco
                } 
                else if (isSelected) {
                    // Color al seleccionar
                    c.setBackground(new Color(10, 132, 255)); //   aca ponemos el color con el que queremos que tenga el fondo al seleccionar un registro, en este caso un celestito claro
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
        header.setBackground(new Color(255, 102, 102)); // Azul medio
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
    }
    
    
    
    
    
    
    
    
    
    
    
}
