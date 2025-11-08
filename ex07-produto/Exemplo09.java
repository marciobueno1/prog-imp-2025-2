import java.util.Scanner;

public class Exemplo09 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Produto produto1 = new Produto();
        Produto produto2 = new Produto();

        System.out.println("### Cadastro de Produtos ###");

        System.out.println("\n-> Insira os dados do produto 1:");
        preencher(produto1);

        System.out.println("\n-> Insira os dados do produto 2:");
        preencher(produto2);

        System.out.println("\n=================================");
        System.out.println("  Imprimindo Dados dos Produtos  ");
        System.out.println("=================================");

        imprimir(produto1);
        imprimir(produto2);
        
        input.close();
    }

    public static void preencher(Produto produto) {
        System.out.println("Digite o título do produto: ");
        produto.titulo = input.nextLine();

        System.out.println("Digite a descrição: ");
        produto.descricao = input.nextLine();

        System.out.println("Digite o preço unitário: ");
        produto.precoUnitario = input.nextDouble();

        System.out.println("Digite a quantidade em estoque: ");
        produto.qtdEstoque = input.nextInt();
        
        input.nextLine(); // para remover o ENTER da digitação do int referente a qtdEstoque
    }

    public static void imprimir(Produto produto) {
        System.out.println("\n--- Detalhes do Produto ---");
        System.out.println("Título: " + produto.titulo);
        System.out.println("Descrição: " + produto.descricao);
        System.out.printf("Preço Unitário: R$ %.2f\n", produto.precoUnitario);
        System.out.println("Quantidade em Estoque: " + produto.qtdEstoque);
    }
}