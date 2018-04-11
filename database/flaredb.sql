## script for flaredb capstone project
## authors: Sean Dougan, Matthew McCarthy, James Massel, Michael Van Dyke and Gregory Uchitel

## instantiate normal admin user and database if not exists
## MyISAM will lock the tables during read/write, for concurrent access you have to explicitly declare
## InnoDB as the database engine

## reset database every instance for testing here if needed 
DROP DATABASE IF EXISTS flaredb;
CREATE USER IF NOT EXISTS admin IDENTIFIED BY 'admin';

## set user access privelages here
CREATE DATABASE IF NOT EXISTS flaredb;

## scope the database engine to read/write flaredb so we don't have to qualify with flaredb.tableName
USE flaredb;



## create database tables if not exists
## all users share some common information

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
	userid int(11) PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(50) NOT NULL UNIQUE,
    `password` VARCHAR(255) NOT NULL, 
    email CHAR(50) NOT NULL UNIQUE, 
    firstname VARCHAR(25), 
    lastname VARCHAR(25),
    accountcreation DATE,
    displaypicture VARCHAR(200), #this is a a filepath pointing to the location of the image
    enabled TINYINT(1), 
    currentyear INT (4),
    semester INT(1)
   )
   
   ## MUST DECLARE InnoDB ENGINE HERE
   ENGINE=InnoDB;
#####################################################################################################
DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
	`username` VARCHAR(50) NOT NULL,
    `authority` VARCHAR(50) NOT NULL,
    UNIQUE KEY `authorities_idx_1`(`username`,`authority`),
    CONSTRAINT `authorities_ibfk_1` FOREIGN KEY(`username`) REFERENCES `users`(`username`)
    ON DELETE CASCADE
)
ENGINE=InnoDB;


   
   #############################################################################################################
   CREATE TABLE IF NOT EXISTS table_club
(
	club_id int (11) AUTO_INCREMENT PRIMARY KEY,
	club_leader int (11),
    club_name varchar (30),
    category varchar(30),
    description varchar(4000),
    facebook_link varchar (200),
    display_picture varchar (200), #this is a a filepath pointing to the location of the image
    FOREIGN KEY user_club_fk(club_leader) REFERENCES users(userid) ON DELETE CASCADE
)
   ENGINE=InnoDB;


##############################################################################################################
CREATE TABLE IF NOT EXISTS table_club_event 
(
	club_event_id int (11) AUTO_INCREMENT PRIMARY KEY,
    club_id int (11),
    event_name varchar(50),
    event_time datetime,
    location varchar(100),
    recurring int (1), #0 for non-recurring 1 for daily, 2 for weekly, 3 for bi-weekly, 4 for monthly
    display_picture varchar (400), #this is a a filepath pointing to the location of the image
    description varchar (4000),
    FOREIGN KEY (club_id) REFERENCES table_club(club_id) ON DELETE CASCADE
)
   ENGINE=InnoDB;

#15 events between the 5 clubs. Leave one club with 0 events. There should be atleast one event for each type of recurring level

###############################################################################################################
CREATE TABLE IF NOT EXISTS table_user_club
#Table used to store what users have joined which clubs
(
	user_id int (11),
    club_id int (11),
    FOREIGN KEY (user_id) REFERENCES users(userid) ON DELETE CASCADE,
    FOREIGN KEY (club_id) REFERENCES table_club(club_id) ON DELETE CASCADE
);

################################################################################################################
CREATE TABLE IF NOT EXISTS table_course
(
	course_id int (11) AUTO_INCREMENT PRIMARY KEY,
    user_id int (11),
    course_code varchar (8),
    course_name varchar (50),
    grade double (5, 2),
    professor1_name char(65),
    professor1_email varchar (100),
    professor2_name char(65),
    professor2_email varchar (100),
    FOREIGN KEY (user_id) REFERENCES users(userid) ON DELETE CASCADE
)
   ENGINE=InnoDB;


###########################################################################################################3
CREATE TABLE IF NOT EXISTS table_course_time
(
	course_time_id int (11) AUTO_INCREMENT PRIMARY KEY,
    course_id int (11),
	user_id int (11),
	time_start time ,
    time_length int (2),
    time_day character (9),
    lab_lecture int(1),
    FOREIGN KEY (course_id) REFERENCES table_course(course_id) ON DELETE CASCADE
)
   ENGINE=InnoDB;


##############################################################################################################
CREATE TABLE IF NOT EXISTS table_assignment
(
	assignment_id int (11) AUTO_INCREMENT PRIMARY KEY,
    course_id int (11),
    assignment_name varchar (50),
    grade_weight double(5, 2),
	grade double (5, 2),
    due_date datetime,
    FOREIGN KEY (course_id) REFERENCES table_course(course_id) ON DELETE CASCADE
)
   ENGINE=InnoDB;


