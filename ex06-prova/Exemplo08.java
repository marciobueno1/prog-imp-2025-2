import java.util.Scanner;

public class Exemplo08 {
  public static final int QTD = 5;
  public static Scanner input = new Scanner(System.in);
  public static void main(String[] args) {
    int[] a = new int[] { 5, 4, 3, 2, 1 };
    int[] b = new int[] { 5, 7, 4, 6, 8 };
    int[] uniao = new int[2 * QTD];
    int[] vcr = new int[] { 1, 2, 2, 3, 4, 4, 5, 1, 2, 3, 4, 5 };
    int[] vsr = new int[3 * QTD];

    // System.out.println("Digite os valores do conjunto A");
    // preencherDigitacao(a);
    // System.out.println("Digite os valores do conjunto B");
    // preencherDigitacao(b);
    System.out.print("Conjunto A: ");
    imprimir(a, QTD);
    System.out.print("Conjunto B: ");
    imprimir(b, QTD);
    System.out.println("\n\nORDENAR\n");
    insertionSort(a, QTD);
    insertionSort(b, QTD);
    System.out.print("Conjunto A: ");
    imprimir(a, QTD);
    System.out.print("Conjunto B: ");
    imprimir(b, QTD);
    int tamUniao = uniao(a, QTD, b, QTD, uniao);
    System.out.print("Conjunto União: ");
    imprimir(uniao, tamUniao);
    int tamVSR = gerarVetorSemRepeticao(vcr, vcr.length, vsr);
    System.out.print("Vetor com repetição: ");
    imprimir(vcr, vcr.length);
    System.out.print("Vetor sem repetição: ");
    imprimir(vsr, tamVSR);
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

  public static int buscaSequencial(int[] v, int tam, int x) {
    for (int i = 0; i < tam; i += 1) {
      if (v[i] == x) {
        return i;
      }
    }
    return -1;
  }

  public static int uniao(int[] a, int tamA, int[] b, int tamB, int[] u) {
    int tamUniao = 0;

    for (int i = 0; i < tamA; i += 1) {
      u[i] = a[i];
    }
    tamUniao = tamA;

    for (int i = 0; i < tamB; i += 1) {
      if (buscaSequencial(a, tamA, b[i]) == -1) {
        u[tamUniao] = b[i];
        tamUniao += 1;
      }
    }

    return tamUniao;
  }

  public static void insertionSort(int[] v, int tam) {
    for (int i = 1; i < tam; i += 1) {
      int chave = v[i];
      int j = i - 1;
      while (j >= 0 && v[j] > chave) {
        v[j + 1] = v[j];
        j -= 1;
      }
      v[j + 1] = chave;
    }
  }

  public static int gerarVetorSemRepeticao(int[] v, int tamV, int[] vsr) {
    int tamSR = 0;
    for (int i = 0; i < tamV; i += 1) {
      if (buscaSequencial(vsr, tamSR, v[i]) == -1) {
        vsr[tamSR] = v[i];
        tamSR += 1;
      }
    }
    return tamSR;
  }

  public static void rotacionarEsquerda(int[] v, int tam) {
    int tmp = v[0];
    for (int i = 1; i < tam; i += 1) {
      v[i - 1] = v[i];
    }
    v[tam - 1] = tmp;
  }

  public static void rotacionar(int[] v, int tam, int k) {
    int qtd = k;
    if (k < 0) {
      qtd = tam + k;
    }
    for (int i = 1; i <= qtd; i += 1) {
      rotacionarEsquerda(v, tam);
    }
  }
}