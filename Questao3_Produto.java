import java.util.Scanner;

public class Questao3_Produto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("=== Novo Produto ===");
            System.out.print("Nome: ");
            String nome = sc.nextLine().trim();

            System.out.print("Preço unitário (use '.' ou ','): ");
            double preco = lerDouble(sc);

            System.out.print("Quantidade: ");
            int qtd = lerInt(sc);

            Produto p = new Produto(nome, preco, qtd);
            double total = p.comprarProduto(); 
            System.out.printf("Produto comprado: %s%nTotal a pagar: R$ %.2f%n", nome, total);

            System.out.print("Deseja cadastrar outro produto? (s/n): ");
            String resp = sc.nextLine().trim().toLowerCase();
            if (!resp.startsWith("s")) break;
        }

        sc.close();
    }

    private static int lerInt(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (Exception ex) {
                System.out.print("Valor inteiro inválido. Digite novamente: ");
            }
        }
    }

    private static double lerDouble(Scanner sc) {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine().trim().replace(',', '.'));
            } catch (Exception ex) {
                System.out.print("Valor inválido. Digite novamente: ");
            }
        }
    }
}

class Produto {
    private String nome;
    private double preco;
    private int quantidade;
    private boolean comprado = false;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome == null ? "" : nome;
        this.preco = preco > 0 ? preco : 0.0;
        this.quantidade = Math.max(quantidade, 0);
    }

    /**
     * tabela de descontos:
     * até 100 > 0%
     * 100 - 200 > 10%
     * 200 - 500 > 20%
     * >500 > 25%
     */

    public double comprarProduto() {
        comprado = true;
        double desconto = 0.0;
        if (preco > 500) desconto = 0.25;
        else if (preco > 200) desconto = 0.20;
        else if (preco > 100) desconto = 0.10;
        double total = preco * quantidade * (1.0 - desconto);
        return total;
    }
}
