package classes;

public class Aluno {
    private String grr;
    private Documento informacoes;
    private float ira;
    private Disciplinas matriculas;

    public Aluno(String grr, Documento informacoes, float ira, Disciplinas matriculas) {
        this.grr = grr;
        this.informacoes = informacoes;
        this.ira = ira;
        this.matriculas = matriculas;
    }

    //--------------------------------

    public Documento getInfo() {
        return informacoes;
    }

    //--

    public String getGrr() {
        return grr;
    }

    public void setGrr(String grr) {
        this.grr = grr;
    }

    //--
    
    public float getIra() {
        return ira;
    }

    public void setIra(float ira) {
        this.ira = ira;
    }

    //--
    
    public Disciplinas getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(Disciplinas matriculas) {
        this.matriculas = matriculas;
    }

}
