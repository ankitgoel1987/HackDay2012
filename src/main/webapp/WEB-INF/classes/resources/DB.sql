--TRUNCATE TABLE USERS;
--TRUNCATE TABLE AUTHORITIES;
--TRUNCATE TABLE userDetails;
--TRUNCATE TABLE reservationDetails;
--TRUNCATE TABLE capacity;

--drop table if exists USERS;
--drop table if exists AUTHORITIES;
--drop table if exists userDetails;
--drop table if exists reservationDetails;
--drop table if exists capacity;

CREATE TABLE IF NOT EXISTS USERS (
        USER_ID int(6) NOT NULL,
		UserName varchar(20) NOT NULL,
        Password varchar(100) NOT NULL,
        AUTHORITY_ID int(6) NOT NULL,
        ENABLED varchar(20) NOT NULL,
        PRIMARY KEY (USER_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
CREATE TABLE IF NOT EXISTS AUTHORITIES (
        AUTHORITY_ID int(6) NOT NULL AUTO_INCREMENT,
        AUTHORITY varchar(20) NOT NULL,
        PRIMARY KEY (AUTHORITY_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS reservationDetails (
        confirmationNumber int(6) NOT NULL AUTO_INCREMENT,
        teeTime datetime NOT NULL,
        noOfGolfers int(6) NOT NULL,
        reminderRequired boolean NOT NULL,
        userID int(6) NOT NULL,
        PRIMARY KEY (confirmationNumber)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS userDetails (
        userID int(6) NOT NULL,
		name varchar(50) NOT NULL,
        email varchar(50) NOT NULL,
        phoneNumber int(20) NOT NULL,
        PRIMARY KEY (userID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS capacity (
        capacityID int(6) NOT NULL,
		teetime datetime NOT NULL,
        maxcount int(6) NOT NULL,
        PRIMARY KEY (capacityID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--insert into USERS values(2, 'dhoni', '78d7a82604de80d2b191e92a96d23a2803c0a0e910a32a6744e3ecd41e4da4cf', 1, 'true');
--insert into AUTHORITIES values(1, 'ROLE_ADMIN');
--insert into AUTHORITIES values(2, 'ROLE_MEMBER');

 ALTER TABLE reservationDetails 
 ADD FOREIGN KEY (userID) REFERENCES USERS(USER_ID) ON DELETE
 CASCADE ON UPDATE CASCADE;

ALTER TABLE USERS
ADD FOREIGN KEY (AUTHORITY_ID) REFERENCES AUTHORITIES(AUTHORITY_ID) ON DELETE
CASCADE ON UPDATE CASCADE;
