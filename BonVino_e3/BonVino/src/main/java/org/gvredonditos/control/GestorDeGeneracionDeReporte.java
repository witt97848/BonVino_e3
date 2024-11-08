package org.gvredonditos.control;

import org.gvredonditos.interfaces.InterfazExcel;
import org.gvredonditos.interfaces.PantallaGenerarReporteDeRankingDeVinos;
import org.gvredonditos.iterators.IAgregado;
import org.gvredonditos.iterators.IIterador;
import org.gvredonditos.iterators.IteradorVinos;
import org.gvredonditos.modelo.Vino;
import org.gvredonditos.repositories.VinoRepository;
import java.time.LocalDate;

import java.util.*;

//public class GestorDeGeneracionDeReporte implements IAgregado<Vino> {
public class GestorDeGeneracionDeReporte {

    public PantallaGenerarReporteDeRankingDeVinos pantalla;
    public InterfazExcel interfazExcel;
    private LocalDate fechaDesde, fechaHasta;
    private List<LocalDate> periodo;
    private String seleccionTipoReseñas, seleccionFormatoVisualizacion, formatoVisualizacion;
    private VinoRepository vinoRepository;

    private List<Vino> vinos;

    public GestorDeGeneracionDeReporte(PantallaGenerarReporteDeRankingDeVinos pantalla){
        this.pantalla = pantalla;
        this.interfazExcel = new InterfazExcel();
        this.vinoRepository = new VinoRepository();
        this.vinos = vinoRepository.findAll();
        this.periodo = new ArrayList<>();
    }

    // HECHO
    public void generarRankingDeVinos(){
        // Mensaje 4 del DS
        pantalla.solicitarFechaDesdeYFechaHasta();
    };

    // HECHO
    public void tomarFechaDesdeYFechaHasta(LocalDate fechaDesde, LocalDate fechaHasta){
        // 2. Se tomaran las fechas desde y hasta
        System.out.println("Se tomaran las fechas desde y hasta: ");

        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;

        periodo.add(fechaDesde);
        periodo.add(fechaHasta);

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
            // Paso numero 17 del DSecuecnia
            buscarVinosConReseñaSolicitada();
        }else{
            finCU();
        }
    }


    // TODO TESTIINNGGG
    public void buscarVinosConReseñaSolicitada(){
        System.out.println("Buscando vinos con reseña solicitada...");
        vinos.forEach(System.out::println);
        for (Vino vino : vinos) {
            vino.calcularPromedioReseñasSommelierPeriodo(periodo);
        }
    }




    public void finCU(){
        pantalla.cerrar();
    }

    // Implementacion de los metodos de la interfaz IAgregado

    // TODO Implementar el metodo crearIterador
    public IIterador crearIterador(List<Vino> elementos) {
        return new IteradorVinos(vinos, periodo);
    }
}
