-- Inserir dados na tabela 'product'
INSERT INTO product
    (product_id, description, price)
VALUES
    (100, 'Liquidificador', 180.0),
    (110, 'Torradeira', 120.0),
    (120, 'Batedeira', 250.0),
    (130, 'Panela de Pressão', 350.0);

-- Inserir dados na tabela 'orders'
INSERT INTO orders (order_id, client_name) VALUES (1, 'Marcio');
INSERT INTO orders (order_id, client_name) VALUES (2, 'Marcio');
INSERT INTO orders (order_id, client_name) VALUES (3, 'Marcio');
INSERT INTO orders (order_id, client_name) VALUES (4, 'Marcio');

-- Inserir dados na tabela 'item'
INSERT INTO item
    (order_id, product_id, quantity)
VALUES
    (1, 100, 1),
    (1, 110, 1),
    (1, 120, 40);

-- Inserir dados na tabela 'item'
INSERT INTO item
    (order_id, product_id, quantity)
VALUES
    (2, 100, 1),
    (2, 110, 1),
    (2, 120, 40);

-- Inserir dados na tabela 'item'
INSERT INTO item
    (order_id, product_id, quantity)
VALUES
    (3, 100, 1),
    (3, 110, 1),
    (3, 120, 40);

INSERT INTO item
    (order_id, product_id, quantity)
VALUES
    (4, 100, 1),
    (4, 110, 1),
    (4, 120, 40);

-- Inserir dados na tabela galpões
INSERT INTO warehouse
    (warehouse_id, location)
VALUES
    (1, 'BRAZIL'),
    (2, 'CHILE'),
    (3, 'BOLIVIA');

-- Inserir dados na tabela estoques
INSERT INTO stock
    (warehouse_id, product_id, max_quantity, min_quantity, current_quantity)
VALUES
    (1, 100, 100, 10, 50000),
    (1, 110, 50, 5, 30000),
    (1, 120, 75, 7, 40000),
    (2, 130, 90, 9, 60000);
