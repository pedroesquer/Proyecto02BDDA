/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package itson.sistemarestaurantepresentacion;

import itson.sistemarestaurantedominio.Cliente;
import itson.sistemarestaurantenegocio.IClientesBO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import java.awt.Frame;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victoria
 */
public class BuscadorClientes extends javax.swing.JFrame {

    private Consumer<Cliente> onClienteSeleccionado; 
    private IClientesBO clientesBO;
    private static final Logger LOG = Logger.getLogger(BuscadorClientes.class.getName());

    /**
     * Constructor del frame BuscadorClientes.
     */
    public BuscadorClientes(IClientesBO clientesBO, Consumer<Cliente> onClienteSeleccionado) {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Buscador Clientes");
        this.clientesBO = clientesBO;
        this.cargarTabla();
        this.onClienteSeleccionado = onClienteSeleccionado; 
    }

    private void cargarTabla() {
        tablaClientes.setDefaultRenderer(Object.class, new Render());

        String[] columnas = new String[]{"Nombre", "Correo", "Numero Telefono", "Puntos Fidelidad", "Seleccion"};
        boolean[] editable = {false, false, false, false, true};
        Class[] types = new Class[]{java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class};

        DefaultTableModel mModel = new DefaultTableModel(columnas, 0) {
            @Override
            public Class getColumnClass(int i) {
                return types[i];
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return editable[column];
            }
        };

        LimpiarTabla(tablaClientes, mModel);

        Object[] datos = new Object[columnas.length];
        try {
            String filtroBusqueda = this.jTextField1.getText();
            List<Cliente> clientes = this.clientesBO.consultar(filtroBusqueda);
            for (Cliente cliente : clientes) {
                datos[0] = cliente.getNombre();
                datos[1] = cliente.getCorreo();
                datos[2] = cliente.getNumeroTelefono();
                datos[3] = cliente.getPuntosFidelidad();
                datos[4] = false;

                mModel.addRow(datos);
            }

            tablaClientes.setModel(mModel);

            // Implementar un listener para cambiar el estado del checkbox
            tablaClientes.getModel().addTableModelListener(e -> {
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

    private void llenarTablaClientes() {
        try {
            String filtroBusqueda = this.jTextField1.getText();
            List<Cliente> clientes = this.clientesBO.consultar(filtroBusqueda);
            //Este objeto permite interactuar con los elementos de la tabla
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaClientes.getModel();
            modeloTabla.setRowCount(0);
            for (Cliente cliente : clientes) {
                Object[] fila = {
                    cliente.getNombre(),
                    cliente.getCorreo(),
                    cliente.getNumeroTelefono(),
                    cliente.getPuntosFidelidad()
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
        jTextField1 = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        btnSeleccionarCliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblBuscar.setText("Buscar");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Correo", "Numero Telefono", "Puntos Fidelidad", "Seleccion"
            }
        ));
        jScrollPane1.setViewportView(tablaClientes);

        btnSeleccionarCliente.setText("Seleccionar Cliente");
        btnSeleccionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addGap(10, 10, 10)
                .addComponent(btnLimpiar)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(390, 390, 390)
                .addComponent(btnSeleccionarCliente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscar)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnLimpiar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSeleccionarCliente)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        this.llenarTablaClientes();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        this.jTextField1.setText("");
        this.llenarTablaClientes();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnSeleccionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarClienteActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < tablaClientes.getRowCount(); i++) {
            Boolean isSelected = (Boolean) tablaClientes.getValueAt(i, 4);

            if (Boolean.TRUE.equals(isSelected)) {
                String nombre = tablaClientes.getValueAt(i, 0).toString();
                String correo = tablaClientes.getValueAt(i, 1).toString();
                String numeroTelefono = tablaClientes.getValueAt(i, 2).toString();
                int puntosFidelidad = Integer.parseInt(tablaClientes.getValueAt(i, 3).toString());

                // Crear el cliente
                Cliente cliente = new Cliente(nombre, correo, numeroTelefono, puntosFidelidad);

                // Llamar al callback
                if (onClienteSeleccionado != null) {
                    onClienteSeleccionado.accept(cliente);
                }

                break;
            }
        }
        this.dispose();
    }//GEN-LAST:event_btnSeleccionarClienteActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSeleccionarCliente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JTable tablaClientes;
    // End of variables declaration//GEN-END:variables
}
