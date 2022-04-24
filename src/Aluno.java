
public class Aluno {
	String nome;
	int rgm;
	Disciplina materia=new Disciplina();//Criando a lista encadeada
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getRgm() {
		return rgm;
	}
	public void setRgm(int rgm) {
		this.rgm = rgm;
	}
	public Disciplina getMateria() {
		return materia;
	}
	public void setMateria(Disciplina materia) {//Recebendo as materias e seus ponteiros
		this.materia=materia;
	}
	public void setDados (int matricula, String novoNome) {//Recebendo RGM e nome fo Aluno
		rgm = matricula;
		nome = novoNome;
	}
	
}
