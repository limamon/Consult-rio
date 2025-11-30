/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import negocio.Psicologo;
/**
 *
 * @author Ramon
 */
public class PsicologoDAO implements IPsicologoDAO {
    private Connection connection;
    
    public PsicologoDAO() {
        this.connection = new ConFactory().getConnection();
    }
    
    @Override
    public void adicionar(Psicologo psicologo) {
        String sql = "INSERT INTO psicologo " +
                     "(nome, cpf, crp, telefone, login, senha) " +
                     "VALUES (?,?,?,?,?,?)";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, psicologo.getNome());
            stmt.setString(2, psicologo.getCpf());
            stmt.setString(3, psicologo.getCrp());
            stmt.setString(4, psicologo.getTelefone());
            stmt.setString(6, psicologo.getLogin());
            stmt.setString(7, psicologo.getSenha());
            
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    // Outros métodos para implementar depois
    @Override
    public void alterar(Psicologo psicologo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remover(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Psicologo> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Psicologo getById(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
