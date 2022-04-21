import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lista sala= new Lista();
		
		System.out.println("A lista está vazia: "+sala.estaVazia());
		Scanner teclado=new Scanner(System.in);
		String op;
		int i=0;
		do {
			System.out.println("Menu:");
			System.out.println("Digite 1-Adicionar, 2-Exibir Lista");
			System.out.println("3-Procurar Aluno, 4-Remover Aluno");
			System.out.println("5-Sair");
			op=teclado.next();
			Aluno aluno=new Aluno();
			switch(op) {
			case "1":{
				Materia grade=new Materia();
				String nome;
				String rgm;
				String resp;
				System.out.println("Digite o nome:");
				nome=teclado.next();
				aluno.setNome(nome);
				System.out.println("Digite o rgm:");
				rgm=teclado.next();
				aluno.setRgm(rgm);
				do {
					String materia="";
					System.out.println("Digite a disciplina:");
					materia=teclado.next();
					aluno.setMateria(materia);
					grade.inserirNoFim(aluno);
					System.out.println("Mais disciplina?\ns(sim) ou n(não):");
					resp=teclado.next();
					while(!resp.equals("s") && !resp.equals("n")) {
						System.out.println("Palavra invalida inválida:");
						System.out.println("Mais disciplina?\\ns(sim) ou n(não):");
						resp=teclado.next();
					}
				}while(!resp.equals("n"));
				sala.inserirAluno(i, aluno);
				i++;
				break;
			}
			case"2":{
				sala.exibirLista();
				break;
			}
			case"3":{
				
				break;
			}
			case "4":{
				
				break;
			}
			}
		}while(op!="5");
		teclado.close();
	}

}
