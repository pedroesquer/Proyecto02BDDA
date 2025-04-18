package itson.sistemarestaurantepresentacion.ingredientes;

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
public class ListaIngredientes extends javax.swing.JFrame implements IngredienteSeleccionadoObserver {

    /**
     * Creates new form Productos
     */
    private IIngredientesBO ingredientesBO;
    private static final Logger LOG = Logger.getLogger(BuscadorIngredientes.class.getName());

    public ListaIngredientes(IIngredientesBO ingredientesBO) {
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

     private void ocultarColumnaID() {
        TableColumnModel columnModel = tablaIngredientes.getColumnModel();
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
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaIngredientes.getModel();
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
        lblTituloIngrediente = new javax.swing.JLabel();
        iconChefSoft = new javax.swing.JLabel();
        iconIngrediente = new javax.swing.JLabel();
        pnlTablaIngrediente = new javax.swing.JScrollPane();
        tablaIngredientes = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
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
        pnlTablaIngrediente.setViewportView(tablaIngredientes);

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

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGeneralLayout = new javax.swing.GroupLayout(panelGeneral);
        panelGeneral.setLayout(panelGeneralLayout);
        panelGeneralLayout.setHorizontalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSuperior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeneralLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlTablaIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeneralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(339, 339, 339))
        );
        panelGeneralLayout.setVerticalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addComponent(panelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(btnLimpiar))
                .addGap(37, 37, 37)
                .addComponent(pnlTablaIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addGap(65, 65, 65))
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

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
        Control.getInstancia().abrirIngredientes();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Control.getInstancia().abrirBuscadorIngredientes(this);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        this.dispose();
        Control.getInstancia().abrirListaIngredientes();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel iconChefSoft;
    private javax.swing.JLabel iconIngrediente;
    private javax.swing.JLabel lblTituloIngrediente;
    private javax.swing.JPanel panelGeneral;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JScrollPane pnlTablaIngrediente;
    private javax.swing.JTable tablaIngredientes;
    // End of variables declaration//GEN-END:variables

    @Override
    public void ingredienteSeleccionado(NuevoIngredienteDTO ingrediente) {
        actualizarIngredientesSeleccionados(ingrediente);
    }
}
