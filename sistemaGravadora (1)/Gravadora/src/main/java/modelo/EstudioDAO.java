package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstudioDAO {
    private static final String INSERIR = "INSERT INTO estudio (nome, num_musicas_gravadas, taxa_hora_estudio) VALUES (?, ?, ?)";
    private static final String SELECIONAR_TODOS = "SELECT * FROM estudio";
    private static final String SELECIONAR_POR_ID = "SELECT * FROM estudio WHERE id = ?";
    private static final String ATUALIZAR = "UPDATE estudio SET nome = ?, num_musicas_gravadas = ?, taxa_hora_estudio = ? WHERE id = ?";
    private static final String EXCLUIR = "DELETE FROM estudio WHERE id = ?";

    public void adicionarEstudio(Estudio estudio) throws SQLException {
        try (Connection conn = conexao.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(INSERIR)) {
            stmt.setString(1, estudio.getNome());
            stmt.setInt(2, estudio.getNumMusicasGravadas());
            stmt.setDouble(3, estudio.getTaxaHoraEstudio());
            stmt.executeUpdate();
        }
    }

    public List<Estudio> selecionarTodosEstudios() throws SQLException {
        List<Estudio> estudios = new ArrayList<>();
        try (Connection conn = conexao.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(SELECIONAR_TODOS);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int numMusicasGravadas = rs.getInt("num_musicas_gravadas");
                double taxaHoraEstudio = rs.getDouble("taxa_hora_estudio");
                estudios.add(new Estudio(id, nome, numMusicasGravadas, taxaHoraEstudio));
            }
        }
        return estudios;
    }

    public Estudio selecionarEstudioPorId(int id) throws SQLException {
        try (Connection conn = conexao.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(SELECIONAR_POR_ID)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nome = rs.getString("nome");
                    int numMusicasGravadas = rs.getInt("num_musicas_gravadas");
                    double taxaHoraEstudio = rs.getDouble("taxa_hora_estudio");
                    return new Estudio(id, nome, numMusicasGravadas, taxaHoraEstudio);
                }
            }
        }
        return null;
    }

    public void atualizarEstudio(Estudio estudio) throws SQLException {
        try (Connection conn = conexao.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(ATUALIZAR)) {
            stmt.setString(1, estudio.getNome());
            stmt.setInt(2, estudio.getNumMusicasGravadas());
            stmt.setDouble(3, estudio.getTaxaHoraEstudio());
            stmt.setInt(4, estudio.getId());
            stmt.executeUpdate();
        }
    }

    public void excluirEstudio(int id) throws SQLException {
        try (Connection conn = conexao.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(EXCLUIR)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
