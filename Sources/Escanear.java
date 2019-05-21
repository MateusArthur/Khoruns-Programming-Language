import java.io.*;
import java.util.*;

class Escanear {
	// Instâncias
	private Armazenamento arm = new Armazenamento();
	private Atribuir atribuir = new Atribuir();
	private Expressoes exp = new Expressoes();
	//Contador de linhas
	int linha = 0;
	//Armazenar loop
	int contarLoop = 0;
	// Interpretador
	public void lerArq(Scanner input) {
		// Contar Chaves 
		int contChaves = 0;
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
			if(line.length() != 0){
				// Verificar se tem espaco antes do new
				int xx = 0;
				while(1 > 0)
				{
					if(!palavraValida(letras[xx]+"") && letras[xx] != '{' && letras[xx] != '}'){
						xx++;
					}
					else 
						break;
				}
				if(letras[xx] == 'n' && letras[xx+1] == 'e' && letras[xx+2] == 'w' && letras[xx+3] == ' ') {
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
							if(!palavraValida(nomeVar)) {
								System.out.println("[Khronus]: Erro atribuição de nome da variavel inválido. [Linha " + linha + "]"); // ajeitar
								return;
							}
							bufferLinha.delete(0, bufferLinha.length()); // apagar
						}
						else // para não adicionar o igual
							bufferLinha.append(letras[j]);
						if(j == line.length()-2 && nomeVar == "") { // case: não ter igual
							nomeVar = bufferLinha.toString(); // achamos o nome da variavel
							if(!palavraValida(nomeVar)) {
								System.out.println("[Khronus]: Erro atribuição de nome da variavel inválido. [Linha " + linha + "]"); // ajeitar
								break outerloop;
							}
							bufferLinha.delete(0, bufferLinha.length()); // apagar
						}
						conteudoVar = bufferLinha.toString();
						j++;
					}
					if(this.arm.getInteiro(nomeVar) != null) {
						System.out.println("[Khronus]: Erro variavel '"+nomeVar+"' ja foi criada.");
						break outerloop;
					}
					int conteudo = 0;
					if(conteudoVar.equals("input()")) {
						Scanner entrada = new Scanner(System.in);
						conteudo = entrada.nextInt();
					}
					else {
						try{
							conteudo = Integer.parseInt(conteudoVar);
						} catch(Exception erro) {
							if(this.arm.getInteiro(conteudoVar) != null)
								conteudo = getArmazenamentoCont(conteudoVar);
						}
					}
					arm.setInteiro(nomeVar, conteudo);
				}
				else {
					char [] armLetras = line.toCharArray();
					line = line.replaceAll("\\s+", ""); // Remover espaços da linha
					letras = line.toCharArray(); // Tranformar novamente agora sem espaços
					if(letras[0] == 'w' && letras[1] == 'h' && letras[2] == 'i' && letras[3] == 'l' && letras[4] == 'e' && letras[5] == '(') {
						contarLoop++;
						String nomeLoop = "while"+contarLoop+".txt";
						int j = 6;
						int operador = 0;
						String nomeVar2 = "";
						while(letras[j] != ')') {
							if(letras[j] == '=' && letras[j+1] == '=') {
								j+=2;
								operador = 1;
								nomeVar = bufferLinha.toString();
								bufferLinha.delete(0, bufferLinha.length());
							}
							else if(letras[j] == '>' && letras[j+1] == '=') {
								j+=2;
								operador = 2;
								nomeVar = bufferLinha.toString();
								bufferLinha.delete(0, bufferLinha.length());
							}
							else if(letras [j] == '<' && letras[j+1] == '=') {
								j+=2;
								operador = 3;
								nomeVar = bufferLinha.toString();
								bufferLinha.delete(0, bufferLinha.length());
							}
							else if(letras[j] == '!' && letras[j+1] == '=') {
								j+=2;
								operador = 4;
								nomeVar = bufferLinha.toString();
								bufferLinha.delete(0, bufferLinha.length());
							}
							else if(letras[j] == '>') {
								j++;
								operador = 5;
								nomeVar = bufferLinha.toString();
								bufferLinha.delete(0, bufferLinha.length());
							}
							else if(letras[j] == '<') {
								j++;
								operador = 6;
								nomeVar = bufferLinha.toString();
								bufferLinha.delete(0, bufferLinha.length());
							}
							bufferLinha.append(letras[j]);
							j++;
						}
						nomeVar2 = bufferLinha.toString();
						bufferLinha.delete(0, bufferLinha.length());
						int varOne;
						int varTwo;
						if(this.arm.getInteiro(nomeVar) != null)
							varOne = getArmazenamentoCont(nomeVar);
						else
							varOne = Integer.parseInt(nomeVar);

						if(this.arm.getInteiro(nomeVar2) != null)
							varTwo = getArmazenamentoCont(nomeVar2);
						else
							varTwo = Integer.parseInt(nomeVar2); 
						// Armazenar em uma string
						File file = new File(nomeLoop);
					
						try {
							PrintWriter escrever = new PrintWriter(file);
							int chave = -1;
							while(input.hasNext()) {
								String lineIf = input.nextLine(); // Armazenar Linhas
								lineIf = lineIf.replaceAll("\\s+", ""); // Remover espaços da linha
								escrever.println(lineIf);
								char [] lif = lineIf.toCharArray(); // tranformar String em char
								if(chave == -1)
									chave = 0;
								if(lif[0] == '{')
									chave++;
								else if(lif[0] == '}')
									chave--;
								if(chave == 0)
								{
									escrever.close();
									break;
								}
							}
						} catch (FileNotFoundException ex) {
							System.out.println("[Khronus]: Erro na while. [Linha " + linha + "]");
							break outerloop;
						}
						if(operador == 1) {
							while(getArmazenamentoCont(nomeVar) == getArmazenamentoCont(nomeVar2)) {
								try {
									Scanner inputWhile = new Scanner(file);
									lerArq(inputWhile);
								} catch (FileNotFoundException ex) {
									System.out.println("[Khronus]: Erro na while. [Linha " + linha + "]");
									break outerloop;
								}
							}
						}
						else if(operador == 2) {
							while(getArmazenamentoCont(nomeVar) >= getArmazenamentoCont(nomeVar2)) {
								try {
									Scanner inputWhile = new Scanner(file);
									lerArq(inputWhile);
								} catch (FileNotFoundException ex) {
									System.out.println("[Khronus]: Erro na while. [Linha " + linha + "]");
									break outerloop;
								}
							}
						}
						else if(operador == 3) {
							while(getArmazenamentoCont(nomeVar) <= getArmazenamentoCont(nomeVar2)) {
								try {
									Scanner inputWhile = new Scanner(file);
									lerArq(inputWhile);
								} catch (FileNotFoundException ex) {
									System.out.println("[Khronus]: Erro na while. [Linha " + linha + "]");
									break outerloop;
								}
							}
						}
						else if(operador == 4) {
							while(getArmazenamentoCont(nomeVar) != getArmazenamentoCont(nomeVar2)) {
								try {
									Scanner inputWhile = new Scanner(file);
									lerArq(inputWhile);
								} catch (FileNotFoundException ex) {
									System.out.println("[Khronus]: Erro na while. [Linha " + linha + "]");
									break outerloop;
								}
							}
						}
						else if(operador == 5) {
							while(getArmazenamentoCont(nomeVar) > getArmazenamentoCont(nomeVar2)) {
								try {
									Scanner inputWhile = new Scanner(file);
									lerArq(inputWhile);
								} catch (FileNotFoundException ex) {
									System.out.println("[Khronus]: Erro na while. [Linha " + linha + "]");
									break outerloop;
								}
							}
						}
						if(operador == 6) {
							while(getArmazenamentoCont(nomeVar) < getArmazenamentoCont(nomeVar2)) {
								try {
									Scanner inputWhile = new Scanner(file);
									lerArq(inputWhile);
								} catch (FileNotFoundException ex) {
									System.out.println("[Khronus]: Erro na while. [Linha " + linha + "]");
									break outerloop;
								}
							}
						}
						file.delete();
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
					else if(letras[0] == 'i' && letras[1] == 'f' && letras[2] == '(') {
						int x = 3;
						int operador = 0;
						String nomeVar2 = "";
						while(letras[x] != ')') {
							if(letras[x] == '=' && letras[x+1] == '=') {
								x+=2;
								operador = 1;
								nomeVar = bufferLinha.toString();
								bufferLinha.delete(0, bufferLinha.length());
							}
							else if(letras[x] == '>' && letras[x+1] == '=') {
								x+=2;
								operador = 2;
								nomeVar = bufferLinha.toString();
								bufferLinha.delete(0, bufferLinha.length());
							}
							else if(letras[x] == '!' && letras[x+1] == '=') {
								x+=2;
								operador = 3;
								nomeVar = bufferLinha.toString();
								bufferLinha.delete(0, bufferLinha.length());
							}
							else if(letras [x] == '<' && letras[x+1] == '=') {
								x+=2;
								operador = 4;
								nomeVar = bufferLinha.toString();
								bufferLinha.delete(0, bufferLinha.length());
							}
							else if(letras[x] == '>') {
								x++;
								operador = 5;
								nomeVar = bufferLinha.toString();
								bufferLinha.delete(0, bufferLinha.length());
							}
							else if(letras[x] == '<') {
								x++;
								operador = 6;
								nomeVar = bufferLinha.toString();
								bufferLinha.delete(0, bufferLinha.length());
							}
							bufferLinha.append(letras[x]);
							x++;
						}
						nomeVar2 = bufferLinha.toString();
						bufferLinha.delete(0, bufferLinha.length());
						int varOne;
						int varTwo;
						int chave = -1;
						if(this.arm.getInteiro(nomeVar) != null)
							varOne = getArmazenamentoCont(nomeVar);
						else
							varOne = Integer.parseInt(nomeVar);

						if(this.arm.getInteiro(nomeVar2) != null)
							varTwo = getArmazenamentoCont(nomeVar2);
						else
							varTwo = Integer.parseInt(nomeVar2); 

						if(operador == 1) {
							if(varOne != varTwo) {
								while(input.hasNext()) {
									String lineIf = input.nextLine(); // Armazenar Linhas
									lineIf = lineIf.replaceAll("\\s+", ""); // Remover espaços da linha
									char [] lif = lineIf.toCharArray(); // tranformar String em char
									if(chave == -1)
										chave = 0;
									if(lif[0] == '{')
										chave++;
									else if(lif[0] == '}')
										chave--;
									if(chave == 0)
										break;
								}
							}
						}
						else if(operador == 2) {
							if(varOne < varTwo) {
								while(input.hasNext()) {
									String lineIf = input.nextLine(); // Armazenar Linhas
									lineIf = lineIf.replaceAll("\\s+", ""); // Remover espaços da linha
									char [] lif = lineIf.toCharArray(); // tranformar String em char
									if(chave == -1)
										chave = 0;
									if(lif[0] == '{')
										chave++;
									else if(lif[0] == '}')
										chave--;
									if(chave == 0)
										break;
								}
							}
						}
						else if(operador == 3) {
							if(varOne == varTwo) {
								while(input.hasNext()) {
									String lineIf = input.nextLine(); // Armazenar Linhas
									lineIf = lineIf.replaceAll("\\s+", ""); // Remover espaços da linha
									char [] lif = lineIf.toCharArray(); // tranformar String em char
									if(chave == -1)
										chave = 0;
									if(lif[0] == '{')
										chave++;
									else if(lif[0] == '}')
										chave--;
									if(chave == 0)
										break;
								}
							}
						}
						else if(operador == 4) {
							if(varOne > varTwo) {
								while(input.hasNext()) {
									String lineIf = input.nextLine(); // Armazenar Linhas
									lineIf = lineIf.replaceAll("\\s+", ""); // Remover espaços da linha
									char [] lif = lineIf.toCharArray(); // tranformar String em char
									if(chave == -1)
										chave = 0;
									if(lif[0] == '{')
										chave++;
									else if(lif[0] == '}')
										chave--;
									if(chave == 0)
										break;
								}
							}
						}
						else if(operador == 5) {
							if(varOne <= varTwo) {
								while(input.hasNext()) {
									String lineIf = input.nextLine(); // Armazenar Linhas
									lineIf = lineIf.replaceAll("\\s+", ""); // Remover espaços da linha
									char [] lif = lineIf.toCharArray(); // tranformar String em char
									if(chave == -1)
										chave = 0;
									if(lif[0] == '{')
										chave++;
									else if(lif[0] == '}')
										chave--;
									if(chave == 0)
										break;
								}
							}
						}
						else if(operador == 6) {
							if(varOne >= varTwo) {
								while(input.hasNext()) {
									String lineIf = input.nextLine(); // Armazenar Linhas
									lineIf = lineIf.replaceAll("\\s+", ""); // Remover espaços da linha
									char [] lif = lineIf.toCharArray(); // tranformar String em char
									if(chave == -1)
										chave = 0;
									if(lif[0] == '{')
										chave++;
									else if(lif[0] == '}')
										chave--;
									if(chave == 0)
										break;
								}
							}
						}
					}
					else {
						Inteiro pegarInteiro = new Inteiro();
						//Atribuicao de valores
						int j = 0;
						int op = 0;
						if(letras[j] == '{') {
							contChaves++;
						}
						else if(letras[j] == '}') {
							contChaves--;
							if(contChaves == 0) {
								contChaves = -1;
								//Limpar memoria
							}
						}
						else { 
							// Atribuicao de valores sem e com expressoes aritmeticas, Ex: a++; a--; a+=x; a-=x; a=x; a=a*a; a=a/a; etc...
							bufferLinha.delete(0, bufferLinha.length());
							// Esse while verifica qual atribuicao sera feita
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
							// Para verificar se está sendo atribuido uma expressao aritmetica
							boolean confirmaExp = false;

							j++;

							// While para armazenar valor que sera atribuido a variavel nomeVar
							while(letras[j] != ';') {
								// verificar se e uma expressao
								if(letras[j] == '+' || letras[j] == '-' || letras[j] == '/' || letras[j] == '*' || letras[j] == '%') {
									confirmaExp = true;
									conteudoVar2 = bufferLinha.toString();
									bufferLinha.delete(0, bufferLinha.length());
									operador = ""+letras[j];
									j++;
								}
								bufferLinha.append(letras[j]);
								j++;
							}
							conteudoVar = bufferLinha.toString();
							// realiza as atribuicoes
							if(op == 1) {
								int conteudo = 0, oa = 0, ob = 0;
								// encontrou uma expressao aritmetica
								if(confirmaExp){
									try{
										//System.out.println(conteudoVar2);
										oa = Integer.parseInt(conteudoVar2);
									}catch(Exception erro){
										oa = this.arm.getInteiro(conteudoVar2).getConteudo();
									}

									try{
										ob = Integer.parseInt(conteudoVar);
									}catch(Exception erro){
										ob = this.arm.getInteiro(conteudoVar).getConteudo();
									}

									atribuir.atribuiVarInt(pegarInteiro, exp.calcula(oa, ob, operador));

								}
								else {
									try{
										conteudo = Integer.parseInt(conteudoVar);
									} catch(Exception erro){
										conteudo = getArmazenamentoCont(conteudoVar);
									}
									atribuir.atribuiVarInt(pegarInteiro, conteudo);
								}
							}
							else if(op == 2) {
								atribuir.incrementaVar(pegarInteiro);
							}
							else if(op == 3) {
								atribuir.decrementaVar(pegarInteiro);
							}
							else if(op == 4) {
								int conteudo;
								try{
									conteudo = Integer.parseInt(conteudoVar);
								} catch(Exception erro){
									conteudo = getArmazenamentoCont(conteudoVar);
								}
								atribuir.addVar(pegarInteiro, conteudo);
							}
							else if(op == 5) {
								int conteudo;
								try{
									conteudo = Integer.parseInt(conteudoVar);
								} catch(Exception erro){
									conteudo = getArmazenamentoCont(conteudoVar);
								}
								conteudo = conteudo * -1;
								atribuir.addVar(pegarInteiro, conteudo);
							}
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
			System.out.println("[Khronus]: Erro, a Variavel " + nome + ", não existe. [LINHA : " + linha + "]");
		}
		return 0;
	}

	public static boolean palavraValida(String pal) 
	{
		int i = 0;
		while(i < pal.length())
		{
			char x = pal.charAt(i);
			if(x != 'a' && x != 'b' && x != 'c' && x != 'd' && x != 'e' && x != 'f' && x != 'g' && x != 'h' && x != 'i' && x != 'j' && x != 'k' && x != 'l' && x != 'm' && x != 'n' && x != 'o' && x != 'r' && x != 'p' && x != 'q' && x != 't' && x != 'u' && x != 'v' && x != 'w' && x != 'x' && x != 'y' && x != 'z' && x != '_') 
			{	
				return false;
			}
			i++;
		}
		return true;
	}
}
