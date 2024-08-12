import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import classes.Aluno;
import classes.Disciplina;
import classes.Disciplinas;
import classes.Ensalamento;
import classes.Mapa;
import classes.Pessoa;
import classes.Professor;
import classes.Siga;

//----------------------------------------------------



class IOHUD extends JFrame {
    public IOHUD(Disciplinas disciplinas, Mapa _map) {
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

                switch(n) {
                    case(0):
                        // pergunta qual caso de uso do professor quer
                        options = {"Lançar notas", "Enviar notificação"};
                        n = JOptionPane.showOptionDialog(null,
                            "Escolha uma opção:",
                            "",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options,
                            options[0]);
                    break;
                }
            }
        });

        professorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selecionada;
                Disciplina disciplina;
                String dados;

                // obtem as disciplinas do professor
                String[] lista = new String[disciplinas.getDisciplinas().size()];
                for (int i = 0; i < disciplinas.getDisciplinas().size(); i++) { 
                    lista[i] = disciplinas.getDisciplinas().get(i).getNome();
                }

                // pergunta qual caso de uso do professor quer
                Object[] options = {"Lançar notas", "Enviar notificação"};
                int n = JOptionPane.showOptionDialog(null,
                        "Escolha uma opção:",
                        "",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);

                //==== CASOS DE USO
                switch(n) {
                    case(0):
                    // pergunta qual materia lancar a nota
                    selecionada = (String) JOptionPane.showInputDialog(
                        null,
                        "Escolha a disciplina:",
                        "Selecionar Disciplina",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        lista,
                        lista[0]);

                    // se saiu sem selecionar saia do caso de uso
                    if (selecionada == null) {
                        break;
                    }
                    disciplina = disciplinas.getDisciplinaPorNome(selecionada);

                    // mencionando limitacao do caso de uso
                    int qtdNotas = disciplina.getAlunos().length;
                    float[] notasAdicionar = new float[qtdNotas];
                    JOptionPane.showMessageDialog(null, "Sem arquivo de nota, adicione nota por nota");

                    // por fim, inserir nota por nota
                    for(int i = 0; i < qtdNotas; i++) {
                        dados = JOptionPane.showInputDialog(
                            null,
                            "Nota [" + i + "]: ",
                            "Salvar",
                            JOptionPane.PLAIN_MESSAGE);
                        notasAdicionar[i] = Float.parseFloat(dados  );
                    }
                    disciplina.criarNota(notasAdicionar);

                    JOptionPane.showMessageDialog(null, qtdNotas + " Notas adicionadas na materia: " + selecionada);

                    for(int i = 0; i < disciplina.getNotas().size(); i++) {
                        for(int j = 0; j < qtdNotas; j++) {
                            System.out.print("   ["+j+"] > " + disciplina.getNotas().get(i)[j] );
                        }
                        System.out.println();
                    }

                    break;

                    //==== ==== ==== ====

                    case(1):
                        // pergunta qual materia deve enviar email
                        selecionada = (String) JOptionPane.showInputDialog(
                            null,
                            "Escolha a disciplina:",
                            "Selecionar Disciplina",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            lista,
                            lista[0]);

                        // se saiu sem selecionar saia do caso de uso
                        if (selecionada == null) {
                            break;
                        }
                        disciplina = disciplinas.getDisciplinaPorNome(selecionada);

                        // pergunta qual mensagem deseja enviar
                        dados = JOptionPane.showInputDialog(
                                null,
                                "Digite a mensagem a ser enviada:",
                                "Enviar Notificação",
                                JOptionPane.PLAIN_MESSAGE);
                        
                        // se saiu sem dar resposta saia do caso de uso
                        if (dados == null || dados.trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Nenhuma mensagem foi inserida.", "Erro", JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                        
                        // por fim, envia o email
                        disciplina.mandarNotificacao(dados, disciplina);
                        JOptionPane.showMessageDialog(null, "Notificação enviada para a disciplina: " + selecionada);
                        
                    break;
                }
            }
        });
    }
}



//----------------------------------------------------



public class Controlador {

    public Controlador() { }

    //---------------------------------------------------------------

    public static void main(String[] args) {

        //==== Criando Professores e Alunos
        Pessoa pes1 = new Pessoa("Andrey Ricardo Pimentel", "103.456.465-00", "PR-10.332.278", "andrey@exemplo.com");
        Pessoa pes2 = new Pessoa("João Silva", "123.456.789-00", "MG-12.345.678", "joao@exemplo.com");
        Pessoa pes3 = new Pessoa("Maria Oliveira", "987.654.321-00", "SP-87.654.321", "maria@exemplo.com");

        Professor prof1 = new Professor(pes1);
        Aluno aluno1 = new Aluno("GRR20201234", pes2, 8.5f, null);
        Aluno aluno2 = new Aluno("GRR20205678", pes3, 9.0f, null);

        Aluno[] Lalunos = {aluno1, aluno2};
        Aluno[] LalunosVazia = {};

        //==== Criando notas

        float[] notas1 = {7.5f, 8.0f};
        float[] notas2 = {8.5f, 9.6f};
        float[] notas3 = {7.1f, 8.5f};
        float[] notas4 = {};
        float[] notas5 = {};

        //==== Criando Disciplinas e Ensalamento

        Disciplina disciplina1 = new Disciplina("Circuitos Digitais", new Date(), "Sala 101", Lalunos, prof1, notas1);
        Disciplina disciplina2 = new Disciplina("Software Basico", new Date(), "Sala 102", Lalunos, prof1, notas2);
        Disciplina disciplina3 = new Disciplina("Sistemas Operacionais", new Date(), "Sala 103", Lalunos, prof1, notas3);
        Disciplina disciplina4 = new Disciplina("Redes1", new Date(), "PA7", LalunosVazia, prof1, notas4);
        Disciplina disciplina5 = new Disciplina("Programacao Paralela", new Date(), "Lab11", LalunosVazia, prof1, notas5);

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

        IOHUD useCaseHud = new IOHUD(disciplinasAlunosExemplo, _map);
        useCaseHud.setVisible(true);
    }
}
