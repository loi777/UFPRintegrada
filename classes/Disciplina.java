package classes;

import java.util.Date;

public class Disciplina {
	private String nome;
	private Date horario;
    private String sala;
    private Aluno[] alunos;
    private String professor;
    private float[] notas;

    public Disciplina(String nome, Date data, String sala, Aluno[] alunos, String professor, float notas[]) {
        this.nome = nome;
    	this.horario = data;
        this.sala = sala;
        this.alunos = alunos;
        this.professor = professor;
        this.notas = notas;
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
    
    public float[] getNotas() {
    	return notas;
    }
    
    public void setNotas(float[] notas) {
    	this.notas = notas;
    }

    //--------------------------------
    
    public void criarNota() {
    }
    
    public void mandarNotificacao(String msg, Disciplina disciplina) {
    	Aluno[] alunos = disciplina.getAlunos();
        for (Aluno aluno : alunos) {
            Pessoa documento = aluno.getInfo();
            String email = documento.getEmail();
            documento.enviarEmail(email, msg);
        }
    }
}
