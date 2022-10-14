public class LogicaBooleana {

    public static void main(String[] args) {
        boolean verdadeiro = true;
        boolean falso = false;
        System.out.printf("verdadeiro && verdadeiro = %b%n", verdadeiro && verdadeiro);
        System.out.printf("verdadeiro && falso = %b%n", verdadeiro && falso);
        System.out.printf("falso && verdadeiro = %b%n", falso && verdadeiro);
        System.out.printf("falso && falso = %b%n", falso && falso);
        System.out.println("===============");
        System.out.printf("verdadeiro || verdadeiro = %b%n", verdadeiro || verdadeiro);
        System.out.printf("verdadeiro || falso = %b%n", verdadeiro || falso);
        System.out.printf("falso || verdadeiro = %b%n", falso || verdadeiro);
        System.out.printf("falso || falso = %b%n", falso || falso);
    }
}
