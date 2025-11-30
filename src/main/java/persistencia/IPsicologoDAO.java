/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.util.List;
import negocio.Psicologo;
/**
 *
 * @author Ramon
 */
public interface IPsicologoDAO {
    // Define os métodos obrigatórios (o famoso CRUD)
    public void adicionar(Psicologo psicologo);
    public void remover(int id);
    public void alterar(Psicologo psicologo);
    public List<Psicologo> listarTodos();
    public Psicologo getById(int id);
}
