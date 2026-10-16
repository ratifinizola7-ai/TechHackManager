
import java.util.ArrayList;
import java.util.List;

public class EquipeRepository {
    private List<Equipe> equipes = new ArrayList<>();

    public void salvar(Equipe equipe) {
        equipes.add(equipe);
    }

    public List<Equipe> listarTodas() {
        return equipes;
    }

    public Equipe buscarPorId(long id) {
        for (Equipe equipe : equipes) {
            if (equipe.getId() == id) {
                return equipe;
            }
        }
        return null;
    }
}
