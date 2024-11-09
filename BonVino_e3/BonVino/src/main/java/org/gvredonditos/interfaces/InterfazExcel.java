package org.gvredonditos.interfaces;

import org.gvredonditos.control.GestorDeGeneracionDeReporte;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InterfazExcel {

    public InterfazExcel() {

    }

    public void exportarExcel(String textCSV){

        String archivoCSV = "src/main/resources/META-INF/ranking_vinos.csv";

        File file = new File(archivoCSV);

        // Crear el archivo CSV en la ubicación especificada
        try (FileWriter writer = new FileWriter(archivoCSV)) {
            // Escribir el texto completo en el archivo
            writer.write(textCSV);
            System.out.println("Archivo CSV exportado exitosamente en: " + archivoCSV);

            // Intentar abrir el archivo automáticamente
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
                System.out.println("Archivo CSV abierto automáticamente.");
            } else {
                System.out.println("Abrir automáticamente no es compatible en este sistema.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Excel file exported successfully!");
    }
    // VISUALIZACION MAS CLARA EN HTML
//    public void exportarExcel(String textCSV) {
//        String archivoHTML = "src/main/resources/META-INF/ranking_vinos.html";
//        File file = new File(archivoHTML);
//
//        // Convertir CSV a HTML
//        StringBuilder htmlContent = new StringBuilder();
//        htmlContent.append("<html><head><title>Ranking de Vinos</title></head><body><table border='1'>");
//
//        // Separar las líneas del CSV
//        String[] lines = textCSV.split("\n");
//        for (String line : lines) {
//            htmlContent.append("<tr>");
//            String[] cells = line.split(",");
//            for (String cell : cells) {
//                htmlContent.append("<td>").append(cell.trim()).append("</td>");
//            }
//            htmlContent.append("</tr>");
//        }
//
//        htmlContent.append("</table></body></html>");
//
//        // Guardar el archivo HTML
//        try (FileWriter writer = new FileWriter(file)) {
//            writer.write(htmlContent.toString());
//            System.out.println("Archivo HTML exportado exitosamente en: " + archivoHTML);
//
//            // Abrir el archivo HTML en el navegador
//            if (Desktop.isDesktopSupported()) {
//                Desktop.getDesktop().browse(file.toURI());
//                System.out.println("Archivo HTML abierto en el navegador.");
//            } else {
//                System.out.println("Abrir en el navegador no es compatible en este sistema.");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
