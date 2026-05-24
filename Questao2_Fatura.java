import java.util.Scanner;

public class Questao2_Fatura {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Número do item: ");
        String numero = sc.nextLine().trim();

        System.out.print("Descrição do item: ");
        String descricao = sc.nextLine().trim();

        System.out.print("Quantidade: ");
        int quantidade = lerInt(sc);

        System.out.print("Preço unitário (use '.' ou ','): ");
        double precoUnitario = lerDouble(sc);

        Fatura f = new Fatura(numero, descricao, quantidade, precoUnitario);

        System.out.printf("Valor da fatura (sem desconto): R$ %.2f%n", f.getValorFatura());

        System.out.print("Deseja aplicar desconto? (s/n): ");
        String resp = sc.nextLine().trim().toLowerCase();
        if (resp.startsWith("s")) {
            System.out.print("Percentual de desconto (ex: 10): ");
            double pct = lerDouble(sc);
            f.aplicarDesconto(pct);
            System.out.printf("Valor da fatura (após %.2f%% desconto): R$ %.2f%n", pct, f.getValorFatura());
        }

        sc.close();
    }

    private static int lerInt(Scanner sc) {
        while (true) {
            try {
                String s = sc.nextLine().trim();
                return Integer.parseInt(s);
            } catch (Exception ex) {
                System.out.print("Valor inteiro inválido. Digite novamente: ");
            }
        }
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

class Fatura {
    private String numeroItem;
    private String descricao;
    private int quantidade;
    private double precoUnitario;

    public Fatura(String numeroItem, String descricao, int quantidade, double precoUnitario) {
        this.numeroItem = numeroItem == null ? "" : numeroItem;
        this.descricao = descricao == null ? "" : descricao;
        this.quantidade = Math.max(quantidade, 0);
        this.precoUnitario = precoUnitario > 0 ? precoUnitario : 0.0;
    }

    public double getValorFatura() {
        return quantidade * precoUnitario;
    }

    public void aplicarDesconto(double percentual) {
        if (percentual <= 0) return;
        double fator = 1.0 - percentual / 100.0;
        if (fator < 0) fator = 0;
        precoUnitario = precoUnitario * fator;
    }
}
