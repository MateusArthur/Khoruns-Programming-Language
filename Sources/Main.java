import java.io.File;
import java.util.Scanner;

class Main{
	public static void main(String[] args){
		try {
			File arquivo = new File("teste.kh");
			Scanner input = new Scanner(arquivo);
			Escanear scan = new Escanear();


			scan.lerArq(input); // Compilar


			input.close();



		} catch (Exception erro) {
			System.out.println("[Khronus Erro]: Não foi possível abrir o arquivo teste.kh");
			erro.printStackTrace();
		}
	}
}
