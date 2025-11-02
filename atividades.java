import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

//01
public class atividade_1 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            numeros.add(rand.nextInt(100));
        }

        System.out.println("Elementos do ArrayList: " + numeros);

        numeros.remove(2);
        System.out.println("Após remover o terceiro elemento: " + numeros);

        numeros.add(0, 999);
        System.out.println("Após adicionar no início: " + numeros);

        if (numeros.contains(15)) {
            System.out.println("O número 15 está presente.");
        } else {
            System.out.println("O número 15 NÃO está presente.");
        }
    }
}

//02
public class atividades_2 {
    public static void main(String[] args) {
        ArrayList<Double> numeros = new ArrayList<>();
        numeros.add(5.4);
        numeros.add(2.8);
        numeros.add(9.1);
        numeros.add(1.3);
        numeros.add(6.6);
        numeros.add(3.5);
        numeros.add(7.7);
        numeros.add(4.9);
        numeros.add(8.0);
        numeros.add(0.2);

        System.out.println("Original: " + numeros);

        Collections.sort(numeros);
        System.out.println("Ordem crescente: " + numeros);

        Collections.sort(numeros, Collections.reverseOrder());
        System.out.println("Ordem decrescente: " + numeros);
    }
}

//03
public class atividade_3 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();

        for (int i = 1; i <= 15; i++) {
            numeros.add(i);
        }

        System.out.println("Original: " + numeros);

        numeros.removeIf(n -> n % 2 == 0);

        System.out.println("Apenas ímpares: " + numeros);
    }
}

//04
class Produto {
    String nome;
    double preco;

    Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return nome + " - R$" + preco;
    }
}

public class atividade_4 {
    public static void main(String[] args) {
        ArrayList<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto("Mouse", 80.0));
        produtos.add(new Produto("Teclado", 120.0));
        produtos.add(new Produto("Monitor", 900.0));
        produtos.add(new Produto("Cadeira", 650.0));
        produtos.add(new Produto("Headset", 250.0));

        if (produtos.isEmpty()) {
            throw new RuntimeException("Lista de produtos está vazia!");
        }

        Produto maisCaro = produtos.get(0);
        for (Produto p : produtos) {
            if (p.preco > maisCaro.preco) {
                maisCaro = p;
            }
        }

        System.out.println("Produto mais caro: " + maisCaro);
    }
}

//05
public class atividade_5 {
    public static void main(String[] args) {
        ArrayList<String> numerosStr = new ArrayList<>();
        numerosStr.add("10");
        numerosStr.add("20");
        numerosStr.add("abc");
        numerosStr.add("30");

        ArrayList<Integer> numerosInt = new ArrayList<>();

        for (String s : numerosStr) {
            try {
                int valor = Integer.parseInt(s);
                numerosInt.add(valor);
            } catch (NumberFormatException e) {
                System.out.println("Erro ao converter: " + s);
            }
        }

        System.out.println("Conversões bem-sucedidas: " + numerosInt);
    }
}

//06
class NoMatchingElementsException extends Exception {
    public NoMatchingElementsException(String mensagem) {
        super(mensagem);
    }
}

public class atividade_6 {
    public static void main(String[] args) {
        ArrayList<String> palavras = new ArrayList<>();
        palavras.add("casa");
        palavras.add("sol");
        palavras.add("amigo");
        palavras.add("lua");
        palavras.add("estrela");
        palavras.add("mar");
        palavras.add("vento");
        palavras.add("rio");
        palavras.add("sol");
        palavras.add("céu");

        try {
            ArrayList<String> filtradas = filtrarPorTamanho(palavras, 4);
            if (filtradas.isEmpty()) {
                throw new NoMatchingElementsException("Nenhuma palavra com 4 letras encontrada.");
            }
            System.out.println("Palavras com 4 letras: " + filtradas);
        } catch (NoMatchingElementsException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<String> filtrarPorTamanho(ArrayList<String> lista, int tamanho) {
        ArrayList<String> resultado = new ArrayList<>();
        for (String palavra : lista) {
            if (palavra.length() == tamanho) {
                resultado.add(palavra);
            }
        }
        return resultado;
    }
}

//07
public class atividade_7 {
    private int andarAtual;
    private int totalAndares;
    private int capacidade;
    private int pessoasPresentes;
    private ArrayList<String> registroMovimentos;

    public atividade_07(int capacidade, int totalAndares) {
        this.capacidade = capacidade;
        this.totalAndares = totalAndares;
        this.andarAtual = 0;
        this.pessoasPresentes = 0;
        this.registroMovimentos = new ArrayList<>();
        registroMovimentos.add("Elevador iniciado no térreo (andar 0).");
    }

    public void entra() {
        if (pessoasPresentes < capacidade) {
            pessoasPresentes++;
            registroMovimentos.add("Entrou 1 pessoa no andar " + andarAtual + " (Total: " + pessoasPresentes + ")");
        } else {
            System.out.println("Elevador cheio! Capacidade máxima atingida.");
        }
    }

    public void sai() {
        if (pessoasPresentes > 0) {
            pessoasPresentes--;
            registroMovimentos.add("Saiu 1 pessoa no andar " + andarAtual + " (Restam: " + pessoasPresentes + ")");
        } else {
            System.out.println("Elevador vazio! Ninguém para sair.");
        }
    }

    public void sobe() {
        if (andarAtual < totalAndares) {
            andarAtual++;
            registroMovimentos.add("Subiu para o andar " + andarAtual);
        } else {
            System.out.println("Já está no último andar!");
        }
    }

    public void desce() {
        if (andarAtual > 0) {
            andarAtual--;
            registroMovimentos.add("Desceu para o andar " + andarAtual);
        } else {
            System.out.println("Já está no térreo!");
        }
    }

    public int getAndarAtual() {
        return andarAtual;
    }

    public int getTotalAndares() {
        return totalAndares;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getPessoasPresentes() {
        return pessoasPresentes;
    }

    public ArrayList<String> getRegistroMovimentos() {
        return registroMovimentos;
    }

    public void exibirRegistro() {
        System.out.println("\n📋 Histórico de movimentos do elevador:");
        for (String evento : registroMovimentos) {
            System.out.println(" - " + evento);
        }
    }
}
public class atividade_7 {
    public static void main(String[] args) {
        Elevador elevador = new Elevador(5, 10);

        elevador.entra();
        elevador.entra();
        elevador.sobe();
        elevador.sobe();
        elevador.sai();
        elevador.sobe();
        elevador.desce();
        elevador.entra();
        elevador.sobe();
        elevador.sobe();
        elevador.sobe();
        elevador.sai();
        elevador.desce();
        elevador.desce();

        System.out.println("\nAndar atual: " + elevador.getAndarAtual());
        System.out.println("Pessoas no elevador: " + elevador.getPessoasPresentes());
        System.out.println("Capacidade máxima: " + elevador.getCapacidade());
        System.out.println("Total de andares do prédio: " + elevador.getTotalAndares());

        elevador.exibirRegistro();
    }
}