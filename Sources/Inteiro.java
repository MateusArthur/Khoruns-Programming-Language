Class Inteiro extends Variaveis{
	private int conteudo;

	public void setConteudo(int c){
		this.conteudo = c;
	}

	public int getConteudo(){
		return this.conteudo;
	}

	public void criaInteiro(int c, String n){
		this.setConteudo(c);
		this.setNome(n);
	}
}