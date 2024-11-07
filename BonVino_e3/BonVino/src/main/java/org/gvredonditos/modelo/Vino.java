package org.gvredonditos.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "vinos")
public class Vino {
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


    public Vino() {}

    public String toString(){
        return "Vino: ("+ id + ") " + nombre + ", Bodega:" + bodega.getNombre() + ", precioArs: " + precioArs;
    }


    // TODO (BORRAR - SOLO TEST)
    public String getReseñasString(){

        String cadena = "";
        for (Reseña reseña : reseñas) {
            cadena += "  " + (reseña.getEsPremium() ? "Premium" : "No Premium") + " - " + reseña.getPuntaje().toString() + "\n";
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

}


//Varietales
//Reseñas