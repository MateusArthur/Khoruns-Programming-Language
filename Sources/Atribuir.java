class Atribuir{

	//Metodo para atribuir um valor inteiro a uma variavel.
	public void atribuiVarInt(Inteiro a, int b){
		a.setConteudo(b);
	}

	//Metodo para atribuir o valor de uma variavel a outra.
	public void atribuiVarVar(Inteiro a, Inteiro b){
		a.setConteudo(b.getConteudo() + a.getConteudo());
	}

	//Metodo para uso de var++
	public void incrementaVar(Inteiro a){
		a.setConteudo(a.getConteudo() + 1);
	}

	//Metodo para uso de var--
	public void decrementaVar(Inteiro a){
		a.setConteudo(a.getConteudo() - 1);
	}

	//Para somar ou diminuir
	public void addVar(Inteiro a, int val) {
		a.setConteudo(a.getConteudo() + val);
	}
}

