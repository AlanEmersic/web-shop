INSERT INTO brand(name)
VALUES ('Razer');
INSERT INTO brand(name)
VALUES ('LOGITECH');

INSERT INTO product(name, description, price, quantity, brandId)
VALUES ('MIŠ RAZER DEATHADDER', 'MIŠ RAZER DEATHADDER opis', 650.99, 1, 1);
INSERT INTO product(name, description, price, quantity, brandId)
VALUES ('MIŠ LOGITECH G500', 'MIŠ LOGITECH G500 opis', 450.99, 2, 2);

INSERT INTO discountCode(code, discount, used)
VALUES ('20%', 20, false);
INSERT INTO discountCode(code, discount, used)
VALUES ('15%', 15, false);

INSERT INTO paymentMethod(name)
VALUES ('KARTIČNO');
INSERT INTO paymentMethod(name)
VALUES ('GOTOVINSKO');