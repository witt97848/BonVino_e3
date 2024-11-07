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




}
