import java.io.*;
import java.util.*;

class Escanear {
	// Instâncias
	private Armazenamento arm = new Armazenamento();
	private Funcoes fc = new Funcoes();
	private Atribuir atribuir = new Atribuir();
	
	// Interpretador
	public void lerArq(Scanner input) {
		int linha = 0;
		while (input.hasNext()) {
			// Variaveis
			String nomeVar = "";
			String line = input.nextLine(); // Armazenar Linhas
			char [] letras = line.toCharArray(); // tranformar String em char
			String conteudoVar = "";
			StringBuilder bufferLinha =  new StringBuilder();
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
					// achamos um vetor ou string
					if(letras[j] == '[' && temTipo == 0) {
						temTipo = 4;
						nomeVar = bufferLinha.toString(); // achemos o nome da variavel
						if(!fc.palavraValida(nomeVar)) {
							System.out.println("[Khronus]: Erro atribuição de nome da variavel inválido. [Linha " + linha + "]"); // ajeitar
							break;
						}
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
						if(!fc.palavraValida(nomeVar)) {
							System.out.println("[Khronus]: Erro atribuição de nome da variavel inválido. [Linha " + linha + "]"); // ajeitar
							break;
						}
						bufferLinha.delete(0, bufferLinha.length()); // apagar
					}
					else // para não adicionar o igual
						bufferLinha.append(letras[j]);
					if(j == line.length()-2 && nomeVar == "") { // case: não ter igual
						if(temTipo == 0) // se não tiver igual e achou ";" definir como inteiro
							temTipo = 1;
						nomeVar = bufferLinha.toString(); // achamos o nome da variavel
						if(!fc.palavraValida(nomeVar)) {
							System.out.println("[Khronus]: Erro atribuição de nome da variavel inválido. [Linha " + linha + "]"); // ajeitar
							break;
						}
						bufferLinha.delete(0, bufferLinha.length()); // apagar
					}
					j++;
				}
				// bufferLinha contém o valor da variavel
				if(conteudoVar == "")
					conteudoVar = bufferLinha.toString();  
				if(temTipo == 1){ // inteiro
	                int conteudo = Integer.parseInt(conteudoVar);
                	arm.setInteiro(nomeVar, conteudo);
				}
				else if(temTipo == 2) { // float
					double conteudo = Double.parseDouble(conteudoVar);
					arm.setFloat(nomeVar, conteudo);
				}
				else if(temTipo == 3) { // bool
					System.out.println("Achamos um bool " + nomeVar + conteudoVar);
				}
				else if(temTipo == 4) { // string/vetor
					// 
					System.out.println("Achamos uma string " + conteudoVar);
				}
				else if(temTipo == 0) { // tipo indefinido
					System.out.println("[Khronus]: Variavel sem atribuição de valor. [Linha " + linha + "]");
					break;
				}
			}
			else if(letras[0] == 'e' && letras[1] == 'l' && letras[2] == 's'  &&  letras[3] == 'e' && letras[4] == ' ') {
					
			}
			else {
				line = line.replaceAll("\\s+", ""); // Remover espaços da linha
				letras = line.toCharArray(); // Tranformar novamente agora sem espaços
				if(letras[0] == 'p' && letras[1] == 'u' && letras[2] == 'b' && letras[3] == 'l' && letras[4] == 'i' && letras[5] == 'c' && letras[6] == '(') {
					int x = 8;
					while(letras[x] != ')')	{
						bufferLinha.append(letras[x]);
						x++;
					}
					nomeVar = bufferLinha.toString(); // achamos o nome da variavel
					if(!fc.palavraValida(nomeVar)) {
						System.out.println("[Khronus]: Erro atribuição de nome da função inválida. [Linha " + linha + "]"); // ajeitar
						break;
					}
					bufferLinha.delete(0, bufferLinha.length());
					//Fim primeira parte da public, adicionar a linha da public para saber a posição que começa e termina
				}
				else if(letras[0] == 'i' && letras[1] == 'f' && letras[2] == '(') {
					int x = 3;
					while(letras[x] != ')') {
						bufferLinha.append(letras[x]);
						x++;
					}
					nomeVar = bufferLinha.toString();
					if(!fc.palavraValida(nomeVar)) {
						System.out.println("[Khronus]: Erro atribuição de nome da função inválida. [Linha " + linha + "]"); // ajeitar
						break;
					}
					bufferLinha.delete(0, bufferLinha.length());
				}
				else if(letras[0] == 'e' && letras[1] == 'l' && letras[2] == 's' &&  letras[3] == 'e'  &&  letras[4] == ' '  &&  letras[5] == 'i'  &&  letras[6] == 'f'  &&  letras[7] == '(') {
					int x = 8;
					while(letras[x] != ')') {
						bufferLinha.append(letras[x]);
						x++;
					}
					nomeVar = bufferLinha.toString();
					if(!fc.palavraValida(nomeVar)) {
						System.out.println("[Khronus]: Erro atribuição de nome da função inválida. [Linha " + linha + "]"); // ajeitar
						break;
					}
					bufferLinha.delete(0, bufferLinha.length());			
				}
				else if(letras[0] == 'f' && letras[1] == 'o' && letras[2] == 'r' && letras[4] == '(') {
					if(letras[5] == 'n' && letras[6] == 'e' && letras[7] == 'w') {
						int j = 8;
						while(letras[j] != ';') {
							if(letras[j] == '=') {
								nomeVar = bufferLinha.toString();
								if(!fc.palavraValida(nomeVar)) {
									System.out.println("[Khronus]: Erro atribuição de nome da variavel inválido. [Linha " + linha + "]");
									break;
								}
								bufferLinha.delete(0, bufferLinha.length());
							}
							bufferLinha.append(letras[j]);
							j++;
						}
						// Verificar se variavel existe se não apresenta erro, faltar fazer a classe
						if(nomeVar == "") {
							nomeVar = bufferLinha.toString();
							if(!fc.palavraValida(nomeVar)) {
								System.out.println("[Khronus]: Erro atribuição de nome da variavel inválido. [Linha " + linha + "]");
								break;
							}
							bufferLinha.delete(0, bufferLinha.length());
						}
					} // verificar se a variavel ja foi instânciada
					else {
						
					}
				}
				else if(letras[0] == 'p' && letras[1] == 'r' && letras[2] == 'i' && letras[3] == 'n' && letras[4] == 't' && letras[5] == '(') {
					// Verificar se é um texto ou var
					// print funcionara da seguinte maneira: print("Inteiro: %d or %i, Float: %f, String: %s", int, float, string);
					if(letras[6] == '"') {
						int j = 7;
						while(letras[j] != '"') {
							if(letras[j] == '%' && letras[j+1] == 'd' || letras[j] == '%' && letras[j+1] == 'i') {
								bufferLinha.append("s");
								j++;
							}
							else if(letras[j] == '%' && letras[j+1] == 'f') {

							}
							else if(letras[j] == '%' && letras[j+1] == 's') {

							}
							else
								bufferLinha.append(letras[j]);
							j++;
						}
						System.out.println(bufferLinha.toString());
						bufferLinha.delete(0, bufferLinha.length());
					}
					else {

					}
				}
				else {
					System.out.println("[Khronus]: Erro de syntaxe. [Linha " + linha + "].");
				}
			}
			linha++;
		
		}
	}
	
	public Inteiro getArmazenamento(String nome){
		if(this.arm.getInteiro(nome) != null){
			return this.arm.getInteiro(nome);
		}
		else{
			System.out.println("[Khronus]: Erro, a Variavel " + nome + ", não existe.");
		}
		return null;
	}
}
