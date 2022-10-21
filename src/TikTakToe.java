import java.util.Scanner;

public class TikTakToe {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean continuarJogando = true;
        int vitoriasDeX = 0;
        int vitoriasDeO = 0;
        int empates = 0;
        while(continuarJogando) {
            char resultado = jogar(input);
            if (resultado == 'X') {
                vitoriasDeX++;
            } else if (resultado == 'O') {
                vitoriasDeO++;
            } else {
                empates++;
            }
            imprimirPlacar(vitoriasDeX, vitoriasDeO, empates);
            continuarJogando = caputuraSeDesejaContinuarJogando(input);
        }
        input.close();
    }

    private static void imprimirPlacar(int vitoriasDeX, int vitoriasDeO, int empates) {
        System.out.println("Placar");
        System.out.printf("Jogador X: %d vitória(s)%n", vitoriasDeX);
        System.out.printf("Jogador O: %d vitória(s)%n", vitoriasDeO);
        System.out.printf("Empate(s): %d%n", empates);
    }

    private static boolean caputuraSeDesejaContinuarJogando(Scanner input) {
        while (true) {
            System.out.println("Deseja continuar jogando?[true|false]");
            try {
                boolean b = input.nextBoolean();
                input.nextLine();
                return b;
            } catch (Exception e) {
                input.nextLine();
                System.out.println("entrada inválida, favor dizer true se deseja continuar jogando ou false se deseja encerrar.");
            }
        }
    }

    private static char jogar(Scanner input) {
        char[][] tabuleiro = inicializarTabuleiro();
        int rodada = 0;
        imprimirTabuleiro(rodada, tabuleiro);
        char jogador = 'O';
        boolean acabou = false;
        while (!acabou) {
            jogador = jogador == 'X' ? 'O' : 'X';
            acabou = capturarJogada(tabuleiro, rodada, input, jogador);
            imprimirTabuleiro(rodada, tabuleiro);
            rodada++;
            if (!acabou && rodada == 9) {
                System.out.println("O jogo empatou");
                return 'E';
            }
        }
        return jogador;
    }

    private static boolean capturarJogada(char[][] tabuleiro, int rodada, Scanner input, char jogador) {
        boolean jogadaValida = false;
        while (!jogadaValida) {
            System.out.printf("Jogador %s informe sua jogada%n", jogador);
            String jogada = input.nextLine();
            char[] posicoes = jogada.toCharArray();
            try {
                int linha = Integer.parseInt(String.valueOf(posicoes[0]));
                int coluna = Integer.parseInt(String.valueOf(posicoes[1]));
                char posicaoAtual = tabuleiro[linha][coluna];
                if (posicaoAtual != ' ') {
                    throw new IllegalArgumentException("a posição já está preenchida informe outra jogada");
                }
                tabuleiro[linha][coluna] = jogador;
                jogadaValida = true;
                if (validaSeJogoAcabou(tabuleiro, jogador, linha, coluna)) return true;
            } catch (NumberFormatException e) {
                System.out.printf("Jogada \"%s\" não é válida, é esperado que informe os números da linha e a coluna juntos. Exemplo 00%n", jogada);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.printf("Jogada \"%s\" não é válida, somente posições de 0 a 2 são válidas para linhas e colunas. Exemplo 00%n", jogada);
            } catch (IllegalArgumentException e) {
                System.out.printf("Jogada \"%s\" não é válida, %s.%n", jogada, e.getMessage());
            }
        }
        return false;
    }

    private static boolean validaSeJogoAcabou(char[][] tabuleiro, char jogador, int linha, int coluna) {
        if (validaLinha(tabuleiro, jogador, linha)) return true;
        if (validaColuna(tabuleiro, jogador, coluna)) return true;
        if (validaDiagonalEsquerda(tabuleiro, jogador, linha, coluna)) return true;
        if (validaDiagonalDireita(tabuleiro, jogador, linha, coluna)) return true;
        return false;
    }

    private static boolean validaDiagonalDireita(char[][] tabuleiro, char jogador, int linha, int coluna) {
        if (linha + coluna == 2 && tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) {
            System.out.printf("Jogador %s venceu, pelas posições 02, 11 e 20.%n", jogador);
            return true;
        }
        return false;
    }

    private static boolean validaDiagonalEsquerda(char[][] tabuleiro, char jogador, int linha, int coluna) {
        if (linha == coluna && tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) {
            System.out.printf("Jogador %s venceu, pelas posições 00, 11 e 22.%n", jogador);
            return true;
        }
        return false;
    }

    private static boolean validaColuna(char[][] tabuleiro, char jogador, int coluna) {
        if (tabuleiro[0][coluna] == tabuleiro[1][coluna] && tabuleiro[1][coluna] == tabuleiro[2][coluna]) {
            System.out.printf("Jogador %s venceu, pelas posições 0%d, 1%d e 2%d.%n", jogador, coluna, coluna, coluna);
            return true;
        }
        return false;
    }

    private static boolean validaLinha(char[][] tabuleiro, char jogador, int linha) {
        if (tabuleiro[linha][0] == tabuleiro[linha][1] && tabuleiro[linha][1] == tabuleiro[linha][2]) {
            System.out.printf("Jogador %s venceu, pelas posições %d0, %d1 e %d2.%n", jogador, linha, linha, linha);
            return true;
        }
        return false;
    }

    private static char[][] inicializarTabuleiro() {
        char[][] tabuleiro = new char[3][];
        for (int i=0; i<3; i++) {
            tabuleiro[i] = new char[]{' ', ' ', ' '};
        }
        return tabuleiro;
    }

    private static void imprimirTabuleiro(int rodada, char[][] tabuleiro) {
        imprimirCabeçalho(rodada);
        for (int i=0;i<3; i++) {
            imprimirLinha(tabuleiro, i);
        }
    }

    private static void imprimirCabeçalho(int rodada) {
        System.out.printf("Rodada %s:%n", rodada);
        System.out.println("     0 | 1 | 2  ");
        imprimirPontilhado();
    }

    private static void imprimirLinha(char[][] tabuleiro, int i) {
        char[] linha = tabuleiro[i];
        System.out.printf(" %d | %c | %c | %c |%n", i, linha[0], linha[1], linha[2]);
        imprimirPontilhado();
    }

    private static void imprimirPontilhado() {
        System.out.println("----------------");
    }
}
