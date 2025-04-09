package itson.sistemarestaurantepresentacion;

import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantedominio.TipoProducto;
import itson.sistemarestaurantedominio.dtos.NuevoProductoDTO;
import itson.sistemarestaurantenegocio.IProductosBO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantepresentacion.control.Control;
import itson.sistemarestaurantepresentacion.observers.ProductoSeleccionadoObserver;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juanpheras
 */
public class ListaProductos extends javax.swing.JFrame implements ProductoSeleccionadoObserver {

    private IProductosBO productosBO;

    /**
     * Creates new form ListaProductos
     *
     * @param productosBO
     */
    public ListaProductos(IProductosBO productosBO) {
        initComponents();
        this.setTitle("ListaProductos");
        this.setResizable(false);
        this.setSize(770, 510);
        this.setLocationRelativeTo(null);
        this.productosBO = productosBO;
        tablaProductos.removeColumn(tablaProductos.getColumnModel().getColumn(0));
        this.cargarTabla("");
    }

    /**
     * Método que llena la tabla según el fultro de busqueda que se haya
     * mandado.
     *
     * @param filtroBusqueda Las palabaras las cuales buscara en base de datos
     * coincidencias que contengan el filtro de busqueda entregado.
     *
     */
    private void cargarTabla(String filtroBusqueda) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaProductos.getModel();
        modeloTabla.setRowCount(0);

