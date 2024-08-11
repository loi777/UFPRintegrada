package classes;    

public class Disciplinas {
	private Disciplina[] disciplinas;
	
	public Disciplinas(Disciplina[] disciplinas) {
        this.disciplinas = disciplinas;
    }

    //--------------------------------
	
	public Disciplina[] getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Disciplina[] disciplinas) {
        this.disciplinas = disciplinas;
    }

    //--------------------------------

    // BLAME::LUIZ
    public void removeDisciplina(Disciplina D) {
        for (int i = 0; i < disciplinas.length; i++) {
            // first find M inside disciplinas
            if (D.getNome() == disciplinas[i].getNome()) {
                // found M inside disciplinas, proceed to remove
                //disciplinas = ArrayUtils.remove(disciplinas, disciplinas[i]);
                return;
            }
        }
    }

    //--------------------------------
    
    public Disciplina getDisciplinaPorNome(Disciplinas disciplinas, String nome) {
    	for (int i = 0; i < disciplinas.getDisciplinas().length; i++) {
            if(disciplinas.getDisciplinas()[i].getNome() == nome) {
            	return disciplinas.getDisciplinas()[i];
            }
        }
		return null;
    }
    
    public Disciplina getDisciplina(Disciplina d) {
    	System.out.println("Get disciplina");
    	return d;
    }

    // BLAME::LUIZ
    public void filtrarMaterias(Disciplinas M) {
        // see if there is any M.disciplinas
        for (int i = 0; i < M.getDisciplinas().length; i++) {

        }
    }
}
