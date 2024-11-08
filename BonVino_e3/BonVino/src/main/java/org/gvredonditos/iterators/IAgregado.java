package org.gvredonditos.iterators;

import java.util.List;

public interface IAgregado<K> {
    IIterador crearIterador(List<K> elementos);
}
