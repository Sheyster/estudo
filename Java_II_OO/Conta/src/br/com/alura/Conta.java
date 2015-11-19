package br.com.alura;

public abstract class Conta{
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
	
	public abstract void atualiza(double taxa);
	
	public void atualizandoConta(double valor){
		this.saldo += valor;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}