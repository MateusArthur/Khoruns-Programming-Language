import java.io.*;
import java.util.*;

class Escanear {
	public void lerArq(Scanner input) {
		while (input.hasNext()) {
			String line = input.nextLine(); // Armazenar Linhas
			line = line.replaceAll("\\s+", ""); // Remover espaços da linha
			char [] letras = line.toCharArray();
			
			// Descobrir se é uma nova variavel
			if(letras[0] == 'n' && letras[1] == 'e' && letras[2] == 'w') { 
				System.out.println("Testando Print");
				boolean temTipo = false;
				int j = 3;
				StringBuilder variavel =  new StringBuilder();
				// Variavel Float
				if(letras[4] == 'F' && letras[5] == 'l' && letras[6] == 'o' && letras[7] == 'a' && letras[8] == 't' && letras[9] == ':') { 
					temTipo = true;
					j = 9;
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
									System.out.println("[Khronus]: Erro de Syntaxe. [Linha %d]" + 0); // ajeitar
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
		}
	}
}