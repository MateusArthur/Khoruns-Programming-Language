//Classe para variaveis do tipo inteiro.
class Inteiro extends Variaveis{
	private int i_Conteudo;

	//Sets.
	public void setConteudo(int c){
		this.i_Conteudo = c;
	}

	//Gets.
	public int getConteudo(){
		return this.i_Conteudo;
	}

	//Metodos.
	public void criaInteiro(int c, String n){
		this.setConteudo(c);
		this.setNome(n);
	}
}