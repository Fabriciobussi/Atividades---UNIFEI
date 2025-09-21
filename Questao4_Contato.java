import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Questao4_Contato {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Agenda agenda = new Agenda("MinhaAgenda", "Agenda de testes");
        System.out.println("=== Sistema de Contatos (Questão 4) ===");

        while (true) {
            System.out.println("\n1) Criar contato (construtores disponíveis)");
            System.out.println("2) Duplicar contato (por índice)");
            System.out.println("3) Verificar se contato está completo (por índice)");
            System.out.println("4) Mostrar contatos da agenda");
            System.out.println("5) Sair");
            System.out.print("Opção: ");
            int op = lerInt();

            switch (op) {
                case 1:
                    criarContatoInterativo(agenda);
                    break;
                case 2:
                    duplicarContatoInterativo(agenda);
                    break;
                case 3:
                    verificarCompletoInterativo(agenda);
                    break;
                case 4:
                    agenda.mostrarContatos();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void criarContatoInterativo(Agenda agenda) {
        System.out.println("Escolha o construtor:");
        System.out.println("1) Contato(codigo)");
        System.out.println("2) Contato(codigo, nome)");
        System.out.println("3) Contato(codigo, nome, email)");
        System.out.println("4) Contato(telefone)");
        System.out.print("Opção: ");
        int op = lerInt();

        try {
            Contato c = null;
            switch (op) {
                case 1:
                    System.out.print("Código (1000-9999): ");
                    c = new Contato(lerInt());
                    break;
                case 2:
                    System.out.print("Código (1000-9999): ");
                    int cod2 = lerInt();
                    System.out.print("Nome: ");
                    String nome2 = sc.nextLine();
                    c = new Contato(cod2, nome2);
                    break;
                case 3:
                    System.out.print("Código (1000-9999): ");
                    int cod3 = lerInt();
                    System.out.print("Nome: ");
                    String nome3 = sc.nextLine();
                    System.out.print("E-mail: ");
                    String email3 = sc.nextLine();
                    c = new Contato(cod3, nome3, email3);
                    break;
                case 4:
                    System.out.print("Telefone (8 dígitos): ");
                    String tel4 = sc.nextLine();
                    c = new Contato(tel4);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    return;
            }

            System.out.print("Endereço (opcional): ");
            String end = sc.nextLine();
            if (!end.isBlank()) c.setEndereco(end);

            System.out.print("Observação (opcional): ");
            String obs = sc.nextLine();
            if (!obs.isBlank()) c.setObservacao(obs);

            agenda.adicionarContato(c);
            System.out.println("Contato criado e adicionado à agenda.");
        } catch (IllegalArgumentException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }

    private static void duplicarContatoInterativo(Agenda agenda) {
        System.out.print("Índice do contato a duplicar (0 = primeiro): ");
        int idx = lerInt();
        Contato original = agenda.getContato(idx);
        if (original == null) {
            System.out.println("Contato não encontrado.");
            return;
        }
        Contato copia = original.duplicar();
        agenda.adicionarContato(copia);
        System.out.println("Contato duplicado e adicionado ao final da agenda.");
    }

    private static void verificarCompletoInterativo(Agenda agenda) {
        System.out.print("Índice do contato a verificar (0 = primeiro): ");
        int idx = lerInt();
        Contato c = agenda.getContato(idx);
        if (c == null) {
            System.out.println("Contato não encontrado.");
            return;
        }
        System.out.println("Contato:");
        c.imprimirContato();
        System.out.println("Completo? " + (c.completo() ? "SIM" : "NÃO"));
    }

    private static int lerInt() {
        while (true) {
            try {
                String s = sc.nextLine().trim();
                return Integer.parseInt(s);
            } catch (Exception ex) {
                System.out.print("Número inválido. Digite novamente: ");
            }
        }
    }
}

class Contato {
    private int codigo = 0;
    private String nome = "";
    private String endereco = "";
    private String email = "";
    private String telefone = "";
    private String observacao = "";

    public Contato(int codigo) {
        setCodigo(codigo);
    }

    public Contato(int codigo, String nome) {
        setCodigo(codigo);
        setNome(nome);
    }

    public Contato(int codigo, String nome, String email) {
        setCodigo(codigo);
        setNome(nome);
        setEmailInterno(email);
    }

    public Contato(String telefone) {
        setTelefone(telefone);
    }

    public int getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public String getEndereco() { return endereco; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public String getObservacao() { return observacao; }

    public void setCodigo(int codigo) {
        if (codigo < 1000 || codigo > 9999) throw new IllegalArgumentException("Código inválido (1000-9999).");
        this.codigo = codigo;
    }

    public void setNome(String nome) { this.nome = nome == null ? "" : nome; }
    public void setEndereco(String endereco) { this.endereco = endereco == null ? "" : endereco; }
    private void setEmailInterno(String email) { this.email = email == null ? "" : email; }

    public void setTelefone(String telefone) {
        if (telefone == null) throw new IllegalArgumentException("Telefone inválido.");
        String digits = telefone.replaceAll("\\D", "");
        if (digits.length() != 8) throw new IllegalArgumentException("Telefone inválido: deve ter 8 dígitos.");
        this.telefone = digits;
    }

    public void setObservacao(String observacao) { this.observacao = observacao == null ? "" : observacao; }

    public void imprimirContato() {
        System.out.printf("Código: %d, Nome: %s, Endereço: %s, E-mail: %s, Telefone: %s, Observação: %s%n",
                codigo, nome, endereco, email, telefone, observacao);
    }

    public Contato duplicar() {
        Contato novo = new Contato(1000);
        novo.codigo = this.codigo;
        novo.nome = this.nome;
        novo.endereco = this.endereco;
        novo.email = this.email;
        novo.telefone = this.telefone;
        novo.observacao = this.observacao;
        return novo;
    }

    public boolean completo() {
        return (codigo >= 1000 && codigo <= 9999) &&
               !nome.isEmpty() &&
               !endereco.isEmpty() &&
               !email.isEmpty() &&
               telefone != null && telefone.length() == 8 &&
               !observacao.isEmpty();
    }
}

class Agenda {
    private String nome;
    private String descricao;
    private List<Contato> contatos = new ArrayList<>();

    public Agenda(String nome, String descricao) {
        this.nome = nome == null ? "" : nome;
        this.descricao = descricao == null ? "" : descricao;
    }

    public void adicionarContato(Contato c) {
        if (c != null) contatos.add(c);
    }

    public void mostrarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("Agenda vazia.");
            return;
        }
        for (int i = 0; i < contatos.size(); i++) {
            System.out.print("[" + i + "] ");
            contatos.get(i).imprimirContato();
        }
    }

    public Contato getContato(int index) {
        if (index < 0 || index >= contatos.size()) return null;
        return contatos.get(index);
    }
}

class Cliente {
    private Agenda agenda;
    public Cliente() {}
    public Cliente(Agenda a) { this.agenda = a; }
    public void setAgenda(Agenda a) { this.agenda = a; }
    public Agenda getAgenda() { return this.agenda; }
}
