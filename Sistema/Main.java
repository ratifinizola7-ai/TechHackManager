public class Main {
    public static void main(String[] args) {
        Localizacao sala = new Localizacao(1L, "Laboratório 01", 2, "Prédio A", 30);
        Mentor mentor = new Mentor(1L, "Ana Souza", "Java & Spring", 4);
        Equipe equipe = new Equipe(1L, "TechVanguard", "Sistema inovador", 9.5, mentor, sala);

        Participante aluno = new Participante(1L, "Rati", "rati@email.com", "Java", equipe);

        System.out.println("Projeto da Equipe: " + equipe.getNomeProjeto());
        System.out.println("Mentor responsável: " + equipe.getMentor().getNome());
        System.out.println("Local: " + equipe.getLocalizacao().getSala());
        System.out.println("Aluno participante: " + aluno.getNome());
    }
}