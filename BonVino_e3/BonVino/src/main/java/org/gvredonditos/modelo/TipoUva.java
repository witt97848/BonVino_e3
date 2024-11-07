package org.gvredonditos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipos_uva")
public class TipoUva {
    @Id
    private int id;
    private String descripcion;
    private String nombre;

    public TipoUva() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String toString() {
        return "Tipo de uva " + nombre + ", " + descripcion;
    }
}