#########################################################################################################
CREATE TABLE IF NOT EXISTS table_study_session
(
	study_session_id int (11) AUTO_INCREMENT PRIMARY KEY,
    course_id int (11),
    session_length time,
    FOREIGN KEY (course_id) REFERENCES table_course(course_id) ON DELETE CASCADE
)
   ENGINE=InnoDB;


############################################################################################################
CREATE TABLE IF NOT EXISTS table_study_session_assignment 
#Used for the option of associating a sudy session to an assignment
(
	study_session_id int (11),
    assignment_id int (11),
    FOREIGN KEY (study_session_id) REFERENCES table_study_session(study_session_id) ON DELETE CASCADE,
    FOREIGN KEY (assignment_id) REFERENCES table_assignment(assignment_id) ON DELETE CASCADE
)
   ENGINE=InnoDB;
   
   #########################################################################################################
   ## VIEWS
	
CREATE OR REPLACE VIEW auth_user (userid, username, `password`, email, firstname, lastname, accountcreation,
    displaypicture, enabled, currentyear, semester, authority) AS
	SELECT userid, users.username, `password`, email, firstname, lastname, accountcreation,
    displaypicture, enabled, currentyear, semester, authority
    FROM users
    JOIN authorities
    ON users.username = authorities.username;
    
	#########################################################################################################
    ## TRIGGERS
    
    
    
    ##########################################################################################################
    ## STORED PROCEDURE


#############################################################################################################

## INSERT ROLES
INSERT INTO `users`(firstname, lastname, email, username, `password`, accountcreation, displaypicture, enabled, currentyear, semester) VALUES
('Matthew', 'McCarthy', 'mccarm416@gmail.com', 'bourgeois.goblin', '{bcrypt}$2a$04$YwoCa6amUc7dYF.eFlsuDe9n9aAmEz.q9.pJyUPDbrvLKvZehAnxS', '2018-02-03 20:34:09', '', 1, 3, 5);
INSERT INTO `users`(firstname, lastname, email, username, `password`, accountcreation, displaypicture, enabled, currentyear, semester) VALUES
('Jamie', 'Massel', 'jamiemassel@gmail.com', 'babyhands', '{bcrypt}$2a$04$YwoCa6amUc7dYF.eFlsuDe9n9aAmEz.q9.pJyUPDbrvLKvZehAnxS', '2018-02-03 20:45:16', '', 1, 3, 5);
INSERT INTO `users`(firstname, lastname, email, username, `password`, accountcreation, displaypicture, enabled, currentyear, semester) VALUES
('Sean', 'Dougan', 'mediauthority@gmail.com', 'svoogan', '{bcrypt}$2a$04$YwoCa6amUc7dYF.eFlsuDe9n9aAmEz.q9.pJyUPDbrvLKvZehAnxS', '2018-02-03 20:46:09', '', 1, 3, 5);
INSERT INTO `users`(firstname, lastname, email, username, `password`, accountcreation, displaypicture, enabled, currentyear, semester) VALUES
('Michael', 'Van Dyke', 'mhvandyke7@gmail.com', '78uh', '{bcrypt}$2a$04$YwoCa6amUc7dYF.eFlsuDe9n9aAmEz.q9.pJyUPDbrvLKvZehAnxS', '2018-02-03 20:47:09', '', 1, 3, 5);
INSERT INTO `users`(firstname, lastname, email, username, `password`, accountcreation, displaypicture, enabled, currentyear, semester) VALUES
('Gregory', 'Uchitel', 'greg.uchitel@gmail.com', 'sku11d3stroy3r', '{bcrypt}$2a$04$YwoCa6amUc7dYF.eFlsuDe9n9aAmEz.q9.pJyUPDbrvLKvZehAnxS', '2018-02-03 20:48:23', '', 1, 3, 5);

INSERT INTO authorities VALUES ("bourgeois.goblin", "ROLE_STUDENT");
INSERT INTO authorities VALUES ("babyhands", "ROLE_STUDENT");
INSERT INTO authorities VALUES ("svoogan", "ROLE_STUDENT");
INSERT INTO authorities VALUES ("78uh", "ROLE_STUDENT");
INSERT INTO authorities VALUES ("sku11d3stroy3r", "ROLE_STUDENT");
# --- Dummy users ---


 
## set access privelage here after table creation
GRANT ALL PRIVILEGES ON flaredb.* TO 'admin'@'localhost';



## TODO make views of joined tables from user too specialized user data for quick lookup
