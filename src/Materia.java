
public class Materia extends Aluno{
	Aluno	primeiro = null;
	Aluno	ultimo = null;
	int		tamanho = 0;
	public boolean estaVazia() {
		if (tamanho == 0)
			return true;
		
		return false;
	}
	public int tamanhoDaLista() {
		return (tamanho);
	}
	public void inserirMateriaInicio(Aluno a) {
		if (estaVazia())
			primeiro = ultimo = a;
		else {
			a.proximo = primeiro;
			primeiro = a;
		}
		tamanho++;
	}
	public void inserirNoFim(Aluno a) {
		if (estaVazia())
			primeiro = ultimo = a;
		else {
			ultimo.proximo = a;
			ultimo = a;
		}
		tamanho++;
	}
	public void exibirLista() {
		Aluno temp = primeiro;
		if (!estaVazia()) {
			for (int i = 0; i < tamanho; i++) {
				System.out.println(  (i+1)+"º Materia: "+temp.materia);
				temp = temp.proximo;
			}
		}
	}
	public void removerMateriaPorNome(String materiaprocurada) {
		if (tamanho == 0) {
			System.out.println("Lista está vazia");
			return;
		}
		
		if (tamanho == 1) {
			if (primeiro.materia.equals(materiaprocurada)) {
					primeiro = ultimo = null;
					tamanho--;
					return;
			}
			else {
				System.out.println("A materia "+materiaprocurada+" não está na lista.");
				return;
			}
		}
		
		Aluno materiadafrente = primeiro;
		Aluno materiadetras = null;
		
		for (int i = 0; i < tamanho; i++) {
			if (materiaprocurada.equals(materiadafrente.materia)) {
				if (i == 0) {
					System.out.println("O primeiro da lista é o procurado e será removido.");
					primeiro = primeiro.proximo;
					tamanho--;
					return;
				}
				else {
					materiadetras.materia = materiadafrente.materia;
					tamanho--;
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
