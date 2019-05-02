import java.io.*;
import java.util.*;

class Escanear {
	// Instâncias
	private Armazenamento arm = new Armazenamento();
	private Funcoes fc = new Funcoes();
	// Interpretador
	public void lerArq(Scanner input) {
		int linha = 0;
		while (input.hasNext()) {
			// Variaveis
			String nomeVar = "";
			String line = input.nextLine(); // Armazenar Linhas
			String tamanhoVetor;
			char [] letras = line.toCharArray(); // tranformar String em char
			String conteudoVar = "";
			// Fim das varaiveis
			// Descobrir se é uma nova variavel
			if(letras[0] == 'n' && letras[1] == 'e' && letras[2] == 'w' && letras[3] == ' ') { 
				// Zerar as variaveis após a verificação do espaço
				line = line.replaceAll("\\s+", ""); // Remover espaços da linha
				letras = line.toCharArray(); // Tranformar novamente agora sem espaços
				// pegar o ultimo char e ve se ter ;
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
				// definir string/vetor
				while(letras[j] != ';') {
					/*
					Tem que adicionar nos lugares certos
					if(!fc.palavraValida(letras[j])) {
						System.out.println("[Khronus]: Erro atribuição de nome da variavel inválido. [Linha " + linha + "]"); // ajeitar
						break;
					}*/
					// achamos um vetor ou string
					if(letras[j] == '[' && temTipo == 0) {
						temTipo = 4;
						nomeVar = bufferLinha.toString(); // achemos o nome da variavel
						bufferLinha.delete(0, bufferLinha.length()); // apgar
						j++;
						// armazenar tamanho do vetor
						while(letras[j] != ']') {
							// verificar se é numero
							if(Character.isDigit(letras[j]) == false) {
								System.out.println("[Khronus]: Erro de Syntaxe. [Linha " + linha + "]");
								break;
							}
							bufferLinha.append(letras[j]);
							j++;
						}
						conteudoVar = bufferLinha.toString(); // achamos o nome da variavel
						bufferLinha.delete(0, bufferLinha.length()); // apagar
					}
					if(letras[j] == '=') {
						if(temTipo == 0) { // é inteiro
							temTipo = 1;
						}
						nomeVar = bufferLinha.toString(); // achamos o nome da variavel
						bufferLinha.delete(0, bufferLinha.length()); // apagar
					}
					if(letras[j] != '=') // para não adicionar o igual
						bufferLinha.append(letras[j]);
					if(j == line.length()-2 && nomeVar == "") { // case: não ter igual
						if(temTipo == 0) // se não tiver igual e achou ";" definir como inteiro
							temTipo = 1;
						nomeVar = bufferLinha.toString(); // achamos o nome da variavel
						bufferLinha.delete(0, bufferLinha.length()); // apagar
					}
					j++;
				}
				// bufferLinha contém o valor da variavel
				if(conteudoVar == "")
					conteudoVar = bufferLinha.toString();  
				if(temTipo == 1){ // inteiro
	                int conteudo = Integer.parseInt(conteudoVar);
                	//Adiciona a variavel ao armazenamento.
                	arm.setInteiro(nomeVar, conteudo);
				}
				else if(temTipo == 2) { // float
					System.out.println("Achamos um float " + nomeVar + conteudoVar);
				}
				else if(temTipo == 3) { // bool
					System.out.println("Achamos um bool " + nomeVar + conteudoVar);
				}
				else if(temTipo == 4) { // string/vetor
					// tamanhoVetor
					System.out.println("Achamos uma string " + conteudoVar);
				}
				else if(temTipo == 0) { // tipo indefinido
					System.out.println("[Khronus]: Variavel sem atribuição de valor. [Linha " + linha + "]");
					break;
				}
			}
			linha++;
		}
	}
	public Inteiro getArmazenamento(){
		return this.arm.getInteiro();
	}
}