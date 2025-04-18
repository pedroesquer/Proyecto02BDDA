package itson.sistemarestaurantepresentacion.comandas;

import itson.sistemarestaurantedominio.Comanda;
import itson.sistemarestaurantepresentacion.ingredientes.*;
import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.Mesa;
import itson.sistemarestaurantedominio.dtos.NuevaComandaDTO;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import itson.sistemarestaurantenegocio.IComandasBO;
import itson.sistemarestaurantenegocio.IIngredientesBO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantepresentacion.control.Control;
import itson.sistemarestaurantepresentacion.observers.ComandaSeleccionadaObserver;
import itson.sistemarestaurantepresentacion.observers.IngredienteSeleccionadoObserver;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Pedro Morales Esquer, Juan Pablo Heras Carrazco, Victoria Valenzuela
 * Sooto
 */
public class ListaComandas extends javax.swing.JFrame {

    /**
     * Creates new form Productos
     */    
    private List<ComandaSeleccionadaObserver> observers = new ArrayList<>();

    private IComandasBO comandasBO;
    private static final Logger LOG = Logger.getLogger(BuscadorIngredientes.class.getName());

    public ListaComandas(IComandasBO comandasBO) {
        initComponents();
        this.setTitle("Lista comandas");
        this.setResizable(false);
        this.setSize(760, 500);
        this.setLocationRelativeTo(null);
        this.comandasBO = comandasBO;

        this.llenarTablaComandas();
        this.ocultarColumnaID();

    }
    /**
    * Registra un nuevo observador para ser notificado cuando una comanda sea
    * seleccionado.
    *
     * @param
    obs la clase que implementa ComandaSeleccionadaObserver

    */
    public void agregarObserver(ComandaSeleccionadaObserver obs) {
        observers.add(obs);
    }

    /**
     * Notifica a todos los observadores registrados que una comanda ha sido
     * seleccionado.
     *
     * @param comanda la comanda seleccionada
     */
    private void notificarObservers(NuevaComandaDTO comanda) {
        for (ComandaSeleccionadaObserver o : observers) {
            o.comandaSeleccionada(comanda);
        }
    }

    private Long obtenerIdComanda() {
        int filaSeleccionada = tablaComandas.getSelectedRow();
        if (filaSeleccionada != -1) {
            return Long.valueOf(tablaComandas.getModel().getValueAt(filaSeleccionada, 0).toString());
        }
        return null;
    }

    /**
     * Llena la tabla con todos los ingredientes disponibles. Consulta los
     * ingredientes y los agrega a la tabla.
     */
    private void llenarTablaComandas() {
        try {
            List<Comanda> comandas = this.comandasBO.consultar();
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaComandas.getModel();
            modeloTabla.setRowCount(0);
            for (Comanda comanda : comandas) {
                Object[] fila = {
                    comanda.getId(),
                    comanda.getMesa().getNumeroMesa(),
                    comanda.getFechaHora(),
                    comanda.getMontoTotal()
                };
                modeloTabla.addRow(fila);
            }
        } catch (NegocioException ex) {
            LOG.severe("No se pudo llenar la tabla");
            JOptionPane.showInputDialog(this, ex.getMessage());
        }
    }

    private void ocultarColumnaID() {
        TableColumnModel columnModel = tablaComandas.getColumnModel();
        TableColumn columnaID = columnModel.getColumn(0);
        columnModel.removeColumn(columnaID);
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGeneral = new javax.swing.JPanel();
        panelSuperior = new javax.swing.JPanel();
        lblTituloComanda = new javax.swing.JLabel();
        iconChefSoft = new javax.swing.JLabel();
        iconComanda = new javax.swing.JLabel();
        pnlTablaComanda = new javax.swing.JScrollPane();
        tablaComandas = new javax.swing.JTable();
        btnSeleccionComanda = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelGeneral.setBackground(new java.awt.Color(255, 253, 211));
        panelGeneral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelSuperior.setBackground(new java.awt.Color(235, 230, 208));

        lblTituloComanda.setFont(new java.awt.Font("Helvetica Neue", 0, 64)); // NOI18N
        lblTituloComanda.setText("Comandas");

        iconChefSoft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoPequenioStroke.png"))); // NOI18N

        iconComanda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/comandasIcon.png"))); // NOI18N

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconChefSoft)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addComponent(lblTituloComanda)
                .addGap(101, 101, 101)
                .addComponent(iconComanda)
                .addGap(49, 49, 49))
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSuperiorLayout.createSequentialGroup()
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSuperiorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(iconChefSoft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSuperiorLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelSuperiorLayout.createSequentialGroup()
                                .addComponent(lblTituloComanda)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(iconComanda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        panelGeneral.add(panelSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        tablaComandas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mesa", "Hora", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaComandas.setColumnSelectionAllowed(true);
        pnlTablaComanda.setViewportView(tablaComandas);
        tablaComandas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tablaComandas.getColumnModel().getColumnCount() > 0) {
            tablaComandas.getColumnModel().getColumn(0).setResizable(false);
            tablaComandas.getColumnModel().getColumn(1).setResizable(false);
            tablaComandas.getColumnModel().getColumn(3).setResizable(false);
        }

        panelGeneral.add(pnlTablaComanda, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 188, 491, 154));

        btnSeleccionComanda.setText("Seleccionar comanda");
        btnSeleccionComanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionComandaActionPerformed(evt);
            }
        });
        panelGeneral.add(btnSeleccionComanda, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 370, 150, -1));

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        panelGeneral.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 93, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Control.getInstancia().abrirComandas();

        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnSeleccionComandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionComandaActionPerformed
        int filaSeleccionada = tablaComandas.getSelectedRow();
        if (filaSeleccionada != -1) {
            Long id = obtenerIdComanda();
            Control.getInstancia().abrirDetallesComanda(id);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "No seleccionaste nada");
        }
        this.dispose();  // Cerrar la ventanaControl.getInstancia().abrirBuscadorIngredientes(this);
    }//GEN-LAST:event_btnSeleccionComandaActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleccionComanda;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel iconChefSoft;
    private javax.swing.JLabel iconComanda;
    private javax.swing.JLabel lblTituloComanda;
    private javax.swing.JPanel panelGeneral;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JScrollPane pnlTablaComanda;
    private javax.swing.JTable tablaComandas;
    // End of variables declaration//GEN-END:variables


}
