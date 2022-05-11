CREATE TABLE Teams (Name varchar(255) NOT NULL, MeetingTime varchar(255), PRIMARY KEY (Name));
CREATE TABLE Sponsors (Name varchar(255) NOT NULL, PhoneNumber varchar(12), Email varchar(255), ContactPerson varchar(255), Other varchar(255), TeamsName varchar(255) NOT NULL, PRIMARY KEY (Name), FOREIGN KEY(TeamsName) REFERENCES Teams(Name));
CREATE TABLE Trainers (id int(10) NOT NULL AUTO_INCREMENT, FirstName varchar(255), LastName varchar(255), TeamsName varchar(255) NOT NULL, PRIMARY KEY (id), FOREIGN KEY(TeamsName) REFERENCES Teams(Name));
CREATE TABLE Participants (id int(10) NOT NULL AUTO_INCREMENT, FirstName varchar(255), LastName varchar(255), Age int(3), Gender char(1), TeamsName varchar(255) NOT NULL, PRIMARY KEY (id), FOREIGN KEY(TeamsName) REFERENCES Teams(Name));
CREATE TABLE Interns (id int(10) NOT NULL AUTO_INCREMENT, FirstName varchar(255), LastName varchar(255), Type varchar(255), TeamsName varchar(255) NOT NULL, PRIMARY KEY (id), FOREIGN KEY(TeamsName) REFERENCES Teams(Name));
CREATE TABLE WeeklyResults (Participantsid int(10) NOT NULL, Weight int(10), WeekNumber int(2) NOT NULL, FOREIGN KEY(Participantsid) REFERENCES Participants(id));
CREATE TABLE StartResults (Participantsid int(10) NOT NULL, VisceralFat float, BMI float, BodyFatPercent float, LeanMusclePercent float, FOREIGN KEY(Participantsid) REFERENCES Participants(id));
CREATE TABLE EndResults (Participantsid int(10) NOT NULL, VisceralFat float, BMI float, BodyFatPercent float, LeanMusclePercent float, FOREIGN KEY(Participantsid) REFERENCES Participants(id));

CREATE VIEW WeeklyTop10Male AS
SELECT 
FROM;
CREATE VIEW WeeklyTop10Female AS

// get all female's weight change
SELECT FirstName, LastName, weightlost
FROM Participants
INNER JOIN WeightChange on Participants.id = WeightChange.Participantsid
WHERE Participants.Gender = 'F'
ORDER BY weightlost DESC
LIMIT 10;
CREATE VIEW WeightChange AS

// get first week
SELECT Participantsid, Weight
FROM WeeklyResults AS w1
WHERE WeekNumber = 1

// get latest week for each participant
SELECT wr.id, MAX(wr.WeekNumber)
FROM Participants p
INNER JOIN WeeklyResults wr on p.id = wr.Participantsid
GROUP BY wr.Participantsid

// get latest week's weight
SELECT Participantid, Weight as latest
FROM WeeklyResults
INNER JOIN wMax on latest.Participantid = wMax.Participantid

// get week1 weight and latest weight
SELECT lastest.Participantid, (w1.Weight - latest.Weight) as weightlost
FROM latest
INNER JOIN w1 on latest.Participantid = w1.Participantid
;
CREATE VIEW WeeklyTeamChange AS SELECT FROM;
CREATE VIEW TotalTeamChange AS SELECT FROM;
CREATE VIEW ParticipantStats AS SELECT FROM;
ALTER TABLE WeeklyResults ADD INDEX FKWeeklyResu744810 (Participantsid), ADD CONSTRAINT FKWeeklyResu744810 FOREIGN KEY (Participantsid) REFERENCES Participants (id);
ALTER TABLE EndResults ADD INDEX FKEndResults849035 (Participantsid), ADD CONSTRAINT FKEndResults849035 FOREIGN KEY (Participantsid) REFERENCES Participants (id);
ALTER TABLE StartResults ADD INDEX FKStartResul249322 (Participantsid), ADD CONSTRAINT FKStartResul249322 FOREIGN KEY (Participantsid) REFERENCES Participants (id);
ALTER TABLE Interns ADD INDEX FKInterns431083 (TeamsName), ADD CONSTRAINT FKInterns431083 FOREIGN KEY (TeamsName) REFERENCES Teams (Name);
ALTER TABLE Trainers ADD INDEX FKTrainers527809 (TeamsName), ADD CONSTRAINT FKTrainers527809 FOREIGN KEY (TeamsName) REFERENCES Teams (Name);
ALTER TABLE Participants ADD INDEX FKParticipan287603 (TeamsName), ADD CONSTRAINT FKParticipan287603 FOREIGN KEY (TeamsName) REFERENCES Teams (Name);
ALTER TABLE Sponsors ADD INDEX FKSponsors207256 (TeamsName), ADD CONSTRAINT FKSponsors207256 FOREIGN KEY (TeamsName) REFERENCES Teams (Name);
