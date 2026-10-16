
public class Main {
    public static void main(String[] args) {

        Localizacao local = new Localizacao(1L, "Laboratório A", 3, "Bloco B", 50);

        Mentor mentor = new Mentor(1L, "Ana Souza", "Arquitetura de Software", 5);

        Equipe equipe = new Equipe(1L, "CodeVanguarda", "TechHackManager", 9.8, local, mentor);

        Participante p1 = new Participante(1L, "Rati Finizola", "rati@email.com", "Java, Python", equipe);
        Participante p2 = new Participante(2L, "Maria Silva", "maria@email.com", "JavaScript, TypeScript", equipe);

        equipe.adicionarParticipante(p1);
        equipe.adicionarParticipante(p2);

        System.out.println("=== DADOS DO HACKATHON ===");
        System.out.println("Equipe: " + equipe.getNome());
        System.out.println("Projeto: " + equipe.getProjeto());
        System.out.println("Nota Final: " + equipe.getNotaFinal());
        System.out.println("Local: " + equipe.getLocalizacao().getSala() + " (" + equipe.getLocalizacao().getPredio() + ")");
        System.out.println("Mentor: " + equipe.getMentor().getNome() + " - " + equipe.getMentor().getExpecialidade());

        System.out.println("\n--- Participantes da Equipe ---");

        for (Participante participante : equipe.getParticipantes()) {
            System.out.println("- " + participante.getNome() + " (Linguagens: " + participante.getLinguagemPrincipal() + ")");
        }
    }
}