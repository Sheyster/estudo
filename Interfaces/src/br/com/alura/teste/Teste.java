package br.com.alura.teste;

import br.com.alura.AreaCalculavel;
import br.com.alura.Circulo;
import br.com.alura.Quadrado;
import br.com.alura.Retangulo;

public class Teste {

	public static void main(String[] args) {
		AreaCalculavel ac = new Retangulo(3, 2);
		System.out.println(ac.calculaArea());
		ac = new Quadrado(5);
		System.out.println(ac.calculaArea());
		
		ac = new Circulo(10);
		System.out.println(ac.calculaArea());
	}

}
