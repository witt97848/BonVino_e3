package org.gvredonditos.infraestructure;

import org.gvredonditos.interfaces.PantallaGenerarReporteDeRankingDeVinos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class MenuPrincipal {

    private JFrame frame;
    private JButton botonGenerarReporte;
    private JButton botonOtraFuncionalidad1;
    private JButton botonOtraFuncionalidad2;
    private PantallaGenerarReporteDeRankingDeVinos pantallaRankingDeVinos;

    public MenuPrincipal(){
    frame = new JFrame("Menu Principal");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setIconImage(new ImageIcon(getClass().getResource(RUTA_RESOURCES +"/images/LogoPPAI.png")).getImage());

    botonGenerarReporte = new JButton("Generar Reporte de Ranking de vinos");
    botonGenerarReporte.setBounds(100, 50, 500, 50);
    botonGenerarReporte.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            pantallaRankingDeVinos = new PantallaGenerarReporteDeRankingDeVinos();

            pantallaRankingDeVinos.opcionGenerarRankingDeVino();
        }
    });
    frame.add(botonGenerarReporte);

    botonOtraFuncionalidad1 = new JButton("Otra funcionalidad 1");
        botonOtraFuncionalidad1.setBounds(100, 150, 500, 50);
        frame.add(botonOtraFuncionalidad1);
    botonOtraFuncionalidad2 = new JButton("Otra funcionalidad 2");
        botonOtraFuncionalidad2.setBounds(100, 250, 500, 50);
        frame.add(botonOtraFuncionalidad2);

    }

    public void habilitarPantalla(){
        frame.setBounds(0,0,1000,600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }


    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de gestión de vinos");

        MenuPrincipal menu = new MenuPrincipal();
        menu.habilitarPantalla();

    }
}
