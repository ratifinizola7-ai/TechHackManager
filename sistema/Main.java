
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        EquipeRepository repository = new EquipeRepository();
        int opcao = -1;

        do {
            System.out.println("\n===============================");
            System.out.println("      TECH HACK MANAGER       ");
            System.out.println("===============================");
            System.out.println("1 - Cadastrar ou Atualizar Equipe");
            System.out.println("2 - Listar Todas as Equipes");
            System.out.println("3 - Remover Equipe por ID");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Por favor, digite um número válido!");
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.println("\n--- CADASTRO DE EQUIPE ---");
                    System.out.print("Digite o ID (número): ");
                    long id = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Digite o nome da equipe: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite o nome do projeto: ");
                    String projeto = scanner.nextLine();

                    System.out.print("Digite a nota final (ex: 9.5): ");
                    double notaFinal = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("\n--- DADOS DO MENTOR ---");
                    System.out.print("Nome do mentor: ");
                    String nomeMentor = scanner.nextLine();
                    System.out.print("Especialidade do mentor: ");
                    String especialidade = scanner.nextLine();
                    System.out.print("Anos de experiência do mentor: ");
                    int experiencia = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("\n--- DADOS DA LOCALIZAÇÃO ---");
                    System.out.print("Nome da sala/laboratório: ");
                    String nomeLocal = scanner.nextLine();
                    System.out.print("Bloco: ");
                    String bloco = scanner.nextLine();
                    System.out.print("Capacidade máxima da sala: ");
                    int capacidade = scanner.nextInt();
                    scanner.nextLine();

                    Localizacao localizacao = new Localizacao(1L, nomeLocal, 1, bloco, capacidade);
                    Mentor mentor = new Mentor(1L, nomeMentor, especialidade, experiencia);

                    Equipe equipe = new Equipe(id, nome, projeto, notaFinal, localizacao, mentor);
                    repository.salvar(equipe);
                    break;

                case 2:
                    System.out.println("\n--- EQUIPES CADASTRADAS NO H2 ---");
                    List<Equipe> equipes = repository.listarTodas();
                    if (equipes.isEmpty()) {
                        System.out.println("Nenhuma equipe cadastrada ainda.");
                    } else {
                        for (Equipe eq : equipes) {
                            System.out.println("--------------------------------");
                            System.out.println("ID: " + eq.getId());
                            System.out.println("Equipe: " + eq.getNome());
                            System.out.println("Projeto: " + eq.getProjeto());
                            System.out.println("Nota Final: " + eq.getNotaFinal());
                            System.out.println("Mentor: " + eq.getMentor().getNome() + " (" + eq.getMentor().getEspecialidade() + ", " + eq.getMentor().getExperienciaAnos() + " anos exp.)");
                            System.out.println("Local: " + eq.getLocalizacao().getSala() + " - " + eq.getLocalizacao().getPredio() + " (Cap: " + eq.getLocalizacao().getCapacidadeMaxima() + ")");
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n--- REMOVER EQUIPE ---");
                    System.out.print("Digite o ID da equipe que deseja remover: ");
                    long idRemover = scanner.nextLong();
                    scanner.nextLine();

                    repository.deletar(idRemover);
                    break;

                case 0:
                    System.out.println("A encerrar o sistema... Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida! Escolha entre 0 e 3.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}