
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
                "especialidade VARCHAR(255), " +
                "experienciaAnos INT, " +
                "localNome VARCHAR(255), " +
                "bloco VARCHAR(255), " +
                "capacidade INT)";

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
        String sql = "MERGE INTO equipe (id, nome, projeto, notaFinal, mentorNome, especialidade, experienciaAnos, localNome, bloco, capacidade) " +
                "KEY(id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            if (conn != null) {
                pstmt.setLong(1, equipe.getId());
                pstmt.setString(2, equipe.getNome());
                pstmt.setString(3, equipe.getProjeto());
                pstmt.setDouble(4, equipe.getNotaFinal());
                pstmt.setString(5, equipe.getMentor().getNome());
                pstmt.setString(6, equipe.getMentor().getEspecialidade());
                pstmt.setInt(7, equipe.getMentor().getExperienciaAnos());
                pstmt.setString(8, equipe.getLocalizacao().getSala());
                pstmt.setString(9, equipe.getLocalizacao().getPredio());
                pstmt.setInt(10, equipe.getLocalizacao().getCapacidadeMaxima());

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
                String especialidade = rs.getString("especialidade");
                int experienciaAnos = rs.getInt("experienciaAnos");

                String localNome = rs.getString("localNome");
                String bloco = rs.getString("bloco");
                int capacidade = rs.getInt("capacidade");

                Localizacao localizacao = new Localizacao(1L, localNome, 1, bloco, capacidade);
                Mentor mentor = new Mentor(1L, mentorNome, especialidade, experienciaAnos);

                Equipe equipe = new Equipe(id, nome, projeto, notaFinal, localizacao, mentor);
                equipes.add(equipe);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar equipes: " + e.getMessage());
        }

        return equipes;
    }

    public void deletar(long id) {
        String sql = "DELETE FROM equipe WHERE id = ?";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            if (conn != null) {
                pstmt.setLong(1, id);
                int linhasAfetadas = pstmt.executeUpdate();

                if (linhasAfetadas > 0) {
                    System.out.println("Equipe com ID " + id + " removida com sucesso do H2!");
                } else {
                    System.out.println("Nenhuma equipe encontrada com o ID " + id);
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao deletar equipe: " + e.getMessage());
        }
    }
}