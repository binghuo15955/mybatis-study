/*
MySQL Data Transfer
Source Host: localhost
Source Database: java1803
Target Host: localhost
Target Database: java1803
Date: 2018-11-14 19:13:56
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `stuID` char(10) NOT NULL default '',
  `name` char(10) default NULL,
  `birthday` date default NULL,
  `sex` char(2) default NULL,
  PRIMARY KEY  (`stuID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
