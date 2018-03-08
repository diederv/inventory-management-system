INSERT INTO Category(name) VALUES('food');
INSERT INTO Category(name) VALUES('drinks');
INSERT INTO Category(name) VALUES('non-food');

INSERT INTO Item(category_name, name, minimal, count) VALUES('food', 'bread', 10, 20);
INSERT INTO Item(category_name, name, minimal, count) VALUES('food', 'cake', 10, 10);
INSERT INTO Item(category_name, name, minimal, count) VALUES('food', 'pie', 5, 5);
INSERT INTO Item(category_name, name, minimal, count) VALUES('drinks', 'beer', 100, 100);
INSERT INTO Item(category_name, name, minimal, count) VALUES('drinks', 'lemonade', 200, 150);
INSERT INTO Item(category_name, name, minimal, count) VALUES('non-food', 'hamer', 5, 5);
INSERT INTO Item(category_name, name, minimal, count) VALUES('non-food', 'radio', 2, 2);

COMMIT;	