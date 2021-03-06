## script for flaredb capstone project
## authors: Sean Dougan, Matthew McCarthy, James Massel, Michael Van Dyke and Gregory Uchitel

## instantiate normal admin user and database if not exists
## MyISAM will lock the tables during read/write, for concurrent access you have to explicitly declare
## InnoDB as the database engine

## reset database every instance for testing here if needed 
DROP DATABASE IF EXISTS flaredb;
CREATE USER IF NOT EXISTS 'admin' IDENTIFIED BY 'admin';

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
   CREATE TABLE table_club
(
	club_id int (11) AUTO_INCREMENT PRIMARY KEY,
	club_leader int (11),
    club_name varchar (30),
    category varchar(30),
    description varchar(4000),
    facebook_link varchar (200),
    display_picture varchar (200), #this is a a filepath pointing to the location of the image
    FOREIGN KEY (club_leader) REFERENCES `users`(userid) ON DELETE CASCADE
)
ENGINE=InnoDB;
##############################################################################################################
CREATE TABLE table_club_event 
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
CREATE TABLE table_user_club
#Table used to store what users have joined which clubs
(
	user_id int (11),
    club_id int (11),
    FOREIGN KEY (user_id) REFERENCES `users`(userid) ON DELETE CASCADE,
    FOREIGN KEY (club_id) REFERENCES table_club(club_id) ON DELETE CASCADE
);

################################################################################################################
CREATE TABLE table_course
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
    FOREIGN KEY (user_id) REFERENCES `users`(userid) ON DELETE CASCADE
)
   ENGINE=InnoDB;


###########################################################################################################3
CREATE TABLE table_course_time
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
CREATE TABLE table_assignment
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
CREATE TABLE table_study_session
(
	study_session_id int (11) AUTO_INCREMENT PRIMARY KEY,
    course_id int (11),
    session_length time,
    FOREIGN KEY (course_id) REFERENCES table_course(course_id) ON DELETE CASCADE
)
   ENGINE=InnoDB;


############################################################################################################
CREATE TABLE table_study_session_assignment 
#Used for the option of associating a sudy session to an assignment
(
	study_session_id int (11),
    assignment_id int (11),
    FOREIGN KEY (study_session_id) REFERENCES table_study_session(study_session_id) ON DELETE CASCADE,
    FOREIGN KEY (assignment_id) REFERENCES table_assignment(assignment_id) ON DELETE CASCADE
)
   ENGINE=InnoDB;
   
############################################################################################################
CREATE TABLE table_chat
#Used for the option of associating a sudy session to an assignment
(
	chat_id int (11) AUTO_INCREMENT PRIMARY KEY,
	user_1_id int (11),
    user_2_id int,
    total_messages int (11),
	FOREIGN KEY (user_1_id) REFERENCES `users`(userid) ON DELETE CASCADE,
	FOREIGN KEY (user_2_id) REFERENCES `users`(userid) ON DELETE CASCADE
    
)
   ENGINE=InnoDB;
   
#############################################################################################################
CREATE TABLE table_messages
(
	message_id int (11) AUTO_INCREMENT PRIMARY KEY,
	chat_id int (11),
    from_user_id int (11),
    to_user_id int (11),
    message varchar (250),
    message_time datetime,
    FOREIGN KEY (chat_id) REFERENCES table_chat(chat_id) ON DELETE CASCADE,
    FOREIGN KEY (from_user_id) REFERENCES `users`(userid) ON DELETE CASCADE,
    FOREIGN KEY (to_user_id) REFERENCES `users`(userid) ON DELETE CASCADE
)
	ENGINE=InnoDB;
    
