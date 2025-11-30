/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ramon
 */
public class ConFactory {
    public Connection getConnection() {
        try {
            // Ajustei o nome do banco para DBConsultorio (que criamos no script)
            // Se o seu MySQL tiver senha, coloque entre as aspas do último parâmetro
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/DBConsultorio", "root", "rbl2526");
            
        } catch (SQLException excecao) {
            // Lança um erro de tempo de execução se falhar
            throw new RuntimeException(excecao);
        }
    }
}
