package br.com.test.collection;

import static br.com.test.collection.VectoresConst.vector1;
import static br.com.test.collection.VectoresConst.vector2;
import static br.com.test.collection.VectoresConst.vector3;

import java.util.HashSet;
import java.util.Set;

public class WithCollection {
	
	public static void main(String[] args) {
		
		Set<Integer> exit = new HashSet<Integer>();
		Set<Integer> aux = new HashSet<Integer>();
		Set<Integer> exit2 = new HashSet<Integer>();
		Set<Integer> aux2 = new HashSet<Integer>();
		
		//Este é para mostrar todos os duplicados
		for (int i = 0; i < vector1.length; i++) {
			if(!aux.add(vector1[i])){
				exit.add(vector1[i]);
			}
			if(!aux.add(vector2[i])){
				exit.add(vector2[i]);
			}
			if(!aux.add(vector3[i])){
				exit.add(vector3[i]);
			}
		}
		
		//Este é para mostrar os que não são duplicados
		for (int i = 0; i < vector1.length; i++) {
			if(aux2.add(vector1[i])){
				exit2.add(vector1[i]);
			} else {
				exit2.remove(vector1[i]);
			}
			if(aux2.add(vector2[i])){
				exit2.add(vector2[i]);
			} else {
				exit2.remove(vector2[i]);
			}
			if(aux2.add(vector3[i])){
				exit2.add(vector3[i]);
			} else {
				exit2.remove(vector3[i]);
			}
		}
		
		System.out.println(exit);
		System.out.println("------------------");
		System.out.println(exit2);
	}

}
