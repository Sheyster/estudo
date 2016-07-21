package br.com.manipulacaostring;

public class ManipulacaoString {

	public static void main(String[] args) {
		
		String abcdef = "abcdef";
		System.out.println(abcdef.charAt(0));
		System.out.println(abcdef.charAt(4));
		
		System.out.println("-------------------");
		
		String valor = "Java"; 
		System.out.println(valor.codePointAt(0));
		
		System.out.println("-------------------");
		
		String valor2 = "java";
		System.out.println(valor2.codePointAt(0));
		
		System.out.println("-------------------");
		
		String java = "Java";
		System.out.println(java.compareTo("Java") == 0 ? true : false);
		System.out.println(java.compareTo("java") == 0 ? true : false);
		System.out.println(java.compareToIgnoreCase("JavA") == 0 ? true : false);
		
		System.out.println("-------------------");
		
		String testeJava = "Teste - Java";
		String testeComSplit[] = testeJava.split(" - ");
		for (String string : testeComSplit) {
			System.out.print(string);
		}
		
		System.out.println("-------------------");
		
		String testeJavaEng = "Teste - Java - Engenharia - Software";
		String testeEngComSplit[] = testeJavaEng.split(" - ", 2);
		for (String string : testeEngComSplit) {
			System.out.print(string + " ");
		}
		
		System.out.println("-------------------");
		
		String eltonJava = "ELTON - Java"; 
		System.out.println(eltonJava.subSequence(0, 5)); 
		System.out.println(eltonJava.substring(0, 5));
		System.out.println(eltonJava.substring(8, 12));
		
		System.out.println("-------------------");
		
		String larva = "Larva"; 
		
		System.out.println(larva.replace("L", "J").replace("r", ""));

		StringBuilder sb = new StringBuilder("01078989469150999134BB2116456");
		sb.setCharAt(21, 'X');
		String novaString = sb.toString();
		System.out.println(novaString);
		
		System.out.println("-------------------");
		
		String teste = "testando";
		char[] testando = teste.toCharArray();
		for (int i = 0; i < testando.length; i++) {
			if(testando[i] == 't'){
				System.out.println('x');
			} else {
				System.out.println(testando[i]);
			}
		}
		
		
		String caracterRepetido = "caracter repetido";
		
		char[] caracter = caracterRepetido.toCharArray();
		
		for (int i = 0; i < caracter.length; i++) {
			char x = caracter[i];
			for (int j = i + 1; j < caracter.length; j++) {
				char y = caracter[j];
				if(x == y){
					System.out.println("Caracter repetido: " + x);
				}
			}
		}
		teste();
		
	}
	
	public static void teste(){
		String caracterRepetido = "caracter repetido";
		String aux = "";
		
		for (int i = 0; i < caracterRepetido.length(); i++) {
			int count = 0;
			char x = caracterRepetido.charAt(i);
			for (int j = i + 1; j < caracterRepetido.length(); j++) {
				char y = caracterRepetido.charAt(j);
				
				if(x == y){
					count++;
				}
			}
			
			if(count == 1){
				aux += x;
			}
		}
		
		System.out.println(aux);
	}
}
