class Atribuir{
	//Metodo para atribuir o valor de uma variavel a outra.
	public void atribuiVarVar(Float a, Float b){
		a.setConteudo(b.getConteudo() + a.getConteudo());
	}

	//Metodo para uso de var++
	public void incrementaVar(Float a){
		a.setConteudo(a.getConteudo() + 1);
	}

	//Metodo para uso de var--
	public void decrementaVar(Float a){
		a.setConteudo(a.getConteudo() - 1);
	}

	//Metodo para atribuir o valor de uma variavel a outra.
	public void atribuiVarVar(Float a, Float b){
		a.setConteudo(b.getConteudo() + a.getConteudo());
	}

//Metodo para atribuir um valor em uma variavel
	public void atribuiVarVal(Float a, double val) {
		a.setConteudo(a.getConteudo() + val);
	}

	//Para somar ou diminuir
	/*public void addVar(Float a, float val) {
		a.setConteudo(a.getConteudo() + val);
	}*/
}
