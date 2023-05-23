/*
 Navicat Premium Data Transfer

 Source Server         : work4
 Source Server Type    : MySQL
 Source Server Version : 80033 (8.0.33)
 Source Host           : localhost:3306
 Source Schema         : work4

 Target Server Type    : MySQL
 Target Server Version : 80033 (8.0.33)
 File Encoding         : 65001

 Date: 23/05/2023 16:58:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cqupt_student
-- ----------------------------
DROP TABLE IF EXISTS `cqupt_student`;
CREATE TABLE `cqupt_student` (
  `studentid` varchar(10) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `Fee` decimal(10,2) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `memo` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `CourseAa` (
  `Aa1` varchar(20) DEFAULT NULL,
  `Aa2` int DEFAULT NULL,
  `Aa3` decimal(10,0) DEFAULT NULL
) 

CREATE TABLE `ChooseBb` (
  `Bb1` varchar(30) DEFAULT NULL,
  `Bb2` INTEGER DEFAULT NULL,
  `Bb3` decimal(6,0) DEFAULT NULL,
)

ALTER TABLE ChooseBb
ADD Bb4 VARCHAR(20) NOT NULL DEFAULT '系统测试值';
ALTER TABLE ChooseBb
ADD Bb5 VARCHAR(10),
ADD CONSTRAINT PK_ChooseBb PRIMARY KEY (Bb5);

CREATE VIEW View_Choosebb AS
SELECT Bb1 AS View_bb1, Bb4 AS View_bb2, Bb5 AS View_bb3
FROM ChooseBb;

DROP VIEW View_Choosebb;

CREATE INDEX Index_bb2 ON ChooseBb(Bb2 ASC);
CREATE INDEX Index_bb4 ON ChooseBb(Bb4 DESC);

DROP INDEX Index_bb2 ON ChooseBb;

CREATE TABLE `test`  (
  `Name` varchar(20) NULL,
  `Age` integer NULL,
  `Score` numeric(10, 2) NULL,
  `Address` varchar(60) NULL
);

INSERT INTO `work4`.`test` (`Name`, `Age`, `Score`, `Address`) VALUES ('赵一', 20, 580.0, '重邮宿舍12-3-5');

INSERT INTO `work4`.`test` (`Name`, `Age`, `Score`, `Address`) VALUES ('钱二', 19, 540.00, '南福苑5-2-9');
INSERT INTO `work4`.`test` (`Name`, `Age`, `Score`, `Address`) VALUES ('孙三', 21, 555.50, '学生新区21-5-15');
INSERT INTO `work4`.`test` (`Name`, `Age`, `Score`, `Address`) VALUES ('李四', 22, 505.00, '重邮宿舍8-6-22');
INSERT INTO `work4`.`test` (`Name`, `Age`, `Score`, `Address`) VALUES ('周五', 20, 495.50, '学生新区23-4-8');
INSERT INTO `work4`.`test` (`Name`, `Age`, `Score`, `Address`) VALUES ('吴六', 19, 435.00, '南福苑2-5-12');

CREATE TABLE `test_temp`  (
  `Name` varchar(20) NULL,
  `Age` integer NULL,
  `Score` numeric(10, 2) NULL,
  `Address` varchar(60) NULL
);

INSERT INTO `work4`.`test_temp` (`Name`, `Age`, `Score`, `Address`) VALUES ('郑七', 21, 490.50, '重邮宿舍11-2-1');
INSERT INTO `work4`.`test_temp` (`Name`, `Age`, `Score`, `Address`) VALUES ('张八', 20, 560.00, '南福苑3-3-3');
INSERT INTO `work4`.`test_temp` (`Name`, `Age`, `Score`, `Address`) VALUES ('王九', 10, 515.00, '学生新区19-7-1');


INSERT INTO test (`Name`, `Age`, `Score`, `Address`)
SELECT `Name`, `Age`, `Score`, `Address`
FROM test_temp;

UPDATE test SET Score=Score+5 WHERE Age<=20;
UPDATE test SET age=age-1 WHERE address like '南福苑%';

DELETE FROM test WHERE age>=21 AND score>=500;
DELETE FROM test WHERE score<550 AND address like '重邮宿舍%';

CREATE TABLE `student`  (
  `SNO` varchar(20) NULL,
  `Name` varchar(10) NULL,
  `Age` integer NULL,
  `College` varchar(30) NULL
);

CREATE TABLE `Course`  (
  `CourseID` varchar(15) NULL,
  `CourseName` varchar(30) NULL,
  `CourseBeforeID` varchar(15) NULL
);

CREATE TABLE `Choose`  (
  `SNO` varchar(15) NULL,
  `CourseID` varchar(30) NULL,
  `Score` decimal(5, 2) NULL
);

INSERT INTO `work4`.`student` (`SNO`, `Name`, `Age`, `College`) VALUES ('S00001', '张三', 20, '计算机学院');
INSERT INTO `work4`.`student` (`SNO`, `Name`, `Age`, `College`) VALUES ('S00002', '李四', 19, '通信学院');
INSERT INTO `work4`.`student` (`SNO`, `Name`, `Age`, `College`) VALUES ('S00003', '王五', 19, '计算机学院');

INSERT INTO `work4`.`Course` (`CourseID`, `CourseName`) VALUES ('C1', '计算机导论');
INSERT INTO `work4`.`Course` (`CourseID`, `CourseName`, `CourseBeforeID`) VALUES ('C2', 'C语言', 'C1');
INSERT INTO `work4`.`Course` (`CourseID`, `CourseName`, `CourseBeforeID`) VALUES ('C3', '数据结构', 'C2');

INSERT INTO `work4`.`Choose` (`SNO`, `CourseID`, `Score`) VALUES ('S00001', 'C1', 95);
INSERT INTO `work4`.`Choose` (`SNO`, `CourseID`, `Score`) VALUES ('S00001', 'C2', 80);
INSERT INTO `work4`.`Choose` (`SNO`, `CourseID`, `Score`) VALUES ('S00001', 'C3', 84);
INSERT INTO `work4`.`Choose` (`SNO`, `CourseID`, `Score`) VALUES ('S00002', 'C1', 80);
INSERT INTO `work4`.`Choose` (`SNO`, `CourseID`, `Score`) VALUES ('S00002', 'C2', 85);
INSERT INTO `work4`.`Choose` (`SNO`, `CourseID`, `Score`) VALUES ('S00003', 'C1', 78);
INSERT INTO `work4`.`Choose` (`SNO`, `CourseID`, `Score`) VALUES ('S00003', 'C3', 70);

SELECT name,SNO FROM student WHERE College ='计算机学院';

SELECT * FROM student WHERE age BETWEEN 20 and 23; 

SELECT COUNT(*) FROM student;

SELECT max(Score) FROM Choose;
SELECT min(Score) FROM Choose;
SELECT sum(Score) FROM Choose;
SELECT avg(Score) FROM Choose;

SELECT CourseID,CourseName FROM Course WHERE CourseBeforeID IS NULL;


SELECT student.SNO,Name,CourseName,Score FROM student 
JOIN Choose on student.SNO=Choose.SNO
JOIN Course on Course.CourseID=Choose.CourseID;


SELECT *
FROM student AS s1
WHERE EXISTS (
    SELECT *
    FROM student AS s2
    WHERE s2.name = '张三' AND s2.college = s1.college AND s2.SNO != s1.SNO
);

SELECT SNO,Score
FROM Choose WHERE CourseID='C1'
AND Score<(SELECT Score FROM Choose WHERE SNO 
IN (SELECT student.SNO FROM student WHERE name='张三') AND CourseID='C1'
);

SELECT SNO FROM Choose WHERE CourseID='C1' UNION ALL
SELECT SNO FROM Choose WHERE CourseID='C3';


SELECT DISTINCT SNO FROM (SELECT SNO FROM Choose WHERE CourseID='C1' UNION ALL
SELECT SNO FROM Choose WHERE CourseID='C3') AS sno;

