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
                     "VALUES (?,?,?,?,?,?,?,?,?,now())";
        
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
            //stmt.setDate(10, new Date(System.currentTimeMillis()));

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
        // Cria a lista vazia que vamos encher com os dados do banco
        List<Paciente> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM paciente";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Cria um novo objeto Paciente para cada linha do banco
                Paciente p = new Paciente();
                
                // --- Preenchendo os dados ---
                
                // ATENÇÃO: Verifique se no seu banco a coluna chama "id" ou "idPaciente"
                // Geralmente é apenas "id". Se der erro, mude aqui:
                p.setIdPaciente(rs.getInt("idPaciente")); 
                
                p.setNome(rs.getString("nome"));
                p.setCpf(rs.getString("cpf"));

                // Tratamento da Data de Nascimento (SQL -> Calendar)
                java.sql.Date dataSql = rs.getDate("data_nascimento");
                if (dataSql != null) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(dataSql);
                    p.setData_nascimento(cal);
                }

                p.setSexo(rs.getString("sexo"));
                p.setEndereco(rs.getString("endereco"));
                p.setTelefone(rs.getString("telefone"));
                p.setFoto(rs.getString("foto"));
                p.setPlano_saude(rs.getString("plano_saude"));
                p.setObservacoes(rs.getString("observacoes"));

                // Tratamento da Data de Cadastro
                // Usamos getTimestamp para pegar data E hora
                java.sql.Timestamp dataCad = rs.getTimestamp("data_cadastro");
                if (dataCad != null) {
                    Calendar cal2 = Calendar.getInstance();
                    cal2.setTime(dataCad);
                    // Verifique se sua classe Paciente tem esse set. 
                    // Se não tiver, apague essa linha ou crie o método lá.
                    p.setData_cadastro(cal2); 
                }

                // Adiciona o paciente preenchido na lista
                lista.add(p);
            }
            
            rs.close();
            stmt.close();
            
            return lista;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Paciente getById(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public List<Paciente> buscarPorNome(String nome) {
        List<Paciente> lista = new ArrayList<>();
        
        // O comando LIKE permite buscas parciais
        String sql = "SELECT * FROM paciente WHERE nome LIKE ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            // Os % indicam que pode ter texto antes ou depois do nome digitado
            stmt.setString(1, "%" + nome + "%"); 
            
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // A lógica aqui é idêntica ao listarTodos, pois precisamos preencher o objeto
                Paciente p = new Paciente();
                
                p.setIdPaciente(rs.getInt("idPaciente")); // Certifique-se que o nome da coluna no banco está certo
                p.setNome(rs.getString("nome"));
                p.setCpf(rs.getString("cpf"));

                // Tratamento data nascimento
                java.sql.Date dataSql = rs.getDate("data_nascimento");
                if (dataSql != null) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(dataSql);
                    p.setData_nascimento(cal);
                }

                p.setSexo(rs.getString("sexo"));
                p.setEndereco(rs.getString("endereco"));
                p.setTelefone(rs.getString("telefone"));
                p.setFoto(rs.getString("foto"));
                p.setPlano_saude(rs.getString("plano_saude"));
                p.setObservacoes(rs.getString("observacoes"));

                // Tratamento data cadastro
                java.sql.Timestamp dataCad = rs.getTimestamp("data_cadastro");
                if (dataCad != null) {
                    Calendar cal2 = Calendar.getInstance();
                    cal2.setTime(dataCad);
                    p.setData_cadastro(cal2); 
                }

                lista.add(p);
            }
            
            rs.close();
            stmt.close();
            
            return lista;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
