import java.util.Scanner;

public class ListarNumerosVarArgs {

    public static void main(String[] args) {
        if (args.length > 2) {
            System.out.printf("Numero de argumentos %d é invalido, esperado até 2 argumentos.", args.length);
            return;
        }
        Scanner sc = new Scanner(System.in);

        int init = capturarInit(args, sc);
        int end = capturarEnd(args, sc);

        System.out.printf("Resultado: [");
        while(init < end){
            System.out.printf("%d, ", init);
            init++;
        }
        System.out.printf("%d]", end);

//        if(args.length == 0){
//            System.out.printf("Informe o valor inicial:\n");
//            init = Integer.parseInt(sc.nextLine());
//            System.out.printf("Informe o valor final:\n");
//            end = Integer.parseInt(sc.nextLine());
//        } else if (args.length == 1) {
//            init = Integer.parseInt(args[0]);
//            System.out.printf("Informe o valor final:\n");
//            end = Integer.parseInt(sc.nextLine());
//        } else if (args.length == 2){
//            init = Integer.parseInt(args[0]);
//            end = Integer.parseInt(args[1]);
//        } else {
//            System.out.printf("Numero de argumentos X é invalido, esperado até 2 argumentos.");
//            return;
//        }

        System.out.printf("Resultado: [");
        while(init < end){
            System.out.printf("%d, ", init);
            init++;
        }
        System.out.printf("%d]", end);

    }

    private static int capturarEnd(String[] args, Scanner sc) {
        if (args.length == 2) {
            return Integer.parseInt(args[1]);
        } else {
            System.out.printf("Informe o valor final:\n");
            return Integer.parseInt(sc.nextLine());
        }
    }

    public static int capturarInit(String[] args, Scanner sc) {
        if (args.length >= 1) {
            return Integer.parseInt(args[0]);
        } else {
            System.out.printf("Informe o valor inicial:\n");
            return Integer.parseInt(sc.nextLine());
        }

//        if (args.length >= 1) {
//            return Integer.parseInt(args[0]);
//        }
//        System.out.printf("Informe o valor inicial:\n");
//        return Integer.parseInt(sc.nextLine());
    }

}
