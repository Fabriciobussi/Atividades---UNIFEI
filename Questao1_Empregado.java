import java.util.Scanner;

public class Questao1_Empregado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Empregado[] funcionarios = new Empregado[2];

        for (int i = 0; i < 2; i++) {
            System.out.println(" Empregado " + (i + 1) + " =====");
            System.out.print("Primeiro nome: ");
            String primeiro = sc.nextLine().trim();
            System.out.print("Sobrenome: ");
            String sobrenome = sc.nextLine().trim();
            System.out.print("Salário mensal (use '.' ou ','): ");
            double salario = lerDouble(sc);

            funcionarios[i] = new Empregado(primeiro, sobrenome, salario);
            System.out.println();
        }

        System.out.println("Salário anual antes do aumento:");
        for (Empregado e : funcionarios) {
            System.out.printf("%s: R$ %.2f%n", e.getNomeCompleto(), e.salarioAnual());
        }

        System.out.println("\nAplicando aumento de 10%...");
        for (Empregado e : funcionarios) {
            e.aumentarSalario(10);
        }

        System.out.println("Salário anual após aumento:");
        for (Empregado e : funcionarios) {
            System.out.printf("%s: R$ %.2f%n", e.getNomeCompleto(), e.salarioAnual());
        }

        sc.close();
    }

    private static double lerDouble(Scanner sc) {
        while (true) {
            try {
                String s = sc.nextLine().trim().replace(',', '.');
                return Double.parseDouble(s);
            } catch (Exception ex) {
                System.out.print("Valor inválido. Digite novamente: ");
            }
        }
    }
}

class Empregado {
    private String primeiroNome;
    private String sobrenome;
    private double salarioMensal;

    public Empregado(String primeiroNome, String sobrenome, double salarioMensal) {
        this.primeiroNome = primeiroNome == null ? "" : primeiroNome;
        this.sobrenome = sobrenome == null ? "" : sobrenome;
        this.salarioMensal = salarioMensal > 0 ? salarioMensal : 0.0;
    }

    public String getNomeCompleto() {
        return primeiroNome + " " + sobrenome;
    }

    public double salarioAnual() {
        return salarioMensal * 12;
    }

    public void aumentarSalario(double percentual) {
        if (percentual > 0) {
            salarioMensal += salarioMensal * percentual / 100.0;
        }
    }
}

