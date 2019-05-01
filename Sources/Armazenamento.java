class Armazenamento{
	private Inteiro inteiros[];

	Armazenamento(){
		this.inteiros = new Inteiro[20];

		for(int i = 0; i < 20; i++){
			inteiros[i] = new Inteiro();
		}
	}

	public void setInteiro(String n, int c){
		inteiros[0].criaInteiro(c, n);
	
	}

	public Inteiro getInteiro(){
		return this.inteiros[0];
	}
}
