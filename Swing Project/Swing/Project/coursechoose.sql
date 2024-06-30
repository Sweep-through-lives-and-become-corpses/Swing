/*
Navicat MySQL Data Transfer

Source Server         : 本地数据库
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : coursechoose

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-03-07 10:17:30
*/
DROP DATABASE IF EXISTS coursechoose;
CREATE DATABASE coursechoose CHARSET utf8;
use coursechoose;
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `c_ccourse`
-- ----------------------------
DROP TABLE IF EXISTS `c_ccourse`;
CREATE TABLE `c_ccourse` (
  `stu_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `ccourse_mark` int(11) DEFAULT '0',
  `ccourse_time` datetime DEFAULT NULL,
  PRIMARY KEY (`stu_id`,`course_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `c_ccourse_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `c_course` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `c_ccourse_ibfk_2` FOREIGN KEY (`stu_id`) REFERENCES `c_student` (`stu_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_ccourse
-- ----------------------------
INSERT INTO `c_ccourse` VALUES ('10004', '1', '87', '2018-03-05 11:38:13');
INSERT INTO `c_ccourse` VALUES ('10015', '2', '61', '2018-03-05 11:04:57');
INSERT INTO `c_ccourse` VALUES ('10015', '8', '88', '2018-03-05 11:04:45');
INSERT INTO `c_ccourse` VALUES ('10015', '10', '68', '2018-03-05 11:05:05');
INSERT INTO `c_ccourse` VALUES ('10017', '1', '88', '2018-03-06 17:10:13');
INSERT INTO `c_ccourse` VALUES ('10017', '3', '0', '2018-03-06 17:10:16');
INSERT INTO `c_ccourse` VALUES ('10019', '2', '88', '2018-03-06 17:10:27');
INSERT INTO `c_ccourse` VALUES ('10019', '3', '0', '2018-03-06 17:10:24');
INSERT INTO `c_ccourse` VALUES ('10019', '5', '0', '2018-03-07 10:06:27');
INSERT INTO `c_ccourse` VALUES ('10021', '1', '98', '2018-03-06 16:17:44');
INSERT INTO `c_ccourse` VALUES ('10021', '2', '98', '2018-03-06 16:18:06');
INSERT INTO `c_ccourse` VALUES ('10021', '9', '0', '2018-03-07 10:09:42');
INSERT INTO `c_ccourse` VALUES ('10021', '10', '0', '2018-03-07 10:09:40');

-- ----------------------------
-- Table structure for `c_class`
-- ----------------------------
DROP TABLE IF EXISTS `c_class`;
CREATE TABLE `c_class` (
  `class_id` int(2) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(20) NOT NULL,
  `class_maxnum` int(2) NOT NULL,
  `grade_id` int(2) NOT NULL,
  PRIMARY KEY (`class_id`),
  KEY `grade_id` (`grade_id`),
  CONSTRAINT `grade_id` FOREIGN KEY (`grade_id`) REFERENCES `c_grade` (`grade_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_class
-- ----------------------------
INSERT INTO `c_class` VALUES ('1', '核弹技术07-1', '50', '1');
INSERT INTO `c_class` VALUES ('2', '核弹技术07-2', '50', '1');
INSERT INTO `c_class` VALUES ('3', '软件工程', '25', '2');
INSERT INTO `c_class` VALUES ('4', '信息技术', '55', '2');
INSERT INTO `c_class` VALUES ('5', '计算机技术', '50', '3');

-- ----------------------------
-- Table structure for `c_course`
-- ----------------------------
DROP TABLE IF EXISTS `c_course`;
CREATE TABLE `c_course` (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(20) NOT NULL,
  `course_credit` float NOT NULL,
  `course_info` varchar(50) NOT NULL,
  `course_begin_time` datetime NOT NULL,
  `teach_id` int(11) NOT NULL,
  PRIMARY KEY (`course_id`),
  KEY `teach_id` (`teach_id`),
  CONSTRAINT `c_course_ibfk_1` FOREIGN KEY (`teach_id`) REFERENCES `c_teacher` (`teach_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_course
-- ----------------------------
INSERT INTO `c_course` VALUES ('1', '计算机技术', '4', '学习计算机', '2011-05-28 12:38:58', '1');
INSERT INTO `c_course` VALUES ('2', '核弹技术', '3', '学习核弹技术', '2011-05-28 12:39:33', '1');
INSERT INTO `c_course` VALUES ('3', '石油化工', '5', '学习石油化工', '2011-05-28 12:40:09', '2');
INSERT INTO `c_course` VALUES ('4', '高等数学', '8', '学习高等数学', '2011-05-28 12:40:30', '3');
INSERT INTO `c_course` VALUES ('5', '数据结构与算法', '5', '很好的课程', '2011-06-08 00:00:00', '2');
INSERT INTO `c_course` VALUES ('8', '高分子', '5', '对！就是是高分子，而不是高分子材料！', '2008-08-08 00:00:00', '1');
INSERT INTO `c_course` VALUES ('9', '航空航天', '6', '世界一流的航空技术', '2009-09-06 00:00:00', '3');
INSERT INTO `c_course` VALUES ('10', '潜艇技术', '3', '很强的的技术，专门对付美国', '2011-06-02 00:00:00', '2');
INSERT INTO `c_course` VALUES ('11', '软件工程导论', '3', '很强的的技术，专门对付美国', '2018-03-05 00:00:00', '3');
INSERT INTO `c_course` VALUES ('12', '人工智能', '4', '学习人工智能', '2018-03-07 00:00:00', '4');
INSERT INTO `c_course` VALUES ('13', '计算机网络', '3', '学习计算机网络', '2018-03-07 00:00:00', '6');
INSERT INTO `c_course` VALUES ('14', '离散数学', '4', '学习离散数学', '2018-03-07 00:00:00', '3');

-- ----------------------------
-- Table structure for `c_grade`
-- ----------------------------
DROP TABLE IF EXISTS `c_grade`;
CREATE TABLE `c_grade` (
  `grade_id` int(2) NOT NULL AUTO_INCREMENT,
  `grade_name` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`grade_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_grade
-- ----------------------------
INSERT INTO `c_grade` VALUES ('1', '一年级');
INSERT INTO `c_grade` VALUES ('2', '二年级');
INSERT INTO `c_grade` VALUES ('3', '三年级');
INSERT INTO `c_grade` VALUES ('4', '四年级');
INSERT INTO `c_grade` VALUES ('5', '五年级');
INSERT INTO `c_grade` VALUES ('6', '六年级');
INSERT INTO `c_grade` VALUES ('7', '七年级');

-- ----------------------------
-- Table structure for `c_log`
-- ----------------------------
DROP TABLE IF EXISTS `c_log`;
CREATE TABLE `c_log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `log_operate` varchar(50) DEFAULT NULL,
  `log_time` datetime DEFAULT NULL,
  `login_user` varchar(12) NOT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_log
-- ----------------------------
INSERT INTO `c_log` VALUES ('1', '[admin]管理员登陆系统', '2018-03-05 10:48:01', 'admin');
INSERT INTO `c_log` VALUES ('2', '[admin]管理员登陆系统', '2018-03-05 10:50:22', 'admin');
INSERT INTO `c_log` VALUES ('3', '[admin]管理员登陆系统', '2018-03-05 10:53:41', 'admin');
INSERT INTO `c_log` VALUES ('4', '[admin]管理员登陆系统', '2018-03-05 10:56:28', 'admin');
INSERT INTO `c_log` VALUES ('5', '[admin]管理员登陆系统', '2018-03-05 11:10:31', 'admin');
INSERT INTO `c_log` VALUES ('6', '[10015]号学生登陆系统', '2018-03-05 11:11:56', '10015');
INSERT INTO `c_log` VALUES ('7', '[1]号教师用户登陆系统', '2018-03-05 11:12:52', '1');
INSERT INTO `c_log` VALUES ('8', '[admin]管理员登陆系统', '2018-03-05 11:30:43', 'admin');
INSERT INTO `c_log` VALUES ('9', '[admin]管理员登陆系统', '2018-03-05 11:34:20', 'admin');
INSERT INTO `c_log` VALUES ('10', '[admin]管理员登陆系统', '2018-03-05 15:56:50', 'admin');
INSERT INTO `c_log` VALUES ('11', '[1]号教师用户登陆系统', '2018-03-05 16:04:24', '1');
INSERT INTO `c_log` VALUES ('12', '[1]号教师用户登陆系统', '2018-03-05 16:04:52', '1');
INSERT INTO `c_log` VALUES ('13', '[1]号教师用户登陆系统', '2018-03-05 16:08:38', '1');
INSERT INTO `c_log` VALUES ('14', '[10015]号学生登陆系统', '2018-03-05 16:10:18', '10015');
INSERT INTO `c_log` VALUES ('15', '[admin]管理员登陆系统', '2018-03-05 16:13:47', 'admin');
INSERT INTO `c_log` VALUES ('16', '[admin]管理员登陆系统', '2018-03-06 10:05:34', 'admin');
INSERT INTO `c_log` VALUES ('17', '[admin]管理员登陆系统', '2018-03-06 10:08:01', 'admin');
INSERT INTO `c_log` VALUES ('18', '[admin]管理员登陆系统', '2018-03-06 14:11:53', 'admin');
INSERT INTO `c_log` VALUES ('19', '[10016]号学生登陆系统', '2018-03-06 15:07:10', '10016');
INSERT INTO `c_log` VALUES ('20', '[10021]号学生登陆系统', '2018-03-06 15:19:25', '10021');
INSERT INTO `c_log` VALUES ('21', '[10021]号学生登陆系统', '2018-03-06 16:00:17', '10021');
INSERT INTO `c_log` VALUES ('22', '[10021]号学生登陆系统', '2018-03-06 16:01:35', '10021');
INSERT INTO `c_log` VALUES ('23', '[10021]号学生登陆系统', '2018-03-06 16:12:52', '10021');
INSERT INTO `c_log` VALUES ('24', '[10021]号学生登陆系统', '2018-03-06 16:15:27', '10021');
INSERT INTO `c_log` VALUES ('25', '[10021]号学生登陆系统', '2018-03-06 16:17:27', '10021');
INSERT INTO `c_log` VALUES ('26', '[10021]号学生登陆系统', '2018-03-06 16:19:51', '10021');
INSERT INTO `c_log` VALUES ('27', '[10021]号学生登陆系统', '2018-03-06 16:40:26', '10021');
INSERT INTO `c_log` VALUES ('28', '[10021]号学生登陆系统', '2018-03-06 16:42:44', '10021');
INSERT INTO `c_log` VALUES ('29', '[10021]号学生登陆系统', '2018-03-06 16:45:49', '10021');
INSERT INTO `c_log` VALUES ('30', '[admin]管理员登陆系统', '2018-03-06 17:00:52', 'admin');
INSERT INTO `c_log` VALUES ('31', '[admin]管理员登陆系统', '2018-03-06 17:01:05', 'admin');
INSERT INTO `c_log` VALUES ('32', '[admin]管理员登陆系统', '2018-03-07 10:01:59', 'admin');
INSERT INTO `c_log` VALUES ('33', '[10021]号学生登陆系统', '2018-03-07 10:09:21', '10021');

-- ----------------------------
-- Table structure for `c_student`
-- ----------------------------
DROP TABLE IF EXISTS `c_student`;
CREATE TABLE `c_student` (
  `stu_id` int(8) NOT NULL AUTO_INCREMENT,
  `stu_name` varchar(8) COLLATE utf8_unicode_ci NOT NULL,
  `stu_sex` char(2) COLLATE utf8_unicode_ci NOT NULL,
  `class_id` int(2) NOT NULL,
  `stu_password` varchar(20) COLLATE utf8_unicode_ci DEFAULT '1',
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10023 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of c_student
-- ----------------------------
INSERT INTO `c_student` VALUES ('10004', '陈罗志', '男', '1', 'chen');
INSERT INTO `c_student` VALUES ('10015', '陈皮', '男', '1', '1');
INSERT INTO `c_student` VALUES ('10016', '张三', '女', '2', '1');
INSERT INTO `c_student` VALUES ('10017', '李四', '女', '2', '1');
INSERT INTO `c_student` VALUES ('10019', '昭君', '男', '3', '1');
INSERT INTO `c_student` VALUES ('10020', '王军', '男', '4', '1');
INSERT INTO `c_student` VALUES ('10021', '马云', '男', '3', '1');
INSERT INTO `c_student` VALUES ('10022', '赵雅琴', '男', '5', '1');

-- ----------------------------
-- Table structure for `c_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `c_teacher`;
CREATE TABLE `c_teacher` (
  `teach_id` int(11) NOT NULL AUTO_INCREMENT,
  `teach_name` varchar(8) NOT NULL,
  `teach_sex` varchar(2) NOT NULL,
  `teach_education` varchar(8) NOT NULL,
  `teach_password` varchar(20) NOT NULL DEFAULT '1',
  PRIMARY KEY (`teach_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_teacher
-- ----------------------------
INSERT INTO `c_teacher` VALUES ('1', '李老师', '女', '博士', '1');
INSERT INTO `c_teacher` VALUES ('2', '陈老师', '男', '烈士', '');
INSERT INTO `c_teacher` VALUES ('3', '吴老师', '男', '硕士', '');
INSERT INTO `c_teacher` VALUES ('4', '张老师', '男', '学士', '');
INSERT INTO `c_teacher` VALUES ('5', '钟老师', '男', '烈士', '');
INSERT INTO `c_teacher` VALUES ('6', '薛仁贵', '女', '学士', '');

-- ----------------------------
-- Table structure for `c_user`
-- ----------------------------
DROP TABLE IF EXISTS `c_user`;
CREATE TABLE `c_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(12) NOT NULL,
  `user_password` varchar(20) NOT NULL,
  `user_login_ip` varchar(20) DEFAULT NULL,
  `user_login_time` datetime DEFAULT NULL,
  `user_privilege` varchar(8) NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_user
-- ----------------------------
INSERT INTO `c_user` VALUES ('2', 'admin', '123', null, null, '管理员');
