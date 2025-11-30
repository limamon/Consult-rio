/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp; // Importante para Data e Hora
import java.util.List;
import negocio.Sessao;
/**
 *
 * @author Ramon
 */
public class SessaoDAO implements ISessaoDAO{
    private Connection connection;
    
    public SessaoDAO() {
        this.connection = new ConFactory().getConnection();
    }
    
    @Override
    public void adicionar(Sessao sessao) {
        String sql = "INSERT INTO sessao " +
                     "(data, queixas_paciente, plano_tratamento, diagnostico_final, " +
                     "resumo_sessao, evolucao, pago, idAnamnese) " +
                     "VALUES (?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            // Conversão de LocalDateTime para SQL Timestamp
            if (sessao.getData() != null) {
                stmt.setTimestamp(1, Timestamp.valueOf(sessao.getData()));
            } else {
                stmt.setTimestamp(1, null); // Caso a data esteja vazia
            }
            
            stmt.setString(2, sessao.getQueixas_paciente());
            stmt.setString(3, sessao.getPlano_tratamento());
            stmt.setString(4, sessao.getDiagnostico_final());
            stmt.setString(5, sessao.getResumo_sessao());
            stmt.setInt(6, sessao.getEvolucao());
            
            // O Java trata Boolean automaticamente para BIT(1)
            stmt.setBoolean(7, sessao.getPago());
            
            // Chave estrangeira da Anamnese
            stmt.setInt(8, sessao.getIdAnamnese());
            
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    // Métodos vazios
    @Override
    public void alterar(Sessao sessao) { throw new UnsupportedOperationException("Not supported yet."); }
    @Override
    public void remover(int id) { throw new UnsupportedOperationException("Not supported yet."); }
    @Override
    public List<Sessao> listarTodos() { throw new UnsupportedOperationException("Not supported yet."); }
    @Override
    public Sessao getById(int id) { throw new UnsupportedOperationException("Not supported yet."); }
}
