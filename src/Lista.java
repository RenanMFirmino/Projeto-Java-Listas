
public class Lista {
	Aluno[] alunos= new Aluno[60];
	int tamanhoLista=0;
	
	public boolean estaVazia() {
		return(tamanhoLista == 0);
	}
	
	public boolean estaCheia() {
		return(tamanhoLista == alunos.length);
	}
	
	public int tamanhoLista() {
		return(tamanhoLista);
	}
	
	public Aluno buscar(int pos) {
		// verifica se pos e valida
		if (pos < 0 || pos >= tamanhoLista)
			return null;
		
		return alunos[pos];
	}
	public void buscaRGM(int rgm) {//Procura e apresenta informações do Aluno desejado
 		for(int i = 0; i < tamanhoLista; i++) {
 			if(alunos[i].getRgm() == rgm) {
 				System.out.println("Nome:\t" + alunos[i].getNome() 
 						+ "\nRgm:\t"+alunos[i].getRgm()+"\n");
 				alunos[i].materia.exibirListaMaterias();
 				return ;
 			}
 		}
 		System.out.println("Não possui aluno cadastrado com esse RGM\n");
 	}
	public int comparaRgm(int rgm) {
		for(int i=0;i<tamanhoLista;i++) {
			if(alunos[i].rgm==rgm) {
				return 1;
			}
		}
		return 0;
	}
	public void deslocarParaDireita(int pos) {
		for (int i = tamanhoLista; i > pos; i--)
			alunos[i] = alunos[i - 1];
	}
	public boolean inserirAlunoRgm (int pos, Aluno c1) {
		if (estaCheia() || (pos > tamanhoLista) || (pos < 0)) {
			System.out.println("Não foi possivel inserir o Aluno na lista");
			return false;
		}
		for(int i=0;i<tamanhoLista;i++) {
			if(c1.rgm<alunos[i].rgm) {
				pos=i;
				break;
			}	
		}
		deslocarParaDireita(pos);
		alunos[pos] = c1;
		tamanhoLista++;
		return true;
	}
	public void deslocarParaEsquerda(int pos) {
		for (int i = pos; i < (tamanhoLista - 1); i++)
			alunos[i] = alunos[i + 1];
	}
	public Aluno removerAlunoPorRgm (int rgm) {//Remove Aluno usando o RGM
		int pos=-1;
		int i;
		for(i = 0; i < tamanhoLista; i++) {
 			if(alunos[i].getRgm() == rgm) {
 				pos=i;
 				break;
 			}
		}
		if ((pos > tamanhoLista) || (pos < 0)) {
			System.out.println("Não existe Aluno com este RGM.");
			return null;
		}
		System.out.println("Aluno de RGM: "+alunos[pos].rgm+" e nome: "+alunos[pos].nome+" removido.");
		int tamanho=alunos[pos].materia.quantidadeMaterias;
		for(i=0;i<tamanho;i++) {
			No nome=alunos[pos].materia.primeiro;
			System.out.println("Materia removida: "+nome.materia+"; Nota removida: "+nome.nota);
			alunos[pos].materia.removerMateriaPorNome(nome.materia);
		}
		Aluno aux = alunos[pos];
		deslocarParaEsquerda(pos);
		tamanhoLista--;
		return aux;
	}
	public void exibirLista() {//Exibe todos os dados do Aluno: Nome, RGM e Materias alocadas
		
		for (int i = 0; i < tamanhoLista; i++) {
			System.out.println(	"\nAluno " +(i + 1)
								+"\nNome: " +alunos[i].nome
								+"\nRgm: "+alunos[i].rgm);
			alunos[i].materia.exibirListaMaterias();
		}
		
	}
}
