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
import java.util.stream.Collectors;


public class GestorDeGeneracionDeReporte implements IAgregado<Vino, LocalDate> {

    private PantallaGenerarReporteDeRankingDeVinos pantalla;
    private InterfazExcel interfazExcel;
    private LocalDate fechaDesde, fechaHasta;
    private List<LocalDate> periodo;
    private String seleccionTipoReseñas, seleccionFormatoVisualizacion, formatoVisualizacion;
    private VinoRepository vinoRepository;
    private List<String> top10RankingVinos;
    private List<Vino> vinos;



    public GestorDeGeneracionDeReporte(PantallaGenerarReporteDeRankingDeVinos pantalla){
        this.pantalla = pantalla;
        this.interfazExcel = new InterfazExcel();
        this.vinoRepository = new VinoRepository();
        this.vinos = vinoRepository.findAll();
        this.periodo = new ArrayList<>();
        this.top10RankingVinos = new ArrayList<>();
    }

    public void generarRankingDeVinos(){
        // Mensaje 4 del DS
        pantalla.solicitarFechaDesdeYFechaHasta();
    };

    public void tomarFechaDesdeYFechaHasta(LocalDate fechaDesde, LocalDate fechaHasta){
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;

        periodo.add(fechaDesde);
        periodo.add(fechaHasta);

        // Mensaje 5 del DS
        pantalla.solicitarTipoDeReseña();
    };

    public void tomarTipoReseñaSeleccionada(String seleccionTipoReseñas){
        this.seleccionTipoReseñas = seleccionTipoReseñas;

        System.out.println("Tipo de reseña seleccionada: " + seleccionTipoReseñas);
        pantalla.solicitarFormatoVisualizacion();

    };

    public void tomarSeleccionFormato(String seleccionFormatoVisualizacion){
        this.seleccionFormatoVisualizacion = seleccionFormatoVisualizacion;
        System.out.println("Formato de visualizacion seleccionado: " + seleccionFormatoVisualizacion);

        pantalla.solicitarConfirmacion();
    };

    public void tomarConfirmacion(String confirmacion){
        if(confirmacion.equals("SI")){
            // Paso numero 17 del DSecuecnia
            buscarVinosConReseñaSolicitada();
        }else{
            finCU();
        }
    }

    public void buscarVinosConReseñaSolicitada(){
        System.out.println("Vinos con reseñas premium en periodo: "+ fechaDesde + " - " + fechaHasta);

        // Variables temporales para formar el ranking
        Map<Float, String> rankingVinos = new HashMap<>();
        Float promedioReseñas;
        String dataVino;


        // TODO - SOLO PARA TEST Y MOSTRAR AL PROFESOR --> Borrar en la version final
        for (Vino vino : vinos) {
            System.out.println(vino.testMostrarVinosYReseñas());
        }



        IIterador iteradorVinos = crearIterador(vinos, periodo);

        iteradorVinos.primero();

        while (!iteradorVinos.haTerminado()){
            Vino vino = (Vino) iteradorVinos.actual();

            if (vino != null){
                promedioReseñas = vino.calcularPromedioReseñasSommelierPeriodo(periodo);

                dataVino =      vino.getId() + // 1 ID
                                "," + vino.getNombre() + // 2 Nombre
                                "," + vino.getPromedioCalificacionGeneral() + // 3 Promedio Calificacion General
                                "," + vino.getNombreBodega() + // 4 Bodega
                                "," + vino.getNombreRegion() + // 5 Region
                                "," + vino.getNombrePais() + // 6 Pais
                                "," + vino.getPrecioArs() + // 7 Precio
                                "," + vino.getVarietales(); // 8 Varietales

                rankingVinos.put(promedioReseñas, dataVino);
            }
            iteradorVinos.siguiente();
        }

        // Lineas de ranking
        top10RankingVinos = rankearVinos(rankingVinos);

        generarArchivo(top10RankingVinos);
        finCU();

    }

    public List<String> rankearVinos(Map<Float, String> rankingVinos){
        return rankingVinos.entrySet()
                .stream()
                .sorted(Map.Entry.<Float, String>comparingByKey().reversed()) // Orden descendente
                .limit(10) // Limitar a los primeros 10
                .map(entry -> entry.getKey() + "," + entry.getValue()) // Formato requerido csv
                .collect(Collectors.toList());
    }

    public void generarArchivo(List<String> vinosFiltrados){


        String textCSV = "Promedio Sommelier, ID, Nombre, Promedio General, Bodega, Region, Pais, Precio, Varietales";

        for (String vino : vinosFiltrados) {
            textCSV += "\n" + vino;
        }

        interfazExcel.exportarExcel(textCSV);

        //TODO para probar
        //interfazExcel.pruebaEnHTML(textCSV);
    }

    public void finCU(){
        System.out.println("Fin de CU24");
        pantalla.cerrar();
    }

    // HECHO Implementacion de la interfaz IAgregado
    public IIterador crearIterador(List<Vino> elementos, List<LocalDate> periodo){
        return new IteradorVinos(vinos, periodo);
    }
}
