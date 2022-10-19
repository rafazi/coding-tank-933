import java.util.Scanner;

public class OrdemInversa {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quantas palavras serão informadas?");
        int qtdPalavras = sc.nextInt();
        sc.nextLine();
        String[] palavras = new String[qtdPalavras];
        for (int i = 0; i < qtdPalavras; i++) {
            System.out.printf("Informe a palavra %d:\n", (i + 1));
            palavras[i] = sc.nextLine();
        }

        System.out.print("Palavras informadas: ");
        for (int i = 0; i < qtdPalavras; i++) {
            if (i == qtdPalavras - 1) {
                System.out.printf("%s.", palavras[i]);
                continue;
            }
            System.out.printf("%s, ", palavras[i]);
        }

        System.out.printf("\nOrdem inversa: ");
        for (int i = qtdPalavras - 1; i >= 0; i--) {
            if (i == 0) {
                System.out.printf("%s.", palavras[i]);
                continue;

            }
            System.out.printf("%s, ", palavras[i]);
        }
    }
}
