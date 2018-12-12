-- ##########################################################################################################################
-- #
-- # Created by: 					Trevor J. Puckett
-- # 
-- # Date due: 						12/12/2018
-- # 
-- # Project name: 					Term Project: Bookstore database design
-- #
-- # Script purpose: 					create and populate a database for the operations and utilization
-- #                                    		of a fabricated bookstore. 
-- #
-- ###########################################################################################################################

-- # Create the database
-- DROP DATABASE IF EXISTS ap;
-- DROP DATABASE IF EXISTS ex;
-- DROP DATABASE IF EXISTS om;

DROP DATABASE IF EXISTS Bookstore;
CREATE DATABASE Bookstore;

-- # Ensure focus is on proper database // This will ensure following commands will be directed to the proper database
USE Bookstore;

-- # Create tables
CREATE TABLE customers
(
customer_id 				INT			PRIMARY	KEY		AUTO_INCREMENT,
first_name				VARCHAR(20)		NOT NULL,
last_name				VARCHAR(25)		NOT NULL,
customer_address			VARCHAR(30),
customer_city				VARCHAR(20),
customer_state				VARCHAR(2),
customer_zip				VARCHAR(5),
customer_phone				VARCHAR(14),
customer_email				VARCHAR(40)		NOT NULL		UNIQUE
);

CREATE TABLE purchases
(
purchase_number 			INT			NOT NULL		PRIMARY	KEY		AUTO_INCREMENT,
customer_id 				INT			NOT NULL,
purchase_date 				DATE			NOT NULL,
CONSTRAINT purchases_fk_customer
    FOREIGN KEY (customer_id)
    REFERENCES customers (customer_id)
);

CREATE TABLE products
(
product_id 			INT 			NOT NULL 	PRIMARY KEY 	AUTO_INCREMENT,
product_name 			VARCHAR(20) 		NOT NULL,
product_description 		VARCHAR(500),
product_on_hand 		INT 			NOT NULL,
product_unit_price 		DECIMAL(6,2) 		NOT NULL 
);

CREATE TABLE purchased_items
(
item_id 			INT 			NOT NULL 	PRIMARY KEY 	AUTO_INCREMENT,
purchase_number 		INT 			NOT NULL,
product_id 			INT 			NOT NULL,
purchased_quantity 		INT 			NOT NULL,
purchased_price 		DECIMAL(6,2)	 	NOT NULL,
CONSTRAINT purchases_fk_purchaseNumber
    FOREIGN KEY (purchase_number)
    REFERENCES purchases (purchase_number),
CONSTRAINT purchases_fk_productID
    FOREIGN KEY (product_id)
    REFERENCES products (product_id)    
);

CREATE TABLE courses
(
course_id 		VARCHAR(7) 		NOT NULL 	PRIMARY KEY,
course_name 		VARCHAR(30)	 	NOT NULL
);

CREATE TABLE required_materials
(
course_id 		VARCHAR(7) 		NOT NULL,
product_id 		INT 			NOT NULL,
PRIMARY KEY (course_id, product_id),
CONSTRAINT required_materials_fk_courseID
	FOREIGN KEY (course_id)
	REFERENCES courses (course_id),
CONSTRAINT required_materials_fk_productID
	FOREIGN KEY (product_id)
    REFERENCES products (product_id)
);
-- # Create indexes
	-- I don't remember seeing any instructions for creating an index... So I'm not gonna worry about it ;D

-- # Instert rows into tables // populate tables

INSERT INTO  customers VALUES
(default, 'John', 'Schidmt','123 Main St.','Columbus','OH','43004','(617)-454-2925','johnschidmt@email.school.edu'),
(default, 'Jacob', 'Jinglehiemer','123 Broad St.','Mesa','AZ','85201','(480)-544-9252','jacobjinglehiemer@email.school.edu'),
(default, 'Delilah', 'Whitees','','New York City','NY','10024','(212)-445-5292','delilahwhitees@email.school.edu'),
(default, 'Jenny', 'Tutone','132 W. Galiger Ave,','Columbia','SC','29201','(803)-867-5309','jennytutone@email.school.edu'),
(default, 'Billy', 'Bobertson','213 E. Mcmanman Ct.','Columbia','SC','29205','(803)-493-5683','billybobertson@email.school.edu')
;	

INSERT INTO products VALUES
(default,	'Required Book',
 'This is your typical 25th edition book. Each year we change exactly 153 words to make it legally a new book. Then we make it manditory you all buy it and teach from it. We know the student body will most likely not even read it all the way through and google the answers to 90% of the homework. But hey.. What are your other options?',
 	32,359.99),
