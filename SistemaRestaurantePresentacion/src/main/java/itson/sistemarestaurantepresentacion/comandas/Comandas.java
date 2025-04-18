package itson.sistemarestaurantepresentacion.comandas;

import itson.sistemarestaurantenegocio.IComandasBO;
import itson.sistemarestaurantenegocio.IIngredientesBO;
import itson.sistemarestaurantepresentacion.control.Control;

/**
 *
 * @author Pedro Morales Esquer, Juan Pablo Heras Carrazco, Victoria Valenzuela
 * Soto
 */
public class Comandas extends javax.swing.JFrame {

    private IComandasBO comandasBO;

    /**
     * Creates new form Productos
     */
    public Comandas(IComandasBO comandasBO) {
        initComponents();
        this.setTitle("Ingredientes");
        this.setResizable(false);
        this.setSize(760, 500);
        this.setLocationRelativeTo(null);
        this.comandasBO = comandasBO;
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
        lblTituloComandas = new javax.swing.JLabel();
        iconChefSoft = new javax.swing.JLabel();
        iconComanda = new javax.swing.JLabel();
        iconAgregarComanda = new javax.swing.JLabel();
        lblNuevoComanda = new javax.swing.JLabel();
        iconBuscar = new javax.swing.JLabel();
        lblVerComandas = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelGeneral.setBackground(new java.awt.Color(255, 253, 211));

        panelSuperior.setBackground(new java.awt.Color(235, 230, 208));

        lblTituloComandas.setFont(new java.awt.Font("Helvetica Neue", 0, 64)); // NOI18N
        lblTituloComandas.setText("Comandas");

        iconChefSoft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoPequenioStroke.png"))); // NOI18N

        iconComanda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/comandasIcon.png"))); // NOI18N

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconChefSoft)
                .addGap(117, 117, 117)
                .addComponent(lblTituloComandas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(iconComanda)
                .addGap(52, 52, 52))
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSuperiorLayout.createSequentialGroup()
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelSuperiorLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTituloComandas))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSuperiorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(iconChefSoft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSuperiorLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(iconComanda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        iconAgregarComanda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/aniadir.png"))); // NOI18N
        iconAgregarComanda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconAgregarComandaMouseClicked(evt);
            }
        });

        lblNuevoComanda.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        lblNuevoComanda.setText("Nueva Comanda");

        iconBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/comandasIcon.png"))); // NOI18N
        iconBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconBuscarMouseClicked(evt);
            }
        });

        lblVerComandas.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        lblVerComandas.setText("Ver comandas");

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
                .addGap(334, 334, 334)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGeneralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addComponent(iconAgregarComanda)
                        .addGap(127, 127, 127)
                        .addComponent(iconBuscar)
                        .addGap(231, 231, 231))
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addComponent(lblNuevoComanda)
                        .addGap(72, 72, 72)
                        .addComponent(lblVerComandas)
                        .addGap(191, 191, 191))))
        );
        panelGeneralLayout.setVerticalGroup(
            panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGeneralLayout.createSequentialGroup()
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelGeneralLayout.createSequentialGroup()
                        .addComponent(panelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                        .addComponent(iconAgregarComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(iconBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(panelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVerComandas)
                    .addComponent(lblNuevoComanda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
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
        Control.getInstancia().abrirListaComandas();
    }//GEN-LAST:event_iconBuscarMouseClicked

    private void iconAgregarComandaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconAgregarComandaMouseClicked
        this.dispose();
        Control.getInstancia().abrirAgregarComandas();
    }//GEN-LAST:event_iconAgregarComandaMouseClicked

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
        Control.getInstancia().abrirPantallaInicio();
    }//GEN-LAST:event_btnVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel iconAgregarComanda;
    private javax.swing.JLabel iconBuscar;
    private javax.swing.JLabel iconChefSoft;
    private javax.swing.JLabel iconComanda;
    private javax.swing.JLabel lblNuevoComanda;
    private javax.swing.JLabel lblTituloComandas;
    private javax.swing.JLabel lblVerComandas;
    private javax.swing.JPanel panelGeneral;
    private javax.swing.JPanel panelSuperior;
    // End of variables declaration//GEN-END:variables
}
