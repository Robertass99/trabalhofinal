import java.util.Scanner;
 
public class Main{
 
  public static void main (String[]args) {
 
    Scanner scanner = new Scanner (System.in);
 
 
    boolean resposta = true;
 
    String[] alunos = new String[100];
 
    double[] matriculas = new double[100];
 
    double[] n1 = new double[100];
 
    double[] n2 = new double[100];
 
    double[] media = new double[100];
 
    int contadoralunos = 0;
 
 
    while (resposta) {
 
	System.out.println ("MENU");
 
	System.out.println ();
 
	System.out.println ("1-Adicionar alunos");
 
	System.out.println ("2-Adicionar nota");
 
	System.out.println ("3-listar alunos");
 
	System.out.println ("4-Listar boletim");
	System.out.println ("5-Excluir Aluno");
 
	int opcao = scanner.nextInt ();
 
	System.out.print ("\033[H\033[2J");
 
	System.out.flush ();
 
	switch (opcao) {
 
	  case 1:
 
	    System.out.println ("ADICIONAR ALUNO");
 
	    System.out.println ();
 
	    System.out.println ("Quantos alunos deseja adicionar?");
 
	    int numAlunosAdicionar = scanner.nextInt ();
 
	    for (int i = 0; i < numAlunosAdicionar; i++) {
 
		scanner.nextLine ();
 
		System.out.println ("Entre com o nome do aluno " + (i + 1) +  ":");
 
		alunos[contadoralunos] = scanner.nextLine ();
 
		System.out.println ("Entre com a matricula do aluno " + (i + 1) + ":");
 
		matriculas[contadoralunos] = scanner.nextDouble ();
 
		System.out.println ("Gravar? (S/N)");
 
		String gravar = scanner.next ();
 
		System.out.print ("\033[H\033[2J");
 
		System.out.flush ();
 
		contadoralunos++;
 
	    }
 
	    break;
 
	  case 2:
 
	    System.out.println ("ADICIONAR NOTA");
 
	    System.out.println ();
 
	    System.out.println ("Entre com a matricula:");
 
	    double matricula = scanner.nextDouble ();
 
	    int alunoEncontrado = -1;
 
	    for (int i = 0; i < contadoralunos; i++) {
 
		if (matricula == matriculas[i])
 
		{
 
		    alunoEncontrado = i;
 
		}
 
	    }
 
 
	    if (alunoEncontrado != -1) {
 
		System.out.println ("Nome: " + alunos[alunoEncontrado]);
 
		System.out.println ("Entre a N1:");
 
		n1[alunoEncontrado] = scanner.nextDouble ();
 
		System.out.println ("Entre com a N2:");
 
		n2[alunoEncontrado] = scanner.nextDouble ();
 
		System.out.println ("Gravar?(S/N)");
 
		media[alunoEncontrado] = (n1[alunoEncontrado] + n2[alunoEncontrado]) / 2;
 
		scanner.nextLine ();
 
		String gravar2 = scanner.nextLine ();
 
		System.out.print ("\033[H\033[2J");
 
		System.out.flush ();
 
	    }
 
	    else {
 
		System.out.println ("Matricula nao encontrada.");
 
		String passar = scanner.nextLine ();
 
		System.out.print ("\033[H\033[2J");
 
		System.out.flush ();
 
	    }
 
	    break;

 
       case 3:
    System.out.println("LISTAR ALUNOS");
    System.out.println();
    System.out.println("Escolha o modo de exibição:");
    System.out.println("1 - Por ordem alfabética");
    System.out.println("2 - Por ordem de matrícula");
    int modoExibicaoAlunos = scanner.nextInt();
 
    System.out.print("\033[H\033[2J");
    System.out.flush();
 
    switch (modoExibicaoAlunos) {
        case 1: 
            for (int i = 0; i < contadoralunos; i++) {
                for (int j = i + 1; j < contadoralunos; j++) {
                    if (alunos[i].compareToIgnoreCase(alunos[j]) > 0) {
                       
                        String tempNome = alunos[i];
                        alunos[i] = alunos[j];
                        alunos[j] = tempNome;
 
                        double tempMatricula = matriculas[i];
                        matriculas[i] = matriculas[j];
                        matriculas[j] = tempMatricula;
                    }
                }
            }
            break;
            case 2: 
            for (int i = 0; i < contadoralunos; i++){
                for (int j = i + 1; j < contadoralunos; j++) {
                    if (matriculas[i] > matriculas[j]) {
                        
                        double tempMedia = media[i];
                        media[i] = media[j];
                        media[j] = tempMedia;
 
                        String tempNome = alunos[i];
                        alunos[i] = alunos[j];
                        alunos[j] = tempNome;
 
                        double tempMatricula = matriculas[i];
                        matriculas[i] = matriculas[j];
                        matriculas[j] = tempMatricula;
                    }
                }
            }
            break;
 
        default:
            System.out.println("Opção inválida. Escolha 1 ou 2.");
            break;
    }
 
    for (int i = 0; i < contadoralunos; i++) {
        if (modoExibicaoAlunos == 1) {
            System.out.println("Nome: " + alunos[i]);
            System.out.println("Matrícula: " + matriculas[i]);
            System.out.println();
        } else if (modoExibicaoAlunos == 2) {
            System.out.println("Matrícula: " + matriculas[i]);
            System.out.println("Nome: " + alunos[i]);
            System.out.println();
        }
    }
 
    System.out.print("Voltar? (S/N)");
    scanner.nextLine();
    String resp3 = scanner.nextLine();
 
    if (resp3.equalsIgnoreCase("N")) {
        resposta = false;
    }
 
    System.out.print("\033[H\033[2J");
    System.out.flush();
    break;


	   case 4:
    System.out.println("BOLETIM");
    System.out.println();
    System.out.println("Escolha o modo de exibição:");
    System.out.println("1 - Por ordem de média");
    System.out.println("2 - Por ordem de matrícula");
    int modoExibicao = scanner.nextInt();
 
    System.out.print("\033[H\033[2J");
    System.out.flush();
 
    switch (modoExibicao) {
        case 1: 
            for (int i = 0; i < contadoralunos; i++) {
                for (int j = i + 1; j < contadoralunos; j++) {
                    if (media[i] < media[j]) {
                        
                        double tempMedia = media[i];
                        media[i] = media[j];
                        media[j] = tempMedia;
 
                        String tempNome = alunos[i];
                        alunos[i] = alunos[j];
                        alunos[j] = tempNome;
 
                        double tempMatricula = matriculas[i];
                        matriculas[i] = matriculas[j];
                        matriculas[j] = tempMatricula;
 
                        double tempN1 = n1[i];
                        n1[i] = n1[j];
                        n1[j] = tempN1;
 
                        double tempN2 = n2[i];
                        n2[i] = n2[j];
                        n2[j] = tempN2;
                    }
                }
            }
            break;
 
        case 2: 
            for (int i = 0; i < contadoralunos; i++) {
                for (int j = i + 1; j < contadoralunos; j++) {
                    if (matriculas[i] > matriculas[j]) {
                        
                        double tempMedia = media[i];
                        media[i] = media[j];
                        media[j] = tempMedia;
 
                        String tempNome = alunos[i];
                        alunos[i] = alunos[j];
                        alunos[j] = tempNome;
 
                        double tempMatricula = matriculas[i];
                        matriculas[i] = matriculas[j];
                        matriculas[j] = tempMatricula;
 
                        double tempN1 = n1[i];
                        n1[i] = n1[j];
                        n1[j] = tempN1;
 
                        double tempN2 = n2[i];
                        n2[i] = n2[j];
                        n2[j] = tempN2;
                    }
                }
            }
            break;
 
        default:
            System.out.println("Opção inválida. Escolha 1 ou 2.");
            break;
    }
 
    for (int i = 0; i < contadoralunos; i++) {
        System.out.println("Nome: " + alunos[i]);
        System.out.println("Matrícula: " + matriculas[i]);
        System.out.println("N1: " + n1[i]);
        System.out.println("N2: " + n2[i]);
        System.out.println("Média: " + media[i]);
        System.out.println();
    }
 
    System.out.print("Voltar? (S/N)");
    scanner.nextLine();
    String resp4 = scanner.nextLine();
 
    if (resp4.equalsIgnoreCase("N")) {
        resposta = false;
    }
 
    System.out.print("\033[H\033[2J");
    System.out.flush();
    break;
 
        case 5:
    System.out.println("Excluir matricula");
    System.out.println();
    System.out.println("Entre com a matricula:");
    double matriculaExcluir = scanner.nextDouble();
 
    int alunoParaExcluir = -1;
 
    for (int i = 0; i < contadoralunos; i++) {
        if (matriculaExcluir == matriculas[i]) {
            alunoParaExcluir = i;
            break;
        }
    }
 
    if (alunoParaExcluir != -1) {
        System.out.println("Aluno encontrado para exclusão:");
        System.out.println("Nome: " + alunos[alunoParaExcluir]);
        System.out.println("Matricula: " + matriculas[alunoParaExcluir]);
        System.out.println("Deseja realmente excluir este aluno? (S/N)");
 
        String confirmacao = scanner.next();
 
        if (confirmacao.equalsIgnoreCase("S")) {
            for (int i = alunoParaExcluir; i < contadoralunos - 1; i++) {
                alunos[i] = alunos[i + 1];
                matriculas[i] = matriculas[i + 1];
                n1[i] = n1[i + 1];
                n2[i] = n2[i + 1];
                media[i] = media[i + 1];
            }
 
            contadoralunos--;
 
            System.out.println("Aluno excluído com sucesso!");
        } else {
            System.out.println("Exclusão cancelada.");
        }
    } else {
        System.out.println("Matrícula não encontrada. Nenhum aluno foi excluído.");
    }
 
    System.out.print("\033[H\033[2J");
    System.out.flush();
    break;
 
	  }
 
      }
 
  }
 
}