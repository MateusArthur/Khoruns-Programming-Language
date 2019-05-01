import java.io.File;
import java.util.Scanner;

class Main{
	public static void print(String texto){
		System.out.println(texto);
	}
	public static void main(String[] args){
		try {
			File Arquivo = new File("teste.kh");
			Scanner input = new Scanner(Arquivo);
			Escanear scan = new Escanear();

			scan.lerArq(input);
			input.close();

		} catch (Exception e) {
			print("[Khronus Erro]: Não foi possível abrir o arquivo teste.kh");
			e.printStackTrace();
		}
	}
}
