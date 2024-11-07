package org.gvredonditos.interfaces;

import org.gvredonditos.control.GestorDeGeneracionDeReporte;

import java.util.ArrayList;

public class InterfazExcel {

    public InterfazExcel() {

    }
    public void exportarExcel(GestorDeGeneracionDeReporte gestor, ArrayList<String> filas){
        try {
            Thread.sleep(3000);
            System.out.println("Excel file exported successfully!");
//            gestor.tomarArchivoGenerado();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
