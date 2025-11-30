/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import negocio.Anamnese;

/**
 *
 * @author Ramon
 */
public class AnamneseDAO implements IAnamneseDAO {
    private Connection connection;
    
    public AnamneseDAO() {
        this.connection = new ConFactory().getConnection();
    }
    
    @Override
    public void adicionar(Anamnese anamnese) {
        // SQL Gigante por causa da quantidade de campos
        String sql = "INSERT INTO anamnese " +
                     "(queixas, sintomas, tratamentos_anteriores, medicamentos, " +
                     "infancia, rotina, vicios, hobbies, trabalho, historico_familiar, " +
                     "comportamento, linguagem, humor, hipotese_diagnostica, observacoes, " +
                     "numero_sessoes, valor_sessao, periodicidade, idPaciente, idPsicologo) " +
                     "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, anamnese.getQueixas());
            stmt.setString(2, anamnese.getSintomas());
            stmt.setString(3, anamnese.getTratamentos_anteriores());
            stmt.setString(4, anamnese.getMedicamentos());
            stmt.setString(5, anamnese.getInfancia());
            stmt.setString(6, anamnese.getRotina());
            stmt.setString(7, anamnese.getVicios());
            stmt.setString(8, anamnese.getHobbies());
            stmt.setString(9, anamnese.getTrabalho());
            stmt.setString(10, anamnese.getHistorico_familiar());
            stmt.setString(11, anamnese.getComportamento());
            stmt.setString(12, anamnese.getLinguagem());
            stmt.setString(13, anamnese.getHumor());
            stmt.setString(14, anamnese.getHipotese_diagnostico());
            stmt.setString(15, anamnese.getObservacoes());
            stmt.setInt(16, anamnese.getNumero_sessoes());
            stmt.setFloat(17, anamnese.getValor_sessao()); // setFloat ou setDouble
            stmt.setString(18, anamnese.getPeriodicidade());
            
            stmt.setInt(19, anamnese.getIdPaciente());
            stmt.setInt(20, anamnese.getIdPsicologo());
            
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    // Métodos vazios
    @Override
    public void alterar(Anamnese anamnese) { throw new UnsupportedOperationException("Not supported yet."); }
    @Override
    public void remover(int id) { throw new UnsupportedOperationException("Not supported yet."); }
    @Override
    public List<Anamnese> listarTodos() { throw new UnsupportedOperationException("Not supported yet."); }
    @Override
    public Anamnese getById(int id) { throw new UnsupportedOperationException("Not supported yet."); }
    
}
