public class Equipe {
    private Long id;
    private String NomeProjeto;
    private String Desccricao;
    private Double NotaFinal;

    private Mentor mentor;
    private Localizacao localizacao;

    public Equipe() {
    }

    public Equipe(Long id, String nomeProjeto, String desccricao, Double notaFinal, Mentor mentor, Localizacao localizacao) {
        this.id = id;
        NomeProjeto = nomeProjeto;
        Desccricao = desccricao;
        NotaFinal = notaFinal;
        this.mentor = mentor;
        this.localizacao = localizacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProjeto() {
        return NomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        NomeProjeto = nomeProjeto;
    }

    public String getDesccricao() {
        return Desccricao;
    }

    public void setDesccricao(String desccricao) {
        Desccricao = desccricao;
    }

    public Double getNotaFinal() {
        return NotaFinal;
    }

    public void setNotaFinal(Double notaFinal) {
        NotaFinal = notaFinal;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }
}
