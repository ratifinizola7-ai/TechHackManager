public class Mentor {
    private Long id;
    private String nome;
    private String especialidade;
    private Integer ExperienciaAnos;

    public Mentor() {
    }

    public Mentor(Long id, String nome, String especialidade, Integer experienciaAnos) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
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

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String expecialidade) {
        this.especialidade = expecialidade;
    }

    public Integer getExperienciaAnos() {
        return ExperienciaAnos;
    }

    public void setExperienciaAnos(Integer experienciaAnos) {
        ExperienciaAnos = experienciaAnos;
    }
}
