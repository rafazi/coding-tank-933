public class Bhaskara {

    public static void main(String[] args) {
        java.util.Scanner myObj = new java.util.Scanner(System.in);
        System.out.println("Informe o coeficiente a: ");
        double a = myObj.nextDouble();
        System.out.println("Informe o coeficiente b: ");
        double b = myObj.nextDouble();
        System.out.println("Informe o coeficiente c: ");
        double c = myObj.nextDouble();

        double delta = Math.pow(b, 2) - 4 * a * c;

        double sqrt = Math.sqrt(delta);
        double x1 = (-b + sqrt) / (2 * a);
        double x2 = (-b - sqrt) / (2 * a);

        System.out.println("A equação é " + a + "x^2 " + "+ " + b + "x " + c);
        System.out.println("O valor de delta é: " + delta);
        System.out.println("A raiz x1 é: " + x1);
        System.out.println("A raiz x2 é: " + x2);
    }
}
