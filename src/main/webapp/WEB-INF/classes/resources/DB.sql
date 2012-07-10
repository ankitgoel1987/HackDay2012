CREATE TABLE IF NOT EXISTS SessionData (
        userID int(6) NOT NULL,
		loginDateTime datetime NOT NULL,
        ipAddress varchar(50)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS USERS (
        USER_ID int(6) NOT NULL AUTO_INCREMENT,
		UserName varchar(50) NOT NULL,
        Password varchar(100) NOT NULL,
        AUTHORITY_ID int(6) NOT NULL,
        ENABLED varchar(50) NOT NULL DEFAULT true,
		name	varchar(50),
		email	varchar(50),
		phoneNumber	varchar(50),
		golfCourseID	int(6) NOT NULL,
        PRIMARY KEY (USER_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
CREATE TABLE IF NOT EXISTS AUTHORITIES (
        AUTHORITY_ID int(6) NOT NULL AUTO_INCREMENT,
        AUTHORITY varchar(50) NOT NULL,
        PRIMARY KEY (AUTHORITY_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS GolfCourse (
		golfCourseID	int(6) AUTO_INCREMENT,
		name	varchar(50),
		bannerImage	blob,
		urlExtension	varchar(50),
		homePageMenuName	varchar(50),
		homePageHTML	boolean,
		homePageImage	blob,
		homePageText	varchar(500),
		facilityPageMenuName	varchar(50),
		facilityPageHTML	boolean,
		facilityPageImage	blob,
		facilityPageText	varchar(500),
		cssName	varchar(50),
		contactUsPageHTML	boolean,
		contactUsPageText	varchar(500),
		googleMapUrl	varchar(50),
		 PRIMARY KEY (golfCourseID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS ReservationDetails (
        confirmationNumber int(6) NOT NULL AUTO_INCREMENT,
		userID int(6) NOT NULL,
		golfCourseID int(6) NOT NULL,
        teeDateTime datetime NOT NULL,
		bookingDateTime datetime NOT NULL,
        noOfGolfers int(6) NOT NULL,
        reminderRequired boolean NOT NULL,
		status int(6) NOT NULL,
        PRIMARY KEY (confirmationNumber)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS capacity (
        capacityID int(6) NOT NULL AUTO_INCREMENT,
		golfCourseID int(6) NOT NULL,
		teetime time NOT NULL,
        maxcount int(6) NOT NULL,
        PRIMARY KEY (capacityID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert into USERS values(1, 'dhoni', '78d7a82604de80d2b191e92a96d23a2803c0a0e910a32a6744e3ecd41e4da4cf', 1, 'true', 'Mahinder Singh Dhoni', 'dhoni@gmail.com', '+918978993113', 1);
insert into USERS values(2, 'sachin', '78d7a82604de80d2b191e92a96d23a2803c0a0e910a32a6744e3ecd41e4da4cf', 1, 'true', 'Mahinder Singh Dhoni', 'dhoni@gmail.com', '+918978993113', 1);
insert into USERS values(3, 'dravid', '78d7a82604de80d2b191e92a96d23a2803c0a0e910a32a6744e3ecd41e4da4cf', 1, 'true', 'Mahinder Singh Dhoni', 'dhoni@gmail.com', '+918978993113', 1);
insert into AUTHORITIES values(1, 'ROLE_SaasOwner');
insert into AUTHORITIES values(2, 'ROLE_GolfClubOwner');
insert into AUTHORITIES values(3, 'ROLE_GolfClubMember');
insert into GolfCourse values (1, "GolfCourse1", "", "\GolfCourse1", "Home", false, "", "Hey this is a cool golf club! Wanna join it?", "Facilities", false, "", "We have so many facilities", "bootstrap.css", false, "Call me at +91-8978993113", "http://googlemaps.com");
insert into reservationDetails values(10225, 3, 1, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 5, true, 1);
insert into reservationDetails values(10226, 3, 1, NOW(), NOW(), 5, true, 1);
insert into capacity values(1, 1, "23:23:23", 15);


ALTER TABLE reservationDetails 
ADD CONSTRAINT FOREIGN KEY (userID) REFERENCES USERS(USER_ID) ON DELETE
CASCADE ON UPDATE CASCADE;

ALTER TABLE reservationDetails 
ADD CONSTRAINT FOREIGN KEY (golfCourseID) REFERENCES GolfCourse(golfCourseID) ON DELETE
CASCADE ON UPDATE CASCADE;

ALTER TABLE capacity 
ADD CONSTRAINT FOREIGN KEY (capacityID) REFERENCES GolfCourse(golfCourseID) ON DELETE
CASCADE ON UPDATE CASCADE;

ALTER TABLE USERS
ADD CONSTRAINT FOREIGN KEY (AUTHORITY_ID) REFERENCES AUTHORITIES(AUTHORITY_ID) ON DELETE
CASCADE ON UPDATE CASCADE;

ALTER TABLE USERS
ADD CONSTRAINT FOREIGN KEY (golfCourseID) REFERENCES GolfCourse(golfCourseID) ON DELETE
CASCADE ON UPDATE CASCADE;

ALTER TABLE SessionData
ADD CONSTRAINT FOREIGN KEY (userID) REFERENCES USERS(USER_ID) ON DELETE
CASCADE ON UPDATE CASCADE;