CREATE TABLE table_note
(
	note_id int (11) AUTO_INCREMENT PRIMARY KEY,
    user_id int (11),
    original_file_name varchar (64),
    file_name varchar (64),
	course_name varchar (50),
    description varchar (64),
    file_extension varchar (64),
    file_path varchar(256),
    FOREIGN KEY (user_id) REFERENCES `users`(userid) ON DELETE CASCADE
)
ENGINE = InnoDB;

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
## --- Dummy users ---
INSERT INTO `users`(firstname, lastname, email, username, `password`, accountcreation, displaypicture, enabled, currentyear, semester) VALUES
('Matthew', 'McCarthy', 'mccarm416@gmail.com', 'bourgeois.goblin', 'password', '2018-02-03 20:34:09', '', 1, 3, 5);
INSERT INTO `users`(firstname, lastname, email, username, `password`, accountcreation, displaypicture, enabled, currentyear, semester) VALUES
('Jamie', 'Massel', 'jamiemassel@gmail.com', 'babyhands', 'password', '2018-02-03 20:45:16', '', 1, 3, 5);
INSERT INTO `users`(firstname, lastname, email, username, `password`, accountcreation, displaypicture, enabled, currentyear, semester) VALUES
('Sean', 'Dougan', 'mediauthority@gmail.com', 'svoogan', 'password', '2018-02-03 20:46:09', '', 1, 3, 5);
INSERT INTO `users`(firstname, lastname, email, username, `password`, accountcreation, displaypicture, enabled, currentyear, semester) VALUES
('Michael', 'Van Dyke', 'mhvandyke7@gmail.com', '78uh', 'password', '2018-02-03 20:47:09', '', 1, 3, 5);
INSERT INTO `users`(firstname, lastname, email, username, `password`, accountcreation, displaypicture, enabled, currentyear, semester) VALUES
('Gregory', 'Uchitel', 'greg.uchitel@gmail.com', 'sku11d3stroy3r', 'password', '2018-02-03 20:48:23', '', 1, 3, 5);
INSERT INTO authorities VALUES ("bourgeois.goblin", "ROLE_STUDENT");
INSERT INTO authorities VALUES ("babyhands", "ROLE_STUDENT");
INSERT INTO authorities VALUES ("svoogan", "ROLE_STUDENT");
INSERT INTO authorities VALUES ("78uh", "ROLE_STUDENT");
INSERT INTO authorities VALUES ("sku11d3stroy3r", "ROLE_STUDENT");

INSERT INTO `users`(firstname, lastname, email, username, `password`, accountcreation, displaypicture, enabled, currentyear, semester) VALUES
('Bill', 'Watterson', 'bwatts@gmail.com', 'CalvinHobbes', 'password', '2018-02-03 20:52:09', '', 1, 2, 4);
INSERT INTO `users`(firstname, lastname, email, username, `password`, accountcreation, displaypicture, enabled, currentyear, semester) VALUES
('Charles', 'Manson', 'notacreep@gmail.com', 'anormalguy', 'password', '2018-02-03 20:53:09', '', 1, 3, 5);
INSERT INTO `users`(firstname, lastname, email, username, `password`, accountcreation, displaypicture, enabled, currentyear, semester) VALUES
('Sarah', 'Palin', 'palin2020@gmail.com', 'repubgal', 'password', '2018-02-03 20:58:29', '', 1, 3, 6);
INSERT INTO `users`(firstname, lastname, email, username, `password`, accountcreation, displaypicture, enabled, currentyear, semester) VALUES
('Dillon', 'Francis', 'getlow@gmail.com', 'djjjjjj', 'password', '2018-02-03 21:00:00', '', 0, 2, 3);
INSERT INTO `users`(firstname, lastname, email, username, `password`, accountcreation, displaypicture, enabled, currentyear, semester) VALUES
('Josine', 'Arnott', 'josie@gmail.com', 'flowerpower', 'password', '2018-02-03 21:10:12', '', 1, 2, 4);

