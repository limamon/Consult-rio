/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import java.time.LocalDateTime;

/**
 *
 * @author Ramon
 */
public class Sessao {
    //Atributos
    private Anamnese anamnese; // A sessão pertence a uma anamnese
    
    public Anamnese getAnamnese() {
        return anamnese;
    }

    public void setAnamnese(Anamnese anamnese) {
        this.anamnese = anamnese;
    }
    
    private int idSessao;
    private LocalDateTime data;
    private String queixas_paciente;
    private String plano_tratamento;
    private String diagnostico_final;
    private String resumo_sessao;
    private int evolucao;
    private Boolean pago;

    public int getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(int idSessao) {
        this.idSessao = idSessao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getQueixas_paciente() {
        return queixas_paciente;
    }

    public void setQueixas_paciente(String queixas_paciente) {
        this.queixas_paciente = queixas_paciente;
    }

    public String getPlano_tratamento() {
        return plano_tratamento;
    }

    public void setPlano_tratamento(String plano_tratamento) {
        this.plano_tratamento = plano_tratamento;
    }

    public String getDiagnostico_final() {
        return diagnostico_final;
    }

    public void setDiagnostico_final(String diagnostico_final) {
        this.diagnostico_final = diagnostico_final;
    }

    public String getResumo_sessao() {
        return resumo_sessao;
    }

    public void setResumo_sessao(String resumo_sessao) {
        this.resumo_sessao = resumo_sessao;
    }

    public int getEvolucao() {
        return evolucao;
    }

    public void setEvolucao(int evolucao) {
        this.evolucao = evolucao;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }
    
    
    
}
