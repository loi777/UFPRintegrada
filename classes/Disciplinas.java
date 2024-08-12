package classes;    

import java.lang.Object;    
import java.util.ArrayList;

public class Disciplinas {
	private ArrayList<Disciplina> disciplinas;
	
	public Disciplinas(Disciplina[] disciplinas) {
        this.disciplinas = new ArrayList<Disciplina>();

        for (int i = 0; i < disciplinas.length; i++) {
            this.disciplinas.add(disciplinas[i]);
        }
    }   

    //--------------------------------
	
	public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Disciplina[] disciplinas) {
        for (int i = 0; i < disciplinas.length; i++) {
            this.disciplinas.add(disciplinas[i]);
        }
    }

    //--------------------------------

    // Remove one discipline from this class
    public void removeDisciplina(Disciplina D) {
        for (int i = 0; i < disciplinas.size(); i++) {
            // first find D inside disciplinas
            if (D.getNome() == disciplinas.get(i).getNome()) {
                // found D in index i, proceed to remove
                
                disciplinas.remove(i);

                return;
            }
        }
    }

    //--------------------------------
    
    // returns a disciplina found that matches the string nome
    // if none returns null
    public Disciplina getDisciplinaPorNome(String nome) {
    	for (int i = 0; i < disciplinas.size(); i++) {
            if(disciplinas.get(i).getNome() == nome) {
            	return disciplinas.get(i);
            }
        }
		return null;
    }
    
    public Disciplina getDisciplina(Disciplina d) {
    	System.out.println("Get disciplina");
    	return d;
    }

    //--------------------------------

    // BLAME::LUIZ
    // removes all disciplinas inside M from this class
    public void filtrarMaterias(Disciplinas M) {
        int lSize = M.getDisciplinas().size();
        
        // Go through all disciplines and remove them if found
        for (int i = 0; i < lSize; i++) {
            removeDisciplina(M.getDisciplinas().get(i));    
        }
    }
}
