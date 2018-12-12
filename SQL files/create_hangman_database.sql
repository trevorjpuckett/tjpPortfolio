-- ##########################################################################################################################
-- #
-- # Created by: 			Trevor J. Puckett
-- # 
-- # Date created: 			12/12/2018
-- # 
-- # Project name: 			Hangman Database
-- #
-- # Script purpose: 			create and populate a database for the operations and utilization
-- #                                    of a hangman application where the user will be able to	draw 
-- # 						from multiple word pools:
-- #							1) Developer entered words only
-- #							2) User entered words only
-- #							3) Developer & User entered words
-- #							4) Phrases randomly generated from developer words
-- #							5) Phrases randomly generated from user words
-- #							6) Phrases randomly generated from developer & user words
-- #							7) User entered phrases										 
-- #
-- ###########################################################################################################################

-- # create the database

DROP DATABASE IF EXISTS Hangman;
CREATE DATABASE Hangman;

-- # ensure focus is on proper database

USE Hangman;

-- # create tables

CREATE TABLE users
(
user_id 			INT 			NOT NULL 	PRIMARY KEY 	AUTO_INCREMENT,
user_name 			VARCHAR(13) 		NOT NULL	UNIQUE,
user_password 			VARCHAR(21)	 	NOT NULL,
user_date_created 		DATE 			NOT NULL,
user_bio 			VARCHAR(200)
);

CREATE TABLE words
(
word_id				INT 			NOT NULL 	PRIMARY KEY 	AUTO_INCREMENT,
word				VARCHAR(45)	 	NOT NULL,
word_creator_id 		INT 			NOT NULL,
CONSTRAINT words_fk_wordCreatorId
	FOREIGN KEY (word_creator_id)
    REFERENCES users (user_id)
);

CREATE TABLE statistics
(
attempt_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
word_id INT NOT NULL,
attempt_pass BOOLEAN NOT NULL,
CONSTRAINT statistics_fk_wordId
	FOREIGN KEY (word_id)
    REFERENCES words (word_id)
);

-- # populate tables for testing purposes

INSERT INTO users VALUES
-- user_id		user_name		user_password		user_date_created		user_bio
( default,		'developer',		'$131%32^10devel',	'2018-12-12',			'' 		),
( default,		'user1',		'genericpassword',	'2018-12-12',			'this is user1' ),
( default,		'user2',		'password',		'2018-12-12',			'this is user2' ),
( default,		'usere3',		'newpassword',		'2018-12-11',			'this is user3' )
;
INSERT INTO words VALUES
-- word_id 		word	 	word_creator_id
(default,	'word',				1),
(default,	'this',				1),
(default,	'these',			1),
(default,	'words',			1),
(default,	'theirs',			1),
(default,	'beer',				1),
(default,	'wine',				1),
(default,	'cold',				1),
(default,	'shorts',			1),
(default,	'lol',				2),
(default,	'rofl',				2),
(default,	'smh',				2),
(default,	'pooki',			3),
(default,	'snugglemuffin',		3),
(default,	'snubby',			3)
;

INSERT INTO statistics VALUES
-- attempt_id		word_id		attempt_pass
(	default,		1,			true	),
(	default,		1,			true	),
(	default,		1,			false	),
(	default,		1,			true	),
(	default,		1,			true	),
(	default,		2,			true	),
(	default,		2,			false	),
(	default,		2,			true	),
(	default,		2,			false	),
(	default,		2,			true	),
(	default,		5,			true	),
(	default,		5,			false	),
(	default,		5,			true	),
(	default,		8,			true	),
(	default,		7,			false	),
(	default,		7,			true	),
(	default,		10,			true	),
(	default,		14,			true	)
;


-- # create views

