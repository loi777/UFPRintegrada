package classes;

import java.util.Date;
import java.util.ArrayList;


public class Disciplina {
	private String nome;
	private Date horario;
    private String sala;
    private Aluno[] alunos;
    private Professor professor;
    private ArrayList<float[]> notas;

    public Disciplina(String nome, Date data, String sala, Aluno[] alunos, Professor professor, float[] notas) {
        this.nome = nome;
    	this.horario = data;
        this.sala = sala;
        this.alunos = alunos;
        this.professor = professor;

        // seta a primeira sequencia de notas, caso tenha
        this.notas = new ArrayList<float[]>();
        if (notas.length > 0) {
            this.notas.add(notas);
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
    
    public Professor getProfessor() {
    	return professor;
    }
    
    public void setProfessor(Professor professor) {
    	this.professor = professor;
    }

    //--
    
    public ArrayList<float[]> getNotas() {
    	return notas;
    }

    // add a sequence of grades to the discipline
    public void criarNota(float[] notas) {
        this.notas.add(notas);
    }

    // remove the last sequence of grades added to the discipline
    // FIFO
    public void removerNota() {
        this.notas.remove(this.notas.size());
    }

    //--------------------------------
    
    // send through email a message to all students
    public void mandarNotificacao(String msg, Disciplina disciplina) {
    	Aluno[] alunos = disciplina.getAlunos();

        for (Aluno aluno : alunos) {
            Pessoa documento = aluno.getInfo();
            String email = documento.getEmail();
            documento.enviarEmail(email, msg);
        }
    }
}
