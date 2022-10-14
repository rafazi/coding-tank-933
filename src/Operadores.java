import java.math.BigDecimal;

public class Operadores {

    public static void main(String[] args) {
        var a = 3;
        int b = 2;
        System.out.println(a + " e " + b);
        System.out.println("Soma: "          + add(a, b));
        System.out.println("Subtração: "     + sub(a, b));
        System.out.println("Multiplicação: " + mul(a, b));
        System.out.println("Divisão: "       + div(a, b));
    }
    public static int add(int a, int b) {
        return a + b;
    }
    public static double sub(double primeiro, double segundo) {
        return primeiro - segundo;
    }
    public static int mul(int primeiro, int segundo) {
        return primeiro * segundo;
    }

    public static double div(double primeiro, double segundo) {
        return primeiro / segundo;
    }
}
