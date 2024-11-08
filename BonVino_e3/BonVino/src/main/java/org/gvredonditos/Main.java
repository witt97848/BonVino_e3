package org.gvredonditos;

import java.util.List;

import org.gvredonditos.modelo.*;
import org.gvredonditos.repositories.*;


public class Main {
    public static void main(String[] args) {
        PaisRepository paisRepo = new PaisRepository();
        BodegaRepository bodegaRepo = new BodegaRepository();
        ProvinciaRepository provinciaRepo = new ProvinciaRepository();
        RegionVitivinicolaRepository regionRepo = new RegionVitivinicolaRepository();
        ReseñaRepository reseñaRepo = new ReseñaRepository();
        TipoUvaRepository tipoUvaRepo = new TipoUvaRepository();
        VarietalRepository varietalRepo = new VarietalRepository();
        VinoRepository vinoRepo = new VinoRepository();


        // TODO Eliminar Siguiente llamadas

//        List<Pais> paises = paisRepo.findAll();
//        paises.forEach(pais -> {System.out.println(pais); pais.getProvincias().forEach(System.out::println);});

//        List<Provincia> provincias = provinciaRepo.findAll();
//        provincias.forEach(p -> {System.out.println(p);p.getRegiones().forEach(r -> System.out.println("  " + r));});

//        List<RegionVitivinicola> regiones = regionRepo.findAll();
//        regiones.forEach(r -> System.out.println(" == " + r));

//        List<Bodega> bodegas = bodegaRepo.findAll();
//        bodegas.forEach(System.out::println);

//        List<Reseña> reseñas = reseñaRepo.findAll();
//        reseñas.forEach(System.out::println);

//        List<TipoUva> tipoUvas = tipoUvaRepo.findAll();
//        tipoUvas.forEach(System.out::println);

//        List<Varietal> varietales = varietalRepo.findAll();
//        varietales.forEach(System.out::println);

//        List<Vino> vinos = vinoRepo.findAll();
//        vinos.forEach(v -> {
//            System.out.println(v.toString());
//            System.out.println(v.getReseñasString());
//            System.out.println(v.getVarietalesString());
//        });

        List<Vino> vinos = vinoRepo.findAll();
        vinos.forEach(v -> {
            System.out.println(v.toString());
            System.out.println(v.getReseñasString());
        });

        // Cierra el SessionFactory después de su uso
        ((PaisRepository) paisRepo).closeSessionFactory();
    }
}