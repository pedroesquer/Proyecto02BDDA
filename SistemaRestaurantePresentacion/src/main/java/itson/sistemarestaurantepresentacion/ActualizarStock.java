package itson.sistemarestaurantepresentacion;

import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import itson.sistemarestaurantenegocio.IIngredientesBO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantepresentacion.control.Control;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pedro Morales Esquer, Juan Pablo Heras Carrazco, Victoria Valenzuela
 * Sooto
 */
public class ActualizarStock extends javax.swing.JFrame {

    /**
     * Creates new form Productos
     */
    private IIngredientesBO ingredientesBO;
    private static final Logger LOG = Logger.getLogger(BuscadorIngredientes.class.getName());

    public ActualizarStock(IIngredientesBO ingredientesBO) {
        initComponents();
        this.setTitle("Ingredientes");
        this.setResizable(false);
        this.setSize(760, 500);
        this.setLocationRelativeTo(null);
        this.ingredientesBO = ingredientesBO;
        this.llenarTablaIngredientes();
    }

    private void llenarTablaIngredientes() {
        try {

            List<Ingrediente> ingredientes = this.ingredientesBO.consultar("");
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

    public void actualizarIngredientesSeleccionados(NuevoIngredienteDTO ingredienteSeleccionado) {
        try {
            // Este objeto permite interactuar con los elementos de la tabla
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaIngredientes.getModel();
            modeloTabla.setRowCount(0); // Limpiamos la tabla antes de llenarla nuevamente

            // Llenamos la tabla con los ingredientes seleccionados
            Object[] fila = {
                ingredienteSeleccionado.getId(),
                ingredienteSeleccionado.getNombre(),
                ingredienteSeleccionado.getUnidadMedida(),
                ingredienteSeleccionado.getStock()
            };
            modeloTabla.addRow(fila);

            lblStockActual.setText(String.valueOf(ingredienteSeleccionado.getStock()));

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

        jTextField1 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        panelGeneral = new javax.swing.JPanel();
        panelSuperior = new javax.swing.JPanel();
        lblTituloIngrediente = new javax.swing.JLabel();
        iconChefSoft = new javax.swing.JLabel();
        iconIngrediente = new javax.swing.JLabel();
        pnlTablaProductos = new javax.swing.JScrollPane();
        tablaIngredientes = new javax.swing.JTable();
        iconBuscar = new javax.swing.JLabel();
        lblStockActual = new javax.swing.JLabel();
        campoStock = new javax.swing.JTextField();
        lblStockActualizar = new javax.swing.JLabel();
        lblStockActualMostrar = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelGeneral.setBackground(new java.awt.Color(255, 253, 211));

        panelSuperior.setBackground(new java.awt.Color(235, 230, 208));

        lblTituloIngrediente.setFont(new java.awt.Font("Helvetica Neue", 0, 64)); // NOI18N
        lblTituloIngrediente.setText("Ingredientes");

        iconChefSoft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoPequenioStroke.png"))); // NOI18N

        iconIngrediente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ingredientesIcon.png"))); // NOI18N

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconChefSoft)
                .addGap(117, 117, 117)
                .addComponent(lblTituloIngrediente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iconIngrediente)
                .addGap(52, 52, 52))
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSuperiorLayout.createSequentialGroup()
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelSuperiorLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTituloIngrediente))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSuperiorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(iconChefSoft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSuperiorLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(iconIngrediente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

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

        lblStockActual.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        lblStockActual.setText("Stock actual:");

        campoStock.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N

        lblStockActualizar.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        lblStockActualizar.setText("Stock a actualizar:");

        lblStockActualMostrar.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGeneralLayout = new javax.swing.GroupLayout(panelGeneral);
        panelGeneral.setLayout(panelGeneralLayout);
        panelGeneralLayout.setHorizontalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSuperior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGeneralLayout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(lblStockActualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoStock, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeneralLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(286, 286, 286)))
                        .addComponent(iconBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(lblStockActual)
                        .addGap(165, 165, 165)
                        .addComponent(lblStockActualMostrar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelGeneralLayout.createSequentialGroup()
                    .addGap(152, 152, 152)
                    .addComponent(pnlTablaProductos)
                    .addGap(152, 152, 152)))
        );
        panelGeneralLayout.setVerticalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addComponent(panelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStockActual)
                    .addComponent(lblStockActualMostrar))
                .addGap(55, 55, 55)
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(iconBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStockActualizar)
                            .addComponent(campoStock, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(btnActualizar)))
                .addGap(49, 49, 49))
            .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelGeneralLayout.createSequentialGroup()
                    .addGap(128, 128, 128)
                    .addComponent(pnlTablaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(293, Short.MAX_VALUE)))
        );

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

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JTextField campoStock;
    private javax.swing.JLabel iconBuscar;
    private javax.swing.JLabel iconChefSoft;
    private javax.swing.JLabel iconIngrediente;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblStockActual;
    private javax.swing.JLabel lblStockActualMostrar;
    private javax.swing.JLabel lblStockActualizar;
    private javax.swing.JLabel lblTituloIngrediente;
    private javax.swing.JPanel panelGeneral;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JScrollPane pnlTablaProductos;
    private javax.swing.JTable tablaIngredientes;
    // End of variables declaration//GEN-END:variables
}
