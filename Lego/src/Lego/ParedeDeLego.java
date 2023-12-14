package Lego;

public class ParedeDeLego {

    private static final int MOD = 1000000007;
    private int altura;
    private int largura;

    public ParedeDeLego(int altura, int largura) {
        this.altura = altura;
        this.largura = largura;
    }

    public int calculaManeirasDeConstruir() {
        int[] dp = new int[largura + 1];
        dp[0] = 1;

        for (int i = 1; i <= largura; i++) {
            for (int j = 1; j <= 4; j++) {
                if (i >= j) {
                    dp[i] = (dp[i] + dp[i - j]) % MOD;
                }
            }
        }

        return dp[largura];
    }
}
