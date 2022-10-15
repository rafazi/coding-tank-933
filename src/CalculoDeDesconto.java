import java.util.Scanner;

public class CalculoDeDesconto {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Qual o valor da Compra?");
        double valor = s.nextDouble();
        s.nextLine();
        System.out.println("Qual a forma de pagamento? [CREDITO,DEBITO,CHEQUE,BOLETO,PIX]");
        String formaPgt = s.nextLine().toUpperCase();
        double desc = 0;
//        if (formaPgt.equals("CREDITO") || formaPgt.equals("DEBITO")) {
//            desc = 3;
//        } else if (formaPgt.equals("CHEQUE")) {
//            desc = 6;
//        }  else if (formaPgt.equals("BOLETO")) {
//            desc = 9;
//        } else if (formaPgt.equals("DINHEIRO") || formaPgt.equals("PIX")) {
//            desc = 12;
//        }

//        switch (formaPgt) {
//            case "CREDITO":
//            case "DEBITO":
//                desc = 3;
//                break;
//            case "CHEQUE":
//                desc = 6;
//                break;
//            case "BOLETO":
//                desc = 9;
//                break;
//            case "DINHEIRO":
//            case "PIX":
//                desc = 12;
//                break;
//            default:
//                desc = -1;
//        }

        switch (formaPgt) {
            case "CREDITO", "CRÉDITO", "DÉBITO", "DEBITO" -> desc = 3;
            case "CHEQUE" -> desc = 6;
            case "BOLETO" -> desc = 9;
            case "DINHEIRO", "PIX" -> desc = 12;
            default -> desc = -1;
        }

        if (desc == -1) {
            System.out.println("Forma de pagamento inválida");
        } else {
            System.out.printf("A sua compra possui %.0f%% de desconto.%n", desc);
            System.out.printf("Totalizando: R$ %.2f", (valor * (100 - desc) / 100));
        }
    }
}
