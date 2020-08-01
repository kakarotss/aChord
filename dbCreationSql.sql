DROP TABLE IF EXISTS courseLine;
DROP TABLE IF EXISTS chords;
DROP TABLE IF EXISTS course;
DROP TABLE IF EXISTS users;

Create database if not exists ache ;


CREATE TABLE users(
userId INT AUTO_INCREMENT,
username VARCHAR(50),
userPassword VARCHAR(50),
email VARCHAR(50),
firstName VARCHAR (50),
lastName VARCHAR (50),
userLevel INT (5),
PRIMARY KEY (userId)

);


CREATE TABLE course(
courseId INT AUTO_INCREMENT,
courseName VARCHAR (50),
courseLevel INT (5),
courseImg VARCHAR (80),
primary key (courseId)
);

CREATE TABLE chords(
chordId INT AUTO_INCREMENT,
courseId INT,
chordTitle VARCHAR (80),
chordDescription VARCHAR (100),
chordImg VARCHAR (80),
PRIMARY KEY (chordId),
foreign key (courseId) references course(courseId)
);

CREATE TABLE courseLine(
courseLineId INT AUTO_INCREMENT,
courseId INT,
userId INT,
primary key(courseLineId),
foreign key(courseId) references course(courseId),
foreign key(userId) references users(userId)
);
