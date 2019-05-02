//Classe para variaveis do tipo inteiro.
class Inteiro extends Variaveis{
	private int i_Conteudo;

	Inteiro(){
		this.setConteudo(0);
	}


	//Sets.
	public void setConteudo(int c){
		this.i_Conteudo = c;
	}

	//Gets.
	public int getConteudo(){
		return this.i_Conteudo;
	}
}
