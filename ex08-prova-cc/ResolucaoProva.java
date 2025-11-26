import java.util.Scanner;

public class ResolucaoProva {
    public static Scanner input = new Scanner(System.in);

    // ========================================================================
    // 1) BUSCA SEQUENCIAL POR DESCRIÇÃO
    // ========================================================================
    public static int buscaSequencialDesc(Produto[] v, int tam, String x) {
      for (int i = 0; i < tam; i++) {
        if (v[i].descricao.equalsIgnoreCase(x)) {
          return i;
        }
      }
      return -1;
    }

    // ========================================================================
    // 2) BUSCA BINÁRIA POR ID NA VENDA
    // ========================================================================
    public static int buscaBinariaId(Venda[] v, int tam, int x) {
      int inicio = 0, fim = tam - 1, meio;

      while (inicio <= fim) {
        meio = (inicio + fim) / 2;

        if (v[meio].id == x) {
          return meio;
        } else if (v[meio].id < x) {
          inicio = meio + 1;
        } else {
          fim = meio - 1;
        }
      }
      
      return -1;
    }

    // ========================================================================
    // 3) ALTERA PRODUTO
    // ========================================================================
    public static boolean alteraProduto(Produto[] v, int tam) {
      boolean alterou = false;
      System.out.print("Digite a descrição do produto para alterar: ");
      String descProcurada = input.nextLine();

      int pos = buscaSequencialDesc(v, tam, descProcurada);

      if (pos == -1) {
        System.out.println("Produto não encontrado.");
        return false;
      }

      // Alterar Descrição
      System.out.println("Deseja alterar a descrição (Atual: " + v[pos].descricao + ")? (S/N)");
      char resp = input.next().charAt(0);
      input.nextLine(); // Limpar buffer
      if (resp == 'S' || resp == 's') {
        System.out.print("Nova descrição: ");
        v[pos].descricao = input.nextLine();
        alterou = true;
      }

      // Alterar Estoque
      System.out.println("Deseja alterar o estoque (Atual: " + v[pos].qtdEstoque + ")? (S/N)");
      resp = input.next().charAt(0);
      if (resp == 'S' || resp == 's') {
        System.out.print("Novo estoque: ");
        v[pos].qtdEstoque = input.nextInt();
        alterou = true;
      }

      // Alterar Valor
      System.out.println("Deseja alterar o valor (Atual: " + v[pos].vlrUnit + ")? (S/N)");
      resp = input.next().charAt(0);
      if (resp == 'S' || resp == 's') {
        System.out.print("Novo valor: ");
        v[pos].vlrUnit = input.nextDouble();
        alterou = true;
      }
      input.nextLine(); // Limpar buffer final

      return alterou;
    }

    // ========================================================================
    // 4) REALIZAR VENDA
    // ========================================================================
    public static void venda(Produto[] vp, int tamProd, Venda[] vv, int tamVendas) {
      Venda novaVenda = new Venda();

      System.out.print("Digite o ID da Venda: ");
      novaVenda.id = input.nextInt();
      while (buscaBinariaId(vv, tamVendas, novaVenda.id) != -1) {
        System.out.println("ID repetido, favor digitar um ID único!");
        System.out.print("Digite o ID da Venda: ");
        novaVenda.id = input.nextInt();
      }

      // 2. Quantidade de produtos diferentes (1 a 5)
      do {
        System.out.print("Quantos produtos diferentes serão vendidos (1-5)? ");
        novaVenda.qtdProdutosVendidos = input.nextInt();
        input.nextLine(); // Limpar buffer
      } while (novaVenda.qtdProdutosVendidos < 1 || novaVenda.qtdProdutosVendidos > 5);

      // 3. Loop para cada produto
      for (int k = 0; k < novaVenda.qtdProdutosVendidos; k++) {
        boolean precisaDigitarNovamente = true;
        while (precisaDigitarNovamente) {
          precisaDigitarNovamente = false;

          System.out.println("--- Produto " + (k + 1) + " ---");
          System.out.print("Digite a descrição do produto: ");
          String desc = input.nextLine();
          int posProd = buscaSequencialDesc(vp, tamProd, desc);

          if (posProd == -1) {
            System.out.println("Produto não encontrado!");
            precisaDigitarNovamente = true;
            continue;
          }

          Produto prodEncontrado = vp[posProd];

          if (prodEncontrado.qtdEstoque <= 0) {
            System.out.println("Produto sem estoque!");
            precisaDigitarNovamente = true;
            continue;
          }

          int qtdVenda = 0;
          do {
            System.out.print("Quantidade (Disponível: " + prodEncontrado.qtdEstoque + "): ");
            qtdVenda = input.nextInt();
            input.nextLine(); // Buffer
          } while (qtdVenda < 1 || qtdVenda > prodEncontrado.qtdEstoque);

          // Atualiza Estoque
          prodEncontrado.qtdEstoque -= qtdVenda;

          // Salva na Venda
          novaVenda.idsProdutos[k] = prodEncontrado.id;
          novaVenda.qtdsVendidas[k] = qtdVenda;
        }
      }

      // Salvar a venda no vetor de vendas na posição correta
      vv[tamVendas] = novaVenda;
      System.out.println("Venda realizada com sucesso!");
    }

