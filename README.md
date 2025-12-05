Projeto desenvolvido para a disciplina de **Características da Linguagem de Programação**. Trata-se de uma aplicação desktop desenvolvida em Java para o gerenciamento de atendimentos, pacientes e sessões de um consultório de psicologia.

## 📋 Identificação

* **Aluno:** Ramon B. Lima
* **Professor:** Giomar Sequeiros
* **Disciplina:** Características da Linguagem de Programação
* **Período:** 2025 – II
* **Data de Apresentação:** 04/12/2025

## 🛠️ Tecnologias e Ferramentas

* **Linguagem:** Java (JDK 8+)
* **IDE:** NetBeans
* **Interface Gráfica:** Swing (AWT/Swing)
* **Banco de Dados:** MySQL
* **Padrão de Projeto:** DAO (Data Access Object) e separação em camadas (Apresentação, Negócio, Persistência).

## ✅ Funcionalidades e Requisitos Implementados

Este projeto foi construído atendendo aos seguintes requisitos da avaliação:

1.  **Modelagem de Classes (Pacote `negocio`):**
    * Implementação das classes `Paciente`, `Psicologo`, `Anamnese` e `Sessao` com atributos espelhados no banco de dados, construtores e encapsulamento (Getters/Setters).
2.  **Persistência de Dados (Pacote `persistencia`):**
    * Criação das interfaces `IPacienteDAO`, `IPsicologoDAO`, `IAnamneseDAO` e `ISessaoDAO`.
    * Implementação completa das classes DAO correspondentes para CRUD no banco de dados.
3.  **Módulo de Anamnese:**
    * Finalização da lógica de salvamento na GUI de Anamnese.
4.  **Controle de Acesso (Login):**
    * Sistema de login modificado para autenticar apenas **Psicólogos** cadastrados no banco de dados.
5.  **Cadastros (GUIs):**
    * **Psicólogos:** Interface funcional para registro de novos profissionais, integrada ao menu principal.
    * **Sessões:** Interface para agendamento de sessões, com seleção de Paciente e vínculo com a ficha de Anamnese respectiva.
6.  **Sistema de Busca:**
    * Implementação do método `listarPorNome(String nome)` na classe `PacienteDAO`.
    * Funcionalidade de filtro na tela de **Listar Pacientes**, permitindo busca dinâmica pelo nome.
7.  **Informações do Desenvolvedor:**
    * Tela `fmSobre` atualizada com os dados do aluno responsável pelo projeto.

## 🚀 Como Executar o Projeto

1.  **Configuração do Banco de Dados:**
    * Localize o arquivo de script SQL (ex: `banco_consultorio.sql`) na pasta raiz do projeto.
    * Execute o script em seu gerenciador MySQL (Workbench, DBeaver, etc.) para criar o banco e as tabelas.
    * *Nota:* Verifique se as credenciais de banco (usuário/senha) na classe de Conexão conferem com o seu ambiente local.

2.  **Importação no NetBeans:**
    * Abra a IDE NetBeans.
    * Selecione `Arquivo` > `Abrir Projeto` e navegue até a pasta descompactada.
    * Verifique se a biblioteca do **Driver JDBC do MySQL** está adicionada ao projeto.

3.  **Execução:**
    * Execute o projeto. A tela inicial de Login deverá ser exibida.

---
*Desenvolvido por Ramon B. Lima - UERJ / 2025*
