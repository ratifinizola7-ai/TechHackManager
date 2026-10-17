
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipeRepository {

    public EquipeRepository() {
        criarTabelaSeNaoExistir();
    }

    private void criarTabelaSeNaoExistir() {
        String sql = "CREATE TABLE IF NOT EXISTS equipe (" +
                "id BIGINT PRIMARY KEY, " +
                "nome VARCHAR(255), " +
                "projeto VARCHAR(255), " +
                "notaFinal DOUBLE, " +
                "mentorNome VARCHAR(255), " +
                "localNome VARCHAR(255))";

        try (Connection conn = ConexaoBD.conectar();
             Statement stmt = conn.createStatement()) {
            if (conn != null) {
                stmt.execute(sql);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    public void salvar(Equipe equipe) {
        String sql = "MERGE INTO equipe (id, nome, projeto, notaFinal, mentorNome, localNome) KEY(id) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            if (conn != null) {
                pstmt.setLong(1, equipe.getId());
                pstmt.setString(2, equipe.getNome());
                pstmt.setString(3, equipe.getProjeto());
                pstmt.setDouble(4, equipe.getNotaFinal());
                pstmt.setString(5, equipe.getMentor().getNome());
                pstmt.setString(6, equipe.getLocalizacao().getSala());

                pstmt.executeUpdate();
                System.out.println("Equipe salva/atualizada com sucesso no banco H2!");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao salvar equipe: " + e.getMessage());
        }
    }

    public List<Equipe> listarTodas() {
        List<Equipe> equipes = new ArrayList<>();
        String sql = "SELECT * FROM equipe";

        try (Connection conn = ConexaoBD.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String projeto = rs.getString("projeto");
                double notaFinal = rs.getDouble("notaFinal");
                String mentorNome = rs.getString("mentorNome");
                String localNome = rs.getString("localNome");

                Localizacao localizacao = new Localizacao(1L, localNome != null ? localNome : "Não definido", 1, "Bloco Principal", 30);
                Mentor mentor = new Mentor(1L, mentorNome != null ? mentorNome : "Não definido", "Geral", 1);

                Equipe equipe = new Equipe(id, nome, projeto, notaFinal, localizacao, mentor);
                equipes.add(equipe);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar equipes: " + e.getMessage());
        }

        return equipes;
    }
}