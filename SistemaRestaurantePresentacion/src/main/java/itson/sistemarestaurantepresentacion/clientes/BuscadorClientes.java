/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package itson.sistemarestaurantepresentacion.clientes;

import itson.sistemarestaurantedominio.Cliente;
import itson.sistemarestaurantenegocio.IClientesBO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantenegocio.utilidades.EncriptadorAES;
import itson.sistemarestaurantepresentacion.Render;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author victoria
 */
public class BuscadorClientes extends javax.swing.JFrame {

    private Consumer<Cliente> onClienteSeleccionado;
    private List<Cliente> clientes;
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
        this.clientes = new ArrayList<>();
        this.clientesBO = clientesBO;
        this.cargarTabla();
        this.onClienteSeleccionado = onClienteSeleccionado;
        this.ocultarColumnaIndice();
    }
    
    private void ocultarColumnaIndice() {
        TableColumnModel columnModel = tablaClientes.getColumnModel();
        TableColumn columnaIndice = columnModel.getColumn(0);
        columnModel.removeColumn(columnaIndice);
    }

    private void cargarTabla() {
        tablaClientes.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel modeloTabla = new DefaultTableModel(
            new String[]{"Índice", "Nombre", "Correo", "Numero Telefono", "Puntos Fidelidad"},
            0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        modeloTabla.setRowCount(0);
        tablaClientes.setModel(modeloTabla);
        tablaClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    }

    private void llenarTablaClientes() {
        try {
            String filtroBusqueda = this.buscarLbl.getText().trim();
            this.clientes = this.clientesBO.consultar(filtroBusqueda);
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaClientes.getModel();
            modeloTabla.setRowCount(0);

            for (int i = 0; i < clientes.size(); i++) {
                Cliente cliente = clientes.get(i);
                String nombreCompleto = cliente.getNombre() + " " + (cliente.getApellidoPaterno() != null ? cliente.getApellidoPaterno() : "");
                if (cliente.getApellidoMaterno() != null && !cliente.getApellidoMaterno().isEmpty()) {
                    nombreCompleto += " " + cliente.getApellidoMaterno();
                }

                String numeroTelefonoDesencriptado;
                try {
                    numeroTelefonoDesencriptado = EncriptadorAES.desencriptar(cliente.getNumeroTelefono());
                } catch (Exception ex) {
                    numeroTelefonoDesencriptado = "Error al desencriptar";
                    System.err.println("Error al desencriptar el numero de telefono: " + ex.getMessage());
                }

                Object[] fila = {
                    i,
                    nombreCompleto.trim(),
                    cliente.getCorreo(),
                    numeroTelefonoDesencriptado,
                    cliente.getPuntosFidelidad()
                };
                modeloTabla.addRow(fila);
            }
        } catch (NegocioException ex) {
            LOG.severe("No se pudo llenar la tabla: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void LimpiarTabla(JTable tabla, DefaultTableModel modeloTabla) {
        this.buscarLbl.setText("");
        modeloTabla.setRowCount(0);
    }
    
    private Integer obtenerIndiceCliente() {
        int filaSeleccionada = tablaClientes.getSelectedRow();
        if (filaSeleccionada != -1) {
            return Integer.parseInt(tablaClientes.getModel().getValueAt(filaSeleccionada, 0).toString());
        }
        return null;
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
        buscarLbl = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        btnSeleccionarCliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblBuscar.setText("Buscar");

        buscarLbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarLblActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buscarLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(buscarLbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void buscarLblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarLblActionPerformed
        this.llenarTablaClientes();
    }//GEN-LAST:event_buscarLblActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        this.llenarTablaClientes();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        this.buscarLbl.setText("");
        this.llenarTablaClientes();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnSeleccionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarClienteActionPerformed
        int filaSeleccionada = tablaClientes.getSelectedRow();
        if (filaSeleccionada != -1) {
            Integer indice = obtenerIndiceCliente();
            if (indice != null && indice >= 0 && indice < clientes.size()) {
                Cliente cliente = clientes.get(indice);
                if (onClienteSeleccionado != null) {
                    onClienteSeleccionado.accept(cliente);
                }
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al obtener el cliente seleccionado. Por favor, intenta de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un cliente haciendo clic en una fila de la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSeleccionarClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSeleccionarCliente;
    private javax.swing.JTextField buscarLbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JTable tablaClientes;
    // End of variables declaration//GEN-END:variables
}
