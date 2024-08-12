package classes;

import java.util.Date;

public class Disciplina {
	private String nome;
	private Date horario;
    private String sala;
    private Aluno[] alunos;
    private String professor;
    private ArrayList<float[]> notas;

    public Disciplina(String nome, Date data, String sala, Aluno[] alunos, String professor, float[] notas) {
        this.nome = nome;
    	this.horario = data;
        this.sala = sala;
        this.alunos = alunos;
        this.professor = professor;

        // seta a primeira sequencia de notas, caso tenha
        this.notas = new ArrayList<float[]>;
        if (notas.length > 0) {
            notas.add(notas);
        }
    }

    //--------------------------------

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //--
    
    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    //--
    
    public String getSala() {
    	return sala;
    }
    
    public void setSala(String sala) {
    	this.sala = sala;
    }

    //--
    
    public Aluno[] getAlunos() {
    	return alunos;
    }
    
    public void setAlunos(Aluno[] alunos) {
    	this.alunos = alunos;
    }

    //--
    
    public String getProfessor() {
    	return professor;
    }
    
    public void setProfessor(String professor) {
    	this.professor = professor;
    }

    //--
    
    public ArrayList<float[]> getNotas() {
    	return notas;
    }

    // add a sequence of grades to the discipline
    public void criarNota(float[] notas) {
        notas.add(notas);
    }

    // remove the last sequence of grades added to the discipline
    public void removerNota(float[] notas) {
        notas.remove(notas.size());
    }

    //--------------------------------
    
    public void mandarNotificacao(String msg, Disciplina disciplina) {
    	Aluno[] alunos = disciplina.getAlunos();
        for (Aluno aluno : alunos) {
            Pessoa documento = aluno.getInfo();
            String email = documento.getEmail();
            documento.enviarEmail(email, msg);
        }
    }
}
