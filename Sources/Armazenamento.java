class Armazenamento{
	private Inteiro inteiros[];

	Armazenamento(){
		this.inteiros = new Inteiro[20];

		for(int i = 0; i < 20; i++){
			inteiros[i] = new Inteiro();
		}
	}

	public void setInteiro(Inteiro i){
		this.inteiros[inteiros.length] = i;
	}

	public Inteiro getInteiro(int p){
		return this.inteiros[p];
	}
}