        try {
            List<Producto> productos = this.productosBO.consultar("");

            for (Producto producto : productos) {
                modeloTabla.addRow(new Object[]{
                    producto.getId(),
                    producto.getNombre(),
                    producto.getPrecio(),
                    producto.getTipo()
                });
            }
        } catch (NegocioException ex) {
            JOptionPane.showInputDialog(this, ex.getMessage());
        }

//        tablaProductos.setDefaultRenderer(Object.class, new Render());
//
//        String[] columnas = new String[]{"ID", "Nombre", "Precio", "Tipo", "Seleccion"};
//        boolean[] editable = {false, false, false, false, true};
//        Class[] types = new Class[]{java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class};
//
//        DefaultTableModel mModel = new DefaultTableModel(columnas, 0) {
//            public Class getColumnClass(int i) {
//                return types[i];
//            }
//
//            public boolean isCellEditable(int row, int column) {
//                return editable[column];
//            }
//        };
//
//        LimpiarTabla(tablaProductos, mModel);
//
//        Object[] datos = new Object[columnas.length];
//        try {
//
//            List<Producto> productos = this.productosBO.consultar(filtroBusqueda);
//            for (Producto producto : productos) {
//
//                datos[0] = String.valueOf(producto.getId());
//                datos[1] = producto.getNombre();
//                datos[2] = String.valueOf(producto.getPrecio());
//                datos[3] = String.valueOf(producto.getTipo());
//                datos[4] = false;
//
//                mModel.addRow(datos);
//            }
//
//            tablaProductos.setModel(mModel);
//
//            // Implementar un listener para cambiar el estado del checkbox
//            tablaProductos.getModel().addTableModelListener(e -> {
//                if (e.getType() == TableModelEvent.UPDATE) {
//                    int row = e.getFirstRow();
//                    int column = e.getColumn();
//                    if (column == 4) {  // Si la columna seleccionada es la de los checkboxes (índice 4)
//                        boolean selected = (boolean) mModel.getValueAt(row, column);
//                        // Si el checkbox de esa fila se seleccionó, desmarcar los demás
//                        if (selected) {
//                            for (int i = 0; i < mModel.getRowCount(); i++) {
//                                if (i != row) {
//                                    mModel.setValueAt(false, i, 4);  // Desmarcar las otras filas
//                                }
//                            }
//                        }
//                    }
//                }
//            });
//        } catch (NegocioException ex) {
//            JOptionPane.showInputDialog(this, ex.getMessage());
//        }
    }

    /**
     * Método que resetea la tabla a su estado original mostrando los productos
     * como estan registrados.
     *
     * @param tabla
     * @param modeloTabla
     */
    public void LimpiarTabla(JTable tabla, DefaultTableModel modeloTabla) {
        if (modeloTabla.getRowCount() > 0) {
            for (int i = 0; i < tabla.getRowCount(); i++) {
                modeloTabla.removeRow(i);
                i -= 1;
            }
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnlTablaProductos = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        botonActualizarProducto = new javax.swing.JButton();
        botonDetallesProducto = new javax.swing.JButton();
        botonBuscarProductos = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 253, 211));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(235, 230, 208));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 64)); // NOI18N
        jLabel1.setText("Productos");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoPequenioStroke.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/platilloIcon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(149, 149, 149)
                .addComponent(jLabel1)
                .addContainerGap(225, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(672, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGap(16, 16, 16)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Producto", "Precio", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProductos.setColumnSelectionAllowed(true);
        pnlTablaProductos.setViewportView(tablaProductos);

        jPanel1.add(pnlTablaProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 162, 508, 244));

        botonActualizarProducto.setBackground(new java.awt.Color(51, 102, 255));
        botonActualizarProducto.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        botonActualizarProducto.setText("Actualizar producto");
        botonActualizarProducto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonActualizarProducto.setOpaque(true);
        botonActualizarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarProductoActionPerformed(evt);
            }
        });
        jPanel1.add(botonActualizarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 424, 188, 51));

        botonDetallesProducto.setBackground(new java.awt.Color(204, 255, 255));
        botonDetallesProducto.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        botonDetallesProducto.setText("Detalles producto");
        botonDetallesProducto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonDetallesProducto.setOpaque(true);
        botonDetallesProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDetallesProductoActionPerformed(evt);
            }
        });
        jPanel1.add(botonDetallesProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 424, 238, 51));

        botonBuscarProductos.setBackground(new java.awt.Color(255, 255, 255));
        botonBuscarProductos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        botonBuscarProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonBuscarProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonBuscarProductosMouseClicked(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Buscar Productos");

        javax.swing.GroupLayout botonBuscarProductosLayout = new javax.swing.GroupLayout(botonBuscarProductos);
        botonBuscarProductos.setLayout(botonBuscarProductosLayout);
        botonBuscarProductosLayout.setHorizontalGroup(
            botonBuscarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonBuscarProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addContainerGap())
        );
        botonBuscarProductosLayout.setVerticalGroup(
            botonBuscarProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botonBuscarProductosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        jPanel1.add(botonBuscarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 150, 30));

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

    private Long seleccionarIdProducto() {
        int filaSeleccionada = tablaProductos.getSelectedRow();
        if (filaSeleccionada != -1) {
            Long id = Long.parseLong(tablaProductos.getModel().getValueAt(filaSeleccionada, 0).toString());
            return id;
        }
        JOptionPane.showMessageDialog(this, "No seleccionaste nada");
        return null;
    }

    private void botonActualizarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarProductoActionPerformed
        Producto producto = this.productosBO.consultarProductoIndividual(this.seleccionarIdProducto());

        if (!(producto == null)) {
            Control.getInstancia().abrirActualizarProducto(producto);
            this.dispose();
        }
    }//GEN-LAST:event_botonActualizarProductoActionPerformed

    private void botonDetallesProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDetallesProductoActionPerformed
        Producto producto = this.productosBO.consultarProductoIndividual(this.seleccionarIdProducto());
        Control.getInstancia().abrirDetallesProducto(producto);
        this.dispose();
    }//GEN-LAST:event_botonDetallesProductoActionPerformed

    private void botonBuscarProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonBuscarProductosMouseClicked
        Control.getInstancia().abrirBuscadorProductos(this);
    }//GEN-LAST:event_botonBuscarProductosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizarProducto;
    private javax.swing.JPanel botonBuscarProductos;
    private javax.swing.JButton botonDetallesProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane pnlTablaProductos;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables

    @Override
    public void productoSeleccionado(NuevoProductoDTO producto) {
        actualizarProductoTabla(producto);

    }

    private void actualizarProductoTabla(NuevoProductoDTO producto) {
        // Este objeto permite interactuar con los elementos de la tabla
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaProductos.getModel();
        modeloTabla.setRowCount(0); // Limpiamos la tabla antes de llenarla nuevamente

        modeloTabla.addRow(new Object[]{
            producto.getId(),
            producto.getNombre(),
            producto.getPrecio(),
            producto.getTipo()
        }
        );
    }
}