INSERT INTO `users`(firstname, lastname, email, username, `password`, accountcreation, displaypicture, enabled, currentyear, semester) VALUES
('John', 'Wendel', 'fatal1ty@gmail.com', 'Fatal1ty', 'password', '2018-02-03 21:11:09', '', 1, 1, 2);
INSERT INTO `users`(firstname, lastname, email, username, `password`, accountcreation, displaypicture, enabled, currentyear, semester) VALUES
('Margaret', 'Atwood', 'maggie@gmail.com', 'handmaiden', 'password', '2018-02-03 21:13:27', '', 1, 3, 5);
INSERT INTO `users`(firstname, lastname, email, username, `password`, accountcreation, displaypicture, enabled, currentyear, semester) VALUES
('John', 'Doe', 'jdoe@gmail.com', 'deadman666', 'password', '2018-02-03 21:15:27', '', 1, 2, 3);
INSERT INTO `users`(firstname, lastname, email, username, `password`, accountcreation, displaypicture, enabled, currentyear, semester) VALUES
('Mary-Jane', 'Watson', 'mjw@gmail.com', 'spideyfangirl', 'password', '2018-02-03 21:13:54', '', 1, 2, 4);
INSERT INTO `users`(firstname, lastname, email, username, `password`, accountcreation, displaypicture, enabled, currentyear, semester) VALUES
('Testy', 'Von Testington', 'test@gmail.com', 'TheTestMan', 'password', '2018-02-04 12:10:00', '', 1, 1, 1);

# --- Dummy Courses --- 
INSERT INTO table_course(user_id, course_code, course_name, grade,  professor1_name, professor1_email, professor2_name, professor2_email) VALUES
(1, 'COMP3080', 'Emerging Technologies',  75, 'Leila Mansoori', 'leila.mansoori@georgebrown.ca', 'Hooman Salamat', 'hooman.salamat@georgebrown.ca');
INSERT INTO table_course(user_id, course_code, course_name, grade,  professor1_name, professor1_email) VALUES
(1, 'COMP3097', 'Mobile Application Development 2', 86, 'Przemyslaw Z. Pawluk', 'ppawluk@georgebrown.ca');
INSERT INTO table_course(user_id, course_code, course_name, grade, professor1_name, professor1_email) VALUES
(1, 'COMP3060', 'Linux Fundamentals', 86, 'Jonathan Barrie', 'jonathan.barrie@georgebrown.ca');
INSERT INTO table_course(user_id, course_code, course_name, grade,  professor1_name, professor1_email) VALUES
(1, 'COMP3065', 'Business Intelligence', 70, 'Teacher McTeach', 'teacher@georgebrown.ca');
INSERT INTO table_course(user_id, course_code, course_name, grade,  professor1_name, professor1_email) VALUES
(1, 'COMP3078', 'Capstone 2', 86, 'Anjana Shah', 'ashah@georgebrown.ca');
INSERT INTO table_course(user_id, course_code, course_name, grade,  professor1_name, professor1_email) VALUES
(1, 'GSCI1003', 'Truth & Lies: Understanding Stats', 70, 'Elena Chudaeva', 'echudaeva@georgebrown.ca');

INSERT INTO table_course(user_id, course_code, course_name, grade,  professor1_name, professor1_email, professor2_name, professor2_email) VALUES
(15, 'COMP1176', 'Introduction to Networks - CCNA 1', 60, 'Karim Allidina', 'kallidina@georgebrown.ca', 'Stephan Caneff', 'scaneff@georgebrown.ca');
INSERT INTO table_course(user_id, course_code, course_name, grade,  professor1_name, professor1_email, professor2_name, professor2_email) VALUES
(15, 'COMP1151', 'IT Essentials', 54, 'Abid Rana', 'arana@georgebrown.ca', 'Danish Khan', 'danish.khan@georgebrown.ca');
INSERT INTO table_course(user_id, course_code, course_name, grade, professor1_name, professor1_email) VALUES
(15, 'COMP1223', 'Web Development Fundamentals', 24, 'Anjana Shah', 'ashah@georgebrown.ca');
INSERT INTO table_course(user_id, course_code, course_name, grade,  professor1_name, professor1_email) VALUES
(15, 'COMM1003', 'English Skills', 70, 'Lara Sauer', 'lsauer@georgebrown.ca');
INSERT INTO table_course(user_id, course_code, course_name, grade,  professor1_name, professor1_email) VALUES
(15, 'GSSC1045', 'Business Appl. for IT', 100, 'George Gorsline', 'ggorsline@georgebrown.ca');
INSERT INTO table_course(user_id, course_code, course_name, grade, professor1_name, professor1_email) VALUES
(15, 'MATH1162', 'Mathematics for Computer Technology 1', 79, 'Tanya Holtzman', 'tholtzman@georgebrown.ca');

