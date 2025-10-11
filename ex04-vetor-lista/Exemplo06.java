// Exercício 01 da lista https://www.facom.ufu.br/~backes/gsi002/ListaC04.pdf

public class Exemplo06 {
  public static void main(String[] args) {
    // int[] A = { 1, 0, 5, -2, -5, 7 };
    int[] A = new int[6];
    A[0] = 1;
    A[1] = 0;
    A[2] = 5;
    A[3] = -2;
    A[4] = -5;
    A[5] = 7;
    int soma = A[0] + A[1] + A[5];
    System.out.println("A soma dos três valores é " + soma);
    A[4] = 100;
    System.out.println("Impressão do vetor 1 em cada linha");
    for (int i = 0; i < A.length; i += 1) {
      System.out.println(A[i]);
    }
  }
}