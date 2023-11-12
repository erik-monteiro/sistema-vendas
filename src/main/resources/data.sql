INSERT INTO product
    (product_id, description, price)
VALUES
    (100, 'Liquidificador', 180.0),
    (110, 'Torradeira', 120.0),
    (120, 'Batedeira', 250.0),
    (130, 'Panela de Pressão', 350.0);

INSERT INTO warehouse
    (warehouse_id, location)
VALUES
    (1, 'BRAZIL'),
    (2, 'CHILE'),
    (3, 'BOLIVIA');

INSERT INTO stock
    (stock_id, warehouse_id, product_id, max_quantity, min_quantity, current_quantity)
VALUES
    (1, 1, 100, 100, 10, 50),
    (2, 1, 100, 50, 5, 30),
    (3, 1, 100, 75, 7, 40),
    (4, 2, 130, 90, 9, 60);





