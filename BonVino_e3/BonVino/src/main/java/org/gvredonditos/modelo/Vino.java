package org.gvredonditos.modelo;

import jakarta.persistence.*;
import org.gvredonditos.iterators.IAgregado;
import org.gvredonditos.iterators.IIterador;
import org.gvredonditos.iterators.IteradorReseñas;


import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "vinos")
public class Vino implements IAgregado<Reseña, LocalDate> {
    @Id
    private int id;
    private String nombre;
    @OneToOne
    @JoinColumn(name = "bodega_id", referencedColumnName = "id")
    private Bodega bodega;
    @Column(name = "precio_ars")
    private Float precioArs;
    private int añada;
    @Column(name = "imagen_etiqueta")
    private String imagenEtiqueta;
    @Column(name = "nota_cata_bodega")
    private String notaCataBodega;
    @OneToMany(mappedBy = "vino", fetch = FetchType.EAGER)
    private List<Reseña> reseñas;
    @OneToMany(mappedBy = "vino", fetch = FetchType.EAGER)
    private List<Varietal> varietales;

    public Vino() {}

    public String toString(){
        return "Vino: ("+ id + ") " + nombre + ", Bodega:" + bodega.getNombre() + ", precioArs: " + precioArs;
    }

    public String getReseñasString(){

        String cadena = "";
        for (Reseña reseña : reseñas) {
            cadena += "  " + (reseña.esPremium() ? "PREMIUM" : "no pre ") + " - " + reseña.getPuntaje().toString() + " - " + reseña.getFecha() + "\n";
        }
        return cadena;
    }

    public String getVarietalesString(){
        String cadena = "";
        for (Varietal varietal : varietales) {
            cadena += "  " + varietal.toString() + "\n";
        }
        return cadena;
    }

    // TODO solo para test y presentar en consola los datos para validar funcionamiento --> Borrar

    public String testMostrarVinosYReseñas(){
        return "Vino - (" + id + ") " + nombre + "\n" + getReseñasString();
    }

    public List<Reseña> getReseñas(){
        return reseñas;
    }

    public String getVarietales(){
        String varietalesString = "";

        for (Varietal varietal : varietales) {
            varietalesString += varietal.getDescripcion() + " - ";
        }

        return varietalesString;
    }

    public int getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public Float getPrecioArs(){
        return precioArs;
    }

    public String getNombreBodega(){
        return bodega.getNombre();
    }

    public Bodega getBodega(){
        return bodega;
    }

    public String getNombrePais(){
        return bodega.getNombrePais();
    }

    public String getNombreRegion(){
        return bodega.getRegion().getNombre();
    }

    public Float calcularPromedioReseñasSommelierPeriodo(List<LocalDate> periodo){

        IIterador iteradorReseñas = crearIterador(reseñas, periodo);

        iteradorReseñas.primero();

        Float total_puntaje_periodo = 0.0f;
        Float cantidad_resenas_periodo = 0.0f;

        while (!iteradorReseñas.haTerminado()){
            Reseña reseña = (Reseña) iteradorReseñas.actual();

            if (reseña != null){
                total_puntaje_periodo += reseña.getPuntaje();
                cantidad_resenas_periodo++;

            }
            iteradorReseñas.siguiente();
        }
        return promediarReseñas(total_puntaje_periodo, cantidad_resenas_periodo);
    }

    public Float promediarReseñas(Float puntajeTotal, Float cantidadReseñas){
        return cantidadReseñas > 0 ? puntajeTotal / cantidadReseñas : 0.0f;
    }

    public Float getPromedioCalificacionGeneral(){
        Float total = 0.0f;
        for (Reseña reseña : reseñas) {
            total += reseña.getPuntaje();
        }
        return reseñas.size() > 0 ? total / reseñas.size() : 0.0f;
    }

    public IIterador crearIterador(List<Reseña> reseñas, List<LocalDate> periodo){
        return new IteradorReseñas(reseñas, periodo);
    }

}