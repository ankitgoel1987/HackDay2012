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
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


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
  UNIQUE KEY userID (userID),
  KEY FK6A68E084653685C (golfCourseID),
  KEY FK6A68E0812D06B18 (authorityID)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE reservationdetails (
  confirmationNumber int(11) NOT NULL AUTO_INCREMENT,
  bookingDateTime datetime DEFAULT NULL,
  noOfGolfers int(11) DEFAULT NULL,
  reminderRequired tinyint(1) DEFAULT NULL,
  status int(11) DEFAULT NULL,
  teeDateTime datetime DEFAULT NULL,
  golfCourseID int(11) DEFAULT NULL,
  userID int(11) DEFAULT NULL,
  PRIMARY KEY (confirmationNumber),
  UNIQUE KEY confirmationNumber (confirmationNumber),
  KEY FK869210F64653685C (golfCourseID),
  KEY FK869210F6E0633F47 (userID)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE authorities (
  authorityID int(11) NOT NULL AUTO_INCREMENT,
  authority varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (authorityID),
  UNIQUE KEY authorityID (authorityID)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE capacity (
  capacityID int(11) NOT NULL,
  golfCourseID int(11) DEFAULT NULL,
  maxcount int(11) DEFAULT NULL,
  teetime time DEFAULT NULL,
  PRIMARY KEY (capacityID),
  UNIQUE KEY capacityID (capacityID)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE golfcourse (
  golfCourseID int(11) NOT NULL AUTO_INCREMENT,
  bannerImage tinyblob,
  contactUsPageHTML tinyint(1) DEFAULT NULL,
  contactUsPageText longtext COLLATE utf8_unicode_ci,
  cssName varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  facilityPageHTML tinyint(1) DEFAULT NULL,
  facilityPageImage tinyblob,
  facilityPageMenuName varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  facilityPageText longtext COLLATE utf8_unicode_ci,
  googleMapUrl varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  homePageHTML tinyint(1) DEFAULT NULL,
  homePageImage tinyblob,
  homePageMenuName varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  homePageText longtext COLLATE utf8_unicode_ci,
  name varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  urlExtension varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (golfCourseID),
  UNIQUE KEY golfCourseID (golfCourseID)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

insert into authorities values(1, 'ROLE_SAASOWNER');
insert into authorities values(2, 'ROLE_GOLFCLUBOWNER');
insert into authorities values(3, 'ROLE_GOLFCLUBMEMBER');
insert into authorities values(4, 'ROLE_ADMIN');
insert into authorities values(5, 'ROLE_MEMBER');

insert into users values(1, 'dhoni@gmail.com', 'true', 'Mahinder Singh Dhoni', '78d7a82604de80d2b191e92a96d23a2803c0a0e910a32a6744e3ecd41e4da4cf', '+918978993113', 'saasowner', 1, 1);
insert into users values(2, 'dhoni@gmail.com', 'true', 'Mahinder Singh Dhoni', '78d7a82604de80d2b191e92a96d23a2803c0a0e910a32a6744e3ecd41e4da4cf', '+918978993113', 'golfclubowner', 2, 1);
insert into users values(3, 'dhoni@gmail.com', 'true', 'Mahinder Singh Dhoni', '78d7a82604de80d2b191e92a96d23a2803c0a0e910a32a6744e3ecd41e4da4cf', '+918978993113', 'golfclubmember', 3, 1);
insert into users values(4, 'dhoni@gmail.com', 'true', 'Mahinder Singh Dhoni', '78d7a82604de80d2b191e92a96d23a2803c0a0e910a32a6744e3ecd41e4da4cf', '+918978993113', 'admin', 4, 1);
insert into users values(5, 'dhoni@gmail.com', 'true', 'Mahinder Singh Dhoni', '78d7a82604de80d2b191e92a96d23a2803c0a0e910a32a6744e3ecd41e4da4cf', '+918978993113', 'member', 5, 1);

insert into golfcourse values(1, "", false, "Contact Us Page Text", "CSSNAME", 
false, "", "facilityPageMenuName", "facilityPageText", "googleMapURL", 
false, "", "homePageMenuName", "homePageText", "name", "urlExtension");

insert into reservationdetails values(1, NOW(), 5, true, 1, NOW(), 1, 3);
insert into reservationdetails values(2, NOW(), 5, true, 1, NOW(), 1, 3);
insert into reservationdetails values(3, NOW(), 5, true, 1, NOW(), 1, 3);

insert into capacity values(1, 1, 15, "23:23:23");


ALTER TABLE reservationdetails 
ADD CONSTRAINT FOREIGN KEY (userID) REFERENCES users(userID) ON DELETE
CASCADE ON UPDATE CASCADE;

ALTER TABLE reservationdetails 
ADD CONSTRAINT FOREIGN KEY (golfcourseID) REFERENCES golfcourse(golfcourseID) ON DELETE
CASCADE ON UPDATE CASCADE;

ALTER TABLE capacity 
ADD CONSTRAINT FOREIGN KEY (capacityID) REFERENCES golfcourse(golfcourseID) ON DELETE
CASCADE ON UPDATE CASCADE;

ALTER TABLE users
ADD CONSTRAINT FOREIGN KEY (authorityID) REFERENCES authorities(authorityID) ON DELETE
CASCADE ON UPDATE CASCADE;

ALTER TABLE users
ADD CONSTRAINT FOREIGN KEY (golfcourseID) REFERENCES golfcourse(golfcourseID) ON DELETE
CASCADE ON UPDATE CASCADE;