    // ========================================================================
    // 5) RELATÓRIO
    // ========================================================================
    public static void relatorio(Produto[] vp, int tamProd, Venda[] vv, int tamVendas) {
      for (int i = 0; i < tamVendas; i++) {
        Venda v = vv[i];

        // Filtro: Apenas vendas com mais de 2 produtos vendidos (itens diferentes)
        if (v.qtdProdutosVendidos > 2) {
          System.out.println("+-------------------------------------------+");
          System.out.printf("|               V E N D A  N.%03d            |\n", v.id);
          System.out.println("+-------------------------------------------+");
          System.out.println("+QTD| D E S C R I Ç Ã O  |VLR UNIT|VLR TOTAL|");
          System.out.println("+---+--------------------+--------+---------+");

          double totalGeral = 0;

          for (int k = 0; k < v.qtdProdutosVendidos; k++) {
            int idProd = v.idsProdutos[k];
            int qtdVendida = v.qtdsVendidas[k];

            int posProd = buscaSequencialId(vp, tamProd, idProd);

            if (posProd != -1) {
              double subTotal = vp[posProd].vlrUnit * qtdVendida;
              totalGeral += subTotal;

              // Formatação similar ao exemplo
              // %3d = inteiro 3 digitos, %-20s = string alinhada esq 20 chars, %.2f = float 2 casas
              System.out.printf("|%3d|%-20s|%8.2f|%9.2f|\n",
                  qtdVendida,
                  vp[posProd].descricao,
                  vp[posProd].vlrUnit,
                  subTotal);
            }
          }

          System.out.println("|   |                    |        |         |");

          System.out.println("+---+--------------------+--------+---------+");
          System.out.printf("|   |Total Geral         |        |%9.2f|\n", totalGeral);
          System.out.println("+---+--------------------+--------+---------+");
          System.out.println();
        }
      }
    }
    
    public static int buscaSequencialId(Produto[] v, int tam, int x) {
      for (int i = 0; i < tam; i++) {
        if (v[i].id == x) {
          return i;
        }
      }
      return -1;
    }


    // Main apenas para teste (opcional, mas necessário para rodar)
    public static void main(String[] args) {
        // Inicialização de dados para teste
        Produto[] produtos = new Produto[10];
        Venda[] vendas = new Venda[10];
        
        produtos[0] = new Produto(); produtos[0].id = 1; produtos[0].descricao = "Refrigerante 2L"; produtos[0].qtdEstoque = 100; produtos[0].vlrUnit = 8.79;
        produtos[1] = new Produto(); produtos[1].id = 2; produtos[1].descricao = "Salgado de Queijo"; produtos[1].qtdEstoque = 50; produtos[1].vlrUnit = 5.25;
        produtos[2] = new Produto(); produtos[2].id = 3; produtos[2].descricao = "Suco de Uva 1L"; produtos[2].qtdEstoque = 20; produtos[2].vlrUnit = 10.58;
        produtos[3] = new Produto(); produtos[3].id = 4; produtos[3].descricao = "Bolo"; produtos[3].qtdEstoque = 10; produtos[3].vlrUnit = 15.00;
        
        int tamProdutos = 4;
        int tamVendas = 0;

        // Testando Venda (Q4)
        venda(produtos, tamProdutos, vendas, tamVendas);
        tamVendas++; // Incrementa após a venda

        // Testando Relatório (Q5)
        System.out.println("\n--- RELATÓRIO ---");
        relatorio(produtos, tamProdutos, vendas, tamVendas);
    }
}