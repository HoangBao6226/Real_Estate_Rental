create database real_estate;
use real_estate;

CREATE TABLE Role (
	roleID INT PRIMARY KEY AUTO_INCREMENT,
    roleName NVARCHAR(50) NOT NULL,
    description NVARCHAR(100) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE Account (
    accountID INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    isActive BOOLEAN DEFAULT TRUE,
    roleID INT,
    employeeID INT,
    lessorID INT,
    lesseeID INT
) ENGINE=InnoDB;

CREATE TABLE Employee (
    employeeID INT PRIMARY KEY AUTO_INCREMENT,
    lastName NVARCHAR(50) NOT NULL,
    firstName NVARCHAR(50) NOT NULL,
	email VARCHAR(100) NOT NULL unique,
    gender ENUM('Male', 'Female'),
    dateOfBirth DATE,
    address TEXT,
    phoneNumber VARCHAR(20)
) ENGINE=InnoDB;

CREATE TABLE Lessor (
    lessorID INT PRIMARY KEY AUTO_INCREMENT,
    lastName NVARCHAR(50) NOT NULL,
    firstName NVARCHAR(50) NOT NULL,
    address TEXT,
    phoneNumber VARCHAR(20),
    email VARCHAR(100) NOT NULL unique
) ENGINE=InnoDB;

CREATE TABLE Lessee (
    lesseeID INT PRIMARY KEY AUTO_INCREMENT,
    lastName NVARCHAR(50) NOT NULL,
    firstName NVARCHAR(50) NOT NULL,
    address TEXT,
    phoneNumber VARCHAR(20),
    email VARCHAR(100) NOT NULL unique
) ENGINE=InnoDB;

CREATE TABLE AccomType (
    accomTypeID INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(50),
    description TEXT
) ENGINE=InnoDB;

CREATE TABLE Advantage (
    advantageID INT AUTO_INCREMENT PRIMARY KEY,
    code NVARCHAR(50),
    description TEXT,
    accomTypeID INT
) ENGINE=InnoDB;

CREATE TABLE Accommodation (
    accommodationID INT PRIMARY KEY AUTO_INCREMENT,
    accommodationName NVARCHAR(100),
    street NVARCHAR(100),
    ward NVARCHAR(50),
    district NVARCHAR(50),
    city NVARCHAR(50),
    direction NVARCHAR(50),
    size DECIMAL(10,2),
    numberOfRooms INT,
    status ENUM('Available', 'Unavailable', 'Occupied', 'Pending_Approval') default 'Available',
	image VARCHAR(255),
	lessorID INT,
    salesID INT,
    accomTypeID INT, 
    map TEXT
) ENGINE=InnoDB;

CREATE TABLE Amenity (
    amenityID INT PRIMARY KEY AUTO_INCREMENT,
    amenityName NVARCHAR(50) NOT NULL UNIQUE,
    description TEXT
) ENGINE=InnoDB;

CREATE TABLE DetailAmenity (
	detailAmenityID INT AUTO_INCREMENT PRIMARY KEY,
    accommodationID INT,
    amenityID INT
) ENGINE=InnoDB;

CREATE TABLE RentType (
    rentTypeID INT PRIMARY KEY AUTO_INCREMENT,
    rentTypeName NVARCHAR(50) NOT NULL UNIQUE,
    description TEXT
) ENGINE=InnoDB;

CREATE TABLE DetailRentType (
	detailRentTypeID INT AUTO_INCREMENT PRIMARY KEY,
    accommodationID INT,
    rentTypeID INT,
    price INT NOT NULL,
    deposit INT NOT NULL
) ENGINE=InnoDB;

CREATE TABLE Reservation (
	reservationID INT AUTO_INCREMENT PRIMARY KEY,
    lesseeID INT,
    accommodationID INT,
    viewDate DATETIME,
    note TEXT,
    status ENUM('In_progress', 'Completed', 'Canceled')
) ENGINE=InnoDB;

CREATE TABLE Invoice (
    invoiceID INT PRIMARY KEY AUTO_INCREMENT,
    totalPrice INT,
    invoiceDate DATETIME,
    startDate DATETIME,
    endDate DATETIME,
    status ENUM('In_progress', 'Completed', 'Canceled'),
    accommodationID INT, 
    lesseeID INT,
    rentTypeID INT
) ENGINE=InnoDB;

CREATE TABLE Payment (
    paymentID INT PRIMARY KEY AUTO_INCREMENT,
    paymentAmount INT,
    fee INT,
    paymentMethod ENUM('Cash', 'Bank_transfer'),
    paymentDate DATE,
    description TEXT,
    status ENUM('Success', 'Failed', 'Pending', 'Refunded'),
    invoiceID INT
) ENGINE=InnoDB;

--------------------------------------------------------------------------------------------------

ALTER TABLE Account ADD CONSTRAINT fk_Role_Account FOREIGN KEY (roleID) REFERENCES Role(roleID);

ALTER TABLE Account ADD CONSTRAINT fk_Account_Em FOREIGN KEY (employeeID) REFERENCES Employee(employeeID);

ALTER TABLE Account ADD CONSTRAINT fk_Account_Lessor FOREIGN KEY (lessorID) REFERENCES Lessor(lessorID);

ALTER TABLE Account ADD CONSTRAINT fk_Account_Lessee FOREIGN KEY (lesseeID) REFERENCES Lessee(lesseeID);

ALTER TABLE Accommodation ADD CONSTRAINT fk_Accom_Lessor FOREIGN KEY (lessorID) REFERENCES Lessor(lessorID);

ALTER TABLE Accommodation ADD CONSTRAINT fk_Accom_Em FOREIGN KEY (salesID) REFERENCES Employee(employeeID);

ALTER TABLE Accommodation ADD CONSTRAINT fk_Accom_Type FOREIGN KEY (accomTypeID) REFERENCES AccomType(accomTypeID);

ALTER TABLE Advantage ADD CONSTRAINT fk_Advan_Type FOREIGN KEY (accomTypeID) REFERENCES AccomType(accomTypeID);

ALTER TABLE DetailAmenity ADD CONSTRAINT fk_Accom_DetailType FOREIGN KEY (accommodationID) REFERENCES Accommodation(accommodationID);

ALTER TABLE DetailAmenity ADD CONSTRAINT fk_Amenity_DetailType FOREIGN KEY (amenityID) REFERENCES Amenity(amenityID);

ALTER TABLE DetailRentType ADD CONSTRAINT fk_Accom_DetailRentType FOREIGN KEY (accommodationID) REFERENCES Accommodation(accommodationID);

ALTER TABLE DetailRentType ADD CONSTRAINT fk_RentType_DetailRentType FOREIGN KEY (rentTypeID) REFERENCES RentType(rentTypeID);

ALTER TABLE Payment ADD CONSTRAINT fk_Payment_Invoice FOREIGN KEY (invoiceID) REFERENCES Invoice(invoiceID);

ALTER TABLE Invoice ADD CONSTRAINT fk_Invoice_Accom FOREIGN KEY (accommodationID) REFERENCES Accommodation(accommodationID);

ALTER TABLE Invoice ADD CONSTRAINT fk_Invoice_RentType FOREIGN KEY (rentTypeID) REFERENCES RentType(rentTypeID);

ALTER TABLE Invoice ADD CONSTRAINT fk_Invoice_Lessee FOREIGN KEY (lesseeID) REFERENCES Lessee(lesseeID);

ALTER TABLE Reservation ADD CONSTRAINT fk_Reservation_Accom FOREIGN KEY (accommodationID) REFERENCES Accommodation(accommodationID);

ALTER TABLE Reservation ADD CONSTRAINT fk_Reservation_Lessee FOREIGN KEY (lesseeID) REFERENCES Lessee(lesseeID);
