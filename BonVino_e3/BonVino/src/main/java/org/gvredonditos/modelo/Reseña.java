package org.gvredonditos.modelo;

import jakarta.persistence.*;

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



    public Reseña() {
    }

    public String getComentario() {
        return comentario;
    }

    public Boolean getEsPremium() {
        return esPremium;
    }

    public Float getPuntaje() {
        return puntaje;
    }

    public Vino getVino() {
        return vino;
    }


    public String toString() {
        return "Reseña [id=" + id + ", comentario=" + comentario + ", esPremium=" + (esPremium ? "SI" : "NO") + ", puntaje=" + puntaje + ", vino=" + vino.getNombre() +  "]";
    }

}
