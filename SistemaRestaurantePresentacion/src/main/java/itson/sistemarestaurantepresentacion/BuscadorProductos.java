/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package itson.sistemarestaurantepresentacion;

import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.TipoProducto;
import itson.sistemarestaurantenegocio.IProductosBO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pedro Morales Esquer, Juan Pablo Heras Carrazco, Victoria Valenzuela
 * Soto
 */
public class BuscadorProductos extends javax.swing.JFrame {

    private IProductosBO productosBO;
    private static final Logger LOG = Logger.getLogger(BuscadorProductos.class.getName());

    /**
     * Constructor del frame BuscadorProductos.
     * @param productosBO
     */
    public BuscadorProductos(IProductosBO productosBO) {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Buscador Productos");
        this.productosBO = productosBO;
//        this.llenarTablaProductos();
        this.cargarTabla();

    }

    private void cargarTabla() {
        tablaProductos.setDefaultRenderer(Object.class, new Render());

        String[] columnas = new String[]{"ID", "Nombre", "Precio", "Tipo", "Seleccion"};
        boolean[] editable = {false, false, false, false, true};
        Class[] types = new Class[]{java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class};

        DefaultTableModel mModel = new DefaultTableModel(columnas, 0) {
            public Class getColumnClass(int i) {
                return types[i];
            }

            public boolean isCellEditable(int row, int column) {
                return editable[column];
            }
        };

        LimpiarTabla(tablaProductos, mModel);

        Object[] datos = new Object[columnas.length];
        try {
            String filtroBusqueda = this.txtBuscar.getText();
            List<Producto> productos = this.productosBO.consultar(filtroBusqueda);
            for (Producto producto : productos) {
                
                datos[0] = String.valueOf(producto.getId());
                datos[1] = producto.getNombre();
                datos[2] = String.valueOf(producto.getPrecio());
                datos[3] = String.valueOf(producto.getTipo());
                datos[4] = false;
                
                mModel.addRow(datos);
            }
            
            tablaProductos.setModel(mModel);
            
            // Implementar un listener para cambiar el estado del checkbox
        tablaProductos.getModel().addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                if (column == 4) {  // Si la columna seleccionada es la de los checkboxes (índice 4)
                    boolean selected = (boolean) mModel.getValueAt(row, column);
                    // Si el checkbox de esa fila se seleccionó, desmarcar los demás
                    if (selected) {
                        for (int i = 0; i < mModel.getRowCount(); i++) {
                            if (i != row) {
                                mModel.setValueAt(false, i, 4);  // Desmarcar las otras filas
                            }
                        }
                    }
                }
            }
        });
        } catch (NegocioException ex) {
            JOptionPane.showInputDialog(this, ex.getMessage());            
        }
    }

    public void LimpiarTabla(JTable tabla, DefaultTableModel modeloTabla) {
        if (modeloTabla.getRowCount() > 0) {
            for (int i = 0; i < tabla.getRowCount(); i++) {
                modeloTabla.removeRow(i);
                i -= 1;
            }
        }
    }

    private void llenarTablaProductos() {
        try {
            String filtroBusqueda = this.txtBuscar.getText();
            List<Producto> productos = this.productosBO.consultar(filtroBusqueda);
            //Este objeto permite interactuar con los elementos de la tabla
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaProductos.getModel();
            modeloTabla.setRowCount(0);
            for (Producto producto : productos) {
                Object[] fila = {
                    producto.getId(),
                    producto.getNombre(),
                    producto.getPrecio(),
                    producto.getTipo()
                };
                modeloTabla.addRow(fila);
            }
        } catch (NegocioException ex) {
            LOG.severe("No se pudo llenar la tabla");
            JOptionPane.showInputDialog(this, ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        pnlTablaProductos = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        btnLimpiar = new javax.swing.JButton();
        botonSeleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblBuscar.setText("Buscar");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Producto", "Precio", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProductos.setColumnSelectionAllowed(true);
        pnlTablaProductos.setViewportView(tablaProductos);
        tablaProductos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        botonSeleccionar.setText("Seleccionar producto");
        botonSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSeleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTablaProductos)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonSeleccionar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBuscar)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlTablaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonSeleccionar)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        //Aqui iria la lógica para encontrar las coincidencias
//        this.llenarTablaProductos();
          this.cargarTabla();

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.txtBuscar.setText("");
            this.cargarTabla();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void botonSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSeleccionarActionPerformed
        for (int i = 0; i < tablaProductos.getRowCount(); i++) {
            //Verificamos si el checkbox, que esta en la columna 4, esta marcada
            Boolean isSelected = (Boolean) tablaProductos.getValueAt(i, 4);
            
            //Se verifica que en efecto este seleccionada la tabla o no, y luego si es postiva
            if(isSelected != null && isSelected){
                Long id = Long.valueOf((String)tablaProductos.getValueAt(i, 0));
                String nombre = (String) tablaProductos.getValueAt(i, 1);
                Float precio = Float.parseFloat((String) tablaProductos.getValueAt(i, 2));
                String tipo = (String) tablaProductos.getValueAt(i, 3);
                
                JOptionPane.showMessageDialog(this, "ID  "+ id + " nombre " + nombre + " precio "+ precio + " tipo "
                        + tipo);
                break; //Aqui iria un return para matar el proceso y mandar el producto seleccionado
            } 
            
        }
        JOptionPane.showMessageDialog(this, "No seleccionaste nada");
    }//GEN-LAST:event_botonSeleccionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonSeleccionar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JScrollPane pnlTablaProductos;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
