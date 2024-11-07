package org.gvredonditos.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "provincias")
public class Provincia {
    @Id
    private int id;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "pais_id", referencedColumnName = "id")
    private Pais pais;

    @OneToMany(mappedBy = "provincia", fetch = FetchType.EAGER)
    List<RegionVitivinicola> regiones;

    public Provincia() {}

    public String getNombre() {
        return nombre;
    }

    public Pais getPais() {
        return pais;
    }

    public List<RegionVitivinicola> getRegiones() {
        return regiones;
    }

    public int getId() {
        return id;
    }

    public String toString(){
        return "Provincia [id=" + id + ", nombre=" + nombre + ", pais=" + pais.getNombre() + "]";
    }
}
