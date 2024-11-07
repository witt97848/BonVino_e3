package org.gvredonditos.interfaces;

import org.gvredonditos.control.GestorDeGeneracionDeReporte;
import javax.swing.*;

public class PantallaGenerarReporteDeRankingDeVinos {
    private GestorDeGeneracionDeReporte gestor;
    private InterfazExcel interfazExcel;
    private JFrame frame;
    private JLabel labelImagenLogo, labelFechaDesde, labelFechaHasta, labelImagenTitulo;
    private JLabel labelTipoDeReseña;
    private JLabel labelFormatoVisualizacion;
    private JTextField inputDiaFechaDesde, inputMesFechaDesde, inputAñoFechaDesde;
    private JTextField inputDiaFechaHasta, inputMesFechaHasta, inputAñoFechaHasta;
    private JComboBox comboBoxTipoDeReseña;
    private JComboBox comboBoxFormatoVisualizacion;
    private JButton btnTomarFechaDesdeFechaHasta, btnCancelarCU, btnTomarTipoDeReseña, btnTomarFormatoVisualizacion;
    private ImageIcon imagenLogo;

    public PantallaGenerarReporteDeRankingDeVinos(){
        this.gestor = new GestorDeGeneracionDeReporte(this);
    }

    public void opcionGenerarRankingDeVino() {
        System.out.println("Se selecciono Generar ranking de vinos");



    }

    public void habilitarPantalla(){
        // habilitar pantalla
    }

    public void tomarFechaDesdeFechaHasta(){
        // tomar fecha desde y fecha hasta
    }

    public void solicitarTipoDeReseña(){
        // solicitar tipo de reseña
    }

    public void tomarSeleccionSommelier(){
        // tomar seleccion sommelier
    }


    public void solicitarFormatoVisualizacion(){
        // solicitar formato de visualizacion
    }

    public void tomarSeleccionFormato(){
        // tomar seleccion formato de visualizacion
    }

    public void solicitarConfirmacion(){
        // solicitar confirmacion
    }

    public void tomarConfirmacion(){
        // tomar confirmacion
    }






}
