package br.com.alura.algoritmosII;

public class TestaMerge {

	public static void main(String[] args) {
		registros[] notasMauricio = { new registros("Andre", 4), new registros("Mariana", 5), new registros("Carlos", 8.5),
				new registros("Paulo", 9) };
		registros[] notasAlberto = { new registros("Jonas", 3), new registros("Juliana", 6.7), new registros("Guilherme", 7),
				new registros("Lucia", 9.3), new registros("Ana", 10) };

		registros[] rank = junta(notasAlberto, notasMauricio);
		for (registros nota : rank) {
			System.out.println("Aluno: " + nota.getAluno() + ", nota: " + nota.getValor());
		}
	}

	private static registros[] junta(registros[] notasMauricio, registros[] notasAlberto) {
		registros[] notas = new registros[notasMauricio.length + notasAlberto.length];

		int atualMauricio = 0;
		int atualAlberto = 0;
		int atual = 0;

		while (atualMauricio < notasMauricio.length && atualAlberto < notasAlberto.length) {
			registros nota1 = notasMauricio[atualMauricio];
			registros nota2 = notasAlberto[atualAlberto];
			if (nota1.getValor() < nota2.getValor()) {
				notas[atual] = nota1;
				atualMauricio++;
			} else {
				notas[atual] = nota2;
				atualAlberto++;
			}
			atual++;
		}

		while (atualAlberto < notasAlberto.length) {
			notas[atual++] = notasAlberto[atualAlberto++];
			// atual++;
			// atualAlberto++;
		}

		while (atualMauricio < notasMauricio.length) {
			notas[atual++] = notasMauricio[atualMauricio++];
			atual++;
			atualMauricio++;
		}

		return notas;
	}

}
