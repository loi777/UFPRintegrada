package classes;

import java.awt.Image;                  // Image manip lib
import java.awt.image.BufferedImage;    // Image manip lib
import java.io.File;                    // Image manip lib
import java.io.IOException;             // Image manip lib
import javax.swing.*;                   // Image manip lib
import java.awt.*;                      // Image manip lib
import java.awt.event.ActionEvent;      // Image manip lib
import java.awt.event.ActionListener;   // Image manip lib


import javax.imageio.*;   // Image manip lib

public class Mapa {
	private String[] campus;            // an array of strings with each campus
	private String[][] predios;         // each campus has a number of different buildings
	private Ensalamento ensalamento;    // the Disciplinas of each map
    private String[] mapas;             // the path to map files to show to the user
	
	public Mapa(String[] campus, String predios[][], Ensalamento ensalamento, String[] mapas) {
        this.campus = campus;
        this.predios = predios;
        this.ensalamento = ensalamento;
        this.mapas = mapas;
    }

    //--------------------------------
	
	public String[] getCampus() {
        return campus;
    }

    public void setCampus(String campus, int id) {
        this.campus[id] = campus;
    }

    //--
    
    public String[][] getPredios() {
    	return predios;
    }
    
    public void setPredios(String predios, int campus, int id) {
    	this.predios[campus][id] = predios;
    }

    //--
    
    public Ensalamento getEnsalamento() {
    	return ensalamento;
    }
    
    public void setEnsalamento(Ensalamento ensalamento) {
    	this.ensalamento = ensalamento;
    }

    //--

    public String[] getMapas() {
    	return mapas;
    }
    
    public void setMapa(String mapaFile, int campusId) {
    	this.mapas[campusId] = mapaFile;
    }

    //--------------------------------
    
    public void filtrarMaterias(Disciplinas M) {
    	System.out.println("Filtrando cursos do mapa interativo...");

        //--

        this.ensalamento.getCursos().filtrarMaterias(M);
    }

    public void showMap() {
        try {
            BufferedImage picture = ImageIO.read(new File("./classes/ImageSource/politecnico.jpg"));

            JLabel picLabel = new JLabel(new ImageIcon(picture));

            JPanel jPanel = new JPanel();
            jPanel.add(picLabel);
            
            JFrame f = new JFrame();
            f.setSize(new Dimension(picture.getWidth(), picture.getHeight()));
            f.add(jPanel);
            f.setVisible(true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
