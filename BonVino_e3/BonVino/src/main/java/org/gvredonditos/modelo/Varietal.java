package org.gvredonditos.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "varietales")
public class Varietal {
    @Id
    private int id;
    private String descripcion;
    @Column(name = "porcentaje_composicion")
    private Float porcentajeComposicion;

    @OneToOne
    @JoinColumn(name = "tipo_uva_id", referencedColumnName = "id")
    private TipoUva tipoUvaId;

    @ManyToOne
    @JoinColumn(name = "vino_id", referencedColumnName = "id")
    private Vino vino;

    public Varietal() {}

    public String toString(){
        return "Varietal (" + id + ") " + descripcion + ", porcentajeComposicion: " + porcentajeComposicion +
                "\n  " + tipoUvaId.toString() +
                "\n  " + vino.getNombre();
    }

}

