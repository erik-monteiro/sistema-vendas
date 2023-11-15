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

-- Inserir dados na tabela 'item'
INSERT INTO item
    (order_id, product_id, quantity)
VALUES
    (1, 100, 2),
    (1, 110, 1),
    (1, 120, 3);

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
    (1, 100, 100, 10, 50),
    (1, 110, 50, 5, 30),
    (1, 120, 75, 7, 40),
    (2, 130, 90, 9, 60);
