import java.util.Scanner;

public class NumeroPositivo {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Digite um número: ");

        int number = reader.nextInt();

        if(number == 0) {
            System.out.print("O número é zero.");
        } else if (number > 0) {
            System.out.println("O numero é " + number + "positivo");
        } else {
            System.out.println("O numero é " + number + "negativo");
//            String type = number > 0 ? "positivo" : "negativo";
//            System.out.print("O número " + number + " é: " + type);
        }
    }
}
