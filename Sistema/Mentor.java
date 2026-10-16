public class Mentor {
    private Long id;
    private String nome;
    private String expecialidade;
    private Integer ExperienciaAnos;

    public Mentor() {
    }

    public Mentor(Long id, String nome, String expecialidade, Integer experienciaAnos) {
        this.id = id;
        this.nome = nome;
        this.expecialidade = expecialidade;
        ExperienciaAnos = experienciaAnos;
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

    public String getExpecialidade() {
        return expecialidade;
    }

    public void setExpecialidade(String expecialidade) {
        this.expecialidade = expecialidade;
    }

    public Integer getExperienciaAnos() {
        return ExperienciaAnos;
    }

    public void setExperienciaAnos(Integer experienciaAnos) {
        ExperienciaAnos = experienciaAnos;
    }
}
