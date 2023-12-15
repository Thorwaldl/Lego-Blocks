import java.util.Scanner;

public class Main {
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar ao usuário o número de casos de teste
        System.out.print("Digite o número de casos de teste (t): ");
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            // Leitura de n e m para cada caso de teste
            System.out.print("Digite a altura (n) e a largura (m) separadas por espaço para o caso de teste " + (i + 1) + ": ");
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            // Criando um objeto ParedeDeLego
            ParedeDeLego parede = new ParedeDeLego(n, m);

            // Chamada do método calculaManeirasDeConstruir e impressão do resultado
            int result = parede.calculaManeirasDeConstruir();
            System.out.println("Número de maneiras de construir a parede: " + result);
        }

        scanner.close();
    }
}
