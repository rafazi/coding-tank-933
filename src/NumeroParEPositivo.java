import java.util.Scanner;

public class NumeroParEPositivo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ehPos = "O número %s é positivo";
        String ehNeg = "O número %s é negativo";
        String ehZero = "O número é zero e par;";
        String ehPar = " e par;";
        String ehImpar = " e ímpar;";
        System.out.printf("Informe um número: \n");
//        Integer numero = Integer.parseInt(sc.nextLine());
        int numero = sc.nextInt();
        boolean ePositivo = numero > 0;
        boolean eNegativo = !ePositivo;
        boolean ePar = numero % 2 == 0;
        boolean eImpar = !ePar;
        if (numero == 0) {
            System.out.printf(ehZero);
        } else if (ePositivo && ePar) {
            System.out.printf("O numero %d é positivo e par", numero);
        } else if (ePositivo && eImpar) {
            System.out.printf("O numero %d é positivo e impar", numero);
        } else if (eNegativo && ePar) {
            System.out.printf("O numero %d é negativo e par", numero);
        } else if (eNegativo && eImpar) {
            System.out.printf("O numero %d é negativo e impar", numero);
        }

//        Scanner ler = new Scanner(System.in);
//        System.out.println("Informe um número:");
//        var num = ler.nextInt();
//        var parImpar = num > 0 ? "positivo" : "negativo";
//        var result = (num % 2 == 0)
//                ? System.out.printf("O número <%d> é %s e par;", num, parImpar)
//                : System.out.printf("O número <%d> é %s e impar;", num, parImpar);
    }
}
