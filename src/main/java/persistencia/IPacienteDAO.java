/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.util.List;
import negocio.Paciente;

/**
 *
 * @author Ramon
 */
public interface IPacienteDAO {
    // Define os métodos obrigatórios (o famoso CRUD)
    public void adicionar(Paciente paciente);
    public void remover(int id);
    public void alterar(Paciente paciente);
    public List<Paciente> listarTodos();
    public Paciente getById(int id);
}
