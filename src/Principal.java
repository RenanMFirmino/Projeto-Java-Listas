import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lista sala= new Lista();
		Materia grade=new Materia();
		System.out.println("A lista está vazia: "+sala.estaVazia());
		Scanner teclado=new Scanner(System.in);
		String op;
		int i=0;
		do {
			System.out.println("Menu:");
			System.out.println("Digite 1-Adicionar, 2-Remover");
			System.out.println("3-Procurar, 4-Mostrar lista");
			System.out.println("5-Sair");
			op=teclado.next();
			Aluno aluno=new Aluno();
			switch(op) {
			case "1":{
				
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
					String materia;
					System.out.println("Digite a matéria cursada:");
					materia=teclado.next();
					aluno.setMateria(materia);
					grade.inserirNoFim(aluno);
					System.out.println("Deseja adicionar outra materia s(sim) ou n(não):");
					resp=teclado.next();
					while(!resp.equals("sim") && !resp.equals("nao")) {
						System.out.println("Palavra invalida inválida:");
						System.out.println("Deseja adicionar outra materia s(sim),n(não):");
						resp=teclado.next();
					}
				}while(!resp.equals("nao"));
				sala.inserirAluno(i, aluno);
				i++;
				break;
			}
			case"3":{
				
				break;
			}
			case "4":{
				sala.exibirLista();
				break;
			}
			}
		}while(op!="5");
		teclado.close();
	}

}
