package org.gvredonditos.control;

import org.gvredonditos.interfaces.InterfazExcel;
import org.gvredonditos.interfaces.PantallaGenerarReporteDeRankingDeVinos;
import org.gvredonditos.iterators.IIterador;
import org.gvredonditos.iterators.IteradorVinos;
import org.gvredonditos.modelo.Vino;
import org.gvredonditos.repositories.VinoRepository;
import java.time.LocalDate;

import java.util.*;
import java.util.stream.Collectors;

//public class GestorDeGeneracionDeReporte implements IAgregado<Vino> {
public class GestorDeGeneracionDeReporte {

    public PantallaGenerarReporteDeRankingDeVinos pantalla;
    public InterfazExcel interfazExcel;
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
        System.out.println("Buscando vinos con al menos 1 reseña premium en periodo...");

        // Variables temporales para formar el ranking

        Map<Float, String> rankingVinos = new HashMap<>();
        Float promedioReseñas;
        String dataVino;


        IIterador iteradorVinos = crearIterador(vinos);

        iteradorVinos.primero();

        while (!iteradorVinos.haTerminado()){
            Vino vino = (Vino) iteradorVinos.actual();

            if (vino != null){
                promedioReseñas = vino.calcularPromedioReseñasSommelierPeriodo(periodo);

                dataVino =
                            " - " + vino.getNombre() + "[" + vino.getId() + "]" +
                            "\n  Calificacion general: " + vino.getPromedioCalificacionGeneral() +
                            "\n  Bodega: " + vino.getBodega().getNombre() +
                            "\n  Region: " + vino.getRegion() +
                            "\n  Pais: " + vino.getNombrePais() +
                            "\n  Precio: " + vino.getPrecioArs() +
                            "\n  Varietales: " + vino.getVarietales();

                rankingVinos.put(promedioReseñas, dataVino);

//                System.out.println(dataVino);
            }
            iteradorVinos.siguiente();
        }

        // Lineas de ranking
        top10RankingVinos = rankearVinos(rankingVinos);

        // TODO ELIMINAR (solo para mostrar)
        for (String vino : top10RankingVinos){
            System.out.println(vino);
        }

    }

    public List<String> rankearVinos(Map<Float, String> rankingVinos){
        return rankingVinos.entrySet()
                .stream()
                .sorted(Map.Entry.<Float, String>comparingByKey().reversed()) // Orden descendente
                .limit(10) // Limitar a los primeros 10
                .map(entry -> "\nPromedio Sommelier: " + entry.getKey() + entry.getValue()) // Formato requerido
                .collect(Collectors.toList());

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