#################################################################################################################
# --- Dummy Assignments --- 
INSERT INTO table_assignment(course_id, assignment_name, due_date, grade, grade_weight) VALUES
(1, 'Team Charter', '2018-02-5 21:00:00', 100, 15);
INSERT INTO table_assignment(course_id, assignment_name, due_date, grade, grade_weight) VALUES
(1, 'Project Proposal', '2018-02-12 21:00:00', 100, 30);
INSERT INTO table_assignment(course_id, assignment_name, due_date) VALUES
(2, 'Assignment 1 - Mobile App', '2018-03-30 08:00:00'); #Assignment due in the future, no grade yet
INSERT INTO table_assignment(course_id, assignment_name, due_date, grade, grade_weight) VALUES
(3, 'Linux Test 1', '2018-02-6 08:00:00', 80, 10);
# --- Dummy Clubs ---
INSERT INTO table_club(club_leader, club_name, category, description, facebook_link, display_picture) VALUES
(1, 'Magic: the Gathering Club', 'Hobbies', 'A club for people who enjoy playing Wizards of the Coast\'s hit card game Magic: the Gathering', 'https://www.facebook.com/groups/806962692719800/about/', '');
INSERT INTO table_club(club_leader, club_name, category, description, facebook_link, display_picture) VALUES
(2, 'League of Legends Club', 'Hobbies', 'A place to get together and pwn n00bs', 'https://www.facebook.com/groups/gblolcom/', '');
INSERT INTO table_club(club_leader, club_name, category, description, facebook_link, display_picture) VALUES
(3, 'Coding Club', 'Academic', 'Club used to argue over best practice regarding coding', '', '');
INSERT INTO table_club(club_leader, club_name, category, description, facebook_link, display_picture) VALUES
(4, 'Gaming Club', 'Hobbies', 'Talk about the latest video games here', '', '');
INSERT INTO table_club(club_leader, club_name, category, description, facebook_link, display_picture) VALUES
(5, 'Greg Fan Club', 'Religion', 'Pay homage to Gregory Uchitel', '', '');

#################################################################################################################
# --- Dummy User-Club  ---
INSERT INTO table_user_club(user_id, club_id) VALUES
(1, 1);
INSERT INTO table_user_club(user_id, club_id) VALUES
(2, 2);
INSERT INTO table_user_club(user_id, club_id) VALUES
(3, 3);
INSERT INTO table_user_club(user_id, club_id) VALUES
(4, 4);
INSERT INTO table_user_club(user_id, club_id) VALUES
(5, 5);
INSERT INTO table_user_club(user_id, club_id) VALUES
(15, 1);
INSERT INTO table_user_club(user_id, club_id) VALUES
(15, 2);
INSERT INTO table_user_club(user_id, club_id) VALUES
(15, 3);
INSERT INTO table_user_club(user_id, club_id) VALUES
(15, 4);
INSERT INTO table_user_club(user_id, club_id) VALUES
(15, 5);

