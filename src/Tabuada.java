public class Tabuada {

    public static void main(String[] args) {
        for(int i = 1; i <= 10; i++){
            System.out.printf("Tabuada do %d:\n", i);
            imprimirTabuada(i);
        }
    }

    private static void imprimirTabuada(int n) {
        for(int j = 1; j <= 10; j++){
            System.out.printf("%d x %d = %d\n", n, j, (n *j));
        }
    }
}
