class Atribuir{

	//Metodo para atribuir um valor inteiro a uma variavel.
	public void atribuiVarInt(Inteiro a, int b){
		a.setConteudo(b + a.getConteudo());
	}

	//Metodo para atribuir o valor de uma variavel a outra.
	public void atribuiVarVar(Inteiro a, Inteiro b){
		a.setConteudo(b.getConteudo() + a.getConteudo());
	}

	//Metodo para uso de var++ ou var--.
	public void incrementa(Inteiro a, int b){
		if(b == 1){
			a.setConteudo(a.getConteudo() + 1);
		}

		else{
			a.setConteudo(a.getConteudo() - 1);	
		}
	}

}

