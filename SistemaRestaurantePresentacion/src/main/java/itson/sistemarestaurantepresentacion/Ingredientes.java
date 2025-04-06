package itson.sistemarestaurantepresentacion;

import itson.sistemarestaurantenegocio.IIngredientesBO;
import itson.sistemarestaurantepresentacion.control.Control;

/**
 *
 * @author Pedro Morales Esquer, Juan Pablo Heras Carrazco, Victoria Valenzuela Soto
 */
public class Ingredientes extends javax.swing.JFrame {

    private IIngredientesBO ingredientesBO;
    /**
     * Creates new form Productos
     */
    public Ingredientes(IIngredientesBO ingredientesBO) {
        initComponents();
        this.setTitle("Ingredientes");
        this.setResizable(false);
        this.setSize(760,500);
        this.setLocationRelativeTo(null);
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

        panelGeneral = new javax.swing.JPanel();
        panelSuperior = new javax.swing.JPanel();
        lblTituloIngrediente = new javax.swing.JLabel();
        iconChefSoft = new javax.swing.JLabel();
        iconIngrediente = new javax.swing.JLabel();
        iconActualizarStock = new javax.swing.JLabel();
        lblActualizarStock = new javax.swing.JLabel();
        iconAgregarIngrediente = new javax.swing.JLabel();
        lblNuevoIngrediente = new javax.swing.JLabel();
        iconBuscar = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
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

        iconActualizarStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/updateIcon.png"))); // NOI18N
        iconActualizarStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconActualizarStockMouseClicked(evt);
            }
        });

        lblActualizarStock.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        lblActualizarStock.setText("Actualizar stock");

        iconAgregarIngrediente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/aniadir.png"))); // NOI18N
        iconAgregarIngrediente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconAgregarIngredienteMouseClicked(evt);
            }
        });

        lblNuevoIngrediente.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        lblNuevoIngrediente.setText("Nuevo Ingrediente");

        iconBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/buscarIcon.png"))); // NOI18N
        iconBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconBuscarMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel9.setText("Ver ingredientes");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeneralLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(iconAgregarIngrediente)
                .addGap(133, 133, 133)
                .addComponent(iconBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iconActualizarStock)
                .addGap(74, 74, 74))
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lblNuevoIngrediente)
                .addGap(66, 66, 66)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblActualizarStock)
                .addGap(43, 43, 43))
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addGap(334, 334, 334)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelGeneralLayout.setVerticalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addComponent(panelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(iconActualizarStock, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeneralLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(iconAgregarIngrediente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(iconBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(lblNuevoIngrediente))
                    .addComponent(lblActualizarStock))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addGap(23, 23, 23))
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

    private void iconBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconBuscarMouseClicked
        this.dispose();
        Control.getInstancia().abrirListaIngredientes();
    }//GEN-LAST:event_iconBuscarMouseClicked

    private void iconActualizarStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconActualizarStockMouseClicked
        this.dispose();
        Control.getInstancia().abrirActualizarStockIngredientes();
    }//GEN-LAST:event_iconActualizarStockMouseClicked

    private void iconAgregarIngredienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconAgregarIngredienteMouseClicked
        this.dispose();
        Control.getInstancia().abrirAgregarIngredientes();
    }//GEN-LAST:event_iconAgregarIngredienteMouseClicked

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
        Control.getInstancia().abrirMenuAdministrador();
    }//GEN-LAST:event_btnVolverActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel iconActualizarStock;
    private javax.swing.JLabel iconAgregarIngrediente;
    private javax.swing.JLabel iconBuscar;
    private javax.swing.JLabel iconChefSoft;
    private javax.swing.JLabel iconIngrediente;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblActualizarStock;
    private javax.swing.JLabel lblNuevoIngrediente;
    private javax.swing.JLabel lblTituloIngrediente;
    private javax.swing.JPanel panelGeneral;
    private javax.swing.JPanel panelSuperior;
    // End of variables declaration//GEN-END:variables
}
