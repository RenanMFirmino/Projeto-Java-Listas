import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lista sala= new Lista();
		System.out.println("A lista está vazia: "+sala.estaVazia());
		Scanner teclado=new Scanner(System.in);
		int op;
		int i;
		do {
			i=sala.tamanhoLista;
			System.out.println("Gerenciador de Alunos");
			System.out.println("Menu:");
			System.out.println("Digite 1-Adicionar, 2-Exibir Lista");
			System.out.println("3-Procurar Aluno, 4-Remover Aluno");
			System.out.println("5-Sair");
			op=teclado.nextInt();
			teclado.nextLine();
			switch(op) {
			case 1:{
				Aluno aluno=new Aluno();
				String nome;
				int rgm;
				String resp;
				Disciplina materia = aluno.getMateria();
				System.out.println("Digite o Nome:");
				nome=teclado.nextLine();
				System.out.println("Digite o RGM:");
				rgm=teclado.nextInt();
				while(sala.comparaRgm(rgm)==1) {
					System.out.println("Outro aluno já possui este RGM");
					System.out.println("Digite outro RGM:");
					rgm=teclado.nextInt();
				}
				teclado.nextLine();
				aluno.setDados(rgm, nome);
				do {
					No novoNo= new No();
					String novaMateria;
					String novaNota;
					System.out.println("Digite a Disciplina:");
					novaMateria=teclado.nextLine();
					System.out.println("Digite a nota:");
					novaNota=teclado.nextLine();
					novoNo.setDadosMateria(novaMateria, novaNota);
					materia.inserirNoFim(novoNo);
					System.out.println("Mais Disciplina?\ns(sim) ou n(não):");
					resp=teclado.nextLine();
					while(!resp.equals("s") && !resp.equals("n")) {
						System.out.println("Palavra inválida, digite novamente:");
						System.out.println("Mais Disciplina?\ns(sim) ou n(não):");
						resp=teclado.nextLine();
					}
				}while(!resp.equals("n"));
				aluno.setMateria(materia);
				sala.inserirAlunoRgm(i, aluno);
				break;
			}
			case 2:{
				sala.exibirLista();
				break;
			}
			case 3:{
				System.out.println("Digite o RGM do aluno do qual voce deseja ver os dados");
				int buscarRgm=teclado.nextInt();
				sala.buscaRGM(buscarRgm);
				break;
			}
			case 4:{
				System.out.println("Qual posição do aluno que voce quer excluir(RGM):");
				int excluir= teclado.nextInt();
				sala.removerAlunoPorRgm(excluir);
				sala.exibirLista();
				break;
			}
			case 5:{
				System.out.println("Fechando o programa");
				break;
			}
			default:{
				System.out.println("Valor inválido");
			}
			}
		}while(op!=5);
		teclado.close();
	}

}
