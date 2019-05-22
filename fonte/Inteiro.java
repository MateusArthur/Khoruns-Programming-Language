//Classe para variaveis do tipo inteiro.
class Inteiro {
	private int i_Conteudo;
	protected String nome;

	Inteiro(){
		this.setConteudo(0);
	}

	//Sets.
	public void setNome(String n){
		this.nome = n;		
	}

	public void setConteudo(int c){
		this.i_Conteudo = c;
	}

	//Gets.
	public String getNome(){
		return this.nome;
	}

	public int getConteudo(){
		return this.i_Conteudo;
	}
}
