import java.util.Scanner;

public class ListarNumeros {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o valor inicial:");
        int valorInicial = sc.nextInt();
        System.out.println("Informe o valor final:");
        int valorFinal = sc.nextInt();
        valorFinal++; // valorFinal = valorFinal + 1; valorFinal += 1;
        valorFinal--; // valorFinal = valorFinal - 1; valorFinal -= 1;

        for (int i = valorInicial; i <= valorFinal; i += 2){
            System.out.println(i);
        }

    }
}