# --- Dummy Club-Events ---
INSERT INTO table_club_event(club_id, event_name, event_time, location, recurring, display_picture, description) VALUES
(1, 'Weekly Booster Draft Meetup', '2018-03-03 21:00:00', 'Student Lounge', 2, '', 'Our weekly booster draft nmeetup. Please bring $10 to participate and cover the cost of the booster packs. Bring any food you like, just no drinks please!');
INSERT INTO table_club_event(club_id, event_name, event_time, location, recurring, display_picture, description) VALUES
(1, 'Commander Game', '2018-03-27 16:00:00', 'Pour House', 0, '', 'Get drunk and play Commander format at the Pour House. We will have spare decks if people want to bring their friends or don\t have their own commander decks. Lets get drunk and have fun!');
INSERT INTO table_club_event(club_id, event_name, event_time, location, recurring, display_picture, description) VALUES
(1, 'CLub Discussion', '2018-03-25 21:00:00', 'Student Lounge', 4, '', 'Monthly club discussion to give feedback and suggestions');
INSERT INTO table_club_event(club_id, event_name, event_time, location, recurring, display_picture, description) VALUES
(2, 'League of Legends Tournament', '2018-04-01 12:00:00', 'Jamies\' House', 0, '', 'Getting together to run a torunament at Jamies\s house. BYOB/W!');
INSERT INTO table_club_event(club_id, event_name, event_time, location, recurring, display_picture, description) VALUES
(3, 'Waterloo Hackathon', '2018-04-20 13:30:00', 'Waterloo University', 0, '', 'Participating in a hackathon at Waterloo University. We will be leaving from Union Station at 10:30AM so please be on time. Bring your A-game and lets kick some ass and show those nerds whats up.');
INSERT INTO table_club_event(club_id, event_name, event_time, location, recurring, display_picture, description) VALUES
(3, 'Waterloo Hackathon', '2018-04-20 13:30:00', 'Waterloo University', 0, '', 'Participating in a hackathon at Waterloo University. We will be leaving from Union Station at 10:30AM so please be on time. Bring your A-game and lets kick some ass and show those nerds whats up.');
INSERT INTO table_club_event(club_id, event_name, event_time, location, recurring, display_picture, description) VALUES
(3, 'Hackathon Practice', '2018-03-15 14:15:00', 'GBC Campus', 3, '', 'Our bi-weekly meetup to practice for upcoming hacathons. We will be designing small apps within an 8 hour period.');
INSERT INTO table_club_event(club_id, event_name, event_time, location, recurring, display_picture, description) VALUES
(4, 'Smash Bros Tournament', '2018-03-12 15:00:00', 'Student Lounge', 3, '', 'Bi-weekly Super Smash Bros.: Melee tournament. May the best player win!');
INSERT INTO table_club_event(club_id, event_name, event_time, location, recurring, display_picture, description) VALUES
(4, 'DRAGON BALL Fighter Z Tournament', '2018-03-20 18:00:00', 'Michael\'s House', 3, '', 'The bi-weekly tournament for DRAGON BALL Fighter Z');
INSERT INTO table_club_event(club_id, event_name, event_time, location, recurring, display_picture, description) VALUES
(5, 'Greg Weekly Praise Day', '2018-03-11 08:00:00', 'Church of Greg', 2, '', 'Weekly meetup to discuss our lord and saviour, Gregory Uchitel. Kool-aid will be available to all who come. Please fast for the previous 48 hours to show your devotion to our saviour.');
 
 # --- Dummy Chats ---
INSERT INTO table_chat(user_1_id, user_2_id, total_messages) VALUES
(1, 2, 0);

INSERT INTO table_chat(user_1_id, user_2_id, total_messages) VALUES
(3, 9, 0);


# --- Dummy Messages ---

INSERT INTO table_messages(chat_id, from_user_id, to_user_id, message, message_time) VALUES
(1, 1, 2, 'Hey Jamie, do you like up dog??','2018-02-03 22:45:16');
INSERT INTO table_messages(chat_id, from_user_id, to_user_id, message, message_time) VALUES
(1, 2, 1, 'What\'s updog???','2018-02-03 22:46:16');
INSERT INTO table_messages(chat_id, from_user_id, to_user_id, message, message_time) VALUES
(1, 1, 2, 'Notthing much G, what\'s up wichu?','2018-02-03 22:47:28');
INSERT INTO table_messages(chat_id, from_user_id, to_user_id, message, message_time) VALUES
(1, 1, 2, 'HAHAHAHAHAHAHA','2018-02-03 20:47:30');
INSERT INTO table_messages(chat_id, from_user_id, to_user_id, message, message_time) VALUES
(1, 2, 1, ':|','2018-02-03 20:47:28');

 INSERT INTO table_messages(chat_id, from_user_id, to_user_id, message, message_time) VALUES
(2, 3, 9, 'UR NEW STUFF IS LIT YO','2018-02-08 21:00:10');
INSERT INTO table_messages(chat_id, from_user_id, to_user_id, message, message_time) VALUES
(2, 9, 3, 'Thanks man!','2018-02-08 21:15:50');


## set access privelage here after table creation
GRANT ALL PRIVILEGES ON flaredb.* TO 'admin'@'localhost';

## TODO make views of joined tables from user too specialized user data for quick lookup
