package org.gvredonditos.control;

import org.gvredonditos.interfaces.InterfazExcel;
import org.gvredonditos.interfaces.PantallaGenerarReporteDeRankingDeVinos;

import java.util.*;

public class GestorDeGeneracionDeReporte {

    public PantallaGenerarReporteDeRankingDeVinos pantalla;
    public InterfazExcel interfazExcel;
    private Date fechaDesde, fechaHasta;
    private String seleccionTipoReseñas, seleccionFormatoVisualizacion, formatoVisualizacion;

    public GestorDeGeneracionDeReporte(PantallaGenerarReporteDeRankingDeVinos pantalla){
        this.pantalla = pantalla;
        this.interfazExcel = new InterfazExcel();
    }

    // TODO Implementar
    public void generarRankingDeVinos(){
        // 1. Se generaran Datos aleatorios para el ranking de vinos
        System.out.println("Se generaran Datos aleatorios para el ranking de vinos: ");

        // Mensaje 4 del DS
        pantalla.solicitarFechaDesdeYFechaHasta();
    };

    // TODO Implementar
    public void tomarFechaDesdeYFechaHasta(Date fechaDesde, Date fechaHasta){
        // 2. Se tomaran las fechas desde y hasta
        System.out.println("Se tomaran las fechas desde y hasta: ");
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;

        System.out.println("Fecha desde: " + fechaDesde);
        System.out.println("Fecha hasta: " + fechaHasta);

        // Mensaje 5 del DS
        pantalla.solicitarTipoDeReseña();
    };

    // TODO Implementar
    public Boolean validarFechas(){
        return null;
    };

    // TODO Implementar
    public void tomarTipoDeReseñaSeleccionada(){

    };

    // TODO Implementar
    public void tomarFormatoVisualizacion(){

    };

    // TODO Implementar
    public void tomarConfirmacion(){

    }


    public void finCU(){
        pantalla.cerrar();
    }





}
