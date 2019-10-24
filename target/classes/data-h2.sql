

transact(id INT PRIMARY  KEY AUTO_INCREMENT,accountnum int,change float,amount float, balance float)

INSERT INTO transact (accountnum,change,amount,balance) VALUES(1,100,50,150);
INSERT INTO transact (accountnum,change,amount,balance) VALUES(1,10,150,160);
INSERT INTO transact (accountnum,change,amount,balance) VALUES(1,-10,160,150);
INSERT INTO transact (accountnum,change,amount,balance) VALUES(2,1000,50,1050);
INSERT INTO transact (accountnum,change,amount,balance) VALUES(2,10,1050,1060);
INSERT INTO transact (accountnum,change,amount,balance) VALUES(2,-10,1060,1050);
INSERT INTO transact (accountnum,change,amount,balance) VALUES(3,100,1050,1060);
INSERT INTO transact (accountnum,change,amount,balance) VALUES(3,-10,1060,1050);

