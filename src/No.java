
public class No {//Criada para facilitar a entrada de dados na classe Aluno
	String materia;
	String nota;
	No proximo;

	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota=nota;
	}
	public No getProximo() {
		return proximo;
	}
	public void setProximo(No proximo) {
		this.proximo = proximo;
	}
	public void setDadosMateria (String novaMateria, String novaNota) {//Recebendo Materia e Nota do Aluno
		materia = novaMateria;
		nota = novaNota;
	}
	
}
