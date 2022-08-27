INSERT INTO tb_user(name, email) VALUES('Gabriel Alves', 'gabrielsalves2k18@gmail.com');
INSERT INTO tb_user(name, email) VALUES('Teste da Silva', 'testedasilva@gmail.com');

INSERT INTO tb_category(name) VALUES('Cidade');
INSERT INTO tb_category(name) VALUES('Emprego');

INSERT INTO tb_news(title, news_text, category_id, user_id, publication_date) VALUES('Empregos em alta', 'Vagas de emprego...', 2, 1, CURRENT_TIMESTAMP);
INSERT INTO tb_news(title, news_text, category_id, user_id, publication_date) VALUES('Guarulhos no progresso', 'Ruas de Guarulhos...', 1, 1, CURRENT_TIMESTAMP);