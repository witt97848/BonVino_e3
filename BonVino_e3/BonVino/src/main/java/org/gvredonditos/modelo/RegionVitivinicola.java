package org.gvredonditos.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "regiones_vitivinicolas")
public class RegionVitivinicola {
    @Id
    private int id;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "provincia_id", referencedColumnName = "id")
    private Provincia provincia;

    public RegionVitivinicola() {
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public String toString() {
        return "RegionVitivinicola [id=" + id + ", nombre=" + nombre + ", provinciaId=" + provincia.getNombre() + "]";
    }
}
