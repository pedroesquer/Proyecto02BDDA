package itson.sistemarestaurantepresentacion.comandas;

import itson.sistemarestaurantepresentacion.ingredientes.*;
import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import itson.sistemarestaurantenegocio.IIngredientesBO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantepresentacion.control.Control;
import itson.sistemarestaurantepresentacion.observers.IngredienteSeleccionadoObserver;
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
public class ListaComandas extends javax.swing.JFrame implements IngredienteSeleccionadoObserver {

    /**
     * Creates new form Productos
     */
    private IIngredientesBO ingredientesBO;
    private static final Logger LOG = Logger.getLogger(BuscadorIngredientes.class.getName());

    public ListaComandas(IIngredientesBO ingredientesBO) {
        initComponents();
        this.setTitle("Lista ingredientes");
        this.setResizable(false);
        this.setSize(760, 500);
        this.setLocationRelativeTo(null);
        this.ingredientesBO = ingredientesBO;
        this.llenarTablaIngredientes();
        this.ocultarColumnaID();
    }

    /**
     * Llena la tabla con todos los ingredientes disponibles. Consulta los
     * ingredientes y los agrega a la tabla.
     */
    private void llenarTablaIngredientes() {
        try {
            List<Ingrediente> ingredientes = this.ingredientesBO.consultar("");
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaComandas.getModel();
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

     private void ocultarColumnaID() {
        TableColumnModel columnModel = tablaComandas.getColumnModel();
        TableColumn columnaID = columnModel.getColumn(0);
        columnModel.removeColumn(columnaID); 
    }
    /**
     * Actualiza la tabla con los datos de un ingrediente seleccionado.
     *
     * @param ingredienteSeleccionado El ingrediente a mostrar en la tabla.
     */
    public void actualizarIngredientesSeleccionados(NuevoIngredienteDTO ingredienteSeleccionado) {
        try {
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaComandas.getModel();
            modeloTabla.setRowCount(0); // Limpiamos la tabla antes de llenarla nuevamente

            Object[] fila = {
                ingredienteSeleccionado.getId(),
                ingredienteSeleccionado.getNombre(),
                ingredienteSeleccionado.getUnidadMedida(),
                ingredienteSeleccionado.getStock()
            };
            modeloTabla.addRow(fila);

        } catch (Exception ex) {
            LOG.severe("No se pudo actualizar la tabla con los ingredientes seleccionados");
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

        panelGeneral = new javax.swing.JPanel();
        panelSuperior = new javax.swing.JPanel();
        lblTituloComanda = new javax.swing.JLabel();
        iconChefSoft = new javax.swing.JLabel();
        iconComanda = new javax.swing.JLabel();
        pnlTablaComanda = new javax.swing.JScrollPane();
        tablaComandas = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
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

        panelGeneral.add(pnlTablaComanda, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 188, 491, 154));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        panelGeneral.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 125, -1));

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        panelGeneral.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(342, 414, 93, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
        Control.getInstancia().abrirIngredientes();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Control.getInstancia().abrirBuscadorIngredientes(this);
    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel iconChefSoft;
    private javax.swing.JLabel iconComanda;
    private javax.swing.JLabel lblTituloComanda;
    private javax.swing.JPanel panelGeneral;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JScrollPane pnlTablaComanda;
    private javax.swing.JTable tablaComandas;
    // End of variables declaration//GEN-END:variables

    @Override
    public void ingredienteSeleccionado(NuevoIngredienteDTO ingrediente) {
        actualizarIngredientesSeleccionados(ingrediente);
    }
}
