import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public class BhaskaraBigDecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o coeficiente a: ");
        BigDecimal a =  BigDecimal.valueOf(sc.nextDouble());
        System.out.println("Digite o coeficiente b: ");
        BigDecimal b =  BigDecimal.valueOf(sc.nextDouble());
        System.out.println("Digite o coeficiente c: ");
        BigDecimal c =  BigDecimal.valueOf(sc.nextDouble());


        BigDecimal b2 = b.pow(2);
        BigDecimal ac4 = BigDecimal.valueOf(4.0).multiply(a).multiply(c);
        BigDecimal delta = b2.subtract(ac4);

        BigDecimal bMenos = b.multiply(new BigDecimal(-1));
        BigDecimal doisA = new BigDecimal(2).multiply(a);


        System.out.println("A equação é " + a + "x^2 " + "+ " + b + "x " + c);
        System.out.println("O valor de delta é: " + delta);
        int comparison = delta.compareTo(BigDecimal.ZERO);
        if (comparison == 0) {
            System.out.println("Existe somente uma raiz de X que é: " + bMenos.divide(doisA));
            return;
        }

        if (comparison == -1) {
            System.out.println("Não existem raízes reais");
            return;
        }

        MathContext mc = new MathContext(3);
        BigDecimal deltaSqrt = delta.sqrt(mc);
        System.out.println("X1 = " + bMenos.add(deltaSqrt).divide(doisA));
        System.out.println("X2 = " + bMenos.subtract(deltaSqrt).divide(doisA));

    }
}
