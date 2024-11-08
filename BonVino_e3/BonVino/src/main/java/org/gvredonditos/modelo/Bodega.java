package org.gvredonditos.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "bodegas")
public class Bodega {
    @Id
    private int id;

    private String descripcion;
    private String historia;
    private String nombre;

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getHistoria() {
        return historia;
    }

    public String getNombre() {
        return nombre;
    }

    public RegionVitivinicola getRegion() {
        return region;
    }

    public String getNombrePais(){
        return region.getNombrePais();
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    private RegionVitivinicola region;

    @Override
    public String toString() {
        return "Bodega" + id + ", " + nombre + ", " + descripcion + "\n  REGION:" + region.getNombre();}

}
