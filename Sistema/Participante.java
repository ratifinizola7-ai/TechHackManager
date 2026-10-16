public class Participante {
    private Long id;
    private String nome;
    private String email;
    private String LinguagemPrincipal;

    private Equipe equipe;

    public Participante() {
    }

    public Participante(Long id, String nome, String email, String linguagemPrincipal, Equipe equipe) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        LinguagemPrincipal = linguagemPrincipal;
        this.equipe = equipe;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinguagemPrincipal() {
        return LinguagemPrincipal;
    }

    public void setLinguagemPrincipal(String linguagemPrincipal) {
        LinguagemPrincipal = linguagemPrincipal;
    }
}
