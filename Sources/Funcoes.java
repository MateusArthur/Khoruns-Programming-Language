import java.io.*;
import java.util.*;

class Funcoes 
{
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

	public static boolean operadoresValidos(char pal) 
	{
		if(pal == '>' || pal == '<' || pal == '=') 
			return true;
		return false;
	}

	public static void percorrerChaves(Scanner input, int linhas) {
		while(input.hasNext()) {
			String line = input.nextLine();
			line = line.replaceAll("\\s+", ""); // Remover espaços da linha
			char [] letras = line.toCharArray();
			StringBuilder bufferLinha =  new StringBuilder();
			int tamanhoLinha = letras.length-1;
			int chaves = 0;
			if(letras[tamanhoLinha] == '{') {
				chaves++;
			}
			else if(letras[tamanhoLinha] == '}') {
				chaves--;
			}
			if(chaves == 0) {
				break;
			}
			linhas++;
		}
	}
}