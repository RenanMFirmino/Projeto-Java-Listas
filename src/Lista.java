
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
 		System.out.println("Aluno não existe\n");
 	}
	public boolean Compara(Aluno c1, Aluno c2) {
		return(c1.nome.equals(c2.nome)) && (c1.rgm==c2.rgm);
	}
	public int comparaNome(String nome) {
		for(int i=0;i<tamanhoLista;i++) {
			if(alunos[i].nome.equalsIgnoreCase(nome)) {
				return 1;
			}
		}
		return 0;
	}
	public int comparaRgm(int rgm) {
		for(int i=0;i<tamanhoLista;i++) {
			if(alunos[i].rgm==rgm) {
				return 1;
			}
		}
		return 0;
	}
	public int retornarPosicao(Aluno aluno) {
		for (int i = 0; i <= tamanhoLista; i++)
			if (Compara(alunos[i], aluno))
				return i;
		return -1;
	}
	public void deslocarParaDireita(int pos) {
		for (int i = tamanhoLista; i > pos; i--)
			alunos[i] = alunos[i - 1];
	}
	public boolean inserirAluno (int pos, Aluno c1) {//Inseri o Aluno em sua respectiva posição
		if (estaCheia() || (pos > tamanhoLista) || (pos < 0))
			return false;
		deslocarParaDireita(pos);
		alunos[pos] = c1;
		tamanhoLista++;
		ordenar();
		return true;
	}
	public void ordenar() {//Ordena a Lista usando o RGM de cada Aluno/Tipo Bubble sort
		Aluno temp=new Aluno();
		for(int i=0;i<tamanhoLista - 1;i++) {
			for(int j=0;j<tamanhoLista - i - 1;j++) {
				if(alunos[j].rgm>alunos[j + 1].rgm) {
					temp=alunos[j];
					alunos[j]=alunos[j + 1];
					alunos[j + 1]=temp;
				}
			}
		}
		
	}
	public boolean inserirAlunoRgm (int pos, Aluno c1) {
		if (estaCheia() || (pos > tamanhoLista) || (pos < 0))
			return false;
		Aluno c2= new Aluno();
		for(int i=0;i<tamanhoLista;i++) {
			c2=alunos[i];
			if(c1.rgm<c2.rgm) {
				deslocarParaDireita(pos);
				alunos[pos] = c1;
				tamanhoLista++;
				break;
			}	
		}
		ordenar();
		return true;
		
	}
	public void deslocarParaEsquerda(int pos) {
		for (int i = pos; i < (tamanhoLista - 1); i++)
			alunos[i] = alunos[i + 1];
	}
	public Aluno removerAlunoPorRgm (int rgm) {//Remove Aluno usando o RGM
		int pos=-1;
		for(int i = 0; i < tamanhoLista; i++) {
 			if(alunos[i].getRgm() == rgm) {
 				pos=i;
 				break;
 			}
		}
		if ((pos > tamanhoLista) || (pos < 0)) {
			System.out.println("Não existe Aluno com este RGM.");
			return null;
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
