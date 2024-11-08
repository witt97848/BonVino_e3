package org.gvredonditos.iterators;

import java.util.List;

public interface IIterador<K, T> {
    void primero();
    void siguiente();
    Boolean haTerminado();
    Boolean cumpleFiltros(List<T> filtro, K elem);
    K actual();
}
