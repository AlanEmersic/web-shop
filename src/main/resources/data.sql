INSERT INTO brand(name)
VALUES ('Razer');
INSERT INTO brand(name)
VALUES ('LOGITECH');
INSERT INTO brand(name)
VALUES ('Kingston');
INSERT INTO brand(name)
VALUES ('Redragon');
INSERT INTO brand(name)
VALUES ('Samsung');
INSERT INTO brand(name)
VALUES ('LG');

INSERT INTO product(name, description, price, quantity, brandId)
VALUES ('MIŠ RAZER DEATHADDER', 'MIŠ RAZER DEATHADDER opis', 650.99, 1, 1);
INSERT INTO product(name, description, price, quantity, brandId)
VALUES ('MIŠ LOGITECH G500', 'MIŠ LOGITECH G500 opis', 450.99, 1, 2);
INSERT INTO product(name, description, price, quantity, brandId)
VALUES ('Miš REDRAGON COBRA CHROMA M711', 'COBRA CHROMA M711 opis', 160, 1, 4);



INSERT INTO discountCode(code, discount, used)
VALUES ('kod-20', 20, false);
INSERT INTO discountCode(code, discount, used)
VALUES ('kod-15', 15, true);

INSERT INTO paymentMethod(name)
VALUES ('KARTIČNO');
INSERT INTO paymentMethod(name)
VALUES ('GOTOVINSKO');