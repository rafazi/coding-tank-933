import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

public class TabelaPrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o valor do empréstimo");
        BigDecimal saldoDevedorTotal = sc.nextBigDecimal();
        System.out.println("Informe juros ao mês em porcentagem");
        BigDecimal jurosPercentual = sc.nextBigDecimal();
        System.out.println("Informe período de empréstimo");
        BigDecimal meses = sc.nextBigDecimal();
        BigDecimal cem = BigDecimal.valueOf(100);
        BigDecimal jurosAoMes = jurosPercentual.divide(cem);
        BigDecimal umMaisJuros = BigDecimal.ONE.add(jurosAoMes);
        BigDecimal umMaisJurosElevadoAMeses = umMaisJuros.pow(meses.intValue());
        BigDecimal dividendo = umMaisJurosElevadoAMeses.multiply(jurosAoMes);
        BigDecimal divisor = umMaisJurosElevadoAMeses.subtract(BigDecimal.ONE);
        MathContext casasDecimais = new MathContext(5);
        BigDecimal parcela = saldoDevedorTotal.multiply(dividendo.divide(divisor, casasDecimais));
        System.out.printf("Valor fixo da parcela R$ %.2f, Saldo devedor total R$ %.2f%n", parcela, saldoDevedorTotal);
        BigDecimal saldoDevedorAtual = saldoDevedorTotal;
        BigDecimal totalJuros = BigDecimal.ZERO;
        BigDecimal totalAmortizacao = BigDecimal.ZERO;
        BigDecimal totalParcela = BigDecimal.ZERO;
        for (int i = 1; i <= meses.intValue(); i++) {
            BigDecimal jurosNoMes = saldoDevedorAtual.multiply(jurosAoMes);
            BigDecimal amortizacao = parcela.subtract(jurosNoMes);
            saldoDevedorAtual = saldoDevedorAtual.subtract(amortizacao);
            System.out.printf("Parcela %d | Juros: R$ %.2f | Amortização: R$ %.2f | Saldo devedor: R$ %.2f%n", i, jurosNoMes, amortizacao, saldoDevedorAtual);
            totalJuros = totalJuros.add(jurosNoMes);
            totalAmortizacao = totalAmortizacao.add(amortizacao);
            totalParcela = totalParcela.add(parcela);
        }
        System.out.printf("Total: Prestação R$ %.2f, Juros R$ %.2f, Amortização R$ %.2f", totalParcela, totalJuros, totalAmortizacao);
    }
}
