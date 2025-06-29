CREATE DATABASE IF NOT EXISTS ong_comida_que_abraca;
USE ong_comida_que_abraca;

CREATE TABLE PESSOAS (
    ID_Pessoa INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Nome VARCHAR(255) NOT NULL,
    Sobrenome VARCHAR(255) NOT NULL,
    DataCadastro DATETIME NOT NULL,
    CPF VARCHAR(14),
    Telefone VARCHAR(45),
    Email VARCHAR(255),
    DataNasc DATE,
    DataInicioAtividade_Voluntario DATE,
    Status_Voluntario VARCHAR(45)
);

CREATE TABLE INSTITUICOES_PARCEIRAS (
    ID_Instituicao INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    NomeInstituicao VARCHAR(255) NOT NULL,
    CNPJ VARCHAR(18),
    Contato VARCHAR(255),
    Endereco TEXT,
    Telefone VARCHAR(45)
);

CREATE TABLE CAMPANHAS (
    ID_Campanha INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    ID_Instituicao_Parceira INT,
    NomeCampanha VARCHAR(255) NOT NULL,
    DataInicio DATE NOT NULL,
    Status VARCHAR(45) NOT NULL,
    Descricao TEXT,
    FOREIGN KEY (ID_Instituicao_Parceira) REFERENCES INSTITUICOES_PARCEIRAS(ID_Instituicao)
);

CREATE TABLE VOLUNTARIO_CAMPANHA (
    ID_Pessoa_Voluntario INT NOT NULL,
    ID_Campanha INT NOT NULL,
    Funcao VARCHAR(255),
    PRIMARY KEY (ID_Pessoa_Voluntario, ID_Campanha),
    FOREIGN KEY (ID_Pessoa_Voluntario) REFERENCES PESSOAS(ID_Pessoa),
    FOREIGN KEY (ID_Campanha) REFERENCES CAMPANHAS(ID_Campanha)
);


CREATE TABLE PRODUTOS (
    ID_Produto INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    NomeProduto VARCHAR(255) NOT NULL,
    UnidadeMedida VARCHAR(45) NOT NULL,
    Descricao TEXT,
    Categoria VARCHAR(45)
);

CREATE TABLE ESTOQUE (
    ID_Estoque INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    ID_Produto INT NOT NULL,
    QuantidadeAtual DECIMAL(10, 2) NOT NULL,
    DataUltimaAtualizacao DATETIME NOT NULL,
    FOREIGN KEY (ID_Produto) REFERENCES PRODUTOS(ID_Produto)
);

CREATE TABLE DOACOES (
    ID_Doacao INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    ID_Pessoa INT,
    ID_Instituicao_Parceira INT,
    ID_Campanha INT,
    ID_Produto INT,
    TipoDoacao VARCHAR(45) NOT NULL,
    DataDoacao DATETIME NOT NULL,
    QuantidadeDoada DECIMAL(10, 2),
    ValorDoado DECIMAL(10, 2),
    Descricao TEXT,
    FOREIGN KEY (ID_Pessoa) REFERENCES PESSOAS(ID_Pessoa),
    FOREIGN KEY (ID_Instituicao_Parceira) REFERENCES INSTITUICOES_PARCEIRAS(ID_Instituicao),
    FOREIGN KEY (ID_Campanha) REFERENCES CAMPANHAS(ID_Campanha),
    FOREIGN KEY (ID_Produto) REFERENCES PRODUTOS(ID_Produto)
);

CREATE TABLE DESPESAS (
    ID_Despesa INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    ID_Campanha INT,
    Descricao VARCHAR(255) NOT NULL,
    Valor DECIMAL(10, 2) NOT NULL,
    DataDespesa DATE NOT NULL,
    Fornecedor VARCHAR(255),
    FOREIGN KEY (ID_Campanha) REFERENCES CAMPANHAS(ID_Campanha)
);


CREATE TABLE FAMILIAS (
    ID_Familia INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    ID_Responsavel_Assistido INT, -- Chave estrangeira será adicionada com ALTER TABLE
    CodigoFamilia VARCHAR(45) NOT NULL,
    NomeReferencia VARCHAR(255) NOT NULL,
    DataPrimeiroContato DATE NOT NULL,
    EnderecoPrincipal TEXT,
    ObservacoesGerais TEXT
);

CREATE TABLE INDIVIDUOS_ASSISTIDOS (
    ID_Individuo INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    ID_Familia INT,
    CodigoReferencia VARCHAR(45) NOT NULL,
    NomeSocial VARCHAR(255) NOT NULL,
    DataNasc DATE,
    Telefone VARCHAR(45),
    ObservacoesIndividuais TEXT,
    FOREIGN KEY (ID_Familia) REFERENCES FAMILIAS(ID_Familia)
);

ALTER TABLE FAMILIAS ADD FOREIGN KEY (ID_Responsavel_Assistido) REFERENCES INDIVIDUOS_ASSISTIDOS(ID_Individuo);

CREATE TABLE DISTRIBUICOES (
    ID_Distribuicao INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    ID_Familia INT,
    ID_Individuo_Assistido INT,
    ID_Campanha INT,
    DataEntrega DATETIME NOT NULL,
    Observacoes TEXT,
    FOREIGN KEY (ID_Familia) REFERENCES FAMILIAS(ID_Familia),
    FOREIGN KEY (ID_Individuo_Assistido) REFERENCES INDIVIDUOS_ASSISTIDOS(ID_Individuo),
    FOREIGN KEY (ID_Campanha) REFERENCES CAMPANHAS(ID_Campanha)
);

CREATE TABLE DISTRIBUICAO_ITENS (
    ID_Distribuicao_Item INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    ID_Distribuicao INT NOT NULL,
    ID_Produto INT NOT NULL,
    QuantidadeEntregue DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (ID_Distribuicao) REFERENCES DISTRIBUICOES(ID_Distribuicao),
    FOREIGN KEY (ID_Produto) REFERENCES PRODUTOS(ID_Produto)
);
