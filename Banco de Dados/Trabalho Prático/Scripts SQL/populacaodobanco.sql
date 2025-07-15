USE ong_comida_que_abraca;


INSERT INTO PRODUTOS (NomeProduto, UnidadeMedida, Categoria) VALUES
('Arroz Tipo 1', 'kg', 'Alimento Não Perecível'),
('Feijão Carioca', 'kg', 'Alimento Não Perecível'),
('Óleo de Soja', 'unidade', 'Alimento Não Perecível'),
('Cobertor de Casal', 'unidade', 'Vestuário e Cama'),
('Camisa de Algodão M', 'unidade', 'Vestuário e Cama');


INSERT INTO ESTOQUE (ID_Produto, QuantidadeAtual, DataUltimaAtualizacao) VALUES
(1, 50.00, NOW()), -- Arroz
(2, 35.00, NOW()), -- Feijão
(3, 24.00, NOW()), -- Óleo
(4, 15.00, NOW()), -- Cobertor
(5, 30.00, NOW()); -- Camisa


INSERT INTO INSTITUICOES_PARCEIRAS (NomeInstituicao, CNPJ, Telefone) VALUES
('Supermercados BH', '00.123.456/0001-00', '(31) 3333-4444'),
('Igreja da Boa Vontade', '11.222.333/0001-11', '(31) 98888-7777');


INSERT INTO PESSOAS (Nome, Sobrenome, DataCadastro, Email, DataInicioAtividade_Voluntario, Status_Voluntario) VALUES
('Maria', 'Silva', NOW(), 'maria.s@email.com', '2024-01-10', 'Ativo'), -- Voluntária e Doadora
('João', 'Pereira', NOW(), 'joao.p@email.com', NULL, NULL), -- Apenas Doador
('Ana', 'Souza', NOW(), 'ana.s@email.com', '2024-03-22', 'Ativo'), -- Apenas Voluntária
('Carlos', 'Gomes', NOW(), 'carlos.g@email.com', '2023-11-05', 'Inativo'); -- Voluntário Inativo


INSERT INTO CAMPANHAS (NomeCampanha, DataInicio, Status, Descricao, ID_Instituicao_Parceira) VALUES
('Inverno Solidário 2025', '2025-05-01', 'Ativa', 'Arrecadação de cobertores para o inverno.', 2),
('Natal Sem Fome 2025', '2025-11-01', 'Planejamento', 'Arrecadação de alimentos para cestas de Natal.', 1);


INSERT INTO VOLUNTARIO_CAMPANHA (ID_Pessoa_Voluntario, ID_Campanha, Funcao) VALUES
(1, 1, 'Coleta e Triagem'), -- Maria na campanha de inverno
(3, 1, 'Logística'); -- Ana na campanha de inverno


INSERT INTO DOACOES (ID_Pessoa, ID_Campanha, TipoDoacao, DataDoacao, ValorDoado) VALUES
(2, 2, 'Dinheiro', NOW(), 150.00);


INSERT INTO DOACOES (ID_Instituicao_Parceira, ID_Produto, TipoDoacao, DataDoacao, QuantidadeDoada) VALUES
(1, 1, 'Item', NOW(), 200.00); -- Supermercado doou 200kg de arroz
-- ATENÇÃO: Após um INSERT de doação de item, o ideal é ter um processo (Trigger ou na aplicação) para atualizar o ESTOQUE.
-- Ex: UPDATE ESTOQUE SET QuantidadeAtual = QuantidadeAtual + 200 WHERE ID_Produto = 1;


-- Primeiro a família, depois os indivíduos, e por fim atualiza o responsável.
INSERT INTO FAMILIAS (CodigoFamilia, NomeReferencia, DataPrimeiroContato) VALUES ('FAM-001', 'Família Oliveira', '2025-02-15');
SET @last_fam_id = LAST_INSERT_ID();


INSERT INTO INDIVIDUOS_ASSISTIDOS (ID_Familia, CodigoReferencia, NomeSocial, DataNasc) VALUES
(@last_fam_id, 'IND-001', 'Sandra Oliveira', '1985-06-20'),
(@last_fam_id, 'IND-002', 'Lucas Oliveira', '2010-09-10');
SET @resp_id = (SELECT ID_Individuo FROM INDIVIDUOS_ASSISTIDOS WHERE NomeSocial = 'Sandra Oliveira');


UPDATE FAMILIAS SET ID_Responsavel_Assistido = @resp_id WHERE ID_Familia = @last_fam_id;


INSERT INTO INDIVIDUOS_ASSISTIDOS (CodigoReferencia, NomeSocial) VALUES ('IND-003', 'José das Neves');


INSERT INTO DISTRIBUICOES (ID_Familia, ID_Campanha, DataEntrega, Observacoes) VALUES
(@last_fam_id, 1, NOW(), 'Entrega de cesta básica e cobertores.');
SET @last_dist_id = LAST_INSERT_ID();


INSERT INTO DISTRIBUICAO_ITENS (ID_Distribuicao, ID_Produto, QuantidadeEntregue) VALUES
(@last_dist_id, 1, 5.00),  
(@last_dist_id, 2, 2.00),   
(@last_dist_id, 4, 2.00);  


UPDATE ESTOQUE SET QuantidadeAtual = QuantidadeAtual - 5 WHERE ID_Produto = 1;
