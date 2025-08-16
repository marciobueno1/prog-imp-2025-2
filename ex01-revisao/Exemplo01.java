public class Exemplo01 {
  public static final int QTD_REPETICOES = 5;

  public static void main(String[] args) {
    System.out.println("Impressão em Ordem Crescente");
    for (int i = 1; i <= QTD_REPETICOES; i += 1) {
      System.out.printf("%2d. Olá, Turma!\n", i);
    }

    System.out.println("\nImpressão em Ordem Decrescente");
    for (int i = QTD_REPETICOES; i >= 1; i -= 1) {
      System.out.printf("%2d. Olá, Turma!\n", i);
    }

    System.out.println("\nImpressão em Ordem Derescente, apesar do 'i' do FOR ser crescente");
    for (int i = 1; i <= QTD_REPETICOES; i += 1) {
      System.out.printf("%2d. Olá, Turma!\n", QTD_REPETICOES - i + 1);
    }
  }
}