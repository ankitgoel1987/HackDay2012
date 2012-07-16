CREATE TABLE hourlydata (
  hourlyDataID varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  weatherCondition varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  weatherDate varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  humidity varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  iconUrl varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  temperature varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  timeRange varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (hourlyDataID),
  UNIQUE KEY hourlyDataID (hourlyDataID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE users (
  userID int(11) NOT NULL AUTO_INCREMENT,
  email varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  enabled varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  name varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  password varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  phoneNumber varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  username varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  authorityID int(11) DEFAULT NULL,
  golfCourseID int(11) DEFAULT NULL,
  PRIMARY KEY (userID),
  UNIQUE KEY userID (userID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE reservationdetails (
  confirmationNumber int(11) NOT NULL AUTO_INCREMENT,
  bookingDateTime datetime DEFAULT NULL,
  gameDate varchar(50) DEFAULT NULL,
  noOfGolfers int(11) DEFAULT NULL,
  reminderRequired tinyint(1) DEFAULT NULL,
  status int(11) DEFAULT NULL,
  teeDateTime datetime DEFAULT NULL,
  timeRange varchar(50) DEFAULT NULL,
  golfCourseID int(11) DEFAULT NULL,
  userID int(11),
  PRIMARY KEY (confirmationNumber),
  UNIQUE KEY confirmationNumber (confirmationNumber)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE authorities (
  authorityID int(11) NOT NULL AUTO_INCREMENT,
  authority varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (authorityID),
  UNIQUE KEY authorityID (authorityID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE capacity (
  capacityID int(11) NOT NULL,
  golfCourseID int(11),
  maxcount int(11) DEFAULT NULL,
  teetime varchar(50) DEFAULT NULL,
  PRIMARY KEY (capacityID),
  UNIQUE KEY capacityID (capacityID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE golfcourse (
  golfCourseID int(11) NOT NULL AUTO_INCREMENT,
  bannerImageURL varchar(100) DEFAULT NULL,
  cssName varchar(50) DEFAULT NULL,
  homePageLongText varchar(100) DEFAULT NULL,
  homePageShortText varchar(100) DEFAULT NULL,
  imageURL1 varchar(100) DEFAULT NULL,
  imageURL2 varchar(100) DEFAULT NULL,
  imageURL3 varchar(100) DEFAULT NULL,
  latitude varchar(100) DEFAULT NULL,
  longitude varchar(100) DEFAULT NULL,
  name varchar(50) DEFAULT NULL,
  urlExtension varchar(50) DEFAULT NULL,
  PRIMARY KEY (golfCourseID),
  UNIQUE KEY golfCourseID (golfCourseID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into authorities values(1, 'ROLE_SAASOWNER');
insert into authorities values(2, 'ROLE_GOLFCLUBOWNER');
insert into authorities values(3, 'ROLE_GOLFCLUBMEMBER');
insert into authorities values(4, 'ROLE_ADMIN');
insert into authorities values(5, 'ROLE_MEMBER');

insert into golfcourse values(1, "bannerImageURL", "cssName", "homePageLongText", "homePageShortText", 
"imageURL1", "imageURL2", "imageURL3", "latitude", "longitude", "GolfCourseName", "urlExtension");

insert into users values(1, 'dhoni@gmail.com', 'true', 'Mahinder Singh Dhoni', '78d7a82604de80d2b191e92a96d23a2803c0a0e910a32a6744e3ecd41e4da4cf', '+918978993113', 'saasowner', 1, 1);
insert into users values(2, 'dhoni@gmail.com', 'true', 'Mahinder Singh Dhoni', '78d7a82604de80d2b191e92a96d23a2803c0a0e910a32a6744e3ecd41e4da4cf', '+918978993113', 'golfclubowner', 2, 1);
insert into users values(3, 'dhoni@gmail.com', 'true', 'Mahinder Singh Dhoni', '78d7a82604de80d2b191e92a96d23a2803c0a0e910a32a6744e3ecd41e4da4cf', '+918978993113', 'golfclubmember', 3, 1);
insert into users values(4, 'dhoni@gmail.com', 'true', 'Mahinder Singh Dhoni', '78d7a82604de80d2b191e92a96d23a2803c0a0e910a32a6744e3ecd41e4da4cf', '+918978993113', 'admin', 4, 1);
insert into users values(5, 'dhoni@gmail.com', 'true', 'Mahinder Singh Dhoni', '78d7a82604de80d2b191e92a96d23a2803c0a0e910a32a6744e3ecd41e4da4cf', '+918978993113', 'member', 5, 1);


insert into reservationdetails values(1, NOW(), "16-7-2012", 5, 1, 1, NOW(), "6-7", 1, 3);
insert into reservationdetails values(2, NOW(), "16-7-2012", 5, 1, 1, NOW(), "8-9", 1, 3);
insert into reservationdetails values(3, NOW(), "16-7-2012", 10, 1, 1, NOW(), "11-12", 1, 3);
insert into reservationdetails values(4, NOW(), "16-7-2012", 10, 1, 1, NOW(), "12-13", 1, 3);
insert into reservationdetails values(5, NOW(), "16-7-2012", 15, 1, 1, NOW(), "14-15", 1, 3);
insert into reservationdetails values(6, NOW(), "16-7-2012", 15, 1, 1, NOW(), "15-16", 1, 3);


insert into capacity values(1, 1, 15, "6-7");
insert into capacity values(2, 1, 15, "7-8");
insert into capacity values(3, 1, 15, "8-9");
insert into capacity values(4, 1, 15, "9-10");
insert into capacity values(5, 1, 15, "10-11");
insert into capacity values(6, 1, 15, "11-12");
insert into capacity values(7, 1, 15, "12-13");
insert into capacity values(8, 1, 15, "13-14");
insert into capacity values(9, 1, 15, "14-15");
insert into capacity values(10, 1, 15, "15-16");
insert into capacity values(11, 1, 15, "16-17");
insert into capacity values(12, 1, 15, "17-18");




ALTER TABLE reservationdetails 
ADD CONSTRAINT FOREIGN KEY (userID) REFERENCES users(userID) ON DELETE
CASCADE ON UPDATE CASCADE;

ALTER TABLE reservationdetails 
ADD CONSTRAINT FOREIGN KEY (golfcourseID) REFERENCES golfcourse(golfcourseID) ON DELETE
CASCADE ON UPDATE CASCADE;

ALTER TABLE capacity 
ADD CONSTRAINT FOREIGN KEY (golfCourseID) REFERENCES golfcourse(golfcourseID) ON DELETE
CASCADE ON UPDATE CASCADE;

ALTER TABLE users
ADD CONSTRAINT FOREIGN KEY (authorityID) REFERENCES authorities(authorityID) ON DELETE
CASCADE ON UPDATE CASCADE;

ALTER TABLE users
ADD CONSTRAINT FOREIGN KEY (golfcourseID) REFERENCES golfcourse(golfcourseID) ON DELETE
CASCADE ON UPDATE CASCADE;
