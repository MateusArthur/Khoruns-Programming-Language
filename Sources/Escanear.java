import java.io.*;
import java.util.*;

class Escanear {
	public void lerArq(Scanner input) {
		while (input.hasNext()) {
			// Nome para a variavel inteiro
			String line = input.nextLine();
			line = line.replaceAll("\\s+", "");
			char [] letras = line.toCharArray();
			if(letras[0] == 'n' && letras[1] == 'e' && letras[2] == 'w') {
				int j = 3;
				String x;
				StringBuilder sb =  new StringBuilder();
				while(letras[j] != '=') {
					sb.append(letras[j]);
					j++;
				}
				x = sb.toString	();
				System.out.println("Inteiro variavel: " + x);
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