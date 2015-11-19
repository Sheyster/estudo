package br.com.alura.teste;

import br.com.alura.Conta;
import br.com.alura.ContaCorrente;
import br.com.alura.ContaPoupanca;

public class TestaContas{
	public static void main(String[] args){
//		Conta c = new Conta();
		Conta cc = new ContaCorrente();
		Conta cp = new ContaPoupanca();
		
		Conta[] c = new Conta[10];
		
//		c.deposita(1000);
		cc.deposita(1000);
		cp.deposita(1000);
		
//		c.atualiza(0.01);
		cc.atualiza(0.01);
		cp.atualiza(0.01);
		
//		System.out.println(c.getSaldo());
		System.out.println(cc.getSaldo());
		System.out.println(cp.getSaldo());
		
//		AtualizadorDeContas at = new AtualizadorDeContas(0.1);
//		at.roda(c);
//		System.out.println(c.getSaldo());
//		at.roda(cc);
//		System.out.println(cc.getSaldo());
	}
}