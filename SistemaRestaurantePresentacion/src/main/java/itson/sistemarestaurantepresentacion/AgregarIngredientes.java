package itson.sistemarestaurantepresentacion;

import itson.sistemarestaurantepresentacion.productos.AgregarProducto;
import itson.sistemarestaurantedominio.Ingrediente;
import itson.sistemarestaurantedominio.UnidadMedida;
import static itson.sistemarestaurantedominio.UnidadMedida.GRAMOS;
import static itson.sistemarestaurantedominio.UnidadMedida.MILILITROS;
import static itson.sistemarestaurantedominio.UnidadMedida.PIEZAS;
import itson.sistemarestaurantedominio.dtos.NuevoIngredienteDTO;
import itson.sistemarestaurantenegocio.IIngredientesBO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantepresentacion.control.Control;
import java.util.logging.Logger;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Morales Esquer, Juan Pablo Heras Carrazco, Victoria Valenzuela Soto
 */
public class AgregarIngredientes extends javax.swing.JFrame {

    private IIngredientesBO ingredientesBO;
    private static final Logger LOG = Logger.getLogger(AgregarProducto.class.getName());

    /**
     * Creates new form AgregarIngredSientes
     */
    public AgregarIngredientes(IIngredientesBO ingredientesBO) {
        initComponents();
        this.setTitle("Agregar ingredientes");
        this.setResizable(false);
        this.setSize(760, 500);
        this.setLocationRelativeTo(null);
        comboBoxUnidad.setModel(new javax.swing.DefaultComboBoxModel<>(new UnidadMedida[]{GRAMOS, PIEZAS, MILILITROS}));
        this.ingredientesBO = ingredientesBO;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoTxtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        campoTxtStock = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnAgregarIngrediente = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        comboBoxUnidad = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 253, 211));

        jPanel2.setBackground(new java.awt.Color(235, 230, 208));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 64)); // NOI18N
        jLabel1.setText("Ingredientes");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoPequenioStroke.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ingredientesIcon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(106, 106, 106)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        campoTxtNombre.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        jLabel4.setText("Nombre:");

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        jLabel5.setText("Unidad de medida:");

        campoTxtStock.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        jLabel6.setText("Stock Inicial:");

        btnAgregarIngrediente.setBackground(new java.awt.Color(85, 85, 85));
        btnAgregarIngrediente.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        btnAgregarIngrediente.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarIngrediente.setText("Agregar ingrediente");
        btnAgregarIngrediente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarIngredienteActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(85, 85, 85));
        btnCancelar.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        comboBoxUnidad.setModel(new javax.swing.DefaultComboBoxModel<>(new UnidadMedida[] { GRAMOS, PIEZAS, MILILITROS }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(btnAgregarIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboBoxUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(campoTxtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(campoTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboBoxUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(campoTxtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarIngrediente)
                    .addComponent(btnCancelar))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarIngredienteActionPerformed
        if (this.agregarIngrediente()) {
            this.dispose();
            Control.getInstancia().abrirMenuAdministrador();

        }
    }//GEN-LAST:event_btnAgregarIngredienteActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
        Control.getInstancia().abrirIngredientes();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * Agrega un nuevo ingrediente al sistema. Registra un ingrediente con los
     * datos proporcionados por el usuario.
     *
     * @return true si el ingrediente fue registrado exitosamente, false en caso
     * contrario.
     */
    private boolean agregarIngrediente() {
        try {
            String nombre = this.campoTxtNombre.getText();
            Integer stock = Integer.valueOf(this.campoTxtStock.getText());
            UnidadMedida unidad = (UnidadMedida) this.comboBoxUnidad.getSelectedItem();
            NuevoIngredienteDTO nuevoIngrediente = new NuevoIngredienteDTO(nombre, stock, unidad);
            this.ingredientesBO.registrar(nuevoIngrediente);
            JOptionPane.showMessageDialog(this, "Exito al registrar el ingrediente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (NegocioException e) {
            LOG.severe("No fue posible registrar el ingrediente " + e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage(), "Informacion", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            LOG.severe("No puedes ingresar letras en el stock");
            JOptionPane.showMessageDialog(this, "Asegurate que el stock sean solo números", "Informacion", JOptionPane.INFORMATION_MESSAGE);

        } catch (PersistenceException e) {
            LOG.severe("Ya existe un ingrediente con el mismo nombre y unidad de medida." + e.getMessage());
            JOptionPane.showMessageDialog(this, e.getMessage(), "Informacion", JOptionPane.INFORMATION_MESSAGE);

        }
        return false;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarIngrediente;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JTextField campoTxtNombre;
    private javax.swing.JTextField campoTxtStock;
    private javax.swing.JComboBox<UnidadMedida> comboBoxUnidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
