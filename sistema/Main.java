

public class Main {
    public static void main(String[] args) {
        EquipeRepository equipeRepository = new EquipeRepository();

        Localizacao local = new Localizacao(2L, "Laboratório A", 3, "Bloco B", 50);
        Mentor mentor = new Mentor(3L, "Ana Souza", "Arquitetura de Software", 5);

        Equipe equipe = new Equipe(1L, "CodeVanguarda", "TechHackManager", 9.8, local, mentor);

        Participante p1 = new Participante(1L, "Rati Finizola", "rati@email.com", "Java, Python", equipe);
        Participante p2 = new Participante(2L, "Maria Silva", "maria@email.com", "JavaScript, TypeScript", equipe);

        equipe.adicionarParticipante(p1);
        equipe.adicionarParticipante(p2);

        equipeRepository.salvar(equipe);

        System.out.println("=== DADOS DO HACKATHON (via Repositório) ===");

        for (Equipe e : equipeRepository.listarTodas()) {
            System.out.println("Equipe: " + e.getNome());
            System.out.println("Projeto: " + e.getProjeto());
            System.out.println("Nota Final: " + e.getNotaFinal());
            System.out.println("Local: " + e.getLocalizacao().getSala() + " (" + e.getLocalizacao().getPredio() + ")");
            System.out.println("Mentor: " + e.getMentor().getNome() + " - " + e.getMentor().getEspecialidade());

            System.out.println("\n--- Participantes da Equipe ---");
            for (Participante participante : e.getParticipantes()) {
                System.out.println("- " + participante.getNome() + " (Linguagens: " + participante.getLinguagemPrincipal() + ")");
            }
        }
    }
}