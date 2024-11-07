package org.gvredonditos.modelo;

import jakarta.persistence.*;
import org.gvredonditos.repositories.PaisRepository;

import java.util.List;

@Entity
@Table(name = "paises")
public class Pais {
    @Id
    private int id;
    private String nombre;

    @OneToMany(mappedBy = "pais", fetch = FetchType.EAGER)
    private List<Provincia> provincias;



    @Override
    public String toString() {
        return "Pais [" + "id=" + id + ", nombre=" + nombre;
    }

    public Pais() {}

    public Pais(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    public List<Provincia> getProvincias() {
        return provincias;
    }

    public String getNombre() {
        return nombre;
    }


}

