package org.gvredonditos.iterators;

import org.gvredonditos.modelo.Vino;

import java.time.LocalDate;
import java.util.List;

public class IteradorVinos implements IIterador<Vino, LocalDate>{
    private List<Vino> elementos;
    private int posicionActual = 0;
    private List<LocalDate> filtroPeriodo;

    public IteradorVinos(List<Vino> vinos, List<LocalDate> filtro){
        this.elementos = vinos;
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
    public Boolean cumpleFiltros(List<LocalDate> filtro, Vino elem) {
        return true;
    }

    @Override
    public Vino actual() {
        Vino elemActual = elementos.get(posicionActual);
        return elemActual;
//        cumpleFiltros()
    }
}
