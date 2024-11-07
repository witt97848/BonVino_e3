package org.gvredonditos.interfaces;

import org.gvredonditos.control.GestorDeGeneracionDeReporte;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class PantallaGenerarReporteDeRankingDeVinos {
    private GestorDeGeneracionDeReporte gestor;
    private InterfazExcel interfazExcel;
    private JFrame frame;
    private JLabel labelImagenLogo, labelFechaDesde, labelFechaHasta, labelImagenTitulo;
    private JLabel labelTipoDeReseña;
    private JLabel labelFormatoVisualizacion;
    private JTextField inputDiaFechaDesde, inputMesFechaDesde, inputAñoFechaDesde;
    private JTextField inputDiaFechaHasta, inputMesFechaHasta, inputAñoFechaHasta;
    private JComboBox comboBoxTipoDeReseña;
    private JComboBox comboBoxFormatoVisualizacion;
    private JButton btnTomarFechaDesdeFechaHasta, btnCancelarCU, btnTomarTipoDeReseña, btnTomarFormatoVisualizacion;
    private ImageIcon imagenLogo;

    public PantallaGenerarReporteDeRankingDeVinos(){
        this.gestor = new GestorDeGeneracionDeReporte(this);
    }

    public void opcionGenerarRankingDeVino() {
        // _________________ Mensaje 2 del DS
        habilitarPantalla();
        System.out.println("Generando ranking de vinos...");
        // ___________________________ Mensaje 3 del DS
        gestor.generarRankingDeVinos();
    }

    // HECHO
    public void habilitarPantalla(){
        // Buttons _____________________________________________________________
        btnCancelarCU = new JButton("Cancelar");
        btnCancelarCU.setBounds(800, 500, 150, 45);
        btnCancelarCU.setBackground(new Color(200,200,200));
        btnCancelarCU.setForeground(new Color(102, 66, 138));
        btnCancelarCU.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        btnCancelarCU.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                gestor.finCU();
            }
        });

        // Frame _______________________________________________________________
        frame = new JFrame("Generar Ranking de Vinos");
        frame.setLayout(null);
        frame.setBounds(0,0,1000,600);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new java.awt.Color(30,15,35));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setIconImage(new ImageIcon(getClass().getResource("/images/LogoPPAI.png")).getImage());

        // Imagenes ____________________________________________________________
        ImageIcon imagenLogo = new ImageIcon(getClass().getResource("/images/LogoPPAI.png"));
        labelImagenLogo = new JLabel(imagenLogo);
        labelImagenLogo.setBounds(60,80,150,150);

        ImageIcon imagenTitulo = new ImageIcon(getClass().getResource("/images/TituloGrupo.png"));
        labelImagenTitulo = new JLabel(imagenTitulo);
        labelImagenTitulo.setBounds(50,250,170,170);

        // Agregar elementos al frame ___________________________________________
        frame.add(btnCancelarCU);
        frame.add(labelImagenLogo);
        frame.add(labelImagenTitulo);

        System.out.println("Pantalla habilitada");
        frame.setVisible(true);
    }

    // HECHO
    public void solicitarFechaDesdeYFechaHasta(){
        // TextFields___________________________________________________________
        inputDiaFechaDesde = new JTextField();
        inputMesFechaDesde = new JTextField();
        inputAñoFechaDesde = new JTextField();
        inputDiaFechaDesde.setBounds(250, 100, 45, 35);
        inputMesFechaDesde.setBounds(310, 100, 45, 35);
        inputAñoFechaDesde.setBounds(370, 100, 60, 35);
        inputDiaFechaDesde.setBackground(new Color(240,240,240));
        inputMesFechaDesde.setBackground(new Color(240,240,240));
        inputAñoFechaDesde.setBackground(new Color(240,240,240));
        inputDiaFechaDesde.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        inputMesFechaDesde.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        inputAñoFechaDesde.setFont(new Font("Lucida Grande", Font.PLAIN, 20));


        inputDiaFechaHasta = new JTextField();
        inputMesFechaHasta = new JTextField();
        inputAñoFechaHasta = new JTextField();
        inputDiaFechaHasta.setBounds(460, 100, 45, 35);
        inputMesFechaHasta.setBounds(520, 100, 45, 35);
        inputAñoFechaHasta.setBounds(580, 100, 60, 35);
        inputDiaFechaHasta.setBackground(new Color(240,240,240));
        inputMesFechaHasta.setBackground(new Color(240,240,240));
        inputAñoFechaHasta.setBackground(new Color(240,240,240));
        inputDiaFechaHasta.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        inputMesFechaHasta.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        inputAñoFechaHasta.setFont(new Font("Lucida Grande", Font.PLAIN, 20));


        // Labels ______________________________________________________________

        labelFechaDesde = new JLabel("Fecha desde: [dd/mm/yyyy]");
        labelFechaDesde.setBounds(250, 70, 200, 20);
        labelFechaDesde.setForeground(Color.WHITE);
        labelFechaDesde.setFont(new Font("Lucida Grande", Font.PLAIN, 16));

        labelFechaHasta = new JLabel("Fecha hasta: [dd/mm/yyyy]");
        labelFechaHasta.setBounds(460, 70, 200, 20);
        labelFechaHasta.setForeground(Color.WHITE);
        labelFechaHasta.setFont(new Font("Lucida Grande", Font.PLAIN, 16));

        // Buttons _____________________________________________________________
        btnTomarFechaDesdeFechaHasta = new JButton("Tomar fechas");
        btnTomarFechaDesdeFechaHasta.setBounds(660, 100, 150, 45);
        btnTomarFechaDesdeFechaHasta.setBackground(new Color(102, 66, 138));
        btnTomarFechaDesdeFechaHasta.setForeground(Color.WHITE);
        btnTomarFechaDesdeFechaHasta.setFont(new Font("Lucida Grande", Font.PLAIN, 18));

        // Evento del botón para tomar las fechas
        btnTomarFechaDesdeFechaHasta.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                // __________________________________________ Mensaje 5 del DS
                try{
                    Date[] fechas = tomarFechaDesdeFechaHasta();
                    // ______________________________________ Mensaje 6 del DS
                    if (validarFechas(fechas[0], fechas[1])){
                        System.out.println("Fechas válidas");
                        // _______________________________________________ Mensaje 7 del DS

                        inputDiaFechaDesde.setEnabled(false);
                        inputMesFechaDesde.setEnabled(false);
                        inputAñoFechaDesde.setEnabled(false);
                        inputDiaFechaHasta.setEnabled(false);
                        inputMesFechaHasta.setEnabled(false);
                        inputAñoFechaHasta.setEnabled(false);
                        btnTomarFechaDesdeFechaHasta.setVisible(false);

                        gestor.tomarFechaDesdeYFechaHasta(fechas[0], fechas[1]);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Fechas invalidas.");
                        System.out.println("Fechas inválidas");
                    }
                } catch (Exception error){
                    JOptionPane.showMessageDialog(null, "Formato de fecha invalida. [dd/mm/yyyy]");
                    System.out.println("Formato de fecha invalida. [dd/mm/yyyy]");
                }
            }
        });

        // Agregar elementos al frame

        frame.add(inputDiaFechaDesde);
        frame.add(inputMesFechaDesde);
        frame.add(inputAñoFechaDesde);

        frame.add(inputDiaFechaHasta);
        frame.add(inputMesFechaHasta);
        frame.add(inputAñoFechaHasta);

        frame.add(labelFechaDesde);
        frame.add(labelFechaHasta);
        frame.add(btnTomarFechaDesdeFechaHasta);
    }

    // HECHO
    public Date[] tomarFechaDesdeFechaHasta(){
        Date[] fechas = new Date[2];

        int diaDesde = Integer.parseInt(inputDiaFechaDesde.getText());
        int mesDesde = Integer.parseInt(inputMesFechaDesde.getText());
        int añoDesde = Integer.parseInt(inputAñoFechaDesde.getText());

        int diaHasta = Integer.parseInt(inputDiaFechaHasta.getText());
        int mesHasta = Integer.parseInt(inputMesFechaHasta.getText());
        int añoHasta = Integer.parseInt(inputAñoFechaHasta.getText());

        fechas[0] = new Date(añoDesde - 1900, mesDesde - 1, diaDesde); // Fecha desde
        fechas[1] = new Date(añoHasta - 1900, mesHasta - 1, diaHasta); // Fecha hasta
        return fechas;
    }

    // HECHO
    public Boolean validarFechas (Date fechaDesde, Date fechaHasta){
        return fechaDesde.before(fechaHasta);
    }

    // TODO Implementar
    public void solicitarTipoDeReseña(){
        // solicitar tipo de reseña
    }

    // TODO Implementar
    public void tomarSeleccionSommelier(){
        // tomar seleccion sommelier
    }

    // TODO Implementar
    public void solicitarFormatoVisualizacion(){
        // solicitar formato de visualizacion
    }

    // TODO Implementar
    public void tomarSeleccionFormato(){
        // tomar seleccion formato de visualizacion
    }

    // TODO Implementar
    public void solicitarConfirmacion(){
        // solicitar confirmacion
    }

    // TODO Implementar
    public void tomarConfirmacion(){
        // tomar confirmacion
    }

    // HECHO
    public void cerrar(){
        frame.dispose();
    }





}
