public class Localizacao {
    private Long id;
    private String Sala;
    private Integer andar;
    private String predio;
    private Integer CapacidadeMaxima;

    public Localizacao() {
    }

    public Localizacao(Long id, String sala, Integer andar, String predio, Integer capacidadeMaxima) {
        this.id = id;
        Sala = sala;
        this.andar = andar;
        this.predio = predio;
        CapacidadeMaxima = capacidadeMaxima;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSala() {
        return Sala;
    }

    public void setSala(String sala) {
        Sala = sala;
    }

    public Integer getAndar() {
        return andar;
    }

    public void setAndar(Integer andar) {
        this.andar = andar;
    }

    public String getPredio() {
        return predio;
    }

    public void setPredio(String predio) {
        this.predio = predio;
    }

    public Integer getCapacidadeMaxima() {
        return CapacidadeMaxima;
    }

    public void setCapacidadeMaxima(Integer capacidadeMaxima) {
        CapacidadeMaxima = capacidadeMaxima;
    }
}
