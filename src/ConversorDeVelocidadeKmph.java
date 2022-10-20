import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class ConversorDeVelocidadeKmph {
    public static void main(String[] args) {
        int[] velocidades;
//        velocidades = new int[]{35, 20, 10, 68, 75};
        velocidades = new int[5];
        for (int i = 0; i < 5; i++) {
            velocidades[i] = ThreadLocalRandom.current().nextInt(0, 101);
        }
        System.out.println("Velocidades aferidas:");
//        System.out.println(Arrays.toString(velocidades));
        for (int v : velocidades) {
            System.out.printf(" %d", v);
        }
        System.out.println("");
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual a unidade de origem? [m/s, km/h, mile/h e knot]");
        String origem = sc.nextLine();


        if (!entradaEhValida(origem)) {
            return;
        }
        System.out.println("Qual a unidade de destino? [m/s, km/h, mile/h e knot]");
        String destino = sc.nextLine();
        if (!entradaEhValida(destino)) {
            return;
        }

        for (int i = 0; i < 5; i++) {
            int velocidade = velocidades[i];
            double velocidadeConvertida = conversao(velocidade, origem, destino);
            System.out.printf("%s %s = %s %s%n", velocidade, origem, velocidadeConvertida, destino);
        }

    }
    private static double conversao(double v, String origem, String destino) {
        double velocidadeOriginal = origem2kmph(v, origem);
        double velocidadeDestino = kmph2destino(velocidadeOriginal, destino);
        return velocidadeDestino;
    }

    public static double origem2kmph(double velocidade, String origem){
        switch (origem) {
            case "m/s":
                return mpsParaKmph(velocidade);
            case "mile/h":
                return milephParaKmph(velocidade);
            case "knot":
                return knotParaKmph(velocidade);
            case "km/h":
            default:
                return velocidade;
        }
    }

    public static double kmph2destino(double velocidade, String destino){
        switch (destino) {
            case "m/s":
                return kmphParaMps(velocidade);
            case "mile/h":
                return kmphParaMileph(velocidade);
            case "knot":
                return kmphParaKnot(velocidade);
            case "km/h":
            default:
                return velocidade;
        }
    }

    public static double kmphParaMps(double kmph) {
        return kmph / 3.6;
    }

    public static double mpsParaKmph(double mps) {
        return mps * 3.6;
    }

    /*
        kmph = mileph * 1.609
        mileph = kmph / 1.609
     */
    public static double milephParaKmph(double mileph) {
        return mileph * 1.609;
    }

    public static double kmphParaMileph(double Kmph) {
        return Kmph / 1.609;
    }

    /*
    kmph = knot * 1.852
    knot = kmph / 1.852
     */
    public static double knotParaKmph(double knot) {
        return knot * 1.852;
    }

    public static double kmphParaKnot(double Kmph) {
        return Kmph / 1.852;
    }

    public static boolean entradaEhValida(String entrada) {
        switch (entrada) {
            case "m/s":
            case "km/h":
            case "mile/h":
            case "knot":
                return true;
            default:
                System.out.printf("A entrada %s não é válida, esperava uma das seguintes: m/s, km/h, mile/h e knot", entrada);
                return false;
        }
    }

}
