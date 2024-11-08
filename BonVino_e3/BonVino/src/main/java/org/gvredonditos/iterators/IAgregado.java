package org.gvredonditos.iterators;

import java.util.List;

public interface IAgregado<K, T> {
    IIterador crearIterador(List<K> elementos, List<T> filtros);
}
