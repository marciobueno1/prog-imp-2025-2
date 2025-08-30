import java.util.Scanner;

public class Exemplo03 {
  public static final int QTD = 4;
  public static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    int[] numeros = new int[QTD];
    int soma = 0;
    double media;
    for (int i = 0; i < numeros.length; i += 1) {
      System.out.printf("Digite o %dº número: ", i + 1);
      numeros[i] = input.nextInt();
      soma += numeros[i];
    }
    media = (double) soma / numeros.length;
    System.out.printf("A média destes %d números é %f\n",
        numeros.length, media);
    System.out.println("Impressão de números maiores que a média");
    for (int i = 0; i < numeros.length; i += 1) {
      if (numeros[i] > media) {
        System.out.printf("v[%d] = %d\n", i + 1, numeros[i]);
      }
    }
  }
}
