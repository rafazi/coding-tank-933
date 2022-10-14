import java.util.Scanner;

public class Input {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String nome;
        System.out.println("Qual o seu nome?");
        nome = ler.nextLine();
        System.out.println("Boa noite, " + nome);
        System.out.println("Qual seu ano de nascimento?");
        int anoNasc = ler.nextInt();
        ler.nextLine();
        int idade = 2022 - anoNasc;
        System.out.println("Ao final de 2022 você terá " + idade + " anos.");
        String test = ler.nextLine();
        System.out.println(test);
        ler.close();
    }
}
