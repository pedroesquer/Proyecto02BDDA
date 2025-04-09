/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package itson.sistemarestaurantepresentacion;

import itson.sistemarestaurantedominio.dtos.NuevoClienteDTO;
import itson.sistemarestaurantenegocio.IClientesBO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantenegocio.utilidades.EncriptadorAES;
import itson.sistemarestaurantepresentacion.control.Control;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Logger;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

/**
 *
 * @author victoria
 */
public class AgregarCliente extends javax.swing.JFrame {
    
    private IClientesBO clientesBO;
    private static final Logger LOG = Logger.getLogger(AgregarCliente.class.getName());
    
    /**
     * pantalla para agregar nuevos clientes
     */
    
    public AgregarCliente(IClientesBO clientesBO) {
        initComponents();
        this.setTitle("Agregar cliente");
        this.setResizable(false);
        this.setSize(760,500);
        this.setLocationRelativeTo(null);
        this.clientesBO = clientesBO;
        this.TextFieldCorreo.setText("Opcional...");
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LblAgregarCliente = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        LblNombre = new javax.swing.JLabel();
        textFieldNombre = new javax.swing.JTextField();
        LblTelefono = new javax.swing.JLabel();
        textFieldTelefono = new javax.swing.JTextField();
        LblCorreo = new javax.swing.JLabel();
        TextFieldCorreo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 204));

        jPanel1.setBackground(new java.awt.Color(235, 230, 208));

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        LblAgregarCliente.setBackground(new java.awt.Color(235, 230, 208));
        LblAgregarCliente.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        LblAgregarCliente.setForeground(new java.awt.Color(0, 0, 0));
        LblAgregarCliente.setText("Agregar Cliente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                .addComponent(LblAgregarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LblAgregarCliente)
                .addGap(20, 20, 20))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 253, 211));

        LblNombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LblNombre.setForeground(new java.awt.Color(0, 0, 0));
        LblNombre.setText("Nombre:");

        textFieldNombre.setBackground(new java.awt.Color(255, 255, 255));
        textFieldNombre.setForeground(new java.awt.Color(0, 0, 0));
        textFieldNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        textFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNombreActionPerformed(evt);
            }
        });

        LblTelefono.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LblTelefono.setForeground(new java.awt.Color(0, 0, 0));
        LblTelefono.setText("Numero de Telefono:");

        textFieldTelefono.setBackground(new java.awt.Color(255, 255, 255));
        textFieldTelefono.setForeground(new java.awt.Color(0, 0, 0));
        textFieldTelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        textFieldTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldTelefonoActionPerformed(evt);
            }
        });

        LblCorreo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        LblCorreo.setForeground(new java.awt.Color(0, 0, 0));
        LblCorreo.setText("Correo electronico:");

        TextFieldCorreo.setBackground(new java.awt.Color(255, 255, 255));
        TextFieldCorreo.setForeground(new java.awt.Color(0, 0, 0));
        TextFieldCorreo.setText("Opcional...");
        TextFieldCorreo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TextFieldCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldCorreoActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(0, 0, 0));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(0, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldNombre)
                    .addComponent(LblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textFieldTelefono)
                    .addComponent(LblCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 231, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(101, 101, 101)
                .addComponent(btnCancelar)
                .addGap(237, 237, 237))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(LblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LblTelefono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LblCorreo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextFieldCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNombreActionPerformed

    private void TextFieldCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldCorreoActionPerformed

    private void textFieldTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldTelefonoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (this.agregarCliente()) {
            this.dispose();
            Control.getInstancia().abrirMenuAdministrador();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
        Control.getInstancia().abrirClientesFrecuentes();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * agrega un nuevo cliente al sistema, registra un cliente
     * con los datos que proporciona el usuario.
     */
   // private boolean agregarCliente(){
    //    try {
 //           String nombre = this.textFieldNombre.getText();
 //           String telefono = this.textFieldTelefono.getText();
  //          String correo = this.TextFieldCorreo.getText();

            // Si el correo es 'opcional' o esta vacio se deja como vacio
 //           if (correo.equalsIgnoreCase("Opcional...") || correo.isEmpty()) {
  //              correo = "";
  //          }

  //          NuevoClienteDTO nuevoCliente = new NuevoClienteDTO(nombre, correo, telefono, 0);
   //         this.clientesBO.registrar(nuevoCliente);
  //          JOptionPane.showMessageDialog(this, "Exito al registrar el cliente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
   //         return true;
   //     } catch (NegocioException e) {
   //         LOG.severe("No fue posible registrar el cliente: " + e.getMessage());
    //        JOptionPane.showMessageDialog(this, e.getMessage(), "Informacion", JOptionPane.INFORMATION_MESSAGE);
    //    } catch (PersistenceException e) {
     //       LOG.severe("Ya existe un cliente con el mismo numero de telefono: " + e.getMessage());
     //       JOptionPane.showMessageDialog(this, e.getMessage(), "Informacion", JOptionPane.INFORMATION_MESSAGE);
     //   }
     //  return false;
   // }
    
    private boolean agregarCliente() {
    try {
        // Obtener los datos de los campos
        String nombreCompleto = this.textFieldNombre.getText();
        String telefono = this.textFieldTelefono.getText();
        String correo = this.TextFieldCorreo.getText();

        // Si el correo es "Opcional..." o está vacío, lo dejamos como vacío
        if (correo.equalsIgnoreCase("Opcional...") || correo.isEmpty() || correo.trim().isEmpty() ) {
            correo = "";
        }

        // Dividir el nombre completo en nombre, apellido paterno y apellido materno
        String[] partesNombre = nombreCompleto.trim().split("\\s+");
        String nombre;
        String apellidoPaterno;
        String apellidoMaterno = null;

        System.out.println("Nombre completo: " + nombreCompleto);
        System.out.println("Partes del nombre: " + Arrays.toString(partesNombre));

        if (partesNombre.length < 2) {
            throw new NegocioException("Debe proporcionar al menos el nombre y el apellido paterno.");
        } else if (partesNombre.length == 2) {
            nombre = partesNombre[0];
            apellidoPaterno = partesNombre[1];
        } else {
            nombre = partesNombre[0];
            apellidoPaterno = partesNombre[1];
            apellidoMaterno = partesNombre[2];
        }

        System.out.println("Nombre completo: " + nombreCompleto);
        System.out.println("Partes del nombre: " + java.util.Arrays.toString(partesNombre));
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido Paterno: " + apellidoPaterno);
        System.out.println("Apellido Materno: " + apellidoMaterno);
        
        LocalDate localDate = LocalDate.now();
        Date fecha = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        
        // Crear el DTO con el constructor que incluye nombre, apellidos, correo, telefono y fecha
        NuevoClienteDTO nuevoCliente = new NuevoClienteDTO(
            nombre,
            apellidoPaterno,
            apellidoMaterno,
            correo,
            telefono,
            fecha
        );

        // Registrar el cliente
        this.clientesBO.registrar(nuevoCliente);
        JOptionPane.showMessageDialog(this, "Exito al registrar el cliente", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        return true;
    } catch (NegocioException e) {
        LOG.severe("No fue posible registrar el cliente: " + e.getMessage());
        JOptionPane.showMessageDialog(this, e.getMessage(), "Informacion", JOptionPane.INFORMATION_MESSAGE);
    } catch (PersistenceException e) {
        LOG.severe("Ya existe un cliente con el mismo número de telefono: " + e.getMessage());
        JOptionPane.showMessageDialog(this, e.getMessage(), "Informacion", JOptionPane.INFORMATION_MESSAGE);
    }
    return false;
}

    
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ListaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ListaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ListaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ListaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
////                IClientesBO clientesBO = FabricaObjetosNegocio.crearClientesBO();
////                new AgregarCliente(clientesBO).setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblAgregarCliente;
    private javax.swing.JLabel LblCorreo;
    private javax.swing.JLabel LblNombre;
    private javax.swing.JLabel LblTelefono;
    private javax.swing.JTextField TextFieldCorreo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField textFieldNombre;
    private javax.swing.JTextField textFieldTelefono;
    // End of variables declaration//GEN-END:variables
}
