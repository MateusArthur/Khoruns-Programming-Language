import java.io.*;
import java.util.*;

class Escanear {
	public void lerArq(Scanner input) {
		while (input.hasNext()) {
			// Nome para a variavel inteiro
			String line = input.nextLine();
			line = line.replaceAll("\\s+", ""); // Remover espaços da linha
			char [] letras = line.toCharArray();
			// Descobrir se é uma nova variavel
			if(letras[0] == 'n' && letras[1] == 'e' && letras[2] == 'w') { 
				boolean temTipo = false;
				// Variavel Float
				if(letras[4] == 'F' && letras[5] == 'l' && letras[6] == 'o' && letras[7] == 't' && letras[8] == ':') { 
					temTipo = true;
				}
				// booleano
				if(letras[4] == 'b' && letras[5] == 'o' && letras[6] == 'o' && letras[7] == 'l' && letras[8] == ':') { 
					temTipo = true;
				}
				// não é definido após = 
				if(temTipo == false) {
					int j = 3;
					// definir string/vetor
					while(letras[j] != '[') { 
						// armazenar tamanho do vetor
						if(letras[j] == '[') {
							temTipo = true;
							int x = j;
							StringBuilder sx =  new StringBuilder();
							String tVet;
							while(letras[x] != ']') // armazenar tamanho do vetor
							{
								if(Character.isDigit(letras[x]) == true) // verificar se é numero
								{
									System.out.println("[Khronus]: Erro de Syntaxe. [Linha %d]" + 0); // ajeitar
									break;
								}
								sx.append(letras[x]);
								x++;
							}
						}
						j++;
					}
				}
				int j = 3;
				if(temTipo == false) { // se não houver tipo será inteiro ou definido após o =
					String x;
					StringBuilder sb =  new StringBuilder();
					// dar loop para achar o =;
					while(letras[j] != '=') { 
						sb.append(letras[j]);
						j++;
						if(letras[j] == '=') // se tiver o =
							temTipo = true;
					}
					x = sb.toString	();
					System.out.println("Inteiro Variavel: " + x);
				}
				j++;
				String xi;
				StringBuilder sn = new StringBuilder();
				while(letras[j] != ';') {
					sn.append(letras[j]);
					j++;
				}
				xi = sn.toString();
				System.out.println("Inteiro Variavel: " + xi);
			}
		}

	}
}