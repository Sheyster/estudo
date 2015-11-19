package br.com.alura;

public class ContaPoupanca extends Conta{
	
	public void atualiza(double taxa){
		this.saldo += this.saldo * taxa * 3;
	}
}