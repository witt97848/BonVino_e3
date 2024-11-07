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

    // HECHO
    public void generarRankingDeVinos(){
        // 1. Se generaran Datos aleatorios para el ranking de vinos
        System.out.println("Se generaran Datos aleatorios para el ranking de vinos: ");

        // Mensaje 4 del DS
        pantalla.solicitarFechaDesdeYFechaHasta();
    };

    // HECHO
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

    // HECHO
    public void tomarTipoReseñaSeleccionada(String seleccionTipoReseñas){
        this.seleccionTipoReseñas = seleccionTipoReseñas;

        System.out.println("Tipo de reseña seleccionada: " + seleccionTipoReseñas);
        pantalla.solicitarFormatoVisualizacion();

    };

    // HECHO
    public void tomarSeleccionFormato(String seleccionFormatoVisualizacion){
        this.seleccionFormatoVisualizacion = seleccionFormatoVisualizacion;
        System.out.println("Formato de visualizacion seleccionado: " + seleccionFormatoVisualizacion);

        pantalla.solicitarConfirmacion();
    };

    // HECHO
    public void tomarConfirmacion(String confirmacion){
        if(confirmacion.equals("SI")){
            buscarVinosConReseñaSolicitada();
        }else{
            finCU();
        }
    }

    public void buscarVinosConReseñaSolicitada(){
        System.out.println("Buscando vinos con reseña solicitada...");
    }


    public void finCU(){
        pantalla.cerrar();
    }





}
