/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.sistemarestaurantepresentacion.beans;

import itson.sistemarestaurantedominio.Comanda;
import itson.sistemarestaurantenegocio.IComandasBO;
import itson.sistemarestaurantenegocio.excepciones.NegocioException;
import itson.sistemarestaurantenegocio.fabrica.FabricaObjetosNegocio;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRImage;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRImageLoader;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author juanpheras
 */
public class PruebaComanda {

    public static void main(String[] args) throws NegocioException, ParseException {

        String jasperFilePath = "src/main/resources/reporteComandas/reporteComandas.jasper";
        try {
            //Step 1 obtain JasperReport Class Object
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(jasperFilePath);

            IComandasBO comandasBO = FabricaObjetosNegocio.crearComandasBO();
            List<Comanda> comandasList = comandasBO.consultar();
            //Create datasource object
            JRBeanCollectionDataSource tableDatasource = new JRBeanCollectionDataSource(comandasList);

            // ← Aquí defines las fechas (puedes cambiarlas por lo que necesites)
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaInicio = sdf.parse("2024-04-01");
            Date fechaFin = sdf.parse("2024-04-10");
            //Create a hashmap to store parameters
            Map<String, Object> parameters = new HashMap<String, Object>();

            parameters.put("TABLE_DATA_SOURCE", tableDatasource);
            parameters.put("fechaInicio", fechaInicio);
            parameters.put("fechaFin", fechaFin);

            //Step 4 Create JasperPrint Object
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, tableDatasource);

            // Mostrar vista previa
            JasperViewer.viewReport(jasperPrint, false);
            //Step 5 export our jasper print object to desired report format.
            // FileChooser para que el usuario elija dónde guardar el PDF
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar reporte como PDF");

            // Mostrar el diálogo
            int seleccion = fileChooser.showSaveDialog(null);

            // Si el usuario eligió guardar
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File archivo = fileChooser.getSelectedFile();
                String ruta = archivo.getAbsolutePath();

                // Asegurarse que tenga la extensión .pdf
                if (!ruta.toLowerCase().endsWith(".pdf")) {
                    ruta += ".pdf";
                }

                // Exportar el reporte como PDF a la ruta elegida
                JasperExportManager.exportReportToPdfFile(jasperPrint, ruta);

                JOptionPane.showMessageDialog(null, "¡Reporte guardado con éxito en:\n" + ruta);
            } else {
                JOptionPane.showMessageDialog(null, "Exportación cancelada por el usuario.");
            }
        } catch (JRException ex) {
            Logger.getLogger(PruebaComanda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
