import java.util.Scanner;

public class NumeroPositivoComReturn {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Digite um número: ");

        int number = reader.nextInt();

        if (number == 0) {
            System.out.println("O número é zero.");
            return;
        }
        String type = number > 0 ? "positivo" : "negativo";
        System.out.println("O número " + number + " é: " + type);
    }
}
