package org.gvredonditos.modelo;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "reseñas")
public class Reseña {
    @Id
    private int id;
    private String comentario;
    @Column(name = "es_premium")
    private Boolean esPremium;
    private Float puntaje;

    @ManyToOne
    @JoinColumn(name="vino_id", referencedColumnName = "id")
    private Vino vino;

    @Column(name = "fecha_reseña")
    private String fechaString;


    public Reseña() {}

    public String getComentario() {
        return comentario;
    }

    public Boolean esPremium() {
        return esPremium;
    }

    public Float getPuntaje() {
        return puntaje;
    }

    public Vino getVino() {
        return vino;
    }

    public LocalDate getFecha() {
        return LocalDate.parse(fechaString);
    }

    public Boolean esDePeriodo(List<LocalDate> periodo){
        return periodo.get(0).minusDays(1).isBefore(getFecha()) && periodo.get(1).plusDays(1).isAfter(getFecha());
    }


    public String toString() {
        return "Reseña [id=" + id + ", comentario=" + comentario + ", esPremium=" + (esPremium ? "SI" : "NO") + ", puntaje=" + puntaje + ", vino=" + vino.getNombre() +  "]";
    }

}
