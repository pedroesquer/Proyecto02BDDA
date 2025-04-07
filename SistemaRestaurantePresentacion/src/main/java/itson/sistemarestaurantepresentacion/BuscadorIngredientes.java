package itson.sistemarestaurantepresentacion;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.UnidadMedida;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import itson.sistemarestaurantenegocio.IIngredientesBO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantepresentacion.control.Control;
import itson.sistemarestaurantepresentacion.observers.IngredienteSeleccionadoObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
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
public class BuscadorIngredientes extends javax.swing.JFrame {

    private List<IngredienteSeleccionadoObserver> observers = new ArrayList<>();
    private NuevoIngredienteDTO nuevoIngredienteDTO;
    private IIngredientesBO ingredientesBO;
    private static final Logger LOG = Logger.getLogger(BuscadorIngredientes.class.getName());

    /**
     * Constructor del frame BuscadorProductos.
     */
    public BuscadorIngredientes(IIngredientesBO ingredientesBO) {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Buscador Ingredientes");
        this.ingredientesBO = ingredientesBO;
        this.cargarTabla();

    }

    private void cargarTabla() {
        tablaIngredientes.setDefaultRenderer(Object.class, new Render());

        String[] columnas = new String[]{"ID", "Ingrediente", "Unidad", "Stock", "Seleccion"};
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

        LimpiarTabla(tablaIngredientes, mModel);

        Object[] datos = new Object[columnas.length];
        try {
            String filtroBusqueda = this.txtBuscar.getText();
            List<Ingrediente> ingredientes = this.ingredientesBO.consultar(filtroBusqueda);
            for (Ingrediente ingrediente : ingredientes) {

                datos[0] = String.valueOf(ingrediente.getId());
                datos[1] = ingrediente.getNombre();
                datos[2] = String.valueOf(ingrediente.getUnidadMedida());
                datos[3] = String.valueOf(ingrediente.getStock());
                datos[4] = false;

                mModel.addRow(datos);
            }

            tablaIngredientes.setModel(mModel);

            tablaIngredientes.getModel().addTableModelListener(e -> {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int row = e.getFirstRow();
                    int column = e.getColumn();
                    if (column == 4) {  
                        boolean selected = (boolean) mModel.getValueAt(row, column);
                        
                        if (selected) {
                            for (int i = 0; i < mModel.getRowCount(); i++) {
                                if (i != row) {
                                    mModel.setValueAt(false, i, 4);  
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

    /**
     * Registra un nuevo observador para ser notificado cuando un jugador sea
     * seleccionado.
     *
     * @param obs la clase que implementa JugadorSeleccionadoObserver
     */
    public void agregarObserver(IngredienteSeleccionadoObserver obs) {
        observers.add(obs);
    }

    /**
     * Notifica a todos los observadores registrados que un jugador ha sido
     * seleccionado.
     *
     * @param jugador el jugador seleccionado
     */
    private void notificarObservers(NuevoIngredienteDTO ingrediente) {
        for (IngredienteSeleccionadoObserver o : observers) {
            o.ingredienteSeleccionado(ingrediente);
        }
    }

    private void llenarTablaIngredientes() {
        try {
            String filtroBusqueda = this.txtBuscar.getText();
            List<Ingrediente> ingredientes = this.ingredientesBO.consultar(filtroBusqueda);
            //Este objeto permite interactuar con los elementos de la tabla
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaIngredientes.getModel();
            modeloTabla.setRowCount(0);
            for (Ingrediente ingrediente : ingredientes) {
                Object[] fila = {
                    ingrediente.getId(),
                    ingrediente.getNombre(),
                    ingrediente.getUnidadMedida(),
                    ingrediente.getStock()
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
        tablaIngredientes = new javax.swing.JTable();
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

        tablaIngredientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ingrediente", "Unidad de Medida", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaIngredientes.setColumnSelectionAllowed(true);
        pnlTablaProductos.setViewportView(tablaIngredientes);
        tablaIngredientes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tablaIngredientes.getColumnModel().getColumnCount() > 0) {
            tablaIngredientes.getColumnModel().getColumn(0).setResizable(false);
            tablaIngredientes.getColumnModel().getColumn(1).setResizable(false);
            tablaIngredientes.getColumnModel().getColumn(3).setResizable(false);
        }

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        botonSeleccionar.setText("Seleccionar ingrediente");
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
        this.llenarTablaIngredientes();

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.txtBuscar.setText("");  // Limpiar el campo de búsqueda
        DefaultTableModel model = (DefaultTableModel) tablaIngredientes.getModel();
        model.setRowCount(0);  // Limpiar las filas de la tabla
        this.cargarTabla();  // Volver a cargar la tabla con los datos originales
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void botonSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSeleccionarActionPerformed
        for (int i = 0; i < tablaIngredientes.getRowCount(); i++) {
            Boolean isSelected = (Boolean) tablaIngredientes.getValueAt(i, 4);

            if (Boolean.TRUE.equals(isSelected)) {
                Object idObj = tablaIngredientes.getValueAt(i, 0);
                Long id = (idObj instanceof Long) ? (Long) idObj : Long.valueOf(idObj.toString());

                String nombre = tablaIngredientes.getValueAt(i, 1).toString();
                String unidadMedidaString = tablaIngredientes.getValueAt(i, 2).toString();
                UnidadMedida unidadMedida = UnidadMedida.valueOf(unidadMedidaString);

                String stockString = tablaIngredientes.getValueAt(i, 3).toString();
                Integer stock = Integer.valueOf(stockString);

                NuevoIngredienteDTO nuevoIngrediente = new NuevoIngredienteDTO(id, nombre, stock, unidadMedida);
                notificarObservers(nuevoIngrediente);
                break;
            }
        }
        this.dispose();


    }//GEN-LAST:event_botonSeleccionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonSeleccionar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JScrollPane pnlTablaProductos;
    private javax.swing.JTable tablaIngredientes;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
