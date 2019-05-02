import java.io.File;
import java.util.Scanner;

class Main{
	public static void print(String texto){
		System.out.println(texto);
	}
	public static void main(String[] args){
		try {
			File arquivo = new File("teste.kh");
			Scanner input = new Scanner(arquivo);
			Escanear scan = new Escanear();
			
			Inteiro inteiros = new Inteiro();

			scan.lerArq(input);
			
			inteiros = scan.getArmazenamento();

			System.out.println("Nome: " + inteiros.getNome()  + " || " +"Valor: " + inteiros.getConteudo());

			input.close();
		
		} catch (Exception erro) {
			print("[Khronus Erro]: Não foi possível abrir o arquivo teste.kh");
			erro.printStackTrace();
		}
	}
}
