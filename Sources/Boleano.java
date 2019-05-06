class Boleano extends Variaveis{
	private boolean i_Conteudo;

	Boleano(){
		this.setConteudo(true);
	}

	// Sets
	public void setConteudo(boolean c) {
		this.i_Conteudo = c;
	}

	// Gets
	public boolean getConteudo() {
		return this.i_Conteudo;
	}

}