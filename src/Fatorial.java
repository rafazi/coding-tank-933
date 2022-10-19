import java.util.Scanner;

public class Fatorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe um número: " );
        int n = sc.nextInt();
        int fatorial = fatorialRecursivo(n);
        System.out.printf("%d!= %d", n, fatorial);
    }

    private static int fatorial(int n) {
        int fat = 1;
        for (int i = n; i > 0; i--) {
            fat *= i;
//            fat = fat * i;
        }
        return fat;
    }

    private static int fatorialWhile(int n) {
        int fat = 1;
        while(n > 1) {
            fat *= n;
            n--;
        }
        return fat;
    }

    private static int fatorialRecursivo(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * fatorialRecursivo(n - 1);
    }
}
