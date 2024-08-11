package classes;

public class Aluno {
    private String grr;
    private Pessoa pessoaInfo;
    private float ira;
    private Disciplinas matriculas;

    public Aluno(String grr, Pessoa pessoaInfo, float ira, Disciplinas matriculas) {
        this.grr = grr;
        this.pessoaInfo = pessoaInfo;
        this.ira = ira;
        this.matriculas = matriculas;
    }

    //--------------------------------

    public Pessoa getInfo() {
        return pessoaInfo;
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
