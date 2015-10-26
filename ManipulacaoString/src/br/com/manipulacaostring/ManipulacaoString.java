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
		
//		String caracterRepetido2 = "caracter repetido";
//		
//		char[] caracter2 = caracterRepetido2.toCharArray();
//		char[] aux = null;
//		
//		for (int i = 0; i < caracter2.length; i++) {
//			char x = caracter2[i];
//			for (int j = i + 1; j < caracter2.length; j++) {
//				char y = caracter2[j];
//				if(x == y){
//					if(aux != null){
//						for (int k = 0; k < aux.length; k++) {
//							if(x != aux[k]){
//								
//								System.out.println("Caracter repetido: " + x);
//							}
//						}
//					} else {
//						aux[0] = x;
//					}
//				}
//			}
//		}
		
	}
	
	public static void teste(){
		String caracterRepetido2 = "caracter repetido";
		
		String aux = "";
		
		for (int i = 0; i < caracterRepetido2.length(); i++) {
			char x = caracterRepetido2.charAt(i);
			for (int j = i + 1; j < caracterRepetido2.length(); j++) {
				char y = caracterRepetido2.charAt(j);
				if(x == y){
					if(!aux.isEmpty()){
						for (int k = 0; k < aux.length(); k++) {
							if(x != aux.charAt(k)){
								aux += x;
								System.out.println("Caracter repetido: " + x);
								break;
							}
						}
					} else {
						aux += x;
					}
				}
			}
		}
	}
}
