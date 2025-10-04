import java.util.Scanner;

public class Exemplo07 {
  public static final int QTD = 5;
  public static Scanner input = new Scanner(System.in);
  public static void main(String[] args) {
    int[] numeros1 = new int[QTD];
    int[] numeros2 = new int[QTD];
    int[] vetorSoma = new int[QTD];
    int opcao, tam2 = 0;
    boolean numeros1Preenchido = false;
    boolean numeros2Preenchido = false;
    boolean vetorSomaPreenchido = false;

    do {
      System.out.println("\n\nMENU");
      System.out.println("1 - Preencher o vetor 1");
      System.out.println("2 - Imprimir o vetor 1");
      System.out.println("3 - Inserir 1 número no vetor 2");
      System.out.println("4 - Imprimir o vetor 2");
      System.out.println("5 - Gerar o vetor soma");
      System.out.println("6 - Imprimir o vetor soma");
      System.out.println("Digite sua opção (0 p/ finalizar): ");
      opcao = input.nextInt();

      switch (opcao) {
        case 1:
          System.out.println("Preenchimento do 1º Vetor");
          preencherDigitacao(numeros1);
          numeros1Preenchido = true;
          break;
        case 2:
          if (numeros1Preenchido) {
            System.out.print("numeros1 = ");
            imprimir(numeros1, numeros1.length);
          } else {
            System.out.println("Preencha o vetor 1 primeiro");
          }
          break;
        case 3:
          tam2 = inserirVetorDigitacao(numeros2, tam2);
          break;
        case 4:
          System.out.print("numeros2 = ");
          imprimir(numeros2, tam2);
          break;
        case 5:
          somar(numeros1, numeros2, vetorSoma);
          break;
        case 6:
          System.out.print("vetorSoma = ");
          imprimir(vetorSoma, vetorSoma.length);
          break;
        default:
          if (opcao != 0) {
            System.out.println("Digitou uma opção inválida!\n");
          }
      }
    } while (opcao != 0);
  }

  public static void imprimir(int[] v, int tam) {
    System.out.print("{");
    if (tam > 0) {
      System.out.print(" " + v[0]);
    }
    for (int i = 1; i < tam; i += 1) {
      System.out.print(", " + v[i]);
    }
    System.out.println(" }");
  }

  public static void preencherDigitacao(int[] v) {
    for (int i = 0; i < v.length; i += 1) {
      System.out.print("Digite o " + (i + 1) + "º valor: ");
      v[i] = input.nextInt();
    }
  }

  public static int inserirVetorDigitacao(int[] v, int tam) {
    if (tam >= v.length) {
      System.out.println("Vetor cheio!");
      return tam;
    }

    System.out.print("Digite o " + (tam + 1) + "º valor: ");
    v[tam] = input.nextInt();

    return tam + 1;
  }

  public static void somar(int[] v1, int[] v2, int[] vs) {
    if (v1.length != v2.length || v1.length != vs.length) {
      System.out.println("Impossível realizar esta soma, todos os vetores devem ser do mesmo tamanho!");
      return;
    }
    for (int i = 0; i < v1.length; i += 1) {
      vs[i] = v1[i] + v2[i];
    }
  }
}