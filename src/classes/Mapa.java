package classes;

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

        this.ensalamento.filtrarMaterias(M);
    }
}
