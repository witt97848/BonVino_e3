package org.gvredonditos.iterators;

import org.gvredonditos.modelo.Reseña;

import java.time.LocalDate;
import java.util.List;

public class IteradorReseñas implements IIterador<Reseña, LocalDate>{
    private List<Reseña> elementos;
    private int posicionActual = 0;
    private List<LocalDate> filtroPeriodo;

    public IteradorReseñas(List<Reseña> reseñas, List<LocalDate> filtro){
        this.elementos = reseñas;
        this.filtroPeriodo = filtro;
    }

    @Override
    public void primero() {
        posicionActual = 0;
    }

    @Override
    public void siguiente() {
        posicionActual++;
    }

    @Override
    public Boolean haTerminado() {
        return posicionActual  >= elementos.size();
    }


    @Override
    public Boolean cumpleFiltros(List<LocalDate> filtro, Reseña elem) {
        return elem.esDePeriodo(filtro) && elem.esPremium();
    }

    @Override
    public Reseña actual() {
        Reseña elemActual = elementos.get(posicionActual);
        if (cumpleFiltros(filtroPeriodo, elemActual)){
            return elemActual;
        } else {
            return null;
        }

    }
}
