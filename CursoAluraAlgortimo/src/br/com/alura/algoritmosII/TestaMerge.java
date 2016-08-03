package br.com.alura.algoritmosII;

public class TestaMerge {

	public static void main(String[] args) {
		Nota[] notasMauricio = { new Nota("Andre", 4), new Nota("Mariana", 5), new Nota("Carlos", 8.5),
				new Nota("Paulo", 9) };
		Nota[] notasAlberto = { new Nota("Jonas", 3), new Nota("Juliana", 6.7), new Nota("Guilherme", 7),
				new Nota("Lucia", 9.3), new Nota("Ana", 10) };

		Nota[] rank = junta(notasAlberto, notasMauricio);
		for (Nota nota : rank) {
			System.out.println("Aluno: " + nota.getAluno() + ", nota: " + nota.getValor());
		}
	}

	private static Nota[] junta(Nota[] notasMauricio, Nota[] notasAlberto) {
		Nota[] notas = new Nota[notasMauricio.length + notasAlberto.length];

		int atualMauricio = 0;
		int atualAlberto = 0;
		int atual = 0;

		while (atualMauricio < notasMauricio.length && atualAlberto < notasAlberto.length) {
			Nota nota1 = notasMauricio[atualMauricio];
			Nota nota2 = notasAlberto[atualAlberto];
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
