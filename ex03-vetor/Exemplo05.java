import java.util.Scanner;

public class Exemplo05 {
  public static final int QTD = 5;
  public static Scanner input = new Scanner(System.in);
  public static void main(String[] args) {
    int[] numeros1 = new int[QTD];
    int[] numeros2 = new int[QTD];
    int[] vetorSoma = new int[QTD];
    System.out.println("Preenchimento do 1º Vetor");
    preencherDigitacao(numeros1);
    System.out.println("\nPreenchimento do 2º Vetor");
    preencherDigitacao(numeros2);
    somar(numeros1, numeros2, vetorSoma);
    System.out.print("numeros1 = ");
    imprimir(numeros1);
    System.out.print("numeros2 = ");
    imprimir(numeros2);
    System.out.print("vetorSoma = ");
    imprimir(vetorSoma);
  }

  public static void imprimir(int[] v) {
    System.out.print("{");
    if (v.length > 0) {
      System.out.print(" " + v[0]);
    }
    for (int i = 1; i < v.length; i += 1) {
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