package org.gvredonditos.interfaces;

import org.gvredonditos.control.GestorDeGeneracionDeReporte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterfazExcel {

    public InterfazExcel() {

    }
    public void exportarExcel(List<String> vinosCSV){
        List<String> fila;

        // 0-Promedio Sommelier 1-ID 2-Nombre 3-Promedio Calificacion General 4-Bodega 5-Region 6-Pais 7-Precio 8-Varietales
        if (vinosCSV.size() == 0) {
            System.out.println("No hay vinos para exportar");
            return;
        }
        for (String vino : vinosCSV) {
            fila = List.of(vino.split(","));
            System.out.println(fila);
//            System.out.println(
//                    "\nVino: (" + fila.get(1) + ") " + fila.get(2)  +
//                            "\n   Promedio Sommelier: " + fila.get(0) +
//                            "\n   Promedio general: " + fila.get(3) +
//                            "\n   Bodega: " + fila.get(4) +
//                            "\n   Region: " + fila.get(5) +
//                            "\n   Pais: " + fila.get(6) +
//                            "\n   Precio: " + fila.get(7) +
//                            "\n   Varietales: " + fila.get(8)
//            );
        }
        System.out.println("Excel file exported successfully!");
    }
}
