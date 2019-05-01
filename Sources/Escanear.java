import java.io.*;
import java.util.*;

class Escanear {
	//private Armazenamento arm = new Armazenamento();
	public void lerArq(Scanner input) {
		int linha = 0;
		while (input.hasNext()) {
			// Variaveis
			String nomeVar;
			String line = input.nextLine(); // Armazenar Linhas
			String tamanhoVetor;
			char [] letras = line.toCharArray(); // tranformar String em char
			System.out.println(line);
			// Fim das varaiveis
			// Descobrir se é uma nova variavel
			if(letras[0] == 'n' && letras[1] == 'e' && letras[2] == 'w' && letras[3] == ' ') { 
				// Zerar as variaveis após a verificação do espaço
				line = line.replaceAll("\\s+", ""); // Remover espaços da linha
				letras = line.toCharArray(); // Tranformar novamente agora sem espaços
				// pegar o ultimo char e ve se ter ;
				System.out.println(line);
				if(line.charAt(line.length()-1) != ';') {
					System.out.println("[Khronus]: Erro de Syntaxe. [Linha " + linha + "]"); // ajeitar
					break;
				}
				// Variaveis inteiras
				int temTipo = 0;
				int j = 3;
				StringBuilder bufferLinha =  new StringBuilder();
				// fim
				// Variavel Float
				if(letras[3] == 'F' && letras[4] == 'l' && letras[5] == 'o' && letras[6] == 'a' && letras[7] == 't' && letras[8] == ':') { 
					temTipo = 2;
					j = 9;
				}
				// booleano
				if(letras[3] == 'b' && letras[4] == 'o' && letras[5] == 'o' && letras[6] == 'l' && letras[7] == ':') { 
					temTipo = 3;
					j = 8;
				}
				// não é definido após = 
				if(temTipo == 0) {
					// definir string/vetor
					while(letras[j] != ';') { 
						// achamos um vetor ou string
						if(letras[j] == '[' && temTipo == 0) {
							temTipo = 4;
							nomeVar = bufferLinha.toString(); // achemos o nome da variavel
							bufferLinha.delete(0, bufferLinha.length()); // apgar
							// armazenar tamanho do vetor
							while(letras[j] != ']') {
								// verificar se é numero
								if(Character.isDigit(letras[j]) == true) {
									System.out.println("[Khronus]: Erro de Syntaxe. [Linha " + linha + "]");
									break;
								}
								bufferLinha.append(letras[j]);
								j++;
							}
							tamanhoVetor = bufferLinha.toString(); // achemos o nome da variavel
							bufferLinha.delete(0, bufferLinha.length()); // apgar
						}
						if(letras[j] == '=') {
							if(temTipo == 0) { // é inteiro
								temTipo = 1;
							}
							nomeVar = bufferLinha.toString();
						}
						bufferLinha.append(letras[j]);
						j++;
					}
					// bufferLinha contém o valor da variavel
					if(temTipo == 1){ // inteiro

					}
					else if(temTipo == 2) { // float

					}
					else if(temTipo == 3) { // bool

					}
					else if(temTipo == 4) { // string/vetor

					}
				}
			}
			linha++;
		}
	}
}