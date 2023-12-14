package Lego;

import java.util.ArrayList;
import java.util.List;

public class Solucao {
	
	
    private static final int MOD = 1000000007;//número mágico
    
    int[] valores = {1, 2, 3, 4};//tipos de lego existentes, se mudar isso acho que segue funcionando

    
    private int altura;
    private int largura;
    int[][] matriz;

    public Solucao(int altura, int largura) {
        this.altura = altura;
        this.largura = largura;
        this.matriz = new int[altura][largura];
    }
    
    public int soluciona() {
    	
    	int retorno=0;
    	
    	
    	
    	if(verificaValidade()) {
    		retorno++;
    	}
    	
    	return retorno;
    }
    
    public void addBlock(int block, int place) {
    	
    	
    	
    }
    
    public void montaLinha(int alturaAtual) {
    	int soma=0;
    	
    	if(soma<largura) {
    		
    		if (soma==largura) {
    			
    		}
    	}
    }
    
    public boolean verificaValidade() {
    	int alt;
    	boolean retorno=true;
    	for(alt=0;alt<altura-1;alt++) {
    		
    		
    	}
    	return false;
    }
    
    
    public static void limparMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = 0;
            }
        }
    }
    
    
//permutador de linhas a baixo
    
    // Método para encontrar as formas de soma possíveis
    public static List<List<Integer>> encontrarFormasSoma(int[] valores, int alvo) {
        List<List<Integer>> formasSoma = new ArrayList<>();
        encontrarFormasSomaRecursivo(valores, alvo, new ArrayList<>(), formasSoma);
        return formasSoma;
    }
    
    // Método recursivo para encontrar as formas de soma possíveis

    public static void encontrarFormasSomaRecursivo(int[] valores, int alvo, List<Integer> formaAtual, List<List<Integer>> formasSoma) {
        int somaAtual = somaLista(formaAtual);

        if (somaAtual == alvo) {
            formasSoma.add(new ArrayList<>(formaAtual)); // Encontrou uma forma de soma, adiciona à lista
            return;
        }

        if (somaAtual > alvo) {
            return; // Soma excedeu o alvo, não é uma forma válida
        }

        for (int valor : valores) {
            formaAtual.add(valor);
            encontrarFormasSomaRecursivo(valores, alvo, formaAtual, formasSoma);
            formaAtual.remove(formaAtual.size() - 1); // Backtracking para testar outras combinações
        }
    }

    // Método auxiliar para calcular a soma de uma lista
    private static int somaLista(List<Integer> lista) {
        int soma = 0;
        for (int num : lista) {
            soma += num;
        }
        return soma;
    }
   
    
}
