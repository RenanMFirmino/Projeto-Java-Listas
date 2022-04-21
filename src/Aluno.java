
public class Aluno {
	String nome;
	String rgm;
	String materia;
	Aluno proximo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRgm() {
		return rgm;
	}
	public void setRgm(String rgm) {
		this.rgm = rgm;
	}
	public String getMateira() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public Aluno getProximo() {
		return proximo;
	}
	public void setProximo(Aluno materia) {
		this.proximo = materia;
	}
}
