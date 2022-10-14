public class HelloWorld {
    public static void main(String[] args) {
        String nome = "Fábio";//        System.out.println("Boa noite, " + nome + ".\nAté logo, " + nome + ".");
//        nome = "Vinicius";
//        nome = "Sérgio";
//        System.out.println(nome);
//        System.out.println("Boa noite, " + nome + ".");
//        System.out.println("Até logo, " + nome + ".");

        System.out.printf("Boa noite, %s %s %s.%n", nome, nome, nome);
        System.out.printf("Até logo, %s.", nome);
    }
}
