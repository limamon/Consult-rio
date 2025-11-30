-- 1. Cria o Banco de Dados com o nome que o professor pediu
CREATE DATABASE IF NOT EXISTS DBConsultorio;

USE DBConsultorio;

-- 2. Tabela Paciente
CREATE TABLE IF NOT EXISTS paciente (
    idPaciente INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(60),
    cpf VARCHAR(45),
    data_nascimento DATE,
    sexo CHAR(1),
    endereco VARCHAR(100),
    telefone VARCHAR(20),
    foto VARCHAR(100),
    plano_saude VARCHAR(50),
    observacoes TEXT,
    data_cadastro DATE
) ENGINE=MyISAM DEFAULT CHARSET=UTF8MB4;

-- 3. Tabela Psicologo
CREATE TABLE IF NOT EXISTS psicologo (
    idPsicologo INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(60),
    cpf VARCHAR(14),
    crp VARCHAR(20),
    telefone VARCHAR(20),
    foto VARCHAR(100),
    login VARCHAR(20) UNIQUE,
    senha VARCHAR(20)
) ENGINE=MyISAM DEFAULT CHARSET=UTF8MB4;

-- 4. Tabela Anamnese
CREATE TABLE IF NOT EXISTS anamnese (
    idAnamnese INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    queixas TEXT,
    sintomas TEXT,
    tratamentos_anteriores TEXT,
    medicamentos TEXT,
    infancia TEXT,
    rotina TEXT,
    vicios TEXT,
    hobbies TEXT,
    trabalho TEXT,
    historico_familiar TEXT,
    comportamento TEXT,
    linguagem TEXT,
    humor TEXT,
    hipotese_diagnostica TEXT,
    observacoes TEXT,
    numero_sessoes INT,
    valor_sessao DECIMAL(10,2), -- Ajustei levemente para (10,2) para evitar erro de sintaxe no decimal vazio, mas se o prof passou vazio, pode deixar DECIMAL
    periodicidade VARCHAR(20),
    
    -- Chaves Estrangeiras
    idPaciente INT UNSIGNED NOT NULL, -- Precisa ser UNSIGNED para bater com a tabela paciente
    idPsicologo INT UNSIGNED NOT NULL, -- Precisa ser UNSIGNED para bater com a tabela psicologo
    
    FOREIGN KEY (idPaciente) REFERENCES paciente(idPaciente),
    FOREIGN KEY (idPsicologo) REFERENCES psicologo(idPsicologo)
) ENGINE=MyISAM DEFAULT CHARSET=UTF8MB4;

-- 5. Tabela Sessao
CREATE TABLE IF NOT EXISTS sessao (
    idSessao INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    data DATETIME,
    queixas_paciente TEXT,
    plano_tratamento TEXT,
    diagnostico_final TEXT,
    resumo_sessao TEXT,
    evolucao INT,
    pago BIT(1),
    
    -- Chave Estrangeira
    idAnamnese INT UNSIGNED, -- Precisa ser UNSIGNED para bater com a tabela anamnese
    
    FOREIGN KEY (idAnamnese) REFERENCES anamnese(idAnamnese)
) ENGINE=MyISAM DEFAULT CHARSET=UTF8MB4;