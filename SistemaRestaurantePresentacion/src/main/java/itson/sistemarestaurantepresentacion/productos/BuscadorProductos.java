/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package itson.sistemarestaurantepresentacion.productos;

import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.TipoProducto;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import itson.sistemarestaurantedominio.dtos.NuevoProductoDTO;
import itson.sistemarestaurantenegocio.IProductosBO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantepresentacion.observers.IngredienteSeleccionadoObserver;
import itson.sistemarestaurantepresentacion.observers.ProductoSeleccionadoObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
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
    private List<ProductoSeleccionadoObserver> observers = new ArrayList<>();

    /**
     * Constructor del frame BuscadorProductos.
     *
     * @param productosBO
     */
    public BuscadorProductos(IProductosBO productosBO) {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Buscador Productos");
        this.productosBO = productosBO;
//        this.llenarTablaProductos();
        tablaProductos.removeColumn(tablaProductos.getColumnModel().getColumn(0));
        this.cargarTabla();

    }

    /**
     * Método que carga la tabla dependiendo del filtro de busqueda.
     * 
     */
    private void cargarTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaProductos.getModel();
        modeloTabla.setRowCount(0);

        String filtro = this.txtBuscar.getText();
        try {
            List<Producto> productos = this.productosBO.consultar(filtro);

            for (Producto producto : productos) {
                modeloTabla.addRow(new Object[]{
                    producto.getId(),
                    producto.getNombre(),
                    producto.getPrecio(),
                    producto.getTipo()
                });
            }

        } catch (NegocioException ex) {
            JOptionPane.showInputDialog(this, ex.getMessage());
        }
    }

    /**
     * Registra un nuevo observador para ser notificado cuando un jugador sea
     * seleccionado.
     *
     * @param obs la clase que implementa JugadorSeleccionadoObserver
     */
    public void agregarObserver(ProductoSeleccionadoObserver obs) {
        observers.add(obs);
    }

    /**
     * Notifica a todos los observadores registrados que un jugador ha sido
     * seleccionado.
     *
     * @param producto el jugador seleccionado
     */
    private void notificarObservers(NuevoProductoDTO producto) {
        for (ProductoSeleccionadoObserver o : observers) {
            o.productoSeleccionado(producto);
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
        jButton1 = new javax.swing.JButton();

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
        tablaProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        jButton1.setText("ID");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addGap(137, 137, 137)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonSeleccionar)
                    .addComponent(jButton1))
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
        int filaSeleccionada = tablaProductos.getSelectedRow();
        if (filaSeleccionada != -1) {
            Long id = obtenerIdProducto();
            String nombre = (String) tablaProductos.getModel().getValueAt(filaSeleccionada, 1);
            Float precio = Float.parseFloat(tablaProductos.getModel().getValueAt(filaSeleccionada, 2).toString());
            TipoProducto tipo = (TipoProducto) tablaProductos.getModel().getValueAt(filaSeleccionada, 3);
            //TipoProducto tipoProducto = TipoProducto.valueOf(tipo);

            NuevoProductoDTO nuevoProducto = new NuevoProductoDTO(id, nombre, precio, tipo);
            notificarObservers(nuevoProducto);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "No seleccionaste nada");
        }

    }//GEN-LAST:event_botonSeleccionarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Long id = obtenerIdProducto();
        if (id != null) {
            JOptionPane.showMessageDialog(this, "ID seleccionado " + id);
        } else {
            JOptionPane.showMessageDialog(this, "Debes seleccionar una celda ");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private Long obtenerIdProducto() {
        int filaSeleccionada = tablaProductos.getSelectedRow();
        if (filaSeleccionada != -1) {
            return Long.valueOf(tablaProductos.getModel().getValueAt(filaSeleccionada, 0).toString());
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonSeleccionar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JScrollPane pnlTablaProductos;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
