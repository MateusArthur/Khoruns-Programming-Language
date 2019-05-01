import java.io.*;
import java.util.*;

class Escanear {
	/*
	public void lerArq(Scanner input) {
		int linha = 0;
		while (input.hasNext()) {
			String line = input.nextLine();
	    line = line.replaceAll("\\s+","");
	    char [] letras = line.toCharArray();
			// Descobrir se é uma nova variavel
			if(letras[0] == 'n' && letras[1] == 'e' && letras[2] == 'w') {
				// pegar o ultimo char e ve se ter ;
				if(line.charAt(line.length()-1) != ';') {
					System.out.println("[Khronus]: Erro de Syntaxe. [Linha " + linha + "]"); // ajeitar
					break;
				}
				boolean temTipo = false;
				int j = 3;
				StringBuilder variavel =  new StringBuilder();
				// PEGAR O "NOME" DA VARIAVEL INT
				if(letras[4] == 'i' && letras[5] == 'n' && letras[6] == 't' && letras[7] == ':') {
					j = 3;
					String armazenaVar;
					StringBuilder sb = new StringBuilder();
					while (letras[j] != '=') {
						sb.append(letras[j]);
						j++;
					}
					armazenaVar = sb.toString();

					//PEGAR VALOR DA VARIAVEL "INT"
					String armazenaInt;
					StringBuilder si = new StringBuilder();
					while (letras[j] != ';') {
						si.append(letras[j]);
						j++;
					}
					armazenaInt = si.toString();
					int i = Integer.parseInt(armazenaInt);

					//***
					temTipo = true;
					j = 8;
					//***
				
					setInteiro(armazenaVar, i);
				}

				// booleano
				if(letras[4] == 'b' && letras[5] == 'o' && letras[6] == 'o' && letras[7] == 'l' && letras[8] == ':') {
					temTipo = true;
					j = 8;
				}
				// não é definido após =
				if(temTipo == false) {
					// definir string/vetor
					while(letras[j] != ';') {
						// achamos um vetor
						if(letras[j] == '[' && temTipo == false) {
							temTipo = true;
							int x = j;
							String tVet;
							// armazenar tamanho do vetor
							while(letras[j] != ']') {
								// verificar se é numero
								if(Character.isDigit(letras[x]) == true) {
									System.out.println("[Khronus]: Erro de Syntaxe. [Linha " + linha + "]");
									break;
								}
								variavel.append(letras[x]);
								j++;
							}
						}
						// achamos um tipo
						if(letras[j] == '=' && temTipo == false) {
							temTipo = true;

							// tem que implementar
						}
						variavel.append(letras[j]);
						j++;
					}
				}
				System.out.println("%s" + variavel);
			}
			linha++;
		}
	}
	*/
}
