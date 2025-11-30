/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import negocio.Paciente;
/**
 *
 * @author Ramon
 */
public class PacienteDAO implements IPacienteDAO {
    private Connection connection;
    
    // Construtor
    public PacienteDAO() {
        this.connection = new ConFactory().getConnection();
    }
    
    // Implementação do método adicionar
    @Override
    public void adicionar(Paciente paciente) {
        // Cuidado com os espaços no SQL
        String sql = "INSERT INTO paciente " +
                     "(nome, cpf, data_nascimento, sexo, endereco, telefone, foto, plano_saude, observacoes, data_cadastro) " +
                     "VALUES (?,?,?,?,?,?,?,?,?,now()";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getCpf());
            
            // Convertendo Calendar para java.sql.Date
            // Verifica se a data não é nula para evitar erro
            if(paciente.getData_nascimento() != null) {
                stmt.setDate(3, new Date(paciente.getData_nascimento().getTimeInMillis()));
            } else {
                stmt.setDate(3, null);
            }
            
            stmt.setString(4, paciente.getSexo());
            stmt.setString(5, paciente.getEndereco());
            stmt.setString(6, paciente.getTelefone());
            stmt.setString(7, paciente.getFoto());
            stmt.setString(8, paciente.getPlano_saude());
            stmt.setString(9, paciente.getObservacoes());
            
            // Data de Cadastro (usando a data atual do sistema se não tiver)
            stmt.setDate(10, new Date(System.currentTimeMillis()));

            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Métodos obrigatórios da Interface (que ainda não vamos preencher)
    @Override
    public void remover(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void alterar(Paciente paciente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Paciente> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Paciente getById(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
