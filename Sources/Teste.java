import java.io.*;
import java.util.*;

class Teste{
	private Armazenamento arm = new Armazenamento();
	
	public void lerArq(Scanner input) {
		//Armazena o nome e o conteudo da variavel no arquivo .kh.
		String nomeVar;
		String conteudoVar;
		
		//Classe que trata uma string como um vetor.
		StringBuilder sb = new StringBuilder();

		//Le uma linha do arquivo .kh.
		while (input.hasNext()) {
			String linha = input.nextLine();
	 
	    	//Remove os espacos presentes na linha.
			linha = linha.replaceAll("\\s+","");
			
			char[] letras = linha.toCharArray();

	    	//Verifica se a operacao na linha cria uma variavel.
			if(letras[0] == 'n' && letras[1] == 'e' && letras[2] == 'w'){
			
				//Verifica se no fim da linha há um ponto e virgula se nao retorna um erro.
				if(linha.charAt(linha.length()-1) != ';') {
					System.out.println("[Khronus]: Erro de Syntaxe. [Linha " + "LINHA TAL IFORMAR" + "]");
					break;
				}

				//Verifica se a variavel é um inteiro.
                if(letras[3] == 'i' && letras[4] == 'n' && letras[5] == 't' && letras[6] == ':') {
     				
     				System.out.println("estou aqui");

                	//Captura o nome da variavel dada no arquivo .kh.
                    int i = 7;
                    while (letras[i] != '=') {
                        sb.append(letras[i]);
                        i++;
                    }

                    //Transforma o vetor de caracters sb em uma string e armazena em nomeVar.
                    nomeVar = sb.toString();

                    //exclui os valores presentes no sb.
                    sb.delete(0, sb.length());

                    //Captura o valor atribuido a variavel no arquivo .kh.
                    i++;
                    while (letras[i] != ';') {
                        sb.append(letras[i]);
                        i++;
                    }
					
					//Transforma o vetor de caracters sb em uma string e armazena em conteudoVar.
                    conteudoVar = sb.toString();

                    System.out.println(conteudoVar);                	

                    //variavel para armazenar o valor inteiro capturado no arquivo .kh.
                	int conteudo = Integer.parseInt(conteudoVar);
                
                	//Adiciona a variavel ao armazenamento.
                	arm.setInteiro(nomeVar, conteudo);
                }
			}
		}
	}

	public Inteiro getArmazenamento(){
		return this.arm.getInteiro();
	}

//Fim da classe.
}
