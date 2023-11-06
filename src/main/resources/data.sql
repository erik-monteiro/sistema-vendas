INSERT INTO product
    (product_id, description, price)
VALUES
    (100,'Liquidificador', 180.0),
    (110,'Torradeira', 120.0),
    (120,'Batedeira', 250.0),
    (130,'Panela de Pressão', 350.0);

INSERT INTO warehouse
    (warehouse_id, location)
VALUES
    (1, 0),
    (2, 1),
    (3, 2);

INSERT INTO stock
    (stock_id, warehouse_warehouse_id, max_quantity, min_quantity, current_quantity)
VALUES
    (1, 1, 100, 10, 50),
    (2, 1, 50, 5, 30),
    (3, 1, 75, 7, 40),
    (4, 2, 90, 9, 60);

INSERT INTO product_warehouse
    (product_id, warehouse_id)
VALUES
    (100, 1),
    (110, 1),
    (120, 1),
    (130, 2);