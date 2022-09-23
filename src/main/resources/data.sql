DROP TABLE IF EXISTS FLIGHT;

CREATE TABLE FLIGHT(
  ID INT AUTO_INCREMENT  PRIMARY KEY,
  FLIGHT_NUMBER VARCHAR(250) NOT NULL,
  ORIGIN_AIRPORT_CODE VARCHAR(250) NOT NULL,
  DESTINATION_AIRPORT_CODE VARCHAR(250) NOT NULL,
  DURATION BIGINT NOT NULL
);

INSERT INTO FLIGHT (ID,FLIGHT_NUMBER, ORIGIN_AIRPORT_CODE, DESTINATION_AIRPORT_CODE, DURATION) VALUES
  (1,'AAA111', 'CCU', 'MUM', 3),
  (2,'III222', 'DEL', 'MUM', 2),
  (3,'ABC123', 'CCU', 'AMS', 20),
  (4,'ABC133', 'BAN', 'AMS', 10),
  (5,'ABC13', 'BAN', 'AMS', 13),
  (6,'ABC143', 'BAN', 'AMS', 11),
  (7,'ABC33', 'BAN', 'AMS', 14),
  (8,'ABC132', 'BAN', 'AMS', 16),
  (9,'ABC136', 'BAN', 'AMS', 20);