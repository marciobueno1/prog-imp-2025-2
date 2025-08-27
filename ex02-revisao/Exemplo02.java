import java.util.Scanner;

public class Exemplo02 {
  public static Scanner input = new Scanner(System.in);
  public static void main(String[] args) {
    System.out.println("==================================");
    impressao(20, 1);
    System.out.println("==================================");
    impressao(1, 50);
    System.out.println("==================================");
    impressao(90, 100);
    System.out.println("==================================");
    System.out.print("Digite o mínimo do intervalo: ");
    int min, max;
    min = input.nextInt();
    do {
      System.out.print("Digite o máximo do intervalo: ");
      max = input.nextInt();
      if (max < min) {
        System.out.println("Digitação inválida! Máximo deve ser maior ou igual a " + min);
      }
  } while (max < min);
    impressao(min, max);
    System.out.println("==================================");
    System.out.print("Digite o preço antigo: ");
    int precoAntigo = input.nextInt();
    System.out.print("Digite o preço novo: ");
    int precoNovo = input.nextInt();
    double aumento = calcularAumentoPrecoPercentual(precoAntigo, precoNovo);
    System.out.printf("O aumento foi de %f%%\n", aumento);
  }

  public static void impressao(int min, int max) {
    if (min > max) {
      int aux = min;
      min = max;
      max = aux;
    }
    System.out.printf("TODOS OS NÚMEROS ENTRE %d E %d\n", min, max);
    for (int i = min; i <= max; i += 1) {
      System.out.print(i);
      if (i != max) {
        System.out.print(", ");
      }
    }
    System.out.println();
  }

  // public static double calcularAumentoPrecoPercentual(
  //     double precoAntigo, double novoPreco
  // ) {
  //   if (precoAntigo == 0) {
  //     return 0.0;
  //   }
  //   return 100.0 * (novoPreco - precoAntigo) / precoAntigo;
  // }

    public static double calcularAumentoPrecoPercentual(
      int precoAntigo, int novoPreco
    ) {
      if (precoAntigo == 0) {
        return 0;
      }
      return 100.0 * (novoPreco - precoAntigo) / precoAntigo;
  }
}
