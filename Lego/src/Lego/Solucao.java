package Lego;

import java.util.ArrayList;
import java.util.List;

public class Solucao {
	
	
    private static final int MOD = 1000000007;//número mágico
    
    int[] valores = {1, 2, 3, 4};//tipos de lego existentes, se mudar isso acho que segue funcionando
    List<List<Integer>> formasLinha;
    List<List<Integer>> combinacoesLinhas;
    int totalFormas=0;
    
    private int altura;
    private int largura;
    int[][] matriz;
    int retorno=0;

    public Solucao(int altura, int largura) {
        this.altura = altura;
        this.largura = largura;
        this.matriz = new int[altura][largura];
        System.out.println("gerando as linhas validas");
        this.formasLinha = encontrarFormasSoma(valores, largura);
        System.out.println("gerando as apermutações que serão as combinações das linhas");
        this.combinacoesLinhas = generatePermutations(altura, totalFormas);

    }
    
    public void soluciona() {
    	

        // Exibindo as linhas de soma encontradas
    	
        System.out.println("Formas de soma para " + largura + ":");
        for (List<Integer> forma : formasLinha) {
            System.out.println(forma);
        }

        
    	//para cada permutação de linhas é gerada uma matriz
        for (List<Integer> permutacao : combinacoesLinhas) {
        	montaMatriz(permutacao);
            //System.out.println(permutacao);

        }
        
        System.out.println("TOTAL DE FORMAS"+combinacoesLinhas.size());
        System.out.println("TOTAL DE FORMAS VÁLIDAS:"+retorno);

    	
    }
    

    
    public void montaMatriz(List<Integer> permutacao) {
    	int alt=0;
    	
    	for(int permut=0;permut<permutacao.size() ;permut++) {

            	System.out.print(formasLinha.get(permutacao.get(permut)-1));
            	preencheMatriz(formasLinha.get(permutacao.get(permut)-1),alt);
            	alt++;
    	}
    	
        System.out.println("");

    	imprimirMatriz(this.matriz);
    	if(verificaValidade(this.matriz)) {
            System.out.println("MATRIZ VÁLIDA");
    	}else {
            System.out.println("MATRIZ INVÁLIDA");
    	}
    	limparMatriz(this.matriz);
        System.out.println("");
        System.out.println("");

    }
    
    public void preencheMatriz(List<Integer> linha, int alt) {
    	int bloco = 0;
    	int lego=0;
    	int index=0;
        System.out.println("quantia de blocos na linha: "+linha.size());

    	for(int lin=0; lin<linha.size();lin++) {
    		lego=linha.get(lin);
    		
    		for (int i=0; i<lego;i++) {
    			
    	    System.out.println ("this.matriz[" + alt+"]["+index+"]="+lego);
    		this.matriz[alt][index]=bloco;
    		index++;

    		}
    		bloco++;
    	}
    	

    }
    

    
    public boolean verificaValidade(int[][] matriz) {
    	int alt=0;
    	int larg=0;
    	//matriz[alt][larg]=0;
    	for(alt=0;alt<this.altura;) {
    		
    		if(matriz[alt][larg]==matriz[alt][larg+1]) {
                System.out.println("Ponto na largura: "+larg);
    			larg++;
    			alt=0;
    			if(larg+1==this.largura) {
    		    	this.retorno ++;
    		    	return true;
    			}
    		}else {
    			alt++;
    		}
    	}
    	
    	
    	return false;
    }
    
    public void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println();
        System.out.println();
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
    public  List<List<Integer>> encontrarFormasSoma(int[] valores, int alvo) {
        List<List<Integer>> formasSoma = new ArrayList<>();
        encontrarFormasSomaRecursivo(valores, alvo, new ArrayList<>(), formasSoma);
        return formasSoma;
    }
    
    // Método recursivo para encontrar as formas de soma possíveis

    public void encontrarFormasSomaRecursivo(int[] valores, int alvo, List<Integer> formaAtual, List<List<Integer>> formasSoma) {
        int somaAtual = somaLista(formaAtual);

        if (somaAtual == alvo) {
            formasSoma.add(new ArrayList<>(formaAtual)); // Encontrou uma forma de soma, adiciona à lista e aumenta o contador
            this.totalFormas++;
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
   
    
    //permutador permutante que permuta a baixo
   
    public List<List<Integer>> generatePermutations(int n, int maxValue) {
        List<List<Integer>> permutations = new ArrayList<>();
        generatePermutationsHelper(n, maxValue, new ArrayList<>(), permutations);
        return permutations;
    }

    private void generatePermutationsHelper(int n, int maxValue, List<Integer> current, List<List<Integer>> permutations) {
        if (n == 0) {
            permutations.add(new ArrayList<>(current));
            return;
        }

        for (int i = 1; i <= maxValue; i++) {
            current.add(i);
            generatePermutationsHelper(n - 1, maxValue, current, permutations);
            current.remove(current.size() - 1);
        }
    }
}
