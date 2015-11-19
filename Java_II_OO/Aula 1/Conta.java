class Conta{
	protected double saldo;
	private String nome;
	
	public double getSaldo(){
		return this.saldo;
	}
	
	public void deposita(double valor){
		this.saldo += valor - 0.10;
	}
	
	public void sacar(double valor){
		this.saldo -= valor;
	}
	
	public void atualiza(double taxa){
		this.saldo += this.saldo * taxa;
	}
	
	public void atualizandoConta(double valor){
		this.saldo += valor;
	}
}