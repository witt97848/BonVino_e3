package org.gvredonditos.modelo;

import jakarta.persistence.*;
import org.gvredonditos.iterators.IAgregado;
import org.gvredonditos.iterators.IIterador;
import org.gvredonditos.iterators.IteradorReseñas;


import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "vinos")
public class Vino implements IAgregado<Reseña> {
    @Id
    private int id;
    private String nombre;

    @OneToOne
    @JoinColumn(name = "bodega_id", referencedColumnName = "id")
    private Bodega bodega;

    @Column(name = "precio_ars")
    private Float precioArs;


    @OneToMany(mappedBy = "vino", fetch = FetchType.EAGER)
    private List<Reseña> reseñas;

    @OneToMany(mappedBy = "vino", fetch = FetchType.EAGER)
    private List<Varietal> varietales;

    @Transient
    private List<LocalDate> periodo;

    public Vino() {}

    public String toString(){
        return "Vino: ("+ id + ") " + nombre + ", Bodega:" + bodega.getNombre() + ", precioArs: " + precioArs;
    }


    // TODO (BORRAR - SOLO TEST)
    public String getReseñasString(){

        String cadena = "";
        for (Reseña reseña : reseñas) {
            cadena += "  " + (reseña.esPremium() ? "Premium" : "No Premium") + " - " + reseña.getPuntaje().toString() + " - " + reseña.getFecha() + "\n";
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

    public List<Reseña> getReseñas(){
        return reseñas;
    }

    public List<Varietal> getVarietales(){
        return varietales;
    }

    public String getNombre(){
        return nombre;
    }

    public Float getPrecioArs(){
        return precioArs;
    }

    public Bodega getBodega(){
        return bodega;
    }

    public Float calcularPromedioReseñasSommelierPeriodo(List<LocalDate> periodo){
        this.periodo = periodo;
        IIterador iteradorReseñas = crearIterador(reseñas);

        iteradorReseñas.primero();

        Float total_puntaje_periodo = 0.0f;
        Float cantidad_resenas_periodo = 0.0f;

        while (!iteradorReseñas.haTerminado()){
            Reseña reseña = (Reseña) iteradorReseñas.actual();

            if (reseña != null){
                System.out.println(reseña.getFecha() + " - " + (reseña.esPremium() ? "PRE":"NOP") + " - " + reseña.getPuntaje());
                total_puntaje_periodo += reseña.getPuntaje();
                cantidad_resenas_periodo++;

            }
            iteradorReseñas.siguiente();
        }

        System.out.println(id + " - " + nombre);
        System.out.println("promedio premium: " + (cantidad_resenas_periodo > 0 ? total_puntaje_periodo / cantidad_resenas_periodo : 0.0f) + "\n");


        return cantidad_resenas_periodo > 0 ? total_puntaje_periodo / cantidad_resenas_periodo : 0.0f;
    }

    public IIterador crearIterador(List<Reseña> reseñas){
        return new IteradorReseñas(reseñas, periodo);
    }

}