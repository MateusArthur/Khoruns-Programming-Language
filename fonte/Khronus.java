import java.io.File;
import java.util.Scanner;

class Khronus{
	public static void main(String[] args){
		try {
			File arquivo  = new File(args[0]);
			Scanner input = new Scanner(arquivo);
			Escanear scan = new Escanear();

			scan.lerArq(input);
			input.close();

		} catch (Exception erro) {
			System.out.println("[Khronus Erro]: Não foi possível abrir o arquivo teste.kh");
			erro.printStackTrace();
		}
	}
}
