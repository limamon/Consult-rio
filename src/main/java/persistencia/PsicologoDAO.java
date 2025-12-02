/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
            stmt.setString(5, psicologo.getLogin());
            stmt.setString(6, psicologo.getSenha());
            
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    // --- NOVO MÉTODO DE LOGIN IMPLEMENTADO ---
    @Override
    public boolean autenticar(String login, String senha) {
        String sql = "SELECT * FROM psicologo WHERE login = ? AND senha = ?";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            
            ResultSet rs = stmt.executeQuery();
            
            // Se rs.next() for verdadeiro, significa que achou o psicólogo
            if (rs.next()) {
                return true;
            }
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return false; // Não achou ninguém
    }
    // -----------------------------------------
    
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
        // 1. Cria a lista vazia
        List<Psicologo> psicologos = new ArrayList<>();
        
        // 2. Define o comando SQL
        String sql = "SELECT * FROM psicologo";

        try {
            // 3. Prepara e executa a consulta
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            // 4. Percorre todos os resultados do banco
            while (rs.next()) {
                Psicologo psicologo = new Psicologo();
                
                // Preenchendo os dados (Cuidado com Maiúsculas/minúsculas)
                // Verifique se no banco a coluna é 'idpsicologo' ou apenas 'id'
                psicologo.setIdPsicologo(rs.getInt("idpsicologo"));
                
                psicologo.setNome(rs.getString("nome"));
                psicologo.setCpf(rs.getString("cpf"));
                psicologo.setCrp(rs.getString("crp"));
                psicologo.setTelefone(rs.getString("telefone"));
                psicologo.setLogin(rs.getString("login"));
                psicologo.setSenha(rs.getString("senha"));

                // Adiciona o psicólogo preenchido na lista
                psicologos.add(psicologo);
            }
            
            // 5. Fecha as conexões
            rs.close();
            stmt.close();
            
            return psicologos;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Psicologo getById(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
