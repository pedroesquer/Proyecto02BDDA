package itson.sistemarestaurantepresentacion;

import itson.sistemarestaurantedominio.Producto;
import itson.sistemarestaurantenegocio.IProductosBO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juanpheras
 */
public class ListaProductos extends javax.swing.JFrame {

    
    private IProductosBO productosBO;
    /**
     * Creates new form ListaProductos
     * @param productosBO
     */
    public ListaProductos(IProductosBO productosBO) {
        initComponents();
        this.setTitle("ListaProductos");
        this.setResizable(false);
        this.setSize(760,500);
        this.setLocationRelativeTo(null);
        this.productosBO = productosBO;
        this.cargarTabla("");
    }
    
    private void cargarTabla(String filtroBusqueda) {
        tablaProductos.setDefaultRenderer(Object.class, new Render());

        String[] columnas = new String[]{"ID", "Nombre", "Precio", "Tipo", "Seleccion"};
        boolean[] editable = {false, false, false, false, true};
        Class[] types = new Class[]{java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class};

        DefaultTableModel mModel = new DefaultTableModel(columnas, 0) {
            public Class getColumnClass(int i) {
                return types[i];
            }

            public boolean isCellEditable(int row, int column) {
                return editable[column];
            }
        };

        LimpiarTabla(tablaProductos, mModel);

        Object[] datos = new Object[columnas.length];
        try {
            
            List<Producto> productos = this.productosBO.consultar(filtroBusqueda);
            for (Producto producto : productos) {
                
                datos[0] = String.valueOf(producto.getId());
                datos[1] = producto.getNombre();
                datos[2] = String.valueOf(producto.getPrecio());
                datos[3] = String.valueOf(producto.getTipo());
                datos[4] = false;
                
                mModel.addRow(datos);
            }
            
            tablaProductos.setModel(mModel);
            
            // Implementar un listener para cambiar el estado del checkbox
        tablaProductos.getModel().addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                if (column == 4) {  // Si la columna seleccionada es la de los checkboxes (índice 4)
                    boolean selected = (boolean) mModel.getValueAt(row, column);
                    // Si el checkbox de esa fila se seleccionó, desmarcar los demás
                    if (selected) {
                        for (int i = 0; i < mModel.getRowCount(); i++) {
                            if (i != row) {
                                mModel.setValueAt(false, i, 4);  // Desmarcar las otras filas
                            }
                        }
                    }
                }
            }
        });
        } catch (NegocioException ex) {
            JOptionPane.showInputDialog(this, ex.getMessage());            
        }
    }
    
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
        botonActualizarProducto1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 253, 211));

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
                .addContainerGap(215, Short.MAX_VALUE))
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

        botonActualizarProducto.setBackground(new java.awt.Color(51, 102, 255));
        botonActualizarProducto.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        botonActualizarProducto.setText("Actualizar producto");
        botonActualizarProducto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        botonActualizarProducto1.setBackground(new java.awt.Color(204, 255, 255));
        botonActualizarProducto1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        botonActualizarProducto1.setText("Detalles producto");
        botonActualizarProducto1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botonActualizarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(botonActualizarProducto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnlTablaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(117, 117, 117))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(pnlTablaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonActualizarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonActualizarProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
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

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizarProducto;
    private javax.swing.JButton botonActualizarProducto1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane pnlTablaProductos;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
}
