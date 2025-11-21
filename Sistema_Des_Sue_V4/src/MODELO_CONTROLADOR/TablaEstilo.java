
package MODELO_CONTROLADOR;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class TablaEstilo {
    // Método estático para aplicar el diseño a cualquier JTable
    public static void personalizarTabla(JTable tabla) {

        tabla.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // 🎨 Colores intercalados en RGB
                Color colorPar = new Color(255,204,204);   // coral claro
                Color colorImpar = new Color(255,153,153); // coral oscuro
                
                
                if (isSelected) {
                    // 🟦 Si está seleccionada la celda
                    c.setBackground(new Color(  10, 132, 255 ));   //  aca ponemos el color con el que queremos que tenga el fondo al seleccionar un registro, en este caso un celestito claro
                    c.setForeground(Color.WHITE);             // Texto blanco
                    c.setFont(c.getFont().deriveFont(Font.BOLD)); // Negrita opcional
                } else {
                    // 🧊 Si no está seleccionada
                    if (row % 2 == 0) {
                        c.setBackground(colorPar);
                    } else {
                        c.setBackground(colorImpar);
                    }
                    c.setForeground(Color.BLACK); // Texto normal
                }

              /*  if (!isSelected) {
                    if (row % 2 == 0) {
                        c.setBackground(colorPar);
                    } else {
                        c.setBackground(colorImpar);
                    }
                } else {
                    // Color de selección
                    c.setBackground(new Color(255, 51, 51));
                    
                }*/

                // 🟢 Color del texto
              

                // 🔠 Fuente opcional
                c.setFont(new Font("Segoe UI", Font.PLAIN, 13));

                return c;
            }
        });

        // 🧭 Opcional: personalizar encabezado
        JTableHeader header = tabla.getTableHeader();
        header.setBackground(new Color(255, 102, 102)); // azul medio
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
    }
}
