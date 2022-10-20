import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class ConversorDeVelocidade {
    public static void main(String[] args) {
        int[] velocidades;
        velocidades = new int[]{35, 20, 10, 68, 75};
//        velocidades = new int[5];
//        for (int i = 0; i < 5; i++) {
//            velocidades[i] = ThreadLocalRandom.current().nextInt(0, 101);
//        }
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
            double velocidadeConvertida = converte(origem, destino, velocidade);
            System.out.printf("%s %s = %s %s%n", velocidade, origem, velocidadeConvertida, destino);
        }

    }

    public static double converte(String origem, String destino, int velocidade) {
        switch (origem) {
            case "m/s":
                return convertMps(destino, velocidade);
            case "km/h":
                return convertKmph(destino, velocidade);
            case "mile/h":
                return convertMileph(destino, velocidade);
            case "knot":
                return convertKnot(destino, velocidade);
        }
        return velocidade;
    }

    public static double convertMps(String destino, int velocidade) {
        switch (destino) {
            case "km/h":
                return mpsParaKmph(velocidade);
            case "mile/h":
                return mpsParaMileph(velocidade);
            case "knot":
                return mpsParaKnot(velocidade);
            case "m/s":
            default:
                return velocidade;
        }
    }

    public static double convertKmph(String destino, int velocidade) {
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

    public static double convertMileph(String destino, int velocidade) {
        switch (destino) {
            case "m/s":
                return milephParaMps(velocidade);
            case "km/h":
                return milephParaKmph(velocidade);
            case "knot":
                return milephParaKnot(velocidade);
            case "mile/h":
            default:
                return velocidade;
        }
    }

    public static double convertKnot(String destino, int velocidade) {
        switch (destino) {
            case "m/s":
                return knotParaMps(velocidade);
            case "km/h":
                return knotParaKmph(velocidade);
            case "mile/h":
                return knotParaMileph(velocidade);
            case "knot":
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

    public static double knotParaMileph(double knot) {
        double kmph = knotParaKmph(knot);
        return kmphParaMileph(kmph);
    }

    public static double milephParaKnot(double mileph) {
        double kmph = milephParaKmph(mileph);
        return kmphParaKnot(kmph);
    }

    public static double knotParaMps(double knot) {
        double kmph = knotParaKmph(knot);
        return kmphParaMps(kmph);
    }

    public static double mpsParaKnot(double mps) {
        double kmph = mpsParaKmph(mps);
        return kmphParaKnot(kmph);
    }

    public static double milephParaMps(double mileph) {
        double kmph = milephParaKmph(mileph);
        return kmphParaMps(kmph);
    }

    public static double mpsParaMileph(double mps) {
        double kmph = mpsParaKmph(mps);
        return kmphParaMileph(kmph);
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
