package funcao;

import java.util.Scanner;

public class jogo {
	static Scanner scanner = new Scanner(System.in);
	static String jogoDAvelha[][] = new String[3][3];
	static int preencheu, perguntar = 0, jogador = 1, fiscalizador = 0, para = 0, contador=0;
	

	public static void main(String[] args) {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				jogoDAvelha[i][j]="_";
			}
		}
		System.out.println("Jogador 1-Bolinha\nJogador 2-Xis");

		while (fiscalizador == 0) {
			perguntar = preencher(preencheu, jogador);
			perguntar = 0;
			if (jogador == 1) {
				jogador += 1;
			} else if (jogador == 2) {
				jogador -= 1;
			}
			fiscalizador = ganhador(para);
		}
		if (fiscalizador == 2) {
			System.out.println("Jogador 2 é o vencedor");
		} else if (fiscalizador == 1) {
			System.out.println("Jogador 1 é o vencedor");
		} else if (fiscalizador == 3) {
			System.out.println("Ocorreu um empate!");
		}
	}

	static void jogoVelha() {
		System.out.println("["+jogoDAvelha[0][0] +"]" + "[" +jogoDAvelha[0][1] + "]" + "[" +jogoDAvelha[0][2]+"]");
		System.out.println("["+jogoDAvelha[1][0]+"]" + "["+jogoDAvelha[1][1]+"]" + "["+jogoDAvelha[1][2]+"]");
		System.out.println("["+jogoDAvelha[2][0]+"]" + "["+jogoDAvelha[2][1]+"]" + "["+jogoDAvelha[2][2]+"]");
	}

	static public int preencher(int preencheu, int jogador) {
		int i, j;
		while (preencheu != 1) {
			System.out.println("\nJogador " + jogador + ":");
			System.out.println("\nInforme a linha da jogada:");
			i = scanner.nextInt();
			System.out.println("Informe a coluna da jogada");
			j = scanner.nextInt();
			if (jogador == 1) {
				if (jogoDAvelha[i][j] == "x" || jogoDAvelha[i][j] == "o") {
					System.out.println("Jogada inválida!");
				} else {
					jogoDAvelha[i][j] = "o";
					preencheu = 1;
				}
			} else if (jogador == 2) {
				if (jogoDAvelha[i][j] == "x" || jogoDAvelha[i][j] == "o") {
					System.out.println("Jogada inválida!");
				} else {
					jogoDAvelha[i][j] = "x";
					preencheu = 1;
				}
			}
			jogoVelha();
		}
		return preencheu;
	}

	static public int ganhador(int para) {
		contador++;
				if (jogoDAvelha[0][0] == "x" && jogoDAvelha[0][1] == "x" && jogoDAvelha[0][2] == "x"
						|| jogoDAvelha[0][0] == "x" && jogoDAvelha[1][0] == "x" && jogoDAvelha[2][0] == "x"
						|| jogoDAvelha[1][0] == "x" && jogoDAvelha[1][1] == "x" && jogoDAvelha[1][2] == "x"
						|| jogoDAvelha[0][1] == "x" && jogoDAvelha[1][1] == "x" && jogoDAvelha[2][1] == "x"
						|| jogoDAvelha[2][0] == "x" && jogoDAvelha[2][1] == "x" && jogoDAvelha[2][2] == "x"
						|| jogoDAvelha[0][2] == "x" && jogoDAvelha[1][2] == "x" && jogoDAvelha[2][2] == "x"
						|| jogoDAvelha[0][0] == "x" && jogoDAvelha[1][1] == "x" && jogoDAvelha[2][2] == "x"
						|| jogoDAvelha[0][2] == "x" && jogoDAvelha[1][1] == "x" && jogoDAvelha[2][0] == "x") {
					para = 2;
				}
				else if (jogoDAvelha[0][0] == "o" && jogoDAvelha[0][1] == "o" && jogoDAvelha[0][2] == "o"
						|| jogoDAvelha[0][0] == "o" && jogoDAvelha[1][0] == "o" && jogoDAvelha[2][0] == "o"
						|| jogoDAvelha[1][0] == "o" && jogoDAvelha[1][1] == "o" && jogoDAvelha[1][2] == "o"
						|| jogoDAvelha[0][1] == "o" && jogoDAvelha[1][1] == "o" && jogoDAvelha[2][1] == "o"
						|| jogoDAvelha[2][0] == "o" && jogoDAvelha[2][1] == "o" && jogoDAvelha[2][2] == "o"
						|| jogoDAvelha[0][2] == "o" && jogoDAvelha[1][2] == "o" && jogoDAvelha[2][2] == "o"
						|| jogoDAvelha[0][0] == "o" && jogoDAvelha[1][1] == "o" && jogoDAvelha[2][2] == "o"
						|| jogoDAvelha[0][2] == "o" && jogoDAvelha[1][1] == "o" && jogoDAvelha[2][0] == "o") {
					para = 1;
				}
				else if(contador==9) {
				para=3;
		}
		return para;
	}
}