import javax.swing.JOptionPane;

public class Modulo2 {
    public static void main(String[] args) {

        //Pede o nome
        String nome = JOptionPane.showInputDialog("Qual é o seu nome?");

        //Mstra o nome
        JOptionPane.showMessageDialog(null, "Olá " + nome + ", seja bem vindo ao módulo de interfaces gráficas no Java!");

        //Prgunta se gosta de programar
        String[] opcoes1 = {"Sim", "Não"};
        int resposta1 = JOptionPane.showOptionDialog(null, nome + "! Você gosta de programar?",
                "Selecionar uma Opção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, opcoes1, opcoes1[0]);

        if (resposta1 == 0) {
            JOptionPane.showMessageDialog(null, "Então estude bem o Java Swing. Ele pode abrir várias portas para você");
        } else {
            JOptionPane.showMessageDialog(null, "Que pena. Mas com as janelas você vai gostar");
        }

        //Pergunta sobre objetos
        String[] opcoes2 = {"Sim - Objeto é legal", "Não - Objeto é sofrimento", "Talvez - Quero aprender"};
        int resposta2 = JOptionPane.showOptionDialog(null, "Lembrete, aqui no Java Swing tudo é objeto. Você gosta disto?",
                "Atenção", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
                null, opcoes2, opcoes2[0]);

        if (resposta2 == 0) {
            JOptionPane.showMessageDialog(null, "Ótimo, todos os componentes são objetos");
        } else if (resposta2 == 1) {
            JOptionPane.showMessageDialog(null, "Não se preocupe. Agora você irá aprender a importâncias dos objetos");
        } else {
            JOptionPane.showMessageDialog(null, "Sim você aprenderá");
        }
    }
}