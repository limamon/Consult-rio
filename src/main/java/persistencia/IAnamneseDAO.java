/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.util.List;
import negocio.Anamnese;
/**
 *
 * @author Ramon
 */
public interface IAnamneseDAO {
    // Define os métodos obrigatórios (o famoso CRUD)
    public void adicionar(Anamnese paciente);
    public void remover(int id);
    public void alterar(Anamnese paciente);
    public List<Anamnese> listarTodos();
    public Anamnese getById(int id);
}
