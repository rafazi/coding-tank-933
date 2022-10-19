import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Advinha {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int randomNum = ThreadLocalRandom.current().nextInt(0, 100 + 1);
//        int rand = new Random().nextInt(101);
//        int chute = -1;
        int chute = -1;
        int quantidadeDeTentativas = 0;
        int menorChute = Integer.MAX_VALUE;
        int maiorChute = Integer.MIN_VALUE;
        while(randomNum != chute) {
            quantidadeDeTentativas++;
            System.out.println("Informe um numero");
            chute = leia.nextInt();
            leia.nextLine();

            if(chute > randomNum) {
                System.out.printf("%d é maior.\n", chute);
            } else if (chute < randomNum) {
                System.out.printf("%d é menor.\n", chute);
            }

            if (chute > maiorChute) {
                maiorChute = chute;
            }

            if (chute < menorChute) {
                menorChute = chute;
            }
        }

        System.out.printf("%d está correto.%n", chute);
        System.out.printf("Foram informados %d números, ", quantidadeDeTentativas);
        System.out.printf("o menor foi %d e o maior foi %d.", menorChute, maiorChute);
    }
}
