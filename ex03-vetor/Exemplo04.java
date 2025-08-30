import java.util.Scanner;

public class Exemplo04 {
  public static final int QTD = 4;
  public static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    int[] numeros = new int[QTD];
    double media;
    preencherVetorDigitacao(numeros);
    media = calcularMediaVetor(numeros);

    System.out.printf("A média destes %d números é %f\n",
        numeros.length, media);
    System.out.println("Impressão de números maiores que a média");
    for (int i = 0; i < numeros.length; i += 1) {
      if (numeros[i] > media) {
        System.out.printf("v[%d] = %d\n", i + 1, numeros[i]);
      }
    }
  }

  public static void preencherVetorDigitacao(int[] v) {
    for (int i = 0; i < v.length; i += 1) {
      System.out.printf("Digite o %dº número: ", i + 1);
      v[i] = input.nextInt();
    }
  }

  public static double calcularMediaVetor(int[] v) {
    int soma = 0;
    for (int i = 0; i < v.length; i += 1) {
      soma += v[i];
    }
    return (double) soma / v.length;
  }
}
