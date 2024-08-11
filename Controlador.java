package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import classes.Aluno;           // Nossas classes
import classes.Disciplina;      // Nossas classes
import classes.Disciplinas;     // Nossas classes
import classes.Documento;       // Nossas classes
import classes.Ensalamento;     // Nossas classes
import classes.Mapa;            // Nossas classes
import classes.Professor;       // Nossas classes
import classes.Siga;            // Nossas classes

//----------------------------------------------------

public class Controlador extends JFrame {

    public Controlador(Disciplinas disciplinas) {
        setTitle("UFPR integrada");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Selecionar perfil: ");
        JButton alunoButton = new JButton("Aluno");
        JButton professorButton = new JButton("Professor");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(label);
        panel.add(alunoButton);
        panel.add(professorButton);

        add(panel);

        alunoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options = {"Encontre sua sala"};
                int n = JOptionPane.showOptionDialog(null,
                        "Escolha uma opção:",
                        "",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
                if (n == 0) {
                    // código para o caso de uso de encontrar sala
                }
            }
        });

        professorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options = {"Lançar notas", "Enviar notificação"};
                int n = JOptionPane.showOptionDialog(null,
                        "Escolha uma opção:",
                        "",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
                if (n == 0) {
                    // código para o caso de uso de lançar notas
                } else if (n == 1) {
                    String[] lista = new String[disciplinas.getDisciplinas().length];
                    for (int i = 0; i < disciplinas.getDisciplinas().length; i++) {
                        lista[i] = disciplinas.getDisciplinas()[i].getNome();
                    }

                    String selecionada = (String) JOptionPane.showInputDialog(
                            null,
                            "Escolha a disciplina:",
                            "Selecionar Disciplina",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            lista,
                            lista[0]);

                    if (selecionada != null) {
                        // solicitando a mensagem do usuário
                        String mensagem = JOptionPane.showInputDialog(
                                null,
                                "Digite a mensagem a ser enviada:",
                                "Enviar Notificação",
                                JOptionPane.PLAIN_MESSAGE);
                        
                        if (mensagem != null && !mensagem.trim().isEmpty()) {
                            Disciplina disciplina = disciplinas.getDisciplinaPorNome(disciplinas, selecionada);
                            disciplina.mandarNotificacao(mensagem, disciplina);
                            JOptionPane.showMessageDialog(null, "Notificação enviada para a disciplina: " + selecionada);
                        } else {
                            JOptionPane.showMessageDialog(null, "Nenhuma mensagem foi inserida.", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
    }

    //---------------------------------------------------------------

    public static void main(String[] args) {

        //==== Criando Professores e Alunos
        Documento doc1 = new Documento("Andrey Ricardo Pimentel", "103.456.465-00", "PR-10.332.278", "andrey@exemplo.com");
        Documento doc2 = new Documento("João Silva", "123.456.789-00", "MG-12.345.678", "joao@exemplo.com");
        Documento doc = new Documento("Maria Oliveira", "987.654.321-00", "SP-87.654.321", "maria@exemplo.com");

        Professor prof1 = new Professor(doc1);
        Aluno aluno1 = new Aluno("GRR20201234", doc1, 8.5f, null);
        Aluno aluno2 = new Aluno("GRR20205678", doc2, 9.0f, null);

        Aluno[] Lalunos = {aluno1, aluno2};
        Aluno[] LalunosVazia = {};

        //==== Criando notas

        float[] notas1 = {7.5f, 8.0f};
        float[] notas2 = {8.5f, 9.6f};
        float[] notas3 = {7.1f, 8.5f};
        float[] notas4 = {};
        float[] notas5 = {};

        //==== Criando Disciplinas e Ensalamento

        Disciplina disciplina1 = new Disciplina("Circuitos Digitais", new Date(), "Sala 101", Lalunos, "Prof. Carlos Souza", notas1);
        Disciplina disciplina2 = new Disciplina("Software Basico", new Date(), "Sala 102", Lalunos, "Prof. Mario Souza", notas2);
        Disciplina disciplina3 = new Disciplina("Sistemas Operacionais", new Date(), "Sala 103", Lalunos, "Prof. Jose Souza", notas3);
        Disciplina disciplina4 = new Disciplina("Redes1", new Date(), "PA7", LalunosVazia, "Prof. Albini", notas4);
        Disciplina disciplina5 = new Disciplina("Programacao Paralela", new Date(), "Lab11", LalunosVazia, "Prof. Wagner Zola", notas5);

        Disciplinas disciplinasAlunosExemplo = new Disciplinas(new Disciplina[]{disciplina1, disciplina2, disciplina3});
        Ensalamento ensalamentoCompleto = new Ensalamento(new Disciplinas(new Disciplina[]{disciplina1, disciplina2, disciplina3, disciplina4, disciplina5}));

        //==== Aplicando Disciplinas

        aluno1.setMatriculas(disciplinasAlunosExemplo);
        aluno2.setMatriculas(disciplinasAlunosExemplo);

        //==== Criando Mapa

        String[] campus = {"Historico", "Politecnico", "Botanico", "Matinhos"};
        // uma pequena lista dos campus da UFPR
        String[][] prediosPolitecnico = {{}, {"PA", "DINF", "CT", "PC"}, {}, {}};
        // cada campus contem uma lista de predios(Apenas do politecnico esta preenchido)
        String[] mapas = {"", "politecnico.png", "", ""};
        // Caminho para os arquivos de imagem, apenas politecnico esta presente

        Mapa _map = new Mapa(campus, prediosPolitecnico, ensalamentoCompleto, mapas);

        //==== INICIANDO IO CASOS DE USOS

        
    }
}
