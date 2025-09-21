import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Questao5_Ingresso {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Evento evento = new Evento();
        System.out.println("=== Sistema de Ingressos (Questão 5) ===");

        while (true) {
            System.out.println("\n1) Adicionar ingresso normal");
            System.out.println("2) Adicionar ingresso VIP");
            System.out.println("3) Vender ingresso (por índice)");
            System.out.println("4) Valor total vendido");
            System.out.println("5) Mostrar ingressos disponíveis");
            System.out.println("6) Sair");
            System.out.print("Opção: ");
            int op = lerInt();

            switch (op) {
                case 1:
                    System.out.print("Preço do ingresso normal (use '.' ou ','): ");
                    double preco = lerDouble();
                    evento.adicionarIngresso(new Ingresso(preco));
                    System.out.println("Ingresso normal adicionado.");
                    break;
                case 2:
                    System.out.print("Preço base do ingresso VIP (use '.' ou ','): ");
                    double base = lerDouble();
                    System.out.print("Valor adicional VIP (use '.' ou ','): ");
                    double adicional = lerDouble();
                    evento.adicionarIngresso(new IngressoVIP(base, adicional));
                    System.out.println("Ingresso VIP adicionado.");
                    break;
                case 3:
                    evento.mostrarIngressosDisponiveis();
                    System.out.print("Índice do ingresso a vender (0 = primeiro): ");
                    int idx = lerInt();
                    boolean ok = evento.venderIngressoPorIndice(idx);
                    System.out.println(ok ? "Venda realizada." : "Índice inválido ou já vendido.");
                    break;
                case 4:
                    System.out.printf("Valor total vendido: R$ %.2f%n", evento.valorTotalVendas());
                    break;
                case 5:
                    evento.mostrarIngressosDisponiveis();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static int lerInt() {
        while (true) {
            try { return Integer.parseInt(sc.nextLine().trim()); }
            catch (Exception ex) { System.out.print("Número inválido. Digite novamente: "); }
        }
    }

    private static double lerDouble() {
        while (true) {
            try { return Double.parseDouble(sc.nextLine().trim().replace(',', '.')); }
            catch (Exception ex) { System.out.print("Valor inválido. Digite novamente: "); }
        }
    }
}

class Ingresso {
    protected double valor;

    public Ingresso(double valor) { this.valor = valor > 0 ? valor : 0.0; }
    public double getValor() { return valor; }

    @Override
    public String toString() { return String.format("Ingresso: R$ %.2f", getValor()); }
}

class IngressoVIP extends Ingresso {
    private double valorAdicional;

    public IngressoVIP(double valor, double adicional) {
        super(valor);
        this.valorAdicional = adicional > 0 ? adicional : 0.0;
    }

    @Override
    public double getValor() {
        return super.getValor() + valorAdicional;
    }

    @Override
    public String toString() {
        return String.format("Ingresso VIP: R$ %.2f (base R$ %.2f + adicional R$ %.2f)",
                getValor(), super.getValor(), valorAdicional);
    }
}

class Evento {
    private List<Ingresso> ingressos = new ArrayList<>();
    private List<Ingresso> vendidos = new ArrayList<>();

    public void adicionarIngresso(Ingresso i) { ingressos.add(i); }

    public boolean venderIngressoPorIndice(int idx) {
        if (idx < 0 || idx >= ingressos.size()) return false;
        Ingresso i = ingressos.get(idx);
        if (vendidos.contains(i)) return false;
        vendidos.add(i);
        return true;
    }

    public double valorTotalVendas() {
        double total = 0.0;
        for (Ingresso i : vendidos) total += i.getValor();
        return total;
    }

    public void mostrarIngressosDisponiveis() {
        System.out.println("Ingressos disponíveis:");
        boolean any = false;
        for (int i = 0; i < ingressos.size(); i++) {
            Ingresso ing = ingressos.get(i);
            if (!vendidos.contains(ing)) {
                System.out.printf("[%d] %s%n", i, ing.toString());
                any = true;
            }
        }
        if (!any) System.out.println("Nenhum ingresso disponível.");
    }
}