(default,'Best Pencils',
 'This box includes 13 of the finest pencils our factory is willing to produce. We claim they are unbreakable, self-sharpening, and last 95% longer than all other brands. We all know it is not true but if you grab your handy-dandy electron microscrope our fine print states clearly in all bold that our crazy claims are only marketing rhetoric. Buy a pack of these and be better than your peers!',
	 225,34.99),
(default,	'Graphing Calculator',
 'The programming is from the 80s, and materials from the scrap yard, but it has a unique ability to do both too much and too little at the same time! Most of you know you can store notes and download scripts for it off the internet making it super easy to make a cheat sheet on it. Some say it is only useful in math but we are sure you will come up with a clever comeback when your history teacher asks why you need a graphing calculator during the exam!',
	 8,289.99),
(default,	'16oz Drink',
 'Let\'s not kid ourselve\'s, You have three options, buy your drink here, be late, or drink from that virus pump everyone calls a water fountain. Given these conditions we know we can buy a pack of this drink from down the street, put it in a cooler, and charge you a sweet 2500% mark up. Let\'s do business!',
	 23,6.99),
(default,	'Junk Food',
 'You don\'t need it, but the bacteria in your stomach & brain that feed off of fat and sugar won\'t let you say no, so go ahead and grab 15 because we are in short supply and there is a hungry line of bacterial drones right behind you!',
 	18, 4.99)
;

INSERT INTO purchases VALUES
(default, 1, '2017-05-19'),
(default, 5, '2017-07-27'),
(default, 3, '2018-08-12'),
(default, 5, '2018-09-13')
;

INSERT INTO purchased_items VALUES
-- Primary Key		purchase number		product id		purchased quantity		purchased price
(	default, 		1, 		1, 				4, 				1399.96	),
(	default, 		1, 		2, 				1, 				34.99	),
(	default, 		2,		5, 				3, 				14.97	),
(	default, 		2,		4, 				1,				6.99	),
(	default, 		3,		3, 				1,				289.99	),
(	default, 		4, 		5, 				9				39.92	)
;


INSERT INTO courses VALUES
('M01', 'Mathematics'),
('E01', 'English'),
('H01', 'History'),
('S01', 'Science')
;

INSERT INTO required_materials VALUES
-- course id		product id
(	'M01',			1),
(	'M01',			3),
(	'E01',			1),
(	'E01',			2),
(	'H01',			1),
(	'H01',			3),
(	'H01',			4),
(	'H01',			5),
(	'S01',			4),
(	'S01',			5)
;
-- # Create table views.
	
CREATE VIEW customer_list AS
	SELECT first_name, last_name, customer_phone, customer_email 
    FROM customers 
	ORDER BY first_name, last_name;

    
CREATE VIEW customer_purchases AS
	SELECT first_name, last_name, pc.purchase_date, pd.product_name, pi.purchased_quantity,pi.purchased_price
    FROM customers cm JOIN purchases pc
		ON cm.customer_id = pc.customer_id
     JOIN purchased_items pi
		ON pc.purchase_number = pi.purchase_number
	JOIN products pd
		ON pi.product_id = pd.product_id;

CREATE VIEW no_purchases AS
	SELECT first_name, last_name 
    FROM customers cm LEFT JOIN purchases pc
		ON cm.customer_id = pc.customer_id
	WHERE pc.customer_id IS NULL; 
    
CREATE VIEW course_materials AS
	SELECT cr.course_id, cr.course_name, pd.product_name 
    FROM courses cr JOIN required_materials rm
		ON cr.course_id = rm.course_id
    JOIN products pd
		ON rm.product_id = pd.product_id
	ORDER BY course_id; 

CREATE VIEW number_of_purchases AS
	SELECT first_name, last_name, COUNT(purchase_number) AS purchases 
    FROM customers cm LEFT JOIN purchases pc
		ON cm.customer_id = pc.customer_id
    GROUP BY cm.customer_id
    UNION
    SELECT first_name, last_name, COUNT(purchase_number) AS purchases
    FROM customers cm2 RIGHT JOIN purchases pc2
		ON cm2.customer_id = pc2.customer_id
	GROUP BY cm2.customer_id;    
	
-- # Testing Queries

-- select * from customers;
-- select * from products;
-- select * from courses;
-- select * from purchased_items;
-- select * from required_materials;
-- select * from purchases;


-- # Testing Quieries for views

-- select * from customer_list;
-- select * from customer_purchases;
-- select * from no_purchases;
-- select * from course_materials;
-- select * from number_of_purchases;
