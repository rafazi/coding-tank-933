import java.math.BigDecimal;
import java.util.Scanner;

public class JurosAoMes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o valor inicial investido em R$.");
        BigDecimal valorInicial = sc.nextBigDecimal();
        System.out.println("Juros ao mês em %");
        BigDecimal jurosPecentual = sc.nextBigDecimal();
        System.out.println("Informe o tempo em meses que o dinheiro ficará investido em meses.");
        int meses = sc.nextInt();

        System.out.printf("%s reais, %s%% de juros ao mês por %s meses.\n", valorInicial, jurosPecentual, meses);
        BigDecimal saldo = valorInicial;
        BigDecimal cem = new BigDecimal(100);
        BigDecimal jurosAoMes = jurosPecentual.divide(cem);
        for (int i = 1; i <= meses ; i++) {
            BigDecimal valorJuros = saldo.multiply(jurosAoMes);
            saldo = saldo.add(valorJuros);
            System.out.printf("Mês %d: Juros: R$ %.2f, saldo: %.2f %n", i, valorJuros, saldo);
        }
    }
}
