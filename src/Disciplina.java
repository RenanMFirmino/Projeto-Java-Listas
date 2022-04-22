
public class Disciplina  {
	No	primeiro = null;
	No	ultimo = null;
	int		quantidadeMaterias = 0;
	public boolean estaVazia() {
		if (quantidadeMaterias == 0)
			return true;
		
		return false;
	}
	public int tamanhoDaLista() {
		return (quantidadeMaterias);
	}
	public void inserirMateriaInicio(No a) {
		No temp= new No();
		if (estaVazia())
			primeiro = ultimo = a;
		else {
			temp.materia=a.materia;
			temp.proximo = a;
			primeiro = temp;
		}
		quantidadeMaterias++;
	}
	public void inserirNoFim(No a) {
		if (estaVazia())
			primeiro = ultimo = a;
		else {
			ultimo.proximo = a;
			ultimo = a;
		}
		quantidadeMaterias++;
	}
	public void exibirListaMaterias() {
		No temp = primeiro;
		if (!estaVazia()) {
			System.out.println("Materias:");
			for (int i = 0; i < quantidadeMaterias; i++) {
				System.out.println( (i+1)+"º Materia: "+temp.materia);
				temp = temp.proximo;
			}
		}
	}
	public void removerMateriaPorNome(String materiaprocurada) {
		if (quantidadeMaterias == 0) {
			System.out.println("Lista está vazia");
			return;
		}
		
		if (quantidadeMaterias == 1) {
			if (primeiro.materia.equals(materiaprocurada)) {
					primeiro = ultimo = null;
					quantidadeMaterias--;
					return;
			}
			else {
				System.out.println("A materia "+materiaprocurada+" não está na lista.");
				return;
			}
		}
		
		No materiadafrente = primeiro;
		No materiadetras = null;
		
		for (int i = 0; i < quantidadeMaterias; i++) {
			if (materiaprocurada.equals(materiadafrente.materia)) {
				if (i == 0) {
					System.out.println("O primeiro da lista é o procurado e será removido.");
					primeiro = primeiro.proximo;
					quantidadeMaterias--;
					return;
				}
				else {
					materiadetras.materia = materiadafrente.materia;
					quantidadeMaterias--;
					return;
				}
			}
			else {
				materiadetras = materiadafrente;
				materiadafrente = materiadafrente.proximo;
			}
		}
		
		System.out.println("Materia "+materiaprocurada+" não está na lista");
		return;
	}
	
}
