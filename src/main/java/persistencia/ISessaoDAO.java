/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.util.List;
import negocio.Sessao;
/**
 *
 * @author Ramon
 */
public interface ISessaoDAO {
    // Define os métodos obrigatórios (o famoso CRUD)
    public void adicionar(Sessao sessao);
    public void remover(int id);
    public void alterar(Sessao sessao);
    public List<Sessao> listarTodos();
    public Sessao getById(int id);
}
