
import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private long id;
    private String nome;
    private String projeto;
    private Double notaFinal;

    private Localizacao localizacao;
    private Mentor mentor;

    private List<Participante> participantes;

    public Equipe(long id, String nome, String projeto, Double notaFinal, Localizacao localizacao, Mentor mentor) {
        this.id = id;
        this.nome = nome;
        this.projeto = projeto;
        this.notaFinal = notaFinal;
        this.localizacao = localizacao;
        this.mentor = mentor;
        this.participantes = new ArrayList<>();
    }

    public void adicionarParticipante(Participante participante) {
        this.participantes.add(participante);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProjeto() {
        return projeto;
    }

    public void setProjeto(String projeto) {
        this.projeto = projeto;
    }

    public Double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }
}