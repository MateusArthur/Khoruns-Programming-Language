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
		outerloop:
		while (input.hasNext()) {
			// Variaveis
			String nomeVar = "";
			//System.out.println(input.nextLine());
			String line = input.nextLine(); // Armazenar Linhas
			char [] letras = line.toCharArray(); // tranformar String em char
			String conteudoVar = "";
			StringBuilder bufferLinha =  new StringBuilder();
			// Fim das varaiveis
			// Descobrir se é uma nova variavel
			if(line.length() != 0)
			{
				if(letras[0] == 'n' && letras[1] == 'e' && letras[2] == 'w' && letras[3] == ' ') {
					// Zerar as variaveis após a verificação do espaço
					line = line.replaceAll("\\s+", ""); // Remover espaços da linha
					letras = line.toCharArray(); // Tranformar novamente agora sem espaços
					// pegar o ultimo char e ve se ter ;
					if(line.charAt(line.length()-1) != ';') {
						System.out.println("[Khronus]: Erro de Syntaxe. [Linha " + linha + "]"); // ajeitar
						break outerloop;
					}
					int j = 3;
					while(letras[j] != ';') {
						if(letras[j] == '=') {
							nomeVar = bufferLinha.toString(); // achamos o nome da variavel
							if(!fc.palavraValida(nomeVar)) {
								System.out.println("[Khronus]: Erro atribuição de nome da variavel inválido. [Linha " + linha + "]"); // ajeitar
								return;
							}
							bufferLinha.delete(0, bufferLinha.length()); // apagar
						}
						else // para não adicionar o igual
							bufferLinha.append(letras[j]);
						if(j == line.length()-2 && nomeVar == "") { // case: não ter igual
							nomeVar = bufferLinha.toString(); // achamos o nome da variavel
							if(!fc.palavraValida(nomeVar)) {
								System.out.println("[Khronus]: Erro atribuição de nome da variavel inválido. [Linha " + linha + "]"); // ajeitar
								break outerloop;
							}
							bufferLinha.delete(0, bufferLinha.length()); // apagar
						}
						j++;
					}
					// bufferLinha contém o valor da variavel
					if(conteudoVar == "")
						conteudoVar = "0";
		            int conteudo = Integer.parseInt(conteudoVar);
	                arm.setInteiro(nomeVar, conteudo);
				}

				else if(letras[0] == 'e' && letras[1] == 'l' && letras[2] == 's'  &&  letras[3] == 'e' && letras[4] == ' ') {

				}
				else {
					char [] armLetras = line.toCharArray();
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
							break outerloop;
						}
						bufferLinha.delete(0, bufferLinha.length());
						//Fim primeira parte da public, adicionar a linha da public para saber a posição que começa e termina
					}
					else if(letras[0] == 'i' && letras[1] == 'f' && letras[2] == '(') {
						int x = 3;
						String nomeVar2 = "";
						int operador = 0;
						int vetorDeCondi[] = new int[10];
						vetorDeCondi = fc.iniciarVetor(vetorDeCondi);
						while(letras[x] != ')') {
							if(nomeVar == "") {
								if(letras[x] == '=' && letras[x+1] == '=') {
									nomeVar = bufferLinha.toString();
									if(getArmazenamento(nomeVar) == null) {
										break outerloop;
									}
									operador = 1;
									bufferLinha.delete(0, bufferLinha.length());
									x+=2;
								}
								else if(letras[x] == '!' && letras[x+1] == '=') {
									nomeVar = bufferLinha.toString();
									if(getArmazenamento(nomeVar) == null) {
										break outerloop;
									}
									operador = 2;
									bufferLinha.delete(0, bufferLinha.length());
									x+=2;
								}
								else if(letras[x] == '>' && letras[x+1] == '=') {
									nomeVar = bufferLinha.toString();
									if(getArmazenamento(nomeVar) == null) {
										break outerloop;
									}
									operador = 3;
									bufferLinha.delete(0, bufferLinha.length());
									x+=2;
								}
								else if(letras[x] == '<' && letras[x+1] == '=') {
									nomeVar = bufferLinha.toString();
									if(getArmazenamento(nomeVar) == null) {
										break outerloop;
									}
									operador = 4;
									bufferLinha.delete(0, bufferLinha.length());
									x+=2;
								}
								else if(letras[x] == '>') {
									nomeVar = bufferLinha.toString();
									if(getArmazenamento(nomeVar) == null) {
										break outerloop;
									}
									operador = 5;
									bufferLinha.delete(0, bufferLinha.length());
									x+=2;
								}
								else if(letras[x] == '<') {
									nomeVar = bufferLinha.toString();
									if(getArmazenamento(nomeVar) == null) {
										break outerloop;
									}
									operador = 6;
									bufferLinha.delete(0, bufferLinha.length());
									x+=2;
								}
								bufferLinha.append(letras[x]);
								x++;
							}
							else {
								if(letras[x] == '&' && letras[x+1] == '&') {
									if(operador == 1) {
										nomeVar2 = bufferLinha.toString();
										if(getArmazenamento(nomeVar2) == null) {
											break outerloop;
										}
										if(getArmazenamentoCont(nomeVar) == getArmazenamentoCont(nomeVar2)) {
											int pos = fc.posicaoLivre(vetorDeCondi);
											if(pos != -1) {
												vetorDeCondi[pos] = 1; // condicao aceita
											}
											else {
												System.out.println("[Khronus] Erro voce ultrapassou o máximo de comparacoes possiveis. [Linha " + linha + "]");
												break outerloop;
											}
										}
										else {
											int pos = fc.posicaoLivre(vetorDeCondi);
											if(pos != -1) {
												vetorDeCondi[pos] = 0; // condicao negada
											}
											else {
												System.out.println("[Khronus] Erro voce ultrapassou o máximo de comparacoes possiveis. [Linha " + linha + "]");
											}
										}
									}
									else if(operador == 2) {
										nomeVar2 = bufferLinha.toString();
										if(getArmazenamento(nomeVar2) == null) {
											break outerloop;
										}
										if(getArmazenamentoCont(nomeVar) != getArmazenamentoCont(nomeVar2)) {
											int pos = fc.posicaoLivre(vetorDeCondi);
											if(pos != -1) {
												vetorDeCondi[pos] = 1; // condicao aceita
											}
											else {
												System.out.println("[Khronus] Erro voce ultrapassou o máximo de comparacoes possiveis. [Linha " + linha + "]");
												break outerloop;
											}
										}
										else {
											int pos = fc.posicaoLivre(vetorDeCondi);
											if(pos != -1) {
												vetorDeCondi[pos] = 0; // condicao negada
											}
											else {
												System.out.println("[Khronus] Erro voce ultrapassou o máximo de comparacoes possiveis. [Linha " + linha + "]");
											}
										}
									}
									else if(operador == 3) {
										nomeVar2 = bufferLinha.toString();
										if(getArmazenamento(nomeVar2) == null) {
											break outerloop;
										}
										if(getArmazenamentoCont(nomeVar) >= getArmazenamentoCont(nomeVar2)) {
											int pos = fc.posicaoLivre(vetorDeCondi);
											if(pos != -1) {
												vetorDeCondi[pos] = 1; // condicao aceita
											}
											else {
												System.out.println("[Khronus] Erro voce ultrapassou o máximo de comparacoes possiveis. [Linha " + linha + "]");
												break outerloop;
											}
										}
										else {
											int pos = fc.posicaoLivre(vetorDeCondi);
											if(pos != -1) {
												vetorDeCondi[pos] = 0; // condicao negada
											}
											else {
												System.out.println("[Khronus] Erro voce ultrapassou o máximo de comparacoes possiveis. [Linha " + linha + "]");
											}
										}
									}
									else if(operador == 4) {
										nomeVar2 = bufferLinha.toString();
										if(getArmazenamento(nomeVar2) == null) {
											break outerloop;
										}
										if(getArmazenamentoCont(nomeVar) <= getArmazenamentoCont(nomeVar2)) {
											int pos = fc.posicaoLivre(vetorDeCondi);
											if(pos != -1) {
												vetorDeCondi[pos] = 1; // condicao aceita
											}
											else {
												System.out.println("[Khronus] Erro voce ultrapassou o máximo de comparacoes possiveis. [Linha " + linha + "]");
												break outerloop;
											}
										}
										else {
											int pos = fc.posicaoLivre(vetorDeCondi);
											if(pos != -1) {
												vetorDeCondi[pos] = 0; // condicao negada
											}
											else {
												System.out.println("[Khronus] Erro voce ultrapassou o máximo de comparacoes possiveis. [Linha " + linha + "]");
											}
										}
									}
									else if(operador == 5) {
										nomeVar2 = bufferLinha.toString();
										if(getArmazenamento(nomeVar2) == null) {
											break outerloop;
										}
										if(getArmazenamentoCont(nomeVar) > getArmazenamentoCont(nomeVar2)) {
											int pos = fc.posicaoLivre(vetorDeCondi);
											if(pos != -1) {
												vetorDeCondi[pos] = 1; // condicao aceita
											}
											else {
												System.out.println("[Khronus] Erro voce ultrapassou o máximo de comparacoes possiveis. [Linha " + linha + "]");
												break outerloop;
											}
										}
										else {
											int pos = fc.posicaoLivre(vetorDeCondi);
											if(pos != -1) {
												vetorDeCondi[pos] = 0; // condicao negada
											}
											else {
												System.out.println("[Khronus] Erro voce ultrapassou o máximo de comparacoes possiveis. [Linha " + linha + "]");
											}
										}
									}
									else if(operador == 6) {
										nomeVar2 = bufferLinha.toString();
										if(getArmazenamento(nomeVar2) == null) {
											break outerloop;
										}
										if(getArmazenamentoCont(nomeVar) > getArmazenamentoCont(nomeVar2)) {
											int pos = fc.posicaoLivre(vetorDeCondi);
											if(pos != -1) {
												vetorDeCondi[pos] = 1; // condicao aceita
											}
											else {
												System.out.println("[Khronus] Erro voce ultrapassou o máximo de comparacoes possiveis. [Linha " + linha + "]");
												break outerloop;
											}
										}
										else {
											int pos = fc.posicaoLivre(vetorDeCondi);
											if(pos != -1) {
												vetorDeCondi[pos] = 0; // condicao negada
											}
											else {
												System.out.println("[Khronus] Erro voce ultrapassou o máximo de comparacoes possiveis. [Linha " + linha + "]");
											}
										}
									}
									bufferLinha.delete(0, bufferLinha.length());
									x++;
								}
								else if(letras[x] == '|' && letras[x+1] == '|') {
									if(fc.vetorIniciado(vetorDeCondi))
										fc.limparVetor(vetorDeCondi);
									if(operador == 1) {
										nomeVar2 = bufferLinha.toString();
										if(getArmazenamento(nomeVar2) == null) {
												break outerloop;
										}
										if(getArmazenamentoCont(nomeVar) == getArmazenamentoCont(nomeVar2)) {

										}
									}
									else if(operador == 2) {
										nomeVar2 = bufferLinha.toString();
										if(getArmazenamento(nomeVar2) == null) {
												break outerloop;
										}
										if(getArmazenamentoCont(nomeVar) != getArmazenamentoCont(nomeVar2)) {

										}
									}
									if(operador == 3) {
										nomeVar2 = bufferLinha.toString();
										if(getArmazenamento(nomeVar2) == null) {
												break outerloop;
										}
										if(getArmazenamentoCont(nomeVar) >= getArmazenamentoCont(nomeVar2)) {

										}
									}
									if(operador == 4) {
										nomeVar2 = bufferLinha.toString();
										if(getArmazenamento(nomeVar2) == null) {
												break outerloop;
										}
										if(getArmazenamentoCont(nomeVar) <= getArmazenamentoCont(nomeVar2)) {

										}
									}
									if(operador == 5) {
										nomeVar2 = bufferLinha.toString();
										if(getArmazenamento(nomeVar2) == null) {
												break outerloop;
										}
										if(getArmazenamentoCont(nomeVar) > getArmazenamentoCont(nomeVar2)) {

										}
									}
									if(operador == 6) {
										nomeVar2 = bufferLinha.toString();
										if(getArmazenamento(nomeVar2) == null) {
												break outerloop;
										}
										if(getArmazenamentoCont(nomeVar) < getArmazenamentoCont(nomeVar2)) {

										}
									}
								}
								else if(letras[x+1] == ')') {

									if(operador == 1) {
										nomeVar2 = bufferLinha.toString();
										if(getArmazenamento(nomeVar2) == null) {
												break outerloop;
										}
										if(getArmazenamentoCont(nomeVar) == getArmazenamentoCont(nomeVar2)) {

										}
									}
									else if(operador == 2) {
										nomeVar2 = bufferLinha.toString();
										if(getArmazenamento(nomeVar2) == null) {
												break outerloop;
										}
										if(getArmazenamentoCont(nomeVar) != getArmazenamentoCont(nomeVar2)) {

										}
									}
									if(operador == 3) {
										nomeVar2 = bufferLinha.toString();
										if(getArmazenamento(nomeVar2) == null) {
												break outerloop;
										}
										if(getArmazenamentoCont(nomeVar) >= getArmazenamentoCont(nomeVar2)) {

										}
									}
									if(operador == 4) {
										nomeVar2 = bufferLinha.toString();
										if(getArmazenamento(nomeVar2) == null) {
												break outerloop;
										}
										if(getArmazenamentoCont(nomeVar) <= getArmazenamentoCont(nomeVar2)) {

										}
									}
									if(operador == 5) {
										nomeVar2 = bufferLinha.toString();
										if(getArmazenamento(nomeVar2) == null) {
												break outerloop;
										}
										if(getArmazenamentoCont(nomeVar) > getArmazenamentoCont(nomeVar2)) {

										}
									}
									if(operador == 6) {
										nomeVar2 = bufferLinha.toString();
										if(getArmazenamento(nomeVar2) == null) {
												break outerloop;
										}
										if(getArmazenamentoCont(nomeVar) < getArmazenamentoCont(nomeVar2)) {

										}
									}
								}
								bufferLinha.append(letras[x]);
								x++;
							}
						}
						nomeVar = bufferLinha.toString();
						if(!fc.palavraValida(nomeVar)) {
							System.out.println("[Khronus]: Erro atribuição de nome da função inválida. [Linha " + linha + "]"); // ajeitar
							break outerloop;
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
							break outerloop;
						}
						bufferLinha.delete(0, bufferLinha.length());
					}
					else if(letras[0] == 'w' && letras[1] == 'h' && letras[2] == 'i' && letras[3] == 'l' && letras[4] == 'e' && letras[5] == '(') {
						int j = 6;
						while(!fc.operadoresValidos(letras[j])) {
							bufferLinha.append(letras[j]);
							j++;
						}
						String armazenaVar = bufferLinha.toString();	
						int var1 = getArmazenamentoCont(armazenaVar);
						System.out.println(var1);
					}
					else if(letras[0] == 'p' && letras[1] == 'r' && letras[2] == 'i' && letras[3] == 'n' && letras[4] == 't' && letras[5] == '(') {
						bufferLinha.delete(0, bufferLinha.length());
						Print imprimir = new Print();
						int x = 0;

						while(letras[x] != '(')
							x++;
						x++;
						if(letras[x] != '"')
						{
							while(letras[x] != ')') {
								bufferLinha.append(letras[x]);
								x++;
							}
							String armazenaVar = bufferLinha.toString();
							imprimir.printarNaTelaStringInteiro("", this.arm.getInteiro(armazenaVar));
						}
						else {
							int j = 0;
							while(armLetras[j] != '"')
								j++;

							if(armLetras[j] == '"')
							{
								j++;
								while(armLetras[j] != '"'){
										bufferLinha.append(armLetras[j]);
										j++;
								}

								String armazenaString = bufferLinha.toString();
								bufferLinha.delete(0, bufferLinha.length());
								j = x; // economizar loops
								while(letras[j] != ',') {
									j++;
									if(letras[j] == ')')
										break;
								}
								if(letras[j] == ','){
										j ++;
										while(letras[j] != ')'){
											bufferLinha.append(letras[j]);
											j++;
										}
										String armazenaVar = bufferLinha.toString();
										imprimir.printarNaTelaStringInteiro(armazenaString, this.arm.getInteiro(armazenaVar));

								}
								else {
									imprimir.printarNaTelaString(armazenaString);
								}
							}
						}
						bufferLinha.delete(0, bufferLinha.length());
					}

					else {
						Inteiro pegarInteiro = new Inteiro();
						//Atribuicao de valores
						int j = 0;
						int op = 0;
						bufferLinha.delete(0, bufferLinha.length());
						while(1 > 0){
							if(letras[j] == '=') {
								op = 1;
								break;
							}
							else if(letras[j] == '+' && letras[j+1] == '+') {
								op = 2;
								j++;
								break;
							}
							else if(letras[j] == '-' && letras[j+1] == '-') {
								op = 3;
								j++;
								break;
							}
							else if(letras[j] == '+' && letras[j+1] == '=') {
								op = 4;
								j++;
								break;
							}
							else if(letras[j] == '-' && letras[j+1] == '=') {
								op = 5;
								j++;
								break;
							}

							bufferLinha.append(letras[j]);
							j++;
						}
						nomeVar = bufferLinha.toString();
						pegarInteiro = getArmazenamento(nomeVar);
						bufferLinha.delete(0, bufferLinha.length());
						String conteudoVar2 = "";
						String operador = "";
						j++;
						while(letras[j] != ';') {
							if(letras[j] == '+' || letras[j] == '-' || letras[j] == '/' || letras[j] == '*') {
								conteudoVar2 = bufferLinha.toString();
								bufferLinha.delete(0, bufferLinha.length());
								operador = ""+letras[j];
								j++;
							}
							bufferLinha.append(letras[j]);
							j++;
						}
						conteudoVar = bufferLinha.toString();
						System.out.println(conteudoVar2);
						System.out.println(operador);
						System.out.println(conteudoVar);
						if(op == 1) {
							int conteudo;
							if(conteudoVar2 != null)
								conteudo = 2;
								//conteudo = exp.calcula(conteudoVar2, conteudoVar, operador);
							else 
								conteudo = Integer.parseInt(conteudoVar);
		          			atribuir.atribuiVarInt(pegarInteiro, conteudo);
						}
						else if(op == 2) {
							atribuir.incrementaVar(pegarInteiro);
						}
						else if(op == 3) {
							atribuir.decrementaVar(pegarInteiro);
						}
						else if(op == 4) {
							int conteudo = Integer.parseInt(conteudoVar);
							atribuir.addVar(pegarInteiro, conteudo);
						}
						else if(op == 5) {
							int conteudo = Integer.parseInt(conteudoVar);
							conteudo = conteudo * -1;
							atribuir.addVar(pegarInteiro, conteudo);
						}
					}
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

	public int getArmazenamentoCont(String nome){
		if(this.arm.getInteiro(nome) != null){
			Inteiro aux = new Inteiro();
			aux = this.arm.getInteiro(nome);
			int a = aux.getConteudo();
			return a;
		}
		else{
			System.out.println("[Khronus]: Erro, a Variavel " + nome + ", não existe.");
		}
		return 0;
	}
}
