/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sistemarestaurantepresentacion;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author juanpheras
 */
public class Render extends DefaultTableCellRenderer{
    
    public Component getTableCellRenderComponent(JTable table,  Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
       if(value instanceof JCheckBox) {
           JCheckBox jCheckbox = (JCheckBox) value;
           
           return jCheckbox;
       }
        
       return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
