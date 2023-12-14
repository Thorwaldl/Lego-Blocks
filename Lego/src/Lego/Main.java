package Lego;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de casos de teste (t): ");
        int t = scanner.nextInt();
        int[] valores = {1, 2, 3, 4};
        for (int i = 0; i < t; i++) {
            System.out.println("Para o caso de teste #" + (i + 1));
            System.out.print("Digite a altura da parede (n): ");
            int n = scanner.nextInt();
            System.out.print("Digite a largura da parede (m): ");
            int m = scanner.nextInt();
            
            long startTime = System.nanoTime();
            
            Solucao s = new Solucao(n, m);
            List<List<Integer>> formasSoma = s.encontrarFormasSoma(valores, m);

            // Exibindo as formas de soma encontradas
            System.out.println("Formas de soma para " + m + ":");
            for (List<Integer> forma : formasSoma) {
                System.out.println(forma);
            }
            //ParedeDeLego parede = new ParedeDeLego(n, m);
            //int result = parede.calculaManeirasDeConstruir();
            
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);  
            double milliseconds = (double) duration / 1_000_000;  // Convert to milliseconds
            System.out.println("Elapsed Time: " + milliseconds + " milliseconds");
            
            //System.out.println("Número de maneiras de construir a parede: " + result);
        }

        scanner.close();
    }
}
